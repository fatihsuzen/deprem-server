package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;

abstract class AbstractConcatenatedTimeline extends Timeline {
    private final int childCount;
    private final boolean isAtomic;
    private final ShuffleOrder shuffleOrder;

    public AbstractConcatenatedTimeline(boolean z4, ShuffleOrder shuffleOrder2) {
        this.isAtomic = z4;
        this.shuffleOrder = shuffleOrder2;
        this.childCount = shuffleOrder2.getLength();
    }

    private int getNextChildIndex(int i5, boolean z4) {
        if (z4) {
            return this.shuffleOrder.getNextIndex(i5);
        }
        if (i5 < this.childCount - 1) {
            return i5 + 1;
        }
        return -1;
    }

    private int getPreviousChildIndex(int i5, boolean z4) {
        if (z4) {
            return this.shuffleOrder.getPreviousIndex(i5);
        }
        if (i5 > 0) {
            return i5 - 1;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public abstract int getChildIndexByChildUid(Object obj);

    /* access modifiers changed from: protected */
    public abstract int getChildIndexByPeriodIndex(int i5);

    /* access modifiers changed from: protected */
    public abstract int getChildIndexByWindowIndex(int i5);

    /* access modifiers changed from: protected */
    public abstract Object getChildUidByChildIndex(int i5);

    /* access modifiers changed from: protected */
    public abstract int getFirstPeriodIndexByChildIndex(int i5);

    public int getFirstWindowIndex(boolean z4) {
        if (this.childCount == 0) {
            return -1;
        }
        int i5 = 0;
        if (this.isAtomic) {
            z4 = false;
        }
        if (z4) {
            i5 = this.shuffleOrder.getFirstIndex();
        }
        while (getTimelineByChildIndex(i5).isEmpty()) {
            i5 = getNextChildIndex(i5, z4);
            if (i5 == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(i5) + getTimelineByChildIndex(i5).getFirstWindowIndex(z4);
    }

    /* access modifiers changed from: protected */
    public abstract int getFirstWindowIndexByChildIndex(int i5);

    public final int getIndexOfPeriod(Object obj) {
        int indexOfPeriod;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int childIndexByChildUid = getChildIndexByChildUid(obj2);
        if (childIndexByChildUid == -1 || (indexOfPeriod = getTimelineByChildIndex(childIndexByChildUid).getIndexOfPeriod(obj3)) == -1) {
            return -1;
        }
        return getFirstPeriodIndexByChildIndex(childIndexByChildUid) + indexOfPeriod;
    }

    public int getLastWindowIndex(boolean z4) {
        int i5;
        int i6 = this.childCount;
        if (i6 == 0) {
            return -1;
        }
        if (this.isAtomic) {
            z4 = false;
        }
        if (z4) {
            i5 = this.shuffleOrder.getLastIndex();
        } else {
            i5 = i6 - 1;
        }
        while (getTimelineByChildIndex(i5).isEmpty()) {
            i5 = getPreviousChildIndex(i5, z4);
            if (i5 == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(i5) + getTimelineByChildIndex(i5).getLastWindowIndex(z4);
    }

    public int getNextWindowIndex(int i5, int i6, boolean z4) {
        int i7 = 0;
        if (this.isAtomic) {
            if (i6 == 1) {
                i6 = 2;
            }
            z4 = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i5);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        Timeline timelineByChildIndex = getTimelineByChildIndex(childIndexByWindowIndex);
        int i8 = i5 - firstWindowIndexByChildIndex;
        if (i6 != 2) {
            i7 = i6;
        }
        int nextWindowIndex = timelineByChildIndex.getNextWindowIndex(i8, i7, z4);
        if (nextWindowIndex != -1) {
            return firstWindowIndexByChildIndex + nextWindowIndex;
        }
        int nextChildIndex = getNextChildIndex(childIndexByWindowIndex, z4);
        while (nextChildIndex != -1 && getTimelineByChildIndex(nextChildIndex).isEmpty()) {
            nextChildIndex = getNextChildIndex(nextChildIndex, z4);
        }
        if (nextChildIndex != -1) {
            return getFirstWindowIndexByChildIndex(nextChildIndex) + getTimelineByChildIndex(nextChildIndex).getFirstWindowIndex(z4);
        }
        if (i6 == 2) {
            return getFirstWindowIndex(z4);
        }
        return -1;
    }

    public final Timeline.Period getPeriod(int i5, Timeline.Period period, boolean z4) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i5);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByPeriodIndex);
        getTimelineByChildIndex(childIndexByPeriodIndex).getPeriod(i5 - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex), period, z4);
        period.windowIndex += firstWindowIndexByChildIndex;
        if (z4) {
            period.uid = Pair.create(getChildUidByChildIndex(childIndexByPeriodIndex), period.uid);
        }
        return period;
    }

    public int getPreviousWindowIndex(int i5, int i6, boolean z4) {
        int i7 = 0;
        if (this.isAtomic) {
            if (i6 == 1) {
                i6 = 2;
            }
            z4 = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i5);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        Timeline timelineByChildIndex = getTimelineByChildIndex(childIndexByWindowIndex);
        int i8 = i5 - firstWindowIndexByChildIndex;
        if (i6 != 2) {
            i7 = i6;
        }
        int previousWindowIndex = timelineByChildIndex.getPreviousWindowIndex(i8, i7, z4);
        if (previousWindowIndex != -1) {
            return firstWindowIndexByChildIndex + previousWindowIndex;
        }
        int previousChildIndex = getPreviousChildIndex(childIndexByWindowIndex, z4);
        while (previousChildIndex != -1 && getTimelineByChildIndex(previousChildIndex).isEmpty()) {
            previousChildIndex = getPreviousChildIndex(previousChildIndex, z4);
        }
        if (previousChildIndex != -1) {
            return getFirstWindowIndexByChildIndex(previousChildIndex) + getTimelineByChildIndex(previousChildIndex).getLastWindowIndex(z4);
        }
        if (i6 == 2) {
            return getLastWindowIndex(z4);
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public abstract Timeline getTimelineByChildIndex(int i5);

    public final Timeline.Window getWindow(int i5, Timeline.Window window, boolean z4, long j5) {
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i5);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int firstPeriodIndexByChildIndex = getFirstPeriodIndexByChildIndex(childIndexByWindowIndex);
        Timeline.Window window2 = window;
        getTimelineByChildIndex(childIndexByWindowIndex).getWindow(i5 - firstWindowIndexByChildIndex, window2, z4, j5);
        window2.firstPeriodIndex += firstPeriodIndexByChildIndex;
        window2.lastPeriodIndex += firstPeriodIndexByChildIndex;
        return window2;
    }
}
