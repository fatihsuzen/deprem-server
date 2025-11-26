package C3;

import B3.C1989i;
import W2.J;
import W2.t;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;

public abstract class a {
    private static final void a(C2308e eVar, Throwable th) {
        t.a aVar = t.f19966b;
        eVar.resumeWith(t.b(u.a(th)));
        throw th;
    }

    public static final void b(C2308e eVar, C2308e eVar2) {
        try {
            C2308e c5 = C2316b.c(eVar);
            t.a aVar = t.f19966b;
            C1989i.b(c5, t.b(J.f19942a));
        } catch (Throwable th) {
            a(eVar2, th);
        }
    }

    public static final void c(p pVar, Object obj, C2308e eVar) {
        try {
            C2308e c5 = C2316b.c(C2316b.a(pVar, obj, eVar));
            t.a aVar = t.f19966b;
            C1989i.b(c5, t.b(J.f19942a));
        } catch (Throwable th) {
            a(eVar, th);
        }
    }
}
