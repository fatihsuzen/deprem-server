package j$.time;

import j$.time.chrono.l;
import j$.time.chrono.s;
import j$.time.format.t;
import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

public final class n implements j$.time.temporal.n, o, Comparable, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f1162c = 0;
    private static final long serialVersionUID = -939150713474957432L;

    /* renamed from: a  reason: collision with root package name */
    public final int f1163a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1164b;

    public final int compareTo(Object obj) {
        n nVar = (n) obj;
        int i5 = this.f1163a - nVar.f1163a;
        return i5 == 0 ? this.f1164b - nVar.f1164b : i5;
    }

    static {
        j$.time.format.n nVar = new j$.time.format.n();
        nVar.d("--");
        nVar.g(a.MONTH_OF_YEAR, 2);
        nVar.c('-');
        nVar.g(a.DAY_OF_MONTH, 2);
        nVar.l(Locale.getDefault(), t.SMART, (l) null);
    }

    public n(int i5, int i6) {
        this.f1163a = i5;
        this.f1164b = i6;
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.MONTH_OF_YEAR || qVar == a.DAY_OF_MONTH : qVar != null && qVar.e(this);
    }

    public final u g(q qVar) {
        if (qVar == a.MONTH_OF_YEAR) {
            return qVar.range();
        }
        if (qVar != a.DAY_OF_MONTH) {
            return r.d(this, qVar);
        }
        l y4 = l.y(this.f1163a);
        y4.getClass();
        int i5 = k.f1158a[y4.ordinal()];
        return u.f((long) (i5 != 1 ? (i5 == 2 || i5 == 3 || i5 == 4 || i5 == 5) ? 30 : 31 : 28), (long) l.y(this.f1163a).x());
    }

    public final int e(q qVar) {
        return g(qVar).a(q(qVar), qVar);
    }

    public final long q(q qVar) {
        int i5;
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        int i6 = m.f1161a[((a) qVar).ordinal()];
        if (i6 == 1) {
            i5 = this.f1164b;
        } else if (i6 == 2) {
            i5 = this.f1163a;
        } else {
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
        return (long) i5;
    }

    public final Object h(j$.time.format.a aVar) {
        if (aVar == r.f1200b) {
            return s.f1072c;
        }
        return r.c(this, aVar);
    }

    public final m k(m mVar) {
        if (j$.com.android.tools.r8.a.v(mVar).equals(s.f1072c)) {
            m a5 = mVar.a((long) this.f1163a, a.MONTH_OF_YEAR);
            a aVar = a.DAY_OF_MONTH;
            return a5.a(Math.min(a5.g(aVar).f1209d, (long) this.f1164b), aVar);
        }
        throw new RuntimeException("Adjustment only supported on ISO date-time");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            return this.f1163a == nVar.f1163a && this.f1164b == nVar.f1164b;
        }
    }

    public final int hashCode() {
        return (this.f1163a << 6) + this.f1164b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.f1163a < 10 ? "0" : "");
        sb.append(this.f1163a);
        sb.append(this.f1164b < 10 ? "-0" : "-");
        sb.append(this.f1164b);
        return sb.toString();
    }

    private Object writeReplace() {
        return new r((byte) 13, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
