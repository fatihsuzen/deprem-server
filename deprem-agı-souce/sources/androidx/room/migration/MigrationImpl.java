package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;
import kotlin.jvm.internal.t;

final class MigrationImpl extends Migration {
    private final l migrateCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MigrationImpl(int i5, int i6, l lVar) {
        super(i5, i6);
        t.e(lVar, "migrateCallback");
        this.migrateCallback = lVar;
    }

    public final l getMigrateCallback() {
        return this.migrateCallback;
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        this.migrateCallback.invoke(supportSQLiteDatabase);
    }
}
