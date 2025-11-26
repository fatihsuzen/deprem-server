package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f761a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f762b;

    public /* synthetic */ h(WorkDatabase workDatabase, WorkManagerImpl workManagerImpl) {
        this.f761a = workDatabase;
        this.f762b = workManagerImpl;
    }

    public final void run() {
        CancelWorkRunnable.forAll$lambda$7$lambda$6(this.f761a, this.f762b);
    }
}
