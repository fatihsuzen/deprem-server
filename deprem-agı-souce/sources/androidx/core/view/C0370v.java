package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* renamed from: androidx.core.view.v  reason: case insensitive filesystem */
public final /* synthetic */ class C0370v implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f328a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f329b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f330c;

    public /* synthetic */ C0370v(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.f328a = menuHostHelper;
        this.f329b = state;
        this.f330c = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        MenuHostHelper.a(this.f328a, this.f329b, this.f330c, lifecycleOwner, event);
    }
}
