package androidx.work;

import d3.C2344a;
import d3.C2345b;

public enum ExistingWorkPolicy {
    REPLACE,
    KEEP,
    APPEND,
    APPEND_OR_REPLACE;

    static {
        ExistingWorkPolicy[] $values;
        $ENTRIES = C2345b.a($values);
    }

    public static C2344a getEntries() {
        return $ENTRIES;
    }
}
