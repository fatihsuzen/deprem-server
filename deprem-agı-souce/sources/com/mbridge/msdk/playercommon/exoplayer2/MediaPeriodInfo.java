package com.mbridge.msdk.playercommon.exoplayer2;

import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;

final class MediaPeriodInfo {
    public final long contentPositionUs;
    public final long durationUs;
    public final long endPositionUs;
    public final MediaSource.MediaPeriodId id;
    public final boolean isFinal;
    public final boolean isLastInTimelinePeriod;
    public final long startPositionUs;

    MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j5, long j6, long j7, long j8, boolean z4, boolean z5) {
        this.id = mediaPeriodId;
        this.startPositionUs = j5;
        this.endPositionUs = j6;
        this.contentPositionUs = j7;
        this.durationUs = j8;
        this.isLastInTimelinePeriod = z4;
        this.isFinal = z5;
    }

    public final MediaPeriodInfo copyWithPeriodIndex(int i5) {
        return new MediaPeriodInfo(this.id.copyWithPeriodIndex(i5), this.startPositionUs, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }

    public final MediaPeriodInfo copyWithStartPositionUs(long j5) {
        return new MediaPeriodInfo(this.id, j5, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }
}
