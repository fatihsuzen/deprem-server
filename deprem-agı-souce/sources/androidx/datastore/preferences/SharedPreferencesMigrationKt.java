package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.migrations.SharedPreferencesMigration;
import androidx.datastore.preferences.core.Preferences;
import b3.C2308e;
import java.util.LinkedHashSet;
import java.util.Set;
import k3.C2616a;
import k3.p;
import k3.q;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class SharedPreferencesMigrationKt {
    private static final Set<String> MIGRATE_ALL_KEYS = new LinkedHashSet();

    public static final SharedPreferencesMigration<Preferences> SharedPreferencesMigration(Context context, String str) {
        t.e(context, "context");
        t.e(str, "sharedPreferencesName");
        return SharedPreferencesMigration$default(context, str, (Set) null, 4, (Object) null);
    }

    public static /* synthetic */ SharedPreferencesMigration SharedPreferencesMigration$default(C2616a aVar, Set<String> set, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            set = MIGRATE_ALL_KEYS;
        }
        return SharedPreferencesMigration(aVar, set);
    }

    public static final Set<String> getMIGRATE_ALL_KEYS() {
        return MIGRATE_ALL_KEYS;
    }

    private static final q getMigrationFunction() {
        return new SharedPreferencesMigrationKt$getMigrationFunction$1((C2308e) null);
    }

    private static final p getShouldRunMigration(Set<String> set) {
        return new SharedPreferencesMigrationKt$getShouldRunMigration$1(set, (C2308e) null);
    }

    public static final SharedPreferencesMigration<Preferences> SharedPreferencesMigration(C2616a aVar) {
        t.e(aVar, "produceSharedPreferences");
        return SharedPreferencesMigration$default(aVar, (Set) null, 2, (Object) null);
    }

    public static final SharedPreferencesMigration<Preferences> SharedPreferencesMigration(C2616a aVar, Set<String> set) {
        t.e(aVar, "produceSharedPreferences");
        t.e(set, "keysToMigrate");
        if (set != MIGRATE_ALL_KEYS) {
            return new SharedPreferencesMigration<>(aVar, set, getShouldRunMigration(set), getMigrationFunction());
        }
        return new SharedPreferencesMigration<>(aVar, (Set) null, getShouldRunMigration(set), getMigrationFunction(), 2, (C2633k) null);
    }

    public static /* synthetic */ SharedPreferencesMigration SharedPreferencesMigration$default(Context context, String str, Set<String> set, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            set = MIGRATE_ALL_KEYS;
        }
        return SharedPreferencesMigration(context, str, set);
    }

    public static final SharedPreferencesMigration<Preferences> SharedPreferencesMigration(Context context, String str, Set<String> set) {
        t.e(context, "context");
        t.e(str, "sharedPreferencesName");
        t.e(set, "keysToMigrate");
        if (set == MIGRATE_ALL_KEYS) {
            return new SharedPreferencesMigration<>(context, str, (Set) null, getShouldRunMigration(set), getMigrationFunction(), 4, (C2633k) null);
        }
        return new SharedPreferencesMigration<>(context, str, set, getShouldRunMigration(set), getMigrationFunction());
    }
}
