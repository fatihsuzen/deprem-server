package com.mbridge.msdk.playercommon.exoplayer2.util;

import com.mbridge.msdk.playercommon.exoplayer2.C;

public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    private long firstSampleTimestampUs;
    private volatile long lastSampleTimestampUs = C.TIME_UNSET;
    private long timestampOffsetUs;

    public TimestampAdjuster(long j5) {
        setFirstSampleTimestampUs(j5);
    }

    public static long ptsToUs(long j5) {
        return (j5 * 1000000) / 90000;
    }

    public static long usToPts(long j5) {
        return (j5 * 90000) / 1000000;
    }

    public final long adjustSampleTimestamp(long j5) {
        if (j5 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.lastSampleTimestampUs != C.TIME_UNSET) {
            this.lastSampleTimestampUs = j5;
        } else {
            long j6 = this.firstSampleTimestampUs;
            if (j6 != Long.MAX_VALUE) {
                this.timestampOffsetUs = j6 - j5;
            }
            synchronized (this) {
                this.lastSampleTimestampUs = j5;
                notifyAll();
            }
        }
        return j5 + this.timestampOffsetUs;
    }

    public final long adjustTsTimestamp(long j5) {
        if (j5 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.lastSampleTimestampUs != C.TIME_UNSET) {
            long usToPts = usToPts(this.lastSampleTimestampUs);
            long j6 = (4294967296L + usToPts) / MAX_PTS_PLUS_ONE;
            long j7 = ((j6 - 1) * MAX_PTS_PLUS_ONE) + j5;
            j5 += j6 * MAX_PTS_PLUS_ONE;
            if (Math.abs(j7 - usToPts) < Math.abs(j5 - usToPts)) {
                j5 = j7;
            }
        }
        return adjustSampleTimestamp(ptsToUs(j5));
    }

    public final long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public final long getLastAdjustedTimestampUs() {
        if (this.lastSampleTimestampUs != C.TIME_UNSET) {
            return this.lastSampleTimestampUs + this.timestampOffsetUs;
        }
        long j5 = this.firstSampleTimestampUs;
        if (j5 != Long.MAX_VALUE) {
            return j5;
        }
        return C.TIME_UNSET;
    }

    public final long getTimestampOffsetUs() {
        if (this.firstSampleTimestampUs == Long.MAX_VALUE) {
            return 0;
        }
        if (this.lastSampleTimestampUs == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        return this.timestampOffsetUs;
    }

    public final void reset() {
        this.lastSampleTimestampUs = C.TIME_UNSET;
    }

    public final synchronized void setFirstSampleTimestampUs(long j5) {
        boolean z4;
        if (this.lastSampleTimestampUs == C.TIME_UNSET) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.firstSampleTimestampUs = j5;
    }

    public final synchronized void waitUntilInitialized() throws InterruptedException {
        while (this.lastSampleTimestampUs == C.TIME_UNSET) {
            wait();
        }
    }
}
