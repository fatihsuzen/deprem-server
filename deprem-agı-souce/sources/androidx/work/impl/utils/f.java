package androidx.work.impl.utils;

import androidx.work.impl.WorkManagerImpl;
import k3.C2616a;

public final /* synthetic */ class f implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f758a;

    public /* synthetic */ f(WorkManagerImpl workManagerImpl) {
        this.f758a = workManagerImpl;
    }

    public final Object invoke() {
        return CancelWorkRunnable.forAll$lambda$7(this.f758a);
    }
}
