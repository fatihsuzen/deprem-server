package androidx.room.migration;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;

public interface AutoMigrationSpec {
    void onPostMigrate(SQLiteConnection sQLiteConnection);

    void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase);
}
