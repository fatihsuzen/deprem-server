package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import k3.t;

public final /* synthetic */ class v implements t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Scheduler[] f774a;

    public /* synthetic */ v(Scheduler[] schedulerArr) {
        this.f774a = schedulerArr;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return WorkManagerImplExtKt.schedulers$lambda$0(this.f774a, (Context) obj, (Configuration) obj2, (TaskExecutor) obj3, (WorkDatabase) obj4, (Trackers) obj5, (Processor) obj6);
    }
}
