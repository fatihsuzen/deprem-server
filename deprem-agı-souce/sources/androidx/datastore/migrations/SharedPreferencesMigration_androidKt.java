package androidx.datastore.migrations;

import java.util.LinkedHashSet;
import java.util.Set;

public final class SharedPreferencesMigration_androidKt {
    private static final Set<String> MIGRATE_ALL_KEYS = new LinkedHashSet();

    public static final Set<String> getMIGRATE_ALL_KEYS() {
        return MIGRATE_ALL_KEYS;
    }
}
