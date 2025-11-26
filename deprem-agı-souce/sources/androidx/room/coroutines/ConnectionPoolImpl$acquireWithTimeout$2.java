package androidx.room.coroutines;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.L;
import w3.M;

@f(c = "androidx.room.coroutines.ConnectionPoolImpl$acquireWithTimeout$2", f = "ConnectionPoolImpl.kt", l = {171}, m = "invokeSuspend")
public final class ConnectionPoolImpl$acquireWithTimeout$2 extends l implements p {
    final /* synthetic */ L $connection;
    final /* synthetic */ Pool $this_acquireWithTimeout;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionPoolImpl$acquireWithTimeout$2(L l5, Pool pool, C2308e eVar) {
        super(2, eVar);
        this.$connection = l5;
        this.$this_acquireWithTimeout = pool;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new ConnectionPoolImpl$acquireWithTimeout$2(this.$connection, this.$this_acquireWithTimeout, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        L l5;
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            L l6 = this.$connection;
            Pool pool = this.$this_acquireWithTimeout;
            this.L$0 = l6;
            this.label = 1;
            Object acquire = pool.acquire(this);
            if (acquire == f5) {
                return f5;
            }
            l5 = l6;
            obj = acquire;
        } else if (i5 == 1) {
            l5 = (L) this.L$0;
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l5.f24690a = obj;
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((ConnectionPoolImpl$acquireWithTimeout$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
