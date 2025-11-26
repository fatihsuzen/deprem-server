package androidx.datastore.core;

import b3.C2308e;
import k3.p;
import k3.q;

public interface StorageConnection<T> extends Closeable {
    InterProcessCoordinator getCoordinator();

    <R> Object readScope(q qVar, C2308e eVar);

    Object writeScope(p pVar, C2308e eVar);
}
