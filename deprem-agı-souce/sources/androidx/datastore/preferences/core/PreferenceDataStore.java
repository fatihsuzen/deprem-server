package androidx.datastore.preferences.core;

import androidx.datastore.core.DataStore;
import b3.C2308e;
import k3.p;
import kotlin.jvm.internal.t;
import z3.C2972e;

public final class PreferenceDataStore implements DataStore<Preferences> {
    private final DataStore<Preferences> delegate;

    public PreferenceDataStore(DataStore<Preferences> dataStore) {
        t.e(dataStore, "delegate");
        this.delegate = dataStore;
    }

    public C2972e getData() {
        return this.delegate.getData();
    }

    public Object updateData(p pVar, C2308e eVar) {
        return this.delegate.updateData(new PreferenceDataStore$updateData$2(pVar, (C2308e) null), eVar);
    }
}
