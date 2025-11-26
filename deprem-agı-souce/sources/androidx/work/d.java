package androidx.work;

import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f504a;

    public /* synthetic */ d(AtomicBoolean atomicBoolean) {
        this.f504a = atomicBoolean;
    }

    public final void run() {
        ListenableFutureKt.executeAsync$lambda$4$lambda$2(this.f504a);
    }
}
