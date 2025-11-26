package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import k3.C2616a;

public final /* synthetic */ class n implements CallbackToFutureAdapter.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executor f793a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2616a f794b;

    public /* synthetic */ n(Executor executor, C2616a aVar) {
        this.f793a = executor;
        this.f794b = aVar;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return WorkerKt.future$lambda$2(this.f793a, this.f794b, completer);
    }
}
