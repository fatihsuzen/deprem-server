package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DefaultExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleQueue;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Loader;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.ConditionVariable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

final class ExtractorMediaPeriod implements ExtractorOutput, MediaPeriod, SampleQueue.UpstreamFormatChangedListener, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback {
    private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000;
    private int actualMinLoadableRetryCount;
    private final Allocator allocator;
    /* access modifiers changed from: private */
    @Nullable
    public MediaPeriod.Callback callback;
    /* access modifiers changed from: private */
    public final long continueLoadingCheckIntervalBytes;
    /* access modifiers changed from: private */
    @Nullable
    public final String customCacheKey;
    private final DataSource dataSource;
    private long durationUs;
    private int enabledTrackCount;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private int extractedSamplesCountAtStartOfLoad;
    private final ExtractorHolder extractorHolder;
    /* access modifiers changed from: private */
    public final Handler handler;
    private boolean haveAudioVideoTracks;
    private long lastSeekPositionUs;
    private long length;
    private final Listener listener;
    private final ConditionVariable loadCondition;
    private final Loader loader = new Loader("Loader:ExtractorMediaPeriod");
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable;
    private final int minLoadableRetryCount;
    private boolean notifiedReadingStarted;
    private boolean notifyDiscontinuity;
    /* access modifiers changed from: private */
    public final Runnable onContinueLoadingRequestedRunnable;
    private boolean pendingDeferredRetry;
    private long pendingResetPositionUs;
    private boolean prepared;
    /* access modifiers changed from: private */
    public boolean released;
    private int[] sampleQueueTrackIds;
    private SampleQueue[] sampleQueues;
    private boolean sampleQueuesBuilt;
    private SeekMap seekMap;
    private boolean seenFirstTrackSelection;
    private boolean[] trackEnabledStates;
    private boolean[] trackFormatNotificationSent;
    private boolean[] trackIsAudioVideoFlags;
    private TrackGroupArray tracks;
    private final Uri uri;

    final class ExtractingLoadable implements Loader.Loadable {
        /* access modifiers changed from: private */
        public long bytesLoaded;
        private final DataSource dataSource;
        /* access modifiers changed from: private */
        public DataSpec dataSpec;
        private final ExtractorHolder extractorHolder;
        /* access modifiers changed from: private */
        public long length = -1;
        private volatile boolean loadCanceled;
        private final ConditionVariable loadCondition;
        private boolean pendingExtractorSeek = true;
        private final PositionHolder positionHolder = new PositionHolder();
        /* access modifiers changed from: private */
        public long seekTimeUs;
        private final Uri uri;

        public ExtractingLoadable(Uri uri2, DataSource dataSource2, ExtractorHolder extractorHolder2, ConditionVariable conditionVariable) {
            this.uri = (Uri) Assertions.checkNotNull(uri2);
            this.dataSource = (DataSource) Assertions.checkNotNull(dataSource2);
            this.extractorHolder = (ExtractorHolder) Assertions.checkNotNull(extractorHolder2);
            this.loadCondition = conditionVariable;
        }

        public final void cancelLoad() {
            this.loadCanceled = true;
        }

        public final void load() throws IOException, InterruptedException {
            int i5 = 0;
            while (i5 == 0 && !this.loadCanceled) {
                DefaultExtractorInput defaultExtractorInput = null;
                try {
                    long j5 = this.positionHolder.position;
                    DataSpec dataSpec2 = new DataSpec(this.uri, j5, -1, ExtractorMediaPeriod.this.customCacheKey);
                    this.dataSpec = dataSpec2;
                    long open = this.dataSource.open(dataSpec2);
                    this.length = open;
                    if (open != -1) {
                        this.length = open + j5;
                    }
                    DefaultExtractorInput defaultExtractorInput2 = new DefaultExtractorInput(this.dataSource, j5, this.length);
                    try {
                        Extractor selectExtractor = this.extractorHolder.selectExtractor(defaultExtractorInput2, this.dataSource.getUri());
                        if (this.pendingExtractorSeek) {
                            selectExtractor.seek(j5, this.seekTimeUs);
                            this.pendingExtractorSeek = false;
                        }
                        while (i5 == 0 && !this.loadCanceled) {
                            this.loadCondition.block();
                            i5 = selectExtractor.read(defaultExtractorInput2, this.positionHolder);
                            if (defaultExtractorInput2.getPosition() > ExtractorMediaPeriod.this.continueLoadingCheckIntervalBytes + j5) {
                                j5 = defaultExtractorInput2.getPosition();
                                this.loadCondition.close();
                                ExtractorMediaPeriod.this.handler.post(ExtractorMediaPeriod.this.onContinueLoadingRequestedRunnable);
                            }
                        }
                        if (i5 == 1) {
                            i5 = 0;
                        } else {
                            this.positionHolder.position = defaultExtractorInput2.getPosition();
                            this.bytesLoaded = this.positionHolder.position - this.dataSpec.absoluteStreamPosition;
                        }
                        Util.closeQuietly(this.dataSource);
                    } catch (Throwable th) {
                        th = th;
                        defaultExtractorInput = defaultExtractorInput2;
                        this.positionHolder.position = defaultExtractorInput.getPosition();
                        this.bytesLoaded = this.positionHolder.position - this.dataSpec.absoluteStreamPosition;
                        Util.closeQuietly(this.dataSource);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (!(i5 == 1 || defaultExtractorInput == null)) {
                        this.positionHolder.position = defaultExtractorInput.getPosition();
                        this.bytesLoaded = this.positionHolder.position - this.dataSpec.absoluteStreamPosition;
                    }
                    Util.closeQuietly(this.dataSource);
                    throw th;
                }
            }
        }

        public final void setLoadPosition(long j5, long j6) {
            this.positionHolder.position = j5;
            this.seekTimeUs = j6;
            this.pendingExtractorSeek = true;
        }
    }

    private static final class ExtractorHolder {
        private Extractor extractor;
        private final ExtractorOutput extractorOutput;
        private final Extractor[] extractors;

        public ExtractorHolder(Extractor[] extractorArr, ExtractorOutput extractorOutput2) {
            this.extractors = extractorArr;
            this.extractorOutput = extractorOutput2;
        }

        public final void release() {
            Extractor extractor2 = this.extractor;
            if (extractor2 != null) {
                extractor2.release();
                this.extractor = null;
            }
        }

        public final Extractor selectExtractor(ExtractorInput extractorInput, Uri uri) throws IOException, InterruptedException {
            Extractor extractor2 = this.extractor;
            if (extractor2 != null) {
                return extractor2;
            }
            Extractor[] extractorArr = this.extractors;
            int length = extractorArr.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                Extractor extractor3 = extractorArr[i5];
                try {
                    if (extractor3.sniff(extractorInput)) {
                        this.extractor = extractor3;
                        extractorInput.resetPeekPosition();
                        break;
                    }
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    extractorInput.resetPeekPosition();
                    throw th;
                }
                extractorInput.resetPeekPosition();
                i5++;
            }
            Extractor extractor4 = this.extractor;
            if (extractor4 != null) {
                extractor4.init(this.extractorOutput);
                return this.extractor;
            }
            throw new UnrecognizedInputFormatException("None of the available extractors (" + Util.getCommaDelimitedSimpleClassNames(this.extractors) + ") could read the stream.", uri);
        }
    }

    interface Listener {
        void onSourceInfoRefreshed(long j5, boolean z4);
    }

    private final class SampleStreamImpl implements SampleStream {
        /* access modifiers changed from: private */
        public final int track;

        public SampleStreamImpl(int i5) {
            this.track = i5;
        }

        public final boolean isReady() {
            return ExtractorMediaPeriod.this.isReady(this.track);
        }

        public final void maybeThrowError() throws IOException {
            ExtractorMediaPeriod.this.maybeThrowError();
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4) {
            return ExtractorMediaPeriod.this.readData(this.track, formatHolder, decoderInputBuffer, z4);
        }

        public final int skipData(long j5) {
            return ExtractorMediaPeriod.this.skipData(this.track, j5);
        }
    }

    public ExtractorMediaPeriod(Uri uri2, DataSource dataSource2, Extractor[] extractorArr, int i5, MediaSourceEventListener.EventDispatcher eventDispatcher2, Listener listener2, Allocator allocator2, @Nullable String str, int i6) {
        this.uri = uri2;
        this.dataSource = dataSource2;
        this.minLoadableRetryCount = i5;
        this.eventDispatcher = eventDispatcher2;
        this.listener = listener2;
        this.allocator = allocator2;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = (long) i6;
        this.extractorHolder = new ExtractorHolder(extractorArr, this);
        this.loadCondition = new ConditionVariable();
        this.maybeFinishPrepareRunnable = new Runnable() {
            public void run() {
                ExtractorMediaPeriod.this.maybeFinishPrepare();
            }
        };
        this.onContinueLoadingRequestedRunnable = new Runnable() {
            public void run() {
                if (!ExtractorMediaPeriod.this.released) {
                    ExtractorMediaPeriod.this.callback.onContinueLoadingRequested(ExtractorMediaPeriod.this);
                }
            }
        };
        this.handler = new Handler();
        this.sampleQueueTrackIds = new int[0];
        this.sampleQueues = new SampleQueue[0];
        this.pendingResetPositionUs = C.TIME_UNSET;
        this.length = -1;
        this.durationUs = C.TIME_UNSET;
        this.actualMinLoadableRetryCount = i5 == -1 ? 3 : i5;
        eventDispatcher2.mediaPeriodCreated();
    }

    private boolean configureRetry(ExtractingLoadable extractingLoadable, int i5) {
        SeekMap seekMap2;
        if (this.length == -1 && ((seekMap2 = this.seekMap) == null || seekMap2.getDurationUs() == C.TIME_UNSET)) {
            if (!this.prepared || suppressRead()) {
                this.notifyDiscontinuity = this.prepared;
                this.lastSeekPositionUs = 0;
                this.extractedSamplesCountAtStartOfLoad = 0;
                for (SampleQueue reset : this.sampleQueues) {
                    reset.reset();
                }
                extractingLoadable.setLoadPosition(0, 0);
                return true;
            }
            this.pendingDeferredRetry = true;
            return false;
        }
        this.extractedSamplesCountAtStartOfLoad = i5;
        return true;
    }

    private void copyLengthFromLoader(ExtractingLoadable extractingLoadable) {
        if (this.length == -1) {
            this.length = extractingLoadable.length;
        }
    }

    private int getExtractedSamplesCount() {
        int i5 = 0;
        for (SampleQueue writeIndex : this.sampleQueues) {
            i5 += writeIndex.getWriteIndex();
        }
        return i5;
    }

    private long getLargestQueuedTimestampUs() {
        long j5 = Long.MIN_VALUE;
        for (SampleQueue largestQueuedTimestampUs : this.sampleQueues) {
            j5 = Math.max(j5, largestQueuedTimestampUs.getLargestQueuedTimestampUs());
        }
        return j5;
    }

    private static boolean isLoadableExceptionFatal(IOException iOException) {
        return iOException instanceof UnrecognizedInputFormatException;
    }

    private boolean isPendingReset() {
        if (this.pendingResetPositionUs != C.TIME_UNSET) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v1 ?, r4v3 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public void maybeFinishPrepare() {
        /*
            r8 = this;
            boolean r0 = r8.released
            if (r0 != 0) goto L_0x00b1
            boolean r0 = r8.prepared
            if (r0 != 0) goto L_0x00b1
            com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap r0 = r8.seekMap
            if (r0 == 0) goto L_0x00b1
            boolean r0 = r8.sampleQueuesBuilt
            if (r0 != 0) goto L_0x0012
            goto L_0x00b1
        L_0x0012:
            com.mbridge.msdk.playercommon.exoplayer2.source.SampleQueue[] r0 = r8.sampleQueues
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L_0x0017:
            if (r3 >= r1) goto L_0x0026
            r4 = r0[r3]
            com.mbridge.msdk.playercommon.exoplayer2.Format r4 = r4.getUpstreamFormat()
            if (r4 != 0) goto L_0x0023
            goto L_0x00b1
        L_0x0023:
            int r3 = r3 + 1
            goto L_0x0017
        L_0x0026:
            com.mbridge.msdk.playercommon.exoplayer2.util.ConditionVariable r0 = r8.loadCondition
            r0.close()
            com.mbridge.msdk.playercommon.exoplayer2.source.SampleQueue[] r0 = r8.sampleQueues
            int r0 = r0.length
            com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup[] r1 = new com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup[r0]
            boolean[] r3 = new boolean[r0]
            r8.trackIsAudioVideoFlags = r3
            boolean[] r3 = new boolean[r0]
            r8.trackEnabledStates = r3
            boolean[] r3 = new boolean[r0]
            r8.trackFormatNotificationSent = r3
            com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap r3 = r8.seekMap
            long r3 = r3.getDurationUs()
            r8.durationUs = r3
            r3 = r2
        L_0x0045:
            r4 = 1
            if (r3 >= r0) goto L_0x0077
            com.mbridge.msdk.playercommon.exoplayer2.source.SampleQueue[] r5 = r8.sampleQueues
            r5 = r5[r3]
            com.mbridge.msdk.playercommon.exoplayer2.Format r5 = r5.getUpstreamFormat()
            com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup r6 = new com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup
            com.mbridge.msdk.playercommon.exoplayer2.Format[] r7 = new com.mbridge.msdk.playercommon.exoplayer2.Format[r4]
            r7[r2] = r5
            r6.<init>((com.mbridge.msdk.playercommon.exoplayer2.Format[]) r7)
            r1[r3] = r6
            java.lang.String r5 = r5.sampleMimeType
            boolean r6 = com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.isVideo(r5)
            if (r6 != 0) goto L_0x006b
            boolean r5 = com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.isAudio(r5)
            if (r5 == 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r4 = r2
        L_0x006b:
            boolean[] r5 = r8.trackIsAudioVideoFlags
            r5[r3] = r4
            boolean r5 = r8.haveAudioVideoTracks
            r4 = r4 | r5
            r8.haveAudioVideoTracks = r4
            int r3 = r3 + 1
            goto L_0x0045
        L_0x0077:
            com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray r0 = new com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray
            r0.<init>((com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup[]) r1)
            r8.tracks = r0
            int r0 = r8.minLoadableRetryCount
            r1 = -1
            if (r0 != r1) goto L_0x009d
            long r0 = r8.length
            r2 = -1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x009d
            com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap r0 = r8.seekMap
            long r0 = r0.getDurationUs()
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x009d
            r0 = 6
            r8.actualMinLoadableRetryCount = r0
        L_0x009d:
            r8.prepared = r4
            com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaPeriod$Listener r0 = r8.listener
            long r1 = r8.durationUs
            com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap r3 = r8.seekMap
            boolean r3 = r3.isSeekable()
            r0.onSourceInfoRefreshed(r1, r3)
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod$Callback r0 = r8.callback
            r0.onPrepared(r8)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaPeriod.maybeFinishPrepare():void");
    }

    private void maybeNotifyTrackFormat(int i5) {
        if (!this.trackFormatNotificationSent[i5]) {
            Format format = this.tracks.get(i5).getFormat(0);
            this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(format.sampleMimeType), format, 0, (Object) null, this.lastSeekPositionUs);
            this.trackFormatNotificationSent[i5] = true;
        }
    }

    private void maybeStartDeferredRetry(int i5) {
        if (this.pendingDeferredRetry && this.trackIsAudioVideoFlags[i5] && !this.sampleQueues[i5].hasNextSample()) {
            this.pendingResetPositionUs = 0;
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = true;
            this.lastSeekPositionUs = 0;
            this.extractedSamplesCountAtStartOfLoad = 0;
            for (SampleQueue reset : this.sampleQueues) {
                reset.reset();
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    private boolean seekInsideBufferUs(long j5) {
        int length2 = this.sampleQueues.length;
        for (int i5 = 0; i5 < length2; i5++) {
            SampleQueue sampleQueue = this.sampleQueues[i5];
            sampleQueue.rewind();
            if (sampleQueue.advanceTo(j5, true, false) == -1 && (this.trackIsAudioVideoFlags[i5] || !this.haveAudioVideoTracks)) {
                return false;
            }
        }
        return true;
    }

    private void startLoading() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.uri, this.dataSource, this.extractorHolder, this.loadCondition);
        if (this.prepared) {
            Assertions.checkState(isPendingReset());
            long j5 = this.durationUs;
            if (j5 == C.TIME_UNSET || this.pendingResetPositionUs < j5) {
                extractingLoadable.setLoadPosition(this.seekMap.getSeekPoints(this.pendingResetPositionUs).first.position, this.pendingResetPositionUs);
                this.pendingResetPositionUs = C.TIME_UNSET;
            } else {
                this.loadingFinished = true;
                this.pendingResetPositionUs = C.TIME_UNSET;
                return;
            }
        }
        this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
        this.eventDispatcher.loadStarted(extractingLoadable.dataSpec, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs, this.loader.startLoading(extractingLoadable, this, this.actualMinLoadableRetryCount));
    }

    private boolean suppressRead() {
        if (this.notifyDiscontinuity || isPendingReset()) {
            return true;
        }
        return false;
    }

    public final boolean continueLoading(long j5) {
        if (this.loadingFinished || this.pendingDeferredRetry) {
            return false;
        }
        if (this.prepared && this.enabledTrackCount == 0) {
            return false;
        }
        boolean open = this.loadCondition.open();
        if (this.loader.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    public final void discardBuffer(long j5, boolean z4) {
        int length2 = this.sampleQueues.length;
        for (int i5 = 0; i5 < length2; i5++) {
            this.sampleQueues[i5].discardTo(j5, z4, this.trackEnabledStates[i5]);
        }
    }

    public final void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public final long getAdjustedSeekPositionUs(long j5, SeekParameters seekParameters) {
        if (!this.seekMap.isSeekable()) {
            return 0;
        }
        SeekMap.SeekPoints seekPoints = this.seekMap.getSeekPoints(j5);
        return Util.resolveSeekPositionUs(j5, seekParameters, seekPoints.first.timeUs, seekPoints.second.timeUs);
    }

    public final long getBufferedPositionUs() {
        long j5;
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.haveAudioVideoTracks) {
            int length2 = this.sampleQueues.length;
            j5 = Long.MAX_VALUE;
            for (int i5 = 0; i5 < length2; i5++) {
                if (this.trackIsAudioVideoFlags[i5]) {
                    j5 = Math.min(j5, this.sampleQueues[i5].getLargestQueuedTimestampUs());
                }
            }
        } else {
            j5 = getLargestQueuedTimestampUs();
        }
        if (j5 == Long.MIN_VALUE) {
            return this.lastSeekPositionUs;
        }
        return j5;
    }

    public final long getNextLoadPositionUs() {
        if (this.enabledTrackCount == 0) {
            return Long.MIN_VALUE;
        }
        return getBufferedPositionUs();
    }

    public final TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    /* access modifiers changed from: package-private */
    public final boolean isReady(int i5) {
        if (suppressRead()) {
            return false;
        }
        if (this.loadingFinished || this.sampleQueues[i5].hasNextSample()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void maybeThrowError() throws IOException {
        this.loader.maybeThrowError(this.actualMinLoadableRetryCount);
    }

    public final void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
    }

    public final void onLoaderReleased() {
        for (SampleQueue reset : this.sampleQueues) {
            reset.reset();
        }
        this.extractorHolder.release();
    }

    public final void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public final void prepare(MediaPeriod.Callback callback2, long j5) {
        this.callback = callback2;
        this.loadCondition.open();
        startLoading();
    }

    /* access modifiers changed from: package-private */
    public final int readData(int i5, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4) {
        if (suppressRead()) {
            return -3;
        }
        int read = this.sampleQueues[i5].read(formatHolder, decoderInputBuffer, z4, this.loadingFinished, this.lastSeekPositionUs);
        if (read == -4) {
            maybeNotifyTrackFormat(i5);
            return read;
        }
        if (read == -3) {
            maybeStartDeferredRetry(i5);
        }
        return read;
    }

    public final long readDiscontinuity() {
        if (!this.notifiedReadingStarted) {
            this.eventDispatcher.readingStarted();
            this.notifiedReadingStarted = true;
        }
        if (!this.notifyDiscontinuity) {
            return C.TIME_UNSET;
        }
        if (!this.loadingFinished && getExtractedSamplesCount() <= this.extractedSamplesCountAtStartOfLoad) {
            return C.TIME_UNSET;
        }
        this.notifyDiscontinuity = false;
        return this.lastSeekPositionUs;
    }

    public final void reevaluateBuffer(long j5) {
    }

    public final void release() {
        if (this.prepared) {
            for (SampleQueue discardToEnd : this.sampleQueues) {
                discardToEnd.discardToEnd();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages((Object) null);
        this.callback = null;
        this.released = true;
        this.eventDispatcher.mediaPeriodReleased();
    }

    public final void seekMap(SeekMap seekMap2) {
        this.seekMap = seekMap2;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public final long seekToUs(long j5) {
        if (!this.seekMap.isSeekable()) {
            j5 = 0;
        }
        this.lastSeekPositionUs = j5;
        this.notifyDiscontinuity = false;
        if (isPendingReset() || !seekInsideBufferUs(j5)) {
            this.pendingDeferredRetry = false;
            this.pendingResetPositionUs = j5;
            this.loadingFinished = false;
            if (this.loader.isLoading()) {
                this.loader.cancelLoading();
                return j5;
            }
            for (SampleQueue reset : this.sampleQueues) {
                reset.reset();
            }
        }
        return j5;
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j5) {
        boolean z4;
        TrackSelection trackSelection;
        boolean z5;
        boolean z6;
        Assertions.checkState(this.prepared);
        int i5 = this.enabledTrackCount;
        int i6 = 0;
        for (int i7 = 0; i7 < trackSelectionArr.length; i7++) {
            SampleStreamImpl sampleStreamImpl = sampleStreamArr[i7];
            if (sampleStreamImpl != null && (trackSelectionArr[i7] == null || !zArr[i7])) {
                int access$300 = sampleStreamImpl.track;
                Assertions.checkState(this.trackEnabledStates[access$300]);
                this.enabledTrackCount--;
                this.trackEnabledStates[access$300] = false;
                sampleStreamArr[i7] = null;
            }
        }
        if (!this.seenFirstTrackSelection ? j5 == 0 : i5 != 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        for (int i8 = 0; i8 < trackSelectionArr.length; i8++) {
            if (sampleStreamArr[i8] == null && (trackSelection = trackSelectionArr[i8]) != null) {
                if (trackSelection.length() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Assertions.checkState(z5);
                if (trackSelection.getIndexInTrackGroup(0) == 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                Assertions.checkState(z6);
                int indexOf = this.tracks.indexOf(trackSelection.getTrackGroup());
                Assertions.checkState(!this.trackEnabledStates[indexOf]);
                this.enabledTrackCount++;
                this.trackEnabledStates[indexOf] = true;
                sampleStreamArr[i8] = new SampleStreamImpl(indexOf);
                zArr2[i8] = true;
                if (!z4) {
                    SampleQueue sampleQueue = this.sampleQueues[indexOf];
                    sampleQueue.rewind();
                    if (sampleQueue.advanceTo(j5, true, true) != -1 || sampleQueue.getReadIndex() == 0) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                }
            }
        }
        if (this.enabledTrackCount == 0) {
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = false;
            if (this.loader.isLoading()) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                int length2 = sampleQueueArr.length;
                while (i6 < length2) {
                    sampleQueueArr[i6].discardToEnd();
                    i6++;
                }
                this.loader.cancelLoading();
            } else {
                SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                int length3 = sampleQueueArr2.length;
                while (i6 < length3) {
                    sampleQueueArr2[i6].reset();
                    i6++;
                }
            }
        } else if (z4) {
            j5 = seekToUs(j5);
            while (i6 < sampleStreamArr.length) {
                if (sampleStreamArr[i6] != null) {
                    zArr2[i6] = true;
                }
                i6++;
            }
        }
        this.seenFirstTrackSelection = true;
        return j5;
    }

    /* access modifiers changed from: package-private */
    public final int skipData(int i5, long j5) {
        int i6 = 0;
        if (suppressRead()) {
            return 0;
        }
        SampleQueue sampleQueue = this.sampleQueues[i5];
        if (!this.loadingFinished || j5 <= sampleQueue.getLargestQueuedTimestampUs()) {
            int advanceTo = sampleQueue.advanceTo(j5, true, true);
            if (advanceTo != -1) {
                i6 = advanceTo;
            }
        } else {
            i6 = sampleQueue.advanceToEnd();
        }
        if (i6 > 0) {
            maybeNotifyTrackFormat(i5);
            return i6;
        }
        maybeStartDeferredRetry(i5);
        return i6;
    }

    public final TrackOutput track(int i5, int i6) {
        int length2 = this.sampleQueues.length;
        for (int i7 = 0; i7 < length2; i7++) {
            if (this.sampleQueueTrackIds[i7] == i5) {
                return this.sampleQueues[i7];
            }
        }
        SampleQueue sampleQueue = new SampleQueue(this.allocator);
        sampleQueue.setUpstreamFormatChangeListener(this);
        int i8 = length2 + 1;
        int[] copyOf = Arrays.copyOf(this.sampleQueueTrackIds, i8);
        this.sampleQueueTrackIds = copyOf;
        copyOf[length2] = i5;
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.sampleQueues, i8);
        this.sampleQueues = sampleQueueArr;
        sampleQueueArr[length2] = sampleQueue;
        return sampleQueue;
    }

    public final void onLoadCanceled(ExtractingLoadable extractingLoadable, long j5, long j6, boolean z4) {
        this.eventDispatcher.loadCanceled(extractingLoadable.dataSpec, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs, j5, j6, extractingLoadable.bytesLoaded);
        if (!z4) {
            copyLengthFromLoader(extractingLoadable);
            for (SampleQueue reset : this.sampleQueues) {
                reset.reset();
            }
            if (this.enabledTrackCount > 0) {
                this.callback.onContinueLoadingRequested(this);
            }
        }
    }

    public final void onLoadCompleted(ExtractingLoadable extractingLoadable, long j5, long j6) {
        if (this.durationUs == C.TIME_UNSET) {
            long largestQueuedTimestampUs = getLargestQueuedTimestampUs();
            long j7 = largestQueuedTimestampUs == Long.MIN_VALUE ? 0 : largestQueuedTimestampUs + 10000;
            this.durationUs = j7;
            this.listener.onSourceInfoRefreshed(j7, this.seekMap.isSeekable());
        }
        this.eventDispatcher.loadCompleted(extractingLoadable.dataSpec, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs, j5, j6, extractingLoadable.bytesLoaded);
        copyLengthFromLoader(extractingLoadable);
        this.loadingFinished = true;
        this.callback.onContinueLoadingRequested(this);
    }

    public final int onLoadError(ExtractingLoadable extractingLoadable, long j5, long j6, IOException iOException) {
        boolean isLoadableExceptionFatal = isLoadableExceptionFatal(iOException);
        this.eventDispatcher.loadError(extractingLoadable.dataSpec, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs, j5, j6, extractingLoadable.bytesLoaded, iOException, isLoadableExceptionFatal);
        copyLengthFromLoader(extractingLoadable);
        if (isLoadableExceptionFatal) {
            return 3;
        }
        int extractedSamplesCount = getExtractedSamplesCount();
        boolean z4 = extractedSamplesCount > this.extractedSamplesCountAtStartOfLoad;
        if (configureRetry(extractingLoadable, extractedSamplesCount)) {
            return z4 ? 1 : 0;
        }
        return 2;
    }
}
