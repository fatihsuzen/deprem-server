package N3;

import t3.C2775L;

/* renamed from: N3.n  reason: case insensitive filesystem */
public abstract /* synthetic */ class C2144n {
    public static /* synthetic */ String a(long j5, int i5) {
        long j6;
        int i6 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i6 == 0) {
            return "0";
        }
        if (i6 > 0) {
            return Long.toString(j5, i5);
        }
        if (i5 < 2 || i5 > 36) {
            i5 = 10;
        }
        int i7 = 64;
        char[] cArr = new char[64];
        int i8 = i5 - 1;
        if ((i5 & i8) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i5);
            do {
                i7--;
                cArr[i7] = Character.forDigit(((int) j5) & i8, i5);
                j5 >>>= numberOfTrailingZeros;
            } while (j5 != 0);
        } else {
            if ((i5 & 1) == 0) {
                j6 = (j5 >>> 1) / ((long) (i5 >>> 1));
            } else {
                j6 = C2775L.a(j5, (long) i5);
            }
            long j7 = (long) i5;
            cArr[63] = Character.forDigit((int) (j5 - (j6 * j7)), i5);
            i7 = 63;
            while (j6 > 0) {
                i7--;
                cArr[i7] = Character.forDigit((int) (j6 % j7), i5);
                j6 /= j7;
            }
        }
        return new String(cArr, i7, 64 - i7);
    }
}
