package j$.time.chrono;

import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;

public enum D implements m {
    ;

    public final int getValue() {
        return ordinal();
    }

    public final u g(q qVar) {
        return r.d(this, qVar);
    }

    public final m k(m mVar) {
        return mVar.a((long) getValue(), a.ERA);
    }
}
