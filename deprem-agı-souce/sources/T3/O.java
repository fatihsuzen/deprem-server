package t3;

import W2.B;
import W2.C2219h;
import W2.D;
import W2.G;
import W2.z;
import kotlin.jvm.internal.t;

public abstract class O {
    public static final byte a(String str) {
        t.e(str, "<this>");
        z b5 = b(str);
        if (b5 != null) {
            return b5.f();
        }
        C2767D.s(str);
        throw new C2219h();
    }

    public static final z b(String str) {
        t.e(str, "<this>");
        return c(str, 10);
    }

    public static final z c(String str, int i5) {
        t.e(str, "<this>");
        B f5 = f(str, i5);
        if (f5 == null) {
            return null;
        }
        int f6 = f5.f();
        if (Integer.compare(f6 ^ Integer.MIN_VALUE, B.b(255) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return z.a(z.b((byte) f6));
    }

    public static final int d(String str) {
        t.e(str, "<this>");
        B e5 = e(str);
        if (e5 != null) {
            return e5.f();
        }
        C2767D.s(str);
        throw new C2219h();
    }

    public static final B e(String str) {
        t.e(str, "<this>");
        return f(str, 10);
    }

    public static final B f(String str, int i5) {
        int i6;
        t.e(str, "<this>");
        C2778b.a(i5);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i7 = 0;
        char charAt = str.charAt(0);
        if (t.g(charAt, 48) < 0) {
            i6 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            i6 = 0;
        }
        int b5 = B.b(i5);
        int i8 = 119304647;
        while (i6 < length) {
            int b6 = C2778b.b(str.charAt(i6), i5);
            if (b6 < 0) {
                return null;
            }
            if (Integer.compare(i7 ^ Integer.MIN_VALUE, i8 ^ Integer.MIN_VALUE) > 0) {
                if (i8 == 119304647) {
                    i8 = N.a(-1, b5);
                    if (Integer.compare(i7 ^ Integer.MIN_VALUE, i8 ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            int b7 = B.b(i7 * b5);
            int b8 = B.b(B.b(b6) + b7);
            if (Integer.compare(b8 ^ Integer.MIN_VALUE, b7 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i6++;
            i7 = b8;
        }
        return B.a(i7);
    }

    public static final long g(String str) {
        t.e(str, "<this>");
        D h5 = h(str);
        if (h5 != null) {
            return h5.f();
        }
        C2767D.s(str);
        throw new C2219h();
    }

    public static final D h(String str) {
        t.e(str, "<this>");
        return i(str, 10);
    }

    public static final D i(String str, int i5) {
        String str2 = str;
        int i6 = i5;
        t.e(str2, "<this>");
        C2778b.a(i6);
        int length = str2.length();
        if (length == 0) {
            return null;
        }
        int i7 = 0;
        char charAt = str2.charAt(0);
        if (t.g(charAt, 48) < 0) {
            i7 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        }
        long b5 = D.b((long) i6);
        long j5 = 0;
        long j6 = 512409557603043100L;
        while (i7 < length) {
            int b6 = C2778b.b(str2.charAt(i7), i6);
            if (b6 < 0) {
                return null;
            }
            if (Long.compare(j5 ^ Long.MIN_VALUE, j6 ^ Long.MIN_VALUE) > 0) {
                if (j6 == 512409557603043100L) {
                    j6 = C2775L.a(-1, b5);
                    if (Long.compare(j5 ^ Long.MIN_VALUE, j6 ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long b7 = D.b(j5 * b5);
            long b8 = D.b(D.b(((long) B.b(b6)) & 4294967295L) + b7);
            if (Long.compare(b8 ^ Long.MIN_VALUE, b7 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i7++;
            j5 = b8;
        }
        return D.a(j5);
    }

    public static final short j(String str) {
        t.e(str, "<this>");
        G k5 = k(str);
        if (k5 != null) {
            return k5.f();
        }
        C2767D.s(str);
        throw new C2219h();
    }

    public static final G k(String str) {
        t.e(str, "<this>");
        return l(str, 10);
    }

    public static final G l(String str, int i5) {
        t.e(str, "<this>");
        B f5 = f(str, i5);
        if (f5 == null) {
            return null;
        }
        int f6 = f5.f();
        if (Integer.compare(f6 ^ Integer.MIN_VALUE, B.b(65535) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return G.a(G.b((short) f6));
    }
}
