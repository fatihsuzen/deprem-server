package androidx.work;

import d3.C2344a;
import d3.C2345b;

public enum ExistingPeriodicWorkPolicy {
    REPLACE,
    KEEP,
    UPDATE,
    CANCEL_AND_REENQUEUE;

    static {
        ExistingPeriodicWorkPolicy[] $values;
        $ENTRIES = C2345b.a($values);
    }

    public static C2344a getEntries() {
        return $ENTRIES;
    }
}
