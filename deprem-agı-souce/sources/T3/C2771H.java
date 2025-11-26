package t3;

import W2.s;
import W2.y;
import X2.C2242i;
import X2.C2250q;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import q3.C2726b;
import q3.C2728d;
import q3.C2729e;
import s3.C2751e;
import s3.C2754h;

/* renamed from: t3.H  reason: case insensitive filesystem */
abstract class C2771H extends C2768E {

    /* renamed from: t3.H$a */
    public static final class a implements C2751e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CharSequence f25886a;

        public a(CharSequence charSequence) {
            this.f25886a = charSequence;
        }

        public Iterator iterator() {
            return new C2785i(this.f25886a);
        }
    }

    public static String A0(String str, CharSequence charSequence) {
        t.e(str, "<this>");
        t.e(charSequence, "suffix");
        if (!X(str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        t.d(substring, "substring(...)");
        return substring;
    }

    public static final void B0(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i5).toString());
        }
    }

    public static final List C0(CharSequence charSequence, char[] cArr, boolean z4, int i5) {
        t.e(charSequence, "<this>");
        t.e(cArr, "delimiters");
        if (cArr.length == 1) {
            return E0(charSequence, String.valueOf(cArr[0]), z4, i5);
        }
        CharSequence charSequence2 = charSequence;
        Iterable<C2728d> j5 = C2754h.j(v0(charSequence2, cArr, 0, z4, i5, 2, (Object) null));
        ArrayList arrayList = new ArrayList(C2250q.p(j5, 10));
        for (C2728d J02 : j5) {
            arrayList.add(J0(charSequence2, J02));
        }
        return arrayList;
    }

    public static final List D0(CharSequence charSequence, String[] strArr, boolean z4, int i5) {
        t.e(charSequence, "<this>");
        t.e(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return E0(charSequence, str, z4, i5);
            }
        }
        CharSequence charSequence2 = charSequence;
        Iterable<C2728d> j5 = C2754h.j(w0(charSequence2, strArr, 0, z4, i5, 2, (Object) null));
        ArrayList arrayList = new ArrayList(C2250q.p(j5, 10));
        for (C2728d J02 : j5) {
            arrayList.add(J0(charSequence2, J02));
        }
        return arrayList;
    }

    private static final List E0(CharSequence charSequence, String str, boolean z4, int i5) {
        boolean z5;
        B0(i5);
        int i6 = 0;
        int b02 = b0(charSequence, str, 0, z4);
        if (b02 == -1 || i5 == 1) {
            return C2250q.d(charSequence.toString());
        }
        if (i5 > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        int i7 = 10;
        if (z5) {
            i7 = C2729e.e(i5, 10);
        }
        ArrayList arrayList = new ArrayList(i7);
        do {
            arrayList.add(charSequence.subSequence(i6, b02).toString());
            i6 = str.length() + b02;
            if ((z5 && arrayList.size() == i5 - 1) || (b02 = b0(charSequence, str, i6, z4)) == -1) {
                arrayList.add(charSequence.subSequence(i6, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i6, b02).toString());
            i6 = str.length() + b02;
            break;
        } while ((b02 = b0(charSequence, str, i6, z4)) == -1);
        arrayList.add(charSequence.subSequence(i6, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List F0(CharSequence charSequence, char[] cArr, boolean z4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z4 = false;
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        return C0(charSequence, cArr, z4, i5);
    }

    public static /* synthetic */ List G0(CharSequence charSequence, String[] strArr, boolean z4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z4 = false;
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        return D0(charSequence, strArr, z4, i5);
    }

    public static final boolean H0(CharSequence charSequence, char c5, boolean z4) {
        t.e(charSequence, "<this>");
        if (charSequence.length() <= 0 || !C2779c.f(charSequence.charAt(0), c5, z4)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean I0(CharSequence charSequence, char c5, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        return H0(charSequence, c5, z4);
    }

    public static final String J0(CharSequence charSequence, C2728d dVar) {
        t.e(charSequence, "<this>");
        t.e(dVar, "range");
        return charSequence.subSequence(dVar.getStart().intValue(), dVar.getEndInclusive().intValue() + 1).toString();
    }

    public static final String K0(String str, C2728d dVar) {
        t.e(str, "<this>");
        t.e(dVar, "range");
        String substring = str.substring(dVar.getStart().intValue(), dVar.getEndInclusive().intValue() + 1);
        t.d(substring, "substring(...)");
        return substring;
    }

    public static String L0(String str, char c5, String str2) {
        t.e(str, "<this>");
        t.e(str2, "missingDelimiterValue");
        String str3 = str;
        int e02 = e0(str3, c5, 0, false, 6, (Object) null);
        if (e02 == -1) {
            return str2;
        }
        String substring = str3.substring(e02 + 1, str3.length());
        t.d(substring, "substring(...)");
        return substring;
    }

    public static final String M0(String str, String str2, String str3) {
        t.e(str, "<this>");
        t.e(str2, "delimiter");
        t.e(str3, "missingDelimiterValue");
        String str4 = str;
        String str5 = str2;
        int f02 = f0(str4, str5, 0, false, 6, (Object) null);
        if (f02 == -1) {
            return str3;
        }
        String substring = str4.substring(f02 + str5.length(), str4.length());
        t.d(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String N0(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return L0(str, c5, str2);
    }

    public static /* synthetic */ String O0(String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str3 = str;
        }
        return M0(str, str2, str3);
    }

    public static String P0(String str, char c5, String str2) {
        t.e(str, "<this>");
        t.e(str2, "missingDelimiterValue");
        String str3 = str;
        int k02 = k0(str3, c5, 0, false, 6, (Object) null);
        if (k02 == -1) {
            return str2;
        }
        String substring = str3.substring(k02 + 1, str3.length());
        t.d(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String Q0(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return P0(str, c5, str2);
    }

    public static final String R0(String str, char c5, String str2) {
        t.e(str, "<this>");
        t.e(str2, "missingDelimiterValue");
        String str3 = str;
        int e02 = e0(str3, c5, 0, false, 6, (Object) null);
        if (e02 == -1) {
            return str2;
        }
        String substring = str3.substring(0, e02);
        t.d(substring, "substring(...)");
        return substring;
    }

    public static final boolean S(CharSequence charSequence, char c5, boolean z4) {
        t.e(charSequence, "<this>");
        if (e0(charSequence, c5, 0, z4, 2, (Object) null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ String S0(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return R0(str, c5, str2);
    }

    public static boolean T(CharSequence charSequence, CharSequence charSequence2, boolean z4) {
        t.e(charSequence, "<this>");
        t.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (f0(charSequence, (String) charSequence2, 0, z4, 2, (Object) null) >= 0) {
                return true;
            }
            return false;
        }
        CharSequence charSequence3 = charSequence;
        if (d0(charSequence3, charSequence2, 0, charSequence3.length(), z4, false, 16, (Object) null) >= 0) {
            return true;
        }
        return false;
    }

    public static final String T0(String str, String str2, String str3) {
        t.e(str, "<this>");
        t.e(str2, "delimiter");
        t.e(str3, "missingDelimiterValue");
        String str4 = str;
        int l02 = l0(str4, str2, 0, false, 6, (Object) null);
        if (l02 == -1) {
            return str3;
        }
        String substring = str4.substring(0, l02);
        t.d(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ boolean U(CharSequence charSequence, char c5, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        return S(charSequence, c5, z4);
    }

    public static /* synthetic */ String U0(String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str3 = str;
        }
        return T0(str, str2, str3);
    }

    public static /* synthetic */ boolean V(CharSequence charSequence, CharSequence charSequence2, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        return T(charSequence, charSequence2, z4);
    }

    public static Boolean V0(String str) {
        t.e(str, "<this>");
        if (t.a(str, "true")) {
            return Boolean.TRUE;
        }
        if (t.a(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static final boolean W(CharSequence charSequence, CharSequence charSequence2, boolean z4) {
        t.e(charSequence, "<this>");
        t.e(charSequence2, "suffix");
        if (!z4 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return C2768E.D((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return z0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z4);
    }

    public static CharSequence W0(CharSequence charSequence) {
        int i5;
        t.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i6 = 0;
        boolean z4 = false;
        while (i6 <= length) {
            if (!z4) {
                i5 = i6;
            } else {
                i5 = length;
            }
            boolean c5 = C2778b.c(charSequence.charAt(i5));
            if (!z4) {
                if (!c5) {
                    z4 = true;
                } else {
                    i6++;
                }
            } else if (!c5) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i6, length + 1);
    }

    public static /* synthetic */ boolean X(CharSequence charSequence, CharSequence charSequence2, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        return W(charSequence, charSequence2, z4);
    }

    private static final s Y(CharSequence charSequence, Collection collection, int i5, boolean z4, boolean z5) {
        C2726b bVar;
        CharSequence charSequence2;
        Object obj;
        boolean z6;
        Object obj2;
        int i6;
        if (z4 || collection.size() != 1) {
            CharSequence charSequence3 = charSequence;
            int i7 = i5;
            if (!z5) {
                bVar = new C2728d(C2729e.c(i7, 0), charSequence3.length());
            } else {
                bVar = C2729e.j(C2729e.e(i7, Z(charSequence3)), 0);
            }
            if (charSequence3 instanceof String) {
                int c5 = bVar.c();
                int f5 = bVar.f();
                int g5 = bVar.g();
                if ((g5 > 0 && c5 <= f5) || (g5 < 0 && f5 <= c5)) {
                    int i8 = c5;
                    while (true) {
                        Iterator it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z6 = z4;
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            z6 = z4;
                            if (C2768E.G(str, 0, (String) charSequence3, i8, str.length(), z6)) {
                                break;
                            }
                            z4 = z6;
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (i8 == f5) {
                                break;
                            }
                            i8 += g5;
                            z4 = z6;
                        } else {
                            return y.a(Integer.valueOf(i8), str2);
                        }
                    }
                }
            } else {
                boolean z7 = z4;
                int c6 = bVar.c();
                int f6 = bVar.f();
                int g6 = bVar.g();
                if ((g6 > 0 && c6 <= f6) || (g6 < 0 && f6 <= c6)) {
                    int i9 = c6;
                    while (true) {
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                charSequence2 = charSequence3;
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            boolean z8 = z7;
                            charSequence2 = charSequence3;
                            z7 = z8;
                            if (z0(str3, 0, charSequence2, i9, str3.length(), z8)) {
                                break;
                            }
                            charSequence3 = charSequence2;
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (i9 == f6) {
                                break;
                            }
                            i9 += g6;
                            charSequence3 = charSequence2;
                        } else {
                            return y.a(Integer.valueOf(i9), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) C2250q.d0(collection);
        if (!z5) {
            i6 = f0(charSequence, str5, i5, false, 4, (Object) null);
        } else {
            i6 = l0(charSequence, str5, i5, false, 4, (Object) null);
        }
        if (i6 < 0) {
            return null;
        }
        return y.a(Integer.valueOf(i6), str5);
    }

    public static int Z(CharSequence charSequence) {
        t.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int a0(CharSequence charSequence, char c5, int i5, boolean z4) {
        t.e(charSequence, "<this>");
        if (!z4 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c5, i5);
        }
        return g0(charSequence, new char[]{c5}, i5, z4);
    }

    public static final int b0(CharSequence charSequence, String str, int i5, boolean z4) {
        t.e(charSequence, "<this>");
        t.e(str, TypedValues.Custom.S_STRING);
        if (!z4 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i5);
        }
        return d0(charSequence, str, i5, charSequence.length(), z4, false, 16, (Object) null);
    }

    private static final int c0(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, boolean z4, boolean z5) {
        C2726b bVar;
        if (!z5) {
            bVar = new C2728d(C2729e.c(i5, 0), C2729e.e(i6, charSequence.length()));
        } else {
            bVar = C2729e.j(C2729e.e(i5, Z(charSequence)), C2729e.c(i6, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            boolean z6 = z4;
            int c5 = bVar.c();
            int f5 = bVar.f();
            int g5 = bVar.g();
            if ((g5 <= 0 || c5 > f5) && (g5 >= 0 || f5 > c5)) {
                return -1;
            }
            int i7 = c5;
            while (true) {
                boolean z7 = z6;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z6 = z7;
                if (z0(charSequence4, 0, charSequence3, i7, charSequence2.length(), z7)) {
                    return i7;
                }
                if (i7 == f5) {
                    return -1;
                }
                i7 += g5;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        } else {
            int c6 = bVar.c();
            int f6 = bVar.f();
            int g6 = bVar.g();
            if ((g6 <= 0 || c6 > f6) && (g6 >= 0 || f6 > c6)) {
                return -1;
            }
            int i8 = c6;
            while (true) {
                String str = (String) charSequence2;
                boolean z8 = z4;
                if (C2768E.G(str, 0, (String) charSequence, i8, str.length(), z8)) {
                    return i8;
                }
                if (i8 == f6) {
                    return -1;
                }
                i8 += g6;
                z4 = z8;
            }
        }
    }

    static /* synthetic */ int d0(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, boolean z4, boolean z5, int i7, Object obj) {
        if ((i7 & 16) != 0) {
            z5 = false;
        }
        return c0(charSequence, charSequence2, i5, i6, z4, z5);
    }

    public static /* synthetic */ int e0(CharSequence charSequence, char c5, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return a0(charSequence, c5, i5, z4);
    }

    public static /* synthetic */ int f0(CharSequence charSequence, String str, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return b0(charSequence, str, i5, z4);
    }

    public static final int g0(CharSequence charSequence, char[] cArr, int i5, boolean z4) {
        t.e(charSequence, "<this>");
        t.e(cArr, "chars");
        if (z4 || cArr.length != 1 || !(charSequence instanceof String)) {
            int c5 = C2729e.c(i5, 0);
            int Z4 = Z(charSequence);
            if (c5 > Z4) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(c5);
                for (char f5 : cArr) {
                    if (C2779c.f(f5, charAt, z4)) {
                        return c5;
                    }
                }
                if (c5 == Z4) {
                    return -1;
                }
                c5++;
            }
        } else {
            return ((String) charSequence).indexOf(C2242i.i0(cArr), i5);
        }
    }

    public static boolean h0(CharSequence charSequence) {
        t.e(charSequence, "<this>");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            if (!C2778b.c(charSequence.charAt(i5))) {
                return false;
            }
        }
        return true;
    }

    public static final int i0(CharSequence charSequence, char c5, int i5, boolean z4) {
        t.e(charSequence, "<this>");
        if (!z4 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c5, i5);
        }
        return m0(charSequence, new char[]{c5}, i5, z4);
    }

    public static final int j0(CharSequence charSequence, String str, int i5, boolean z4) {
        t.e(charSequence, "<this>");
        t.e(str, TypedValues.Custom.S_STRING);
        if (z4 || !(charSequence instanceof String)) {
            return c0(charSequence, str, i5, 0, z4, true);
        }
        return ((String) charSequence).lastIndexOf(str, i5);
    }

    public static /* synthetic */ int k0(CharSequence charSequence, char c5, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = Z(charSequence);
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return i0(charSequence, c5, i5, z4);
    }

    public static /* synthetic */ int l0(CharSequence charSequence, String str, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = Z(charSequence);
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return j0(charSequence, str, i5, z4);
    }

    public static final int m0(CharSequence charSequence, char[] cArr, int i5, boolean z4) {
        t.e(charSequence, "<this>");
        t.e(cArr, "chars");
        if (z4 || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int e5 = C2729e.e(i5, Z(charSequence)); -1 < e5; e5--) {
                char charAt = charSequence.charAt(e5);
                for (char f5 : cArr) {
                    if (C2779c.f(f5, charAt, z4)) {
                        return e5;
                    }
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(C2242i.i0(cArr), i5);
    }

    public static final C2751e n0(CharSequence charSequence) {
        t.e(charSequence, "<this>");
        return new a(charSequence);
    }

    public static List o0(CharSequence charSequence) {
        t.e(charSequence, "<this>");
        return C2754h.x(n0(charSequence));
    }

    public static final CharSequence p0(CharSequence charSequence, int i5, char c5) {
        t.e(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException("Desired length " + i5 + " is less than zero.");
        } else if (i5 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i5);
            sb.append(charSequence);
            int length = i5 - charSequence.length();
            int i6 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c5);
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                }
            }
            return sb;
        }
    }

    public static String q0(String str, int i5, char c5) {
        t.e(str, "<this>");
        return p0(str, i5, c5).toString();
    }

    public static final CharSequence r0(CharSequence charSequence, int i5, char c5) {
        t.e(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException("Desired length " + i5 + " is less than zero.");
        } else if (i5 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i5);
            int length = i5 - charSequence.length();
            int i6 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c5);
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
    }

    public static String s0(String str, int i5, char c5) {
        t.e(str, "<this>");
        return r0(str, i5, c5).toString();
    }

    private static final C2751e t0(CharSequence charSequence, char[] cArr, int i5, boolean z4, int i6) {
        B0(i6);
        return new C2781e(charSequence, i5, i6, new C2769F(cArr, z4));
    }

    private static final C2751e u0(CharSequence charSequence, String[] strArr, int i5, boolean z4, int i6) {
        B0(i6);
        return new C2781e(charSequence, i5, i6, new C2770G(C2242i.g(strArr), z4));
    }

    static /* synthetic */ C2751e v0(CharSequence charSequence, char[] cArr, int i5, boolean z4, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            z4 = false;
        }
        if ((i7 & 8) != 0) {
            i6 = 0;
        }
        return t0(charSequence, cArr, i5, z4, i6);
    }

    static /* synthetic */ C2751e w0(CharSequence charSequence, String[] strArr, int i5, boolean z4, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            z4 = false;
        }
        if ((i7 & 8) != 0) {
            i6 = 0;
        }
        return u0(charSequence, strArr, i5, z4, i6);
    }

    /* access modifiers changed from: private */
    public static final s x0(char[] cArr, boolean z4, CharSequence charSequence, int i5) {
        t.e(charSequence, "$this$DelimitedRangesSequence");
        int g02 = g0(charSequence, cArr, i5, z4);
        if (g02 < 0) {
            return null;
        }
        return y.a(Integer.valueOf(g02), 1);
    }

    /* access modifiers changed from: private */
    public static final s y0(List list, boolean z4, CharSequence charSequence, int i5) {
        t.e(charSequence, "$this$DelimitedRangesSequence");
        s Y4 = Y(charSequence, list, i5, z4, false);
        if (Y4 != null) {
            return y.a(Y4.c(), Integer.valueOf(((String) Y4.d()).length()));
        }
        return null;
    }

    public static final boolean z0(CharSequence charSequence, int i5, CharSequence charSequence2, int i6, int i7, boolean z4) {
        t.e(charSequence, "<this>");
        t.e(charSequence2, "other");
        if (i6 < 0 || i5 < 0 || i5 > charSequence.length() - i7 || i6 > charSequence2.length() - i7) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (!C2779c.f(charSequence.charAt(i5 + i8), charSequence2.charAt(i6 + i8), z4)) {
                return false;
            }
        }
        return true;
    }
}
