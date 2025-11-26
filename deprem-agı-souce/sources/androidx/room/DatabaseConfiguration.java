package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import b3.C2312i;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;

public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationForAllTables;
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<AutoMigrationSpec> autoMigrationSpecs;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    public final RoomDatabase.MigrationContainer migrationContainer;
    private final Set<Integer> migrationNotRequiredFrom;
    public final boolean multiInstanceInvalidation;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final Intent multiInstanceInvalidationServiceIntent;
    public final String name;
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    public final C2312i queryCoroutineContext;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SQLiteDriver sqliteDriver;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List<Object> typeConverters;
    private boolean useTempTrackingTable;

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context2, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer2, List<? extends RoomDatabase.Callback> list, boolean z4, RoomDatabase.JournalMode journalMode2, Executor executor, Executor executor2, Intent intent, boolean z5, boolean z6, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3, boolean z7, SQLiteDriver sQLiteDriver, C2312i iVar) {
        Intent intent2 = intent;
        List<? extends Object> list4 = list2;
        List<? extends AutoMigrationSpec> list5 = list3;
        t.e(context2, "context");
        t.e(migrationContainer2, "migrationContainer");
        t.e(journalMode2, "journalMode");
        t.e(executor, "queryExecutor");
        t.e(executor2, "transactionExecutor");
        t.e(list4, "typeConverters");
        t.e(list5, "autoMigrationSpecs");
        this.context = context2;
        this.name = str;
        this.sqliteOpenHelperFactory = factory;
        this.migrationContainer = migrationContainer2;
        this.callbacks = list;
        this.allowMainThreadQueries = z4;
        this.journalMode = journalMode2;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidationServiceIntent = intent2;
        this.requireMigration = z5;
        this.allowDestructiveMigrationOnDowngrade = z6;
        this.migrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
        this.typeConverters = list4;
        this.autoMigrationSpecs = list5;
        this.allowDestructiveMigrationForAllTables = z7;
        this.sqliteDriver = sQLiteDriver;
        this.queryCoroutineContext = iVar;
        this.multiInstanceInvalidation = intent2 != null;
        this.useTempTrackingTable = true;
    }

    public static /* synthetic */ DatabaseConfiguration copy$default(DatabaseConfiguration databaseConfiguration, Context context2, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer2, List list, boolean z4, RoomDatabase.JournalMode journalMode2, Executor executor, Executor executor2, Intent intent, boolean z5, boolean z6, Set set, String str2, File file, Callable callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2, List list2, List list3, boolean z7, SQLiteDriver sQLiteDriver, C2312i iVar, int i5, Object obj) {
        C2312i iVar2;
        SQLiteDriver sQLiteDriver2;
        DatabaseConfiguration databaseConfiguration2 = databaseConfiguration;
        int i6 = i5;
        if (obj == null) {
            Context context3 = (i6 & 1) != 0 ? databaseConfiguration2.context : context2;
            String str3 = (i6 & 2) != 0 ? databaseConfiguration2.name : str;
            SupportSQLiteOpenHelper.Factory factory2 = (i6 & 4) != 0 ? databaseConfiguration2.sqliteOpenHelperFactory : factory;
            RoomDatabase.MigrationContainer migrationContainer3 = (i6 & 8) != 0 ? databaseConfiguration2.migrationContainer : migrationContainer2;
            List list4 = (i6 & 16) != 0 ? databaseConfiguration2.callbacks : list;
            boolean z8 = (i6 & 32) != 0 ? databaseConfiguration2.allowMainThreadQueries : z4;
            RoomDatabase.JournalMode journalMode3 = (i6 & 64) != 0 ? databaseConfiguration2.journalMode : journalMode2;
            Executor executor3 = (i6 & 128) != 0 ? databaseConfiguration2.queryExecutor : executor;
            Executor executor4 = (i6 & 256) != 0 ? databaseConfiguration2.transactionExecutor : executor2;
            Intent intent2 = (i6 & 512) != 0 ? databaseConfiguration2.multiInstanceInvalidationServiceIntent : intent;
            boolean z9 = (i6 & 1024) != 0 ? databaseConfiguration2.requireMigration : z5;
            boolean z10 = (i6 & 2048) != 0 ? databaseConfiguration2.allowDestructiveMigrationOnDowngrade : z6;
            Set set2 = (i6 & 4096) != 0 ? databaseConfiguration2.migrationNotRequiredFrom : set;
            String str4 = (i6 & 8192) != 0 ? databaseConfiguration2.copyFromAssetPath : str2;
            Context context4 = context3;
            File file2 = (i6 & 16384) != 0 ? databaseConfiguration2.copyFromFile : file;
            Callable callable2 = (i6 & 32768) != 0 ? databaseConfiguration2.copyFromInputStream : callable;
            RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback3 = (i5 & 65536) != 0 ? databaseConfiguration2.prepackagedDatabaseCallback : prepackagedDatabaseCallback2;
            List list5 = (i5 & 131072) != 0 ? databaseConfiguration2.typeConverters : list2;
            List list6 = (i5 & 262144) != 0 ? databaseConfiguration2.autoMigrationSpecs : list3;
            boolean z11 = (i5 & 524288) != 0 ? databaseConfiguration2.allowDestructiveMigrationForAllTables : z7;
            SQLiteDriver sQLiteDriver3 = (i5 & 1048576) != 0 ? databaseConfiguration2.sqliteDriver : sQLiteDriver;
            if ((i5 & 2097152) != 0) {
                sQLiteDriver2 = sQLiteDriver3;
                iVar2 = databaseConfiguration2.queryCoroutineContext;
            } else {
                iVar2 = iVar;
                sQLiteDriver2 = sQLiteDriver3;
            }
            return databaseConfiguration2.copy(context4, str3, factory2, migrationContainer3, list4, z8, journalMode3, executor3, executor4, intent2, z9, z10, set2, str4, file2, callable2, prepackagedDatabaseCallback3, list5, list6, z11, sQLiteDriver2, iVar2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final DatabaseConfiguration copy(Context context2, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer2, List<? extends RoomDatabase.Callback> list, boolean z4, RoomDatabase.JournalMode journalMode2, Executor executor, Executor executor2, Intent intent, boolean z5, boolean z6, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3, boolean z7, SQLiteDriver sQLiteDriver, C2312i iVar) {
        Context context3 = context2;
        t.e(context3, "context");
        RoomDatabase.MigrationContainer migrationContainer3 = migrationContainer2;
        t.e(migrationContainer3, "migrationContainer");
        RoomDatabase.JournalMode journalMode3 = journalMode2;
        t.e(journalMode3, "journalMode");
        Executor executor3 = executor;
        t.e(executor3, "queryExecutor");
        Executor executor4 = executor2;
        t.e(executor4, "transactionExecutor");
        t.e(list2, "typeConverters");
        List<? extends AutoMigrationSpec> list4 = list3;
        t.e(list4, "autoMigrationSpecs");
        List<? extends AutoMigrationSpec> list5 = list4;
        return new DatabaseConfiguration(context3, str, factory, migrationContainer3, list, z4, journalMode3, executor3, executor4, intent, z5, z6, set, str2, file, callable, prepackagedDatabaseCallback2, list2, list5, z7, sQLiteDriver, iVar);
    }

    public final Set<Integer> getMigrationNotRequiredFrom$room_runtime_release() {
        return this.migrationNotRequiredFrom;
    }

    public final boolean getUseTempTrackingTable$room_runtime_release() {
        return this.useTempTrackingTable;
    }

    public boolean isMigrationRequired(int i5, int i6) {
        return MigrationUtil.isMigrationRequired(this, i5, i6);
    }

    public boolean isMigrationRequiredFrom(int i5) {
        return isMigrationRequired(i5, i5 + 1);
    }

    public final void setUseTempTrackingTable$room_runtime_release(boolean z4) {
        this.useTempTrackingTable = z4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r25, java.lang.String r26, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r27, androidx.room.RoomDatabase.MigrationContainer r28, java.util.List<? extends androidx.room.RoomDatabase.Callback> r29, boolean r30, androidx.room.RoomDatabase.JournalMode r31, java.util.concurrent.Executor r32, boolean r33, java.util.Set<java.lang.Integer> r34) {
        /*
            r24 = this;
            java.lang.String r0 = "context"
            r2 = r25
            kotlin.jvm.internal.t.e(r2, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r4 = r27
            kotlin.jvm.internal.t.e(r4, r0)
            java.lang.String r0 = "migrationContainer"
            r5 = r28
            kotlin.jvm.internal.t.e(r5, r0)
            java.lang.String r0 = "journalMode"
            r8 = r31
            kotlin.jvm.internal.t.e(r8, r0)
            java.lang.String r0 = "queryExecutor"
            r9 = r32
            kotlin.jvm.internal.t.e(r9, r0)
            java.util.List r19 = X2.C2250q.g()
            java.util.List r20 = X2.C2250q.g()
            r22 = 0
            r23 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r21 = 0
            r10 = r32
            r1 = r24
            r3 = r26
            r6 = r29
            r7 = r30
            r12 = r33
            r14 = r34
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, boolean, java.util.Set):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r24, java.lang.String r25, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r26, androidx.room.RoomDatabase.MigrationContainer r27, java.util.List<? extends androidx.room.RoomDatabase.Callback> r28, boolean r29, androidx.room.RoomDatabase.JournalMode r30, java.util.concurrent.Executor r31, java.util.concurrent.Executor r32, boolean r33, boolean r34, boolean r35, java.util.Set<java.lang.Integer> r36) {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r0 = "context"
            kotlin.jvm.internal.t.e(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r26
            kotlin.jvm.internal.t.e(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r27
            kotlin.jvm.internal.t.e(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r30
            kotlin.jvm.internal.t.e(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r31
            kotlin.jvm.internal.t.e(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r32
            kotlin.jvm.internal.t.e(r9, r0)
            if (r33 == 0) goto L_0x0035
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0033:
            r10 = r0
            goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x0033
        L_0x0037:
            java.util.List r18 = X2.C2250q.g()
            java.util.List r19 = X2.C2250q.g()
            r21 = 0
            r22 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r20 = 0
            r0 = r23
            r2 = r25
            r5 = r28
            r6 = r29
            r11 = r34
            r12 = r35
            r13 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r24, java.lang.String r25, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r26, androidx.room.RoomDatabase.MigrationContainer r27, java.util.List<? extends androidx.room.RoomDatabase.Callback> r28, boolean r29, androidx.room.RoomDatabase.JournalMode r30, java.util.concurrent.Executor r31, java.util.concurrent.Executor r32, boolean r33, boolean r34, boolean r35, java.util.Set<java.lang.Integer> r36, java.lang.String r37, java.io.File r38) {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r0 = "context"
            kotlin.jvm.internal.t.e(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r26
            kotlin.jvm.internal.t.e(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r27
            kotlin.jvm.internal.t.e(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r30
            kotlin.jvm.internal.t.e(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r31
            kotlin.jvm.internal.t.e(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r32
            kotlin.jvm.internal.t.e(r9, r0)
            if (r33 == 0) goto L_0x0035
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0033:
            r10 = r0
            goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x0033
        L_0x0037:
            java.util.List r18 = X2.C2250q.g()
            java.util.List r19 = X2.C2250q.g()
            r21 = 0
            r22 = 0
            r16 = 0
            r17 = 0
            r20 = 0
            r0 = r23
            r2 = r25
            r5 = r28
            r6 = r29
            r11 = r34
            r12 = r35
            r13 = r36
            r14 = r37
            r15 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r24, java.lang.String r25, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r26, androidx.room.RoomDatabase.MigrationContainer r27, java.util.List<? extends androidx.room.RoomDatabase.Callback> r28, boolean r29, androidx.room.RoomDatabase.JournalMode r30, java.util.concurrent.Executor r31, java.util.concurrent.Executor r32, boolean r33, boolean r34, boolean r35, java.util.Set<java.lang.Integer> r36, java.lang.String r37, java.io.File r38, java.util.concurrent.Callable<java.io.InputStream> r39) {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r0 = "context"
            kotlin.jvm.internal.t.e(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r26
            kotlin.jvm.internal.t.e(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r27
            kotlin.jvm.internal.t.e(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r30
            kotlin.jvm.internal.t.e(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r31
            kotlin.jvm.internal.t.e(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r32
            kotlin.jvm.internal.t.e(r9, r0)
            if (r33 == 0) goto L_0x0035
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0033:
            r10 = r0
            goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x0033
        L_0x0037:
            java.util.List r18 = X2.C2250q.g()
            java.util.List r19 = X2.C2250q.g()
            r21 = 0
            r22 = 0
            r17 = 0
            r20 = 0
            r0 = r23
            r2 = r25
            r5 = r28
            r6 = r29
            r11 = r34
            r12 = r35
            r13 = r36
            r14 = r37
            r15 = r38
            r16 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r24, java.lang.String r25, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r26, androidx.room.RoomDatabase.MigrationContainer r27, java.util.List<? extends androidx.room.RoomDatabase.Callback> r28, boolean r29, androidx.room.RoomDatabase.JournalMode r30, java.util.concurrent.Executor r31, java.util.concurrent.Executor r32, boolean r33, boolean r34, boolean r35, java.util.Set<java.lang.Integer> r36, java.lang.String r37, java.io.File r38, java.util.concurrent.Callable<java.io.InputStream> r39, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r40) {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r0 = "context"
            kotlin.jvm.internal.t.e(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r26
            kotlin.jvm.internal.t.e(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r27
            kotlin.jvm.internal.t.e(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r30
            kotlin.jvm.internal.t.e(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r31
            kotlin.jvm.internal.t.e(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r32
            kotlin.jvm.internal.t.e(r9, r0)
            if (r33 == 0) goto L_0x0035
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0033:
            r10 = r0
            goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x0033
        L_0x0037:
            java.util.List r18 = X2.C2250q.g()
            java.util.List r19 = X2.C2250q.g()
            r21 = 0
            r22 = 0
            r20 = 0
            r0 = r23
            r2 = r25
            r5 = r28
            r6 = r29
            r11 = r34
            r12 = r35
            r13 = r36
            r14 = r37
            r15 = r38
            r16 = r39
            r17 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r24, java.lang.String r25, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r26, androidx.room.RoomDatabase.MigrationContainer r27, java.util.List<? extends androidx.room.RoomDatabase.Callback> r28, boolean r29, androidx.room.RoomDatabase.JournalMode r30, java.util.concurrent.Executor r31, java.util.concurrent.Executor r32, boolean r33, boolean r34, boolean r35, java.util.Set<java.lang.Integer> r36, java.lang.String r37, java.io.File r38, java.util.concurrent.Callable<java.io.InputStream> r39, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r40, java.util.List<? extends java.lang.Object> r41) {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r0 = "context"
            kotlin.jvm.internal.t.e(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r26
            kotlin.jvm.internal.t.e(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r27
            kotlin.jvm.internal.t.e(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r30
            kotlin.jvm.internal.t.e(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r31
            kotlin.jvm.internal.t.e(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r32
            kotlin.jvm.internal.t.e(r9, r0)
            java.lang.String r0 = "typeConverters"
            r2 = r41
            kotlin.jvm.internal.t.e(r2, r0)
            if (r33 == 0) goto L_0x003c
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r5 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r5)
        L_0x003a:
            r10 = r0
            goto L_0x003e
        L_0x003c:
            r0 = 0
            goto L_0x003a
        L_0x003e:
            java.util.List r19 = X2.C2250q.g()
            r21 = 0
            r22 = 0
            r20 = 0
            r0 = r23
            r5 = r28
            r6 = r29
            r11 = r34
            r12 = r35
            r13 = r36
            r14 = r37
            r15 = r38
            r16 = r39
            r17 = r40
            r18 = r2
            r2 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback, java.util.List):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r24, java.lang.String r25, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r26, androidx.room.RoomDatabase.MigrationContainer r27, java.util.List<? extends androidx.room.RoomDatabase.Callback> r28, boolean r29, androidx.room.RoomDatabase.JournalMode r30, java.util.concurrent.Executor r31, java.util.concurrent.Executor r32, boolean r33, boolean r34, boolean r35, java.util.Set<java.lang.Integer> r36, java.lang.String r37, java.io.File r38, java.util.concurrent.Callable<java.io.InputStream> r39, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r40, java.util.List<? extends java.lang.Object> r41, java.util.List<? extends androidx.room.migration.AutoMigrationSpec> r42) {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r0 = "context"
            kotlin.jvm.internal.t.e(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r26
            kotlin.jvm.internal.t.e(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r27
            kotlin.jvm.internal.t.e(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r30
            kotlin.jvm.internal.t.e(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r31
            kotlin.jvm.internal.t.e(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r32
            kotlin.jvm.internal.t.e(r9, r0)
            java.lang.String r0 = "typeConverters"
            r2 = r41
            kotlin.jvm.internal.t.e(r2, r0)
            java.lang.String r0 = "autoMigrationSpecs"
            r5 = r42
            kotlin.jvm.internal.t.e(r5, r0)
            if (r33 == 0) goto L_0x0043
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r6 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r6)
        L_0x0041:
            r10 = r0
            goto L_0x0045
        L_0x0043:
            r0 = 0
            goto L_0x0041
        L_0x0045:
            r21 = 0
            r22 = 0
            r17 = 0
            r20 = 0
            r0 = r23
            r6 = r29
            r11 = r34
            r12 = r35
            r13 = r36
            r14 = r37
            r15 = r38
            r16 = r39
            r18 = r2
            r19 = r5
            r2 = r25
            r5 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback, java.util.List, java.util.List):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r25, java.lang.String r26, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r27, androidx.room.RoomDatabase.MigrationContainer r28, java.util.List<? extends androidx.room.RoomDatabase.Callback> r29, boolean r30, androidx.room.RoomDatabase.JournalMode r31, java.util.concurrent.Executor r32, java.util.concurrent.Executor r33, android.content.Intent r34, boolean r35, boolean r36, java.util.Set<java.lang.Integer> r37, java.lang.String r38, java.io.File r39, java.util.concurrent.Callable<java.io.InputStream> r40, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r41, java.util.List<? extends java.lang.Object> r42, java.util.List<? extends androidx.room.migration.AutoMigrationSpec> r43) {
        /*
            r24 = this;
            java.lang.String r0 = "context"
            r2 = r25
            kotlin.jvm.internal.t.e(r2, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r4 = r27
            kotlin.jvm.internal.t.e(r4, r0)
            java.lang.String r0 = "migrationContainer"
            r5 = r28
            kotlin.jvm.internal.t.e(r5, r0)
            java.lang.String r0 = "journalMode"
            r8 = r31
            kotlin.jvm.internal.t.e(r8, r0)
            java.lang.String r0 = "queryExecutor"
            r9 = r32
            kotlin.jvm.internal.t.e(r9, r0)
            java.lang.String r0 = "transactionExecutor"
            r10 = r33
            kotlin.jvm.internal.t.e(r10, r0)
            java.lang.String r0 = "typeConverters"
            r1 = r42
            kotlin.jvm.internal.t.e(r1, r0)
            java.lang.String r0 = "autoMigrationSpecs"
            r3 = r43
            kotlin.jvm.internal.t.e(r3, r0)
            r22 = 0
            r23 = 0
            r18 = 0
            r21 = 0
            r6 = r29
            r7 = r30
            r11 = r34
            r12 = r35
            r13 = r36
            r14 = r37
            r15 = r38
            r16 = r39
            r17 = r40
            r19 = r1
            r20 = r3
            r1 = r24
            r3 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, android.content.Intent, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback, java.util.List, java.util.List):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r25, java.lang.String r26, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r27, androidx.room.RoomDatabase.MigrationContainer r28, java.util.List<? extends androidx.room.RoomDatabase.Callback> r29, boolean r30, androidx.room.RoomDatabase.JournalMode r31, java.util.concurrent.Executor r32, java.util.concurrent.Executor r33, android.content.Intent r34, boolean r35, boolean r36, java.util.Set<java.lang.Integer> r37, java.lang.String r38, java.io.File r39, java.util.concurrent.Callable<java.io.InputStream> r40, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r41, java.util.List<? extends java.lang.Object> r42, java.util.List<? extends androidx.room.migration.AutoMigrationSpec> r43, boolean r44) {
        /*
            r24 = this;
            java.lang.String r0 = "context"
            r2 = r25
            kotlin.jvm.internal.t.e(r2, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r4 = r27
            kotlin.jvm.internal.t.e(r4, r0)
            java.lang.String r0 = "migrationContainer"
            r5 = r28
            kotlin.jvm.internal.t.e(r5, r0)
            java.lang.String r0 = "journalMode"
            r8 = r31
            kotlin.jvm.internal.t.e(r8, r0)
            java.lang.String r0 = "queryExecutor"
            r9 = r32
            kotlin.jvm.internal.t.e(r9, r0)
            java.lang.String r0 = "transactionExecutor"
            r10 = r33
            kotlin.jvm.internal.t.e(r10, r0)
            java.lang.String r0 = "typeConverters"
            r1 = r42
            kotlin.jvm.internal.t.e(r1, r0)
            java.lang.String r0 = "autoMigrationSpecs"
            r3 = r43
            kotlin.jvm.internal.t.e(r3, r0)
            r22 = 0
            r23 = 0
            r18 = 0
            r6 = r29
            r7 = r30
            r11 = r34
            r12 = r35
            r13 = r36
            r14 = r37
            r15 = r38
            r16 = r39
            r17 = r40
            r21 = r44
            r19 = r1
            r20 = r3
            r1 = r24
            r3 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, android.content.Intent, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback, java.util.List, java.util.List, boolean):void");
    }
}
