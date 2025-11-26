package androidx.work.impl;

import W2.J;
import X2.C2250q;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.ListenableFutureKt;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import b3.C2308e;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2907y;
import w3.C2908y0;
import w3.O;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class WorkerWrapper {
    /* access modifiers changed from: private */
    public final Context appContext;
    private final ListenableWorker builderWorker;
    private final Clock clock;
    private final Configuration configuration;
    private final DependencyDao dependencyDao;
    private final ForegroundProcessor foregroundProcessor;
    private final WorkerParameters.RuntimeExtras runtimeExtras;
    private final List<String> tags;
    /* access modifiers changed from: private */
    public final WorkDatabase workDatabase;
    private final String workDescription;
    private final WorkSpec workSpec;
    private final WorkSpecDao workSpecDao;
    private final String workSpecId;
    /* access modifiers changed from: private */
    public final TaskExecutor workTaskExecutor;
    /* access modifiers changed from: private */
    public final C2907y workerJob = C0.b((C2908y0) null, 1, (Object) null);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Builder {
        private final Context appContext;
        private final Configuration configuration;
        private final ForegroundProcessor foregroundProcessor;
        private WorkerParameters.RuntimeExtras runtimeExtras = new WorkerParameters.RuntimeExtras();
        private final List<String> tags;
        private final WorkDatabase workDatabase;
        private final WorkSpec workSpec;
        private final TaskExecutor workTaskExecutor;
        private ListenableWorker worker;

        @SuppressLint({"LambdaLast"})
        public Builder(Context context, Configuration configuration2, TaskExecutor taskExecutor, ForegroundProcessor foregroundProcessor2, WorkDatabase workDatabase2, WorkSpec workSpec2, List<String> list) {
            t.e(context, "context");
            t.e(configuration2, "configuration");
            t.e(taskExecutor, "workTaskExecutor");
            t.e(foregroundProcessor2, "foregroundProcessor");
            t.e(workDatabase2, "workDatabase");
            t.e(workSpec2, "workSpec");
            t.e(list, "tags");
            this.configuration = configuration2;
            this.workTaskExecutor = taskExecutor;
            this.foregroundProcessor = foregroundProcessor2;
            this.workDatabase = workDatabase2;
            this.workSpec = workSpec2;
            this.tags = list;
            Context applicationContext = context.getApplicationContext();
            t.d(applicationContext, "getApplicationContext(...)");
            this.appContext = applicationContext;
        }

        public final WorkerWrapper build() {
            return new WorkerWrapper(this);
        }

        public final Context getAppContext() {
            return this.appContext;
        }

        public final Configuration getConfiguration() {
            return this.configuration;
        }

        public final ForegroundProcessor getForegroundProcessor() {
            return this.foregroundProcessor;
        }

        public final WorkerParameters.RuntimeExtras getRuntimeExtras() {
            return this.runtimeExtras;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public final WorkDatabase getWorkDatabase() {
            return this.workDatabase;
        }

        public final WorkSpec getWorkSpec() {
            return this.workSpec;
        }

        public final TaskExecutor getWorkTaskExecutor() {
            return this.workTaskExecutor;
        }

        public final ListenableWorker getWorker() {
            return this.worker;
        }

        public final void setRuntimeExtras(WorkerParameters.RuntimeExtras runtimeExtras2) {
            t.e(runtimeExtras2, "<set-?>");
            this.runtimeExtras = runtimeExtras2;
        }

        public final void setWorker(ListenableWorker listenableWorker) {
            this.worker = listenableWorker;
        }

        public final Builder withRuntimeExtras(WorkerParameters.RuntimeExtras runtimeExtras2) {
            if (runtimeExtras2 != null) {
                this.runtimeExtras = runtimeExtras2;
            }
            return this;
        }

        @VisibleForTesting
        public final Builder withWorker(ListenableWorker listenableWorker) {
            t.e(listenableWorker, "worker");
            this.worker = listenableWorker;
            return this;
        }
    }

    private static abstract class Resolution {

        public static final class Failed extends Resolution {
            private final ListenableWorker.Result result;

            public Failed() {
                this((ListenableWorker.Result) null, 1, (C2633k) null);
            }

            public final ListenableWorker.Result getResult() {
                return this.result;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failed(ListenableWorker.Result result2) {
                super((C2633k) null);
                t.e(result2, "result");
                this.result = result2;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Failed(ListenableWorker.Result result2, int i5, C2633k kVar) {
                this((i5 & 1) != 0 ? new ListenableWorker.Result.Failure() : result2);
            }
        }

        public static final class Finished extends Resolution {
            private final ListenableWorker.Result result;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Finished(ListenableWorker.Result result2) {
                super((C2633k) null);
                t.e(result2, "result");
                this.result = result2;
            }

            public final ListenableWorker.Result getResult() {
                return this.result;
            }
        }

        public static final class ResetWorkerStatus extends Resolution {
            private final int reason;

            public ResetWorkerStatus() {
                this(0, 1, (C2633k) null);
            }

            public final int getReason() {
                return this.reason;
            }

            public ResetWorkerStatus(int i5) {
                super((C2633k) null);
                this.reason = i5;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ResetWorkerStatus(int i5, int i6, C2633k kVar) {
                this((i6 & 1) != 0 ? -256 : i5);
            }
        }

        public /* synthetic */ Resolution(C2633k kVar) {
            this();
        }

        private Resolution() {
        }
    }

    public WorkerWrapper(Builder builder) {
        t.e(builder, "builder");
        WorkSpec workSpec2 = builder.getWorkSpec();
        this.workSpec = workSpec2;
        this.appContext = builder.getAppContext();
        this.workSpecId = workSpec2.id;
        this.runtimeExtras = builder.getRuntimeExtras();
        this.builderWorker = builder.getWorker();
        this.workTaskExecutor = builder.getWorkTaskExecutor();
        Configuration configuration2 = builder.getConfiguration();
        this.configuration = configuration2;
        this.clock = configuration2.getClock();
        this.foregroundProcessor = builder.getForegroundProcessor();
        WorkDatabase workDatabase2 = builder.getWorkDatabase();
        this.workDatabase = workDatabase2;
        this.workSpecDao = workDatabase2.workSpecDao();
        this.dependencyDao = workDatabase2.dependencyDao();
        List<String> tags2 = builder.getTags();
        this.tags = tags2;
        this.workDescription = createWorkDescription(tags2);
    }

    private final String createWorkDescription(List<String> list) {
        return "Work [ id=" + this.workSpecId + ", tags={ " + C2250q.V(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null) + " } ]";
    }

    private final boolean handleResult(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            String access$getTAG$p = WorkerWrapperKt.TAG;
            Logger logger = Logger.get();
            logger.info(access$getTAG$p, "Worker result SUCCESS for " + this.workDescription);
            if (this.workSpec.isPeriodic()) {
                return resetPeriodic();
            }
            return setSucceeded(result);
        } else if (result instanceof ListenableWorker.Result.Retry) {
            String access$getTAG$p2 = WorkerWrapperKt.TAG;
            Logger logger2 = Logger.get();
            logger2.info(access$getTAG$p2, "Worker result RETRY for " + this.workDescription);
            return reschedule(-256);
        } else {
            String access$getTAG$p3 = WorkerWrapperKt.TAG;
            Logger logger3 = Logger.get();
            logger3.info(access$getTAG$p3, "Worker result FAILURE for " + this.workDescription);
            if (this.workSpec.isPeriodic()) {
                return resetPeriodic();
            }
            if (result == null) {
                result = new ListenableWorker.Result.Failure();
            }
            return setFailed(result);
        }
    }

    private final void iterativelyFailWorkAndDependents(String str) {
        List l5 = C2250q.l(str);
        while (!l5.isEmpty()) {
            String str2 = (String) C2250q.z(l5);
            if (this.workSpecDao.getState(str2) != WorkInfo.State.CANCELLED) {
                this.workSpecDao.setState(WorkInfo.State.FAILED, str2);
            }
            l5.addAll(this.dependencyDao.getDependentWorkIds(str2));
        }
    }

    /* access modifiers changed from: private */
    public final boolean onWorkFinished(ListenableWorker.Result result) {
        WorkInfo.State state = this.workSpecDao.getState(this.workSpecId);
        this.workDatabase.workProgressDao().delete(this.workSpecId);
        if (state == null) {
            return false;
        }
        if (state == WorkInfo.State.RUNNING) {
            return handleResult(result);
        }
        if (!state.isFinished()) {
            return reschedule(WorkInfo.STOP_REASON_UNKNOWN);
        }
        return false;
    }

    private final boolean reschedule(int i5) {
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.setLastEnqueueTime(this.workSpecId, this.clock.currentTimeMillis());
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1);
        this.workSpecDao.setStopReason(this.workSpecId, i5);
        return true;
    }

    private final boolean resetPeriodic() {
        this.workSpecDao.setLastEnqueueTime(this.workSpecId, this.clock.currentTimeMillis());
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.resetWorkSpecRunAttemptCount(this.workSpecId);
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.incrementPeriodCount(this.workSpecId);
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1);
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean resetWorkerStatus(int i5) {
        if (t.a(this.workSpec.getBackOffOnSystemInterruptions(), Boolean.TRUE)) {
            String access$getTAG$p = WorkerWrapperKt.TAG;
            Logger logger = Logger.get();
            logger.debug(access$getTAG$p, "Worker " + this.workSpec.workerClassName + " was interrupted. Backing off.");
            reschedule(i5);
            return true;
        }
        WorkInfo.State state = this.workSpecDao.getState(this.workSpecId);
        if (state == null || state.isFinished()) {
            String access$getTAG$p2 = WorkerWrapperKt.TAG;
            Logger logger2 = Logger.get();
            logger2.debug(access$getTAG$p2, "Status for " + this.workSpecId + " is " + state + " ; not doing any work");
            return false;
        }
        String access$getTAG$p3 = WorkerWrapperKt.TAG;
        Logger logger3 = Logger.get();
        logger3.debug(access$getTAG$p3, "Status for " + this.workSpecId + " is " + state + "; not doing any work and rescheduling for later execution");
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.setStopReason(this.workSpecId, i5);
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1);
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01ee, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01ef, code lost:
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x022e, code lost:
        r2 = androidx.work.impl.WorkerWrapperKt.access$getTAG$p();
        r3 = androidx.work.Logger.get();
        r3.info(r2, r1.workDescription + " was cancelled", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x024c, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:10:0x002e, B:52:0x01d0] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036 A[ExcHandler: CancellationException (r0v23 'e' java.util.concurrent.CancellationException A[CUSTOM_DECLARE]), Splitter:B:10:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runWorker(b3.C2308e r23) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            boolean r2 = r0 instanceof androidx.work.impl.WorkerWrapper$runWorker$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            androidx.work.impl.WorkerWrapper$runWorker$1 r2 = (androidx.work.impl.WorkerWrapper$runWorker$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            androidx.work.impl.WorkerWrapper$runWorker$1 r2 = new androidx.work.impl.WorkerWrapper$runWorker$1
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = c3.C2316b.f()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0041
            if (r4 != r5) goto L_0x0039
            java.lang.Object r2 = r2.L$0
            androidx.work.WorkerParameters r2 = (androidx.work.WorkerParameters) r2
            W2.u.b(r0)     // Catch:{ CancellationException -> 0x0036, all -> 0x0033 }
            goto L_0x01e3
        L_0x0033:
            r0 = move-exception
            goto L_0x01f0
        L_0x0036:
            r0 = move-exception
            goto L_0x022e
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0041:
            W2.u.b(r0)
            androidx.work.Configuration r0 = r1.configuration
            androidx.work.Tracer r0 = r0.getTracer()
            boolean r0 = r0.isEnabled()
            androidx.work.impl.model.WorkSpec r4 = r1.workSpec
            java.lang.String r4 = r4.getTraceTag()
            if (r0 == 0) goto L_0x0067
            if (r4 == 0) goto L_0x0067
            androidx.work.Configuration r7 = r1.configuration
            androidx.work.Tracer r7 = r7.getTracer()
            androidx.work.impl.model.WorkSpec r8 = r1.workSpec
            int r8 = r8.hashCode()
            r7.beginAsyncSection(r4, r8)
        L_0x0067:
            androidx.work.impl.WorkDatabase r7 = r1.workDatabase
            androidx.work.impl.B r8 = new androidx.work.impl.B
            r8.<init>(r1)
            java.lang.Object r7 = r7.runInTransaction(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r8 = 0
            if (r7 == 0) goto L_0x0081
            androidx.work.impl.WorkerWrapper$Resolution$ResetWorkerStatus r0 = new androidx.work.impl.WorkerWrapper$Resolution$ResetWorkerStatus
            r0.<init>(r8, r5, r6)
            return r0
        L_0x0081:
            androidx.work.impl.model.WorkSpec r7 = r1.workSpec
            boolean r7 = r7.isPeriodic()
            if (r7 == 0) goto L_0x008f
            androidx.work.impl.model.WorkSpec r7 = r1.workSpec
            androidx.work.Data r7 = r7.input
        L_0x008d:
            r11 = r7
            goto L_0x00e2
        L_0x008f:
            androidx.work.Configuration r7 = r1.configuration
            androidx.work.InputMergerFactory r7 = r7.getInputMergerFactory()
            androidx.work.impl.model.WorkSpec r9 = r1.workSpec
            java.lang.String r9 = r9.inputMergerClassName
            androidx.work.InputMerger r7 = r7.createInputMergerWithDefaultFallback(r9)
            if (r7 != 0) goto L_0x00c5
            java.lang.String r0 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.Logger r2 = androidx.work.Logger.get()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Could not create Input Merger "
            r3.append(r4)
            androidx.work.impl.model.WorkSpec r4 = r1.workSpec
            java.lang.String r4 = r4.inputMergerClassName
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.error(r0, r3)
            androidx.work.impl.WorkerWrapper$Resolution$Failed r0 = new androidx.work.impl.WorkerWrapper$Resolution$Failed
            r0.<init>(r6, r5, r6)
            return r0
        L_0x00c5:
            androidx.work.impl.model.WorkSpec r9 = r1.workSpec
            androidx.work.Data r9 = r9.input
            java.util.List r9 = X2.C2250q.d(r9)
            java.util.Collection r9 = (java.util.Collection) r9
            androidx.work.impl.model.WorkSpecDao r10 = r1.workSpecDao
            java.lang.String r11 = r1.workSpecId
            java.util.List r10 = r10.getInputsFromPrerequisites(r11)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.List r9 = X2.C2250q.b0(r9, r10)
            androidx.work.Data r7 = r7.merge(r9)
            goto L_0x008d
        L_0x00e2:
            androidx.work.WorkerParameters r9 = new androidx.work.WorkerParameters
            java.lang.String r7 = r1.workSpecId
            java.util.UUID r10 = java.util.UUID.fromString(r7)
            java.util.List<java.lang.String> r7 = r1.tags
            r12 = r7
            java.util.Collection r12 = (java.util.Collection) r12
            androidx.work.WorkerParameters$RuntimeExtras r13 = r1.runtimeExtras
            androidx.work.impl.model.WorkSpec r7 = r1.workSpec
            int r14 = r7.runAttemptCount
            int r15 = r7.getGeneration()
            androidx.work.Configuration r7 = r1.configuration
            java.util.concurrent.Executor r16 = r7.getExecutor()
            androidx.work.Configuration r7 = r1.configuration
            b3.i r17 = r7.getWorkerCoroutineContext()
            androidx.work.impl.utils.taskexecutor.TaskExecutor r7 = r1.workTaskExecutor
            androidx.work.Configuration r8 = r1.configuration
            androidx.work.WorkerFactory r19 = r8.getWorkerFactory()
            androidx.work.impl.utils.WorkProgressUpdater r8 = new androidx.work.impl.utils.WorkProgressUpdater
            androidx.work.impl.WorkDatabase r5 = r1.workDatabase
            androidx.work.impl.utils.taskexecutor.TaskExecutor r6 = r1.workTaskExecutor
            r8.<init>(r5, r6)
            androidx.work.impl.utils.WorkForegroundUpdater r5 = new androidx.work.impl.utils.WorkForegroundUpdater
            androidx.work.impl.WorkDatabase r6 = r1.workDatabase
            r18 = r7
            androidx.work.impl.foreground.ForegroundProcessor r7 = r1.foregroundProcessor
            r20 = r8
            androidx.work.impl.utils.taskexecutor.TaskExecutor r8 = r1.workTaskExecutor
            r5.<init>(r6, r7, r8)
            r21 = r5
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            androidx.work.ListenableWorker r5 = r1.builderWorker
            if (r5 != 0) goto L_0x0180
            androidx.work.Configuration r5 = r1.configuration     // Catch:{ all -> 0x013f }
            androidx.work.WorkerFactory r5 = r5.getWorkerFactory()     // Catch:{ all -> 0x013f }
            android.content.Context r6 = r1.appContext     // Catch:{ all -> 0x013f }
            androidx.work.impl.model.WorkSpec r7 = r1.workSpec     // Catch:{ all -> 0x013f }
            java.lang.String r7 = r7.workerClassName     // Catch:{ all -> 0x013f }
            androidx.work.ListenableWorker r5 = r5.createWorkerWithDefaultFallback(r6, r7, r9)     // Catch:{ all -> 0x013f }
            goto L_0x0180
        L_0x013f:
            r0 = move-exception
            java.lang.String r2 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.Logger r3 = androidx.work.Logger.get()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Could not create Worker "
            r4.append(r5)
            androidx.work.impl.model.WorkSpec r5 = r1.workSpec
            java.lang.String r5 = r5.workerClassName
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.error(r2, r4)
            androidx.work.Configuration r2 = r1.configuration
            androidx.core.util.Consumer r2 = r2.getWorkerInitializationExceptionHandler()
            if (r2 == 0) goto L_0x0178
            androidx.work.WorkerExceptionInfo r3 = new androidx.work.WorkerExceptionInfo
            androidx.work.impl.model.WorkSpec r4 = r1.workSpec
            java.lang.String r4 = r4.workerClassName
            r3.<init>(r4, r9, r0)
            java.lang.String r0 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.impl.utils.WorkerExceptionUtilsKt.safeAccept(r2, r3, r0)
        L_0x0178:
            androidx.work.impl.WorkerWrapper$Resolution$Failed r0 = new androidx.work.impl.WorkerWrapper$Resolution$Failed
            r2 = 1
            r3 = 0
            r0.<init>(r3, r2, r3)
            return r0
        L_0x0180:
            r5.setUsed()
            b3.i r6 = r2.getContext()
            w3.y0$b r7 = w3.C2908y0.f26320k0
            b3.i$b r6 = r6.get(r7)
            kotlin.jvm.internal.t.b(r6)
            w3.y0 r6 = (w3.C2908y0) r6
            androidx.work.impl.C r7 = new androidx.work.impl.C
            r7.<init>(r5, r0, r4, r1)
            r6.s(r7)
            boolean r0 = r1.trySetRunning()
            if (r0 != 0) goto L_0x01a9
            androidx.work.impl.WorkerWrapper$Resolution$ResetWorkerStatus r0 = new androidx.work.impl.WorkerWrapper$Resolution$ResetWorkerStatus
            r4 = 0
            r7 = 1
            r8 = 0
            r0.<init>(r4, r7, r8)
            return r0
        L_0x01a9:
            r4 = 0
            r7 = 1
            r8 = 0
            boolean r0 = r6.isCancelled()
            if (r0 == 0) goto L_0x01b8
            androidx.work.impl.WorkerWrapper$Resolution$ResetWorkerStatus r0 = new androidx.work.impl.WorkerWrapper$Resolution$ResetWorkerStatus
            r0.<init>(r4, r7, r8)
            return r0
        L_0x01b8:
            androidx.work.ForegroundUpdater r0 = r9.getForegroundUpdater()
            java.lang.String r4 = "getForegroundUpdater(...)"
            kotlin.jvm.internal.t.d(r0, r4)
            androidx.work.impl.utils.taskexecutor.TaskExecutor r4 = r1.workTaskExecutor
            java.util.concurrent.Executor r4 = r4.getMainThreadExecutor()
            java.lang.String r6 = "getMainThreadExecutor(...)"
            kotlin.jvm.internal.t.d(r4, r6)
            w3.I r4 = w3.C2894r0.b(r4)
            androidx.work.impl.WorkerWrapper$runWorker$result$1 r6 = new androidx.work.impl.WorkerWrapper$runWorker$result$1     // Catch:{ CancellationException -> 0x0036, all -> 0x01ee }
            r8 = 0
            r6.<init>(r1, r5, r0, r8)     // Catch:{ CancellationException -> 0x0036, all -> 0x01ee }
            r2.L$0 = r9     // Catch:{ CancellationException -> 0x0036, all -> 0x01ee }
            r7 = 1
            r2.label = r7     // Catch:{ CancellationException -> 0x0036, all -> 0x01ee }
            java.lang.Object r0 = w3.C2872g.g(r4, r6, r2)     // Catch:{ CancellationException -> 0x0036, all -> 0x01ee }
            if (r0 != r3) goto L_0x01e2
            return r3
        L_0x01e2:
            r2 = r9
        L_0x01e3:
            androidx.work.ListenableWorker$Result r0 = (androidx.work.ListenableWorker.Result) r0     // Catch:{ CancellationException -> 0x0036, all -> 0x0033 }
            androidx.work.impl.WorkerWrapper$Resolution$Finished r3 = new androidx.work.impl.WorkerWrapper$Resolution$Finished     // Catch:{ CancellationException -> 0x0036, all -> 0x0033 }
            kotlin.jvm.internal.t.b(r0)     // Catch:{ CancellationException -> 0x0036, all -> 0x0033 }
            r3.<init>(r0)     // Catch:{ CancellationException -> 0x0036, all -> 0x0033 }
            return r3
        L_0x01ee:
            r0 = move-exception
            r2 = r9
        L_0x01f0:
            java.lang.String r3 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.Logger r4 = androidx.work.Logger.get()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r1.workDescription
            r5.append(r6)
            java.lang.String r6 = " failed because it threw an exception/error"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.error(r3, r5, r0)
            androidx.work.Configuration r3 = r1.configuration
            androidx.core.util.Consumer r3 = r3.getWorkerExecutionExceptionHandler()
            if (r3 == 0) goto L_0x0226
            androidx.work.WorkerExceptionInfo r4 = new androidx.work.WorkerExceptionInfo
            androidx.work.impl.model.WorkSpec r5 = r1.workSpec
            java.lang.String r5 = r5.workerClassName
            r4.<init>(r5, r2, r0)
            java.lang.String r0 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.impl.utils.WorkerExceptionUtilsKt.safeAccept(r3, r4, r0)
        L_0x0226:
            androidx.work.impl.WorkerWrapper$Resolution$Failed r0 = new androidx.work.impl.WorkerWrapper$Resolution$Failed
            r7 = 1
            r8 = 0
            r0.<init>(r8, r7, r8)
            return r0
        L_0x022e:
            java.lang.String r2 = androidx.work.impl.WorkerWrapperKt.TAG
            androidx.work.Logger r3 = androidx.work.Logger.get()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r1.workDescription
            r4.append(r5)
            java.lang.String r5 = " was cancelled"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.info(r2, r4, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper.runWorker(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Boolean runWorker$lambda$1(WorkerWrapper workerWrapper) {
        WorkSpec workSpec2 = workerWrapper.workSpec;
        if (workSpec2.state != WorkInfo.State.ENQUEUED) {
            String access$getTAG$p = WorkerWrapperKt.TAG;
            Logger logger = Logger.get();
            logger.debug(access$getTAG$p, workerWrapper.workSpec.workerClassName + " is not in ENQUEUED state. Nothing more to do");
            return Boolean.TRUE;
        } else if ((!workSpec2.isPeriodic() && !workerWrapper.workSpec.isBackedOff()) || workerWrapper.clock.currentTimeMillis() >= workerWrapper.workSpec.calculateNextRunTime()) {
            return Boolean.FALSE;
        } else {
            Logger logger2 = Logger.get();
            String access$getTAG$p2 = WorkerWrapperKt.TAG;
            logger2.debug(access$getTAG$p2, "Delaying execution for " + workerWrapper.workSpec.workerClassName + " because it is being executed before schedule.");
            return Boolean.TRUE;
        }
    }

    /* access modifiers changed from: private */
    public static final J runWorker$lambda$4(ListenableWorker listenableWorker, boolean z4, String str, WorkerWrapper workerWrapper, Throwable th) {
        if (th instanceof WorkerStoppedException) {
            listenableWorker.stop(((WorkerStoppedException) th).getReason());
        }
        if (z4 && str != null) {
            workerWrapper.configuration.getTracer().endAsyncSection(str, workerWrapper.workSpec.hashCode());
        }
        return J.f19942a;
    }

    private final boolean setSucceeded(ListenableWorker.Result result) {
        this.workSpecDao.setState(WorkInfo.State.SUCCEEDED, this.workSpecId);
        t.c(result, "null cannot be cast to non-null type androidx.work.ListenableWorker.Result.Success");
        Data outputData = ((ListenableWorker.Result.Success) result).getOutputData();
        t.d(outputData, "getOutputData(...)");
        this.workSpecDao.setOutput(this.workSpecId, outputData);
        long currentTimeMillis = this.clock.currentTimeMillis();
        for (String next : this.dependencyDao.getDependentWorkIds(this.workSpecId)) {
            if (this.workSpecDao.getState(next) == WorkInfo.State.BLOCKED && this.dependencyDao.hasCompletedAllPrerequisites(next)) {
                String access$getTAG$p = WorkerWrapperKt.TAG;
                Logger logger = Logger.get();
                logger.info(access$getTAG$p, "Setting status to enqueued for " + next);
                this.workSpecDao.setState(WorkInfo.State.ENQUEUED, next);
                this.workSpecDao.setLastEnqueueTime(next, currentTimeMillis);
            }
        }
        return false;
    }

    private final boolean trySetRunning() {
        Object runInTransaction = this.workDatabase.runInTransaction(new D(this));
        t.d(runInTransaction, "runInTransaction(...)");
        return ((Boolean) runInTransaction).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final Boolean trySetRunning$lambda$13(WorkerWrapper workerWrapper) {
        boolean z4;
        if (workerWrapper.workSpecDao.getState(workerWrapper.workSpecId) == WorkInfo.State.ENQUEUED) {
            workerWrapper.workSpecDao.setState(WorkInfo.State.RUNNING, workerWrapper.workSpecId);
            workerWrapper.workSpecDao.incrementWorkSpecRunAttemptCount(workerWrapper.workSpecId);
            workerWrapper.workSpecDao.setStopReason(workerWrapper.workSpecId, -256);
            z4 = true;
        } else {
            z4 = false;
        }
        return Boolean.valueOf(z4);
    }

    public final WorkGenerationalId getWorkGenerationalId() {
        return WorkSpecKt.generationalId(this.workSpec);
    }

    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void interrupt(int i5) {
        this.workerJob.a(new WorkerStoppedException(i5));
    }

    public final C1722d launch() {
        return ListenableFutureKt.launchFuture$default(this.workTaskExecutor.getTaskCoroutineDispatcher().plus(C0.b((C2908y0) null, 1, (Object) null)), (O) null, new WorkerWrapper$launch$1(this, (C2308e) null), 2, (Object) null);
    }

    @VisibleForTesting
    public final boolean setFailed(ListenableWorker.Result result) {
        t.e(result, "result");
        iterativelyFailWorkAndDependents(this.workSpecId);
        Data outputData = ((ListenableWorker.Result.Failure) result).getOutputData();
        t.d(outputData, "getOutputData(...)");
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.setOutput(this.workSpecId, outputData);
        return false;
    }
}
