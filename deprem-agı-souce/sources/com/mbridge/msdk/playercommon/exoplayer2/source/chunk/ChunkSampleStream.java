package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleQueue;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream;
import com.mbridge.msdk.playercommon.exoplayer2.source.SequenceableLoader;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Loader;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    private static final String TAG = "ChunkSampleStream";
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> callback;
    private final T chunkSource;
    long decodeOnlyUntilPositionUs;
    private final SampleQueue[] embeddedSampleQueues;
    /* access modifiers changed from: private */
    public final Format[] embeddedTrackFormats;
    /* access modifiers changed from: private */
    public final int[] embeddedTrackTypes;
    /* access modifiers changed from: private */
    public final boolean[] embeddedTracksSelected;
    /* access modifiers changed from: private */
    public final MediaSourceEventListener.EventDispatcher eventDispatcher;
    /* access modifiers changed from: private */
    public long lastSeekPositionUs;
    private final Loader loader = new Loader("Loader:ChunkSampleStream");
    boolean loadingFinished;
    private final BaseMediaChunkOutput mediaChunkOutput;
    private final ArrayList<BaseMediaChunk> mediaChunks;
    private final int minLoadableRetryCount;
    private final ChunkHolder nextChunkHolder = new ChunkHolder();
    private long pendingResetPositionUs;
    private Format primaryDownstreamTrackFormat;
    private final SampleQueue primarySampleQueue;
    public final int primaryTrackType;
    private final List<BaseMediaChunk> readOnlyMediaChunks;
    @Nullable
    private ReleaseCallback<T> releaseCallback;

    public final class EmbeddedSampleStream implements SampleStream {
        private boolean formatNotificationSent;
        private final int index;
        public final ChunkSampleStream<T> parent;
        private final SampleQueue sampleQueue;

        public EmbeddedSampleStream(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue2, int i5) {
            this.parent = chunkSampleStream;
            this.sampleQueue = sampleQueue2;
            this.index = i5;
        }

        private void maybeNotifyTrackFormatChanged() {
            if (!this.formatNotificationSent) {
                ChunkSampleStream.this.eventDispatcher.downstreamFormatChanged(ChunkSampleStream.this.embeddedTrackTypes[this.index], ChunkSampleStream.this.embeddedTrackFormats[this.index], 0, (Object) null, ChunkSampleStream.this.lastSeekPositionUs);
                this.formatNotificationSent = true;
            }
        }

        public final boolean isReady() {
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            if (chunkSampleStream.loadingFinished) {
                return true;
            }
            if (chunkSampleStream.isPendingReset() || !this.sampleQueue.hasNextSample()) {
                return false;
            }
            return true;
        }

        public final void maybeThrowError() throws IOException {
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4) {
            if (ChunkSampleStream.this.isPendingReset()) {
                return -3;
            }
            SampleQueue sampleQueue2 = this.sampleQueue;
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            int read = sampleQueue2.read(formatHolder, decoderInputBuffer, z4, chunkSampleStream.loadingFinished, chunkSampleStream.decodeOnlyUntilPositionUs);
            if (read == -4) {
                maybeNotifyTrackFormatChanged();
            }
            return read;
        }

        public final void release() {
            Assertions.checkState(ChunkSampleStream.this.embeddedTracksSelected[this.index]);
            ChunkSampleStream.this.embeddedTracksSelected[this.index] = false;
        }

        public final int skipData(long j5) {
            int i5;
            if (!ChunkSampleStream.this.loadingFinished || j5 <= this.sampleQueue.getLargestQueuedTimestampUs()) {
                i5 = this.sampleQueue.advanceTo(j5, true, true);
                if (i5 == -1) {
                    i5 = 0;
                }
            } else {
                i5 = this.sampleQueue.advanceToEnd();
            }
            if (i5 > 0) {
                maybeNotifyTrackFormatChanged();
            }
            return i5;
        }
    }

    public interface ReleaseCallback<T extends ChunkSource> {
        void onSampleStreamReleased(ChunkSampleStream<T> chunkSampleStream);
    }

    public ChunkSampleStream(int i5, int[] iArr, Format[] formatArr, T t5, SequenceableLoader.Callback<ChunkSampleStream<T>> callback2, Allocator allocator, long j5, int i6, MediaSourceEventListener.EventDispatcher eventDispatcher2) {
        int i7;
        this.primaryTrackType = i5;
        this.embeddedTrackTypes = iArr;
        this.embeddedTrackFormats = formatArr;
        this.chunkSource = t5;
        this.callback = callback2;
        this.eventDispatcher = eventDispatcher2;
        this.minLoadableRetryCount = i6;
        ArrayList<BaseMediaChunk> arrayList = new ArrayList<>();
        this.mediaChunks = arrayList;
        this.readOnlyMediaChunks = DesugarCollections.unmodifiableList(arrayList);
        int i8 = 0;
        if (iArr == null) {
            i7 = 0;
        } else {
            i7 = iArr.length;
        }
        this.embeddedSampleQueues = new SampleQueue[i7];
        this.embeddedTracksSelected = new boolean[i7];
        int i9 = i7 + 1;
        int[] iArr2 = new int[i9];
        SampleQueue[] sampleQueueArr = new SampleQueue[i9];
        SampleQueue sampleQueue = new SampleQueue(allocator);
        this.primarySampleQueue = sampleQueue;
        iArr2[0] = i5;
        sampleQueueArr[0] = sampleQueue;
        while (i8 < i7) {
            SampleQueue sampleQueue2 = new SampleQueue(allocator);
            this.embeddedSampleQueues[i8] = sampleQueue2;
            int i10 = i8 + 1;
            sampleQueueArr[i10] = sampleQueue2;
            iArr2[i10] = iArr[i8];
            i8 = i10;
        }
        this.mediaChunkOutput = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.pendingResetPositionUs = j5;
        this.lastSeekPositionUs = j5;
    }

    private void discardDownstreamMediaChunks(int i5) {
        int primaryStreamIndexToMediaChunkIndex = primaryStreamIndexToMediaChunkIndex(i5, 0);
        if (primaryStreamIndexToMediaChunkIndex > 0) {
            Util.removeRange(this.mediaChunks, 0, primaryStreamIndexToMediaChunkIndex);
        }
    }

    private BaseMediaChunk discardUpstreamMediaChunksFromIndex(int i5) {
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i5);
        ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
        Util.removeRange(arrayList, i5, arrayList.size());
        int i6 = 0;
        this.primarySampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i6 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            SampleQueue sampleQueue = sampleQueueArr[i6];
            i6++;
            sampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(i6));
        }
    }

    private BaseMediaChunk getLastMediaChunk() {
        ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean haveReadFromMediaChunk(int i5) {
        int readIndex;
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i5);
        if (this.primarySampleQueue.getReadIndex() > baseMediaChunk.getFirstSampleIndex(0)) {
            return true;
        }
        int i6 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i6 >= sampleQueueArr.length) {
                return false;
            }
            readIndex = sampleQueueArr[i6].getReadIndex();
            i6++;
        } while (readIndex <= baseMediaChunk.getFirstSampleIndex(i6));
        return true;
    }

    private boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private void maybeNotifyPrimaryTrackFormatChanged(int i5, int i6) {
        int i7;
        int primaryStreamIndexToMediaChunkIndex = primaryStreamIndexToMediaChunkIndex(i5 - i6, 0);
        if (i6 == 1) {
            i7 = primaryStreamIndexToMediaChunkIndex;
        } else {
            i7 = primaryStreamIndexToMediaChunkIndex(i5 - 1, primaryStreamIndexToMediaChunkIndex);
        }
        while (primaryStreamIndexToMediaChunkIndex <= i7) {
            maybeNotifyPrimaryTrackFormatChanged(primaryStreamIndexToMediaChunkIndex);
            primaryStreamIndexToMediaChunkIndex++;
        }
    }

    private int primaryStreamIndexToMediaChunkIndex(int i5, int i6) {
        do {
            i6++;
            if (i6 >= this.mediaChunks.size()) {
                return this.mediaChunks.size() - 1;
            }
        } while (this.mediaChunks.get(i6).getFirstSampleIndex(0) <= i5);
        return i6 - 1;
    }

    public boolean continueLoading(long j5) {
        BaseMediaChunk lastMediaChunk;
        long j6;
        if (this.loadingFinished || this.loader.isLoading()) {
            return false;
        }
        boolean isPendingReset = isPendingReset();
        if (isPendingReset) {
            j6 = this.pendingResetPositionUs;
            lastMediaChunk = null;
        } else {
            lastMediaChunk = getLastMediaChunk();
            j6 = lastMediaChunk.endTimeUs;
        }
        this.chunkSource.getNextChunk(lastMediaChunk, j5, j6, this.nextChunkHolder);
        ChunkHolder chunkHolder = this.nextChunkHolder;
        boolean z4 = chunkHolder.endOfStream;
        Chunk chunk = chunkHolder.chunk;
        chunkHolder.clear();
        if (z4) {
            this.pendingResetPositionUs = C.TIME_UNSET;
            this.loadingFinished = true;
            return true;
        } else if (chunk == null) {
            return false;
        } else {
            if (isMediaChunk(chunk)) {
                BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                if (isPendingReset) {
                    long j7 = baseMediaChunk.startTimeUs;
                    long j8 = this.pendingResetPositionUs;
                    if (j7 == j8) {
                        j8 = Long.MIN_VALUE;
                    }
                    this.decodeOnlyUntilPositionUs = j8;
                    this.pendingResetPositionUs = C.TIME_UNSET;
                }
                baseMediaChunk.init(this.mediaChunkOutput);
                this.mediaChunks.add(baseMediaChunk);
            }
            this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.minLoadableRetryCount));
            return true;
        }
    }

    public void discardBuffer(long j5, boolean z4) {
        int firstIndex = this.primarySampleQueue.getFirstIndex();
        this.primarySampleQueue.discardTo(j5, z4, true);
        int firstIndex2 = this.primarySampleQueue.getFirstIndex();
        if (firstIndex2 > firstIndex) {
            long firstTimestampUs = this.primarySampleQueue.getFirstTimestampUs();
            int i5 = 0;
            while (true) {
                SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
                if (i5 < sampleQueueArr.length) {
                    sampleQueueArr[i5].discardTo(firstTimestampUs, z4, this.embeddedTracksSelected[i5]);
                    i5++;
                } else {
                    discardDownstreamMediaChunks(firstIndex2);
                    return;
                }
            }
        }
    }

    public long getAdjustedSeekPositionUs(long j5, SeekParameters seekParameters) {
        return this.chunkSource.getAdjustedSeekPositionUs(j5, seekParameters);
    }

    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j5 = this.lastSeekPositionUs;
        BaseMediaChunk lastMediaChunk = getLastMediaChunk();
        if (!lastMediaChunk.isLoadCompleted()) {
            if (this.mediaChunks.size() > 1) {
                ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
                lastMediaChunk = arrayList.get(arrayList.size() - 2);
            } else {
                lastMediaChunk = null;
            }
        }
        if (lastMediaChunk != null) {
            j5 = Math.max(j5, lastMediaChunk.endTimeUs);
        }
        return Math.max(j5, this.primarySampleQueue.getLargestQueuedTimestampUs());
    }

    public T getChunkSource() {
        return this.chunkSource;
    }

    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return getLastMediaChunk().endTimeUs;
    }

    /* access modifiers changed from: package-private */
    public boolean isPendingReset() {
        if (this.pendingResetPositionUs != C.TIME_UNSET) {
            return true;
        }
        return false;
    }

    public boolean isReady() {
        if (this.loadingFinished) {
            return true;
        }
        if (isPendingReset() || !this.primarySampleQueue.hasNextSample()) {
            return false;
        }
        return true;
    }

    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        if (!this.loader.isLoading()) {
            this.chunkSource.maybeThrowError();
        }
    }

    public void onLoaderReleased() {
        this.primarySampleQueue.reset();
        for (SampleQueue reset : this.embeddedSampleQueues) {
            reset.reset();
        }
        ReleaseCallback<T> releaseCallback2 = this.releaseCallback;
        if (releaseCallback2 != null) {
            releaseCallback2.onSampleStreamReleased(this);
        }
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4) {
        if (isPendingReset()) {
            return -3;
        }
        int read = this.primarySampleQueue.read(formatHolder, decoderInputBuffer, z4, this.loadingFinished, this.decodeOnlyUntilPositionUs);
        if (read == -4) {
            maybeNotifyPrimaryTrackFormatChanged(this.primarySampleQueue.getReadIndex(), 1);
        }
        return read;
    }

    public void reevaluateBuffer(long j5) {
        int size;
        int preferredQueueSize;
        if (!this.loader.isLoading() && !isPendingReset() && (size = this.mediaChunks.size()) > (preferredQueueSize = this.chunkSource.getPreferredQueueSize(j5, this.readOnlyMediaChunks))) {
            while (true) {
                if (preferredQueueSize >= size) {
                    preferredQueueSize = size;
                    break;
                } else if (!haveReadFromMediaChunk(preferredQueueSize)) {
                    break;
                } else {
                    preferredQueueSize++;
                }
            }
            if (preferredQueueSize != size) {
                long j6 = getLastMediaChunk().endTimeUs;
                BaseMediaChunk discardUpstreamMediaChunksFromIndex = discardUpstreamMediaChunksFromIndex(preferredQueueSize);
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
                this.loadingFinished = false;
                this.eventDispatcher.upstreamDiscarded(this.primaryTrackType, discardUpstreamMediaChunksFromIndex.startTimeUs, j6);
            }
        }
    }

    public void release() {
        release((ReleaseCallback) null);
    }

    public void seekToUs(long j5) {
        boolean z4;
        BaseMediaChunk baseMediaChunk;
        boolean z5;
        this.lastSeekPositionUs = j5;
        this.primarySampleQueue.rewind();
        if (isPendingReset()) {
            z4 = false;
        } else {
            int i5 = 0;
            while (true) {
                if (i5 >= this.mediaChunks.size()) {
                    break;
                }
                baseMediaChunk = this.mediaChunks.get(i5);
                int i6 = (baseMediaChunk.startTimeUs > j5 ? 1 : (baseMediaChunk.startTimeUs == j5 ? 0 : -1));
                if (i6 == 0 && baseMediaChunk.seekTimeUs == C.TIME_UNSET) {
                    break;
                } else if (i6 > 0) {
                    break;
                } else {
                    i5++;
                }
            }
            baseMediaChunk = null;
            if (baseMediaChunk != null) {
                z4 = this.primarySampleQueue.setReadPosition(baseMediaChunk.getFirstSampleIndex(0));
                this.decodeOnlyUntilPositionUs = Long.MIN_VALUE;
            } else {
                SampleQueue sampleQueue = this.primarySampleQueue;
                if (j5 < getNextLoadPositionUs()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (sampleQueue.advanceTo(j5, true, z5) != -1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.decodeOnlyUntilPositionUs = this.lastSeekPositionUs;
            }
        }
        if (z4) {
            for (SampleQueue sampleQueue2 : this.embeddedSampleQueues) {
                sampleQueue2.rewind();
                sampleQueue2.advanceTo(j5, true, false);
            }
            return;
        }
        this.pendingResetPositionUs = j5;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
            return;
        }
        this.primarySampleQueue.reset();
        for (SampleQueue reset : this.embeddedSampleQueues) {
            reset.reset();
        }
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long j5, int i5) {
        for (int i6 = 0; i6 < this.embeddedSampleQueues.length; i6++) {
            if (this.embeddedTrackTypes[i6] == i5) {
                Assertions.checkState(!this.embeddedTracksSelected[i6]);
                this.embeddedTracksSelected[i6] = true;
                this.embeddedSampleQueues[i6].rewind();
                this.embeddedSampleQueues[i6].advanceTo(j5, true, true);
                return new EmbeddedSampleStream(this, this.embeddedSampleQueues[i6], i6);
            }
        }
        throw new IllegalStateException();
    }

    public int skipData(long j5) {
        int i5 = 0;
        if (isPendingReset()) {
            return 0;
        }
        if (!this.loadingFinished || j5 <= this.primarySampleQueue.getLargestQueuedTimestampUs()) {
            int advanceTo = this.primarySampleQueue.advanceTo(j5, true, true);
            if (advanceTo != -1) {
                i5 = advanceTo;
            }
        } else {
            i5 = this.primarySampleQueue.advanceToEnd();
        }
        if (i5 > 0) {
            maybeNotifyPrimaryTrackFormatChanged(this.primarySampleQueue.getReadIndex(), i5);
        }
        return i5;
    }

    public void onLoadCanceled(Chunk chunk, long j5, long j6, boolean z4) {
        Chunk chunk2 = chunk;
        MediaSourceEventListener.EventDispatcher eventDispatcher2 = this.eventDispatcher;
        MediaSourceEventListener.EventDispatcher eventDispatcher3 = eventDispatcher2;
        MediaSourceEventListener.EventDispatcher eventDispatcher4 = eventDispatcher3;
        MediaSourceEventListener.EventDispatcher eventDispatcher5 = eventDispatcher4;
        MediaSourceEventListener.EventDispatcher eventDispatcher6 = eventDispatcher5;
        MediaSourceEventListener.EventDispatcher eventDispatcher7 = eventDispatcher6;
        MediaSourceEventListener.EventDispatcher eventDispatcher8 = eventDispatcher7;
        MediaSourceEventListener.EventDispatcher eventDispatcher9 = eventDispatcher8;
        eventDispatcher9.loadCanceled(chunk2.dataSpec, chunk2.type, this.primaryTrackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs, j5, j6, chunk2.bytesLoaded());
        if (!z4) {
            this.primarySampleQueue.reset();
            for (SampleQueue reset : this.embeddedSampleQueues) {
                reset.reset();
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    public void onLoadCompleted(Chunk chunk, long j5, long j6) {
        Chunk chunk2 = chunk;
        this.chunkSource.onChunkLoadCompleted(chunk2);
        this.eventDispatcher.loadCompleted(chunk2.dataSpec, chunk2.type, this.primaryTrackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs, j5, j6, chunk2.bytesLoaded());
        this.callback.onContinueLoadingRequested(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0089 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onLoadError(com.mbridge.msdk.playercommon.exoplayer2.source.chunk.Chunk r22, long r23, long r25, java.io.IOException r27) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            long r16 = r1.bytesLoaded()
            boolean r2 = r21.isMediaChunk(r22)
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.source.chunk.BaseMediaChunk> r3 = r0.mediaChunks
            int r3 = r3.size()
            r4 = 1
            int r3 = r3 - r4
            r5 = 0
            int r5 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            r20 = 0
            if (r5 == 0) goto L_0x0028
            if (r2 == 0) goto L_0x0028
            boolean r5 = r0.haveReadFromMediaChunk(r3)
            if (r5 != 0) goto L_0x0025
            goto L_0x0028
        L_0x0025:
            r5 = r20
            goto L_0x0029
        L_0x0028:
            r5 = r4
        L_0x0029:
            T r6 = r0.chunkSource
            r7 = r27
            boolean r6 = r6.onChunkLoadError(r1, r5, r7)
            if (r6 == 0) goto L_0x005b
            if (r5 != 0) goto L_0x003d
            java.lang.String r2 = "ChunkSampleStream"
            java.lang.String r3 = "Ignoring attempt to cancel non-cancelable load."
            android.util.Log.w(r2, r3)
            goto L_0x005b
        L_0x003d:
            if (r2 == 0) goto L_0x0058
            com.mbridge.msdk.playercommon.exoplayer2.source.chunk.BaseMediaChunk r2 = r0.discardUpstreamMediaChunksFromIndex(r3)
            if (r2 != r1) goto L_0x0047
            r2 = r4
            goto L_0x0049
        L_0x0047:
            r2 = r20
        L_0x0049:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r2)
            java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.source.chunk.BaseMediaChunk> r2 = r0.mediaChunks
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0058
            long r2 = r0.lastSeekPositionUs
            r0.pendingResetPositionUs = r2
        L_0x0058:
            r19 = r4
            goto L_0x005d
        L_0x005b:
            r19 = r20
        L_0x005d:
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener$EventDispatcher r2 = r0.eventDispatcher
            r3 = r2
            com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec r2 = r1.dataSpec
            r4 = r3
            int r3 = r1.type
            r5 = r4
            int r4 = r0.primaryTrackType
            r6 = r5
            com.mbridge.msdk.playercommon.exoplayer2.Format r5 = r1.trackFormat
            r8 = r6
            int r6 = r1.trackSelectionReason
            java.lang.Object r7 = r1.trackSelectionData
            r10 = r8
            long r8 = r1.startTimeUs
            long r11 = r1.endTimeUs
            r14 = r25
            r18 = r27
            r1 = r10
            r10 = r11
            r12 = r23
            r1.loadError(r2, r3, r4, r5, r6, r7, r8, r10, r12, r14, r16, r18, r19)
            if (r19 == 0) goto L_0x0089
            com.mbridge.msdk.playercommon.exoplayer2.source.SequenceableLoader$Callback<com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkSampleStream<T>> r1 = r0.callback
            r1.onContinueLoadingRequested(r0)
            r1 = 2
            return r1
        L_0x0089:
            return r20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkSampleStream.onLoadError(com.mbridge.msdk.playercommon.exoplayer2.source.chunk.Chunk, long, long, java.io.IOException):int");
    }

    public void release(@Nullable ReleaseCallback<T> releaseCallback2) {
        this.releaseCallback = releaseCallback2;
        this.primarySampleQueue.discardToEnd();
        for (SampleQueue discardToEnd : this.embeddedSampleQueues) {
            discardToEnd.discardToEnd();
        }
        this.loader.release(this);
    }

    private void maybeNotifyPrimaryTrackFormatChanged(int i5) {
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i5);
        Format format = baseMediaChunk.trackFormat;
        if (!format.equals(this.primaryDownstreamTrackFormat)) {
            this.eventDispatcher.downstreamFormatChanged(this.primaryTrackType, format, baseMediaChunk.trackSelectionReason, baseMediaChunk.trackSelectionData, baseMediaChunk.startTimeUs);
        }
        this.primaryDownstreamTrackFormat = format;
    }
}
