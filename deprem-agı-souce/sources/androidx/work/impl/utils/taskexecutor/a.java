package androidx.work.impl.utils.taskexecutor;

import w3.C2894r0;
import w3.I;

public abstract /* synthetic */ class a {
    public static void a(TaskExecutor taskExecutor, Runnable runnable) {
        taskExecutor.getSerialTaskExecutor().execute(runnable);
    }

    public static I b(TaskExecutor taskExecutor) {
        return C2894r0.b(taskExecutor.getSerialTaskExecutor());
    }
}
