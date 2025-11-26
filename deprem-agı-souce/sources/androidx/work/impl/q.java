package androidx.work.impl;

import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import kotlin.jvm.internal.t;

public abstract /* synthetic */ class q {
    public static void a(WorkLauncher workLauncher, StartStopToken startStopToken) {
        t.e(startStopToken, "workSpecId");
        workLauncher.startWork(startStopToken, (WorkerParameters.RuntimeExtras) null);
    }

    public static void b(WorkLauncher workLauncher, StartStopToken startStopToken) {
        t.e(startStopToken, "workSpecId");
        workLauncher.stopWork(startStopToken, WorkInfo.STOP_REASON_UNKNOWN);
    }

    public static void c(WorkLauncher workLauncher, StartStopToken startStopToken, int i5) {
        t.e(startStopToken, "workSpecId");
        workLauncher.stopWork(startStopToken, i5);
    }
}
