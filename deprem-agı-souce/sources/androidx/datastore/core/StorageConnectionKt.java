package androidx.datastore.core;

import W2.J;
import b3.C2308e;
import c3.C2316b;

public final class StorageConnectionKt {
    public static final <T> Object readData(StorageConnection<T> storageConnection, C2308e eVar) {
        return storageConnection.readScope(new StorageConnectionKt$readData$2((C2308e) null), eVar);
    }

    public static final <T> Object writeData(StorageConnection<T> storageConnection, T t5, C2308e eVar) {
        Object writeScope = storageConnection.writeScope(new StorageConnectionKt$writeData$2(t5, (C2308e) null), eVar);
        if (writeScope == C2316b.f()) {
            return writeScope;
        }
        return J.f19942a;
    }
}
