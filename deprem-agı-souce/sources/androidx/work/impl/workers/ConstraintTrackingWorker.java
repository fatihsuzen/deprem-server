package androidx.work.impl.workers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import b3.C2308e;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import w3.C2872g;
import w3.C2894r0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ConstraintTrackingWorker extends CoroutineWorker {
    private final WorkerParameters workerParameters;

    private static final class ConstraintUnsatisfiedException extends CancellationException {
        private final int stopReason;

        public ConstraintUnsatisfiedException(int i5) {
            this.stopReason = i5;
        }

        public final int getStopReason() {
            return this.stopReason;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters2) {
        super(context, workerParameters2);
        t.e(context, "appContext");
        t.e(workerParameters2, "workerParameters");
        this.workerParameters = workerParameters2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runWorker(androidx.work.ListenableWorker r5, androidx.work.impl.constraints.WorkConstraintsTracker r6, androidx.work.impl.model.WorkSpec r7, b3.C2308e r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$1 r0 = (androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$1 r0 = new androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            W2.u.b(r8)
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            W2.u.b(r8)
            androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2 r8 = new androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2
            r2 = 0
            r8.<init>(r5, r6, r7, r2)
            r0.label = r3
            java.lang.Object r8 = w3.N.d(r8, r0)
            if (r8 != r1) goto L_0x0043
            return r1
        L_0x0043:
            java.lang.String r5 = "coroutineScope(...)"
            kotlin.jvm.internal.t.d(r8, r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.workers.ConstraintTrackingWorker.runWorker(androidx.work.ListenableWorker, androidx.work.impl.constraints.WorkConstraintsTracker, androidx.work.impl.model.WorkSpec, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setupAndRunConstraintTrackingWork(b3.C2308e r15) {
        /*
            r14 = this;
            boolean r2 = r15 instanceof androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$1
            if (r2 == 0) goto L_0x0014
            r2 = r15
            androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$1 r2 = (androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0014
            int r3 = r3 - r4
            r2.label = r3
        L_0x0012:
            r6 = r2
            goto L_0x001a
        L_0x0014:
            androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$1 r2 = new androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$1
            r2.<init>(r14, r15)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r0 = r6.result
            java.lang.Object r7 = c3.C2316b.f()
            int r2 = r6.label
            r8 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r8) goto L_0x0033
            java.lang.Object r2 = r6.L$0
            androidx.work.ListenableWorker r2 = (androidx.work.ListenableWorker) r2
            W2.u.b(r0)     // Catch:{ CancellationException -> 0x0030 }
            goto L_0x011c
        L_0x0030:
            r0 = move-exception
            goto L_0x011f
        L_0x0033:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003b:
            W2.u.b(r0)
            androidx.work.Data r0 = r14.getInputData()
            java.lang.String r2 = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME"
            java.lang.String r2 = r0.getString(r2)
            java.lang.String r3 = "No worker to delegate to."
            java.lang.String r4 = "failure(...)"
            if (r2 == 0) goto L_0x0054
            int r0 = r2.length()
            if (r0 != 0) goto L_0x0057
        L_0x0054:
            r9 = r3
            goto L_0x018c
        L_0x0057:
            android.content.Context r0 = r14.getApplicationContext()
            androidx.work.impl.WorkManagerImpl r5 = androidx.work.impl.WorkManagerImpl.getInstance(r0)
            java.lang.String r0 = "getInstance(...)"
            kotlin.jvm.internal.t.d(r5, r0)
            androidx.work.impl.WorkDatabase r0 = r5.getWorkDatabase()
            androidx.work.impl.model.WorkSpecDao r0 = r0.workSpecDao()
            java.util.UUID r9 = r14.getId()
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "toString(...)"
            kotlin.jvm.internal.t.d(r9, r10)
            androidx.work.impl.model.WorkSpec r0 = r0.getWorkSpec(r9)
            if (r0 != 0) goto L_0x0087
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.failure()
            kotlin.jvm.internal.t.d(r0, r4)
            return r0
        L_0x0087:
            r9 = r3
            androidx.work.impl.constraints.WorkConstraintsTracker r3 = new androidx.work.impl.constraints.WorkConstraintsTracker
            androidx.work.impl.constraints.trackers.Trackers r10 = r5.getTrackers()
            java.lang.String r11 = "getTrackers(...)"
            kotlin.jvm.internal.t.d(r10, r11)
            r3.<init>((androidx.work.impl.constraints.trackers.Trackers) r10)
            boolean r10 = r3.areAllConstraintsMet(r0)
            if (r10 != 0) goto L_0x00c7
            java.lang.String r0 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG
            androidx.work.Logger r3 = androidx.work.Logger.get()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Constraints not met for delegate "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = ". Requesting retry."
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.debug(r0, r2)
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.retry()
            java.lang.String r2 = "retry(...)"
            kotlin.jvm.internal.t.d(r0, r2)
            return r0
        L_0x00c7:
            java.lang.String r10 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG
            androidx.work.Logger r11 = androidx.work.Logger.get()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Constraints met for delegate "
            r12.append(r13)
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            r11.debug(r10, r12)
            androidx.work.WorkerFactory r10 = r14.getWorkerFactory()     // Catch:{ all -> 0x0160 }
            android.content.Context r11 = r14.getApplicationContext()     // Catch:{ all -> 0x0160 }
            java.lang.String r12 = "getApplicationContext(...)"
            kotlin.jvm.internal.t.d(r11, r12)     // Catch:{ all -> 0x0160 }
            androidx.work.WorkerParameters r12 = r14.workerParameters     // Catch:{ all -> 0x0160 }
            androidx.work.ListenableWorker r2 = r10.createWorkerWithDefaultFallback(r11, r2, r12)     // Catch:{ all -> 0x0160 }
            androidx.work.WorkerParameters r4 = r14.workerParameters
            androidx.work.impl.utils.taskexecutor.TaskExecutor r4 = r4.getTaskExecutor()
            java.util.concurrent.Executor r4 = r4.getMainThreadExecutor()
            java.lang.String r5 = "getMainThreadExecutor(...)"
            kotlin.jvm.internal.t.d(r4, r5)
            w3.I r9 = w3.C2894r0.b(r4)     // Catch:{ CancellationException -> 0x0030 }
            r4 = r0
            androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5 r0 = new androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5     // Catch:{ CancellationException -> 0x0030 }
            r5 = 0
            r1 = r14
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ CancellationException -> 0x0030 }
            r6.L$0 = r2     // Catch:{ CancellationException -> 0x0030 }
            r6.label = r8     // Catch:{ CancellationException -> 0x0030 }
            java.lang.Object r0 = w3.C2872g.g(r9, r0, r6)     // Catch:{ CancellationException -> 0x0030 }
            if (r0 != r7) goto L_0x011c
            return r7
        L_0x011c:
            androidx.work.ListenableWorker$Result r0 = (androidx.work.ListenableWorker.Result) r0     // Catch:{ CancellationException -> 0x0030 }
            return r0
        L_0x011f:
            boolean r3 = r14.isStopped()
            if (r3 != 0) goto L_0x0129
            boolean r3 = r0 instanceof androidx.work.impl.workers.ConstraintTrackingWorker.ConstraintUnsatisfiedException
            if (r3 == 0) goto L_0x014b
        L_0x0129:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r3 >= r4) goto L_0x0132
            r3 = -512(0xfffffffffffffe00, float:NaN)
            goto L_0x0148
        L_0x0132:
            boolean r3 = r14.isStopped()
            if (r3 == 0) goto L_0x013d
            int r3 = r14.getStopReason()
            goto L_0x0148
        L_0x013d:
            boolean r3 = r0 instanceof androidx.work.impl.workers.ConstraintTrackingWorker.ConstraintUnsatisfiedException
            if (r3 == 0) goto L_0x0158
            r3 = r0
            androidx.work.impl.workers.ConstraintTrackingWorker$ConstraintUnsatisfiedException r3 = (androidx.work.impl.workers.ConstraintTrackingWorker.ConstraintUnsatisfiedException) r3
            int r3 = r3.getStopReason()
        L_0x0148:
            r2.stop(r3)
        L_0x014b:
            boolean r2 = r0 instanceof androidx.work.impl.workers.ConstraintTrackingWorker.ConstraintUnsatisfiedException
            if (r2 == 0) goto L_0x0157
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.retry()
            kotlin.jvm.internal.t.b(r0)
            return r0
        L_0x0157:
            throw r0
        L_0x0158:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "Unreachable"
            r0.<init>(r2)
            throw r0
        L_0x0160:
            r0 = move-exception
            java.lang.String r3 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG
            androidx.work.Logger r6 = androidx.work.Logger.get()
            r6.debug(r3, r9)
            androidx.work.Configuration r3 = r5.getConfiguration()
            androidx.core.util.Consumer r3 = r3.getWorkerInitializationExceptionHandler()
            if (r3 == 0) goto L_0x0184
            androidx.work.WorkerExceptionInfo r5 = new androidx.work.WorkerExceptionInfo
            androidx.work.WorkerParameters r6 = r14.workerParameters
            r5.<init>(r2, r6, r0)
            java.lang.String r0 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG
            androidx.work.impl.utils.WorkerExceptionUtilsKt.safeAccept(r3, r5, r0)
        L_0x0184:
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.failure()
            kotlin.jvm.internal.t.d(r0, r4)
            return r0
        L_0x018c:
            java.lang.String r0 = androidx.work.impl.workers.ConstraintTrackingWorkerKt.TAG
            androidx.work.Logger r2 = androidx.work.Logger.get()
            r2.error(r0, r9)
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.failure()
            kotlin.jvm.internal.t.d(r0, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.workers.ConstraintTrackingWorker.setupAndRunConstraintTrackingWork(b3.e):java.lang.Object");
    }

    public Object doWork(C2308e eVar) {
        Executor backgroundExecutor = getBackgroundExecutor();
        t.d(backgroundExecutor, "getBackgroundExecutor(...)");
        return C2872g.g(C2894r0.b(backgroundExecutor), new ConstraintTrackingWorker$doWork$2(this, (C2308e) null), eVar);
    }
}
