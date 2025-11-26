package androidx.sqlite.driver;

import W2.C2219h;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class AndroidSQLiteConnection implements SQLiteConnection {
    private final SQLiteDatabase db;

    public AndroidSQLiteConnection(SQLiteDatabase sQLiteDatabase) {
        t.e(sQLiteDatabase, "db");
        this.db = sQLiteDatabase;
    }

    public void close() {
        this.db.close();
    }

    public final SQLiteDatabase getDb() {
        return this.db;
    }

    public SQLiteStatement prepare(String str) {
        t.e(str, "sql");
        if (this.db.isOpen()) {
            return AndroidSQLiteStatement.Companion.create(this.db, str);
        }
        SQLite.throwSQLiteException(21, "connection is closed");
        throw new C2219h();
    }
}
