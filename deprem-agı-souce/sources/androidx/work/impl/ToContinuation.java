package androidx.work.impl;

import W2.t;
import W2.u;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2882l;

final class ToContinuation<T> implements Runnable {
    private final C2882l continuation;
    private final C1722d futureToObserve;

    public ToContinuation(C1722d dVar, C2882l lVar) {
        t.e(dVar, "futureToObserve");
        t.e(lVar, "continuation");
        this.futureToObserve = dVar;
        this.continuation = lVar;
    }

    public final C2882l getContinuation() {
        return this.continuation;
    }

    public final C1722d getFutureToObserve() {
        return this.futureToObserve;
    }

    public void run() {
        if (this.futureToObserve.isCancelled()) {
            C2882l.a.a(this.continuation, (Throwable) null, 1, (Object) null);
            return;
        }
        try {
            C2882l lVar = this.continuation;
            t.a aVar = W2.t.f19966b;
            lVar.resumeWith(W2.t.b(WorkerWrapperKt.getUninterruptibly(this.futureToObserve)));
        } catch (ExecutionException e5) {
            C2882l lVar2 = this.continuation;
            t.a aVar2 = W2.t.f19966b;
            lVar2.resumeWith(W2.t.b(u.a(WorkerWrapperKt.nonNullCause(e5))));
        }
    }
}
