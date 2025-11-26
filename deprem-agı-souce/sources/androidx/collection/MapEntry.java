package androidx.collection;

import java.util.Map;
import l3.C2677a;

final class MapEntry<K, V> implements Map.Entry<K, V>, C2677a {
    private final K key;
    private final V value;

    public MapEntry(K k5, V v5) {
        this.key = k5;
        this.value = v5;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public V setValue(V v5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
