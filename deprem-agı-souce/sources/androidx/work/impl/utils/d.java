package androidx.work.impl.utils;

import androidx.work.impl.WorkManagerImpl;
import k3.C2616a;

public final /* synthetic */ class d implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f754a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f755b;

    public /* synthetic */ d(String str, WorkManagerImpl workManagerImpl) {
        this.f754a = str;
        this.f755b = workManagerImpl;
    }

    public final Object invoke() {
        return CancelWorkRunnable.forName$lambda$4(this.f754a, this.f755b);
    }
}
