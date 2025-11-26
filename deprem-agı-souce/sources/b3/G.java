package B3;

import t3.s;

abstract /* synthetic */ class G {
    public static final int a(String str, int i5, int i6, int i7) {
        return (int) E.c(str, (long) i5, (long) i6, (long) i7);
    }

    public static final long b(String str, long j5, long j6, long j7) {
        String d5 = E.d(str);
        if (d5 == null) {
            return j5;
        }
        Long v5 = s.v(d5);
        if (v5 != null) {
            long longValue = v5.longValue();
            if (j6 <= longValue && longValue <= j7) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j6 + ".." + j7 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d5 + '\'').toString());
    }

    public static final String c(String str, String str2) {
        String d5 = E.d(str);
        if (d5 == null) {
            return str2;
        }
        return d5;
    }

    public static final boolean d(String str, boolean z4) {
        String d5 = E.d(str);
        if (d5 != null) {
            return Boolean.parseBoolean(d5);
        }
        return z4;
    }

    public static /* synthetic */ int e(String str, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            i6 = 1;
        }
        if ((i8 & 8) != 0) {
            i7 = Integer.MAX_VALUE;
        }
        return E.b(str, i5, i6, i7);
    }

    public static /* synthetic */ long f(String str, long j5, long j6, long j7, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            j6 = 1;
        }
        long j8 = j6;
        if ((i5 & 8) != 0) {
            j7 = Long.MAX_VALUE;
        }
        return E.c(str, j5, j8, j7);
    }
}
