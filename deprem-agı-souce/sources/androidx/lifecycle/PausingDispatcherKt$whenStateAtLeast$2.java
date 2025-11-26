package androidx.lifecycle;

import W2.J;
import W2.u;
import androidx.lifecycle.Lifecycle;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.C2872g;
import w3.C2908y0;
import w3.M;

@f(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.jvm.kt", l = {213}, m = "invokeSuspend")
final class PausingDispatcherKt$whenStateAtLeast$2 extends l implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, p pVar, C2308e eVar) {
        super(2, eVar);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = pVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, eVar);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    public final Object invokeSuspend(Object obj) {
        LifecycleController lifecycleController;
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            C2908y0 y0Var = (C2908y0) ((M) this.L$0).getCoroutineContext().get(C2908y0.f26320k0);
            if (y0Var != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, y0Var);
                try {
                    p pVar = this.$block;
                    this.L$0 = lifecycleController2;
                    this.label = 1;
                    obj = C2872g.g(pausingDispatcher, pVar, this);
                    if (obj == f5) {
                        return f5;
                    }
                    lifecycleController = lifecycleController2;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController = lifecycleController2;
                    lifecycleController.finish();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job");
            }
        } else if (i5 == 1) {
            lifecycleController = (LifecycleController) this.L$0;
            try {
                u.b(obj);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        lifecycleController.finish();
        return obj;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
