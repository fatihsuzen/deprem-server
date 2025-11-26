package androidx.room.migration;

import k3.l;
import kotlin.jvm.internal.t;

public final class MigrationKt {
    public static final Migration Migration(int i5, int i6, l lVar) {
        t.e(lVar, "migrate");
        return new MigrationImpl(i5, i6, lVar);
    }
}
