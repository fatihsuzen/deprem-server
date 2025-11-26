package androidx.room.coroutines;

import W2.C2223l;
import W2.m;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.driver.AndroidSQLiteConnection;
import b3.C2308e;
import k3.p;
import kotlin.jvm.internal.t;

public final class AndroidSQLiteDriverConnectionPool implements ConnectionPool {
    private final C2223l androidConnection$delegate = m.b(new a(this));
    private final SQLiteDriver driver;
    private final String fileName;

    public AndroidSQLiteDriverConnectionPool(SQLiteDriver sQLiteDriver, String str) {
        t.e(sQLiteDriver, "driver");
        t.e(str, "fileName");
        this.driver = sQLiteDriver;
        this.fileName = str;
    }

    /* access modifiers changed from: private */
    public static final AndroidSQLiteDriverPooledConnection androidConnection_delegate$lambda$0(AndroidSQLiteDriverConnectionPool androidSQLiteDriverConnectionPool) {
        SQLiteConnection open = androidSQLiteDriverConnectionPool.driver.open(androidSQLiteDriverConnectionPool.fileName);
        t.c(open, "null cannot be cast to non-null type androidx.sqlite.driver.AndroidSQLiteConnection");
        return new AndroidSQLiteDriverPooledConnection((AndroidSQLiteConnection) open);
    }

    private final AndroidSQLiteDriverPooledConnection getAndroidConnection() {
        return (AndroidSQLiteDriverPooledConnection) this.androidConnection$delegate.getValue();
    }

    public void close() {
        getAndroidConnection().getDelegate().close();
    }

    public <R> Object useConnection(boolean z4, p pVar, C2308e eVar) {
        return pVar.invoke(getAndroidConnection(), eVar);
    }
}
