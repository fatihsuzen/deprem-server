package androidx.work.impl;

import androidx.work.Logger;
import kotlin.jvm.internal.t;

public final class WorkDatabasePathHelperKt {
    /* access modifiers changed from: private */
    public static final String[] DATABASE_EXTRA_FILES = {"-journal", "-shm", "-wal"};
    /* access modifiers changed from: private */
    public static final String TAG;
    public static final String WORK_DATABASE_NAME = "androidx.work.workdb";

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WrkDbPathHelper");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }
}
