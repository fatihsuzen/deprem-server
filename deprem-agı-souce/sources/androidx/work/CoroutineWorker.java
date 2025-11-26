package androidx.work;

import W2.J;
import android.content.Context;
import androidx.concurrent.futures.ListenableFutureKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2865c0;
import w3.C2908y0;
import w3.I;
import w3.O;

public abstract class CoroutineWorker extends ListenableWorker {
    private final I coroutineContext = DeprecatedDispatcher.INSTANCE;
    private final WorkerParameters params;

    private static final class DeprecatedDispatcher extends I {
        public static final DeprecatedDispatcher INSTANCE = new DeprecatedDispatcher();
        private static final I dispatcher = C2865c0.a();

        private DeprecatedDispatcher() {
        }

        public void dispatch(C2312i iVar, Runnable runnable) {
            t.e(iVar, "context");
            t.e(runnable, "block");
            dispatcher.dispatch(iVar, runnable);
        }

        public final I getDispatcher() {
            return dispatcher;
        }

        public boolean isDispatchNeeded(C2312i iVar) {
            t.e(iVar, "context");
            return dispatcher.isDispatchNeeded(iVar);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "appContext");
        t.e(workerParameters, "params");
        this.params = workerParameters;
    }

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, C2308e eVar) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object doWork(C2308e eVar);

    public I getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object getForegroundInfo(C2308e eVar) {
        return getForegroundInfo$suspendImpl(this, eVar);
    }

    public final C1722d getForegroundInfoAsync() {
        return ListenableFutureKt.launchFuture$default(getCoroutineContext().plus(C0.b((C2908y0) null, 1, (Object) null)), (O) null, new CoroutineWorker$getForegroundInfoAsync$1(this, (C2308e) null), 2, (Object) null);
    }

    public final void onStopped() {
        super.onStopped();
    }

    public final Object setForeground(ForegroundInfo foregroundInfo, C2308e eVar) {
        C1722d foregroundAsync = setForegroundAsync(foregroundInfo);
        t.d(foregroundAsync, "setForegroundAsync(...)");
        Object await = ListenableFutureKt.await(foregroundAsync, eVar);
        if (await == C2316b.f()) {
            return await;
        }
        return J.f19942a;
    }

    public final Object setProgress(Data data, C2308e eVar) {
        C1722d progressAsync = setProgressAsync(data);
        t.d(progressAsync, "setProgressAsync(...)");
        Object await = ListenableFutureKt.await(progressAsync, eVar);
        if (await == C2316b.f()) {
            return await;
        }
        return J.f19942a;
    }

    public final C1722d startWork() {
        C2312i iVar;
        if (!t.a(getCoroutineContext(), DeprecatedDispatcher.INSTANCE)) {
            iVar = getCoroutineContext();
        } else {
            iVar = this.params.getWorkerContext();
        }
        t.b(iVar);
        return ListenableFutureKt.launchFuture$default(iVar.plus(C0.b((C2908y0) null, 1, (Object) null)), (O) null, new CoroutineWorker$startWork$1(this, (C2308e) null), 2, (Object) null);
    }
}
