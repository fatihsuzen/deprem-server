package androidx.lifecycle;

import W2.J;
import W2.u;
import androidx.lifecycle.Lifecycle;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.CancellationException;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
final class LifecycleCoroutineScopeImpl$register$1 extends l implements p {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LifecycleCoroutineScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleCoroutineScopeImpl$register$1(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, C2308e eVar) {
        super(2, eVar);
        this.this$0 = lifecycleCoroutineScopeImpl;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        LifecycleCoroutineScopeImpl$register$1 lifecycleCoroutineScopeImpl$register$1 = new LifecycleCoroutineScopeImpl$register$1(this.this$0, eVar);
        lifecycleCoroutineScopeImpl$register$1.L$0 = obj;
        return lifecycleCoroutineScopeImpl$register$1;
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            M m5 = (M) this.L$0;
            if (this.this$0.getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                this.this$0.getLifecycle$lifecycle_common().addObserver(this.this$0);
            } else {
                C0.d(m5.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
            }
            return J.f19942a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((LifecycleCoroutineScopeImpl$register$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
