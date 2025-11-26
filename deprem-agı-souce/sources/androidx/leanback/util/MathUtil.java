package androidx.leanback.util;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class MathUtil {
    private MathUtil() {
    }

    public static int safeLongToInt(long j5) {
        int i5 = (int) j5;
        if (((long) i5) == j5) {
            return i5;
        }
        throw new ArithmeticException("Input overflows int.\n");
    }
}
