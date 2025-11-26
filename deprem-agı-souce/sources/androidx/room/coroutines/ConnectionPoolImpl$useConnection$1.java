package androidx.room.coroutines;

import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.coroutines.ConnectionPoolImpl", f = "ConnectionPoolImpl.kt", l = {114, 118, 541, 147}, m = "useConnection")
final class ConnectionPoolImpl$useConnection$1<R> extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConnectionPoolImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionPoolImpl$useConnection$1(ConnectionPoolImpl connectionPoolImpl, C2308e eVar) {
        super(eVar);
        this.this$0 = connectionPoolImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.useConnection(false, (p) null, this);
    }
}
