package androidx.room;

import W2.y;
import X2.C2250q;
import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.room.migration.Migration;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.mbridge.msdk.MBridgeConstans;
import h3.C2453b;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    public static final Companion Companion = new Companion((C2633k) null);
    private final List<RoomDatabase.Callback> callbacks;
    private DatabaseConfiguration configuration;
    private final Delegate delegate;
    private final String identityHash;
    private final String legacyHash;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final void dropAllTables$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            Cursor query = supportSQLiteDatabase.query("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                List c5 = C2250q.c();
                while (query.moveToNext()) {
                    String string = query.getString(0);
                    t.b(string);
                    if (!s.P(string, "sqlite_", false, 2, (Object) null)) {
                        if (!t.a(string, "android_metadata")) {
                            c5.add(y.a(string, Boolean.valueOf(t.a(query.getString(1), MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW))));
                        }
                    }
                }
                List<W2.s> a5 = C2250q.a(c5);
                C2453b.a(query, (Throwable) null);
                for (W2.s sVar : a5) {
                    String str = (String) sVar.a();
                    if (((Boolean) sVar.b()).booleanValue()) {
                        supportSQLiteDatabase.execSQL("DROP VIEW IF EXISTS " + str);
                    } else {
                        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                    }
                }
            } catch (Throwable th) {
                C2453b.a(query, th);
                throw th;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
            h3.C2453b.a(r3, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean hasEmptySchema$room_runtime_release(androidx.sqlite.db.SupportSQLiteDatabase r3) {
            /*
                r2 = this;
                java.lang.String r0 = "db"
                kotlin.jvm.internal.t.e(r3, r0)
                java.lang.String r0 = "SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"
                android.database.Cursor r3 = r3.query((java.lang.String) r0)
                boolean r0 = r3.moveToFirst()     // Catch:{ all -> 0x001a }
                r1 = 0
                if (r0 == 0) goto L_0x001c
                int r0 = r3.getInt(r1)     // Catch:{ all -> 0x001a }
                if (r0 != 0) goto L_0x001c
                r1 = 1
                goto L_0x001c
            L_0x001a:
                r0 = move-exception
                goto L_0x0021
            L_0x001c:
                r0 = 0
                h3.C2453b.a(r3, r0)
                return r1
            L_0x0021:
                throw r0     // Catch:{ all -> 0x0022 }
            L_0x0022:
                r1 = move-exception
                h3.C2453b.a(r3, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.Companion.hasEmptySchema$room_runtime_release(androidx.sqlite.db.SupportSQLiteDatabase):boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
            h3.C2453b.a(r3, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean hasRoomMasterTable$room_runtime_release(androidx.sqlite.db.SupportSQLiteDatabase r3) {
            /*
                r2 = this;
                java.lang.String r0 = "db"
                kotlin.jvm.internal.t.e(r3, r0)
                java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
                android.database.Cursor r3 = r3.query((java.lang.String) r0)
                boolean r0 = r3.moveToFirst()     // Catch:{ all -> 0x001a }
                r1 = 0
                if (r0 == 0) goto L_0x001c
                int r0 = r3.getInt(r1)     // Catch:{ all -> 0x001a }
                if (r0 == 0) goto L_0x001c
                r1 = 1
                goto L_0x001c
            L_0x001a:
                r0 = move-exception
                goto L_0x0021
            L_0x001c:
                r0 = 0
                h3.C2453b.a(r3, r0)
                return r1
            L_0x0021:
                throw r0     // Catch:{ all -> 0x0022 }
            L_0x0022:
                r1 = move-exception
                h3.C2453b.a(r3, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.Companion.hasRoomMasterTable$room_runtime_release(androidx.sqlite.db.SupportSQLiteDatabase):boolean");
        }

        private Companion() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class Delegate {
        public final int version;

        public Delegate(int i5) {
            this.version = i5;
        }

        public abstract void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
        }

        public ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            validateMigration(supportSQLiteDatabase);
            return new ValidationResult(true, (String) null);
        }

        /* access modifiers changed from: protected */
        public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z4, String str) {
            this.isValid = z4;
            this.expectedFoundMsg = str;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate2, String str, String str2) {
        super(delegate2.version);
        t.e(databaseConfiguration, "configuration");
        t.e(delegate2, "delegate");
        t.e(str, "identityHash");
        t.e(str2, "legacyHash");
        this.callbacks = databaseConfiguration.callbacks;
        this.configuration = databaseConfiguration;
        this.delegate = delegate2;
        this.identityHash = str;
        this.legacyHash = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        h3.C2453b.a(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void checkIdentity(androidx.sqlite.db.SupportSQLiteDatabase r4) {
        /*
            r3 = this;
            androidx.room.RoomOpenHelper$Companion r0 = Companion
            boolean r0 = r0.hasRoomMasterTable$room_runtime_release(r4)
            if (r0 == 0) goto L_0x005f
            androidx.sqlite.db.SimpleSQLiteQuery r0 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.String r1 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r0.<init>(r1)
            android.database.Cursor r4 = r4.query((androidx.sqlite.db.SupportSQLiteQuery) r0)
            boolean r0 = r4.moveToFirst()     // Catch:{ all -> 0x0020 }
            r1 = 0
            if (r0 == 0) goto L_0x0022
            r0 = 0
            java.lang.String r0 = r4.getString(r0)     // Catch:{ all -> 0x0020 }
            goto L_0x0023
        L_0x0020:
            r0 = move-exception
            goto L_0x0059
        L_0x0022:
            r0 = r1
        L_0x0023:
            h3.C2453b.a(r4, r1)
            java.lang.String r4 = r3.identityHash
            boolean r4 = kotlin.jvm.internal.t.a(r4, r0)
            if (r4 != 0) goto L_0x0058
            java.lang.String r4 = r3.legacyHash
            boolean r4 = kotlin.jvm.internal.t.a(r4, r0)
            if (r4 == 0) goto L_0x0037
            goto L_0x0058
        L_0x0037:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            r1.append(r2)
            java.lang.String r2 = r3.identityHash
            r1.append(r2)
            java.lang.String r2 = ", found: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r4.<init>(r0)
            throw r4
        L_0x0058:
            return
        L_0x0059:
            throw r0     // Catch:{ all -> 0x005a }
        L_0x005a:
            r1 = move-exception
            h3.C2453b.a(r4, r0)
            throw r1
        L_0x005f:
            androidx.room.RoomOpenHelper$Delegate r0 = r3.delegate
            androidx.room.RoomOpenHelper$ValidationResult r0 = r0.onValidateSchema(r4)
            boolean r1 = r0.isValid
            if (r1 == 0) goto L_0x0072
            androidx.room.RoomOpenHelper$Delegate r0 = r3.delegate
            r0.onPostMigrate(r4)
            r3.updateIdentity(r4)
            return
        L_0x0072:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r1.append(r2)
            java.lang.String r0 = r0.expectedFoundMsg
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.checkIdentity(androidx.sqlite.db.SupportSQLiteDatabase):void");
    }

    private final void createMasterTableIfNotExists(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private final void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        createMasterTableIfNotExists(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        super.onConfigure(supportSQLiteDatabase);
    }

    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        boolean hasEmptySchema$room_runtime_release = Companion.hasEmptySchema$room_runtime_release(supportSQLiteDatabase);
        this.delegate.createAllTables(supportSQLiteDatabase);
        if (!hasEmptySchema$room_runtime_release) {
            ValidationResult onValidateSchema = this.delegate.onValidateSchema(supportSQLiteDatabase);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
            }
        }
        updateIdentity(supportSQLiteDatabase);
        this.delegate.onCreate(supportSQLiteDatabase);
        List<RoomDatabase.Callback> list = this.callbacks;
        if (list != null) {
            for (RoomDatabase.Callback onCreate : list) {
                onCreate.onCreate(supportSQLiteDatabase);
            }
        }
    }

    public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i5, int i6) {
        t.e(supportSQLiteDatabase, "db");
        onUpgrade(supportSQLiteDatabase, i5, i6);
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        super.onOpen(supportSQLiteDatabase);
        checkIdentity(supportSQLiteDatabase);
        this.delegate.onOpen(supportSQLiteDatabase);
        List<RoomDatabase.Callback> list = this.callbacks;
        if (list != null) {
            for (RoomDatabase.Callback onOpen : list) {
                onOpen.onOpen(supportSQLiteDatabase);
            }
        }
        this.configuration = null;
    }

    public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i5, int i6) {
        List<Migration> findMigrationPath;
        t.e(supportSQLiteDatabase, "db");
        DatabaseConfiguration databaseConfiguration = this.configuration;
        if (databaseConfiguration == null || (findMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(i5, i6)) == null) {
            DatabaseConfiguration databaseConfiguration2 = this.configuration;
            if (databaseConfiguration2 == null || databaseConfiguration2.isMigrationRequired(i5, i6)) {
                throw new IllegalStateException("A migration from " + i5 + " to " + i6 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            if (databaseConfiguration2.allowDestructiveMigrationForAllTables) {
                Companion.dropAllTables$room_runtime_release(supportSQLiteDatabase);
            } else {
                this.delegate.dropAllTables(supportSQLiteDatabase);
            }
            List<RoomDatabase.Callback> list = this.callbacks;
            if (list != null) {
                for (RoomDatabase.Callback onDestructiveMigration : list) {
                    onDestructiveMigration.onDestructiveMigration(supportSQLiteDatabase);
                }
            }
            this.delegate.createAllTables(supportSQLiteDatabase);
            return;
        }
        this.delegate.onPreMigrate(supportSQLiteDatabase);
        for (Migration migrate : findMigrationPath) {
            migrate.migrate((SQLiteConnection) new SupportSQLiteConnection(supportSQLiteDatabase));
        }
        ValidationResult onValidateSchema = this.delegate.onValidateSchema(supportSQLiteDatabase);
        if (onValidateSchema.isValid) {
            this.delegate.onPostMigrate(supportSQLiteDatabase);
            updateIdentity(supportSQLiteDatabase);
            return;
        }
        throw new IllegalStateException("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate2, String str) {
        this(databaseConfiguration, delegate2, "", str);
        t.e(databaseConfiguration, "configuration");
        t.e(delegate2, "delegate");
        t.e(str, "legacyHash");
    }
}
