package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.chrono.C0456b;
import j$.time.chrono.C0459e;
import j$.time.chrono.l;
import j$.time.chrono.s;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class g implements m, o, C0456b, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final g f1142d = D(-999999999, 1, 1);

    /* renamed from: e  reason: collision with root package name */
    public static final g f1143e = D(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;

    /* renamed from: a  reason: collision with root package name */
    public final int f1144a;

    /* renamed from: b  reason: collision with root package name */
    public final short f1145b;

    /* renamed from: c  reason: collision with root package name */
    public final short f1146c;

    static {
        D(1970, 1, 1);
    }

    public static g D(int i5, int i6, int i7) {
        a.YEAR.k((long) i5);
        a.MONTH_OF_YEAR.k((long) i6);
        a.DAY_OF_MONTH.k((long) i7);
        return w(i5, i6, i7);
    }

    public static g E(long j5) {
        long j6;
        long j7 = j5;
        a.EPOCH_DAY.k(j7);
        long j8 = 719468 + j7;
        if (j8 < 0) {
            long j9 = ((j7 + 719469) / 146097) - 1;
            j6 = j9 * 400;
            j8 += (-j9) * 146097;
        } else {
            j6 = 0;
        }
        long j10 = ((j8 * 400) + 591) / 146097;
        long j11 = j8 - ((j10 / 400) + (((j10 / 4) + (j10 * 365)) - (j10 / 100)));
        if (j11 < 0) {
            j10--;
            j11 = j8 - ((j10 / 400) + (((j10 / 4) + (365 * j10)) - (j10 / 100)));
        }
        int i5 = (int) j11;
        int i6 = ((i5 * 5) + 2) / 153;
        long j12 = j10 + j6 + ((long) (i6 / 10));
        a aVar = a.YEAR;
        return new g(aVar.f1181b.a(j12, aVar), ((i6 + 2) % 12) + 1, (i5 - (((i6 * 306) + 5) / 10)) + 1);
    }

    public static g x(n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        g gVar = (g) nVar.h(r.f1204f);
        if (gVar != null) {
            return gVar;
        }
        String name = nVar.getClass().getName();
        throw new RuntimeException("Unable to obtain LocalDate from TemporalAccessor: " + nVar + " of type " + name);
    }

    public static g w(int i5, int i6, int i7) {
        int i8 = 28;
        if (i7 > 28) {
            if (i6 != 2) {
                i8 = (i6 == 4 || i6 == 6 || i6 == 9 || i6 == 11) ? 30 : 31;
            } else {
                s.f1072c.getClass();
                if (s.f((long) i5)) {
                    i8 = 29;
                }
            }
            if (i7 > i8) {
                if (i7 == 29) {
                    throw new RuntimeException("Invalid date 'February 29' as '" + i5 + "' is not a leap year");
                }
                throw new RuntimeException("Invalid date '" + l.y(i6).name() + " " + i7 + "'");
            }
        }
        return new g(i5, i6, i7);
    }

    public static g J(int i5, int i6, int i7) {
        if (i6 == 2) {
            s.f1072c.getClass();
            i7 = Math.min(i7, s.f((long) i5) ? 29 : 28);
        } else if (i6 == 4 || i6 == 6 || i6 == 9 || i6 == 11) {
            i7 = Math.min(i7, 30);
        }
        return new g(i5, i6, i7);
    }

    public g(int i5, int i6, int i7) {
        this.f1144a = i5;
        this.f1145b = (short) i6;
        this.f1146c = (short) i7;
    }

    public final boolean c(q qVar) {
        return j$.com.android.tools.r8.a.n(this, qVar);
    }

    public final u g(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.f(this);
        }
        a aVar = (a) qVar;
        if (aVar.isDateBased()) {
            int i5 = f.f1091a[aVar.ordinal()];
            if (i5 == 1) {
                return u.e(1, (long) C());
            }
            if (i5 == 2) {
                return u.e(1, (long) (B() ? 366 : 365));
            } else if (i5 == 3) {
                return u.e(1, (l.y(this.f1145b) != l.FEBRUARY || B()) ? 5 : 4);
            } else if (i5 != 4) {
                return ((a) qVar).f1181b;
            } else {
                if (this.f1144a <= 0) {
                    return u.e(1, C.NANOS_PER_SECOND);
                }
                return u.e(1, 999999999);
            }
        } else {
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    public final int e(q qVar) {
        if (qVar instanceof a) {
            return y(qVar);
        }
        return r.a(this, qVar);
    }

    public final long q(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        if (qVar == a.EPOCH_DAY) {
            return r();
        }
        return qVar == a.PROLEPTIC_MONTH ? ((((long) this.f1144a) * 12) + ((long) this.f1145b)) - 1 : (long) y(qVar);
    }

    public final int y(q qVar) {
        switch (f.f1091a[((a) qVar).ordinal()]) {
            case 1:
                return this.f1146c;
            case 2:
                return A();
            case 3:
                return ((this.f1146c - 1) / 7) + 1;
            case 4:
                int i5 = this.f1144a;
                return i5 >= 1 ? i5 : 1 - i5;
            case 5:
                return z().getValue();
            case 6:
                return ((this.f1146c - 1) % 7) + 1;
            case 7:
                return ((A() - 1) % 7) + 1;
            case 8:
                throw new RuntimeException("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((A() - 1) / 7) + 1;
            case 10:
                return this.f1145b;
            case 11:
                throw new RuntimeException("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.f1144a;
            case 13:
                if (this.f1144a >= 1) {
                    return 1;
                }
                return 0;
            default:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    public final l getChronology() {
        return s.f1072c;
    }

    public final int A() {
        return (l.y(this.f1145b).v(B()) + this.f1146c) - 1;
    }

    public final d z() {
        return d.v(((int) j$.com.android.tools.r8.a.A(r() + 3, (long) 7)) + 1);
    }

    public final boolean B() {
        s.f1072c.getClass();
        return s.f((long) this.f1144a);
    }

    public final int C() {
        short s5 = this.f1145b;
        return s5 != 2 ? (s5 == 4 || s5 == 6 || s5 == 9 || s5 == 11) ? 30 : 31 : B() ? 29 : 28;
    }

    /* renamed from: L */
    public final g f(o oVar) {
        if (oVar instanceof g) {
            return (g) oVar;
        }
        return (g) oVar.k(this);
    }

    /* renamed from: K */
    public final g a(long j5, q qVar) {
        if (!(qVar instanceof a)) {
            return (g) qVar.h(this, j5);
        }
        a aVar = (a) qVar;
        aVar.k(j5);
        switch (f.f1091a[aVar.ordinal()]) {
            case 1:
                int i5 = (int) j5;
                if (this.f1146c != i5) {
                    return D(this.f1144a, this.f1145b, i5);
                }
                break;
            case 2:
                return M((int) j5);
            case 3:
                return G(j$.com.android.tools.r8.a.w(j5 - q(a.ALIGNED_WEEK_OF_MONTH), 7));
            case 4:
                if (this.f1144a < 1) {
                    j5 = 1 - j5;
                }
                return N((int) j5);
            case 5:
                return G(j5 - ((long) z().getValue()));
            case 6:
                return G(j5 - q(a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return G(j5 - q(a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return E(j5);
            case 9:
                return G(j$.com.android.tools.r8.a.w(j5 - q(a.ALIGNED_WEEK_OF_YEAR), 7));
            case 10:
                int i6 = (int) j5;
                if (this.f1145b != i6) {
                    a.MONTH_OF_YEAR.k((long) i6);
                    return J(this.f1144a, i6, this.f1146c);
                }
                break;
            case 11:
                return H(j5 - (((((long) this.f1144a) * 12) + ((long) this.f1145b)) - 1));
            case 12:
                return N((int) j5);
            case 13:
                if (q(a.ERA) != j5) {
                    return N(1 - this.f1144a);
                }
                break;
            default:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
        return this;
    }

    public final g N(int i5) {
        if (this.f1144a == i5) {
            return this;
        }
        a.YEAR.k((long) i5);
        return J(i5, this.f1145b, this.f1146c);
    }

    public final g M(int i5) {
        if (A() == i5) {
            return this;
        }
        int i6 = this.f1144a;
        long j5 = (long) i6;
        a.YEAR.k(j5);
        a.DAY_OF_YEAR.k((long) i5);
        s.f1072c.getClass();
        boolean f5 = s.f(j5);
        if (i5 != 366 || f5) {
            l y4 = l.y(((i5 - 1) / 31) + 1);
            if (i5 > (y4.w(f5) + y4.v(f5)) - 1) {
                y4 = l.f1159a[((((int) 1) + 12) + y4.ordinal()) % 12];
            }
            return new g(i6, y4.getValue(), (i5 - y4.v(f5)) + 1);
        }
        throw new RuntimeException("Invalid date 'DayOfYear 366' as '" + i6 + "' is not a leap year");
    }

    /* renamed from: F */
    public final g b(long j5, j$.time.temporal.s sVar) {
        if (!(sVar instanceof b)) {
            return (g) sVar.e(this, j5);
        }
        switch (f.f1092b[((b) sVar).ordinal()]) {
            case 1:
                return G(j5);
            case 2:
                return G(j$.com.android.tools.r8.a.w(j5, 7));
            case 3:
                return H(j5);
            case 4:
                return I(j5);
            case 5:
                return I(j$.com.android.tools.r8.a.w(j5, 10));
            case 6:
                return I(j$.com.android.tools.r8.a.w(j5, 100));
            case 7:
                return I(j$.com.android.tools.r8.a.w(j5, 1000));
            case 8:
                a aVar = a.ERA;
                return a(j$.com.android.tools.r8.a.x(q(aVar), j5), aVar);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    public final g I(long j5) {
        if (j5 == 0) {
            return this;
        }
        a aVar = a.YEAR;
        return J(aVar.f1181b.a(((long) this.f1144a) + j5, aVar), this.f1145b, this.f1146c);
    }

    public final g H(long j5) {
        if (j5 == 0) {
            return this;
        }
        long j6 = (((long) this.f1144a) * 12) + ((long) (this.f1145b - 1)) + j5;
        a aVar = a.YEAR;
        long j7 = (long) 12;
        return J(aVar.f1181b.a(j$.com.android.tools.r8.a.B(j6, j7), aVar), ((int) j$.com.android.tools.r8.a.A(j6, j7)) + 1, this.f1146c);
    }

    public final g G(long j5) {
        if (j5 == 0) {
            return this;
        }
        long j6 = ((long) this.f1146c) + j5;
        if (j6 > 0) {
            if (j6 <= 28) {
                return new g(this.f1144a, this.f1145b, (int) j6);
            }
            if (j6 <= 59) {
                long C4 = (long) C();
                if (j6 <= C4) {
                    return new g(this.f1144a, this.f1145b, (int) j6);
                }
                short s5 = this.f1145b;
                if (s5 < 12) {
                    return new g(this.f1144a, s5 + 1, (int) (j6 - C4));
                }
                a.YEAR.k((long) (this.f1144a + 1));
                return new g(this.f1144a + 1, 1, (int) (j6 - C4));
            }
        }
        return E(j$.com.android.tools.r8.a.x(r(), j5));
    }

    public final m n(long j5, b bVar) {
        return j5 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1, bVar) : b(-j5, bVar);
    }

    public final Object h(j$.time.format.a aVar) {
        if (aVar == r.f1204f) {
            return this;
        }
        return j$.com.android.tools.r8.a.p(this, aVar);
    }

    public final m k(m mVar) {
        return j$.com.android.tools.r8.a.a(this, mVar);
    }

    public final C0459e s(j jVar) {
        return LocalDateTime.y(this, jVar);
    }

    public final long r() {
        long j5;
        long j6 = (long) this.f1144a;
        long j7 = (long) this.f1145b;
        long j8 = 365 * j6;
        if (j6 >= 0) {
            j5 = ((j6 + 399) / 400) + (((3 + j6) / 4) - ((99 + j6) / 100)) + j8;
        } else {
            j5 = j8 - ((j6 / -400) + ((j6 / -4) - (j6 / -100)));
        }
        long j9 = (((367 * j7) - 362) / 12) + j5 + ((long) (this.f1146c - 1));
        if (j7 > 2) {
            j9 = !B() ? j9 - 2 : j9 - 1;
        }
        return j9 - 719528;
    }

    /* renamed from: u */
    public final int compareTo(C0456b bVar) {
        if (bVar instanceof g) {
            return v((g) bVar);
        }
        return j$.com.android.tools.r8.a.g(this, bVar);
    }

    public final int v(g gVar) {
        int i5 = this.f1144a - gVar.f1144a;
        if (i5 != 0) {
            return i5;
        }
        int i6 = this.f1145b - gVar.f1145b;
        return i6 == 0 ? this.f1146c - gVar.f1146c : i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && v((g) obj) == 0;
    }

    public final int hashCode() {
        int i5 = this.f1144a;
        return (((i5 << 11) + (this.f1145b << 6)) + this.f1146c) ^ (i5 & -2048);
    }

    public final String toString() {
        int i5 = this.f1144a;
        short s5 = this.f1145b;
        short s6 = this.f1146c;
        int abs = Math.abs(i5);
        StringBuilder sb = new StringBuilder(10);
        if (abs >= 1000) {
            if (i5 > 9999) {
                sb.append('+');
            }
            sb.append(i5);
        } else if (i5 < 0) {
            sb.append(i5 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i5 + 10000);
            sb.deleteCharAt(0);
        }
        String str = "-";
        sb.append(s5 < 10 ? "-0" : str);
        sb.append(s5);
        if (s6 < 10) {
            str = "-0";
        }
        sb.append(str);
        sb.append(s6);
        return sb.toString();
    }

    private Object writeReplace() {
        return new r((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
