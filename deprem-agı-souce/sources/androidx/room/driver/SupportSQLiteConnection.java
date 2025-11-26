package androidx.room.driver;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SupportSQLiteConnection implements SQLiteConnection {
    private final SupportSQLiteDatabase db;

    public SupportSQLiteConnection(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        this.db = supportSQLiteDatabase;
    }

    public void close() {
        this.db.close();
    }

    public final SupportSQLiteDatabase getDb() {
        return this.db;
    }

    public SupportSQLiteStatement prepare(String str) {
        t.e(str, "sql");
        return SupportSQLiteStatement.Companion.create(this.db, str);
    }
}
