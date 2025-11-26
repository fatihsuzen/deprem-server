package androidx.work;

import d3.C2344a;
import d3.C2345b;

public enum BackoffPolicy {
    EXPONENTIAL,
    LINEAR;

    static {
        BackoffPolicy[] $values;
        $ENTRIES = C2345b.a($values);
    }

    public static C2344a getEntries() {
        return $ENTRIES;
    }
}
