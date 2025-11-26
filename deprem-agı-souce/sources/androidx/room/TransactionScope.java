package androidx.room;

import b3.C2308e;
import k3.p;

public interface TransactionScope<T> extends PooledConnection {
    Object rollback(T t5, C2308e eVar);

    <R> Object withNestedTransaction(p pVar, C2308e eVar);
}
