package t3;

import W2.C2219h;
import X2.C2236c;
import kotlin.jvm.internal.t;
import q3.C2729e;
import t3.C2783g;

/* renamed from: t3.f  reason: case insensitive filesystem */
public abstract class C2782f {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f25904a;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f25905b;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f25906c;

    /* renamed from: d  reason: collision with root package name */
    private static final long[] f25907d;

    static {
        int[] iArr = new int[256];
        int i5 = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            iArr[i6] = "0123456789abcdef".charAt(i6 & 15) | ("0123456789abcdef".charAt(i6 >> 4) << 8);
        }
        f25904a = iArr;
        int[] iArr2 = new int[256];
        for (int i7 = 0; i7 < 256; i7++) {
            iArr2[i7] = "0123456789ABCDEF".charAt(i7 & 15) | ("0123456789ABCDEF".charAt(i7 >> 4) << 8);
        }
        f25905b = iArr2;
        int[] iArr3 = new int[256];
        for (int i8 = 0; i8 < 256; i8++) {
            iArr3[i8] = -1;
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i9)] = i10;
            i9++;
            i10++;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i11)] = i12;
            i11++;
            i12++;
        }
        f25906c = iArr3;
        long[] jArr = new long[256];
        for (int i13 = 0; i13 < 256; i13++) {
            jArr[i13] = -1;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i14)] = (long) i15;
            i14++;
            i15++;
        }
        int i16 = 0;
        while (i5 < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i5)] = (long) i16;
            i5++;
            i16++;
        }
        f25907d = jArr;
    }

    private static final void a(String str, int i5, int i6, int i7) {
        int i8 = i6 - i5;
        if (i8 < 1) {
            j(str, i5, i6, "at least", 1);
        } else if (i8 > i7) {
            c(str, i5, (i8 + i5) - i7);
        }
    }

    private static final void b(String str, int i5, int i6, String str2, String str3, boolean z4, int i7) {
        if ((i6 - i5) - str2.length() <= str3.length()) {
            k(str, i5, i6, str2, str3);
        }
        if (str2.length() != 0) {
            int length = str2.length();
            for (int i8 = 0; i8 < length; i8++) {
                if (!C2779c.f(str2.charAt(i8), str.charAt(i5 + i8), z4)) {
                    l(str, i5, i6, str2, "prefix");
                }
            }
            i5 += str2.length();
        }
        int length2 = i6 - str3.length();
        if (str3.length() != 0) {
            int length3 = str3.length();
            for (int i9 = 0; i9 < length3; i9++) {
                if (!C2779c.f(str3.charAt(i9), str.charAt(length2 + i9), z4)) {
                    l(str, length2, i6, str3, "suffix");
                }
            }
        }
        a(str, i5, length2, i7);
    }

    private static final void c(String str, int i5, int i6) {
        while (i5 < i6) {
            if (str.charAt(i5) == '0') {
                i5++;
            } else {
                throw new NumberFormatException("Expected the hexadecimal digit '0' at index " + i5 + ", but was '" + str.charAt(i5) + "'.\nThe result won't fit the type being parsed.");
            }
        }
    }

    public static final int[] d() {
        return f25904a;
    }

    public static final long e(String str, int i5, int i6, C2783g gVar) {
        t.e(str, "<this>");
        t.e(gVar, "format");
        return g(str, i5, i6, gVar, 16);
    }

    public static /* synthetic */ long f(String str, int i5, int i6, C2783g gVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = str.length();
        }
        if ((i7 & 4) != 0) {
            gVar = C2783g.f25908d.a();
        }
        return e(str, i5, i6, gVar);
    }

    private static final long g(String str, int i5, int i6, C2783g gVar, int i7) {
        C2236c.Companion.a(i5, i6, str.length());
        C2783g.c b5 = gVar.b();
        if (b5.f()) {
            a(str, i5, i6, i7);
            return h(str, i5, i6);
        }
        String d5 = b5.d();
        String e5 = b5.e();
        String str2 = str;
        int i8 = i5;
        int i9 = i6;
        b(str2, i8, i9, d5, e5, b5.c(), i7);
        return h(str2, i8 + d5.length(), i9 - e5.length());
    }

    private static final long h(String str, int i5, int i6) {
        long j5 = 0;
        while (i5 < i6) {
            long j6 = j5 << 4;
            char charAt = str.charAt(i5);
            if ((charAt >>> 8) == 0) {
                long j7 = f25907d[charAt];
                if (j7 >= 0) {
                    j5 = j6 | j7;
                    i5++;
                }
            }
            i(str, i5);
            throw new C2219h();
        }
        return j5;
    }

    private static final Void i(String str, int i5) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i5 + ", but was " + str.charAt(i5));
    }

    private static final void j(String str, int i5, int i6, String str2, int i7) {
        t.c(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i5, i6);
        t.d(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i7 + " hexadecimal digits at index " + i5 + ", but was \"" + substring + "\" of length " + (i6 - i5));
    }

    private static final void k(String str, int i5, int i6, String str2, String str3) {
        t.c(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i5, i6);
        t.d(substring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + str2 + "\" and suffix \"" + str3 + "\", but was " + substring);
    }

    private static final void l(String str, int i5, int i6, String str2, String str3) {
        int e5 = C2729e.e(str2.length() + i5, i6);
        t.c(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i5, e5);
        t.d(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str3 + " \"" + str2 + "\" at index " + i5 + ", but was " + substring);
    }
}
