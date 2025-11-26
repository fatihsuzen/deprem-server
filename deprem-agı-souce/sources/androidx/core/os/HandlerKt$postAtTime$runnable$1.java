package androidx.core.os;

import k3.C2616a;

public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    final /* synthetic */ C2616a $action;

    public HandlerKt$postAtTime$runnable$1(C2616a aVar) {
        this.$action = aVar;
    }

    public final void run() {
        this.$action.invoke();
    }
}
