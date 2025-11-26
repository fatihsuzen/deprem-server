package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import z3.w;

public final /* synthetic */ class j implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w f381a;

    public /* synthetic */ j(w wVar) {
        this.f381a = wVar;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Lifecycle._get_currentStateFlow_$lambda$0(this.f381a, lifecycleOwner, event);
    }
}
