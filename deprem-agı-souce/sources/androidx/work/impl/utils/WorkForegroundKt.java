package androidx.work.impl.utils;

import W2.J;
import android.content.Context;
import android.os.Build;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import w3.C2872g;
import w3.C2894r0;

public final class WorkForegroundKt {
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkForegroundRunnable");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    public static final Object workForeground(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor, C2308e eVar) {
        if (!workSpec.expedited || Build.VERSION.SDK_INT >= 31) {
            return J.f19942a;
        }
        Executor mainThreadExecutor = taskExecutor.getMainThreadExecutor();
        t.d(mainThreadExecutor, "getMainThreadExecutor(...)");
        ListenableWorker listenableWorker2 = listenableWorker;
        Object g5 = C2872g.g(C2894r0.b(mainThreadExecutor), new WorkForegroundKt$workForeground$2(listenableWorker2, workSpec, foregroundUpdater, context, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
