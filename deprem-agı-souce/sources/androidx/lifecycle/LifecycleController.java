package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t;
import w3.C2908y0;

@MainThread
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle2, Lifecycle.State state, DispatchQueue dispatchQueue2, C2908y0 y0Var) {
        t.e(lifecycle2, "lifecycle");
        t.e(state, "minState");
        t.e(dispatchQueue2, "dispatchQueue");
        t.e(y0Var, "parentJob");
        this.lifecycle = lifecycle2;
        this.minState = state;
        this.dispatchQueue = dispatchQueue2;
        k kVar = new k(this, y0Var);
        this.observer = kVar;
        if (lifecycle2.getCurrentState() == Lifecycle.State.DESTROYED) {
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
            finish();
            return;
        }
        lifecycle2.addObserver(kVar);
    }

    private final void handleDestroy(C2908y0 y0Var) {
        C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        finish();
    }

    /* access modifiers changed from: private */
    public static final void observer$lambda$0(LifecycleController lifecycleController, C2908y0 y0Var, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        t.e(lifecycleOwner, "source");
        t.e(event, "<unused var>");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
            lifecycleController.finish();
        } else if (lifecycleOwner.getLifecycle().getCurrentState().compareTo(lifecycleController.minState) < 0) {
            lifecycleController.dispatchQueue.pause();
        } else {
            lifecycleController.dispatchQueue.resume();
        }
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
