package androidx.savedstate.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateRegistryImpl f473a;

    public /* synthetic */ a(SavedStateRegistryImpl savedStateRegistryImpl) {
        this.f473a = savedStateRegistryImpl;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        SavedStateRegistryImpl.performAttach$lambda$12(this.f473a, lifecycleOwner, event);
    }
}
