package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.C2616a;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f505a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f506b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2616a f507c;

    public /* synthetic */ e(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, C2616a aVar) {
        this.f505a = atomicBoolean;
        this.f506b = completer;
        this.f507c = aVar;
    }

    public final void run() {
        ListenableFutureKt.executeAsync$lambda$4$lambda$3(this.f505a, this.f506b, this.f507c);
    }
}
