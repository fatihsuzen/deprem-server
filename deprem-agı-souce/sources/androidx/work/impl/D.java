package androidx.work.impl;

import java.util.concurrent.Callable;

public final /* synthetic */ class D implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f527a;

    public /* synthetic */ D(WorkerWrapper workerWrapper) {
        this.f527a = workerWrapper;
    }

    public final Object call() {
        return WorkerWrapper.trySetRunning$lambda$13(this.f527a);
    }
}
