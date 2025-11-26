package androidx.room.concurrent;

import W2.J;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import k3.C2616a;
import kotlin.jvm.internal.t;

public final class CloseBarrier {
    private final AtomicInteger blockers = new AtomicInteger(0);
    private final C2616a closeAction;
    private final AtomicBoolean closeInitiated = new AtomicBoolean(false);

    public CloseBarrier(C2616a aVar) {
        t.e(aVar, "closeAction");
        this.closeAction = aVar;
    }

    private final boolean isClosed() {
        return this.closeInitiated.get();
    }

    public final boolean block$room_runtime_release() {
        synchronized (this) {
            if (isClosed()) {
                return false;
            }
            this.blockers.incrementAndGet();
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        if (r3.blockers.get() != 0) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r3.closeAction.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close$room_runtime_release() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.closeInitiated     // Catch:{ all -> 0x001e }
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r3)
            return
        L_0x000d:
            W2.J r0 = W2.J.f19942a     // Catch:{ all -> 0x001e }
            monitor-exit(r3)
            java.util.concurrent.atomic.AtomicInteger r0 = r3.blockers
        L_0x0012:
            int r1 = r0.get()
            if (r1 != 0) goto L_0x0012
            k3.a r0 = r3.closeAction
            r0.invoke()
            return
        L_0x001e:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.concurrent.CloseBarrier.close$room_runtime_release():void");
    }

    public final void unblock$room_runtime_release() {
        synchronized (this) {
            this.blockers.decrementAndGet();
            if (this.blockers.get() >= 0) {
                J j5 = J.f19942a;
            } else {
                throw new IllegalStateException("Unbalanced call to unblock() detected.");
            }
        }
    }
}
