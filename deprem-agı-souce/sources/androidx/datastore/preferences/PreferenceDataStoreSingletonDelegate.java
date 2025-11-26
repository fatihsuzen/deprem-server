package androidx.datastore.preferences;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.t;
import n3.C2700a;
import r3.C2739i;
import w3.M;

public final class PreferenceDataStoreSingletonDelegate implements C2700a {
    @GuardedBy("lock")
    private volatile DataStore<Preferences> INSTANCE;
    private final ReplaceFileCorruptionHandler<Preferences> corruptionHandler;
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final String name;
    private final l produceMigrations;
    private final M scope;

    public PreferenceDataStoreSingletonDelegate(String str, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, l lVar, M m5) {
        t.e(str, RewardPlus.NAME);
        t.e(lVar, "produceMigrations");
        t.e(m5, "scope");
        this.name = str;
        this.corruptionHandler = replaceFileCorruptionHandler;
        this.produceMigrations = lVar;
        this.scope = m5;
    }

    public DataStore<Preferences> getValue(Context context, C2739i iVar) {
        DataStore<Preferences> dataStore;
        t.e(context, "thisRef");
        t.e(iVar, "property");
        DataStore<Preferences> dataStore2 = this.INSTANCE;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.lock) {
            try {
                if (this.INSTANCE == null) {
                    Context applicationContext = context.getApplicationContext();
                    PreferenceDataStoreFactory preferenceDataStoreFactory = PreferenceDataStoreFactory.INSTANCE;
                    ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler = this.corruptionHandler;
                    l lVar = this.produceMigrations;
                    t.d(applicationContext, "applicationContext");
                    this.INSTANCE = preferenceDataStoreFactory.create(replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) (List) lVar.invoke(applicationContext), this.scope, (C2616a) new PreferenceDataStoreSingletonDelegate$getValue$1$1(applicationContext, this));
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
