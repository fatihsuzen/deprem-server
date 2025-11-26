package androidx.work.impl.utils;

import X2.C2250q;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.work.BackoffPolicy;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.t;

public final class EnqueueUtilsKt {
    public static final String ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME = "androidx.work.multiprocess.RemoteListenableDelegatingWorker.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME";
    public static final String ARGUMENT_SERVICE_CLASS_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_CLASS_NAME";
    public static final String ARGUMENT_SERVICE_PACKAGE_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME";
    public static final String REMOTE_DELEGATING_LISTENABLE_WORKER_CLASS_NAME = "androidx.work.multiprocess.RemoteListenableDelegatingWorker";

    public static final void checkContentUriTriggerWorkerLimits(WorkDatabase workDatabase, Configuration configuration, WorkContinuationImpl workContinuationImpl) {
        int i5;
        t.e(workDatabase, "workDatabase");
        t.e(configuration, "configuration");
        t.e(workContinuationImpl, "continuation");
        if (Build.VERSION.SDK_INT >= 24) {
            List l5 = C2250q.l(workContinuationImpl);
            int i6 = 0;
            while (!l5.isEmpty()) {
                WorkContinuationImpl workContinuationImpl2 = (WorkContinuationImpl) C2250q.z(l5);
                List<? extends WorkRequest> work = workContinuationImpl2.getWork();
                t.d(work, "getWork(...)");
                Iterable<WorkRequest> iterable = work;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    i5 = 0;
                    for (WorkRequest workSpec : iterable) {
                        if (workSpec.getWorkSpec().constraints.hasContentUriTriggers() && (i5 = i5 + 1) < 0) {
                            C2250q.n();
                        }
                    }
                } else {
                    i5 = 0;
                }
                i6 += i5;
                List<WorkContinuationImpl> parents = workContinuationImpl2.getParents();
                if (parents != null) {
                    l5.addAll(parents);
                }
            }
            if (i6 != 0) {
                int countNonFinishedContentUriTriggerWorkers = workDatabase.workSpecDao().countNonFinishedContentUriTriggerWorkers();
                int contentUriTriggerWorkersLimit = configuration.getContentUriTriggerWorkersLimit();
                if (countNonFinishedContentUriTriggerWorkers + i6 > contentUriTriggerWorkersLimit) {
                    throw new IllegalArgumentException("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: " + contentUriTriggerWorkersLimit + ";\nalready enqueued count: " + countNonFinishedContentUriTriggerWorkers + ";\ncurrent enqueue operation count: " + i6 + ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.");
                }
            }
        }
    }

    public static final WorkSpec tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        WorkSpec workSpec2 = workSpec;
        t.e(workSpec2, "workSpec");
        Constraints constraints = workSpec2.constraints;
        String str = workSpec2.workerClassName;
        Class<ConstraintTrackingWorker> cls = ConstraintTrackingWorker.class;
        if (t.a(str, cls.getName()) || (!constraints.requiresBatteryNotLow() && !constraints.requiresStorageNotLow())) {
            return workSpec;
        }
        Data build = new Data.Builder().putAll(workSpec2.input).putString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME, str).build();
        String name = cls.getName();
        t.d(name, "getName(...)");
        return WorkSpec.copy$default(workSpec2, (String) null, (WorkInfo.State) null, name, (String) null, build, (Data) null, 0, 0, 0, (Constraints) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 0, 0, 0, (String) null, (Boolean) null, 33554411, (Object) null);
    }

    @VisibleForTesting
    public static final WorkSpec tryDelegateRemoteListenableWorker(WorkSpec workSpec) {
        WorkSpec workSpec2 = workSpec;
        t.e(workSpec2, "workSpec");
        Class<String> cls = String.class;
        boolean hasKeyWithValueOfType = workSpec2.input.hasKeyWithValueOfType(ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, cls);
        boolean hasKeyWithValueOfType2 = workSpec2.input.hasKeyWithValueOfType(ARGUMENT_SERVICE_PACKAGE_NAME, cls);
        boolean hasKeyWithValueOfType3 = workSpec2.input.hasKeyWithValueOfType(ARGUMENT_SERVICE_CLASS_NAME, cls);
        if (hasKeyWithValueOfType || !hasKeyWithValueOfType2 || !hasKeyWithValueOfType3) {
            return workSpec;
        }
        return WorkSpec.copy$default(workSpec2, (String) null, (WorkInfo.State) null, REMOTE_DELEGATING_LISTENABLE_WORKER_CLASS_NAME, (String) null, new Data.Builder().putAll(workSpec2.input).putString(ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, workSpec2.workerClassName).build(), (Data) null, 0, 0, 0, (Constraints) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 0, 0, 0, (String) null, (Boolean) null, 33554411, (Object) null);
    }

    public static final WorkSpec wrapWorkSpecIfNeeded(List<? extends Scheduler> list, WorkSpec workSpec) {
        t.e(list, "schedulers");
        t.e(workSpec, "workSpec");
        WorkSpec tryDelegateRemoteListenableWorker = tryDelegateRemoteListenableWorker(workSpec);
        if (Build.VERSION.SDK_INT <= 25) {
            return tryDelegateConstrainedWorkSpec(tryDelegateRemoteListenableWorker);
        }
        return tryDelegateRemoteListenableWorker;
    }
}
