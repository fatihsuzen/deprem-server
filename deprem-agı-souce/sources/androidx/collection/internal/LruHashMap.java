package androidx.collection.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class LruHashMap<K, V> {
    private final LinkedHashMap<K, V> map;

    public LruHashMap() {
        this(0, 0.0f, 3, (C2633k) null);
    }

    public final V get(K k5) {
        t.e(k5, "key");
        return this.map.get(k5);
    }

    public final Set<Map.Entry<K, V>> getEntries() {
        Set<Map.Entry<K, V>> entrySet = this.map.entrySet();
        t.d(entrySet, "map.entries");
        return entrySet;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final V put(K k5, V v5) {
        t.e(k5, "key");
        t.e(v5, "value");
        return this.map.put(k5, v5);
    }

    public final V remove(K k5) {
        t.e(k5, "key");
        return this.map.remove(k5);
    }

    public LruHashMap(int i5, float f5) {
        this.map = new LinkedHashMap<>(i5, f5, true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LruHashMap(int i5, float f5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 16 : i5, (i6 & 2) != 0 ? 0.75f : f5);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LruHashMap(LruHashMap<? extends K, V> lruHashMap) {
        this(0, 0.0f, 3, (C2633k) null);
        t.e(lruHashMap, "original");
        for (Map.Entry next : lruHashMap.getEntries()) {
            put(next.getKey(), next.getValue());
        }
    }
}
