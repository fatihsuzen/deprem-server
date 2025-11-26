package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import w3.U;

public final /* synthetic */ class a implements CallbackToFutureAdapter.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U f402a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f403b;

    public /* synthetic */ a(U u5, Object obj) {
        this.f402a = u5;
        this.f403b = obj;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return CoroutineAdapterKt.asListenableFuture$lambda$0(this.f402a, this.f403b, completer);
    }
}
