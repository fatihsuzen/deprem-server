package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.Timeline;

public abstract class ForwardingTimeline extends Timeline {
    protected final Timeline timeline;

    public ForwardingTimeline(Timeline timeline2) {
        this.timeline = timeline2;
    }

    public int getFirstWindowIndex(boolean z4) {
        return this.timeline.getFirstWindowIndex(z4);
    }

    public int getIndexOfPeriod(Object obj) {
        return this.timeline.getIndexOfPeriod(obj);
    }

    public int getLastWindowIndex(boolean z4) {
        return this.timeline.getLastWindowIndex(z4);
    }

    public int getNextWindowIndex(int i5, int i6, boolean z4) {
        return this.timeline.getNextWindowIndex(i5, i6, z4);
    }

    public Timeline.Period getPeriod(int i5, Timeline.Period period, boolean z4) {
        return this.timeline.getPeriod(i5, period, z4);
    }

    public int getPeriodCount() {
        return this.timeline.getPeriodCount();
    }

    public int getPreviousWindowIndex(int i5, int i6, boolean z4) {
        return this.timeline.getPreviousWindowIndex(i5, i6, z4);
    }

    public Timeline.Window getWindow(int i5, Timeline.Window window, boolean z4, long j5) {
        return this.timeline.getWindow(i5, window, z4, j5);
    }

    public int getWindowCount() {
        return this.timeline.getWindowCount();
    }
}
