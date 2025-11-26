package androidx.work.impl.utils;

import androidx.work.impl.WorkManagerImpl;
import java.util.UUID;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f756a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UUID f757b;

    public /* synthetic */ e(WorkManagerImpl workManagerImpl, UUID uuid) {
        this.f756a = workManagerImpl;
        this.f757b = uuid;
    }

    public final void run() {
        CancelWorkRunnable.forId$lambda$1$lambda$0(this.f756a, this.f757b);
    }
}
