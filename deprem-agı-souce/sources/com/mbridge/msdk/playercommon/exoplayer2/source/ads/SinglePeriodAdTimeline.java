package com.mbridge.msdk.playercommon.exoplayer2.source.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.ForwardingTimeline;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

final class SinglePeriodAdTimeline extends ForwardingTimeline {
    private final AdPlaybackState adPlaybackState;

    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState2) {
        super(timeline);
        boolean z4;
        boolean z5 = false;
        if (timeline.getPeriodCount() == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        Assertions.checkState(timeline.getWindowCount() == 1 ? true : z5);
        this.adPlaybackState = adPlaybackState2;
    }

    public final Timeline.Period getPeriod(int i5, Timeline.Period period, boolean z4) {
        this.timeline.getPeriod(i5, period, z4);
        Timeline.Period period2 = period;
        period2.set(period.id, period.uid, period.windowIndex, period.durationUs, period.getPositionInWindowUs(), this.adPlaybackState);
        return period2;
    }

    public final Timeline.Window getWindow(int i5, Timeline.Window window, boolean z4, long j5) {
        Timeline.Window window2 = super.getWindow(i5, window, z4, j5);
        if (window2.durationUs == C.TIME_UNSET) {
            window2.durationUs = this.adPlaybackState.contentDurationUs;
        }
        return window2;
    }
}
