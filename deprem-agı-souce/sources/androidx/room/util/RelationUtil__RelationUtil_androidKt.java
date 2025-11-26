package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.util.HashMap;
import k3.l;
import kotlin.jvm.internal.t;

final /* synthetic */ class RelationUtil__RelationUtil_androidKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchArrayMap(ArrayMap<K, V> arrayMap, boolean z4, l lVar) {
        t.e(arrayMap, "map");
        t.e(lVar, "fetchBlock");
        ArrayMap arrayMap2 = new ArrayMap(999);
        int size = arrayMap.size();
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            if (z4) {
                arrayMap2.put(arrayMap.keyAt(i5), arrayMap.valueAt(i5));
            } else {
                arrayMap2.put(arrayMap.keyAt(i5), (Object) null);
            }
            i5++;
            i6++;
            if (i6 == 999) {
                lVar.invoke(arrayMap2);
                if (!z4) {
                    arrayMap.putAll(arrayMap2);
                }
                arrayMap2.clear();
                i6 = 0;
            }
        }
        if (i6 > 0) {
            lVar.invoke(arrayMap2);
            if (!z4) {
                arrayMap.putAll(arrayMap2);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchHashMap(HashMap<K, V> hashMap, boolean z4, l lVar) {
        int i5;
        t.e(hashMap, "map");
        t.e(lVar, "fetchBlock");
        HashMap hashMap2 = new HashMap(999);
        loop0:
        while (true) {
            i5 = 0;
            for (K next : hashMap.keySet()) {
                t.d(next, "next(...)");
                if (z4) {
                    hashMap2.put(next, hashMap.get(next));
                } else {
                    hashMap2.put(next, (Object) null);
                }
                i5++;
                if (i5 == 999) {
                    lVar.invoke(hashMap2);
                    if (!z4) {
                        hashMap.putAll(hashMap2);
                    }
                    hashMap2.clear();
                }
            }
            break loop0;
        }
        if (i5 > 0) {
            lVar.invoke(hashMap2);
            if (!z4) {
                hashMap.putAll(hashMap2);
            }
        }
    }
}
