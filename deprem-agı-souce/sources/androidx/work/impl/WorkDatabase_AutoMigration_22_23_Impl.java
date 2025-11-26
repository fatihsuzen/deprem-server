package androidx.work.impl;

import androidx.room.migration.Migration;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.internal.t;

public final class WorkDatabase_AutoMigration_22_23_Impl extends Migration {
    public WorkDatabase_AutoMigration_22_23_Impl() {
        super(22, 23);
    }

    public void migrate(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        SQLite.execSQL(sQLiteConnection, "ALTER TABLE `WorkSpec` ADD COLUMN `trace_tag` TEXT DEFAULT NULL");
    }
}
