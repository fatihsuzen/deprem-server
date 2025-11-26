package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.C2616a;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f790a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f791b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2616a f792c;

    public /* synthetic */ m(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, C2616a aVar) {
        this.f790a = atomicBoolean;
        this.f791b = completer;
        this.f792c = aVar;
    }

    public final void run() {
        WorkerKt.future$lambda$2$lambda$1(this.f790a, this.f791b, this.f792c);
    }
}
