package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import java.util.HashMap;
import java.util.Map;
import k3.l;

public final class RelationUtil {
    public static final int MAX_BIND_PARAMETER_CNT = 999;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchArrayMap(ArrayMap<K, V> arrayMap, boolean z4, l lVar) {
        RelationUtil__RelationUtil_androidKt.recursiveFetchArrayMap(arrayMap, z4, lVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchHashMap(HashMap<K, V> hashMap, boolean z4, l lVar) {
        RelationUtil__RelationUtil_androidKt.recursiveFetchHashMap(hashMap, z4, lVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <V> void recursiveFetchLongSparseArray(LongSparseArray<V> longSparseArray, boolean z4, l lVar) {
        RelationUtil__RelationUtilKt.recursiveFetchLongSparseArray(longSparseArray, z4, lVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchMap(Map<K, V> map, boolean z4, l lVar) {
        RelationUtil__RelationUtilKt.recursiveFetchMap(map, z4, lVar);
    }
}
