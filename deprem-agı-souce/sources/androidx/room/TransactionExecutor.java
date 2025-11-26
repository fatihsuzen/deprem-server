package androidx.room;

import W2.J;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;

public final class TransactionExecutor implements Executor {
    private Runnable active;
    private final Executor executor;
    private final Object syncLock = new Object();
    private final ArrayDeque<Runnable> tasks = new ArrayDeque<>();

    public TransactionExecutor(Executor executor2) {
        t.e(executor2, "executor");
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    public static final void execute$lambda$1$lambda$0(Runnable runnable, TransactionExecutor transactionExecutor) {
        try {
            runnable.run();
        } finally {
            transactionExecutor.scheduleNext();
        }
    }

    public void execute(Runnable runnable) {
        t.e(runnable, "command");
        synchronized (this.syncLock) {
            try {
                this.tasks.offer(new C0418r(runnable, this));
                if (this.active == null) {
                    scheduleNext();
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void scheduleNext() {
        synchronized (this.syncLock) {
            try {
                Runnable poll = this.tasks.poll();
                Runnable runnable = poll;
                this.active = runnable;
                if (poll != null) {
                    this.executor.execute(runnable);
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
