package androidx.room.migration;

import W2.r;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.t;

public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int i5, int i6) {
        this.startVersion = i5;
        this.endVersion = i6;
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        throw new r("Migration functionality with a SupportSQLiteDatabase (without a provided SQLiteDriver) requires overriding the migrate(SupportSQLiteDatabase) function.");
    }

    public void migrate(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        if (sQLiteConnection instanceof SupportSQLiteConnection) {
            migrate(((SupportSQLiteConnection) sQLiteConnection).getDb());
            return;
        }
        throw new r("Migration functionality with a provided SQLiteDriver requires overriding the migrate(SQLiteConnection) function.");
    }
}
