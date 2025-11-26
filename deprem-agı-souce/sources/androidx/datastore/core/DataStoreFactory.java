package androidx.datastore.core;

import X2.C2250q;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import java.util.List;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.T0;

public final class DataStoreFactory {
    public static final DataStoreFactory INSTANCE = new DataStoreFactory();

    private DataStoreFactory() {
    }

    public static /* synthetic */ DataStore create$default(DataStoreFactory dataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, M m5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i5 & 4) != 0) {
            list = C2250q.g();
        }
        if ((i5 & 8) != 0) {
            m5 = N.a(Actual_jvmKt.ioDispatcher().plus(T0.b((C2908y0) null, 1, (Object) null)));
        }
        return dataStoreFactory.create(storage, replaceFileCorruptionHandler, list, m5);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, C2616a aVar) {
        t.e(serializer, "serializer");
        t.e(list, "migrations");
        t.e(aVar, "produceFile");
        return create$default(this, serializer, replaceFileCorruptionHandler, list, (M) null, aVar, 8, (Object) null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, C2616a aVar) {
        t.e(serializer, "serializer");
        t.e(aVar, "produceFile");
        return create$default(this, serializer, replaceFileCorruptionHandler, (List) null, (M) null, aVar, 12, (Object) null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, C2616a aVar) {
        t.e(serializer, "serializer");
        t.e(aVar, "produceFile");
        return create$default(this, serializer, (ReplaceFileCorruptionHandler) null, (List) null, (M) null, aVar, 14, (Object) null);
    }

    public static /* synthetic */ DataStore create$default(DataStoreFactory dataStoreFactory, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, M m5, C2616a aVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i5 & 4) != 0) {
            list = C2250q.g();
        }
        if ((i5 & 8) != 0) {
            m5 = N.a(C2865c0.b().plus(T0.b((C2908y0) null, 1, (Object) null)));
        }
        return dataStoreFactory.create(serializer, replaceFileCorruptionHandler, list, m5, aVar);
    }

    public final <T> DataStore<T> create(Storage<T> storage) {
        t.e(storage, "storage");
        return create$default(this, storage, (ReplaceFileCorruptionHandler) null, (List) null, (M) null, 14, (Object) null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler) {
        t.e(storage, "storage");
        return create$default(this, storage, replaceFileCorruptionHandler, (List) null, (M) null, 12, (Object) null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list) {
        t.e(storage, "storage");
        t.e(list, "migrations");
        return create$default(this, storage, replaceFileCorruptionHandler, list, (M) null, 8, (Object) null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, M m5, C2616a aVar) {
        t.e(serializer, "serializer");
        t.e(list, "migrations");
        t.e(m5, "scope");
        t.e(aVar, "produceFile");
        return create(new FileStorage(serializer, (l) null, aVar, 2, (C2633k) null), replaceFileCorruptionHandler, list, m5);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, M m5) {
        t.e(storage, "storage");
        t.e(list, "migrations");
        t.e(m5, "scope");
        CorruptionHandler corruptionHandler = replaceFileCorruptionHandler;
        if (replaceFileCorruptionHandler == null) {
            corruptionHandler = new NoOpCorruptionHandler();
        }
        return new DataStoreImpl(storage, C2250q.d(DataMigrationInitializer.Companion.getInitializer(list)), corruptionHandler, m5);
    }
}
