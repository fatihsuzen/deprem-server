package androidx.work.impl;

import W2.J;
import X2.C2250q;
import androidx.annotation.RestrictTo;
import androidx.work.BackoffPolicy;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableFutureKt;
import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.Tracer;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;
import n0.C1722d;

public final class WorkerUpdater {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Operation enqueueUniquelyNamedPeriodic(WorkManagerImpl workManagerImpl, String str, WorkRequest workRequest) {
        t.e(workManagerImpl, "<this>");
        t.e(str, RewardPlus.NAME);
        t.e(workRequest, "workRequest");
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        String str2 = "enqueueUniquePeriodic_" + str;
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        t.d(serialTaskExecutor, "getSerialTaskExecutor(...)");
        return OperationKt.launchOperation(tracer, str2, serialTaskExecutor, new A(workManagerImpl, str, workRequest));
    }

    /* access modifiers changed from: private */
    public static final J enqueueUniquelyNamedPeriodic$lambda$6(WorkManagerImpl workManagerImpl, String str, WorkRequest workRequest) {
        String str2 = str;
        WorkManagerImpl workManagerImpl2 = workManagerImpl;
        WorkRequest workRequest2 = workRequest;
        y yVar = new y(workRequest2, workManagerImpl2, str2);
        WorkSpecDao workSpecDao = workManagerImpl2.getWorkDatabase().workSpecDao();
        List<WorkSpec.IdAndState> workSpecIdAndStatesForName = workSpecDao.getWorkSpecIdAndStatesForName(str2);
        if (workSpecIdAndStatesForName.size() <= 1) {
            WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) C2250q.O(workSpecIdAndStatesForName);
            if (idAndState == null) {
                yVar.invoke();
                return J.f19942a;
            }
            WorkSpec workSpec = workSpecDao.getWorkSpec(idAndState.id);
            if (workSpec == null) {
                throw new IllegalStateException("WorkSpec with " + idAndState.id + ", that matches a name \"" + str2 + "\", wasn't found");
            } else if (!workSpec.isPeriodic()) {
                throw new UnsupportedOperationException("Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
            } else if (idAndState.state == WorkInfo.State.CANCELLED) {
                workSpecDao.delete(idAndState.id);
                yVar.invoke();
                return J.f19942a;
            } else {
                WorkSpec copy$default = WorkSpec.copy$default(workRequest2.getWorkSpec(), idAndState.id, (WorkInfo.State) null, (String) null, (String) null, (Data) null, (Data) null, 0, 0, 0, (Constraints) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 0, 0, 0, (String) null, (Boolean) null, 33554430, (Object) null);
                Processor processor = workManagerImpl2.getProcessor();
                t.d(processor, "getProcessor(...)");
                WorkDatabase workDatabase = workManagerImpl2.getWorkDatabase();
                t.d(workDatabase, "getWorkDatabase(...)");
                Configuration configuration = workManagerImpl2.getConfiguration();
                t.d(configuration, "<get-configuration>(...)");
                List<Scheduler> schedulers = workManagerImpl2.getSchedulers();
                t.d(schedulers, "getSchedulers(...)");
                Configuration configuration2 = configuration;
                updateWorkImpl(processor, workDatabase, configuration2, schedulers, copy$default, workRequest2.getTags());
                return J.f19942a;
            }
        } else {
            throw new UnsupportedOperationException("Can't apply UPDATE policy to the chains of work.");
        }
    }

    /* access modifiers changed from: private */
    public static final J enqueueUniquelyNamedPeriodic$lambda$6$lambda$5(WorkRequest workRequest, WorkManagerImpl workManagerImpl, String str) {
        EnqueueRunnable.enqueue(new WorkContinuationImpl(workManagerImpl, str, ExistingWorkPolicy.KEEP, C2250q.d(workRequest)));
        return J.f19942a;
    }

    private static final WorkManager.UpdateResult updateWorkImpl(Processor processor, WorkDatabase workDatabase, Configuration configuration, List<? extends Scheduler> list, WorkSpec workSpec, Set<String> set) {
        String str = workSpec.id;
        WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec2 == null) {
            throw new IllegalArgumentException("Worker with " + str + " doesn't exist");
        } else if (workSpec2.state.isFinished()) {
            return WorkManager.UpdateResult.NOT_APPLIED;
        } else {
            if (!(workSpec2.isPeriodic() ^ workSpec.isPeriodic())) {
                boolean isEnqueued = processor.isEnqueued(str);
                if (!isEnqueued) {
                    for (Scheduler cancel : list) {
                        cancel.cancel(str);
                    }
                }
                WorkDatabase workDatabase2 = workDatabase;
                List<? extends Scheduler> list2 = list;
                workDatabase2.runInTransaction((Runnable) new x(workDatabase2, workSpec2, workSpec, list2, str, set, isEnqueued));
                if (!isEnqueued) {
                    Schedulers.schedule(configuration, workDatabase2, list2);
                }
                return isEnqueued ? WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN : WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
            }
            w wVar = new w();
            throw new UnsupportedOperationException("Can't update " + ((String) wVar.invoke(workSpec2)) + " Worker to " + ((String) wVar.invoke(workSpec)) + " Worker. Update operation must preserve worker's type.");
        }
    }

    /* access modifiers changed from: private */
    public static final String updateWorkImpl$lambda$0(WorkSpec workSpec) {
        t.e(workSpec, "spec");
        if (workSpec.isPeriodic()) {
            return "Periodic";
        }
        return "OneTime";
    }

    /* access modifiers changed from: private */
    public static final void updateWorkImpl$lambda$3(WorkDatabase workDatabase, WorkSpec workSpec, WorkSpec workSpec2, List list, String str, Set set, boolean z4) {
        WorkSpec workSpec3 = workSpec;
        String str2 = str;
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        WorkInfo.State state = workSpec3.state;
        int i5 = workSpec3.runAttemptCount;
        long j5 = workSpec3.lastEnqueueTime;
        long j6 = j5;
        int i6 = i5;
        WorkSpec workSpec4 = workSpec2;
        WorkSpec copy$default = WorkSpec.copy$default(workSpec4, (String) null, state, (String) null, (String) null, (Data) null, (Data) null, 0, 0, 0, (Constraints) null, i6, (BackoffPolicy) null, 0, j6, 0, 0, false, (OutOfQuotaPolicy) null, workSpec3.getPeriodCount(), workSpec3.getGeneration() + 1, workSpec3.getNextScheduleTimeOverride(), workSpec3.getNextScheduleTimeOverrideGeneration(), 0, (String) null, (Boolean) null, 29613053, (Object) null);
        if (workSpec2.getNextScheduleTimeOverrideGeneration() == 1) {
            copy$default.setNextScheduleTimeOverride(workSpec2.getNextScheduleTimeOverride());
            copy$default.setNextScheduleTimeOverrideGeneration(copy$default.getNextScheduleTimeOverrideGeneration() + 1);
        }
        workSpecDao.updateWorkSpec(EnqueueUtilsKt.wrapWorkSpecIfNeeded(list, copy$default));
        workTagDao.deleteByWorkSpecId(str2);
        workTagDao.insertTags(str2, set);
        if (!z4) {
            workSpecDao.markWorkSpecScheduled(str2, -1);
            workDatabase.workProgressDao().delete(str2);
        }
    }

    /* access modifiers changed from: private */
    public static final WorkManager.UpdateResult updateWorkImpl$lambda$4(WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        Processor processor = workManagerImpl.getProcessor();
        t.d(processor, "getProcessor(...)");
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        t.d(workDatabase, "getWorkDatabase(...)");
        Configuration configuration = workManagerImpl.getConfiguration();
        t.d(configuration, "<get-configuration>(...)");
        List<Scheduler> schedulers = workManagerImpl.getSchedulers();
        t.d(schedulers, "getSchedulers(...)");
        return updateWorkImpl(processor, workDatabase, configuration, schedulers, workRequest.getWorkSpec(), workRequest.getTags());
    }

    public static final C1722d updateWorkImpl(WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        t.e(workManagerImpl, "<this>");
        t.e(workRequest, "workRequest");
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        t.d(serialTaskExecutor, "getSerialTaskExecutor(...)");
        return ListenableFutureKt.executeAsync(serialTaskExecutor, "updateWorkImpl", new z(workManagerImpl, workRequest));
    }
}
