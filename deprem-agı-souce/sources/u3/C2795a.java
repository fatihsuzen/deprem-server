package u3;

import androidx.collection.a;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;
import t3.s;

/* renamed from: u3.a  reason: case insensitive filesystem */
public final class C2795a implements Comparable {

    /* renamed from: b  reason: collision with root package name */
    public static final C0262a f25994b = new C0262a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final long f25995c = h(0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final long f25996d = C2797c.j(4611686018427387903L);

    /* renamed from: e  reason: collision with root package name */
    private static final long f25997e = C2797c.j(-4611686018427387903L);

    /* renamed from: a  reason: collision with root package name */
    private final long f25998a;

    /* renamed from: u3.a$a  reason: collision with other inner class name */
    public static final class C0262a {
        public /* synthetic */ C0262a(C2633k kVar) {
            this();
        }

        public final long a() {
            return C2795a.f25996d;
        }

        public final long b() {
            return C2795a.f25995c;
        }

        public final long c(String str) {
            t.e(str, "value");
            try {
                return C2797c.p(str, true);
            } catch (IllegalArgumentException e5) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + str + "'.", e5);
            }
        }

        private C0262a() {
        }
    }

    private /* synthetic */ C2795a(long j5) {
        this.f25998a = j5;
    }

    public static final boolean D(long j5) {
        if (j5 < 0) {
            return true;
        }
        return false;
    }

    public static final boolean E(long j5) {
        if (j5 > 0) {
            return true;
        }
        return false;
    }

    public static final long F(long j5, long j6) {
        if (z(j5)) {
            if (w(j6) || (j6 ^ j5) >= 0) {
                return j5;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (z(j6)) {
            return j6;
        } else {
            if ((((int) j5) & 1) == (((int) j6) & 1)) {
                long u5 = u(j5) + u(j6);
                if (y(j5)) {
                    return C2797c.m(u5);
                }
                return C2797c.k(u5);
            } else if (x(j5)) {
                return c(j5, u(j5), u(j6));
            } else {
                long j7 = j5;
                return c(j7, u(j6), u(j7));
            }
        }
    }

    public static final String G(long j5) {
        long j6;
        boolean z4;
        boolean z5;
        StringBuilder sb = new StringBuilder();
        if (D(j5)) {
            sb.append('-');
        }
        sb.append("PT");
        long j7 = j(j5);
        long m5 = m(j7);
        int q5 = q(j7);
        long j8 = m5;
        int s5 = s(j7);
        int r5 = r(j7);
        if (z(j5)) {
            j6 = 9999999999999L;
        } else {
            j6 = j8;
        }
        boolean z6 = false;
        if (j6 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (s5 == 0 && r5 == 0) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (q5 != 0 || (z5 && z4)) {
            z6 = true;
        }
        if (z4) {
            sb.append(j6);
            sb.append('H');
        }
        if (z6) {
            sb.append(q5);
            sb.append('M');
        }
        if (z5 || (!z4 && !z6)) {
            d(j5, sb, s5, r5, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        return sb.toString();
    }

    public static final long H(long j5, C2798d dVar) {
        t.e(dVar, "unit");
        if (j5 == f25996d) {
            return Long.MAX_VALUE;
        }
        if (j5 == f25997e) {
            return Long.MIN_VALUE;
        }
        return C2799e.b(u(j5), t(j5), dVar);
    }

    public static String I(long j5) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        if (j5 == 0) {
            return "0s";
        }
        if (j5 == f25996d) {
            return "Infinity";
        }
        if (j5 == f25997e) {
            return "-Infinity";
        }
        boolean D4 = D(j5);
        StringBuilder sb = new StringBuilder();
        if (D4) {
            sb.append('-');
        }
        long j6 = j(j5);
        long l5 = l(j6);
        int k5 = k(j6);
        int q5 = q(j6);
        long j7 = l5;
        int s5 = s(j6);
        int r5 = r(j6);
        int i5 = 0;
        if (j7 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (k5 != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (q5 != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (s5 == 0 && r5 == 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z4) {
            sb.append(j7);
            sb.append('d');
            i5 = 1;
        }
        if (z5 || (z4 && (z6 || z7))) {
            int i6 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            sb.append(k5);
            sb.append('h');
            i5 = i6;
        }
        if (z6 || (z7 && (z5 || z4))) {
            int i7 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            sb.append(q5);
            sb.append('m');
            i5 = i7;
        }
        if (z7) {
            int i8 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            if (s5 != 0 || z4 || z5 || z6) {
                d(j5, sb, s5, r5, 9, "s", false);
            } else if (r5 >= 1000000) {
                d(j5, sb, r5 / 1000000, r5 % 1000000, 6, "ms", false);
            } else {
                long j8 = j5;
                if (r5 >= 1000) {
                    d(j8, sb, r5 / 1000, r5 % 1000, 3, "us", false);
                } else {
                    sb.append(r5);
                    sb.append("ns");
                }
            }
            i5 = i8;
        }
        if (D4 && i5 > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    public static final long J(long j5) {
        return C2797c.i(-u(j5), ((int) j5) & 1);
    }

    private static final long c(long j5, long j6, long j7) {
        long g5 = C2797c.o(j7);
        long j8 = j6 + g5;
        if (-4611686018426L > j8 || j8 >= 4611686018427L) {
            return C2797c.j(C2729e.i(j8, -4611686018427387903L, 4611686018427387903L));
        }
        return C2797c.l(C2797c.n(j8) + (j7 - C2797c.n(g5)));
    }

    private static final void d(long j5, StringBuilder sb, int i5, int i6, int i7, String str, boolean z4) {
        sb.append(i5);
        if (i6 != 0) {
            sb.append('.');
            String s02 = s.s0(String.valueOf(i6), i7, '0');
            int i8 = -1;
            int length = s02.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i9 = length - 1;
                    if (s02.charAt(length) != '0') {
                        i8 = length;
                        break;
                    } else if (i9 < 0) {
                        break;
                    } else {
                        length = i9;
                    }
                }
            }
            int i10 = i8 + 1;
            if (z4 || i10 >= 3) {
                sb.append(s02, 0, ((i8 + 3) / 3) * 3);
                t.d(sb, "append(...)");
            } else {
                sb.append(s02, 0, i10);
                t.d(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    public static final /* synthetic */ C2795a e(long j5) {
        return new C2795a(j5);
    }

    public static int g(long j5, long j6) {
        long j7 = j5 ^ j6;
        if (j7 < 0 || (((int) j7) & 1) == 0) {
            return t.h(j5, j6);
        }
        int i5 = (((int) j5) & 1) - (((int) j6) & 1);
        if (D(j5)) {
            return -i5;
        }
        return i5;
    }

    public static long h(long j5) {
        if (!C2796b.a()) {
            return j5;
        }
        if (y(j5)) {
            long u5 = u(j5);
            if (-4611686018426999999L <= u5 && u5 < 4611686018427000000L) {
                return j5;
            }
            throw new AssertionError(u(j5) + " ns is out of nanoseconds range");
        }
        long u6 = u(j5);
        if (-4611686018427387903L > u6 || u6 >= 4611686018427387904L) {
            throw new AssertionError(u(j5) + " ms is out of milliseconds range");
        }
        long u7 = u(j5);
        if (-4611686018426L > u7 || u7 >= 4611686018427L) {
            return j5;
        }
        throw new AssertionError(u(j5) + " ms is denormalized");
    }

    public static boolean i(long j5, Object obj) {
        if ((obj instanceof C2795a) && j5 == ((C2795a) obj).K()) {
            return true;
        }
        return false;
    }

    public static final long j(long j5) {
        if (D(j5)) {
            return J(j5);
        }
        return j5;
    }

    public static final int k(long j5) {
        if (z(j5)) {
            return 0;
        }
        return (int) (m(j5) % ((long) 24));
    }

    public static final long l(long j5) {
        return H(j5, C2798d.DAYS);
    }

    public static final long m(long j5) {
        return H(j5, C2798d.HOURS);
    }

    public static final long n(long j5) {
        if (!x(j5) || !w(j5)) {
            return H(j5, C2798d.MILLISECONDS);
        }
        return u(j5);
    }

    public static final long o(long j5) {
        return H(j5, C2798d.MINUTES);
    }

    public static final long p(long j5) {
        return H(j5, C2798d.SECONDS);
    }

    public static final int q(long j5) {
        if (z(j5)) {
            return 0;
        }
        return (int) (o(j5) % ((long) 60));
    }

    public static final int r(long j5) {
        long u5;
        if (z(j5)) {
            return 0;
        }
        if (x(j5)) {
            u5 = C2797c.n(u(j5) % ((long) 1000));
        } else {
            u5 = u(j5) % ((long) 1000000000);
        }
        return (int) u5;
    }

    public static final int s(long j5) {
        if (z(j5)) {
            return 0;
        }
        return (int) (p(j5) % ((long) 60));
    }

    private static final C2798d t(long j5) {
        if (y(j5)) {
            return C2798d.NANOSECONDS;
        }
        return C2798d.MILLISECONDS;
    }

    private static final long u(long j5) {
        return j5 >> 1;
    }

    public static int v(long j5) {
        return a.a(j5);
    }

    public static final boolean w(long j5) {
        return !z(j5);
    }

    private static final boolean x(long j5) {
        if ((((int) j5) & 1) == 1) {
            return true;
        }
        return false;
    }

    private static final boolean y(long j5) {
        if ((((int) j5) & 1) == 0) {
            return true;
        }
        return false;
    }

    public static final boolean z(long j5) {
        if (j5 == f25996d || j5 == f25997e) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ long K() {
        return this.f25998a;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return f(((C2795a) obj).K());
    }

    public boolean equals(Object obj) {
        return i(this.f25998a, obj);
    }

    public int f(long j5) {
        return g(this.f25998a, j5);
    }

    public int hashCode() {
        return v(this.f25998a);
    }

    public String toString() {
        return I(this.f25998a);
    }
}
