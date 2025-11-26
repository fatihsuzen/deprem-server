package androidx.datastore.core;

import b3.C2308e;
import k3.l;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.MultiProcessCoordinator", f = "MultiProcessCoordinator.android.kt", l = {211, 47, 48}, m = "lock")
final class MultiProcessCoordinator$lock$1<T> extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiProcessCoordinator$lock$1(MultiProcessCoordinator multiProcessCoordinator, C2308e eVar) {
        super(eVar);
        this.this$0 = multiProcessCoordinator;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.lock((l) null, this);
    }
}
