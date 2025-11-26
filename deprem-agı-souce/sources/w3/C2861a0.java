package w3;

import B3.C1988h;
import B3.K;
import W2.J;
import W2.t;
import W2.u;
import b3.C2308e;
import b3.C2312i;

/* renamed from: w3.a0  reason: case insensitive filesystem */
public abstract class C2861a0 {
    public static final void a(Z z4, int i5) {
        boolean z5;
        C2308e d5 = z4.d();
        if (i5 == 4) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 || !(d5 instanceof C1988h) || b(i5) != b(z4.f26267c)) {
            d(z4, d5, z5);
            return;
        }
        C1988h hVar = (C1988h) d5;
        I i6 = hVar.f17394d;
        C2312i context = hVar.getContext();
        if (i6.isDispatchNeeded(context)) {
            i6.dispatch(context, z4);
        } else {
            e(z4);
        }
    }

    public static final boolean b(int i5) {
        if (i5 == 1 || i5 == 2) {
            return true;
        }
        return false;
    }

    public static final boolean c(int i5) {
        if (i5 == 2) {
            return true;
        }
        return false;
    }

    public static final void d(Z z4, C2308e eVar, boolean z5) {
        Object f5;
        b1 b1Var;
        Object j5 = z4.j();
        Throwable e5 = z4.e(j5);
        if (e5 != null) {
            t.a aVar = t.f19966b;
            f5 = u.a(e5);
        } else {
            t.a aVar2 = t.f19966b;
            f5 = z4.f(j5);
        }
        Object b5 = t.b(f5);
        if (z5) {
            kotlin.jvm.internal.t.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            C1988h hVar = (C1988h) eVar;
            C2308e eVar2 = hVar.f17395e;
            Object obj = hVar.f17397g;
            C2312i context = eVar2.getContext();
            Object i5 = K.i(context, obj);
            if (i5 != K.f17373a) {
                b1Var = G.m(eVar2, context, i5);
            } else {
                b1Var = null;
            }
            try {
                hVar.f17395e.resumeWith(b5);
                J j6 = J.f19942a;
                if (b1Var == null || b1Var.Q0()) {
                    K.f(context, i5);
                }
            } catch (Throwable th) {
                if (b1Var == null || b1Var.Q0()) {
                    K.f(context, i5);
                }
                throw th;
            }
        } else {
            eVar.resumeWith(b5);
        }
    }

    private static final void e(Z z4) {
        C2877i0 b5 = W0.f26260a.b();
        if (b5.M()) {
            b5.I(z4);
            return;
        }
        b5.K(true);
        try {
            d(z4, z4.d(), true);
            do {
            } while (b5.P());
        } catch (Throwable th) {
            b5.F(true);
            throw th;
        }
        b5.F(true);
    }
}
