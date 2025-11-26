package androidx.datastore.core;

import b3.C2308e;

public interface DataMigration<T> {
    Object cleanUp(C2308e eVar);

    Object migrate(T t5, C2308e eVar);

    Object shouldMigrate(T t5, C2308e eVar);
}
