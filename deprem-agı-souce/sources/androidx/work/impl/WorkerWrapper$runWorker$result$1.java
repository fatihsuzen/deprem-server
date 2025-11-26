package androidx.work.impl;

import W2.J;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.work.impl.WorkerWrapper$runWorker$result$1", f = "WorkerWrapper.kt", l = {300, 311}, m = "invokeSuspend")
final class WorkerWrapper$runWorker$result$1 extends l implements p {
    final /* synthetic */ ForegroundUpdater $foregroundUpdater;
    final /* synthetic */ ListenableWorker $worker;
    int label;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkerWrapper$runWorker$result$1(WorkerWrapper workerWrapper, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, C2308e eVar) {
        super(2, eVar);
        this.this$0 = workerWrapper;
        this.$worker = listenableWorker;
        this.$foregroundUpdater = foregroundUpdater;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new WorkerWrapper$runWorker$result$1(this.this$0, this.$worker, this.$foregroundUpdater, eVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
        if (androidx.work.impl.utils.WorkForegroundKt.workForeground(r4, r5, r6, r7, r8, r9) == r0) goto L_0x007b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            W2.u.b(r11)
            return r11
        L_0x0012:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001a:
            W2.u.b(r11)
            r9 = r10
            goto L_0x0042
        L_0x001f:
            W2.u.b(r11)
            androidx.work.impl.WorkerWrapper r11 = r10.this$0
            android.content.Context r4 = r11.appContext
            androidx.work.impl.WorkerWrapper r11 = r10.this$0
            androidx.work.impl.model.WorkSpec r5 = r11.getWorkSpec()
            androidx.work.ListenableWorker r6 = r10.$worker
            androidx.work.ForegroundUpdater r7 = r10.$foregroundUpdater
            androidx.work.impl.WorkerWrapper r11 = r10.this$0
            androidx.work.impl.utils.taskexecutor.TaskExecutor r8 = r11.workTaskExecutor
            r10.label = r3
            r9 = r10
            java.lang.Object r11 = androidx.work.impl.utils.WorkForegroundKt.workForeground(r4, r5, r6, r7, r8, r9)
            if (r11 != r0) goto L_0x0042
            goto L_0x007b
        L_0x0042:
            java.lang.String r11 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.impl.WorkerWrapper r1 = r9.this$0
            androidx.work.Logger r3 = androidx.work.Logger.get()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Starting work for "
            r4.append(r5)
            androidx.work.impl.model.WorkSpec r1 = r1.getWorkSpec()
            java.lang.String r1 = r1.workerClassName
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.debug(r11, r1)
            androidx.work.ListenableWorker r11 = r9.$worker
            n0.d r11 = r11.startWork()
            java.lang.String r1 = "startWork(...)"
            kotlin.jvm.internal.t.d(r11, r1)
            androidx.work.ListenableWorker r1 = r9.$worker
            r9.label = r2
            java.lang.Object r11 = androidx.work.impl.WorkerWrapperKt.awaitWithin(r11, r1, r10)
            if (r11 != r0) goto L_0x007c
        L_0x007b:
            return r0
        L_0x007c:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper$runWorker$result$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((WorkerWrapper$runWorker$result$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
