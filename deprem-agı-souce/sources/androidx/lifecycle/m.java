package androidx.lifecycle;

import k3.C2616a;

public final /* synthetic */ class m implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Lifecycle f385a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LifecycleEventObserver f386b;

    public /* synthetic */ m(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        this.f385a = lifecycle;
        this.f386b = lifecycleEventObserver;
    }

    public final Object invoke() {
        return LifecycleKt$eventFlow$1.invokeSuspend$lambda$1(this.f385a, this.f386b);
    }
}
