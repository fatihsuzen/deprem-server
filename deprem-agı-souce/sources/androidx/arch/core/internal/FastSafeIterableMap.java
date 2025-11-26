package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private final HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap = new HashMap<>();

    @Nullable
    public Map.Entry<K, V> ceil(K k5) {
        if (contains(k5)) {
            return this.mHashMap.get(k5).mPrevious;
        }
        return null;
    }

    public boolean contains(K k5) {
        return this.mHashMap.containsKey(k5);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public SafeIterableMap.Entry<K, V> get(K k5) {
        return this.mHashMap.get(k5);
    }

    public V putIfAbsent(@NonNull K k5, @NonNull V v5) {
        SafeIterableMap.Entry entry = get(k5);
        if (entry != null) {
            return entry.mValue;
        }
        this.mHashMap.put(k5, put(k5, v5));
        return null;
    }

    public V remove(@NonNull K k5) {
        V remove = super.remove(k5);
        this.mHashMap.remove(k5);
        return remove;
    }
}
