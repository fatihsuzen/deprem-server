package androidx.room;

import k3.C2616a;

public final /* synthetic */ class g implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InvalidationTracker f437a;

    public /* synthetic */ g(InvalidationTracker invalidationTracker) {
        this.f437a = invalidationTracker;
    }

    public final Object invoke() {
        return InvalidationTracker.onRefreshCompleted$lambda$1(this.f437a);
    }
}
