package w3;

import b3.C2312i;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: w3.q0  reason: case insensitive filesystem */
public final class C2893q0 extends C2891p0 implements W {

    /* renamed from: b  reason: collision with root package name */
    private final Executor f26311b;

    public C2893q0(Executor executor) {
        this.f26311b = executor;
        if (F() instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) F()).setRemoveOnCancelPolicy(true);
        }
    }

    private final void G(C2312i iVar, RejectedExecutionException rejectedExecutionException) {
        B0.c(iVar, C2887n0.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture H(ScheduledExecutorService scheduledExecutorService, Runnable runnable, C2312i iVar, long j5) {
        try {
            return scheduledExecutorService.schedule(runnable, j5, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e5) {
            G(iVar, e5);
            return null;
        }
    }

    public Executor F() {
        return this.f26311b;
    }

    public void close() {
        ExecutorService executorService;
        Executor F4 = F();
        if (F4 instanceof ExecutorService) {
            executorService = (ExecutorService) F4;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public void dispatch(C2312i iVar, Runnable runnable) {
        try {
            Executor F4 = F();
            C2864c.a();
            F4.execute(runnable);
        } catch (RejectedExecutionException e5) {
            C2864c.a();
            G(iVar, e5);
            C2865c0.b().dispatch(iVar, runnable);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2893q0) || ((C2893q0) obj).F() != F()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(F());
    }

    public void o(long j5, C2882l lVar) {
        ScheduledExecutorService scheduledExecutorService;
        long j6;
        Executor F4 = F();
        ScheduledFuture scheduledFuture = null;
        if (F4 instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) F4;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            j6 = j5;
            scheduledFuture = H(scheduledExecutorService, new Q0(this, lVar), lVar.getContext(), j6);
        } else {
            j6 = j5;
        }
        if (scheduledFuture != null) {
            C2890p.c(lVar, new C2878j(scheduledFuture));
        } else {
            S.f26256g.o(j6, lVar);
        }
    }

    public C2869e0 q(long j5, Runnable runnable, C2312i iVar) {
        ScheduledExecutorService scheduledExecutorService;
        long j6;
        C2312i iVar2;
        Runnable runnable2;
        Executor F4 = F();
        ScheduledFuture scheduledFuture = null;
        if (F4 instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) F4;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            j6 = j5;
            runnable2 = runnable;
            iVar2 = iVar;
            scheduledFuture = H(scheduledExecutorService, runnable2, iVar2, j6);
        } else {
            j6 = j5;
            runnable2 = runnable;
            iVar2 = iVar;
        }
        if (scheduledFuture != null) {
            return new C2867d0(scheduledFuture);
        }
        return S.f26256g.q(j6, runnable2, iVar2);
    }

    public String toString() {
        return F().toString();
    }
}
