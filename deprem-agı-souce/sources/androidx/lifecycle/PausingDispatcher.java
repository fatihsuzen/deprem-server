package androidx.lifecycle;

import b3.C2312i;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.I;

public final class PausingDispatcher extends I {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    public void dispatch(C2312i iVar, Runnable runnable) {
        t.e(iVar, "context");
        t.e(runnable, "block");
        this.dispatchQueue.dispatchAndEnqueue(iVar, runnable);
    }

    public boolean isDispatchNeeded(C2312i iVar) {
        t.e(iVar, "context");
        if (C2865c0.c().F().isDispatchNeeded(iVar)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
