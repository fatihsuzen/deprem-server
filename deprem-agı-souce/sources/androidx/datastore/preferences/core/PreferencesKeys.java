package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Set;
import kotlin.jvm.internal.t;

public final class PreferencesKeys {
    public static final Preferences.Key<Boolean> booleanKey(String str) {
        t.e(str, RewardPlus.NAME);
        return new Preferences.Key<>(str);
    }

    public static final Preferences.Key<byte[]> byteArrayKey(String str) {
        t.e(str, RewardPlus.NAME);
        return new Preferences.Key<>(str);
    }

    public static final Preferences.Key<Double> doubleKey(String str) {
        t.e(str, RewardPlus.NAME);
        return new Preferences.Key<>(str);
    }

    public static final Preferences.Key<Float> floatKey(String str) {
        t.e(str, RewardPlus.NAME);
        return new Preferences.Key<>(str);
    }

    public static final Preferences.Key<Integer> intKey(String str) {
        t.e(str, RewardPlus.NAME);
        return new Preferences.Key<>(str);
    }

    public static final Preferences.Key<Long> longKey(String str) {
        t.e(str, RewardPlus.NAME);
        return new Preferences.Key<>(str);
    }

    public static final Preferences.Key<String> stringKey(String str) {
        t.e(str, RewardPlus.NAME);
        return new Preferences.Key<>(str);
    }

    public static final Preferences.Key<Set<String>> stringSetKey(String str) {
        t.e(str, RewardPlus.NAME);
        return new Preferences.Key<>(str);
    }
}
