package androidx.work.impl.utils;

import W2.J;
import X2.C2250q;
import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.Tracer;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.t;

public final class CancelWorkRunnable {
    private static final void cancel(WorkManagerImpl workManagerImpl, String str) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        t.d(workDatabase, "getWorkDatabase(...)");
        iterativelyCancelWorkAndDependents(workDatabase, str);
        Processor processor = workManagerImpl.getProcessor();
        t.d(processor, "getProcessor(...)");
        processor.stopAndCancelWork(str, 1);
        for (Scheduler cancel : workManagerImpl.getSchedulers()) {
            cancel.cancel(str);
        }
    }

    public static final Operation forAll(WorkManagerImpl workManagerImpl) {
        t.e(workManagerImpl, "workManagerImpl");
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        t.d(serialTaskExecutor, "getSerialTaskExecutor(...)");
        return OperationKt.launchOperation(tracer, "CancelAllWork", serialTaskExecutor, new f(workManagerImpl));
    }

    /* access modifiers changed from: private */
    public static final J forAll$lambda$7(WorkManagerImpl workManagerImpl) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        t.d(workDatabase, "getWorkDatabase(...)");
        workDatabase.runInTransaction((Runnable) new h(workDatabase, workManagerImpl));
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void forAll$lambda$7$lambda$6(WorkDatabase workDatabase, WorkManagerImpl workManagerImpl) {
        for (String cancel : workDatabase.workSpecDao().getAllUnfinishedWork()) {
            cancel(workManagerImpl, cancel);
        }
        new PreferenceUtils(workDatabase).setLastCancelAllTimeMillis(workManagerImpl.getConfiguration().getClock().currentTimeMillis());
    }

    public static final Operation forId(UUID uuid, WorkManagerImpl workManagerImpl) {
        t.e(uuid, "id");
        t.e(workManagerImpl, "workManagerImpl");
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        t.d(serialTaskExecutor, "getSerialTaskExecutor(...)");
        return OperationKt.launchOperation(tracer, "CancelWorkById", serialTaskExecutor, new g(workManagerImpl, uuid));
    }

    /* access modifiers changed from: private */
    public static final J forId$lambda$1(WorkManagerImpl workManagerImpl, UUID uuid) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        t.d(workDatabase, "getWorkDatabase(...)");
        workDatabase.runInTransaction((Runnable) new e(workManagerImpl, uuid));
        reschedulePendingWorkers(workManagerImpl);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void forId$lambda$1$lambda$0(WorkManagerImpl workManagerImpl, UUID uuid) {
        String uuid2 = uuid.toString();
        t.d(uuid2, "toString(...)");
        cancel(workManagerImpl, uuid2);
    }

    public static final Operation forName(String str, WorkManagerImpl workManagerImpl) {
        t.e(str, RewardPlus.NAME);
        t.e(workManagerImpl, "workManagerImpl");
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        String str2 = "CancelWorkByName_" + str;
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        t.d(serialTaskExecutor, "getSerialTaskExecutor(...)");
        return OperationKt.launchOperation(tracer, str2, serialTaskExecutor, new d(str, workManagerImpl));
    }

    /* access modifiers changed from: private */
    public static final J forName$lambda$4(String str, WorkManagerImpl workManagerImpl) {
        forNameInline(str, workManagerImpl);
        reschedulePendingWorkers(workManagerImpl);
        return J.f19942a;
    }

    public static final void forNameInline(String str, WorkManagerImpl workManagerImpl) {
        t.e(str, RewardPlus.NAME);
        t.e(workManagerImpl, "workManagerImpl");
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        t.d(workDatabase, "getWorkDatabase(...)");
        workDatabase.runInTransaction((Runnable) new C0452a(workDatabase, str, workManagerImpl));
    }

    /* access modifiers changed from: private */
    public static final void forNameInline$lambda$5(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        for (String cancel : workDatabase.workSpecDao().getUnfinishedWorkWithName(str)) {
            cancel(workManagerImpl, cancel);
        }
    }

    public static final Operation forTag(String str, WorkManagerImpl workManagerImpl) {
        t.e(str, "tag");
        t.e(workManagerImpl, "workManagerImpl");
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        String str2 = "CancelWorkByTag_" + str;
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        t.d(serialTaskExecutor, "getSerialTaskExecutor(...)");
        return OperationKt.launchOperation(tracer, str2, serialTaskExecutor, new C0454c(workManagerImpl, str));
    }

    /* access modifiers changed from: private */
    public static final J forTag$lambda$3(WorkManagerImpl workManagerImpl, String str) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        t.d(workDatabase, "getWorkDatabase(...)");
        workDatabase.runInTransaction((Runnable) new C0453b(workDatabase, str, workManagerImpl));
        reschedulePendingWorkers(workManagerImpl);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void forTag$lambda$3$lambda$2(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        for (String cancel : workDatabase.workSpecDao().getUnfinishedWorkWithTag(str)) {
            cancel(workManagerImpl, cancel);
        }
    }

    private static final void iterativelyCancelWorkAndDependents(WorkDatabase workDatabase, String str) {
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        DependencyDao dependencyDao = workDatabase.dependencyDao();
        List l5 = C2250q.l(str);
        while (!l5.isEmpty()) {
            String str2 = (String) C2250q.z(l5);
            WorkInfo.State state = workSpecDao.getState(str2);
            if (!(state == WorkInfo.State.SUCCEEDED || state == WorkInfo.State.FAILED)) {
                workSpecDao.setCancelledState(str2);
            }
            l5.addAll(dependencyDao.getDependentWorkIds(str2));
        }
    }

    private static final void reschedulePendingWorkers(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}
