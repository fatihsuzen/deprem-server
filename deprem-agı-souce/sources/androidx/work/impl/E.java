package androidx.work.impl;

import androidx.work.impl.WorkerWrapper;
import java.util.concurrent.Callable;

public final /* synthetic */ class E implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper.Resolution f528a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f529b;

    public /* synthetic */ E(WorkerWrapper.Resolution resolution, WorkerWrapper workerWrapper) {
        this.f528a = resolution;
        this.f529b = workerWrapper;
    }

    public final Object call() {
        return WorkerWrapper$launch$1.invokeSuspend$lambda$1(this.f528a, this.f529b);
    }
}
