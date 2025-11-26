package Z2;

import W2.A;
import W2.C;
import W2.E;
import W2.H;
import X2.C2250q;
import java.util.Arrays;
import k3.l;

abstract class c extends b {
    public static boolean a(short[] sArr, short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    public static boolean b(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    public static boolean c(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    public static boolean d(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    public static String e(byte[] bArr) {
        String V4;
        if (bArr == null || (V4 = C2250q.V(A.c(bArr), ", ", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null)) == null) {
            return "null";
        }
        return V4;
    }

    public static String f(int[] iArr) {
        String V4;
        if (iArr == null || (V4 = C2250q.V(C.c(iArr), ", ", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null)) == null) {
            return "null";
        }
        return V4;
    }

    public static String g(short[] sArr) {
        String V4;
        if (sArr == null || (V4 = C2250q.V(H.c(sArr), ", ", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null)) == null) {
            return "null";
        }
        return V4;
    }

    public static String h(long[] jArr) {
        String V4;
        if (jArr == null || (V4 = C2250q.V(E.c(jArr), ", ", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null)) == null) {
            return "null";
        }
        return V4;
    }
}
