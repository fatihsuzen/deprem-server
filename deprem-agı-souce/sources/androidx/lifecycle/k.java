package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import w3.C2908y0;

public final /* synthetic */ class k implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LifecycleController f382a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2908y0 f383b;

    public /* synthetic */ k(LifecycleController lifecycleController, C2908y0 y0Var) {
        this.f382a = lifecycleController;
        this.f383b = y0Var;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleController.observer$lambda$0(this.f382a, this.f383b, lifecycleOwner, event);
    }
}
