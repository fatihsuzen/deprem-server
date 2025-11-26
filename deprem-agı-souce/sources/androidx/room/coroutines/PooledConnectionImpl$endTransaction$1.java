package androidx.room.coroutines;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", l = {543}, m = "endTransaction")
final class PooledConnectionImpl$endTransaction$1 extends d {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PooledConnectionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PooledConnectionImpl$endTransaction$1(PooledConnectionImpl pooledConnectionImpl, C2308e eVar) {
        super(eVar);
        this.this$0 = pooledConnectionImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.endTransaction(false, this);
    }
}
