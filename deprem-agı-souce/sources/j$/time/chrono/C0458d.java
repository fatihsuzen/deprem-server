package j$.time.chrono;

import j$.com.android.tools.r8.a;
import j$.time.c;
import j$.time.j;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.u;
import java.io.Serializable;

/* renamed from: j$.time.chrono.d  reason: case insensitive filesystem */
public abstract class C0458d implements C0456b, m, o, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public abstract C0456b A(long j5);

    public /* synthetic */ boolean c(q qVar) {
        return a.n(this, qVar);
    }

    public final /* synthetic */ int e(q qVar) {
        return r.a(this, qVar);
    }

    public /* synthetic */ u g(q qVar) {
        return r.d(this, qVar);
    }

    public final /* synthetic */ Object h(j$.time.format.a aVar) {
        return a.p(this, aVar);
    }

    public final /* synthetic */ m k(m mVar) {
        return a.a(this, mVar);
    }

    /* renamed from: u */
    public final /* synthetic */ int compareTo(C0456b bVar) {
        return a.g(this, bVar);
    }

    public abstract C0456b y(long j5);

    public abstract C0456b z(long j5);

    public static C0456b v(l lVar, m mVar) {
        C0456b bVar = (C0456b) mVar;
        if (lVar.equals(bVar.getChronology())) {
            return bVar;
        }
        String d5 = lVar.d();
        String d6 = bVar.getChronology().d();
        throw new ClassCastException("Chronology mismatch, expected: " + d5 + ", actual: " + d6);
    }

    public C0459e s(j jVar) {
        return new C0461g(this, jVar);
    }

    public C0456b b(long j5, s sVar) {
        boolean z4 = sVar instanceof b;
        if (z4) {
            switch (C0457c.f1041a[((b) sVar).ordinal()]) {
                case 1:
                    return y(j5);
                case 2:
                    return y(a.w(j5, 7));
                case 3:
                    return z(j5);
                case 4:
                    return A(j5);
                case 5:
                    return A(a.w(j5, 10));
                case 6:
                    return A(a.w(j5, 100));
                case 7:
                    return A(a.w(j5, 1000));
                case 8:
                    j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                    return a(a.x(q(aVar), j5), (q) aVar);
                default:
                    throw new RuntimeException("Unsupported unit: " + sVar);
            }
        } else if (!z4) {
            return v(getChronology(), sVar.e(this, j5));
        } else {
            throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    public m w() {
        return getChronology().l(r.a(this, j$.time.temporal.a.ERA));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0456b) && a.g(this, (C0456b) obj) == 0;
    }

    public int hashCode() {
        long r5 = r();
        return ((int) (r5 ^ (r5 >>> 32))) ^ getChronology().hashCode();
    }

    /* renamed from: B */
    public C0456b f(o oVar) {
        return v(getChronology(), oVar.k(this));
    }

    public final String toString() {
        long q5 = q(j$.time.temporal.a.YEAR_OF_ERA);
        long q6 = q(j$.time.temporal.a.MONTH_OF_YEAR);
        long q7 = q(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(getChronology().toString());
        sb.append(" ");
        sb.append(w());
        sb.append(" ");
        sb.append(q5);
        String str = "-";
        sb.append(q6 < 10 ? "-0" : str);
        sb.append(q6);
        if (q7 < 10) {
            str = "-0";
        }
        sb.append(str);
        sb.append(q7);
        return sb.toString();
    }

    public C0456b a(long j5, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return v(getChronology(), qVar.h(this, j5));
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    /* renamed from: x */
    public C0456b n(long j5, s sVar) {
        return v(getChronology(), r.b(this, j5, sVar));
    }

    public long r() {
        return q(j$.time.temporal.a.EPOCH_DAY);
    }
}
