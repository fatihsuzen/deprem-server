package androidx.datastore;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.core.okio.OkioSerializer;
import androidx.datastore.core.okio.OkioStorage;
import e4.C2362k;
import java.util.List;
import k3.l;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import n3.C2700a;
import r3.C2739i;
import w3.M;

public final class DataStoreSingletonDelegate<T> implements C2700a {
    @GuardedBy("lock")
    private volatile DataStore<T> INSTANCE;
    private final ReplaceFileCorruptionHandler<T> corruptionHandler;
    /* access modifiers changed from: private */
    public final String fileName;
    private final Object lock = new Object();
    private final l produceMigrations;
    private final M scope;
    private final OkioSerializer<T> serializer;

    public DataStoreSingletonDelegate(String str, OkioSerializer<T> okioSerializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, l lVar, M m5) {
        t.e(str, "fileName");
        t.e(okioSerializer, "serializer");
        t.e(lVar, "produceMigrations");
        t.e(m5, "scope");
        this.fileName = str;
        this.serializer = okioSerializer;
        this.corruptionHandler = replaceFileCorruptionHandler;
        this.produceMigrations = lVar;
        this.scope = m5;
    }

    public DataStore<T> getValue(Context context, C2739i iVar) {
        DataStore<T> dataStore;
        t.e(context, "thisRef");
        t.e(iVar, "property");
        DataStore<T> dataStore2 = this.INSTANCE;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.lock) {
            try {
                if (this.INSTANCE == null) {
                    Context applicationContext = context.getApplicationContext();
                    DataStoreFactory dataStoreFactory = DataStoreFactory.INSTANCE;
                    OkioStorage okioStorage = new OkioStorage(C2362k.f21590b, this.serializer, (p) null, new DataStoreSingletonDelegate$getValue$1$1(applicationContext, this), 4, (C2633k) null);
                    ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler = this.corruptionHandler;
                    l lVar = this.produceMigrations;
                    t.d(applicationContext, "applicationContext");
                    this.INSTANCE = dataStoreFactory.create(okioStorage, replaceFileCorruptionHandler, (List) lVar.invoke(applicationContext), this.scope);
                }
                dataStore = this.INSTANCE;
                t.b(dataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataStore;
    }
}
