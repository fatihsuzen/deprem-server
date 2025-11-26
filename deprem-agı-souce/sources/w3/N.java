package w3;

import B3.C1984d;
import B3.z;
import C3.b;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.concurrent.CancellationException;
import k3.p;
import kotlin.coroutines.jvm.internal.h;

public abstract class N {
    public static final M a(C2312i iVar) {
        if (iVar.get(C2908y0.f26320k0) == null) {
            iVar = iVar.plus(C0.b((C2908y0) null, 1, (Object) null));
        }
        return new C1984d(iVar);
    }

    public static final void b(M m5, CancellationException cancellationException) {
        C2908y0 y0Var = (C2908y0) m5.getCoroutineContext().get(C2908y0.f26320k0);
        if (y0Var != null) {
            y0Var.a(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + m5).toString());
    }

    public static /* synthetic */ void c(M m5, CancellationException cancellationException, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            cancellationException = null;
        }
        b(m5, cancellationException);
    }

    public static final Object d(p pVar, C2308e eVar) {
        z zVar = new z(eVar.getContext(), eVar);
        Object b5 = b.b(zVar, zVar, pVar);
        if (b5 == C2316b.f()) {
            h.c(eVar);
        }
        return b5;
    }

    public static final void e(M m5) {
        B0.g(m5.getCoroutineContext());
    }
}
