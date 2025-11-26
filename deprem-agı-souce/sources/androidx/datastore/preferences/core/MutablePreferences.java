package androidx.datastore.preferences.core;

import W2.s;
import X2.C2250q;
import X2.M;
import androidx.datastore.preferences.core.Preferences;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class MutablePreferences extends Preferences {
    private final AtomicBoolean frozen;
    private final Map<Preferences.Key<?>, Object> preferencesMap;

    public MutablePreferences() {
        this((Map) null, false, 3, (C2633k) null);
    }

    public Map<Preferences.Key<?>, Object> asMap() {
        s sVar;
        Set<Map.Entry<Preferences.Key<?>, Object>> entrySet = this.preferencesMap.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(C2729e.c(M.e(C2250q.p(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                t.d(copyOf, "copyOf(this, size)");
                sVar = new s(key, copyOf);
            } else {
                sVar = new s(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(sVar.c(), sVar.d());
        }
        return Actual_jvmAndroidKt.immutableMap(linkedHashMap);
    }

    public final void checkNotFrozen$datastore_preferences_core_release() {
        if (this.frozen.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void clear() {
        checkNotFrozen$datastore_preferences_core_release();
        this.preferencesMap.clear();
    }

    public <T> boolean contains(Preferences.Key<T> key) {
        t.e(key, "key");
        return this.preferencesMap.containsKey(key);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.preferences.core.MutablePreferences
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            androidx.datastore.preferences.core.MutablePreferences r6 = (androidx.datastore.preferences.core.MutablePreferences) r6
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r0 = r6.preferencesMap
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            r3 = 1
            if (r0 != r2) goto L_0x0010
            return r3
        L_0x0010:
            int r0 = r0.size()
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            int r2 = r2.size()
            if (r0 == r2) goto L_0x001d
            return r1
        L_0x001d:
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r6 = r6.preferencesMap
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0026
            return r3
        L_0x0026:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x002e:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0067
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r2 = r2.get(r4)
            if (r2 == 0) goto L_0x0063
            java.lang.Object r0 = r0.getValue()
            boolean r4 = r0 instanceof byte[]
            if (r4 == 0) goto L_0x005e
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L_0x0063
            byte[] r0 = (byte[]) r0
            byte[] r2 = (byte[]) r2
            boolean r0 = java.util.Arrays.equals(r0, r2)
            if (r0 == 0) goto L_0x0063
            r0 = r3
            goto L_0x0064
        L_0x005e:
            boolean r0 = kotlin.jvm.internal.t.a(r0, r2)
            goto L_0x0064
        L_0x0063:
            r0 = r1
        L_0x0064:
            if (r0 != 0) goto L_0x002e
            return r1
        L_0x0067:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.core.MutablePreferences.equals(java.lang.Object):boolean");
    }

    public final void freeze$datastore_preferences_core_release() {
        this.frozen.set(true);
    }

    public <T> T get(Preferences.Key<T> key) {
        t.e(key, "key");
        T t5 = this.preferencesMap.get(key);
        if (!(t5 instanceof byte[])) {
            return t5;
        }
        byte[] bArr = (byte[]) t5;
        Object copyOf = Arrays.copyOf(bArr, bArr.length);
        t.d(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public final Map<Preferences.Key<?>, Object> getPreferencesMap$datastore_preferences_core_release() {
        return this.preferencesMap;
    }

    public int hashCode() {
        int i5;
        int i6 = 0;
        for (Map.Entry value : this.preferencesMap.entrySet()) {
            Object value2 = value.getValue();
            if (value2 instanceof byte[]) {
                i5 = Arrays.hashCode((byte[]) value2);
            } else {
                i5 = value2.hashCode();
            }
            i6 += i5;
        }
        return i6;
    }

    public final void minusAssign(Preferences.Key<?> key) {
        t.e(key, "key");
        checkNotFrozen$datastore_preferences_core_release();
        remove(key);
    }

    public final void plusAssign(Preferences preferences) {
        t.e(preferences, "prefs");
        checkNotFrozen$datastore_preferences_core_release();
        this.preferencesMap.putAll(preferences.asMap());
    }

    public final void putAll(Preferences.Pair<?>... pairArr) {
        t.e(pairArr, "pairs");
        checkNotFrozen$datastore_preferences_core_release();
        for (Preferences.Pair<?> pair : pairArr) {
            setUnchecked$datastore_preferences_core_release(pair.getKey$datastore_preferences_core_release(), pair.getValue$datastore_preferences_core_release());
        }
    }

    public final <T> T remove(Preferences.Key<T> key) {
        t.e(key, "key");
        checkNotFrozen$datastore_preferences_core_release();
        return this.preferencesMap.remove(key);
    }

    public final <T> void set(Preferences.Key<T> key, T t5) {
        t.e(key, "key");
        setUnchecked$datastore_preferences_core_release(key, t5);
    }

    public final void setUnchecked$datastore_preferences_core_release(Preferences.Key<?> key, Object obj) {
        t.e(key, "key");
        checkNotFrozen$datastore_preferences_core_release();
        if (obj == null) {
            remove(key);
        } else if (obj instanceof Set) {
            this.preferencesMap.put(key, Actual_jvmAndroidKt.immutableCopyOfSet((Set) obj));
        } else if (obj instanceof byte[]) {
            Map<Preferences.Key<?>, Object> map = this.preferencesMap;
            byte[] bArr = (byte[]) obj;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            t.d(copyOf, "copyOf(this, size)");
            map.put(key, copyOf);
        } else {
            this.preferencesMap.put(key, obj);
        }
    }

    public String toString() {
        return C2250q.V(this.preferencesMap.entrySet(), ",\n", "{\n", "\n}", 0, (CharSequence) null, MutablePreferences$toString$1.INSTANCE, 24, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutablePreferences(Map map, boolean z4, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? new LinkedHashMap() : map, (i5 & 2) != 0 ? true : z4);
    }

    public final void plusAssign(Preferences.Pair<?> pair) {
        t.e(pair, "pair");
        checkNotFrozen$datastore_preferences_core_release();
        putAll(pair);
    }

    public MutablePreferences(Map<Preferences.Key<?>, Object> map, boolean z4) {
        t.e(map, "preferencesMap");
        this.preferencesMap = map;
        this.frozen = new AtomicBoolean(z4);
    }
}
