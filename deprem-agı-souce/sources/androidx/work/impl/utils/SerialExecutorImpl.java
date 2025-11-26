package androidx.work.impl.utils;

import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class SerialExecutorImpl implements SerialExecutor {
    @GuardedBy("mLock")
    private Runnable mActive;
    private final Executor mExecutor;
    final Object mLock = new Object();
    private final ArrayDeque<Task> mTasks = new ArrayDeque<>();

    static class Task implements Runnable {
        final Runnable mRunnable;
        final SerialExecutorImpl mSerialExecutor;

        Task(SerialExecutorImpl serialExecutorImpl, Runnable runnable) {
            this.mSerialExecutor = serialExecutorImpl;
            this.mRunnable = runnable;
        }

        public void run() {
            try {
                this.mRunnable.run();
                synchronized (this.mSerialExecutor.mLock) {
                    this.mSerialExecutor.scheduleNext();
                }
            } catch (Throwable th) {
                synchronized (this.mSerialExecutor.mLock) {
                    this.mSerialExecutor.scheduleNext();
                    throw th;
                }
            }
        }
    }

    public SerialExecutorImpl(Executor executor) {
        this.mExecutor = executor;
    }

    public void execute(Runnable runnable) {
        synchronized (this.mLock) {
            try {
                this.mTasks.add(new Task(this, runnable));
                if (this.mActive == null) {
                    scheduleNext();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public Executor getDelegatedExecutor() {
        return this.mExecutor;
    }

    public boolean hasPendingTasks() {
        boolean z4;
        synchronized (this.mLock) {
            z4 = !this.mTasks.isEmpty();
        }
        return z4;
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("mLock")
    public void scheduleNext() {
        Runnable poll = this.mTasks.poll();
        this.mActive = poll;
        if (poll != null) {
            this.mExecutor.execute(poll);
        }
    }
}
