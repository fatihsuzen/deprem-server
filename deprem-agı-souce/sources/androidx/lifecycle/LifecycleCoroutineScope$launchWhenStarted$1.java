package androidx.lifecycle;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.jvm.kt", l = {88}, m = "invokeSuspend")
final class LifecycleCoroutineScope$launchWhenStarted$1 extends l implements p {
    final /* synthetic */ p $block;
    int label;
    final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleCoroutineScope$launchWhenStarted$1(LifecycleCoroutineScope lifecycleCoroutineScope, p pVar, C2308e eVar) {
        super(2, eVar);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = pVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new LifecycleCoroutineScope$launchWhenStarted$1(this.this$0, this.$block, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            Lifecycle lifecycle$lifecycle_common = this.this$0.getLifecycle$lifecycle_common();
            p pVar = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.whenStarted(lifecycle$lifecycle_common, pVar, (C2308e) this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((LifecycleCoroutineScope$launchWhenStarted$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
