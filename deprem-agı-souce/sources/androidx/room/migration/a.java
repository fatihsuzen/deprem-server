package androidx.room.migration;

import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.t;

public abstract /* synthetic */ class a {
    public static void a(AutoMigrationSpec autoMigrationSpec, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        if (sQLiteConnection instanceof SupportSQLiteConnection) {
            autoMigrationSpec.onPostMigrate(((SupportSQLiteConnection) sQLiteConnection).getDb());
        }
    }

    public static void b(AutoMigrationSpec autoMigrationSpec, SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
    }
}
