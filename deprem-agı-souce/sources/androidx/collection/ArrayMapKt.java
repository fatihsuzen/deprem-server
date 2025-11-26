package androidx.collection;

import W2.s;
import kotlin.jvm.internal.t;

public final class ArrayMapKt {
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    public static final <K, V> ArrayMap<K, V> arrayMapOf(s... sVarArr) {
        t.e(sVarArr, "pairs");
        ArrayMap<K, V> arrayMap = new ArrayMap<>(sVarArr.length);
        for (s sVar : sVarArr) {
            arrayMap.put(sVar.c(), sVar.d());
        }
        return arrayMap;
    }
}
