package androidx.room;

import W2.J;
import X2.C2250q;
import android.content.Context;
import android.content.Intent;
import androidx.room.BaseRoomConnectionManager;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.coroutines.AndroidSQLiteDriverConnectionPool;
import androidx.room.coroutines.ConnectionPool;
import androidx.room.coroutines.ConnectionPoolKt;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.room.driver.SupportSQLiteConnectionPool;
import androidx.room.driver.SupportSQLiteDriver;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.driver.AndroidSQLiteDriver;
import b3.C2308e;
import b3.C2312i;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import k3.l;
import k3.p;
import kotlin.jvm.internal.t;

public final class RoomConnectionManager extends BaseRoomConnectionManager {
    private final List<RoomDatabase.Callback> callbacks;
    private final DatabaseConfiguration configuration;
    private final ConnectionPool connectionPool;
    private final RoomOpenDelegate openDelegate;
    /* access modifiers changed from: private */
    public SupportSQLiteDatabase supportDatabase;

    private static final class NoOpOpenDelegate extends RoomOpenDelegate {
        public NoOpOpenDelegate() {
            super(-1, "", "");
        }

        public void createAllTables(SQLiteConnection sQLiteConnection) {
            t.e(sQLiteConnection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        public void dropAllTables(SQLiteConnection sQLiteConnection) {
            t.e(sQLiteConnection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        public void onCreate(SQLiteConnection sQLiteConnection) {
            t.e(sQLiteConnection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        public void onOpen(SQLiteConnection sQLiteConnection) {
            t.e(sQLiteConnection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        public void onPostMigrate(SQLiteConnection sQLiteConnection) {
            t.e(sQLiteConnection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        public void onPreMigrate(SQLiteConnection sQLiteConnection) {
            t.e(sQLiteConnection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection sQLiteConnection) {
            t.e(sQLiteConnection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }
    }

    public final class SupportOpenHelperCallback extends SupportSQLiteOpenHelper.Callback {
        public SupportOpenHelperCallback(int i5) {
            super(i5);
        }

        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            RoomConnectionManager.this.onCreate(new SupportSQLiteConnection(supportSQLiteDatabase));
        }

        public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i5, int i6) {
            t.e(supportSQLiteDatabase, "db");
            onUpgrade(supportSQLiteDatabase, i5, i6);
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            RoomConnectionManager.this.onOpen(new SupportSQLiteConnection(supportSQLiteDatabase));
            RoomConnectionManager.this.supportDatabase = supportSQLiteDatabase;
        }

        public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i5, int i6) {
            t.e(supportSQLiteDatabase, "db");
            RoomConnectionManager.this.onMigrate(new SupportSQLiteConnection(supportSQLiteDatabase), i5, i6);
        }
    }

    public RoomConnectionManager(DatabaseConfiguration databaseConfiguration, RoomOpenDelegate roomOpenDelegate) {
        ConnectionPool connectionPool2;
        t.e(databaseConfiguration, "config");
        t.e(roomOpenDelegate, "openDelegate");
        this.configuration = databaseConfiguration;
        this.openDelegate = roomOpenDelegate;
        List<RoomDatabase.Callback> list = databaseConfiguration.callbacks;
        this.callbacks = list == null ? C2250q.g() : list;
        SQLiteDriver sQLiteDriver = databaseConfiguration.sqliteDriver;
        if (sQLiteDriver != null) {
            String str = ":memory:";
            if (sQLiteDriver instanceof AndroidSQLiteDriver) {
                BaseRoomConnectionManager.DriverWrapper driverWrapper = new BaseRoomConnectionManager.DriverWrapper(this, sQLiteDriver);
                String str2 = databaseConfiguration.name;
                connectionPool2 = new AndroidSQLiteDriverConnectionPool(driverWrapper, str2 != null ? str2 : str);
            } else if (databaseConfiguration.name == null) {
                connectionPool2 = ConnectionPoolKt.newSingleConnectionPool(new BaseRoomConnectionManager.DriverWrapper(this, sQLiteDriver), str);
            } else {
                connectionPool2 = ConnectionPoolKt.newConnectionPool(new BaseRoomConnectionManager.DriverWrapper(this, sQLiteDriver), databaseConfiguration.name, getMaxNumberOfReaders(databaseConfiguration.journalMode), getMaxNumberOfWriters(databaseConfiguration.journalMode));
            }
            this.connectionPool = connectionPool2;
        } else if (databaseConfiguration.sqliteOpenHelperFactory != null) {
            this.connectionPool = new SupportSQLiteConnectionPool(new SupportSQLiteDriver(databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.Companion.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new SupportOpenHelperCallback(roomOpenDelegate.getVersion())).build())));
        } else {
            throw new IllegalArgumentException("SQLiteManager was constructed with both null driver and open helper factory!");
        }
        init();
    }

    /* access modifiers changed from: private */
    public static final J _init_$lambda$1(RoomConnectionManager roomConnectionManager, SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        roomConnectionManager.supportDatabase = supportSQLiteDatabase;
        return J.f19942a;
    }

    private final void init() {
        boolean z4;
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            z4 = true;
        } else {
            z4 = false;
        }
        SupportSQLiteOpenHelper supportOpenHelper$room_runtime_release = getSupportOpenHelper$room_runtime_release();
        if (supportOpenHelper$room_runtime_release != null) {
            supportOpenHelper$room_runtime_release.setWriteAheadLoggingEnabled(z4);
        }
    }

    private final DatabaseConfiguration installOnOpenCallback(DatabaseConfiguration databaseConfiguration, l lVar) {
        DatabaseConfiguration databaseConfiguration2 = databaseConfiguration;
        List<RoomDatabase.Callback> list = databaseConfiguration2.callbacks;
        if (list == null) {
            list = C2250q.g();
        }
        return DatabaseConfiguration.copy$default(databaseConfiguration2, (Context) null, (String) null, (SupportSQLiteOpenHelper.Factory) null, (RoomDatabase.MigrationContainer) null, C2250q.c0(list, new RoomConnectionManager$installOnOpenCallback$newCallbacks$1(lVar)), false, (RoomDatabase.JournalMode) null, (Executor) null, (Executor) null, (Intent) null, false, false, (Set) null, (String) null, (File) null, (Callable) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List) null, (List) null, false, (SQLiteDriver) null, (C2312i) null, 4194287, (Object) null);
    }

    public final void close() {
        this.connectionPool.close();
    }

    /* access modifiers changed from: protected */
    public List<RoomDatabase.Callback> getCallbacks() {
        return this.callbacks;
    }

    /* access modifiers changed from: protected */
    public DatabaseConfiguration getConfiguration() {
        return this.configuration;
    }

    /* access modifiers changed from: protected */
    public RoomOpenDelegate getOpenDelegate() {
        return this.openDelegate;
    }

    public final SupportSQLiteOpenHelper getSupportOpenHelper$room_runtime_release() {
        SupportSQLiteConnectionPool supportSQLiteConnectionPool;
        SupportSQLiteDriver supportDriver$room_runtime_release;
        ConnectionPool connectionPool2 = this.connectionPool;
        if (connectionPool2 instanceof SupportSQLiteConnectionPool) {
            supportSQLiteConnectionPool = (SupportSQLiteConnectionPool) connectionPool2;
        } else {
            supportSQLiteConnectionPool = null;
        }
        if (supportSQLiteConnectionPool == null || (supportDriver$room_runtime_release = supportSQLiteConnectionPool.getSupportDriver$room_runtime_release()) == null) {
            return null;
        }
        return supportDriver$room_runtime_release.getOpenHelper();
    }

    public final boolean isSupportDatabaseOpen() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.supportDatabase;
        if (supportSQLiteDatabase != null) {
            return supportSQLiteDatabase.isOpen();
        }
        return false;
    }

    public String resolveFileName$room_runtime_release(String str) {
        t.e(str, "fileName");
        if (t.a(str, ":memory:")) {
            return str;
        }
        String absolutePath = getConfiguration().context.getDatabasePath(str).getAbsolutePath();
        t.b(absolutePath);
        return absolutePath;
    }

    public <R> Object useConnection(boolean z4, p pVar, C2308e eVar) {
        return this.connectionPool.useConnection(z4, pVar, eVar);
    }

    public RoomConnectionManager(DatabaseConfiguration databaseConfiguration, l lVar) {
        t.e(databaseConfiguration, "config");
        t.e(lVar, "supportOpenHelperFactory");
        this.configuration = databaseConfiguration;
        this.openDelegate = new NoOpOpenDelegate();
        List<RoomDatabase.Callback> list = databaseConfiguration.callbacks;
        this.callbacks = list == null ? C2250q.g() : list;
        this.connectionPool = new SupportSQLiteConnectionPool(new SupportSQLiteDriver((SupportSQLiteOpenHelper) lVar.invoke(installOnOpenCallback(databaseConfiguration, new i(this)))));
        init();
    }
}
