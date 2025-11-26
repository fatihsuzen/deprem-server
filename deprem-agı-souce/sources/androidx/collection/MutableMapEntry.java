package androidx.collection;

import java.util.Map;
import kotlin.jvm.internal.t;
import l3.C2680d;

final class MutableMapEntry<K, V> implements Map.Entry<K, V>, C2680d {
    private final int index;
    private final Object[] keys;
    private final Object[] values;

    public MutableMapEntry(Object[] objArr, Object[] objArr2, int i5) {
        t.e(objArr, "keys");
        t.e(objArr2, "values");
        this.keys = objArr;
        this.values = objArr2;
        this.index = i5;
    }

    public static /* synthetic */ void getKey$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public final int getIndex() {
        return this.index;
    }

    public K getKey() {
        return this.keys[this.index];
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public V getValue() {
        return this.values[this.index];
    }

    public final Object[] getValues() {
        return this.values;
    }

    public V setValue(V v5) {
        V[] vArr = this.values;
        int i5 = this.index;
        V v6 = vArr[i5];
        vArr[i5] = v5;
        return v6;
    }
}
