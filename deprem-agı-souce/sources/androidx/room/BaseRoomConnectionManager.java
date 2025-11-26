package androidx.room;

import W2.y;
import X2.C2250q;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.concurrent.ExclusiveLock;
import androidx.room.migration.Migration;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.SQLiteStatement;
import b3.C2308e;
import com.mbridge.msdk.MBridgeConstans;
import i3.C2579a;
import java.util.List;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class BaseRoomConnectionManager {
    public static final int BUSY_TIMEOUT_MS = 3000;
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    public boolean isConfigured;
    /* access modifiers changed from: private */
    public boolean isInitializing;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    protected final class DriverWrapper implements SQLiteDriver {
        private final SQLiteDriver actual;
        final /* synthetic */ BaseRoomConnectionManager this$0;

        public DriverWrapper(BaseRoomConnectionManager baseRoomConnectionManager, SQLiteDriver sQLiteDriver) {
            t.e(sQLiteDriver, "actual");
            this.this$0 = baseRoomConnectionManager;
            this.actual = sQLiteDriver;
        }

        private final SQLiteConnection openLocked(String str) {
            boolean z4;
            if (this.this$0.isConfigured || this.this$0.isInitializing || t.a(str, ":memory:")) {
                z4 = false;
            } else {
                z4 = true;
            }
            return (SQLiteConnection) new ExclusiveLock(str, z4).withLock(new d(this.this$0, this, str), new BaseRoomConnectionManager$DriverWrapper$openLocked$2(str));
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: private */
        public static final SQLiteConnection openLocked$lambda$1(BaseRoomConnectionManager baseRoomConnectionManager, DriverWrapper driverWrapper, String str) {
            if (!baseRoomConnectionManager.isInitializing) {
                SQLiteConnection open = driverWrapper.actual.open(str);
                if (!baseRoomConnectionManager.isConfigured) {
                    try {
                        baseRoomConnectionManager.isInitializing = true;
                        baseRoomConnectionManager.configureDatabase(open);
                        baseRoomConnectionManager.isInitializing = false;
                        return open;
                    } catch (Throwable th) {
                        baseRoomConnectionManager.isInitializing = false;
                        throw th;
                    }
                } else {
                    baseRoomConnectionManager.configurationConnection(open);
                    return open;
                }
            } else {
                throw new IllegalStateException("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
            }
        }

        public SQLiteConnection open(String str) {
            t.e(str, "fileName");
            return openLocked(this.this$0.resolveFileName$room_runtime_release(str));
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.room.RoomDatabase$JournalMode[] r0 = androidx.room.RoomDatabase.JournalMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.room.RoomDatabase$JournalMode r1 = androidx.room.RoomDatabase.JournalMode.TRUNCATE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.room.RoomDatabase$JournalMode r1 = androidx.room.RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.BaseRoomConnectionManager.WhenMappings.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0069, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        i3.C2579a.a(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006d, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void checkIdentity(androidx.sqlite.SQLiteConnection r5) {
        /*
            r4 = this;
            boolean r0 = r4.hasRoomMasterTable(r5)
            if (r0 == 0) goto L_0x006e
            java.lang.String r0 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            androidx.sqlite.SQLiteStatement r5 = r5.prepare(r0)
            boolean r0 = r5.step()     // Catch:{ all -> 0x0019 }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            r0 = 0
            java.lang.String r0 = r5.getText(r0)     // Catch:{ all -> 0x0019 }
            goto L_0x001c
        L_0x0019:
            r0 = move-exception
            goto L_0x0068
        L_0x001b:
            r0 = r1
        L_0x001c:
            i3.C2579a.a(r5, r1)
            androidx.room.RoomOpenDelegate r5 = r4.getOpenDelegate()
            java.lang.String r5 = r5.getIdentityHash()
            boolean r5 = kotlin.jvm.internal.t.a(r5, r0)
            if (r5 != 0) goto L_0x0067
            androidx.room.RoomOpenDelegate r5 = r4.getOpenDelegate()
            java.lang.String r5 = r5.getLegacyIdentityHash()
            boolean r5 = kotlin.jvm.internal.t.a(r5, r0)
            if (r5 == 0) goto L_0x003c
            goto L_0x0067
        L_0x003c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            r1.append(r2)
            androidx.room.RoomOpenDelegate r2 = r4.getOpenDelegate()
            java.lang.String r2 = r2.getIdentityHash()
            r1.append(r2)
            java.lang.String r2 = ", found: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x0067:
            return
        L_0x0068:
            throw r0     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r1 = move-exception
            i3.C2579a.a(r5, r0)
            throw r1
        L_0x006e:
            java.lang.String r0 = "BEGIN EXCLUSIVE TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r5, r0)
            W2.t$a r0 = W2.t.f19966b     // Catch:{ all -> 0x0092 }
            androidx.room.RoomOpenDelegate r0 = r4.getOpenDelegate()     // Catch:{ all -> 0x0092 }
            androidx.room.RoomOpenDelegate$ValidationResult r0 = r0.onValidateSchema(r5)     // Catch:{ all -> 0x0092 }
            boolean r1 = r0.isValid     // Catch:{ all -> 0x0092 }
            if (r1 == 0) goto L_0x0094
            androidx.room.RoomOpenDelegate r0 = r4.getOpenDelegate()     // Catch:{ all -> 0x0092 }
            r0.onPostMigrate(r5)     // Catch:{ all -> 0x0092 }
            r4.updateIdentity(r5)     // Catch:{ all -> 0x0092 }
            W2.J r0 = W2.J.f19942a     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = W2.t.b(r0)     // Catch:{ all -> 0x0092 }
            goto L_0x00bb
        L_0x0092:
            r0 = move-exception
            goto L_0x00b1
        L_0x0094:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0092 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0092 }
            r2.<init>()     // Catch:{ all -> 0x0092 }
            java.lang.String r3 = "Pre-packaged database has an invalid schema: "
            r2.append(r3)     // Catch:{ all -> 0x0092 }
            java.lang.String r0 = r0.expectedFoundMsg     // Catch:{ all -> 0x0092 }
            r2.append(r0)     // Catch:{ all -> 0x0092 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0092 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0092 }
            r1.<init>(r0)     // Catch:{ all -> 0x0092 }
            throw r1     // Catch:{ all -> 0x0092 }
        L_0x00b1:
            W2.t$a r1 = W2.t.f19966b
            java.lang.Object r0 = W2.u.a(r0)
            java.lang.Object r0 = W2.t.b(r0)
        L_0x00bb:
            boolean r1 = W2.t.h(r0)
            if (r1 == 0) goto L_0x00c9
            r1 = r0
            W2.J r1 = (W2.J) r1
            java.lang.String r1 = "END TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r5, r1)
        L_0x00c9:
            java.lang.Throwable r1 = W2.t.e(r0)
            if (r1 != 0) goto L_0x00d3
            W2.t.a(r0)
            return
        L_0x00d3:
            java.lang.String r0 = "ROLLBACK TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r5, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.BaseRoomConnectionManager.checkIdentity(androidx.sqlite.SQLiteConnection):void");
    }

    /* access modifiers changed from: private */
    public final void configurationConnection(SQLiteConnection sQLiteConnection) {
        configureSynchronousFlag(sQLiteConnection);
        configureBusyTimeout(sQLiteConnection);
        getOpenDelegate().onOpen(sQLiteConnection);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        i3.C2579a.a(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void configureBusyTimeout(androidx.sqlite.SQLiteConnection r6) {
        /*
            r5 = this;
            java.lang.String r0 = "PRAGMA busy_timeout"
            androidx.sqlite.SQLiteStatement r0 = r6.prepare(r0)
            r0.step()     // Catch:{ all -> 0x001e }
            r1 = 0
            long r1 = r0.getLong(r1)     // Catch:{ all -> 0x001e }
            r3 = 0
            i3.C2579a.a(r0, r3)
            r3 = 3000(0xbb8, double:1.482E-320)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x001d
            java.lang.String r0 = "PRAGMA busy_timeout = 3000"
            androidx.sqlite.SQLite.execSQL(r6, r0)
        L_0x001d:
            return
        L_0x001e:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r1 = move-exception
            i3.C2579a.a(r0, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.BaseRoomConnectionManager.configureBusyTimeout(androidx.sqlite.SQLiteConnection):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008f, code lost:
        i3.C2579a.a(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void configureDatabase(androidx.sqlite.SQLiteConnection r4) {
        /*
            r3 = this;
            r3.configureJournalMode(r4)
            r3.configureSynchronousFlag(r4)
            r3.configureBusyTimeout(r4)
            java.lang.String r0 = "PRAGMA user_version"
            androidx.sqlite.SQLiteStatement r0 = r4.prepare(r0)
            r0.step()     // Catch:{ all -> 0x008c }
            r1 = 0
            long r1 = r0.getLong(r1)     // Catch:{ all -> 0x008c }
            int r1 = (int) r1
            r2 = 0
            i3.C2579a.a(r0, r2)
            androidx.room.RoomOpenDelegate r0 = r3.getOpenDelegate()
            int r0 = r0.getVersion()
            if (r1 == r0) goto L_0x0088
            java.lang.String r0 = "BEGIN EXCLUSIVE TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r4, r0)
            W2.t$a r0 = W2.t.f19966b     // Catch:{ all -> 0x0033 }
            if (r1 != 0) goto L_0x0035
            r3.onCreate(r4)     // Catch:{ all -> 0x0033 }
            goto L_0x0040
        L_0x0033:
            r0 = move-exception
            goto L_0x0063
        L_0x0035:
            androidx.room.RoomOpenDelegate r0 = r3.getOpenDelegate()     // Catch:{ all -> 0x0033 }
            int r0 = r0.getVersion()     // Catch:{ all -> 0x0033 }
            r3.onMigrate(r4, r1, r0)     // Catch:{ all -> 0x0033 }
        L_0x0040:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0033 }
            r0.<init>()     // Catch:{ all -> 0x0033 }
            java.lang.String r1 = "PRAGMA user_version = "
            r0.append(r1)     // Catch:{ all -> 0x0033 }
            androidx.room.RoomOpenDelegate r1 = r3.getOpenDelegate()     // Catch:{ all -> 0x0033 }
            int r1 = r1.getVersion()     // Catch:{ all -> 0x0033 }
            r0.append(r1)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0033 }
            androidx.sqlite.SQLite.execSQL(r4, r0)     // Catch:{ all -> 0x0033 }
            W2.J r0 = W2.J.f19942a     // Catch:{ all -> 0x0033 }
            java.lang.Object r0 = W2.t.b(r0)     // Catch:{ all -> 0x0033 }
            goto L_0x006d
        L_0x0063:
            W2.t$a r1 = W2.t.f19966b
            java.lang.Object r0 = W2.u.a(r0)
            java.lang.Object r0 = W2.t.b(r0)
        L_0x006d:
            boolean r1 = W2.t.h(r0)
            if (r1 == 0) goto L_0x007b
            r1 = r0
            W2.J r1 = (W2.J) r1
            java.lang.String r1 = "END TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r4, r1)
        L_0x007b:
            java.lang.Throwable r0 = W2.t.e(r0)
            if (r0 != 0) goto L_0x0082
            goto L_0x0088
        L_0x0082:
            java.lang.String r1 = "ROLLBACK TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r4, r1)
            throw r0
        L_0x0088:
            r3.onOpen(r4)
            return
        L_0x008c:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x008e }
        L_0x008e:
            r1 = move-exception
            i3.C2579a.a(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.BaseRoomConnectionManager.configureDatabase(androidx.sqlite.SQLiteConnection):void");
    }

    private final void configureJournalMode(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(sQLiteConnection, "PRAGMA journal_mode = WAL");
        } else {
            SQLite.execSQL(sQLiteConnection, "PRAGMA journal_mode = TRUNCATE");
        }
    }

    private final void configureSynchronousFlag(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(sQLiteConnection, "PRAGMA synchronous = NORMAL");
        } else {
            SQLite.execSQL(sQLiteConnection, "PRAGMA synchronous = FULL");
        }
    }

    private final void createMasterTableIfNotExists(SQLiteConnection sQLiteConnection) {
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.CREATE_QUERY);
    }

    private final void dropAllTables(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().allowDestructiveMigrationForAllTables) {
            SQLiteStatement prepare = sQLiteConnection.prepare("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                List c5 = C2250q.c();
                while (prepare.step()) {
                    String text = prepare.getText(0);
                    if (!s.P(text, "sqlite_", false, 2, (Object) null)) {
                        if (!t.a(text, "android_metadata")) {
                            c5.add(y.a(text, Boolean.valueOf(t.a(prepare.getText(1), MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW))));
                        }
                    }
                }
                List<W2.s> a5 = C2250q.a(c5);
                C2579a.a(prepare, (Throwable) null);
                for (W2.s sVar : a5) {
                    String str = (String) sVar.a();
                    if (((Boolean) sVar.b()).booleanValue()) {
                        SQLite.execSQL(sQLiteConnection, "DROP VIEW IF EXISTS " + str);
                    } else {
                        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS " + str);
                    }
                }
            } catch (Throwable th) {
                C2579a.a(prepare, th);
                throw th;
            }
        } else {
            getOpenDelegate().dropAllTables(sQLiteConnection);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        i3.C2579a.a(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean hasEmptySchema(androidx.sqlite.SQLiteConnection r7) {
        /*
            r6 = this;
            java.lang.String r0 = "SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"
            androidx.sqlite.SQLiteStatement r7 = r7.prepare(r0)
            boolean r0 = r7.step()     // Catch:{ all -> 0x0019 }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            long r2 = r7.getLong(r1)     // Catch:{ all -> 0x0019 }
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x001b
            r1 = 1
            goto L_0x001b
        L_0x0019:
            r0 = move-exception
            goto L_0x0020
        L_0x001b:
            r0 = 0
            i3.C2579a.a(r7, r0)
            return r1
        L_0x0020:
            throw r0     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r1 = move-exception
            i3.C2579a.a(r7, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.BaseRoomConnectionManager.hasEmptySchema(androidx.sqlite.SQLiteConnection):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        i3.C2579a.a(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean hasRoomMasterTable(androidx.sqlite.SQLiteConnection r7) {
        /*
            r6 = this;
            java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'"
            androidx.sqlite.SQLiteStatement r7 = r7.prepare(r0)
            boolean r0 = r7.step()     // Catch:{ all -> 0x0019 }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            long r2 = r7.getLong(r1)     // Catch:{ all -> 0x0019 }
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x001b
            r1 = 1
            goto L_0x001b
        L_0x0019:
            r0 = move-exception
            goto L_0x0020
        L_0x001b:
            r0 = 0
            i3.C2579a.a(r7, r0)
            return r1
        L_0x0020:
            throw r0     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r1 = move-exception
            i3.C2579a.a(r7, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.BaseRoomConnectionManager.hasRoomMasterTable(androidx.sqlite.SQLiteConnection):boolean");
    }

    private final void invokeCreateCallback(SQLiteConnection sQLiteConnection) {
        for (RoomDatabase.Callback onCreate : getCallbacks()) {
            onCreate.onCreate(sQLiteConnection);
        }
    }

    private final void invokeDestructiveMigrationCallback(SQLiteConnection sQLiteConnection) {
        for (RoomDatabase.Callback onDestructiveMigration : getCallbacks()) {
            onDestructiveMigration.onDestructiveMigration(sQLiteConnection);
        }
    }

    private final void invokeOpenCallback(SQLiteConnection sQLiteConnection) {
        for (RoomDatabase.Callback onOpen : getCallbacks()) {
            onOpen.onOpen(sQLiteConnection);
        }
    }

    private final void updateIdentity(SQLiteConnection sQLiteConnection) {
        createMasterTableIfNotExists(sQLiteConnection);
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.createInsertQuery(getOpenDelegate().getIdentityHash()));
    }

    /* access modifiers changed from: protected */
    public abstract List<RoomDatabase.Callback> getCallbacks();

    /* access modifiers changed from: protected */
    public abstract DatabaseConfiguration getConfiguration();

    /* access modifiers changed from: protected */
    public final int getMaxNumberOfReaders(RoomDatabase.JournalMode journalMode) {
        t.e(journalMode, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i5 == 1) {
            return 1;
        }
        if (i5 == 2) {
            return 4;
        }
        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + journalMode + '\'').toString());
    }

    /* access modifiers changed from: protected */
    public final int getMaxNumberOfWriters(RoomDatabase.JournalMode journalMode) {
        t.e(journalMode, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return 1;
        }
        throw new IllegalStateException(("Can't get max number of writers for journal mode '" + journalMode + '\'').toString());
    }

    /* access modifiers changed from: protected */
    public abstract RoomOpenDelegate getOpenDelegate();

    /* access modifiers changed from: protected */
    public final void onCreate(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        boolean hasEmptySchema = hasEmptySchema(sQLiteConnection);
        getOpenDelegate().createAllTables(sQLiteConnection);
        if (!hasEmptySchema) {
            RoomOpenDelegate.ValidationResult onValidateSchema = getOpenDelegate().onValidateSchema(sQLiteConnection);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg).toString());
            }
        }
        updateIdentity(sQLiteConnection);
        getOpenDelegate().onCreate(sQLiteConnection);
        invokeCreateCallback(sQLiteConnection);
    }

    /* access modifiers changed from: protected */
    public final void onMigrate(SQLiteConnection sQLiteConnection, int i5, int i6) {
        t.e(sQLiteConnection, "connection");
        List<Migration> findMigrationPath = MigrationUtil.findMigrationPath(getConfiguration().migrationContainer, i5, i6);
        if (findMigrationPath != null) {
            getOpenDelegate().onPreMigrate(sQLiteConnection);
            for (Migration migrate : findMigrationPath) {
                migrate.migrate(sQLiteConnection);
            }
            RoomOpenDelegate.ValidationResult onValidateSchema = getOpenDelegate().onValidateSchema(sQLiteConnection);
            if (onValidateSchema.isValid) {
                getOpenDelegate().onPostMigrate(sQLiteConnection);
                updateIdentity(sQLiteConnection);
                return;
            }
            throw new IllegalStateException(("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg).toString());
        } else if (!MigrationUtil.isMigrationRequired(getConfiguration(), i5, i6)) {
            dropAllTables(sQLiteConnection);
            invokeDestructiveMigrationCallback(sQLiteConnection);
            getOpenDelegate().createAllTables(sQLiteConnection);
        } else {
            throw new IllegalStateException(("A migration from " + i5 + " to " + i6 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
        }
    }

    /* access modifiers changed from: protected */
    public final void onOpen(SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "connection");
        checkIdentity(sQLiteConnection);
        getOpenDelegate().onOpen(sQLiteConnection);
        invokeOpenCallback(sQLiteConnection);
        this.isConfigured = true;
    }

    public String resolveFileName$room_runtime_release(String str) {
        t.e(str, "fileName");
        return str;
    }

    public abstract <R> Object useConnection(boolean z4, p pVar, C2308e eVar);
}
