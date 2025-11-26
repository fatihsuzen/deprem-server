package androidx.work.impl.utils;

import W2.J;
import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.Tracer;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.t;

public final class PruneWorkRunnableKt {
    public static final Operation pruneWork(WorkDatabase workDatabase, Configuration configuration, TaskExecutor taskExecutor) {
        t.e(workDatabase, "<this>");
        t.e(configuration, "configuration");
        t.e(taskExecutor, "executor");
        Tracer tracer = configuration.getTracer();
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        t.d(serialTaskExecutor, "getSerialTaskExecutor(...)");
        return OperationKt.launchOperation(tracer, "PruneWork", serialTaskExecutor, new u(workDatabase));
    }

    /* access modifiers changed from: private */
    public static final J pruneWork$lambda$0(WorkDatabase workDatabase) {
        workDatabase.workSpecDao().pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();
        return J.f19942a;
    }
}
