package androidx.work.impl;

import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.a;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.t;

public final class AutoMigration_19_20 implements AutoMigrationSpec {
    public /* synthetic */ void onPostMigrate(SQLiteConnection sQLiteConnection) {
        a.a(this, sQLiteConnection);
    }

    public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.execSQL("UPDATE WorkSpec SET `last_enqueue_time` = -1 WHERE `last_enqueue_time` = 0");
    }
}
