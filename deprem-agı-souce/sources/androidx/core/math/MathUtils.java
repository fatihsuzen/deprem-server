package androidx.core.math;

public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int i5, int i6) {
        int i7 = i5 + i6;
        boolean z4 = false;
        if ((i5 >= 0) == (i6 >= 0)) {
            boolean z5 = i5 >= 0;
            if (i7 >= 0) {
                z4 = true;
            }
            if (z5 != z4) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i7;
    }

    public static double clamp(double d5, double d6, double d7) {
        if (d5 < d6) {
            return d6;
        }
        return d5 > d7 ? d7 : d5;
    }

    public static int decrementExact(int i5) {
        if (i5 != Integer.MIN_VALUE) {
            return i5 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i5) {
        if (i5 != Integer.MAX_VALUE) {
            return i5 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i5, int i6) {
        int i7 = i5 * i6;
        if (i5 == 0 || i6 == 0 || (i7 / i5 == i6 && i7 / i6 == i5)) {
            return i7;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i5) {
        if (i5 != Integer.MIN_VALUE) {
            return -i5;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i5, int i6) {
        int i7 = i5 - i6;
        boolean z4 = false;
        if ((i5 < 0) != (i6 < 0)) {
            boolean z5 = i5 < 0;
            if (i7 < 0) {
                z4 = true;
            }
            if (z5 != z4) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i7;
    }

    public static int toIntExact(long j5) {
        if (j5 <= 2147483647L && j5 >= -2147483648L) {
            return (int) j5;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long addExact(long j5, long j6) {
        long j7 = j5 + j6;
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        boolean z4 = false;
        if ((i5 >= 0) == (j6 >= 0)) {
            boolean z5 = i5 >= 0;
            if (j7 >= 0) {
                z4 = true;
            }
            if (z5 != z4) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j7;
    }

    public static float clamp(float f5, float f6, float f7) {
        if (f5 < f6) {
            return f6;
        }
        return f5 > f7 ? f7 : f5;
    }

    public static long decrementExact(long j5) {
        if (j5 != Long.MIN_VALUE) {
            return j5 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j5) {
        if (j5 != Long.MAX_VALUE) {
            return j5 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j5) {
        if (j5 != Long.MIN_VALUE) {
            return -j5;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j5, long j6) {
        long j7 = j5 - j6;
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        boolean z4 = false;
        if ((i5 < 0) != (j6 < 0)) {
            boolean z5 = i5 < 0;
            if (j7 < 0) {
                z4 = true;
            }
            if (z5 != z4) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j7;
    }

    public static int clamp(int i5, int i6, int i7) {
        if (i5 < i6) {
            return i6;
        }
        return i5 > i7 ? i7 : i5;
    }

    public static long multiplyExact(long j5, long j6) {
        long j7 = j5 * j6;
        if (j5 == 0 || j6 == 0 || (j7 / j5 == j6 && j7 / j6 == j5)) {
            return j7;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long j5, long j6, long j7) {
        if (j5 < j6) {
            return j6;
        }
        return j5 > j7 ? j7 : j5;
    }
}
