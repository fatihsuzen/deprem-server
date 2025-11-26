package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.chrono.l;
import j$.time.format.n;
import j$.time.format.t;
import j$.time.format.u;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

public final class v implements m, o, Comparable, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f1212c = 0;
    private static final long serialVersionUID = 4183400860270640070L;

    /* renamed from: a  reason: collision with root package name */
    public final int f1213a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1214b;

    public final int compareTo(Object obj) {
        v vVar = (v) obj;
        int i5 = this.f1213a - vVar.f1213a;
        return i5 == 0 ? this.f1214b - vVar.f1214b : i5;
    }

    static {
        n nVar = new n();
        nVar.h(a.YEAR, 4, 10, u.EXCEEDS_PAD);
        nVar.c('-');
        nVar.g(a.MONTH_OF_YEAR, 2);
        nVar.l(Locale.getDefault(), t.SMART, (l) null);
    }

    public v(int i5, int i6) {
        this.f1213a = i5;
        this.f1214b = i6;
    }

    public final v z(int i5, int i6) {
        if (this.f1213a == i5 && this.f1214b == i6) {
            return this;
        }
        return new v(i5, i6);
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.YEAR || qVar == a.MONTH_OF_YEAR || qVar == a.PROLEPTIC_MONTH || qVar == a.YEAR_OF_ERA || qVar == a.ERA : qVar != null && qVar.e(this);
    }

    public final j$.time.temporal.u g(q qVar) {
        if (qVar != a.YEAR_OF_ERA) {
            return r.d(this, qVar);
        }
        return j$.time.temporal.u.e(1, this.f1213a <= 0 ? C.NANOS_PER_SECOND : 999999999);
    }

    public final int e(q qVar) {
        return g(qVar).a(q(qVar), qVar);
    }

    public final long q(q qVar) {
        int i5;
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        int i6 = u.f1210a[((a) qVar).ordinal()];
        int i7 = 1;
        if (i6 == 1) {
            i5 = this.f1214b;
        } else if (i6 == 2) {
            return v();
        } else {
            if (i6 == 3) {
                int i8 = this.f1213a;
                if (i8 < 1) {
                    i8 = 1 - i8;
                }
                return (long) i8;
            } else if (i6 == 4) {
                i5 = this.f1213a;
            } else if (i6 == 5) {
                if (this.f1213a < 1) {
                    i7 = 0;
                }
                return (long) i7;
            } else {
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
            }
        }
        return (long) i5;
    }

    public final long v() {
        return ((((long) this.f1213a) * 12) + ((long) this.f1214b)) - 1;
    }

    /* renamed from: A */
    public final v a(long j5, q qVar) {
        if (!(qVar instanceof a)) {
            return (v) qVar.h(this, j5);
        }
        a aVar = (a) qVar;
        aVar.k(j5);
        int i5 = u.f1210a[aVar.ordinal()];
        if (i5 == 1) {
            int i6 = (int) j5;
            a.MONTH_OF_YEAR.k((long) i6);
            return z(this.f1213a, i6);
        } else if (i5 == 2) {
            return x(j5 - v());
        } else {
            if (i5 == 3) {
                if (this.f1213a < 1) {
                    j5 = 1 - j5;
                }
                int i7 = (int) j5;
                a.YEAR.k((long) i7);
                return z(i7, this.f1214b);
            } else if (i5 == 4) {
                int i8 = (int) j5;
                a.YEAR.k((long) i8);
                return z(i8, this.f1214b);
            } else if (i5 != 5) {
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
            } else if (q(a.ERA) == j5) {
                return this;
            } else {
                int i9 = 1 - this.f1213a;
                a.YEAR.k((long) i9);
                return z(i9, this.f1214b);
            }
        }
    }

    /* renamed from: w */
    public final v b(long j5, s sVar) {
        if (!(sVar instanceof b)) {
            return (v) sVar.e(this, j5);
        }
        switch (u.f1211b[((b) sVar).ordinal()]) {
            case 1:
                return x(j5);
            case 2:
                return y(j5);
            case 3:
                return y(j$.com.android.tools.r8.a.w(j5, 10));
            case 4:
                return y(j$.com.android.tools.r8.a.w(j5, 100));
            case 5:
                return y(j$.com.android.tools.r8.a.w(j5, 1000));
            case 6:
                a aVar = a.ERA;
                return a(j$.com.android.tools.r8.a.x(q(aVar), j5), aVar);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    public final v y(long j5) {
        if (j5 == 0) {
            return this;
        }
        a aVar = a.YEAR;
        return z(aVar.f1181b.a(((long) this.f1213a) + j5, aVar), this.f1214b);
    }

    public final v x(long j5) {
        if (j5 == 0) {
            return this;
        }
        long j6 = (((long) this.f1213a) * 12) + ((long) (this.f1214b - 1)) + j5;
        a aVar = a.YEAR;
        long j7 = (long) 12;
        return z(aVar.f1181b.a(j$.com.android.tools.r8.a.B(j6, j7), aVar), ((int) j$.com.android.tools.r8.a.A(j6, j7)) + 1);
    }

    public final m n(long j5, b bVar) {
        return j5 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1, bVar) : b(-j5, bVar);
    }

    public final Object h(j$.time.format.a aVar) {
        if (aVar == r.f1200b) {
            return j$.time.chrono.s.f1072c;
        }
        if (aVar == r.f1201c) {
            return b.MONTHS;
        }
        return r.c(this, aVar);
    }

    public final m k(m mVar) {
        if (j$.com.android.tools.r8.a.v(mVar).equals(j$.time.chrono.s.f1072c)) {
            return mVar.a(v(), a.PROLEPTIC_MONTH);
        }
        throw new RuntimeException("Adjustment only supported on ISO date-time");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            return this.f1213a == vVar.f1213a && this.f1214b == vVar.f1214b;
        }
    }

    public final int hashCode() {
        return this.f1213a ^ (this.f1214b << 27);
    }

    public final String toString() {
        int abs = Math.abs(this.f1213a);
        StringBuilder sb = new StringBuilder(9);
        if (abs < 1000) {
            int i5 = this.f1213a;
            if (i5 < 0) {
                sb.append(i5 - 10000);
                sb.deleteCharAt(1);
            } else {
                sb.append(i5 + 10000);
                sb.deleteCharAt(0);
            }
        } else {
            sb.append(this.f1213a);
        }
        sb.append(this.f1214b < 10 ? "-0" : "-");
        sb.append(this.f1214b);
        return sb.toString();
    }

    private Object writeReplace() {
        return new r((byte) 12, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final m f(g gVar) {
        return (v) j$.com.android.tools.r8.a.a(gVar, this);
    }
}
