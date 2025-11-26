package androidx.work.impl.workers;

import W2.J;
import androidx.work.ListenableWorker;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2", f = "ConstraintTrackingWorker.kt", l = {134}, m = "invokeSuspend")
final class ConstraintTrackingWorker$runWorker$2 extends l implements p {
    final /* synthetic */ ListenableWorker $delegate;
    final /* synthetic */ WorkConstraintsTracker $workConstraintsTracker;
    final /* synthetic */ WorkSpec $workSpec;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstraintTrackingWorker$runWorker$2(ListenableWorker listenableWorker, WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, C2308e eVar) {
        super(2, eVar);
        this.$delegate = listenableWorker;
        this.$workConstraintsTracker = workConstraintsTracker;
        this.$workSpec = workSpec;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        ConstraintTrackingWorker$runWorker$2 constraintTrackingWorker$runWorker$2 = new ConstraintTrackingWorker$runWorker$2(this.$delegate, this.$workConstraintsTracker, this.$workSpec, eVar);
        constraintTrackingWorker$runWorker$2.L$0 = obj;
        return constraintTrackingWorker$runWorker$2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: w3.y0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: n0.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.util.concurrent.atomic.AtomicInteger} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r14.label
            java.lang.String r2 = "Delegated worker "
            r3 = -256(0xffffffffffffff00, float:NaN)
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 != r5) goto L_0x002b
            java.lang.Object r0 = r14.L$2
            r1 = r0
            w3.y0 r1 = (w3.C2908y0) r1
            java.lang.Object r0 = r14.L$1
            r6 = r0
            n0.d r6 = (n0.C1722d) r6
            java.lang.Object r0 = r14.L$0
            r7 = r0
            java.util.concurrent.atomic.AtomicInteger r7 = (java.util.concurrent.atomic.AtomicInteger) r7
            W2.u.b(r15)     // Catch:{ CancellationException -> 0x0027, all -> 0x0023 }
            goto L_0x0074
        L_0x0023:
            r0 = move-exception
            r15 = r0
            goto L_0x0083
        L_0x0027:
            r0 = move-exception
        L_0x0028:
            r15 = r0
            goto L_0x00ac
        L_0x002b:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0033:
            W2.u.b(r15)
            java.lang.Object r15 = r14.L$0
            r6 = r15
            w3.M r6 = (w3.M) r6
            java.util.concurrent.atomic.AtomicInteger r10 = new java.util.concurrent.atomic.AtomicInteger
            r10.<init>(r3)
            androidx.work.ListenableWorker r15 = r14.$delegate
            n0.d r11 = r15.startWork()
            java.lang.String r15 = "startWork(...)"
            kotlin.jvm.internal.t.d(r11, r15)
            androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1 r7 = new androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1
            androidx.work.impl.constraints.WorkConstraintsTracker r8 = r14.$workConstraintsTracker
            androidx.work.impl.model.WorkSpec r9 = r14.$workSpec
            r12 = 0
            r7.<init>(r8, r9, r10, r11, r12)
            r1 = r10
            r15 = r11
            r10 = 3
            r11 = 0
            r9 = r7
            r7 = 0
            r8 = 0
            w3.y0 r6 = w3.C2876i.d(r6, r7, r8, r9, r10, r11)
            r14.L$0 = r1     // Catch:{ CancellationException -> 0x007e, all -> 0x007a }
            r14.L$1 = r15     // Catch:{ CancellationException -> 0x007e, all -> 0x007a }
            r14.L$2 = r6     // Catch:{ CancellationException -> 0x007e, all -> 0x007a }
            r14.label = r5     // Catch:{ CancellationException -> 0x007e, all -> 0x007a }
            java.lang.Object r7 = androidx.concurrent.futures.ListenableFutureKt.await(r15, r14)     // Catch:{ CancellationException -> 0x007e, all -> 0x007a }
            if (r7 != r0) goto L_0x006f
            return r0
        L_0x006f:
            r13 = r6
            r6 = r15
            r15 = r7
            r7 = r1
            r1 = r13
        L_0x0074:
            androidx.work.ListenableWorker$Result r15 = (androidx.work.ListenableWorker.Result) r15     // Catch:{ CancellationException -> 0x0027, all -> 0x0023 }
            w3.C2908y0.a.a(r1, r4, r5, r4)
            return r15
        L_0x007a:
            r0 = move-exception
            r15 = r0
            r1 = r6
            goto L_0x0083
        L_0x007e:
            r0 = move-exception
            r7 = r1
            r1 = r6
            r6 = r15
            goto L_0x0028
        L_0x0083:
            java.lang.String r0 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG     // Catch:{ all -> 0x00a9 }
            androidx.work.ListenableWorker r3 = r14.$delegate     // Catch:{ all -> 0x00a9 }
            androidx.work.Logger r6 = androidx.work.Logger.get()     // Catch:{ all -> 0x00a9 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r7.<init>()     // Catch:{ all -> 0x00a9 }
            r7.append(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.Class r2 = r3.getClass()     // Catch:{ all -> 0x00a9 }
            r7.append(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = " threw exception in startWork."
            r7.append(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x00a9 }
            r6.debug(r0, r2, r15)     // Catch:{ all -> 0x00a9 }
            throw r15     // Catch:{ all -> 0x00a9 }
        L_0x00a9:
            r0 = move-exception
            r15 = r0
            goto L_0x00ed
        L_0x00ac:
            java.lang.String r0 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG     // Catch:{ all -> 0x00a9 }
            androidx.work.ListenableWorker r8 = r14.$delegate     // Catch:{ all -> 0x00a9 }
            androidx.work.Logger r9 = androidx.work.Logger.get()     // Catch:{ all -> 0x00a9 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r10.<init>()     // Catch:{ all -> 0x00a9 }
            r10.append(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.Class r2 = r8.getClass()     // Catch:{ all -> 0x00a9 }
            r10.append(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = " was cancelled"
            r10.append(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = r10.toString()     // Catch:{ all -> 0x00a9 }
            r9.debug(r0, r2, r15)     // Catch:{ all -> 0x00a9 }
            int r0 = r7.get()     // Catch:{ all -> 0x00a9 }
            if (r0 == r3) goto L_0x00d9
            r0 = r5
            goto L_0x00da
        L_0x00d9:
            r0 = 0
        L_0x00da:
            boolean r2 = r6.isCancelled()     // Catch:{ all -> 0x00a9 }
            if (r2 == 0) goto L_0x00ec
            if (r0 == 0) goto L_0x00ec
            androidx.work.impl.workers.ConstraintTrackingWorker$ConstraintUnsatisfiedException r15 = new androidx.work.impl.workers.ConstraintTrackingWorker$ConstraintUnsatisfiedException     // Catch:{ all -> 0x00a9 }
            int r0 = r7.get()     // Catch:{ all -> 0x00a9 }
            r15.<init>(r0)     // Catch:{ all -> 0x00a9 }
            throw r15     // Catch:{ all -> 0x00a9 }
        L_0x00ec:
            throw r15     // Catch:{ all -> 0x00a9 }
        L_0x00ed:
            w3.C2908y0.a.a(r1, r4, r5, r4)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((ConstraintTrackingWorker$runWorker$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
