package androidx.lifecycle;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import b3.C2312i;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.I0;

public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;
    private final Queue<Runnable> queue = new ArrayDeque();

    /* access modifiers changed from: private */
    public static final void dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue dispatchQueue, Runnable runnable) {
        dispatchQueue.enqueue(runnable);
    }

    @MainThread
    private final void enqueue(Runnable runnable) {
        if (this.queue.offer(runnable)) {
            drainQueue();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables");
    }

    @MainThread
    public final boolean canRun() {
        if (this.finished || !this.paused) {
            return true;
        }
        return false;
    }

    @AnyThread
    public final void dispatchAndEnqueue(C2312i iVar, Runnable runnable) {
        t.e(iVar, "context");
        t.e(runnable, "runnable");
        I0 F4 = C2865c0.c().F();
        if (F4.isDispatchNeeded(iVar) || canRun()) {
            F4.dispatch(iVar, new g(this, runnable));
        } else {
            enqueue(runnable);
        }
    }

    @MainThread
    public final void drainQueue() {
        if (!this.isDraining) {
            boolean z4 = true;
            z4 = false;
            try {
                while (true) {
                    if (this.queue.isEmpty()) {
                        break;
                    } else if (!canRun()) {
                        break;
                    } else {
                        Runnable poll = this.queue.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                this.isDraining = z4;
            } finally {
                this.isDraining = z4;
            }
        }
    }

    @MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.paused = true;
    }

    @MainThread
    public final void resume() {
        if (this.paused) {
            if (!this.finished) {
                this.paused = false;
                drainQueue();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher");
        }
    }
}
