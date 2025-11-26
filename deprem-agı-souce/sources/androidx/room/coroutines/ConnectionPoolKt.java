package androidx.room.coroutines;

import androidx.sqlite.SQLiteDriver;
import kotlin.jvm.internal.t;

public final class ConnectionPoolKt {
    public static final ConnectionPool newConnectionPool(SQLiteDriver sQLiteDriver, String str, int i5, int i6) {
        t.e(sQLiteDriver, "driver");
        t.e(str, "fileName");
        return new ConnectionPoolImpl(sQLiteDriver, str, i5, i6);
    }

    public static final ConnectionPool newSingleConnectionPool(SQLiteDriver sQLiteDriver, String str) {
        t.e(sQLiteDriver, "driver");
        t.e(str, "fileName");
        return new ConnectionPoolImpl(sQLiteDriver, str);
    }
}
