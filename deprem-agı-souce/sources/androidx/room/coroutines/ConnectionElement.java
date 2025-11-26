package androidx.room.coroutines;

import b3.C2312i;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

final class ConnectionElement implements C2312i.b {
    public static final Key Key = new Key((C2633k) null);
    private final PooledConnectionImpl connectionWrapper;

    public static final class Key implements C2312i.c {
        public /* synthetic */ Key(C2633k kVar) {
            this();
        }

        private Key() {
        }
    }

    public ConnectionElement(PooledConnectionImpl pooledConnectionImpl) {
        t.e(pooledConnectionImpl, "connectionWrapper");
        this.connectionWrapper = pooledConnectionImpl;
    }

    public <R> R fold(R r5, p pVar) {
        return C2312i.b.a.a(this, r5, pVar);
    }

    public <E extends C2312i.b> E get(C2312i.c cVar) {
        return C2312i.b.a.b(this, cVar);
    }

    public final PooledConnectionImpl getConnectionWrapper() {
        return this.connectionWrapper;
    }

    public C2312i.c getKey() {
        return Key;
    }

    public C2312i minusKey(C2312i.c cVar) {
        return C2312i.b.a.c(this, cVar);
    }

    public C2312i plus(C2312i iVar) {
        return C2312i.b.a.d(this, iVar);
    }
}
