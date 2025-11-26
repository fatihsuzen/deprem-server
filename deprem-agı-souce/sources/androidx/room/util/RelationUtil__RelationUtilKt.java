package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.l;
import kotlin.jvm.internal.t;

final /* synthetic */ class RelationUtil__RelationUtilKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <V> void recursiveFetchLongSparseArray(LongSparseArray<V> longSparseArray, boolean z4, l lVar) {
        t.e(longSparseArray, "map");
        t.e(lVar, "fetchBlock");
        LongSparseArray longSparseArray2 = new LongSparseArray(999);
        int size = longSparseArray.size();
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            if (z4) {
                longSparseArray2.put(longSparseArray.keyAt(i5), longSparseArray.valueAt(i5));
            } else {
                longSparseArray2.put(longSparseArray.keyAt(i5), null);
            }
            i5++;
            i6++;
            if (i6 == 999) {
                lVar.invoke(longSparseArray2);
                if (!z4) {
                    longSparseArray.putAll(longSparseArray2);
                }
                longSparseArray2.clear();
                i6 = 0;
            }
        }
        if (i6 > 0) {
            lVar.invoke(longSparseArray2);
            if (!z4) {
                longSparseArray.putAll(longSparseArray2);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchMap(Map<K, V> map, boolean z4, l lVar) {
        int i5;
        t.e(map, "map");
        t.e(lVar, "fetchBlock");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        loop0:
        while (true) {
            i5 = 0;
            for (K next : map.keySet()) {
                if (z4) {
                    linkedHashMap.put(next, map.get(next));
                } else {
                    linkedHashMap.put(next, (Object) null);
                }
                i5++;
                if (i5 == 999) {
                    lVar.invoke(linkedHashMap);
                    if (!z4) {
                        map.putAll(linkedHashMap);
                    }
                    linkedHashMap.clear();
                }
            }
            break loop0;
        }
        if (i5 > 0) {
            lVar.invoke(linkedHashMap);
            if (!z4) {
                map.putAll(linkedHashMap);
            }
        }
    }
}
