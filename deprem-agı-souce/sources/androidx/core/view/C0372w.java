package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* renamed from: androidx.core.view.w  reason: case insensitive filesystem */
public final /* synthetic */ class C0372w implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f331a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f332b;

    public /* synthetic */ C0372w(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.f331a = menuHostHelper;
        this.f332b = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        MenuHostHelper.b(this.f331a, this.f332b, lifecycleOwner, event);
    }
}
