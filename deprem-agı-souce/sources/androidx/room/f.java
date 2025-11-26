package androidx.room;

import k3.C2616a;

public final /* synthetic */ class f implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InvalidationTracker f436a;

    public /* synthetic */ f(InvalidationTracker invalidationTracker) {
        this.f436a = invalidationTracker;
    }

    public final Object invoke() {
        return InvalidationTracker.onRefreshScheduled$lambda$0(this.f436a);
    }
}
