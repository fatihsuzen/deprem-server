package androidx.work;

import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f789a;

    public /* synthetic */ l(AtomicBoolean atomicBoolean) {
        this.f789a = atomicBoolean;
    }

    public final void run() {
        WorkerKt.future$lambda$2$lambda$0(this.f789a);
    }
}
