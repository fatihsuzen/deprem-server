package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2908y0;
import w3.N;
import w3.O;

public final class ListenableFutureKt {
    public static final <V> C1722d executeAsync(Executor executor, String str, C2616a aVar) {
        t.e(executor, "<this>");
        t.e(str, "debugTag");
        t.e(aVar, "block");
        C1722d future = CallbackToFutureAdapter.getFuture(new b(executor, str, aVar));
        t.d(future, "getFuture(...)");
        return future;
    }

    /* access modifiers changed from: private */
    public static final Object executeAsync$lambda$4(Executor executor, String str, C2616a aVar, CallbackToFutureAdapter.Completer completer) {
        t.e(completer, "completer");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.addCancellationListener(new d(atomicBoolean), DirectExecutor.INSTANCE);
        executor.execute(new e(atomicBoolean, completer, aVar));
        return str;
    }

    /* access modifiers changed from: private */
    public static final void executeAsync$lambda$4$lambda$2(AtomicBoolean atomicBoolean) {
        atomicBoolean.set(true);
    }

    /* access modifiers changed from: private */
    public static final void executeAsync$lambda$4$lambda$3(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, C2616a aVar) {
        if (!atomicBoolean.get()) {
            try {
                completer.set(aVar.invoke());
            } catch (Throwable th) {
                completer.setException(th);
            }
        }
    }

    public static final <T> C1722d launchFuture(C2312i iVar, O o5, p pVar) {
        t.e(iVar, "context");
        t.e(o5, "start");
        t.e(pVar, "block");
        C1722d future = CallbackToFutureAdapter.getFuture(new c(iVar, o5, pVar));
        t.d(future, "getFuture(...)");
        return future;
    }

    public static /* synthetic */ C1722d launchFuture$default(C2312i iVar, O o5, p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            iVar = C2313j.f20794a;
        }
        if ((i5 & 2) != 0) {
            o5 = O.DEFAULT;
        }
        return launchFuture(iVar, o5, pVar);
    }

    /* access modifiers changed from: private */
    public static final Object launchFuture$lambda$1(C2312i iVar, O o5, p pVar, CallbackToFutureAdapter.Completer completer) {
        t.e(completer, "completer");
        completer.addCancellationListener(new f((C2908y0) iVar.get(C2908y0.f26320k0)), DirectExecutor.INSTANCE);
        return C2876i.d(N.a(iVar), (C2312i) null, o5, new ListenableFutureKt$launchFuture$1$2(pVar, completer, (C2308e) null), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void launchFuture$lambda$1$lambda$0(C2908y0 y0Var) {
        if (y0Var != null) {
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        }
    }
}
