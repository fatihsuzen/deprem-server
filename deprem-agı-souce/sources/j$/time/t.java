package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.chrono.l;
import j$.time.format.n;
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

public final class t implements m, o, Comparable, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f1177b = 0;
    private static final long serialVersionUID = -23038383694477807L;

    /* renamed from: a  reason: collision with root package name */
    public final int f1178a;

    public final int compareTo(Object obj) {
        return this.f1178a - ((t) obj).f1178a;
    }

    static {
        n nVar = new n();
        nVar.h(a.YEAR, 4, 10, u.EXCEEDS_PAD);
        nVar.l(Locale.getDefault(), j$.time.format.t.SMART, (l) null);
    }

    public static t v(int i5) {
        a.YEAR.k((long) i5);
        return new t(i5);
    }

    public t(int i5) {
        this.f1178a = i5;
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.YEAR || qVar == a.YEAR_OF_ERA || qVar == a.ERA : qVar != null && qVar.e(this);
    }

    public final j$.time.temporal.u g(q qVar) {
        if (qVar != a.YEAR_OF_ERA) {
            return r.d(this, qVar);
        }
        return j$.time.temporal.u.e(1, this.f1178a <= 0 ? C.NANOS_PER_SECOND : 999999999);
    }

    public final int e(q qVar) {
        return g(qVar).a(q(qVar), qVar);
    }

    public final long q(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        int i5 = s.f1175a[((a) qVar).ordinal()];
        int i6 = 1;
        if (i5 == 1) {
            int i7 = this.f1178a;
            if (i7 < 1) {
                i7 = 1 - i7;
            }
            return (long) i7;
        } else if (i5 == 2) {
            return (long) this.f1178a;
        } else {
            if (i5 == 3) {
                if (this.f1178a < 1) {
                    i6 = 0;
                }
                return (long) i6;
            }
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: y */
    public final t a(long j5, q qVar) {
        if (!(qVar instanceof a)) {
            return (t) qVar.h(this, j5);
        }
        a aVar = (a) qVar;
        aVar.k(j5);
        int i5 = s.f1175a[aVar.ordinal()];
        if (i5 == 1) {
            if (this.f1178a < 1) {
                j5 = 1 - j5;
            }
            return v((int) j5);
        } else if (i5 == 2) {
            return v((int) j5);
        } else {
            if (i5 == 3) {
                return q(a.ERA) == j5 ? this : v(1 - this.f1178a);
            }
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: w */
    public final t b(long j5, s sVar) {
        if (!(sVar instanceof b)) {
            return (t) sVar.e(this, j5);
        }
        int i5 = s.f1176b[((b) sVar).ordinal()];
        if (i5 == 1) {
            return x(j5);
        }
        if (i5 == 2) {
            return x(j$.com.android.tools.r8.a.w(j5, 10));
        }
        if (i5 == 3) {
            return x(j$.com.android.tools.r8.a.w(j5, 100));
        }
        if (i5 == 4) {
            return x(j$.com.android.tools.r8.a.w(j5, 1000));
        }
        if (i5 == 5) {
            a aVar = a.ERA;
            return a(j$.com.android.tools.r8.a.x(q(aVar), j5), aVar);
        }
        throw new RuntimeException("Unsupported unit: " + sVar);
    }

    public final t x(long j5) {
        if (j5 == 0) {
            return this;
        }
        a aVar = a.YEAR;
        return v(aVar.f1181b.a(((long) this.f1178a) + j5, aVar));
    }

    public final m n(long j5, b bVar) {
        return j5 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1, bVar) : b(-j5, bVar);
    }

    public final Object h(j$.time.format.a aVar) {
        if (aVar == r.f1200b) {
            return j$.time.chrono.s.f1072c;
        }
        if (aVar == r.f1201c) {
            return b.YEARS;
        }
        return r.c(this, aVar);
    }

    public final m k(m mVar) {
        if (j$.com.android.tools.r8.a.v(mVar).equals(j$.time.chrono.s.f1072c)) {
            return mVar.a((long) this.f1178a, a.YEAR);
        }
        throw new RuntimeException("Adjustment only supported on ISO date-time");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t) && this.f1178a == ((t) obj).f1178a;
    }

    public final int hashCode() {
        return this.f1178a;
    }

    public final String toString() {
        return Integer.toString(this.f1178a);
    }

    private Object writeReplace() {
        return new r((byte) 11, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final m f(g gVar) {
        return (t) j$.com.android.tools.r8.a.a(gVar, this);
    }
}
