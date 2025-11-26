package androidx.work;

import d3.C2344a;
import d3.C2345b;

public enum OutOfQuotaPolicy {
    RUN_AS_NON_EXPEDITED_WORK_REQUEST,
    DROP_WORK_REQUEST;

    static {
        OutOfQuotaPolicy[] $values;
        $ENTRIES = C2345b.a($values);
    }

    public static C2344a getEntries() {
        return $ENTRIES;
    }
}
