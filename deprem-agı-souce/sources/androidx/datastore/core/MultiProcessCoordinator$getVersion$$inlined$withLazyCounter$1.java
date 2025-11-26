package androidx.datastore.core;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.datastore.core.MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1", f = "MultiProcessCoordinator.android.kt", l = {}, m = "invokeSuspend")
public final class MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1 extends l implements p {
    int label;
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(MultiProcessCoordinator multiProcessCoordinator, C2308e eVar) {
        super(2, eVar);
        this.this$0 = multiProcessCoordinator;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            return b.b(this.this$0.getSharedCounter().getValue());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
