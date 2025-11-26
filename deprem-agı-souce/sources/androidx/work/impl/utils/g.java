package androidx.work.impl.utils;

import androidx.work.impl.WorkManagerImpl;
import java.util.UUID;
import k3.C2616a;

public final /* synthetic */ class g implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f759a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UUID f760b;

    public /* synthetic */ g(WorkManagerImpl workManagerImpl, UUID uuid) {
        this.f759a = workManagerImpl;
        this.f760b = uuid;
    }

    public final Object invoke() {
        return CancelWorkRunnable.forId$lambda$1(this.f759a, this.f760b);
    }
}
