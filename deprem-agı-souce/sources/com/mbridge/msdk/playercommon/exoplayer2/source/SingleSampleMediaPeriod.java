package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Loader;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {
    private static final int INITIAL_SAMPLE_SIZE = 1024;
    private final DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    private int errorCount;
    /* access modifiers changed from: private */
    public final MediaSourceEventListener.EventDispatcher eventDispatcher;
    final Format format;
    final Loader loader = new Loader("Loader:SingleSampleMediaPeriod");
    boolean loadingFinished;
    boolean loadingSucceeded;
    private final int minLoadableRetryCount;
    boolean notifiedReadingStarted;
    byte[] sampleData;
    int sampleSize;
    private final ArrayList<SampleStreamImpl> sampleStreams = new ArrayList<>();
    private final TrackGroupArray tracks;
    final boolean treatLoadErrorsAsEndOfStream;

    private final class SampleStreamImpl implements SampleStream {
        private static final int STREAM_STATE_END_OF_STREAM = 2;
        private static final int STREAM_STATE_SEND_FORMAT = 0;
        private static final int STREAM_STATE_SEND_SAMPLE = 1;
        private boolean formatSent;
        private int streamState;

        private SampleStreamImpl() {
        }

        private void sendFormat() {
            if (!this.formatSent) {
                SingleSampleMediaPeriod.this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(SingleSampleMediaPeriod.this.format.sampleMimeType), SingleSampleMediaPeriod.this.format, 0, (Object) null, 0);
                this.formatSent = true;
            }
        }

        public final boolean isReady() {
            return SingleSampleMediaPeriod.this.loadingFinished;
        }

        public final void maybeThrowError() throws IOException {
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            if (!singleSampleMediaPeriod.treatLoadErrorsAsEndOfStream) {
                singleSampleMediaPeriod.loader.maybeThrowError();
            }
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4) {
            int i5 = this.streamState;
            if (i5 == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            } else if (z4 || i5 == 0) {
                formatHolder.format = SingleSampleMediaPeriod.this.format;
                this.streamState = 1;
                return -5;
            } else {
                SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
                if (!singleSampleMediaPeriod.loadingFinished) {
                    return -3;
                }
                if (singleSampleMediaPeriod.loadingSucceeded) {
                    decoderInputBuffer.timeUs = 0;
                    decoderInputBuffer.addFlag(1);
                    decoderInputBuffer.ensureSpaceForWrite(SingleSampleMediaPeriod.this.sampleSize);
                    ByteBuffer byteBuffer = decoderInputBuffer.data;
                    SingleSampleMediaPeriod singleSampleMediaPeriod2 = SingleSampleMediaPeriod.this;
                    byteBuffer.put(singleSampleMediaPeriod2.sampleData, 0, singleSampleMediaPeriod2.sampleSize);
                    sendFormat();
                } else {
                    decoderInputBuffer.addFlag(4);
                }
                this.streamState = 2;
                return -4;
            }
        }

        public final void reset() {
            if (this.streamState == 2) {
                this.streamState = 1;
            }
        }

        public final int skipData(long j5) {
            if (j5 <= 0 || this.streamState == 2) {
                return 0;
            }
            this.streamState = 2;
            sendFormat();
            return 1;
        }
    }

    static final class SourceLoadable implements Loader.Loadable {
        private final DataSource dataSource;
        public final DataSpec dataSpec;
        /* access modifiers changed from: private */
        public byte[] sampleData;
        /* access modifiers changed from: private */
        public int sampleSize;

        public SourceLoadable(DataSpec dataSpec2, DataSource dataSource2) {
            this.dataSpec = dataSpec2;
            this.dataSource = dataSource2;
        }

        public final void cancelLoad() {
        }

        public final void load() throws IOException, InterruptedException {
            int i5 = 0;
            this.sampleSize = 0;
            try {
                this.dataSource.open(this.dataSpec);
                while (i5 != -1) {
                    int i6 = this.sampleSize + i5;
                    this.sampleSize = i6;
                    byte[] bArr = this.sampleData;
                    if (bArr == null) {
                        this.sampleData = new byte[1024];
                    } else if (i6 == bArr.length) {
                        this.sampleData = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    DataSource dataSource2 = this.dataSource;
                    byte[] bArr2 = this.sampleData;
                    int i7 = this.sampleSize;
                    i5 = dataSource2.read(bArr2, i7, bArr2.length - i7);
                }
                Util.closeQuietly(this.dataSource);
            } catch (Throwable th) {
                Util.closeQuietly(this.dataSource);
                throw th;
            }
        }
    }

    public SingleSampleMediaPeriod(DataSpec dataSpec2, DataSource.Factory factory, Format format2, long j5, int i5, MediaSourceEventListener.EventDispatcher eventDispatcher2, boolean z4) {
        this.dataSpec = dataSpec2;
        this.dataSourceFactory = factory;
        this.format = format2;
        this.durationUs = j5;
        this.minLoadableRetryCount = i5;
        this.eventDispatcher = eventDispatcher2;
        this.treatLoadErrorsAsEndOfStream = z4;
        this.tracks = new TrackGroupArray(new TrackGroup(format2));
        eventDispatcher2.mediaPeriodCreated();
    }

    public final boolean continueLoading(long j5) {
        if (this.loadingFinished || this.loader.isLoading()) {
            return false;
        }
        this.eventDispatcher.loadStarted(this.dataSpec, 1, -1, this.format, 0, (Object) null, 0, this.durationUs, this.loader.startLoading(new SourceLoadable(this.dataSpec, this.dataSourceFactory.createDataSource()), this, this.minLoadableRetryCount));
        return true;
    }

    public final void discardBuffer(long j5, boolean z4) {
    }

    public final long getAdjustedSeekPositionUs(long j5, SeekParameters seekParameters) {
        return j5;
    }

    public final long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return 0;
    }

    public final long getNextLoadPositionUs() {
        if (this.loadingFinished || this.loader.isLoading()) {
            return Long.MIN_VALUE;
        }
        return 0;
    }

    public final TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    public final void maybeThrowPrepareError() throws IOException {
    }

    public final void prepare(MediaPeriod.Callback callback, long j5) {
        callback.onPrepared(this);
    }

    public final long readDiscontinuity() {
        if (this.notifiedReadingStarted) {
            return C.TIME_UNSET;
        }
        this.eventDispatcher.readingStarted();
        this.notifiedReadingStarted = true;
        return C.TIME_UNSET;
    }

    public final void reevaluateBuffer(long j5) {
    }

    public final void release() {
        this.loader.release();
        this.eventDispatcher.mediaPeriodReleased();
    }

    public final long seekToUs(long j5) {
        for (int i5 = 0; i5 < this.sampleStreams.size(); i5++) {
            this.sampleStreams.get(i5).reset();
        }
        return j5;
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j5) {
        for (int i5 = 0; i5 < trackSelectionArr.length; i5++) {
            SampleStream sampleStream = sampleStreamArr[i5];
            if (sampleStream != null && (trackSelectionArr[i5] == null || !zArr[i5])) {
                this.sampleStreams.remove(sampleStream);
                sampleStreamArr[i5] = null;
            }
            if (sampleStreamArr[i5] == null && trackSelectionArr[i5] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                this.sampleStreams.add(sampleStreamImpl);
                sampleStreamArr[i5] = sampleStreamImpl;
                zArr2[i5] = true;
            }
        }
        return j5;
    }

    public final void onLoadCanceled(SourceLoadable sourceLoadable, long j5, long j6, boolean z4) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        long j7 = j5;
        long j8 = j6;
        this.eventDispatcher.loadCanceled(sourceLoadable2.dataSpec, 1, -1, (Format) null, 0, (Object) null, 0, this.durationUs, j7, j8, (long) sourceLoadable2.sampleSize);
    }

    public final void onLoadCompleted(SourceLoadable sourceLoadable, long j5, long j6) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        this.eventDispatcher.loadCompleted(sourceLoadable2.dataSpec, 1, -1, this.format, 0, (Object) null, 0, this.durationUs, j5, j6, (long) sourceLoadable2.sampleSize);
        this.sampleSize = sourceLoadable.sampleSize;
        this.sampleData = sourceLoadable.sampleData;
        this.loadingFinished = true;
        this.loadingSucceeded = true;
    }

    public final int onLoadError(SourceLoadable sourceLoadable, long j5, long j6, IOException iOException) {
        int i5 = this.errorCount + 1;
        this.errorCount = i5;
        boolean z4 = this.treatLoadErrorsAsEndOfStream && i5 >= this.minLoadableRetryCount;
        SourceLoadable sourceLoadable2 = sourceLoadable;
        this.eventDispatcher.loadError(sourceLoadable2.dataSpec, 1, -1, this.format, 0, (Object) null, 0, this.durationUs, j5, j6, (long) sourceLoadable2.sampleSize, iOException, z4);
        if (!z4) {
            return 0;
        }
        this.loadingFinished = true;
        return 2;
    }
}
