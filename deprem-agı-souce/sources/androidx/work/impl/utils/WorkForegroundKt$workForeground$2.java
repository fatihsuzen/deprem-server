package androidx.work.impl.utils;

import W2.J;
import android.content.Context;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.impl.model.WorkSpec;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.work.impl.utils.WorkForegroundKt$workForeground$2", f = "WorkForeground.kt", l = {42, 50}, m = "invokeSuspend")
final class WorkForegroundKt$workForeground$2 extends l implements p {
    final /* synthetic */ Context $context;
    final /* synthetic */ ForegroundUpdater $foregroundUpdater;
    final /* synthetic */ WorkSpec $spec;
    final /* synthetic */ ListenableWorker $worker;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkForegroundKt$workForeground$2(ListenableWorker listenableWorker, WorkSpec workSpec, ForegroundUpdater foregroundUpdater, Context context, C2308e eVar) {
        super(2, eVar);
        this.$worker = listenableWorker;
        this.$spec = workSpec;
        this.$foregroundUpdater = foregroundUpdater;
        this.$context = context;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new WorkForegroundKt$workForeground$2(this.$worker, this.$spec, this.$foregroundUpdater, this.$context, eVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        if (r8 == r0) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            W2.u.b(r8)
            return r8
        L_0x0012:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001a:
            W2.u.b(r8)
            goto L_0x0037
        L_0x001e:
            W2.u.b(r8)
            androidx.work.ListenableWorker r8 = r7.$worker
            n0.d r8 = r8.getForegroundInfoAsync()
            java.lang.String r1 = "getForegroundInfoAsync(...)"
            kotlin.jvm.internal.t.d(r8, r1)
            androidx.work.ListenableWorker r1 = r7.$worker
            r7.label = r3
            java.lang.Object r8 = androidx.work.impl.WorkerWrapperKt.awaitWithin(r8, r1, r7)
            if (r8 != r0) goto L_0x0037
            goto L_0x0076
        L_0x0037:
            androidx.work.ForegroundInfo r8 = (androidx.work.ForegroundInfo) r8
            if (r8 == 0) goto L_0x0078
            java.lang.String r1 = androidx.work.impl.utils.WorkForegroundKt.TAG
            androidx.work.impl.model.WorkSpec r3 = r7.$spec
            androidx.work.Logger r4 = androidx.work.Logger.get()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Updating notification for "
            r5.append(r6)
            java.lang.String r3 = r3.workerClassName
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.debug(r1, r3)
            androidx.work.ForegroundUpdater r1 = r7.$foregroundUpdater
            android.content.Context r3 = r7.$context
            androidx.work.ListenableWorker r4 = r7.$worker
            java.util.UUID r4 = r4.getId()
            n0.d r8 = r1.setForegroundAsync(r3, r4, r8)
            java.lang.String r1 = "setForegroundAsync(...)"
            kotlin.jvm.internal.t.d(r8, r1)
            r7.label = r2
            java.lang.Object r8 = androidx.concurrent.futures.ListenableFutureKt.await(r8, r7)
            if (r8 != r0) goto L_0x0077
        L_0x0076:
            return r0
        L_0x0077:
            return r8
        L_0x0078:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Worker was marked important ("
            r8.append(r0)
            androidx.work.impl.model.WorkSpec r0 = r7.$spec
            java.lang.String r0 = r0.workerClassName
            r8.append(r0)
            java.lang.String r0 = ") but did not provide ForegroundInfo"
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.WorkForegroundKt$workForeground$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((WorkForegroundKt$workForeground$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
