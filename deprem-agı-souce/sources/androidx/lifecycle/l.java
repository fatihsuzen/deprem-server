package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import y3.v;

public final /* synthetic */ class l implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v f384a;

    public /* synthetic */ l(v vVar) {
        this.f384a = vVar;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleKt$eventFlow$1.invokeSuspend$lambda$0(this.f384a, lifecycleOwner, event);
    }
}
