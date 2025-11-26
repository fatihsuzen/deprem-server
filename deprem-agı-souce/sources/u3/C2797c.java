package u3;

import kotlin.jvm.internal.t;
import m3.C2690a;
import q3.C2729e;
import t3.s;
import u3.C2795a;

/* renamed from: u3.c  reason: case insensitive filesystem */
public abstract class C2797c {
    /* access modifiers changed from: private */
    public static final long i(long j5, int i5) {
        return C2795a.h((j5 << 1) + ((long) i5));
    }

    /* access modifiers changed from: private */
    public static final long j(long j5) {
        return C2795a.h((j5 << 1) + 1);
    }

    /* access modifiers changed from: private */
    public static final long k(long j5) {
        if (-4611686018426L > j5 || j5 >= 4611686018427L) {
            return j(C2729e.i(j5, -4611686018427387903L, 4611686018427387903L));
        }
        return l(n(j5));
    }

    /* access modifiers changed from: private */
    public static final long l(long j5) {
        return C2795a.h(j5 << 1);
    }

    /* access modifiers changed from: private */
    public static final long m(long j5) {
        if (-4611686018426999999L > j5 || j5 >= 4611686018427000000L) {
            return j(o(j5));
        }
        return l(j5);
    }

    /* access modifiers changed from: private */
    public static final long n(long j5) {
        return j5 * ((long) 1000000);
    }

    /* access modifiers changed from: private */
    public static final long o(long j5) {
        return j5 / ((long) 1000000);
    }

    /* access modifiers changed from: private */
    public static final long p(String str, boolean z4) {
        int i5;
        long F4;
        int i6;
        boolean z5;
        String str2 = str;
        int length = str2.length();
        if (length != 0) {
            C2795a.C0262a aVar = C2795a.f25994b;
            long b5 = aVar.b();
            char charAt = str2.charAt(0);
            int i7 = (charAt == '+' || charAt == '-') ? 1 : 0;
            boolean z6 = i7 > 0;
            boolean z7 = z6 && s.I0(str2, '-', false, 2, (Object) null);
            if (length > i7) {
                char c5 = ':';
                char c6 = '0';
                if (str2.charAt(i7) == 'P') {
                    int i8 = i7 + 1;
                    if (i8 != length) {
                        boolean z8 = false;
                        C2798d dVar = null;
                        while (i8 < length) {
                            if (str2.charAt(i8) != 'T') {
                                int i9 = i8;
                                while (true) {
                                    if (i9 >= str2.length()) {
                                        i6 = length;
                                        break;
                                    }
                                    char charAt2 = str2.charAt(i9);
                                    if (c6 > charAt2 || charAt2 >= c5) {
                                        i6 = length;
                                        if (!s.U("+-.", charAt2, false, 2, (Object) null)) {
                                            break;
                                        }
                                    } else {
                                        i6 = length;
                                    }
                                    i9++;
                                    length = i6;
                                    c6 = '0';
                                    c5 = ':';
                                }
                                t.c(str2, "null cannot be cast to non-null type java.lang.String");
                                String substring = str2.substring(i8, i9);
                                t.d(substring, "substring(...)");
                                if (substring.length() != 0) {
                                    int length2 = i8 + substring.length();
                                    if (length2 < 0 || length2 >= str2.length()) {
                                        throw new IllegalArgumentException("Missing unit for value " + substring);
                                    }
                                    char charAt3 = str2.charAt(length2);
                                    i8 = length2 + 1;
                                    C2798d d5 = C2800f.d(charAt3, z8);
                                    if (dVar == null || dVar.compareTo(d5) > 0) {
                                        int e02 = s.e0(substring, '.', 0, false, 6, (Object) null);
                                        if (d5 != C2798d.SECONDS || e02 <= 0) {
                                            z5 = z8;
                                            b5 = C2795a.F(b5, t(q(substring), d5));
                                        } else {
                                            t.c(substring, "null cannot be cast to non-null type java.lang.String");
                                            String substring2 = substring.substring(0, e02);
                                            t.d(substring2, "substring(...)");
                                            z5 = z8;
                                            long F5 = C2795a.F(b5, t(q(substring2), d5));
                                            t.c(substring, "null cannot be cast to non-null type java.lang.String");
                                            String substring3 = substring.substring(e02);
                                            t.d(substring3, "substring(...)");
                                            b5 = C2795a.F(F5, r(Double.parseDouble(substring3), d5));
                                        }
                                        z8 = z5;
                                        dVar = d5;
                                        length = i6;
                                        c6 = '0';
                                        c5 = ':';
                                    } else {
                                        throw new IllegalArgumentException("Unexpected order of duration components");
                                    }
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            } else if (z8 || (i8 = i8 + 1) == length) {
                                throw new IllegalArgumentException();
                            } else {
                                z8 = true;
                            }
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    int i10 = length;
                    if (!z4) {
                        String str3 = "Unexpected order of duration components";
                        char c7 = '0';
                        if (s.G(str2, i7, "Infinity", 0, Math.max(i10 - i7, 8), true)) {
                            b5 = aVar.a();
                        } else {
                            boolean z9 = !z6;
                            if (z6 && str2.charAt(i7) == '(' && s.a1(str2) == ')') {
                                i7++;
                                int i11 = i10 - 1;
                                if (i7 != i11) {
                                    i5 = i11;
                                    z9 = true;
                                } else {
                                    throw new IllegalArgumentException("No components");
                                }
                            } else {
                                i5 = i10;
                            }
                            boolean z10 = false;
                            C2798d dVar2 = null;
                            while (i7 < i5) {
                                if (z10 && z9) {
                                    while (i7 < str2.length() && str2.charAt(i7) == ' ') {
                                        i7++;
                                    }
                                }
                                int i12 = i7;
                                while (true) {
                                    if (i12 >= str2.length()) {
                                        break;
                                    }
                                    char charAt4 = str2.charAt(i12);
                                    if ((c7 > charAt4 || charAt4 >= ':') && charAt4 != '.') {
                                        break;
                                    }
                                    i12++;
                                }
                                t.c(str2, "null cannot be cast to non-null type java.lang.String");
                                String substring4 = str2.substring(i7, i12);
                                t.d(substring4, "substring(...)");
                                if (substring4.length() != 0) {
                                    int length3 = i7 + substring4.length();
                                    int i13 = length3;
                                    while (i13 < str2.length() && 'a' <= (r15 = str2.charAt(i13)) && r15 < '{') {
                                        i13++;
                                    }
                                    t.c(str2, "null cannot be cast to non-null type java.lang.String");
                                    String substring5 = str2.substring(length3, i13);
                                    t.d(substring5, "substring(...)");
                                    i7 = length3 + substring5.length();
                                    C2798d e5 = C2800f.e(substring5);
                                    if (dVar2 == null || dVar2.compareTo(e5) > 0) {
                                        String str4 = substring4;
                                        int e03 = s.e0(str4, '.', 0, false, 6, (Object) null);
                                        String str5 = str4;
                                        if (e03 > 0) {
                                            t.c(str5, "null cannot be cast to non-null type java.lang.String");
                                            String substring6 = str5.substring(0, e03);
                                            t.d(substring6, "substring(...)");
                                            long F6 = C2795a.F(b5, t(Long.parseLong(substring6), e5));
                                            t.c(str5, "null cannot be cast to non-null type java.lang.String");
                                            String substring7 = str5.substring(e03);
                                            t.d(substring7, "substring(...)");
                                            F4 = C2795a.F(F6, r(Double.parseDouble(substring7), e5));
                                            if (i7 < i5) {
                                                throw new IllegalArgumentException("Fractional component must be last");
                                            }
                                        } else {
                                            F4 = C2795a.F(b5, t(Long.parseLong(str5), e5));
                                        }
                                        dVar2 = e5;
                                        z10 = true;
                                        c7 = '0';
                                    } else {
                                        throw new IllegalArgumentException(str3);
                                    }
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                return z7 ? C2795a.J(b5) : b5;
            }
            throw new IllegalArgumentException("No components");
        }
        throw new IllegalArgumentException("The string is empty");
    }

    private static final long q(String str) {
        int i5;
        char charAt;
        int length = str.length();
        if (length <= 0 || !s.U("+-", str.charAt(0), false, 2, (Object) null)) {
            i5 = 0;
        } else {
            i5 = 1;
        }
        if (length - i5 > 16) {
            int i6 = i5;
            while (true) {
                if (i5 < length) {
                    char charAt2 = str.charAt(i5);
                    if (charAt2 != '0') {
                        if ('1' > charAt2 || charAt2 >= ':') {
                            break;
                        }
                    } else if (i6 == i5) {
                        i6++;
                    }
                    i5++;
                } else if (length - i6 > 16) {
                    if (str.charAt(0) == '-') {
                        return Long.MIN_VALUE;
                    }
                    return Long.MAX_VALUE;
                }
            }
        }
        if (!s.P(str, "+", false, 2, (Object) null) || length <= 1 || '0' > (charAt = str.charAt(1)) || charAt >= ':') {
            return Long.parseLong(str);
        }
        return Long.parseLong(s.Z0(str, 1));
    }

    public static final long r(double d5, C2798d dVar) {
        t.e(dVar, "unit");
        double a5 = C2799e.a(d5, dVar, C2798d.NANOSECONDS);
        if (!Double.isNaN(a5)) {
            long b5 = C2690a.b(a5);
            if (-4611686018426999999L > b5 || b5 >= 4611686018427000000L) {
                return k(C2690a.b(C2799e.a(d5, dVar, C2798d.MILLISECONDS)));
            }
            return l(b5);
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.");
    }

    public static final long s(int i5, C2798d dVar) {
        t.e(dVar, "unit");
        if (dVar.compareTo(C2798d.SECONDS) <= 0) {
            return l(C2799e.c((long) i5, dVar, C2798d.NANOSECONDS));
        }
        return t((long) i5, dVar);
    }

    public static final long t(long j5, C2798d dVar) {
        t.e(dVar, "unit");
        C2798d dVar2 = C2798d.NANOSECONDS;
        long c5 = C2799e.c(4611686018426999999L, dVar2, dVar);
        if ((-c5) > j5 || j5 > c5) {
            return j(C2729e.i(C2799e.b(j5, dVar, C2798d.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
        }
        return l(C2799e.c(j5, dVar, dVar2));
    }
}
