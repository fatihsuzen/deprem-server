package androidx.datastore.migrations;

import X2.C2250q;
import X2.M;
import android.content.SharedPreferences;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;

public final class SharedPreferencesView {
    private final Set<String> keySet;
    private final SharedPreferences prefs;

    public SharedPreferencesView(SharedPreferences sharedPreferences, Set<String> set) {
        t.e(sharedPreferences, "prefs");
        this.prefs = sharedPreferences;
        this.keySet = set;
    }

    private final String checkKey(String str) {
        Set<String> set = this.keySet;
        if (set == null || set.contains(str)) {
            return str;
        }
        throw new IllegalStateException(("Can't access key outside migration: " + str).toString());
    }

    public static /* synthetic */ String getString$default(SharedPreferencesView sharedPreferencesView, String str, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = null;
        }
        return sharedPreferencesView.getString(str, str2);
    }

    public static /* synthetic */ Set getStringSet$default(SharedPreferencesView sharedPreferencesView, String str, Set set, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            set = null;
        }
        return sharedPreferencesView.getStringSet(str, set);
    }

    public final boolean contains(String str) {
        t.e(str, "key");
        return this.prefs.contains(checkKey(str));
    }

    public final Map<String, Object> getAll() {
        boolean z4;
        Map<String, ?> all = this.prefs.getAll();
        t.d(all, "prefs.all");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : all.entrySet()) {
            String str = (String) next.getKey();
            Set<String> set = this.keySet;
            if (set != null) {
                z4 = set.contains(str);
            } else {
                z4 = true;
            }
            if (z4) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(M.e(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Set) {
                value = C2250q.r0((Iterable) value);
            }
            linkedHashMap2.put(key, value);
        }
        return linkedHashMap2;
    }

    public final boolean getBoolean(String str, boolean z4) {
        t.e(str, "key");
        return this.prefs.getBoolean(checkKey(str), z4);
    }

    public final float getFloat(String str, float f5) {
        t.e(str, "key");
        return this.prefs.getFloat(checkKey(str), f5);
    }

    public final int getInt(String str, int i5) {
        t.e(str, "key");
        return this.prefs.getInt(checkKey(str), i5);
    }

    public final long getLong(String str, long j5) {
        t.e(str, "key");
        return this.prefs.getLong(checkKey(str), j5);
    }

    public final String getString(String str, String str2) {
        t.e(str, "key");
        return this.prefs.getString(checkKey(str), str2);
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        t.e(str, "key");
        Set<String> stringSet = this.prefs.getStringSet(checkKey(str), set);
        if (stringSet != null) {
            return C2250q.q0(stringSet);
        }
        return null;
    }
}
