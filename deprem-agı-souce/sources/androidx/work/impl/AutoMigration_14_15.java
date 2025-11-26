package androidx.work.impl;

import android.content.ContentValues;
import androidx.room.RenameColumn;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.a;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.t;

@RenameColumn(fromColumnName = "period_start_time", tableName = "WorkSpec", toColumnName = "last_enqueue_time")
public final class AutoMigration_14_15 implements AutoMigrationSpec {
    public /* synthetic */ void onPostMigrate(SQLiteConnection sQLiteConnection) {
        a.a(this, sQLiteConnection);
    }

    public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.execSQL("UPDATE workspec SET period_count = 1 WHERE last_enqueue_time <> 0 AND interval_duration <> 0");
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("last_enqueue_time", Long.valueOf(System.currentTimeMillis()));
        supportSQLiteDatabase.update("WorkSpec", 3, contentValues, "last_enqueue_time = 0 AND interval_duration <> 0 ", new Object[0]);
    }
}
