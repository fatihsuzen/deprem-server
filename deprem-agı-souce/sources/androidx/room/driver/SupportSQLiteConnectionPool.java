package androidx.room.driver;

import androidx.room.coroutines.ConnectionPool;
import b3.C2308e;
import k3.p;
import kotlin.jvm.internal.t;

public final class SupportSQLiteConnectionPool implements ConnectionPool {
    private final SupportSQLiteDriver supportDriver;

    public SupportSQLiteConnectionPool(SupportSQLiteDriver supportSQLiteDriver) {
        t.e(supportSQLiteDriver, "supportDriver");
        this.supportDriver = supportSQLiteDriver;
    }

    private final SupportSQLitePooledConnection getSupportConnection() {
        String databaseName = this.supportDriver.getOpenHelper().getDatabaseName();
        if (databaseName == null) {
            databaseName = ":memory:";
        }
        return new SupportSQLitePooledConnection(this.supportDriver.open(databaseName));
    }

    public void close() {
        this.supportDriver.getOpenHelper().close();
    }

    public final SupportSQLiteDriver getSupportDriver$room_runtime_release() {
        return this.supportDriver;
    }

    public <R> Object useConnection(boolean z4, p pVar, C2308e eVar) {
        return pVar.invoke(getSupportConnection(), eVar);
    }
}
