package X2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.t;

/* renamed from: X2.l  reason: case insensitive filesystem */
abstract class C2245l extends C2244k {
    public static /* synthetic */ void A(boolean[] zArr, boolean z4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = zArr.length;
        }
        w(zArr, z4, i5, i6);
    }

    public static void B(float[] fArr, int i5, int i6) {
        t.e(fArr, "<this>");
        Arrays.sort(fArr, i5, i6);
    }

    public static void C(int[] iArr, int i5, int i6) {
        t.e(iArr, "<this>");
        Arrays.sort(iArr, i5, i6);
    }

    public static void D(long[] jArr, int i5, int i6) {
        t.e(jArr, "<this>");
        Arrays.sort(jArr, i5, i6);
    }

    public static final void E(Object[] objArr) {
        t.e(objArr, "<this>");
        if (objArr.length > 1) {
            Arrays.sort(objArr);
        }
    }

    public static final void F(Object[] objArr, Comparator comparator) {
        t.e(objArr, "<this>");
        t.e(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }

    public static List g(Object[] objArr) {
        t.e(objArr, "<this>");
        List a5 = C2248o.a(objArr);
        t.d(a5, "asList(...)");
        return a5;
    }

    public static byte[] h(byte[] bArr, byte[] bArr2, int i5, int i6, int i7) {
        t.e(bArr, "<this>");
        t.e(bArr2, "destination");
        System.arraycopy(bArr, i6, bArr2, i5, i7 - i6);
        return bArr2;
    }

    public static float[] i(float[] fArr, float[] fArr2, int i5, int i6, int i7) {
        t.e(fArr, "<this>");
        t.e(fArr2, "destination");
        System.arraycopy(fArr, i6, fArr2, i5, i7 - i6);
        return fArr2;
    }

    public static int[] j(int[] iArr, int[] iArr2, int i5, int i6, int i7) {
        t.e(iArr, "<this>");
        t.e(iArr2, "destination");
        System.arraycopy(iArr, i6, iArr2, i5, i7 - i6);
        return iArr2;
    }

    public static long[] k(long[] jArr, long[] jArr2, int i5, int i6, int i7) {
        t.e(jArr, "<this>");
        t.e(jArr2, "destination");
        System.arraycopy(jArr, i6, jArr2, i5, i7 - i6);
        return jArr2;
    }

    public static Object[] l(Object[] objArr, Object[] objArr2, int i5, int i6, int i7) {
        t.e(objArr, "<this>");
        t.e(objArr2, "destination");
        System.arraycopy(objArr, i6, objArr2, i5, i7 - i6);
        return objArr2;
    }

    public static /* synthetic */ byte[] m(byte[] bArr, byte[] bArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = bArr.length;
        }
        return h(bArr, bArr2, i5, i6, i7);
    }

    public static /* synthetic */ float[] n(float[] fArr, float[] fArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = fArr.length;
        }
        return i(fArr, fArr2, i5, i6, i7);
    }

    public static /* synthetic */ int[] o(int[] iArr, int[] iArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = iArr.length;
        }
        return j(iArr, iArr2, i5, i6, i7);
    }

    public static /* synthetic */ long[] p(long[] jArr, long[] jArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = jArr.length;
        }
        return k(jArr, jArr2, i5, i6, i7);
    }

    public static /* synthetic */ Object[] q(Object[] objArr, Object[] objArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = objArr.length;
        }
        return l(objArr, objArr2, i5, i6, i7);
    }

    public static byte[] r(byte[] bArr, int i5, int i6) {
        t.e(bArr, "<this>");
        C2243j.c(i6, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i5, i6);
        t.d(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static Object[] s(Object[] objArr, int i5, int i6) {
        t.e(objArr, "<this>");
        C2243j.c(i6, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i5, i6);
        t.d(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static final void t(int[] iArr, int i5, int i6, int i7) {
        t.e(iArr, "<this>");
        Arrays.fill(iArr, i6, i7, i5);
    }

    public static final void u(long[] jArr, long j5, int i5, int i6) {
        t.e(jArr, "<this>");
        Arrays.fill(jArr, i5, i6, j5);
    }

    public static void v(Object[] objArr, Object obj, int i5, int i6) {
        t.e(objArr, "<this>");
        Arrays.fill(objArr, i5, i6, obj);
    }

    public static final void w(boolean[] zArr, boolean z4, int i5, int i6) {
        t.e(zArr, "<this>");
        Arrays.fill(zArr, i5, i6, z4);
    }

    public static /* synthetic */ void x(int[] iArr, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = iArr.length;
        }
        t(iArr, i5, i6, i7);
    }

    public static /* synthetic */ void y(long[] jArr, long j5, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = jArr.length;
        }
        u(jArr, j5, i5, i6);
    }

    public static /* synthetic */ void z(Object[] objArr, Object obj, int i5, int i6, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = objArr.length;
        }
        v(objArr, obj, i5, i6);
    }
}
