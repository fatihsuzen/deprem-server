package j$.time.chrono;

import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.q;
import j$.time.temporal.u;

public enum r implements m {
    ;

    public final int getValue() {
        return 1;
    }

    public final u g(q qVar) {
        if (qVar == a.ERA) {
            return u.e(1, 1);
        }
        return j$.time.temporal.r.d(this, qVar);
    }

    public final m k(m mVar) {
        return mVar.a((long) 1, a.ERA);
    }
}
