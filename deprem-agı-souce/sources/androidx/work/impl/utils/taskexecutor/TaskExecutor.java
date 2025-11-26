package androidx.work.impl.utils.taskexecutor;

import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import w3.I;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface TaskExecutor {
    void executeOnTaskThread(Runnable runnable);

    Executor getMainThreadExecutor();

    SerialExecutor getSerialTaskExecutor();

    I getTaskCoroutineDispatcher();
}
