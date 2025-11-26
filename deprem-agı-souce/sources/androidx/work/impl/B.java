package androidx.work.impl;

import java.util.concurrent.Callable;

public final /* synthetic */ class B implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f522a;

    public /* synthetic */ B(WorkerWrapper workerWrapper) {
        this.f522a = workerWrapper;
    }

    public final Object call() {
        return WorkerWrapper.runWorker$lambda$1(this.f522a);
    }
}
