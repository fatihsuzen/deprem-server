package androidx.core.util;

import W2.J;
import W2.t;
import b3.C2308e;
import java.util.concurrent.atomic.AtomicBoolean;

final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final C2308e continuation;

    public ContinuationRunnable(C2308e eVar) {
        super(false);
        this.continuation = eVar;
    }

    public void run() {
        if (compareAndSet(false, true)) {
            C2308e eVar = this.continuation;
            t.a aVar = t.f19966b;
            eVar.resumeWith(t.b(J.f19942a));
        }
    }

    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
