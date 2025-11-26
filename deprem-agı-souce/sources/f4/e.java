package f4;

import e4.W;
import kotlin.jvm.internal.t;

public abstract class e {
    public static final int a(int[] iArr, int i5, int i6, int i7) {
        t.e(iArr, "<this>");
        int i8 = i7 - 1;
        while (i6 <= i8) {
            int i9 = (i6 + i8) >>> 1;
            int i10 = iArr[i9];
            if (i10 < i5) {
                i6 = i9 + 1;
            } else if (i10 <= i5) {
                return i9;
            } else {
                i8 = i9 - 1;
            }
        }
        return (-i6) - 1;
    }

    public static final int b(W w4, int i5) {
        t.e(w4, "<this>");
        int a5 = a(w4.N(), i5 + 1, 0, w4.O().length);
        if (a5 >= 0) {
            return a5;
        }
        return ~a5;
    }
}
