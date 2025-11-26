package com.mbridge.msdk.playercommon.exoplayer2.source;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import java.io.IOException;

public final class DeferredMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    public final MediaSource.MediaPeriodId id;
    @Nullable
    private PrepareErrorListener listener;
    private MediaPeriod mediaPeriod;
    public final MediaSource mediaSource;
    private boolean notifiedPrepareError;
    private long preparePositionOverrideUs = C.TIME_UNSET;
    private long preparePositionUs;

    public interface PrepareErrorListener {
        void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);
    }

    public DeferredMediaPeriod(MediaSource mediaSource2, MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator2) {
        this.id = mediaPeriodId;
        this.allocator = allocator2;
        this.mediaSource = mediaSource2;
    }

    public final boolean continueLoading(long j5) {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        if (mediaPeriod2 == null || !mediaPeriod2.continueLoading(j5)) {
            return false;
        }
        return true;
    }

    public final void createPeriod() {
        MediaPeriod createPeriod = this.mediaSource.createPeriod(this.id, this.allocator);
        this.mediaPeriod = createPeriod;
        if (this.callback != null) {
            createPeriod.prepare(this, this.preparePositionUs);
        }
    }

    public final void discardBuffer(long j5, boolean z4) {
        this.mediaPeriod.discardBuffer(j5, z4);
    }

    public final long getAdjustedSeekPositionUs(long j5, SeekParameters seekParameters) {
        return this.mediaPeriod.getAdjustedSeekPositionUs(j5, seekParameters);
    }

    public final long getBufferedPositionUs() {
        return this.mediaPeriod.getBufferedPositionUs();
    }

    public final long getNextLoadPositionUs() {
        return this.mediaPeriod.getNextLoadPositionUs();
    }

    public final TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    public final void maybeThrowPrepareError() throws IOException {
        try {
            MediaPeriod mediaPeriod2 = this.mediaPeriod;
            if (mediaPeriod2 != null) {
                mediaPeriod2.maybeThrowPrepareError();
            } else {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
            }
        } catch (IOException e5) {
            PrepareErrorListener prepareErrorListener = this.listener;
            if (prepareErrorListener == null) {
                throw e5;
            } else if (!this.notifiedPrepareError) {
                this.notifiedPrepareError = true;
                prepareErrorListener.onPrepareError(this.id, e5);
            }
        }
    }

    public final void onPrepared(MediaPeriod mediaPeriod2) {
        this.callback.onPrepared(this);
    }

    public final void prepare(MediaPeriod.Callback callback2, long j5) {
        this.callback = callback2;
        this.preparePositionUs = j5;
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        if (mediaPeriod2 != null) {
            mediaPeriod2.prepare(this, j5);
        }
    }

    public final long readDiscontinuity() {
        return this.mediaPeriod.readDiscontinuity();
    }

    public final void reevaluateBuffer(long j5) {
        this.mediaPeriod.reevaluateBuffer(j5);
    }

    public final void releasePeriod() {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        if (mediaPeriod2 != null) {
            this.mediaSource.releasePeriod(mediaPeriod2);
        }
    }

    public final long seekToUs(long j5) {
        return this.mediaPeriod.seekToUs(j5);
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j5) {
        long j6;
        long j7 = this.preparePositionOverrideUs;
        if (j7 == C.TIME_UNSET || j5 != 0) {
            j6 = j5;
        } else {
            this.preparePositionOverrideUs = C.TIME_UNSET;
            j6 = j7;
        }
        return this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr, zArr2, j6);
    }

    public final void setDefaultPreparePositionUs(long j5) {
        if (this.preparePositionUs == 0 && j5 != 0) {
            this.preparePositionOverrideUs = j5;
            this.preparePositionUs = j5;
        }
    }

    public final void setPrepareErrorListener(PrepareErrorListener prepareErrorListener) {
        this.listener = prepareErrorListener;
    }

    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
        this.callback.onContinueLoadingRequested(this);
    }
}
