package j$.time.temporal;

import j$.com.android.tools.r8.a;
import j$.time.chrono.s;

/* 'enum' modifier removed */
public final class g extends h {
    public g() {
        super("WEEK_BASED_YEAR", 3);
    }

    public final u range() {
        return a.YEAR.f1181b;
    }

    public final boolean e(n nVar) {
        if (!nVar.c(a.EPOCH_DAY)) {
            return false;
        }
        h hVar = j.f1189a;
        return a.v(nVar).equals(s.f1072c);
    }

    public final long g(n nVar) {
        if (e(nVar)) {
            return (long) h.n(j$.time.g.x(nVar));
        }
        throw new RuntimeException("Unsupported field: WeekBasedYear");
    }

    public final u f(n nVar) {
        if (e(nVar)) {
            return range();
        }
        throw new RuntimeException("Unsupported field: WeekBasedYear");
    }

    public final m h(m mVar, long j5) {
        if (e(mVar)) {
            int a5 = a.YEAR.f1181b.a(j5, h.WEEK_BASED_YEAR);
            j$.time.g x4 = j$.time.g.x(mVar);
            a aVar = a.DAY_OF_WEEK;
            int e5 = x4.e(aVar);
            int k5 = h.k(x4);
            if (k5 == 53 && h.q(a5) == 52) {
                k5 = 52;
            }
            j$.time.g D4 = j$.time.g.D(a5, 1, 4);
            return mVar.f(D4.G((long) (((k5 - 1) * 7) + (e5 - D4.e(aVar)))));
        }
        throw new RuntimeException("Unsupported field: WeekBasedYear");
    }

    public final String toString() {
        return "WeekBasedYear";
    }
}
