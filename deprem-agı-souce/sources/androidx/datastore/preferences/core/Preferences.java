package androidx.datastore.preferences.core;

import X2.M;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Map;
import kotlin.jvm.internal.t;

public abstract class Preferences {

    public static final class Key<T> {
        private final String name;

        public Key(String str) {
            t.e(str, RewardPlus.NAME);
            this.name = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                return t.a(this.name, ((Key) obj).name);
            }
            return false;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public final Pair<T> to(T t5) {
            return new Pair<>(this, t5);
        }

        public String toString() {
            return this.name;
        }
    }

    public static final class Pair<T> {
        private final Key<T> key;
        private final T value;

        public Pair(Key<T> key2, T t5) {
            t.e(key2, "key");
            this.key = key2;
            this.value = t5;
        }

        public final Key<T> getKey$datastore_preferences_core_release() {
            return this.key;
        }

        public final T getValue$datastore_preferences_core_release() {
            return this.value;
        }
    }

    public abstract Map<Key<?>, Object> asMap();

    public abstract <T> boolean contains(Key<T> key);

    public abstract <T> T get(Key<T> key);

    public final MutablePreferences toMutablePreferences() {
        return new MutablePreferences(M.v(asMap()), false);
    }

    public final Preferences toPreferences() {
        return new MutablePreferences(M.v(asMap()), true);
    }
}
