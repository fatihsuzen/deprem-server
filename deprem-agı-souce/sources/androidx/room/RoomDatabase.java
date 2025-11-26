package androidx.room;

import W2.J;
import W2.r;
import W2.s;
import W2.y;
import X2.C2250q;
import X2.T;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.concurrent.CloseBarrier;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.support.AutoCloser;
import androidx.room.support.AutoClosingRoomOpenHelperFactory;
import androidx.room.support.PrePackagedCopyOpenHelperFactory;
import androidx.room.support.QueryInterceptorOpenHelperFactory;
import androidx.room.util.KClassUtil;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import b.w;
import b3.C2308e;
import b3.C2309f;
import b3.C2312i;
import com.mbridge.msdk.MBridgeConstans;
import d3.C2344a;
import d3.C2345b;
import j3.C2582a;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import k3.C2616a;
import k3.l;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;
import r3.C2733c;
import w3.C2894r0;
import w3.M;
import w3.N;

public abstract class RoomDatabase {
    public static final Companion Companion = new Companion((C2633k) null);
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;
    private AutoCloser autoCloser;
    private final CloseBarrier closeBarrier = new CloseBarrier(new RoomDatabase$closeBarrier$1(this));
    /* access modifiers changed from: private */
    public RoomConnectionManager connectionManager;
    private M coroutineScope;
    private Executor internalQueryExecutor;
    private InvalidationTracker internalTracker;
    private Executor internalTransactionExecutor;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected List<? extends Callback> mCallbacks;
    protected volatile SupportSQLiteDatabase mDatabase;
    private final ThreadLocal<Integer> suspendingTransactionId = new ThreadLocal<>();
    private C2312i transactionContext;
    private final Map<C2733c, Object> typeConverters = new LinkedHashMap();
    private boolean useTempTrackingTable = true;

    public static class Builder<T extends RoomDatabase> {
        private boolean allowDestructiveMigrationForAllTables;
        private boolean allowDestructiveMigrationOnDowngrade;
        private boolean allowMainThreadQueries;
        private TimeUnit autoCloseTimeUnit;
        private long autoCloseTimeout = -1;
        private final List<AutoMigrationSpec> autoMigrationSpecs = new ArrayList();
        private final List<Callback> callbacks = new ArrayList();
        private final Context context;
        private String copyFromAssetPath;
        private File copyFromFile;
        private Callable<InputStream> copyFromInputStream;
        private SQLiteDriver driver;
        private final C2616a factory;
        private boolean inMemoryTrackingTableMode = true;
        private JournalMode journalMode = JournalMode.AUTOMATIC;
        private final C2733c klass;
        private final MigrationContainer migrationContainer = new MigrationContainer();
        private final Set<Integer> migrationStartAndEndVersions = new LinkedHashSet();
        private Set<Integer> migrationsNotRequiredFrom = new LinkedHashSet();
        private Intent multiInstanceInvalidationIntent;
        private final String name;
        private PrepackagedDatabaseCallback prepackagedDatabaseCallback;
        private QueryCallback queryCallback;
        private C2312i queryCallbackCoroutineContext;
        private Executor queryCallbackExecutor;
        private C2312i queryCoroutineContext;
        private Executor queryExecutor;
        private boolean requireMigration = true;
        private SupportSQLiteOpenHelper.Factory supportOpenHelperFactory;
        private Executor transactionExecutor;
        private final List<Object> typeConverters = new ArrayList();

        public Builder(C2733c cVar, String str, C2616a aVar, Context context2) {
            t.e(cVar, "klass");
            t.e(context2, "context");
            this.klass = cVar;
            this.context = context2;
            this.name = str;
            this.factory = aVar;
        }

        public Builder<T> addAutoMigrationSpec(AutoMigrationSpec autoMigrationSpec) {
            t.e(autoMigrationSpec, "autoMigrationSpec");
            this.autoMigrationSpecs.add(autoMigrationSpec);
            return this;
        }

        public Builder<T> addCallback(Callback callback) {
            t.e(callback, "callback");
            this.callbacks.add(callback);
            return this;
        }

        public Builder<T> addMigrations(Migration... migrationArr) {
            t.e(migrationArr, "migrations");
            for (Migration migration : migrationArr) {
                this.migrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                this.migrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
            }
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(migrationArr, migrationArr.length));
            return this;
        }

        public Builder<T> addTypeConverter(Object obj) {
            t.e(obj, "typeConverter");
            this.typeConverters.add(obj);
            return this;
        }

        public Builder<T> allowMainThreadQueries() {
            this.allowMainThreadQueries = true;
            return this;
        }

        public T build() {
            AutoClosingRoomOpenHelperFactory autoClosingRoomOpenHelperFactory;
            boolean z4;
            boolean z5;
            boolean z6;
            SupportSQLiteOpenHelper.Factory factory2;
            T t5;
            C2312i iVar;
            int i5;
            int i6;
            Executor executor = this.queryExecutor;
            if (executor == null && this.transactionExecutor == null) {
                Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
                this.transactionExecutor = iOThreadExecutor;
                this.queryExecutor = iOThreadExecutor;
            } else if (executor != null && this.transactionExecutor == null) {
                this.transactionExecutor = executor;
            } else if (executor == null) {
                this.queryExecutor = this.transactionExecutor;
            }
            RoomDatabaseKt.validateMigrationsNotRequired(this.migrationStartAndEndVersions, this.migrationsNotRequiredFrom);
            SQLiteDriver sQLiteDriver = this.driver;
            if (sQLiteDriver == null && this.supportOpenHelperFactory == null) {
                autoClosingRoomOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            } else if (sQLiteDriver == null) {
                autoClosingRoomOpenHelperFactory = this.supportOpenHelperFactory;
            } else if (this.supportOpenHelperFactory == null) {
                autoClosingRoomOpenHelperFactory = null;
            } else {
                throw new IllegalArgumentException("A RoomDatabase cannot be configured with both a SQLiteDriver and a SupportOpenHelper.Factory.");
            }
            int i7 = 0;
            if (this.autoCloseTimeout > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (this.copyFromAssetPath == null && this.copyFromFile == null && this.copyFromInputStream == null) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (this.queryCallback != null) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (autoClosingRoomOpenHelperFactory != null) {
                if (z4) {
                    if (this.name != null) {
                        long j5 = this.autoCloseTimeout;
                        TimeUnit timeUnit = this.autoCloseTimeUnit;
                        if (timeUnit != null) {
                            autoClosingRoomOpenHelperFactory = new AutoClosingRoomOpenHelperFactory(autoClosingRoomOpenHelperFactory, new AutoCloser(j5, timeUnit, (AutoCloser.Watch) null, 4, (C2633k) null));
                        } else {
                            throw new IllegalArgumentException("Required value was null.");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                }
                if (z5) {
                    if (this.name != null) {
                        String str = this.copyFromAssetPath;
                        if (str == null) {
                            i5 = 0;
                        } else {
                            i5 = 1;
                        }
                        File file = this.copyFromFile;
                        if (file == null) {
                            i6 = 0;
                        } else {
                            i6 = 1;
                        }
                        Callable<InputStream> callable = this.copyFromInputStream;
                        if (callable != null) {
                            i7 = 1;
                        }
                        if (i5 + i6 + i7 == 1) {
                            autoClosingRoomOpenHelperFactory = new PrePackagedCopyOpenHelperFactory(str, file, callable, autoClosingRoomOpenHelperFactory);
                        } else {
                            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                }
                if (z6) {
                    Executor executor2 = this.queryCallbackExecutor;
                    if ((executor2 == null || (iVar = C2894r0.b(executor2)) == null) && (iVar = this.queryCallbackCoroutineContext) == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    M a5 = N.a(iVar);
                    QueryCallback queryCallback2 = this.queryCallback;
                    if (queryCallback2 != null) {
                        autoClosingRoomOpenHelperFactory = new QueryInterceptorOpenHelperFactory(autoClosingRoomOpenHelperFactory, a5, queryCallback2);
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                }
                factory2 = autoClosingRoomOpenHelperFactory;
            } else {
                factory2 = null;
            }
            if (factory2 == null) {
                if (z4) {
                    throw new IllegalArgumentException("Auto Closing Database is not supported when an SQLiteDriver is configured.");
                } else if (z5) {
                    throw new IllegalArgumentException("Pre-Package Database is not supported when an SQLiteDriver is configured.");
                } else if (z6) {
                    throw new IllegalArgumentException("Query Callback is not supported when an SQLiteDriver is configured.");
                }
            }
            Context context2 = this.context;
            String str2 = this.name;
            MigrationContainer migrationContainer2 = this.migrationContainer;
            List<Callback> list = this.callbacks;
            boolean z7 = this.allowMainThreadQueries;
            JournalMode resolve$room_runtime_release = this.journalMode.resolve$room_runtime_release(context2);
            Executor executor3 = this.queryExecutor;
            if (executor3 != null) {
                Executor executor4 = this.transactionExecutor;
                if (executor4 != null) {
                    Intent intent = this.multiInstanceInvalidationIntent;
                    boolean z8 = this.requireMigration;
                    boolean z9 = this.allowDestructiveMigrationOnDowngrade;
                    Set<Integer> set = this.migrationsNotRequiredFrom;
                    DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context2, str2, factory2, migrationContainer2, list, z7, resolve$room_runtime_release, executor3, executor4, intent, z8, z9, set, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, this.prepackagedDatabaseCallback, this.typeConverters, this.autoMigrationSpecs, this.allowDestructiveMigrationForAllTables, this.driver, this.queryCoroutineContext);
                    databaseConfiguration.setUseTempTrackingTable$room_runtime_release(this.inMemoryTrackingTableMode);
                    C2616a aVar = this.factory;
                    if (aVar == null || (t5 = (RoomDatabase) aVar.invoke()) == null) {
                        t5 = (RoomDatabase) KClassUtil.findAndInstantiateDatabaseImpl$default(C2582a.a(this.klass), (String) null, 2, (Object) null);
                    }
                    t5.init(databaseConfiguration);
                    return t5;
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalArgumentException("Required value was null.");
        }

        public Builder<T> createFromAsset(String str) {
            t.e(str, "databaseFilePath");
            this.copyFromAssetPath = str;
            return this;
        }

        public Builder<T> createFromFile(File file) {
            t.e(file, "databaseFile");
            this.copyFromFile = file;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromInputStream(Callable<InputStream> callable) {
            t.e(callable, "inputStreamCallable");
            this.copyFromInputStream = callable;
            return this;
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            Intent intent;
            if (this.name != null) {
                intent = new Intent(this.context, MultiInstanceInvalidationService.class);
            } else {
                intent = null;
            }
            this.multiInstanceInvalidationIntent = intent;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigration() {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(int... iArr) {
            t.e(iArr, "startVersions");
            for (int valueOf : iArr) {
                this.migrationsNotRequiredFrom.add(Integer.valueOf(valueOf));
            }
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory factory2) {
            this.supportOpenHelperFactory = factory2;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setAutoCloseTimeout(@IntRange(from = 0) long j5, TimeUnit timeUnit) {
            t.e(timeUnit, "autoCloseTimeUnit");
            if (j5 >= 0) {
                this.autoCloseTimeout = j5;
                this.autoCloseTimeUnit = timeUnit;
                return this;
            }
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
        }

        public final Builder<T> setDriver(SQLiteDriver sQLiteDriver) {
            t.e(sQLiteDriver, "driver");
            this.driver = sQLiteDriver;
            return this;
        }

        @ExperimentalRoomApi
        public final Builder<T> setInMemoryTrackingMode(boolean z4) {
            this.inMemoryTrackingTableMode = z4;
            return this;
        }

        public Builder<T> setJournalMode(JournalMode journalMode2) {
            t.e(journalMode2, "journalMode");
            this.journalMode = journalMode2;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setMultiInstanceInvalidationServiceIntent(Intent intent) {
            t.e(intent, "invalidationServiceIntent");
            if (this.name == null) {
                intent = null;
            }
            this.multiInstanceInvalidationIntent = intent;
            return this;
        }

        public Builder<T> setQueryCallback(QueryCallback queryCallback2, Executor executor) {
            t.e(queryCallback2, "queryCallback");
            t.e(executor, "executor");
            this.queryCallback = queryCallback2;
            this.queryCallbackExecutor = executor;
            this.queryCallbackCoroutineContext = null;
            return this;
        }

        public final Builder<T> setQueryCoroutineContext(C2312i iVar) {
            t.e(iVar, "context");
            if (this.queryExecutor != null || this.transactionExecutor != null) {
                throw new IllegalArgumentException("This builder has already been configured with an Executor. A RoomDatabase canonly be configured with either an Executor or a CoroutineContext.");
            } else if (iVar.get(C2309f.f20792a0) != null) {
                this.queryCoroutineContext = iVar;
                return this;
            } else {
                throw new IllegalArgumentException("It is required that the coroutine context contain a dispatcher.");
            }
        }

        public Builder<T> setQueryExecutor(Executor executor) {
            t.e(executor, "executor");
            if (this.queryCoroutineContext == null) {
                this.queryExecutor = executor;
                return this;
            }
            throw new IllegalArgumentException("This builder has already been configured with a CoroutineContext. A RoomDatabasecan only be configured with either an Executor or a CoroutineContext.");
        }

        public Builder<T> setTransactionExecutor(Executor executor) {
            t.e(executor, "executor");
            if (this.queryCoroutineContext == null) {
                this.transactionExecutor = executor;
                return this;
            }
            throw new IllegalArgumentException("This builder has already been configured with a CoroutineContext. A RoomDatabasecan only be configured with either an Executor or a CoroutineContext.");
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromAsset(String str, PrepackagedDatabaseCallback prepackagedDatabaseCallback2) {
            t.e(str, "databaseFilePath");
            t.e(prepackagedDatabaseCallback2, "callback");
            this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
            this.copyFromAssetPath = str;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "StreamFiles"})
        public Builder<T> createFromFile(File file, PrepackagedDatabaseCallback prepackagedDatabaseCallback2) {
            t.e(file, "databaseFile");
            t.e(prepackagedDatabaseCallback2, "callback");
            this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
            this.copyFromFile = file;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "LambdaLast"})
        public Builder<T> createFromInputStream(Callable<InputStream> callable, PrepackagedDatabaseCallback prepackagedDatabaseCallback2) {
            t.e(callable, "inputStreamCallable");
            t.e(prepackagedDatabaseCallback2, "callback");
            this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
            this.copyFromInputStream = callable;
            return this;
        }

        public final Builder<T> fallbackToDestructiveMigration(boolean z4) {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            this.allowDestructiveMigrationForAllTables = z4;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(boolean z4, int... iArr) {
            t.e(iArr, "startVersions");
            for (int valueOf : iArr) {
                this.migrationsNotRequiredFrom.add(Integer.valueOf(valueOf));
            }
            this.allowDestructiveMigrationForAllTables = z4;
            return this;
        }

        public final Builder<T> fallbackToDestructiveMigrationOnDowngrade(boolean z4) {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            this.allowDestructiveMigrationForAllTables = z4;
            return this;
        }

        public final Builder<T> setQueryCallback(C2312i iVar, QueryCallback queryCallback2) {
            t.e(iVar, "context");
            t.e(queryCallback2, "queryCallback");
            this.queryCallback = queryCallback2;
            this.queryCallbackExecutor = null;
            this.queryCallbackCoroutineContext = iVar;
            return this;
        }

        public Builder(Context context2, Class<T> cls, String str) {
            t.e(context2, "context");
            t.e(cls, "klass");
            this.klass = C2582a.c(cls);
            this.context = context2;
            this.name = str;
            this.factory = null;
        }
    }

    public static abstract class Callback {
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
        }

        public void onDestructiveMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
        }

        public void onCreate(SQLiteConnection sQLiteConnection) {
            t.e(sQLiteConnection, "connection");
            if (sQLiteConnection instanceof SupportSQLiteConnection) {
                onCreate(((SupportSQLiteConnection) sQLiteConnection).getDb());
            }
        }

        public void onDestructiveMigration(SQLiteConnection sQLiteConnection) {
            t.e(sQLiteConnection, "connection");
            if (sQLiteConnection instanceof SupportSQLiteConnection) {
                onDestructiveMigration(((SupportSQLiteConnection) sQLiteConnection).getDb());
            }
        }

        public void onOpen(SQLiteConnection sQLiteConnection) {
            t.e(sQLiteConnection, "connection");
            if (sQLiteConnection instanceof SupportSQLiteConnection) {
                onOpen(((SupportSQLiteConnection) sQLiteConnection).getDb());
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        static {
            JournalMode[] $values;
            $ENTRIES = C2345b.a($values);
        }

        public static C2344a getEntries() {
            return $ENTRIES;
        }

        public final JournalMode resolve$room_runtime_release(Context context) {
            ActivityManager activityManager;
            t.e(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            if (systemService instanceof ActivityManager) {
                activityManager = (ActivityManager) systemService;
            } else {
                activityManager = null;
            }
            if (activityManager == null || activityManager.isLowRamDevice()) {
                return TRUNCATE;
            }
            return WRITE_AHEAD_LOGGING;
        }
    }

    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
        }
    }

    public interface QueryCallback {
        void onQuery(String str, List<? extends Object> list);
    }

    /* access modifiers changed from: private */
    public static final J beginTransaction$lambda$8(RoomDatabase roomDatabase, SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "it");
        roomDatabase.internalBeginTransaction();
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final SupportSQLiteOpenHelper createConnectionManager$lambda$1(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        t.e(databaseConfiguration, "config");
        return roomDatabase.createOpenHelper(databaseConfiguration);
    }

    /* access modifiers changed from: private */
    public static final J endTransaction$lambda$9(RoomDatabase roomDatabase, SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "it");
        roomDatabase.internalEndTransaction();
        return J.f19942a;
    }

    protected static /* synthetic */ void getMCallbacks$annotations() {
    }

    protected static /* synthetic */ void getMDatabase$annotations() {
    }

    private final void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        if (!writableDatabase.inTransaction()) {
            getInvalidationTracker().syncBlocking$room_runtime_release();
        }
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    private final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (!inTransaction()) {
            getInvalidationTracker().refreshVersionsAsync();
        }
    }

    /* access modifiers changed from: private */
    public final void onClosed() {
        M m5 = this.coroutineScope;
        RoomConnectionManager roomConnectionManager = null;
        if (m5 == null) {
            t.w("coroutineScope");
            m5 = null;
        }
        N.c(m5, (CancellationException) null, 1, (Object) null);
        getInvalidationTracker().stop$room_runtime_release();
        RoomConnectionManager roomConnectionManager2 = this.connectionManager;
        if (roomConnectionManager2 == null) {
            t.w("connectionManager");
        } else {
            roomConnectionManager = roomConnectionManager2;
        }
        roomConnectionManager.close();
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                cancellationSignal = null;
            }
            return roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    private final /* synthetic */ <T extends SupportSQLiteOpenHelper> T unwrapOpenHelper(T t5) {
        if (t5 == null) {
            return null;
        }
        while (true) {
            t.k(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (w.a(t5)) {
                return t5;
            }
            if (!(t5 instanceof DelegatingOpenHelper)) {
                return null;
            }
            t5 = ((DelegatingOpenHelper) t5).getDelegate();
        }
    }

    public final void addTypeConverter$room_runtime_release(C2733c cVar, Object obj) {
        t.e(cVar, "kclass");
        t.e(obj, "converter");
        this.typeConverters.put(cVar, obj);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (!this.allowMainThreadQueries && isMainThread$room_runtime_release()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotSuspendingTransaction() {
        if (inCompatibilityMode$room_runtime_release() && !inTransaction() && this.suspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 == null) {
            internalBeginTransaction();
        } else {
            autoCloser2.executeRefCountingFunction(new l(this));
        }
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        this.closeBarrier.close$room_runtime_release();
    }

    public SupportSQLiteStatement compileStatement(String str) {
        t.e(str, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public List<Migration> createAutoMigrations(Map<C2733c, ? extends AutoMigrationSpec> map) {
        t.e(map, "autoMigrationSpecs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X2.M.e(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(C2582a.a((C2733c) entry.getKey()), entry.getValue());
        }
        return getAutoMigrations(linkedHashMap);
    }

    public final RoomConnectionManager createConnectionManager$room_runtime_release(DatabaseConfiguration databaseConfiguration) {
        RoomOpenDelegate roomOpenDelegate;
        t.e(databaseConfiguration, "configuration");
        try {
            RoomOpenDelegateMarker createOpenDelegate = createOpenDelegate();
            t.c(createOpenDelegate, "null cannot be cast to non-null type androidx.room.RoomOpenDelegate");
            roomOpenDelegate = (RoomOpenDelegate) createOpenDelegate;
        } catch (r unused) {
            roomOpenDelegate = null;
        }
        if (roomOpenDelegate == null) {
            return new RoomConnectionManager(databaseConfiguration, (l) new k(this));
        }
        return new RoomConnectionManager(databaseConfiguration, roomOpenDelegate);
    }

    /* access modifiers changed from: protected */
    public abstract InvalidationTracker createInvalidationTracker();

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RoomOpenDelegateMarker createOpenDelegate() {
        throw new r((String) null, 1, (C2633k) null);
    }

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        t.e(databaseConfiguration, "config");
        throw new r((String) null, 1, (C2633k) null);
    }

    public void endTransaction() {
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 == null) {
            internalEndTransaction();
        } else {
            autoCloser2.executeRefCountingFunction(new j(this));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        t.e(map, "autoMigrationSpecs");
        return C2250q.g();
    }

    public final CloseBarrier getCloseBarrier$room_runtime_release() {
        return this.closeBarrier;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final M getCoroutineScope() {
        M m5 = this.coroutineScope;
        if (m5 != null) {
            return m5;
        }
        t.w("coroutineScope");
        return null;
    }

    public InvalidationTracker getInvalidationTracker() {
        InvalidationTracker invalidationTracker = this.internalTracker;
        if (invalidationTracker != null) {
            return invalidationTracker;
        }
        t.w("internalTracker");
        return null;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            t.w("connectionManager");
            roomConnectionManager = null;
        }
        SupportSQLiteOpenHelper supportOpenHelper$room_runtime_release = roomConnectionManager.getSupportOpenHelper$room_runtime_release();
        if (supportOpenHelper$room_runtime_release != null) {
            return supportOpenHelper$room_runtime_release;
        }
        throw new IllegalStateException("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final C2312i getQueryContext() {
        M m5 = this.coroutineScope;
        if (m5 == null) {
            t.w("coroutineScope");
            m5 = null;
        }
        return m5.getCoroutineContext();
    }

    public Executor getQueryExecutor() {
        Executor executor = this.internalQueryExecutor;
        if (executor != null) {
            return executor;
        }
        t.w("internalQueryExecutor");
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Set<C2733c> getRequiredAutoMigrationSpecClasses() {
        Set<Class<? extends AutoMigrationSpec>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        ArrayList arrayList = new ArrayList(C2250q.p(requiredAutoMigrationSpecs, 10));
        for (Class c5 : requiredAutoMigrationSpecs) {
            arrayList.add(C2582a.c(c5));
        }
        return C2250q.r0(arrayList);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return T.d();
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Map<C2733c, List<C2733c>> getRequiredTypeConverterClasses() {
        Set<Map.Entry<Class<?>, List<Class<?>>>> entrySet = getRequiredTypeConverters().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(C2729e.c(X2.M.e(C2250q.p(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            C2733c c5 = C2582a.c((Class) entry.getKey());
            Iterable<Class> iterable = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(C2250q.p(iterable, 10));
            for (Class c6 : iterable) {
                arrayList.add(C2582a.c(c6));
            }
            s a5 = y.a(c5, arrayList);
            linkedHashMap.put(a5.c(), a5.d());
        }
        return linkedHashMap;
    }

    public final Map<C2733c, List<C2733c>> getRequiredTypeConverterClassesMap$room_runtime_release() {
        return getRequiredTypeConverterClasses();
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return X2.M.h();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    public final C2312i getTransactionContext$room_runtime_release() {
        C2312i iVar = this.transactionContext;
        if (iVar != null) {
            return iVar;
        }
        t.w("transactionContext");
        return null;
    }

    public Executor getTransactionExecutor() {
        Executor executor = this.internalTransactionExecutor;
        if (executor != null) {
            return executor;
        }
        t.w("internalTransactionExecutor");
        return null;
    }

    public <T> T getTypeConverter(Class<T> cls) {
        t.e(cls, "klass");
        return this.typeConverters.get(C2582a.c(cls));
    }

    public final boolean getUseTempTrackingTable$room_runtime_release() {
        return this.useTempTrackingTable;
    }

    public final boolean inCompatibilityMode$room_runtime_release() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            t.w("connectionManager");
            roomConnectionManager = null;
        }
        if (roomConnectionManager.getSupportOpenHelper$room_runtime_release() != null) {
            return true;
        }
        return false;
    }

    public boolean inTransaction() {
        if (!isOpenInternal() || !getOpenHelper().getWritableDatabase().inTransaction()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0160 A[RETURN] */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(androidx.room.DatabaseConfiguration r8) {
        /*
            r7 = this;
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.t.e(r8, r0)
            boolean r0 = r8.getUseTempTrackingTable$room_runtime_release()
            r7.useTempTrackingTable = r0
            androidx.room.RoomConnectionManager r0 = r7.createConnectionManager$room_runtime_release(r8)
            r7.connectionManager = r0
            androidx.room.InvalidationTracker r0 = r7.createInvalidationTracker()
            r7.internalTracker = r0
            androidx.room.RoomDatabaseKt.validateAutoMigrations(r7, r8)
            androidx.room.RoomDatabaseKt.validateTypeConverters(r7, r8)
            b3.i r0 = r8.queryCoroutineContext
            r1 = 1
            java.lang.String r2 = "internalQueryExecutor"
            java.lang.String r3 = "coroutineScope"
            r4 = 0
            if (r0 == 0) goto L_0x008b
            b3.f$b r5 = b3.C2309f.f20792a0
            b3.i$b r0 = r0.get(r5)
            java.lang.String r5 = "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher"
            kotlin.jvm.internal.t.c(r0, r5)
            w3.I r0 = (w3.I) r0
            java.util.concurrent.Executor r5 = w3.C2894r0.a(r0)
            r7.internalQueryExecutor = r5
            androidx.room.TransactionExecutor r6 = new androidx.room.TransactionExecutor
            if (r5 != 0) goto L_0x0042
            kotlin.jvm.internal.t.w(r2)
            r5 = r4
        L_0x0042:
            r6.<init>(r5)
            r7.internalTransactionExecutor = r6
            b3.i r2 = r8.queryCoroutineContext
            w3.y0$b r5 = w3.C2908y0.f26320k0
            b3.i$b r2 = r2.get(r5)
            w3.y0 r2 = (w3.C2908y0) r2
            b3.i r5 = r8.queryCoroutineContext
            w3.y r2 = w3.T0.a(r2)
            b3.i r2 = r5.plus(r2)
            w3.M r2 = w3.N.a(r2)
            r7.coroutineScope = r2
            boolean r2 = r7.inCompatibilityMode$room_runtime_release()
            if (r2 == 0) goto L_0x007c
            w3.M r2 = r7.coroutineScope
            if (r2 != 0) goto L_0x006f
            kotlin.jvm.internal.t.w(r3)
            r2 = r4
        L_0x006f:
            b3.i r2 = r2.getCoroutineContext()
            w3.I r0 = r0.limitedParallelism(r1)
            b3.i r0 = r2.plus(r0)
            goto L_0x0088
        L_0x007c:
            w3.M r0 = r7.coroutineScope
            if (r0 != 0) goto L_0x0084
            kotlin.jvm.internal.t.w(r3)
            r0 = r4
        L_0x0084:
            b3.i r0 = r0.getCoroutineContext()
        L_0x0088:
            r7.transactionContext = r0
            goto L_0x00d0
        L_0x008b:
            java.util.concurrent.Executor r0 = r8.queryExecutor
            r7.internalQueryExecutor = r0
            androidx.room.TransactionExecutor r0 = new androidx.room.TransactionExecutor
            java.util.concurrent.Executor r5 = r8.transactionExecutor
            r0.<init>(r5)
            r7.internalTransactionExecutor = r0
            java.util.concurrent.Executor r0 = r7.internalQueryExecutor
            if (r0 != 0) goto L_0x00a0
            kotlin.jvm.internal.t.w(r2)
            r0 = r4
        L_0x00a0:
            w3.I r0 = w3.C2894r0.b(r0)
            w3.y r1 = w3.T0.b(r4, r1, r4)
            b3.i r0 = r0.plus(r1)
            w3.M r0 = w3.N.a(r0)
            r7.coroutineScope = r0
            if (r0 != 0) goto L_0x00b8
            kotlin.jvm.internal.t.w(r3)
            r0 = r4
        L_0x00b8:
            b3.i r0 = r0.getCoroutineContext()
            java.util.concurrent.Executor r1 = r7.internalTransactionExecutor
            if (r1 != 0) goto L_0x00c6
            java.lang.String r1 = "internalTransactionExecutor"
            kotlin.jvm.internal.t.w(r1)
            r1 = r4
        L_0x00c6:
            w3.I r1 = w3.C2894r0.b(r1)
            b3.i r0 = r0.plus(r1)
            r7.transactionContext = r0
        L_0x00d0:
            boolean r0 = r8.allowMainThreadQueries
            r7.allowMainThreadQueries = r0
            androidx.room.RoomConnectionManager r0 = r7.connectionManager
            java.lang.String r1 = "connectionManager"
            if (r0 != 0) goto L_0x00de
            kotlin.jvm.internal.t.w(r1)
            r0 = r4
        L_0x00de:
            androidx.sqlite.db.SupportSQLiteOpenHelper r0 = r0.getSupportOpenHelper$room_runtime_release()
            if (r0 != 0) goto L_0x00e6
        L_0x00e4:
            r0 = r4
            goto L_0x00f6
        L_0x00e6:
            boolean r2 = r0 instanceof androidx.room.support.PrePackagedCopyOpenHelper
            if (r2 == 0) goto L_0x00eb
            goto L_0x00f6
        L_0x00eb:
            boolean r2 = r0 instanceof androidx.room.DelegatingOpenHelper
            if (r2 == 0) goto L_0x00e4
            androidx.room.DelegatingOpenHelper r0 = (androidx.room.DelegatingOpenHelper) r0
            androidx.sqlite.db.SupportSQLiteOpenHelper r0 = r0.getDelegate()
            goto L_0x00e6
        L_0x00f6:
            androidx.room.support.PrePackagedCopyOpenHelper r0 = (androidx.room.support.PrePackagedCopyOpenHelper) r0
            if (r0 == 0) goto L_0x00fd
            r0.setDatabaseConfiguration(r8)
        L_0x00fd:
            androidx.room.RoomConnectionManager r0 = r7.connectionManager
            if (r0 != 0) goto L_0x0105
            kotlin.jvm.internal.t.w(r1)
            r0 = r4
        L_0x0105:
            androidx.sqlite.db.SupportSQLiteOpenHelper r0 = r0.getSupportOpenHelper$room_runtime_release()
            if (r0 != 0) goto L_0x010d
        L_0x010b:
            r0 = r4
            goto L_0x011d
        L_0x010d:
            boolean r1 = r0 instanceof androidx.room.support.AutoClosingRoomOpenHelper
            if (r1 == 0) goto L_0x0112
            goto L_0x011d
        L_0x0112:
            boolean r1 = r0 instanceof androidx.room.DelegatingOpenHelper
            if (r1 == 0) goto L_0x010b
            androidx.room.DelegatingOpenHelper r0 = (androidx.room.DelegatingOpenHelper) r0
            androidx.sqlite.db.SupportSQLiteOpenHelper r0 = r0.getDelegate()
            goto L_0x010d
        L_0x011d:
            androidx.room.support.AutoClosingRoomOpenHelper r0 = (androidx.room.support.AutoClosingRoomOpenHelper) r0
            if (r0 == 0) goto L_0x0142
            androidx.room.support.AutoCloser r1 = r0.getAutoCloser$room_runtime_release()
            r7.autoCloser = r1
            androidx.room.support.AutoCloser r1 = r0.getAutoCloser$room_runtime_release()
            w3.M r2 = r7.coroutineScope
            if (r2 != 0) goto L_0x0133
            kotlin.jvm.internal.t.w(r3)
            goto L_0x0134
        L_0x0133:
            r4 = r2
        L_0x0134:
            r1.initCoroutineScope(r4)
            androidx.room.InvalidationTracker r1 = r7.getInvalidationTracker()
            androidx.room.support.AutoCloser r0 = r0.getAutoCloser$room_runtime_release()
            r1.setAutoCloser$room_runtime_release(r0)
        L_0x0142:
            android.content.Intent r0 = r8.multiInstanceInvalidationServiceIntent
            if (r0 == 0) goto L_0x0160
            java.lang.String r0 = r8.name
            if (r0 == 0) goto L_0x0158
            androidx.room.InvalidationTracker r0 = r7.getInvalidationTracker()
            android.content.Context r1 = r8.context
            java.lang.String r2 = r8.name
            android.content.Intent r8 = r8.multiInstanceInvalidationServiceIntent
            r0.initMultiInstanceInvalidation$room_runtime_release(r1, r2, r8)
            return
        L_0x0158:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Required value was null."
            r8.<init>(r0)
            throw r8
        L_0x0160:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.init(androidx.room.DatabaseConfiguration):void");
    }

    /* access modifiers changed from: protected */
    public void internalInitInvalidationTracker(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        internalInitInvalidationTracker((SQLiteConnection) new SupportSQLiteConnection(supportSQLiteDatabase));
    }

    public final boolean isMainThread$room_runtime_release() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 != null) {
            return autoCloser2.isActive();
        }
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            t.w("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.isSupportDatabaseOpen();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isOpenInternal() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            t.w("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.isSupportDatabaseOpen();
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void performClear(boolean z4, String... strArr) {
        t.e(strArr, "tableNames");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new RoomDatabase$performClear$1(this, z4, strArr, (C2308e) null));
    }

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        t.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        return query$default(this, supportSQLiteQuery, (CancellationSignal) null, 2, (Object) null);
    }

    public void runInTransaction(Runnable runnable) {
        t.e(runnable, TtmlNode.TAG_BODY);
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    public final void setUseTempTrackingTable$room_runtime_release(boolean z4) {
        this.useTempTrackingTable = z4;
    }

    public final <R> Object useConnection$room_runtime_release(boolean z4, p pVar, C2308e eVar) {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            t.w("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.useConnection(z4, pVar, eVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final <T> T getTypeConverter(C2733c cVar) {
        t.e(cVar, "klass");
        T t5 = this.typeConverters.get(cVar);
        t.c(t5, "null cannot be cast to non-null type T of androidx.room.RoomDatabase.getTypeConverter");
        return t5;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final void internalInitInvalidationTracker(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        getInvalidationTracker().internalInit$room_runtime_release(sQLiteConnection);
    }

    public Cursor query(String str, Object[] objArr) {
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    public static class MigrationContainer {
        private final Map<Integer, TreeMap<Integer, Migration>> migrations = new LinkedHashMap();

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void addMigration(Migration migration) {
            t.e(migration, "migration");
            int i5 = migration.startVersion;
            int i6 = migration.endVersion;
            Map<Integer, TreeMap<Integer, Migration>> map = this.migrations;
            Integer valueOf = Integer.valueOf(i5);
            TreeMap<Integer, Migration> treeMap = map.get(valueOf);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                map.put(valueOf, treeMap);
            }
            TreeMap treeMap2 = treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i6))) {
                Log.w(Room.LOG_TAG, "Overriding migration " + treeMap2.get(Integer.valueOf(i6)) + " with " + migration);
            }
            treeMap2.put(Integer.valueOf(i6), migration);
        }

        public void addMigrations(List<? extends Migration> list) {
            t.e(list, "migrations");
            for (Migration addMigration : list) {
                addMigration(addMigration);
            }
        }

        public final boolean contains(int i5, int i6) {
            return MigrationUtil.contains(this, i5, i6);
        }

        public List<Migration> findMigrationPath(int i5, int i6) {
            return MigrationUtil.findMigrationPath(this, i5, i6);
        }

        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return this.migrations;
        }

        public final s getSortedDescendingNodes$room_runtime_release(int i5) {
            TreeMap treeMap = this.migrations.get(Integer.valueOf(i5));
            if (treeMap == null) {
                return null;
            }
            return y.a(treeMap, treeMap.descendingKeySet());
        }

        public final s getSortedNodes$room_runtime_release(int i5) {
            TreeMap treeMap = this.migrations.get(Integer.valueOf(i5));
            if (treeMap == null) {
                return null;
            }
            return y.a(treeMap, treeMap.keySet());
        }

        public void addMigrations(Migration... migrationArr) {
            t.e(migrationArr, "migrations");
            for (Migration addMigration : migrationArr) {
                addMigration(addMigration);
            }
        }
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        t.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return getOpenHelper().getWritableDatabase().query(supportSQLiteQuery, cancellationSignal);
        }
        return getOpenHelper().getWritableDatabase().query(supportSQLiteQuery);
    }

    public <V> V runInTransaction(Callable<V> callable) {
        t.e(callable, TtmlNode.TAG_BODY);
        beginTransaction();
        try {
            V call = callable.call();
            setTransactionSuccessful();
            return call;
        } finally {
            endTransaction();
        }
    }
}
