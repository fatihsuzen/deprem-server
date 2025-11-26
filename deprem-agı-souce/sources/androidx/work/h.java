package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.Executor;
import k3.C2616a;

public final /* synthetic */ class h implements CallbackToFutureAdapter.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executor f509a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Tracer f510b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f511c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C2616a f512d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MutableLiveData f513e;

    public /* synthetic */ h(Executor executor, Tracer tracer, String str, C2616a aVar, MutableLiveData mutableLiveData) {
        this.f509a = executor;
        this.f510b = tracer;
        this.f511c = str;
        this.f512d = aVar;
        this.f513e = mutableLiveData;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return OperationKt.launchOperation$lambda$2(this.f509a, this.f510b, this.f511c, this.f512d, this.f513e, completer);
    }
}
