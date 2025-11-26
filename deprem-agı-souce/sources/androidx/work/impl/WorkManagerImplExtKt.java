package androidx.work.impl;

import X2.C2242i;
import X2.C2250q;
import android.content.Context;
import androidx.appcompat.R;
import androidx.work.Configuration;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.constraints.trackers.BatteryNotLowTracker;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import b3.C2308e;
import b3.C2312i;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.I;
import w3.M;
import w3.N;

public final class WorkManagerImplExtKt {
    public static final void close(WorkManagerImpl workManagerImpl) {
        t.e(workManagerImpl, "<this>");
        Object unused = C2874h.b((C2312i) null, new WorkManagerImplExtKt$close$1(workManagerImpl, (C2308e) null), 1, (Object) null);
        workManagerImpl.getWorkDatabase().close();
    }

    /* access modifiers changed from: private */
    public static final List<Scheduler> createSchedulers(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        Scheduler createBestAvailableBackgroundScheduler = Schedulers.createBestAvailableBackgroundScheduler(context, workDatabase, configuration);
        t.d(createBestAvailableBackgroundScheduler, "createBestAvailableBackgroundScheduler(...)");
        return C2250q.j(createBestAvailableBackgroundScheduler, new GreedyScheduler(context, configuration, trackers, processor, new WorkLauncherImpl(processor, taskExecutor), taskExecutor));
    }

    public static final WorkManagerImpl createTestWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        t.e(context, "context");
        t.e(configuration, "configuration");
        t.e(taskExecutor, "workTaskExecutor");
        WorkDatabase.Companion companion = WorkDatabase.Companion;
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        t.d(serialTaskExecutor, "getSerialTaskExecutor(...)");
        return createWorkManager$default(context, configuration, taskExecutor, companion.create(context, serialTaskExecutor, configuration.getClock(), true), (Trackers) null, (Processor) null, (k3.t) null, 112, (Object) null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration) {
        t.e(context, "context");
        t.e(configuration, "configuration");
        return createWorkManager$default(context, configuration, (TaskExecutor) null, (WorkDatabase) null, (Trackers) null, (Processor) null, (k3.t) null, R.styleable.AppCompatTheme_windowMinWidthMajor, (Object) null);
    }

    public static /* synthetic */ WorkManagerImpl createWorkManager$default(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, k3.t tVar, int i5, Object obj) {
        Trackers trackers2;
        Processor processor2;
        WorkManagerImplExtKt$WorkManagerImpl$1 workManagerImplExtKt$WorkManagerImpl$1;
        if ((i5 & 4) != 0) {
            taskExecutor = new WorkManagerTaskExecutor(configuration.getTaskExecutor());
        }
        TaskExecutor taskExecutor2 = taskExecutor;
        if ((i5 & 8) != 0) {
            WorkDatabase.Companion companion = WorkDatabase.Companion;
            Context applicationContext = context.getApplicationContext();
            t.d(applicationContext, "getApplicationContext(...)");
            SerialExecutor serialTaskExecutor = taskExecutor2.getSerialTaskExecutor();
            t.d(serialTaskExecutor, "getSerialTaskExecutor(...)");
            workDatabase = companion.create(applicationContext, serialTaskExecutor, configuration.getClock(), context.getResources().getBoolean(androidx.work.R.bool.workmanager_test_configuration));
        }
        if ((i5 & 16) != 0) {
            Context applicationContext2 = context.getApplicationContext();
            t.d(applicationContext2, "getApplicationContext(...)");
            trackers2 = new Trackers(applicationContext2, taskExecutor2, (ConstraintTracker) null, (BatteryNotLowTracker) null, (ConstraintTracker) null, (ConstraintTracker) null, 60, (C2633k) null);
        } else {
            trackers2 = trackers;
        }
        if ((i5 & 32) != 0) {
            processor2 = new Processor(context.getApplicationContext(), configuration, taskExecutor2, workDatabase);
        } else {
            processor2 = processor;
        }
        if ((i5 & 64) != 0) {
            workManagerImplExtKt$WorkManagerImpl$1 = WorkManagerImplExtKt$WorkManagerImpl$1.INSTANCE;
        } else {
            workManagerImplExtKt$WorkManagerImpl$1 = tVar;
        }
        return createWorkManager(context, configuration, taskExecutor2, workDatabase, trackers2, processor2, workManagerImplExtKt$WorkManagerImpl$1);
    }

    public static final M createWorkManagerScope(TaskExecutor taskExecutor) {
        t.e(taskExecutor, "taskExecutor");
        I taskCoroutineDispatcher = taskExecutor.getTaskCoroutineDispatcher();
        t.d(taskCoroutineDispatcher, "getTaskCoroutineDispatcher(...)");
        return N.a(taskCoroutineDispatcher);
    }

    public static final k3.t schedulers(Scheduler... schedulerArr) {
        t.e(schedulerArr, "schedulers");
        return new v(schedulerArr);
    }

    /* access modifiers changed from: private */
    public static final List schedulers$lambda$0(Scheduler[] schedulerArr, Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        t.e(context, "<unused var>");
        t.e(configuration, "<unused var>");
        t.e(taskExecutor, "<unused var>");
        t.e(workDatabase, "<unused var>");
        t.e(trackers, "<unused var>");
        t.e(processor, "<unused var>");
        return C2242i.q0(schedulerArr);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        t.e(context, "context");
        t.e(configuration, "configuration");
        t.e(taskExecutor, "workTaskExecutor");
        return createWorkManager$default(context, configuration, taskExecutor, (WorkDatabase) null, (Trackers) null, (Processor) null, (k3.t) null, 120, (Object) null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        t.e(context, "context");
        t.e(configuration, "configuration");
        t.e(taskExecutor, "workTaskExecutor");
        t.e(workDatabase, "workDatabase");
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, (Trackers) null, (Processor) null, (k3.t) null, 112, (Object) null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers) {
        t.e(context, "context");
        t.e(configuration, "configuration");
        t.e(taskExecutor, "workTaskExecutor");
        t.e(workDatabase, "workDatabase");
        t.e(trackers, "trackers");
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, trackers, (Processor) null, (k3.t) null, 96, (Object) null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        t.e(context, "context");
        t.e(configuration, "configuration");
        t.e(taskExecutor, "workTaskExecutor");
        t.e(workDatabase, "workDatabase");
        t.e(trackers, "trackers");
        t.e(processor, "processor");
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, trackers, processor, (k3.t) null, 64, (Object) null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, k3.t tVar) {
        t.e(context, "context");
        t.e(configuration, "configuration");
        t.e(taskExecutor, "workTaskExecutor");
        t.e(workDatabase, "workDatabase");
        t.e(trackers, "trackers");
        t.e(processor, "processor");
        t.e(tVar, "schedulersCreator");
        Configuration configuration2 = configuration;
        Context context2 = context;
        k3.t tVar2 = tVar;
        Processor processor2 = processor;
        Trackers trackers2 = trackers;
        WorkDatabase workDatabase2 = workDatabase;
        TaskExecutor taskExecutor2 = taskExecutor;
        Configuration configuration3 = configuration2;
        return new WorkManagerImpl(context2.getApplicationContext(), configuration3, taskExecutor2, workDatabase2, (List) tVar2.invoke(context2, configuration3, taskExecutor2, workDatabase2, trackers2, processor2), processor2, trackers2);
    }
}
