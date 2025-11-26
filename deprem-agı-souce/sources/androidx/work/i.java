package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import k3.C2616a;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Tracer f514a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f515b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2616a f516c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MutableLiveData f517d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f518e;

    public /* synthetic */ i(Tracer tracer, String str, C2616a aVar, MutableLiveData mutableLiveData, CallbackToFutureAdapter.Completer completer) {
        this.f514a = tracer;
        this.f515b = str;
        this.f516c = aVar;
        this.f517d = mutableLiveData;
        this.f518e = completer;
    }

    public final void run() {
        OperationKt.launchOperation$lambda$2$lambda$1(this.f514a, this.f515b, this.f516c, this.f517d, this.f518e);
    }
}
