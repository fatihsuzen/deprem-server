package androidx.lifecycle;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {168}, m = "invokeSuspend")
final class BlockRunner$maybeRun$1 extends l implements p {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BlockRunner<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlockRunner$maybeRun$1(BlockRunner<T> blockRunner, C2308e eVar) {
        super(2, eVar);
        this.this$0 = blockRunner;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        BlockRunner$maybeRun$1 blockRunner$maybeRun$1 = new BlockRunner$maybeRun$1(this.this$0, eVar);
        blockRunner$maybeRun$1.L$0 = obj;
        return blockRunner$maybeRun$1;
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(this.this$0.liveData, ((M) this.L$0).getCoroutineContext());
            p access$getBlock$p = this.this$0.block;
            this.label = 1;
            if (access$getBlock$p.invoke(liveDataScopeImpl, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.onDone.invoke();
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((BlockRunner$maybeRun$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
