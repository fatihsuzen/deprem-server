package androidx.lifecycle;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.lifecycle.EmittedSource$disposeNow$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
final class EmittedSource$disposeNow$2 extends l implements p {
    int label;
    final /* synthetic */ EmittedSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EmittedSource$disposeNow$2(EmittedSource emittedSource, C2308e eVar) {
        super(2, eVar);
        this.this$0 = emittedSource;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new EmittedSource$disposeNow$2(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            this.this$0.removeSource();
            return J.f19942a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((EmittedSource$disposeNow$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
