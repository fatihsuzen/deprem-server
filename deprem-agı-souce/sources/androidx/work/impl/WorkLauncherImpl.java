package androidx.work.impl;

import androidx.work.WorkerParameters;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.t;

public final class WorkLauncherImpl implements WorkLauncher {
    private final Processor processor;
    private final TaskExecutor workTaskExecutor;

    public WorkLauncherImpl(Processor processor2, TaskExecutor taskExecutor) {
        t.e(processor2, "processor");
        t.e(taskExecutor, "workTaskExecutor");
        this.processor = processor2;
        this.workTaskExecutor = taskExecutor;
    }

    /* access modifiers changed from: private */
    public static final void startWork$lambda$0(WorkLauncherImpl workLauncherImpl, StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        workLauncherImpl.processor.startWork(startStopToken, runtimeExtras);
    }

    public final Processor getProcessor() {
        return this.processor;
    }

    public final TaskExecutor getWorkTaskExecutor() {
        return this.workTaskExecutor;
    }

    public /* synthetic */ void startWork(StartStopToken startStopToken) {
        q.a(this, startStopToken);
    }

    public /* synthetic */ void stopWork(StartStopToken startStopToken) {
        q.b(this, startStopToken);
    }

    public /* synthetic */ void stopWorkWithReason(StartStopToken startStopToken, int i5) {
        q.c(this, startStopToken, i5);
    }

    public void startWork(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        t.e(startStopToken, "workSpecId");
        this.workTaskExecutor.executeOnTaskThread(new r(this, startStopToken, runtimeExtras));
    }

    public void stopWork(StartStopToken startStopToken, int i5) {
        t.e(startStopToken, "workSpecId");
        this.workTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this.processor, startStopToken, false, i5));
    }
}
