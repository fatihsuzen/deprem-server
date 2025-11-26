package t3;

/* renamed from: t3.L  reason: case insensitive filesystem */
public abstract /* synthetic */ class C2775L {
    public static /* synthetic */ long a(long j5, long j6) {
        if (j6 < 0) {
            if ((j5 ^ Long.MIN_VALUE) < (j6 ^ Long.MIN_VALUE)) {
                return 0;
            }
            return 1;
        } else if (j5 >= 0) {
            return j5 / j6;
        } else {
            int i5 = 1;
            long j7 = ((j5 >>> 1) / j6) << 1;
            if (((j5 - (j7 * j6)) ^ Long.MIN_VALUE) < (j6 ^ Long.MIN_VALUE)) {
                i5 = 0;
            }
            return j7 + ((long) i5);
        }
    }
}
