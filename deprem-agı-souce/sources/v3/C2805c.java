package v3;

import kotlin.jvm.internal.t;
import t3.C2782f;
import t3.C2783g;

/* renamed from: v3.c  reason: case insensitive filesystem */
abstract class C2805c extends C2804b {
    public static final void e(String str, int i5) {
        t.e(str, "<this>");
        if (str.charAt(i5) != '-') {
            throw new IllegalArgumentException(("Expected '-' (hyphen) at index " + i5 + ", but was '" + str.charAt(i5) + '\'').toString());
        }
    }

    public static final void f(long j5, byte[] bArr, int i5, int i6, int i7) {
        t.e(bArr, "dst");
        int i8 = 7 - i6;
        int i9 = 8 - i7;
        if (i9 <= i8) {
            while (true) {
                int i10 = C2782f.d()[(int) ((j5 >> (i8 << 3)) & 255)];
                int i11 = i5 + 1;
                bArr[i5] = (byte) (i10 >> 8);
                i5 += 2;
                bArr[i11] = (byte) i10;
                if (i8 != i9) {
                    i8--;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final String g(String str, int i5) {
        if (str.length() <= i5) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        t.c(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(0, i5);
        t.d(substring, "substring(...)");
        sb.append(substring);
        sb.append("...");
        return sb.toString();
    }

    public static final C2803a h(String str) {
        t.e(str, "hexString");
        String str2 = str;
        return C2803a.f26045c.a(C2782f.f(str2, 0, 16, (C2783g) null, 4, (Object) null), C2782f.f(str2, 16, 32, (C2783g) null, 4, (Object) null));
    }

    public static final C2803a i(String str) {
        t.e(str, "hexDashString");
        String str2 = str;
        long f5 = C2782f.f(str2, 0, 8, (C2783g) null, 4, (Object) null);
        String str3 = str2;
        e(str3, 8);
        long f6 = C2782f.f(str3, 9, 13, (C2783g) null, 4, (Object) null);
        e(str3, 13);
        long f7 = C2782f.f(str3, 14, 18, (C2783g) null, 4, (Object) null);
        e(str3, 18);
        long f8 = C2782f.f(str3, 19, 23, (C2783g) null, 4, (Object) null);
        e(str3, 23);
        long j5 = f6 << 16;
        long j6 = f8 << 48;
        return C2803a.f26045c.a(j5 | (f5 << 32) | f7, j6 | C2782f.f(str3, 24, 36, (C2783g) null, 4, (Object) null));
    }
}
