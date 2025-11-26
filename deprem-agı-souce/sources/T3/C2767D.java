package t3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import kotlin.jvm.internal.t;

/* renamed from: t3.D  reason: case insensitive filesystem */
abstract class C2767D extends C2766C {
    public static final Void s(String str) {
        t.e(str, "input");
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }

    public static Integer t(String str) {
        t.e(str, "<this>");
        return u(str, 10);
    }

    public static final Integer u(String str, int i5) {
        int i6;
        boolean z4;
        int i7;
        t.e(str, "<this>");
        C2778b.a(i5);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i8 = 0;
        char charAt = str.charAt(0);
        int i9 = -2147483647;
        if (t.g(charAt, 48) < 0) {
            i6 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z4 = false;
            } else if (charAt != '-') {
                return null;
            } else {
                i9 = Integer.MIN_VALUE;
                z4 = true;
            }
        } else {
            z4 = false;
            i6 = 0;
        }
        int i10 = -59652323;
        while (i6 < length) {
            int b5 = C2778b.b(str.charAt(i6), i5);
            if (b5 < 0) {
                return null;
            }
            if ((i8 < i10 && (i10 != -59652323 || i8 < (i10 = i9 / i5))) || (i7 = i8 * i5) < i9 + b5) {
                return null;
            }
            i8 = i7 - b5;
            i6++;
        }
        if (z4) {
            return Integer.valueOf(i8);
        }
        return Integer.valueOf(-i8);
    }

    public static Long v(String str) {
        t.e(str, "<this>");
        return w(str, 10);
    }

    public static final Long w(String str, int i5) {
        boolean z4;
        String str2 = str;
        int i6 = i5;
        t.e(str2, "<this>");
        C2778b.a(i6);
        int length = str2.length();
        Long l5 = null;
        if (length == 0) {
            return null;
        }
        int i7 = 0;
        char charAt = str2.charAt(0);
        int g5 = t.g(charAt, 48);
        long j5 = C.TIME_UNSET;
        if (g5 < 0) {
            z4 = true;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z4 = false;
                i7 = 1;
            } else if (charAt != '-') {
                return null;
            } else {
                j5 = Long.MIN_VALUE;
                i7 = 1;
            }
        } else {
            z4 = false;
        }
        long j6 = 0;
        long j7 = -256204778801521550L;
        while (i7 < length) {
            int b5 = C2778b.b(str2.charAt(i7), i6);
            if (b5 < 0) {
                return l5;
            }
            if (j6 < j7) {
                if (j7 != -256204778801521550L) {
                    return l5;
                }
                j7 = j5 / ((long) i6);
                if (j6 < j7) {
                    return l5;
                }
            }
            Long l6 = l5;
            int i8 = i7;
            long j8 = j6 * ((long) i6);
            long j9 = (long) b5;
            if (j8 < j5 + j9) {
                return l6;
            }
            j6 = j8 - j9;
            i7 = i8 + 1;
            l5 = l6;
        }
        if (z4) {
            return Long.valueOf(j6);
        }
        return Long.valueOf(-j6);
    }
}
