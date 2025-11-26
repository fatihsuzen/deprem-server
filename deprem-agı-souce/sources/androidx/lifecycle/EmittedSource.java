package androidx.lifecycle;

import W2.J;
import androidx.annotation.MainThread;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2869e0;
import w3.C2872g;
import w3.C2908y0;
import w3.N;
import w3.O;

public final class EmittedSource implements C2869e0 {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    public EmittedSource(LiveData<?> liveData, MediatorLiveData<?> mediatorLiveData) {
        t.e(liveData, "source");
        t.e(mediatorLiveData, "mediator");
        this.source = liveData;
        this.mediator = mediatorLiveData;
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void removeSource() {
        if (!this.disposed) {
            this.mediator.removeSource(this.source);
            this.disposed = true;
        }
    }

    public void dispose() {
        C2908y0 unused = C2876i.d(N.a(C2865c0.c().F()), (C2312i) null, (O) null, new EmittedSource$dispose$1(this, (C2308e) null), 3, (Object) null);
    }

    public final Object disposeNow(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c().F(), new EmittedSource$disposeNow$2(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
