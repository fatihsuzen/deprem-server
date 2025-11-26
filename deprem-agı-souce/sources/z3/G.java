package z3;

import A3.c;
import A3.d;
import B3.C1983c;
import W2.J;
import W2.t;
import androidx.lifecycle.a;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.jvm.internal.h;
import w3.C2886n;

final class G extends d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f26603a = new AtomicReference((Object) null);

    /* renamed from: d */
    public boolean a(E e5) {
        if (C1983c.a(this.f26603a) != null) {
            return false;
        }
        C1983c.b(this.f26603a, F.f26601a);
        return true;
    }

    public final Object e(C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        if (!a.a(this.f26603a, F.f26601a, nVar)) {
            t.a aVar = t.f19966b;
            nVar.resumeWith(t.b(J.f19942a));
        }
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    /* renamed from: f */
    public C2308e[] b(E e5) {
        C1983c.b(this.f26603a, (Object) null);
        return c.f17267a;
    }

    public final void g() {
        AtomicReference atomicReference = this.f26603a;
        while (true) {
            Object a5 = C1983c.a(atomicReference);
            if (a5 != null && a5 != F.f26602b) {
                if (a5 == F.f26601a) {
                    if (a.a(this.f26603a, a5, F.f26602b)) {
                        return;
                    }
                } else if (a.a(this.f26603a, a5, F.f26601a)) {
                    t.a aVar = t.f19966b;
                    ((C2886n) a5).resumeWith(t.b(J.f19942a));
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = this.f26603a.getAndSet(F.f26601a);
        kotlin.jvm.internal.t.b(andSet);
        if (andSet == F.f26602b) {
            return true;
        }
        return false;
    }
}
