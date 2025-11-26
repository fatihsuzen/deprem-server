package androidx.datastore.core;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.datastore.core.MultiProcessCoordinator$withLazyCounter$2", f = "MultiProcessCoordinator.android.kt", l = {163}, m = "invokeSuspend")
public final class MultiProcessCoordinator$withLazyCounter$2 extends l implements p {
    final /* synthetic */ p $block;
    int label;
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiProcessCoordinator$withLazyCounter$2(p pVar, MultiProcessCoordinator multiProcessCoordinator, C2308e eVar) {
        super(2, eVar);
        this.$block = pVar;
        this.this$0 = multiProcessCoordinator;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new MultiProcessCoordinator$withLazyCounter$2(this.$block, this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            p pVar = this.$block;
            SharedCounter access$getSharedCounter = this.this$0.getSharedCounter();
            this.label = 1;
            Object invoke = pVar.invoke(access$getSharedCounter, this);
            if (invoke == f5) {
                return f5;
            }
            return invoke;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        return this.$block.invoke(this.this$0.getSharedCounter(), this);
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((MultiProcessCoordinator$withLazyCounter$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
