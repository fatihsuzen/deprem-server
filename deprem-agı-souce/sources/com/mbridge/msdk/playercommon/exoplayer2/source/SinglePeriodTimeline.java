package com.mbridge.msdk.playercommon.exoplayer2.source;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public final class SinglePeriodTimeline extends Timeline {
    private static final Object UID = new Object();
    private final boolean isDynamic;
    private final boolean isSeekable;
    private final long periodDurationUs;
    private final long presentationStartTimeMs;
    @Nullable
    private final Object tag;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowPositionInPeriodUs;
    private final long windowStartTimeMs;

    public SinglePeriodTimeline(long j5, boolean z4, boolean z5) {
        this(j5, z4, z5, (Object) null);
    }

    public final int getIndexOfPeriod(Object obj) {
        if (UID.equals(obj)) {
            return 0;
        }
        return -1;
    }

    public final Timeline.Period getPeriod(int i5, Timeline.Period period, boolean z4) {
        Object obj;
        Assertions.checkIndex(i5, 0, 1);
        if (z4) {
            obj = UID;
        } else {
            obj = null;
        }
        return period.set((Object) null, obj, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
    }

    public final int getPeriodCount() {
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r1 > r4) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.playercommon.exoplayer2.Timeline.Window getWindow(int r19, com.mbridge.msdk.playercommon.exoplayer2.Timeline.Window r20, boolean r21, long r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            r2 = 1
            r3 = r19
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkIndex(r3, r1, r2)
            if (r21 == 0) goto L_0x000f
            java.lang.Object r1 = r0.tag
        L_0x000d:
            r3 = r1
            goto L_0x0011
        L_0x000f:
            r1 = 0
            goto L_0x000d
        L_0x0011:
            long r1 = r0.windowDefaultStartPositionUs
            boolean r9 = r0.isDynamic
            if (r9 == 0) goto L_0x0031
            r4 = 0
            int r4 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0031
            long r4 = r0.windowDurationUs
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x002a
        L_0x0028:
            r10 = r6
            goto L_0x0032
        L_0x002a:
            long r1 = r1 + r22
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0031
            goto L_0x0028
        L_0x0031:
            r10 = r1
        L_0x0032:
            long r4 = r0.presentationStartTimeMs
            long r6 = r0.windowStartTimeMs
            boolean r8 = r0.isSeekable
            long r12 = r0.windowDurationUs
            r15 = 0
            long r1 = r0.windowPositionInPeriodUs
            r14 = 0
            r16 = r1
            r2 = r20
            com.mbridge.msdk.playercommon.exoplayer2.Timeline$Window r1 = r2.set(r3, r4, r6, r8, r9, r10, r12, r14, r15, r16)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.SinglePeriodTimeline.getWindow(int, com.mbridge.msdk.playercommon.exoplayer2.Timeline$Window, boolean, long):com.mbridge.msdk.playercommon.exoplayer2.Timeline$Window");
    }

    public final int getWindowCount() {
        return 1;
    }

    public SinglePeriodTimeline(long j5, boolean z4, boolean z5, @Nullable Object obj) {
        this(j5, j5, 0, 0, z4, z5, obj);
    }

    public SinglePeriodTimeline(long j5, long j6, long j7, long j8, boolean z4, boolean z5, @Nullable Object obj) {
        this(C.TIME_UNSET, C.TIME_UNSET, j5, j6, j7, j8, z4, z5, obj);
    }

    public SinglePeriodTimeline(long j5, long j6, long j7, long j8, long j9, long j10, boolean z4, boolean z5, @Nullable Object obj) {
        this.presentationStartTimeMs = j5;
        this.windowStartTimeMs = j6;
        this.periodDurationUs = j7;
        this.windowDurationUs = j8;
        this.windowPositionInPeriodUs = j9;
        this.windowDefaultStartPositionUs = j10;
        this.isSeekable = z4;
        this.isDynamic = z5;
        this.tag = obj;
    }
}
