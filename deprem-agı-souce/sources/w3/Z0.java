package w3;

import C3.b;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.h;

public abstract class Z0 {
    public static final X0 a(long j5, W w4, C2908y0 y0Var) {
        return new X0("Timed out waiting for " + j5 + " ms", y0Var);
    }

    private static final Object b(Y0 y02, p pVar) {
        B0.f(y02, X.c(y02.f17429d.getContext()).q(y02.f26266e, y02, y02.getContext()));
        return b.c(y02, y02, pVar);
    }

    public static final Object c(long j5, p pVar, C2308e eVar) {
        if (j5 > 0) {
            Object b5 = b(new Y0(j5, eVar), pVar);
            if (b5 == C2316b.f()) {
                h.c(eVar);
            }
            return b5;
        }
        throw new X0("Timed out immediately");
    }

    public static final Object d(long j5, p pVar, C2308e eVar) {
        return c(X.d(j5), pVar, eVar);
    }
}
