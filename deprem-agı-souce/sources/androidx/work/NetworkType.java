package androidx.work;

import d3.C2344a;
import d3.C2345b;

public enum NetworkType {
    NOT_REQUIRED,
    CONNECTED,
    UNMETERED,
    NOT_ROAMING,
    METERED,
    TEMPORARILY_UNMETERED;

    static {
        NetworkType[] $values;
        $ENTRIES = C2345b.a($values);
    }

    public static C2344a getEntries() {
        return $ENTRIES;
    }
}
