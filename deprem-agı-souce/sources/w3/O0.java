package w3;

import W2.t;
import W2.u;

final class O0 extends D0 {

    /* renamed from: e  reason: collision with root package name */
    private final C2886n f26252e;

    public O0(C2886n nVar) {
        this.f26252e = nVar;
    }

    public boolean u() {
        return false;
    }

    public void v(Throwable th) {
        Object e02 = t().e0();
        if (e02 instanceof C2854A) {
            C2886n nVar = this.f26252e;
            t.a aVar = t.f19966b;
            nVar.resumeWith(t.b(u.a(((C2854A) e02).f26214a)));
            return;
        }
        C2886n nVar2 = this.f26252e;
        t.a aVar2 = t.f19966b;
        nVar2.resumeWith(t.b(F0.h(e02)));
    }
}
