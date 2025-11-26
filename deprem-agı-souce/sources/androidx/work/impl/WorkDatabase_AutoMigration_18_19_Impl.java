package androidx.work.impl;

import androidx.room.migration.Migration;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.internal.t;

public final class WorkDatabase_AutoMigration_18_19_Impl extends Migration {
    public WorkDatabase_AutoMigration_18_19_Impl() {
        super(18, 19);
    }

    public void migrate(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        SQLite.execSQL(sQLiteConnection, "ALTER TABLE `WorkSpec` ADD COLUMN `stop_reason` INTEGER NOT NULL DEFAULT -256");
    }
}
