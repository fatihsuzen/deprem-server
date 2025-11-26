package androidx.concurrent.futures;

import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2886n;

public final class ListenableFutureKt {
    public static final <T> Object await(C1722d dVar, C2308e eVar) {
        try {
            if (dVar.isDone()) {
                return AbstractResolvableFuture.getUninterruptibly(dVar);
            }
            C2886n nVar = new C2886n(C2316b.c(eVar), 1);
            dVar.addListener(new ToContinuation(dVar, nVar), DirectExecutor.INSTANCE);
            nVar.g(new ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(dVar));
            Object x4 = nVar.x();
            if (x4 == C2316b.f()) {
                h.c(eVar);
            }
            return x4;
        } catch (ExecutionException e5) {
            throw nonNullCause(e5);
        }
    }

    /* access modifiers changed from: private */
    public static final Throwable nonNullCause(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        if (cause == null) {
            t.q();
        }
        return cause;
    }
}
