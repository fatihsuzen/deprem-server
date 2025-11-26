package com.mbridge.msdk.playercommon.exoplayer2.source;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.ShuffleOrder;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public final class LoopingMediaSource extends CompositeMediaSource<Void> {
    private int childPeriodCount;
    private final MediaSource childSource;
    private final int loopCount;

    private static final class InfinitelyLoopingTimeline extends ForwardingTimeline {
        public InfinitelyLoopingTimeline(Timeline timeline) {
            super(timeline);
        }

        public final int getNextWindowIndex(int i5, int i6, boolean z4) {
            int nextWindowIndex = this.timeline.getNextWindowIndex(i5, i6, z4);
            if (nextWindowIndex == -1) {
                return getFirstWindowIndex(z4);
            }
            return nextWindowIndex;
        }

        public final int getPreviousWindowIndex(int i5, int i6, boolean z4) {
            int previousWindowIndex = this.timeline.getPreviousWindowIndex(i5, i6, z4);
            if (previousWindowIndex == -1) {
                return getLastWindowIndex(z4);
            }
            return previousWindowIndex;
        }
    }

    private static final class LoopingTimeline extends AbstractConcatenatedTimeline {
        private final int childPeriodCount;
        private final Timeline childTimeline;
        private final int childWindowCount;
        private final int loopCount;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoopingTimeline(Timeline timeline, int i5) {
            super(false, new ShuffleOrder.UnshuffledShuffleOrder(i5));
            boolean z4 = false;
            this.childTimeline = timeline;
            int periodCount = timeline.getPeriodCount();
            this.childPeriodCount = periodCount;
            this.childWindowCount = timeline.getWindowCount();
            this.loopCount = i5;
            if (periodCount > 0) {
                Assertions.checkState(i5 <= Integer.MAX_VALUE / periodCount ? true : z4, "LoopingMediaSource contains too many periods");
            }
        }

        /* access modifiers changed from: protected */
        public final int getChildIndexByChildUid(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }

        /* access modifiers changed from: protected */
        public final int getChildIndexByPeriodIndex(int i5) {
            return i5 / this.childPeriodCount;
        }

        /* access modifiers changed from: protected */
        public final int getChildIndexByWindowIndex(int i5) {
            return i5 / this.childWindowCount;
        }

        /* access modifiers changed from: protected */
        public final Object getChildUidByChildIndex(int i5) {
            return Integer.valueOf(i5);
        }

        /* access modifiers changed from: protected */
        public final int getFirstPeriodIndexByChildIndex(int i5) {
            return i5 * this.childPeriodCount;
        }

        /* access modifiers changed from: protected */
        public final int getFirstWindowIndexByChildIndex(int i5) {
            return i5 * this.childWindowCount;
        }

        public final int getPeriodCount() {
            return this.childPeriodCount * this.loopCount;
        }

        /* access modifiers changed from: protected */
        public final Timeline getTimelineByChildIndex(int i5) {
            return this.childTimeline;
        }

        public final int getWindowCount() {
            return this.childWindowCount * this.loopCount;
        }
    }

    public LoopingMediaSource(MediaSource mediaSource) {
        this(mediaSource, Integer.MAX_VALUE);
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        if (this.loopCount != Integer.MAX_VALUE) {
            return this.childSource.createPeriod(mediaPeriodId.copyWithPeriodIndex(mediaPeriodId.periodIndex % this.childPeriodCount), allocator);
        }
        return this.childSource.createPeriod(mediaPeriodId, allocator);
    }

    public final void prepareSourceInternal(ExoPlayer exoPlayer, boolean z4) {
        super.prepareSourceInternal(exoPlayer, z4);
        prepareChildSource(null, this.childSource);
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        this.childSource.releasePeriod(mediaPeriod);
    }

    public final void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.childPeriodCount = 0;
    }

    public LoopingMediaSource(MediaSource mediaSource, int i5) {
        Assertions.checkArgument(i5 > 0);
        this.childSource = mediaSource;
        this.loopCount = i5;
    }

    /* access modifiers changed from: protected */
    public final void onChildSourceInfoRefreshed(Void voidR, MediaSource mediaSource, Timeline timeline, @Nullable Object obj) {
        this.childPeriodCount = timeline.getPeriodCount();
        refreshSourceInfo(this.loopCount != Integer.MAX_VALUE ? new LoopingTimeline(timeline, this.loopCount) : new InfinitelyLoopingTimeline(timeline), obj);
    }
}
