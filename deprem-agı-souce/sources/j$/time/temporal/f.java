package j$.time.temporal;

import j$.com.android.tools.r8.a;
import j$.time.chrono.s;
import j$.time.g;

/* 'enum' modifier removed */
public final class f extends h {
    public final u range() {
        return u.f(52, 53);
    }

    public f() {
        super("WEEK_OF_WEEK_BASED_YEAR", 2);
    }

    public final boolean e(n nVar) {
        if (!nVar.c(a.EPOCH_DAY)) {
            return false;
        }
        h hVar = j.f1189a;
        return a.v(nVar).equals(s.f1072c);
    }

    public final u f(n nVar) {
        if (e(nVar)) {
            return u.e(1, (long) h.q(h.n(g.x(nVar))));
        }
        throw new RuntimeException("Unsupported field: WeekOfWeekBasedYear");
    }

    public final long g(n nVar) {
        if (e(nVar)) {
            return (long) h.k(g.x(nVar));
        }
        throw new RuntimeException("Unsupported field: WeekOfWeekBasedYear");
    }

    public final m h(m mVar, long j5) {
        range().b(j5, this);
        return mVar.b(a.C(j5, g(mVar)), b.WEEKS);
    }

    public final String toString() {
        return "WeekOfWeekBasedYear";
    }
}
