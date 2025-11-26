package j$.time.temporal;

import j$.com.android.tools.r8.a;
import j$.time.chrono.s;

/* 'enum' modifier removed */
public final class e extends h {
    public e() {
        super("QUARTER_OF_YEAR", 1);
    }

    public final u range() {
        return u.e(1, 4);
    }

    public final boolean e(n nVar) {
        if (!nVar.c(a.MONTH_OF_YEAR)) {
            return false;
        }
        h hVar = j.f1189a;
        return a.v(nVar).equals(s.f1072c);
    }

    public final long g(n nVar) {
        if (e(nVar)) {
            return (nVar.q(a.MONTH_OF_YEAR) + 2) / 3;
        }
        throw new RuntimeException("Unsupported field: QuarterOfYear");
    }

    public final u f(n nVar) {
        if (e(nVar)) {
            return range();
        }
        throw new RuntimeException("Unsupported field: QuarterOfYear");
    }

    public final m h(m mVar, long j5) {
        long g5 = g(mVar);
        range().b(j5, this);
        a aVar = a.MONTH_OF_YEAR;
        return mVar.a(((j5 - g5) * 3) + mVar.q(aVar), aVar);
    }

    public final String toString() {
        return "QuarterOfYear";
    }
}
