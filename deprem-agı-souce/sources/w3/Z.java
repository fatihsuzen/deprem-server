package w3;

import B3.C1988h;
import B3.K;
import D3.h;
import W2.J;
import W2.t;
import W2.u;
import b3.C2308e;
import b3.C2312i;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t;

public abstract class Z extends h {

    /* renamed from: c  reason: collision with root package name */
    public int f26267c;

    public Z(int i5) {
        this.f26267c = i5;
    }

    public abstract C2308e d();

    public Throwable e(Object obj) {
        C2854A a5;
        if (obj instanceof C2854A) {
            a5 = (C2854A) obj;
        } else {
            a5 = null;
        }
        if (a5 != null) {
            return a5.f26214a;
        }
        return null;
    }

    public final void i(Throwable th) {
        K.a(d().getContext(), new P("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object j();

    public final void run() {
        C2312i context;
        Object i5;
        b1 b1Var;
        try {
            C2308e d5 = d();
            t.c(d5, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            C1988h hVar = (C1988h) d5;
            C2308e eVar = hVar.f17395e;
            Object obj = hVar.f17397g;
            context = eVar.getContext();
            i5 = K.i(context, obj);
            C2908y0 y0Var = null;
            if (i5 != K.f17373a) {
                b1Var = G.m(eVar, context, i5);
            } else {
                b1Var = null;
            }
            C2312i context2 = eVar.getContext();
            Object j5 = j();
            Throwable e5 = e(j5);
            if (e5 == null && C2861a0.b(this.f26267c)) {
                y0Var = (C2908y0) context2.get(C2908y0.f26320k0);
            }
            if (y0Var != null && !y0Var.isActive()) {
                CancellationException m5 = y0Var.m();
                b(j5, m5);
                t.a aVar = W2.t.f19966b;
                eVar.resumeWith(W2.t.b(u.a(m5)));
            } else if (e5 != null) {
                t.a aVar2 = W2.t.f19966b;
                eVar.resumeWith(W2.t.b(u.a(e5)));
            } else {
                t.a aVar3 = W2.t.f19966b;
                eVar.resumeWith(W2.t.b(f(j5)));
            }
            J j6 = J.f19942a;
            if (b1Var != null) {
                if (!b1Var.Q0()) {
                    return;
                }
            }
            K.f(context, i5);
        } catch (Throwable th) {
            i(th);
        }
    }

    public Object f(Object obj) {
        return obj;
    }

    public void b(Object obj, Throwable th) {
    }
}
