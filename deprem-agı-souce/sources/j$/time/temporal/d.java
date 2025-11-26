package j$.time.temporal;

import j$.com.android.tools.r8.a;
import j$.time.chrono.s;

/* 'enum' modifier removed */
public final class d extends h {
    public final u range() {
        return u.f(90, 92);
    }

    public d() {
        super("DAY_OF_QUARTER", 0);
    }

    public final boolean e(n nVar) {
        if (!nVar.c(a.DAY_OF_YEAR) || !nVar.c(a.MONTH_OF_YEAR) || !nVar.c(a.YEAR)) {
            return false;
        }
        h hVar = j.f1189a;
        return a.v(nVar).equals(s.f1072c);
    }

    public final u f(n nVar) {
        if (e(nVar)) {
            long q5 = nVar.q(h.QUARTER_OF_YEAR);
            if (q5 == 1) {
                long q6 = nVar.q(a.YEAR);
                s.f1072c.getClass();
                return s.f(q6) ? u.e(1, 91) : u.e(1, 90);
            } else if (q5 == 2) {
                return u.e(1, 91);
            } else {
                if (q5 == 3 || q5 == 4) {
                    return u.e(1, 92);
                }
                return range();
            }
        } else {
            throw new RuntimeException("Unsupported field: DayOfQuarter");
        }
    }

    public final long g(n nVar) {
        if (e(nVar)) {
            int e5 = nVar.e(a.DAY_OF_YEAR);
            int e6 = nVar.e(a.MONTH_OF_YEAR);
            long q5 = nVar.q(a.YEAR);
            int i5 = (e6 - 1) / 3;
            s.f1072c.getClass();
            return (long) (e5 - h.f1185a[i5 + (s.f(q5) ? 4 : 0)]);
        }
        throw new RuntimeException("Unsupported field: DayOfQuarter");
    }

    public final m h(m mVar, long j5) {
        long g5 = g(mVar);
        range().b(j5, this);
        a aVar = a.DAY_OF_YEAR;
        return mVar.a((j5 - g5) + mVar.q(aVar), aVar);
    }

    public final String toString() {
        return "DayOfQuarter";
    }
}
