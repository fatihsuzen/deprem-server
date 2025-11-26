package W2;

import kotlin.jvm.internal.t;
import t3.C2777a;

public abstract class L {
    public static final int a(int i5, int i6) {
        return t.g(i5 ^ Integer.MIN_VALUE, i6 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j5, long j6) {
        return t.h(j5 ^ Long.MIN_VALUE, j6 ^ Long.MIN_VALUE);
    }

    public static final String c(long j5, int i5) {
        if (j5 >= 0) {
            String l5 = Long.toString(j5, C2777a.a(i5));
            t.d(l5, "toString(...)");
            return l5;
        }
        long j6 = (long) i5;
        long j7 = ((j5 >>> 1) / j6) << 1;
        long j8 = j5 - (j7 * j6);
        if (j8 >= j6) {
            j8 -= j6;
            j7++;
        }
        StringBuilder sb = new StringBuilder();
        String l6 = Long.toString(j7, C2777a.a(i5));
        t.d(l6, "toString(...)");
        sb.append(l6);
        String l7 = Long.toString(j8, C2777a.a(i5));
        t.d(l7, "toString(...)");
        sb.append(l7);
        return sb.toString();
    }
}
