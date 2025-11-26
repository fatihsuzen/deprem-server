package X2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import k3.l;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.t;
import l3.C2677a;
import q3.C2729e;
import t3.s;

/* renamed from: X2.n  reason: case insensitive filesystem */
abstract class C2247n extends C2245l {

    /* renamed from: X2.n$a */
    public static final class a implements Iterable, C2677a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object[] f20070a;

        public a(Object[] objArr) {
            this.f20070a = objArr;
        }

        public Iterator iterator() {
            return C2625c.a(this.f20070a);
        }
    }

    public static Iterable H(Object[] objArr) {
        t.e(objArr, "<this>");
        if (objArr.length == 0) {
            return C2251s.g();
        }
        return new a(objArr);
    }

    public static boolean I(byte[] bArr, byte b5) {
        t.e(bArr, "<this>");
        if (U(bArr, b5) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean J(int[] iArr, int i5) {
        t.e(iArr, "<this>");
        if (V(iArr, i5) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean K(long[] jArr, long j5) {
        t.e(jArr, "<this>");
        if (W(jArr, j5) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean L(Object[] objArr, Object obj) {
        t.e(objArr, "<this>");
        if (X(objArr, obj) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean M(short[] sArr, short s5) {
        t.e(sArr, "<this>");
        if (Y(sArr, s5) >= 0) {
            return true;
        }
        return false;
    }

    public static List N(Object[] objArr, int i5) {
        t.e(objArr, "<this>");
        if (i5 >= 0) {
            return n0(objArr, C2729e.c(objArr.length - i5, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
    }

    public static List O(Object[] objArr) {
        t.e(objArr, "<this>");
        return (List) P(objArr, new ArrayList());
    }

    public static final Collection P(Object[] objArr, Collection collection) {
        t.e(objArr, "<this>");
        t.e(collection, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static int Q(int[] iArr) {
        t.e(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static int R(long[] jArr) {
        t.e(jArr, "<this>");
        return jArr.length - 1;
    }

    public static final int S(Object[] objArr) {
        t.e(objArr, "<this>");
        return objArr.length - 1;
    }

    public static Object T(Object[] objArr, int i5) {
        t.e(objArr, "<this>");
        if (i5 < 0 || i5 >= objArr.length) {
            return null;
        }
        return objArr[i5];
    }

    public static final int U(byte[] bArr, byte b5) {
        t.e(bArr, "<this>");
        int length = bArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (b5 == bArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final int V(int[] iArr, int i5) {
        t.e(iArr, "<this>");
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (i5 == iArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    public static final int W(long[] jArr, long j5) {
        t.e(jArr, "<this>");
        int length = jArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (j5 == jArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static int X(Object[] objArr, Object obj) {
        t.e(objArr, "<this>");
        int i5 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i5 < length) {
                if (objArr[i5] == null) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i5 < length2) {
            if (t.a(obj, objArr[i5])) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final int Y(short[] sArr, short s5) {
        t.e(sArr, "<this>");
        int length = sArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (s5 == sArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public static final Appendable Z(byte[] bArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar) {
        t.e(bArr, "<this>");
        t.e(appendable, "buffer");
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i6 = 0;
        for (byte b5 : bArr) {
            i6++;
            if (i6 > 1) {
                appendable.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            if (lVar != null) {
                appendable.append((CharSequence) lVar.invoke(Byte.valueOf(b5)));
            } else {
                appendable.append(String.valueOf(b5));
            }
        }
        if (i5 >= 0 && i6 > i5) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final Appendable a0(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar) {
        t.e(objArr, "<this>");
        t.e(appendable, "buffer");
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i6 = 0;
        for (Object obj : objArr) {
            i6++;
            if (i6 > 1) {
                appendable.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            s.a(appendable, obj, lVar);
        }
        if (i5 >= 0 && i6 > i5) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String b0(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar) {
        t.e(bArr, "<this>");
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(charSequence4, "truncated");
        return ((StringBuilder) Z(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
    }

    public static final String c0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar) {
        t.e(objArr, "<this>");
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(charSequence4, "truncated");
        return ((StringBuilder) a0(objArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
    }

    public static /* synthetic */ String d0(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i6 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i6 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        l lVar2 = lVar;
        int i7 = i5;
        CharSequence charSequence6 = charSequence2;
        return b0(bArr, charSequence, charSequence6, charSequence3, i7, charSequence5, lVar2);
    }

    public static /* synthetic */ String e0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i6 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i6 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        l lVar2 = lVar;
        int i7 = i5;
        CharSequence charSequence6 = charSequence2;
        return c0(objArr, charSequence, charSequence6, charSequence3, i7, charSequence5, lVar2);
    }

    public static final void f0(float[] fArr, int i5, int i6) {
        t.e(fArr, "<this>");
        C2236c.Companion.d(i5, i6, fArr.length);
        int i7 = (i5 + i6) / 2;
        if (i5 != i7) {
            int i8 = i6 - 1;
            while (i5 < i7) {
                float f5 = fArr[i5];
                fArr[i5] = fArr[i8];
                fArr[i8] = f5;
                i8--;
                i5++;
            }
        }
    }

    public static final void g0(int[] iArr, int i5, int i6) {
        t.e(iArr, "<this>");
        C2236c.Companion.d(i5, i6, iArr.length);
        int i7 = (i5 + i6) / 2;
        if (i5 != i7) {
            int i8 = i6 - 1;
            while (i5 < i7) {
                int i9 = iArr[i5];
                iArr[i5] = iArr[i8];
                iArr[i8] = i9;
                i8--;
                i5++;
            }
        }
    }

    public static final void h0(long[] jArr, int i5, int i6) {
        t.e(jArr, "<this>");
        C2236c.Companion.d(i5, i6, jArr.length);
        int i7 = (i5 + i6) / 2;
        if (i5 != i7) {
            int i8 = i6 - 1;
            while (i5 < i7) {
                long j5 = jArr[i5];
                jArr[i5] = jArr[i8];
                jArr[i8] = j5;
                i8--;
                i5++;
            }
        }
    }

    public static char i0(char[] cArr) {
        t.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static Object j0(Object[] objArr) {
        t.e(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static void k0(float[] fArr, int i5, int i6) {
        t.e(fArr, "<this>");
        C2245l.B(fArr, i5, i6);
        f0(fArr, i5, i6);
    }

    public static void l0(int[] iArr, int i5, int i6) {
        t.e(iArr, "<this>");
        C2245l.C(iArr, i5, i6);
        g0(iArr, i5, i6);
    }

    public static void m0(long[] jArr, int i5, int i6) {
        t.e(jArr, "<this>");
        C2245l.D(jArr, i5, i6);
        h0(jArr, i5, i6);
    }

    public static final List n0(Object[] objArr, int i5) {
        t.e(objArr, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
        } else if (i5 == 0) {
            return C2251s.g();
        } else {
            int length = objArr.length;
            if (i5 >= length) {
                return q0(objArr);
            }
            if (i5 == 1) {
                return r.d(objArr[length - 1]);
            }
            ArrayList arrayList = new ArrayList(i5);
            for (int i6 = length - i5; i6 < length; i6++) {
                arrayList.add(objArr[i6]);
            }
            return arrayList;
        }
    }

    public static final Collection o0(Object[] objArr, Collection collection) {
        t.e(objArr, "<this>");
        t.e(collection, "destination");
        for (Object add : objArr) {
            collection.add(add);
        }
        return collection;
    }

    public static List p0(int[] iArr) {
        t.e(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            return C2251s.g();
        }
        if (length != 1) {
            return s0(iArr);
        }
        return r.d(Integer.valueOf(iArr[0]));
    }

    public static List q0(Object[] objArr) {
        t.e(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return C2251s.g();
        }
        if (length != 1) {
            return t0(objArr);
        }
        return r.d(objArr[0]);
    }

    public static List r0(boolean[] zArr) {
        t.e(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            return C2251s.g();
        }
        if (length != 1) {
            return u0(zArr);
        }
        return r.d(Boolean.valueOf(zArr[0]));
    }

    public static final List s0(int[] iArr) {
        t.e(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }

    public static final List t0(Object[] objArr) {
        t.e(objArr, "<this>");
        return new ArrayList(C2251s.f(objArr));
    }

    public static final List u0(boolean[] zArr) {
        t.e(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean valueOf : zArr) {
            arrayList.add(Boolean.valueOf(valueOf));
        }
        return arrayList;
    }

    public static Set v0(Object[] objArr) {
        t.e(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return V.d();
        }
        if (length != 1) {
            return (Set) o0(objArr, new LinkedHashSet(O.e(objArr.length)));
        }
        return U.c(objArr[0]);
    }

    public static Iterable w0(Object[] objArr) {
        t.e(objArr, "<this>");
        return new H(new C2246m(objArr));
    }

    /* access modifiers changed from: private */
    public static final Iterator x0(Object[] objArr) {
        return C2625c.a(objArr);
    }
}
