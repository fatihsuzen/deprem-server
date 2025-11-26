package w3;

import W2.J;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.concurrent.CancellationException;
import k3.l;
import kotlin.jvm.internal.C2639q;
import w3.C2908y0;

abstract /* synthetic */ class C0 {

    /* synthetic */ class a extends C2639q implements l {
        a(Object obj) {
            super(1, obj, D0.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
        }

        public final void g(Throwable th) {
            ((D0) this.receiver).v(th);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            g((Throwable) obj);
            return J.f19942a;
        }
    }

    public static final C2907y a(C2908y0 y0Var) {
        return new A0(y0Var);
    }

    public static /* synthetic */ C2907y b(C2908y0 y0Var, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            y0Var = null;
        }
        return B0.a(y0Var);
    }

    public static final void c(C2312i iVar, CancellationException cancellationException) {
        C2908y0 y0Var = (C2908y0) iVar.get(C2908y0.f26320k0);
        if (y0Var != null) {
            y0Var.a(cancellationException);
        }
    }

    public static /* synthetic */ void d(C2312i iVar, CancellationException cancellationException, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            cancellationException = null;
        }
        B0.c(iVar, cancellationException);
    }

    public static final Object e(C2908y0 y0Var, C2308e eVar) {
        C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        Object l5 = y0Var.l(eVar);
        if (l5 == C2316b.f()) {
            return l5;
        }
        return J.f19942a;
    }

    public static final C2869e0 f(C2908y0 y0Var, C2869e0 e0Var) {
        return j(y0Var, false, new C2873g0(e0Var), 1, (Object) null);
    }

    public static final void g(C2312i iVar) {
        C2908y0 y0Var = (C2908y0) iVar.get(C2908y0.f26320k0);
        if (y0Var != null) {
            B0.h(y0Var);
        }
    }

    public static final void h(C2908y0 y0Var) {
        if (!y0Var.isActive()) {
            throw y0Var.m();
        }
    }

    public static final C2869e0 i(C2908y0 y0Var, boolean z4, D0 d02) {
        if (y0Var instanceof E0) {
            return ((E0) y0Var).k0(z4, d02);
        }
        return y0Var.p(d02.u(), z4, new a(d02));
    }

    public static /* synthetic */ C2869e0 j(C2908y0 y0Var, boolean z4, D0 d02, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = true;
        }
        return B0.i(y0Var, z4, d02);
    }
}
