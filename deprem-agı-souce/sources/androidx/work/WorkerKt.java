package androidx.work;

import W2.J;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.C2616a;
import kotlin.jvm.internal.t;
import n0.C1722d;

public final class WorkerKt {
    /* access modifiers changed from: private */
    public static final <T> C1722d future(Executor executor, C2616a aVar) {
        C1722d future = CallbackToFutureAdapter.getFuture(new n(executor, aVar));
        t.d(future, "getFuture(...)");
        return future;
    }

    /* access modifiers changed from: private */
    public static final J future$lambda$2(Executor executor, C2616a aVar, CallbackToFutureAdapter.Completer completer) {
        t.e(completer, "it");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.addCancellationListener(new l(atomicBoolean), DirectExecutor.INSTANCE);
        executor.execute(new m(atomicBoolean, completer, aVar));
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void future$lambda$2$lambda$0(AtomicBoolean atomicBoolean) {
        atomicBoolean.set(true);
    }

    /* access modifiers changed from: private */
    public static final void future$lambda$2$lambda$1(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, C2616a aVar) {
        if (!atomicBoolean.get()) {
            try {
                completer.set(aVar.invoke());
            } catch (Throwable th) {
                completer.setException(th);
            }
        }
    }
}
