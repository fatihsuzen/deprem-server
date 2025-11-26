package androidx.datastore.preferences;

import W2.J;
import W2.u;
import X2.C2250q;
import androidx.datastore.migrations.SharedPreferencesView;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import b3.C2308e;
import c3.C2316b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import k3.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;

@f(c = "androidx.datastore.preferences.SharedPreferencesMigrationKt$getMigrationFunction$1", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
final class SharedPreferencesMigrationKt$getMigrationFunction$1 extends l implements q {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    SharedPreferencesMigrationKt$getMigrationFunction$1(C2308e eVar) {
        super(3, eVar);
    }

    public final Object invoke(SharedPreferencesView sharedPreferencesView, Preferences preferences, C2308e eVar) {
        SharedPreferencesMigrationKt$getMigrationFunction$1 sharedPreferencesMigrationKt$getMigrationFunction$1 = new SharedPreferencesMigrationKt$getMigrationFunction$1(eVar);
        sharedPreferencesMigrationKt$getMigrationFunction$1.L$0 = sharedPreferencesView;
        sharedPreferencesMigrationKt$getMigrationFunction$1.L$1 = preferences;
        return sharedPreferencesMigrationKt$getMigrationFunction$1.invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            SharedPreferencesView sharedPreferencesView = (SharedPreferencesView) this.L$0;
            Preferences preferences = (Preferences) this.L$1;
            Set<Preferences.Key<?>> keySet = preferences.asMap().keySet();
            ArrayList arrayList = new ArrayList(C2250q.p(keySet, 10));
            for (Preferences.Key name : keySet) {
                arrayList.add(name.getName());
            }
            Map<String, Object> all = sharedPreferencesView.getAll();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : all.entrySet()) {
                if (!arrayList.contains((String) next.getKey())) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            MutablePreferences mutablePreferences = preferences.toMutablePreferences();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Boolean) {
                    mutablePreferences.set(PreferencesKeys.booleanKey(str), value);
                } else if (value instanceof Float) {
                    mutablePreferences.set(PreferencesKeys.floatKey(str), value);
                } else if (value instanceof Integer) {
                    mutablePreferences.set(PreferencesKeys.intKey(str), value);
                } else if (value instanceof Long) {
                    mutablePreferences.set(PreferencesKeys.longKey(str), value);
                } else if (value instanceof String) {
                    mutablePreferences.set(PreferencesKeys.stringKey(str), value);
                } else if (value instanceof Set) {
                    Preferences.Key<Set<String>> stringSetKey = PreferencesKeys.stringSetKey(str);
                    t.c(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                    mutablePreferences.set(stringSetKey, (Set) value);
                }
            }
            return mutablePreferences.toPreferences();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
