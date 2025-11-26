package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import k3.C2616a;

public final /* synthetic */ class b implements CallbackToFutureAdapter.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executor f498a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f499b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2616a f500c;

    public /* synthetic */ b(Executor executor, String str, C2616a aVar) {
        this.f498a = executor;
        this.f499b = str;
        this.f500c = aVar;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ListenableFutureKt.executeAsync$lambda$4(this.f498a, this.f499b, this.f500c, completer);
    }
}
