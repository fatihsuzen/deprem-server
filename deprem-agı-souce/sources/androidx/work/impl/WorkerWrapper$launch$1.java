package androidx.work.impl;

import W2.J;
import W2.q;
import W2.u;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.WorkerWrapper;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.CancellationException;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2872g;
import w3.C2907y;
import w3.M;

@f(c = "androidx.work.impl.WorkerWrapper$launch$1", f = "WorkerWrapper.kt", l = {98}, m = "invokeSuspend")
final class WorkerWrapper$launch$1 extends l implements p {
    int label;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkerWrapper$launch$1(WorkerWrapper workerWrapper, C2308e eVar) {
        super(2, eVar);
        this.this$0 = workerWrapper;
    }

    /* access modifiers changed from: private */
    public static final Boolean invokeSuspend$lambda$1(WorkerWrapper.Resolution resolution, WorkerWrapper workerWrapper) {
        boolean z4;
        if (resolution instanceof WorkerWrapper.Resolution.Finished) {
            z4 = workerWrapper.onWorkFinished(((WorkerWrapper.Resolution.Finished) resolution).getResult());
        } else if (resolution instanceof WorkerWrapper.Resolution.Failed) {
            workerWrapper.setFailed(((WorkerWrapper.Resolution.Failed) resolution).getResult());
            z4 = false;
        } else if (resolution instanceof WorkerWrapper.Resolution.ResetWorkerStatus) {
            z4 = workerWrapper.resetWorkerStatus(((WorkerWrapper.Resolution.ResetWorkerStatus) resolution).getReason());
        } else {
            throw new q();
        }
        return Boolean.valueOf(z4);
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new WorkerWrapper$launch$1(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        WorkerWrapper.Resolution resolution;
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            C2907y access$getWorkerJob$p = this.this$0.workerJob;
            WorkerWrapper$launch$1$resolution$1 workerWrapper$launch$1$resolution$1 = new WorkerWrapper$launch$1$resolution$1(this.this$0, (C2308e) null);
            this.label = 1;
            obj = C2872g.g(access$getWorkerJob$p, workerWrapper$launch$1$resolution$1, this);
            if (obj == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            try {
                u.b(obj);
            } catch (WorkerStoppedException e5) {
                resolution = new WorkerWrapper.Resolution.ResetWorkerStatus(e5.getReason());
            } catch (CancellationException unused) {
                resolution = new WorkerWrapper.Resolution.Failed((ListenableWorker.Result) null, 1, (C2633k) null);
            } catch (Throwable th) {
                Logger.get().error(WorkerWrapperKt.TAG, "Unexpected error in WorkerWrapper", th);
                resolution = new WorkerWrapper.Resolution.Failed((ListenableWorker.Result) null, 1, (C2633k) null);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        resolution = (WorkerWrapper.Resolution) obj;
        Object runInTransaction = this.this$0.workDatabase.runInTransaction(new E(resolution, this.this$0));
        t.d(runInTransaction, "runInTransaction(...)");
        return runInTransaction;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((WorkerWrapper$launch$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
