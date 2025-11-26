package androidx.datastore.core;

import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.SingleProcessCoordinator", f = "SingleProcessCoordinator.kt", l = {50}, m = "tryLock")
final class SingleProcessCoordinator$tryLock$1<T> extends d {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleProcessCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessCoordinator$tryLock$1(SingleProcessCoordinator singleProcessCoordinator, C2308e eVar) {
        super(eVar);
        this.this$0 = singleProcessCoordinator;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.tryLock((p) null, this);
    }
}
