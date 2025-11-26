package androidx.datastore.preferences.core;

import X2.C2250q;
import androidx.annotation.RestrictTo;
import j$.util.DesugarCollections;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.I;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Actual_jvmAndroidKt {
    public static final <T> Set<T> immutableCopyOfSet(Set<? extends T> set) {
        t.e(set, "set");
        Set<T> unmodifiableSet = DesugarCollections.unmodifiableSet(C2250q.r0(set));
        t.d(unmodifiableSet, "unmodifiableSet(set.toSet())");
        return unmodifiableSet;
    }

    public static final <K, V> Map<K, V> immutableMap(Map<K, ? extends V> map) {
        t.e(map, "map");
        Map<K, V> unmodifiableMap = DesugarCollections.unmodifiableMap(map);
        t.d(unmodifiableMap, "unmodifiableMap(map)");
        return unmodifiableMap;
    }

    public static final I ioDispatcher() {
        return C2865c0.b();
    }
}
