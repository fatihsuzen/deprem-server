package androidx.datastore.preferences.core;

import X2.C2250q;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.FileStorage;
import androidx.datastore.core.Storage;
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

public final class PreferenceDataStoreFactory {
    public static final PreferenceDataStoreFactory INSTANCE = new PreferenceDataStoreFactory();

    private PreferenceDataStoreFactory() {
    }

    public static /* synthetic */ DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, M m5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i5 & 4) != 0) {
            list = C2250q.g();
        }
        if ((i5 & 8) != 0) {
            m5 = N.a(Actual_jvmAndroidKt.ioDispatcher().plus(T0.b((C2908y0) null, 1, (Object) null)));
        }
        return preferenceDataStoreFactory.create((Storage<Preferences>) storage, (ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, m5);
    }

    public static /* synthetic */ DataStore createWithPath$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, M m5, C2616a aVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i5 & 2) != 0) {
            list = C2250q.g();
        }
        if ((i5 & 4) != 0) {
            m5 = N.a(Actual_jvmAndroidKt.ioDispatcher().plus(T0.b((C2908y0) null, 1, (Object) null)));
        }
        return preferenceDataStoreFactory.createWithPath(replaceFileCorruptionHandler, list, m5, aVar);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage) {
        t.e(storage, "storage");
        return create$default(this, (Storage) storage, (ReplaceFileCorruptionHandler) null, (List) null, (M) null, 14, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, C2616a aVar) {
        t.e(list, "migrations");
        t.e(aVar, "produceFile");
        return createWithPath$default(this, replaceFileCorruptionHandler, list, (M) null, aVar, 4, (Object) null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler) {
        t.e(storage, "storage");
        return create$default(this, (Storage) storage, (ReplaceFileCorruptionHandler) replaceFileCorruptionHandler, (List) null, (M) null, 12, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, C2616a aVar) {
        t.e(aVar, "produceFile");
        return createWithPath$default(this, replaceFileCorruptionHandler, (List) null, (M) null, aVar, 6, (Object) null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list) {
        t.e(storage, "storage");
        t.e(list, "migrations");
        return create$default(this, (Storage) storage, (ReplaceFileCorruptionHandler) replaceFileCorruptionHandler, (List) list, (M) null, 8, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(C2616a aVar) {
        t.e(aVar, "produceFile");
        return createWithPath$default(this, (ReplaceFileCorruptionHandler) null, (List) null, (M) null, aVar, 7, (Object) null);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, C2616a aVar) {
        t.e(list, "migrations");
        t.e(aVar, "produceFile");
        return create$default(this, (ReplaceFileCorruptionHandler) replaceFileCorruptionHandler, (List) list, (M) null, aVar, 4, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, M m5, C2616a aVar) {
        t.e(list, "migrations");
        t.e(m5, "scope");
        t.e(aVar, "produceFile");
        return create(replaceFileCorruptionHandler, list, m5, (C2616a) new PreferenceDataStoreFactory$createWithPath$1(aVar));
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, C2616a aVar) {
        t.e(aVar, "produceFile");
        return create$default(this, (ReplaceFileCorruptionHandler) replaceFileCorruptionHandler, (List) null, (M) null, aVar, 6, (Object) null);
    }

    public final DataStore<Preferences> create(C2616a aVar) {
        t.e(aVar, "produceFile");
        return create$default(this, (ReplaceFileCorruptionHandler) null, (List) null, (M) null, aVar, 7, (Object) null);
    }

    public static /* synthetic */ DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, M m5, C2616a aVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i5 & 2) != 0) {
            list = C2250q.g();
        }
        if ((i5 & 4) != 0) {
            m5 = N.a(C2865c0.b().plus(T0.b((C2908y0) null, 1, (Object) null)));
        }
        return preferenceDataStoreFactory.create((ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, m5, aVar);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, M m5, C2616a aVar) {
        t.e(list, "migrations");
        t.e(m5, "scope");
        t.e(aVar, "produceFile");
        return new PreferenceDataStore(create((Storage<Preferences>) new FileStorage(PreferencesFileSerializer.INSTANCE, (l) null, new PreferenceDataStoreFactory$create$delegate$1(aVar), 2, (C2633k) null), replaceFileCorruptionHandler, list, m5));
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, M m5) {
        t.e(storage, "storage");
        t.e(list, "migrations");
        t.e(m5, "scope");
        return new PreferenceDataStore(DataStoreFactory.INSTANCE.create(storage, replaceFileCorruptionHandler, list, m5));
    }
}
