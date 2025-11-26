package androidx.room.coroutines;

import androidx.room.Transactor;
import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", l = {543}, m = "beginTransaction")
final class PooledConnectionImpl$beginTransaction$1 extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PooledConnectionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PooledConnectionImpl$beginTransaction$1(PooledConnectionImpl pooledConnectionImpl, C2308e eVar) {
        super(eVar);
        this.this$0 = pooledConnectionImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.beginTransaction((Transactor.SQLiteTransactionType) null, this);
    }
}
