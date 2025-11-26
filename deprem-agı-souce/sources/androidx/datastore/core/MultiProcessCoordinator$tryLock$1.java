package androidx.datastore.core;

import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.MultiProcessCoordinator", f = "MultiProcessCoordinator.android.kt", l = {62, 87}, m = "tryLock")
final class MultiProcessCoordinator$tryLock$1<T> extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiProcessCoordinator$tryLock$1(MultiProcessCoordinator multiProcessCoordinator, C2308e eVar) {
        super(eVar);
        this.this$0 = multiProcessCoordinator;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.tryLock((p) null, this);
    }
}
