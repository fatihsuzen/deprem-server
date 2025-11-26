package androidx.room.coroutines;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$2", f = "ConnectionPoolImpl.kt", l = {115}, m = "invokeSuspend")
final class ConnectionPoolImpl$useConnection$2 extends l implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ PooledConnectionImpl $confinedConnection;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionPoolImpl$useConnection$2(p pVar, PooledConnectionImpl pooledConnectionImpl, C2308e eVar) {
        super(2, eVar);
        this.$block = pVar;
        this.$confinedConnection = pooledConnectionImpl;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new ConnectionPoolImpl$useConnection$2(this.$block, this.$confinedConnection, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            p pVar = this.$block;
            PooledConnectionImpl pooledConnectionImpl = this.$confinedConnection;
            this.label = 1;
            Object invoke = pVar.invoke(pooledConnectionImpl, this);
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

    public final Object invoke(M m5, C2308e eVar) {
        return ((ConnectionPoolImpl$useConnection$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
