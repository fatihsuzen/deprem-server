package androidx.room.coroutines;

import androidx.room.Transactor;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", l = {376, 380, 393, 393, 393}, m = "transaction")
final class PooledConnectionImpl$transaction$1<R> extends d {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PooledConnectionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PooledConnectionImpl$transaction$1(PooledConnectionImpl pooledConnectionImpl, C2308e eVar) {
        super(eVar);
        this.this$0 = pooledConnectionImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.transaction((Transactor.SQLiteTransactionType) null, (p) null, this);
    }
}
