package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.SerialExecutorImpl;
import java.util.concurrent.Executor;
import w3.C2894r0;
import w3.I;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkManagerTaskExecutor implements TaskExecutor {
    private final SerialExecutorImpl mBackgroundExecutor;
    private final Executor mMainThreadExecutor = new Executor() {
        public void execute(Runnable runnable) {
            WorkManagerTaskExecutor.this.mMainThreadHandler.post(runnable);
        }
    };
    final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    private final I mTaskDispatcher;

    public WorkManagerTaskExecutor(Executor executor) {
        SerialExecutorImpl serialExecutorImpl = new SerialExecutorImpl(executor);
        this.mBackgroundExecutor = serialExecutorImpl;
        this.mTaskDispatcher = C2894r0.b(serialExecutorImpl);
    }

    public /* synthetic */ void executeOnTaskThread(Runnable runnable) {
        a.a(this, runnable);
    }

    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }

    public I getTaskCoroutineDispatcher() {
        return this.mTaskDispatcher;
    }

    public SerialExecutorImpl getSerialTaskExecutor() {
        return this.mBackgroundExecutor;
    }
}
