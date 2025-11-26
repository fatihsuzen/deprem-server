package androidx.datastore.preferences.core;

import androidx.datastore.core.DataStore;
import b3.C2308e;
import k3.p;

public final class PreferencesKt {
    public static final Object edit(DataStore<Preferences> dataStore, p pVar, C2308e eVar) {
        return dataStore.updateData(new PreferencesKt$edit$2(pVar, (C2308e) null), eVar);
    }
}
