package com.mbridge.msdk.playercommon.exoplayer2;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.source.ads.AdPlaybackState;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public abstract class Timeline {
    public static final Timeline EMPTY = new Timeline() {
        public final int getIndexOfPeriod(Object obj) {
            return -1;
        }

        public final Period getPeriod(int i5, Period period, boolean z4) {
            throw new IndexOutOfBoundsException();
        }

        public final int getPeriodCount() {
            return 0;
        }

        public final Window getWindow(int i5, Window window, boolean z4, long j5) {
            throw new IndexOutOfBoundsException();
        }

        public final int getWindowCount() {
            return 0;
        }
    };

    public static final class Period {
        private AdPlaybackState adPlaybackState;
        public long durationUs;
        public Object id;
        private long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        public final int getAdCountInAdGroup(int i5) {
            return this.adPlaybackState.adGroups[i5].count;
        }

        public final long getAdDurationUs(int i5, int i6) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i5];
            if (adGroup.count != -1) {
                return adGroup.durationsUs[i6];
            }
            return C.TIME_UNSET;
        }

        public final int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public final int getAdGroupIndexAfterPositionUs(long j5) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(j5);
        }

        public final int getAdGroupIndexForPositionUs(long j5) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(j5);
        }

        public final long getAdGroupTimeUs(int i5) {
            return this.adPlaybackState.adGroupTimesUs[i5];
        }

        public final long getAdResumePositionUs() {
            return this.adPlaybackState.adResumePositionUs;
        }

        public final long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public final long getDurationUs() {
            return this.durationUs;
        }

        public final int getFirstAdIndexToPlay(int i5) {
            return this.adPlaybackState.adGroups[i5].getFirstAdIndexToPlay();
        }

        public final int getNextAdIndexToPlay(int i5, int i6) {
            return this.adPlaybackState.adGroups[i5].getNextAdIndexToPlay(i6);
        }

        public final long getPositionInWindowMs() {
            return C.usToMs(this.positionInWindowUs);
        }

        public final long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public final boolean hasPlayedAdGroup(int i5) {
            return !this.adPlaybackState.adGroups[i5].hasUnplayedAds();
        }

        public final boolean isAdAvailable(int i5, int i6) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i5];
            if (adGroup.count == -1 || adGroup.states[i6] == 0) {
                return false;
            }
            return true;
        }

        public final Period set(Object obj, Object obj2, int i5, long j5, long j6) {
            return set(obj, obj2, i5, j5, j6, AdPlaybackState.NONE);
        }

        public final Period set(Object obj, Object obj2, int i5, long j5, long j6, AdPlaybackState adPlaybackState2) {
            this.id = obj;
            this.uid = obj2;
            this.windowIndex = i5;
            this.durationUs = j5;
            this.positionInWindowUs = j6;
            this.adPlaybackState = adPlaybackState2;
            return this;
        }
    }

    public static final class Window {
        public long defaultPositionUs;
        public long durationUs;
        public int firstPeriodIndex;
        public boolean isDynamic;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        @Nullable
        public Object tag;
        public long windowStartTimeMs;

        public final long getDefaultPositionMs() {
            return C.usToMs(this.defaultPositionUs);
        }

        public final long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public final long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public final long getDurationUs() {
            return this.durationUs;
        }

        public final long getPositionInFirstPeriodMs() {
            return C.usToMs(this.positionInFirstPeriodUs);
        }

        public final long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public final Window set(@Nullable Object obj, long j5, long j6, boolean z4, boolean z5, long j7, long j8, int i5, int i6, long j9) {
            this.tag = obj;
            this.presentationStartTimeMs = j5;
            this.windowStartTimeMs = j6;
            this.isSeekable = z4;
            this.isDynamic = z5;
            this.defaultPositionUs = j7;
            this.durationUs = j8;
            this.firstPeriodIndex = i5;
            this.lastPeriodIndex = i6;
            this.positionInFirstPeriodUs = j9;
            return this;
        }
    }

    public int getFirstWindowIndex(boolean z4) {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    public abstract int getIndexOfPeriod(Object obj);

    public int getLastWindowIndex(boolean z4) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int i5, Period period, Window window, int i6, boolean z4) {
        int i7 = getPeriod(i5, period).windowIndex;
        if (getWindow(i7, window).lastPeriodIndex != i5) {
            return i5 + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i7, i6, z4);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window).firstPeriodIndex;
    }

    public int getNextWindowIndex(int i5, int i6, boolean z4) {
        if (i6 != 0) {
            if (i6 == 1) {
                return i5;
            }
            if (i6 != 2) {
                throw new IllegalStateException();
            } else if (i5 == getLastWindowIndex(z4)) {
                return getFirstWindowIndex(z4);
            } else {
                return i5 + 1;
            }
        } else if (i5 == getLastWindowIndex(z4)) {
            return -1;
        } else {
            return i5 + 1;
        }
    }

    public final Period getPeriod(int i5, Period period) {
        return getPeriod(i5, period, false);
    }

    public abstract Period getPeriod(int i5, Period period, boolean z4);

    public abstract int getPeriodCount();

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i5, long j5) {
        return getPeriodPosition(window, period, i5, j5, 0);
    }

    public int getPreviousWindowIndex(int i5, int i6, boolean z4) {
        if (i6 != 0) {
            if (i6 == 1) {
                return i5;
            }
            if (i6 != 2) {
                throw new IllegalStateException();
            } else if (i5 == getFirstWindowIndex(z4)) {
                return getLastWindowIndex(z4);
            } else {
                return i5 - 1;
            }
        } else if (i5 == getFirstWindowIndex(z4)) {
            return -1;
        } else {
            return i5 - 1;
        }
    }

    public final Window getWindow(int i5, Window window) {
        return getWindow(i5, window, false);
    }

    public abstract Window getWindow(int i5, Window window, boolean z4, long j5);

    public abstract int getWindowCount();

    public final boolean isEmpty() {
        if (getWindowCount() == 0) {
            return true;
        }
        return false;
    }

    public final boolean isLastPeriod(int i5, Period period, Window window, int i6, boolean z4) {
        if (getNextPeriodIndex(i5, period, window, i6, z4) == -1) {
            return true;
        }
        return false;
    }

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i5, long j5, long j6) {
        Assertions.checkIndex(i5, 0, getWindowCount());
        Window window2 = window;
        getWindow(i5, window2, false, j6);
        if (j5 == C.TIME_UNSET) {
            j5 = window2.getDefaultPositionUs();
            if (j5 == C.TIME_UNSET) {
                return null;
            }
        }
        int i6 = window2.firstPeriodIndex;
        long positionInFirstPeriodUs = window2.getPositionInFirstPeriodUs() + j5;
        long durationUs = getPeriod(i6, period).getDurationUs();
        while (durationUs != C.TIME_UNSET && positionInFirstPeriodUs >= durationUs && i6 < window2.lastPeriodIndex) {
            positionInFirstPeriodUs -= durationUs;
            i6++;
            durationUs = getPeriod(i6, period).getDurationUs();
        }
        return Pair.create(Integer.valueOf(i6), Long.valueOf(positionInFirstPeriodUs));
    }

    public final Window getWindow(int i5, Window window, boolean z4) {
        return getWindow(i5, window, z4, 0);
    }
}
