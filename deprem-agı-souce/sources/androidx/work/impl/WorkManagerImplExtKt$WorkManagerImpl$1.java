package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.List;
import k3.t;
import kotlin.jvm.internal.C2639q;

final /* synthetic */ class WorkManagerImplExtKt$WorkManagerImpl$1 extends C2639q implements t {
    public static final WorkManagerImplExtKt$WorkManagerImpl$1 INSTANCE = new WorkManagerImplExtKt$WorkManagerImpl$1();

    WorkManagerImplExtKt$WorkManagerImpl$1() {
        super(6, WorkManagerImplExtKt.class, "createSchedulers", "createSchedulers(Landroid/content/Context;Landroidx/work/Configuration;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/WorkDatabase;Landroidx/work/impl/constraints/trackers/Trackers;Landroidx/work/impl/Processor;)Ljava/util/List;", 1);
    }

    public final List<Scheduler> invoke(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        kotlin.jvm.internal.t.e(context, "p0");
        kotlin.jvm.internal.t.e(configuration, "p1");
        kotlin.jvm.internal.t.e(taskExecutor, "p2");
        kotlin.jvm.internal.t.e(workDatabase, "p3");
        kotlin.jvm.internal.t.e(trackers, "p4");
        kotlin.jvm.internal.t.e(processor, "p5");
        return WorkManagerImplExtKt.createSchedulers(context, configuration, taskExecutor, workDatabase, trackers, processor);
    }
}
