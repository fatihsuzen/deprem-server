package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import b3.C2312i;
import k3.p;
import w3.O;

public final /* synthetic */ class c implements CallbackToFutureAdapter.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2312i f501a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ O f502b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f503c;

    public /* synthetic */ c(C2312i iVar, O o5, p pVar) {
        this.f501a = iVar;
        this.f502b = o5;
        this.f503c = pVar;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ListenableFutureKt.launchFuture$lambda$1(this.f501a, this.f502b, this.f503c, completer);
    }
}
