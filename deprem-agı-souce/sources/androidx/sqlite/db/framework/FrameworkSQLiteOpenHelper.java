package androidx.sqlite.db.framework;

import W2.C2223l;
import W2.m;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import d3.C2344a;
import d3.C2345b;
import java.io.File;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public static final Companion Companion = new Companion((C2633k) null);
    private static final String TAG = "SupportSQLite";
    private final boolean allowDataLossOnRecovery;
    private final SupportSQLiteOpenHelper.Callback callback;
    private final Context context;
    private final C2223l lazyDelegate;
    private final String name;
    private final boolean useNoBackupDirectory;
    private boolean writeAheadLoggingEnabled;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    private static final class DBRefHolder {
        private FrameworkSQLiteDatabase db;

        public DBRefHolder(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.db = frameworkSQLiteDatabase;
        }

        public final FrameworkSQLiteDatabase getDb() {
            return this.db;
        }

        public final void setDb(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.db = frameworkSQLiteDatabase;
        }
    }

    private static final class OpenHelper extends SQLiteOpenHelper {
        public static final Companion Companion = new Companion((C2633k) null);
        private final boolean allowDataLossOnRecovery;
        private final SupportSQLiteOpenHelper.Callback callback;
        private final Context context;
        private final DBRefHolder dbRef;
        private final ProcessLock lock;
        private boolean migrated;
        private boolean opened;

        private static final class CallbackException extends RuntimeException {
            private final CallbackName callbackName;
            private final Throwable cause;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CallbackException(CallbackName callbackName2, Throwable th) {
                super(th);
                t.e(callbackName2, "callbackName");
                t.e(th, "cause");
                this.callbackName = callbackName2;
                this.cause = th;
            }

            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            public Throwable getCause() {
                return this.cause;
            }
        }

        public enum CallbackName {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN;

            static {
                CallbackName[] $values;
                $ENTRIES = C2345b.a($values);
            }

            public static C2344a getEntries() {
                return $ENTRIES;
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final FrameworkSQLiteDatabase getWrappedDb(DBRefHolder dBRefHolder, SQLiteDatabase sQLiteDatabase) {
                t.e(dBRefHolder, "refHolder");
                t.e(sQLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase db = dBRefHolder.getDb();
                if (db != null && db.isDelegate(sQLiteDatabase)) {
                    return db;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sQLiteDatabase);
                dBRefHolder.setDb(frameworkSQLiteDatabase);
                return frameworkSQLiteDatabase;
            }

            private Companion() {
            }
        }

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName[] r0 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_CONFIGURE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_UPGRADE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_DOWNGRADE     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_OPEN     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.WhenMappings.<clinit>():void");
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public OpenHelper(android.content.Context r8, java.lang.String r9, androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.DBRefHolder r10, androidx.sqlite.db.SupportSQLiteOpenHelper.Callback r11, boolean r12) {
            /*
                r7 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.t.e(r8, r0)
                java.lang.String r0 = "dbRef"
                kotlin.jvm.internal.t.e(r10, r0)
                java.lang.String r0 = "callback"
                kotlin.jvm.internal.t.e(r11, r0)
                int r5 = r11.version
                androidx.sqlite.db.framework.g r6 = new androidx.sqlite.db.framework.g
                r6.<init>(r11, r10)
                r4 = 0
                r1 = r7
                r2 = r8
                r3 = r9
                r1.<init>(r2, r3, r4, r5, r6)
                r1.context = r2
                r1.dbRef = r10
                r1.callback = r11
                r1.allowDataLossOnRecovery = r12
                androidx.sqlite.util.ProcessLock r8 = new androidx.sqlite.util.ProcessLock
                if (r3 != 0) goto L_0x0037
                java.util.UUID r9 = java.util.UUID.randomUUID()
                java.lang.String r9 = r9.toString()
                java.lang.String r10 = "toString(...)"
                kotlin.jvm.internal.t.d(r9, r10)
                goto L_0x0038
            L_0x0037:
                r9 = r3
            L_0x0038:
                java.io.File r10 = r2.getCacheDir()
                r11 = 0
                r8.<init>(r9, r10, r11)
                r1.lock = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$DBRefHolder, androidx.sqlite.db.SupportSQLiteOpenHelper$Callback, boolean):void");
        }

        /* access modifiers changed from: private */
        public static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback callback2, DBRefHolder dBRefHolder, SQLiteDatabase sQLiteDatabase) {
            Companion companion = Companion;
            t.b(sQLiteDatabase);
            callback2.onCorruption(companion.getWrappedDb(dBRefHolder, sQLiteDatabase));
        }

        private final SQLiteDatabase getWritableOrReadableDatabase(boolean z4) {
            if (z4) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                t.b(writableDatabase);
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            t.b(readableDatabase);
            return readableDatabase;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:12|11|13|14|15|16|17) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final android.database.sqlite.SQLiteDatabase innerGetDatabase(boolean r5) {
            /*
                r4 = this;
                java.lang.String r0 = r4.getDatabaseName()
                boolean r1 = r4.opened
                if (r0 == 0) goto L_0x0035
                if (r1 != 0) goto L_0x0035
                android.content.Context r1 = r4.context
                java.io.File r1 = r1.getDatabasePath(r0)
                java.io.File r1 = r1.getParentFile()
                if (r1 == 0) goto L_0x0035
                r1.mkdirs()
                boolean r2 = r1.isDirectory()
                if (r2 != 0) goto L_0x0035
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Invalid database parent file, not a directory: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.String r2 = "SupportSQLite"
                android.util.Log.w(r2, r1)
            L_0x0035:
                android.database.sqlite.SQLiteDatabase r5 = r4.getWritableOrReadableDatabase(r5)     // Catch:{ all -> 0x003a }
                return r5
            L_0x003a:
                r1 = 500(0x1f4, double:2.47E-321)
                java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x003f }
            L_0x003f:
                android.database.sqlite.SQLiteDatabase r5 = r4.getWritableOrReadableDatabase(r5)     // Catch:{ all -> 0x0044 }
                return r5
            L_0x0044:
                r1 = move-exception
                boolean r2 = r1 instanceof androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackException
                if (r2 == 0) goto L_0x0078
                androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackException r1 = (androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackException) r1
                java.lang.Throwable r2 = r1.getCause()
                androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = r1.getCallbackName()
                int[] r3 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.WhenMappings.$EnumSwitchMapping$0
                int r1 = r1.ordinal()
                r1 = r3[r1]
                r3 = 1
                if (r1 == r3) goto L_0x0077
                r3 = 2
                if (r1 == r3) goto L_0x0077
                r3 = 3
                if (r1 == r3) goto L_0x0077
                r3 = 4
                if (r1 == r3) goto L_0x0077
                r3 = 5
                if (r1 != r3) goto L_0x0071
                boolean r1 = r2 instanceof android.database.sqlite.SQLiteException
                if (r1 == 0) goto L_0x0070
                r1 = r2
                goto L_0x0078
            L_0x0070:
                throw r2
            L_0x0071:
                W2.q r5 = new W2.q
                r5.<init>()
                throw r5
            L_0x0077:
                throw r2
            L_0x0078:
                boolean r2 = r1 instanceof android.database.sqlite.SQLiteException
                if (r2 == 0) goto L_0x0092
                if (r0 == 0) goto L_0x0092
                boolean r2 = r4.allowDataLossOnRecovery
                if (r2 == 0) goto L_0x0092
                android.content.Context r1 = r4.context
                r1.deleteDatabase(r0)
                android.database.sqlite.SQLiteDatabase r5 = r4.getWritableOrReadableDatabase(r5)     // Catch:{ CallbackException -> 0x008c }
                return r5
            L_0x008c:
                r5 = move-exception
                java.lang.Throwable r5 = r5.getCause()
                throw r5
            L_0x0092:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.innerGetDatabase(boolean):android.database.sqlite.SQLiteDatabase");
        }

        public void close() {
            try {
                ProcessLock.lock$default(this.lock, false, 1, (Object) null);
                super.close();
                this.dbRef.setDb((FrameworkSQLiteDatabase) null);
                this.opened = false;
            } finally {
                this.lock.unlock();
            }
        }

        public final boolean getAllowDataLossOnRecovery() {
            return this.allowDataLossOnRecovery;
        }

        public final SupportSQLiteOpenHelper.Callback getCallback() {
            return this.callback;
        }

        public final Context getContext() {
            return this.context;
        }

        public final DBRefHolder getDbRef() {
            return this.dbRef;
        }

        public final SupportSQLiteDatabase getSupportDatabase(boolean z4) {
            boolean z5;
            SupportSQLiteDatabase wrappedDb;
            try {
                ProcessLock processLock = this.lock;
                if (this.opened || getDatabaseName() == null) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                processLock.lock(z5);
                this.migrated = false;
                SQLiteDatabase innerGetDatabase = innerGetDatabase(z4);
                if (this.migrated) {
                    close();
                    wrappedDb = getSupportDatabase(z4);
                } else {
                    wrappedDb = getWrappedDb(innerGetDatabase);
                }
                this.lock.unlock();
                return wrappedDb;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
            t.e(sQLiteDatabase, "sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, sQLiteDatabase);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            t.e(sQLiteDatabase, "db");
            if (!this.migrated && this.callback.version != sQLiteDatabase.getVersion()) {
                sQLiteDatabase.setMaxSqlCacheSize(1);
            }
            try {
                this.callback.onConfigure(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th);
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            t.e(sQLiteDatabase, "sqLiteDatabase");
            try {
                this.callback.onCreate(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CREATE, th);
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
            t.e(sQLiteDatabase, "db");
            this.migrated = true;
            try {
                this.callback.onDowngrade(getWrappedDb(sQLiteDatabase), i5, i6);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            t.e(sQLiteDatabase, "db");
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.ON_OPEN, th);
                }
            }
            this.opened = true;
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
            t.e(sQLiteDatabase, "sqLiteDatabase");
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sQLiteDatabase), i5, i6);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteOpenHelper(Context context2, String str, SupportSQLiteOpenHelper.Callback callback2) {
        this(context2, str, callback2, false, false, 24, (C2633k) null);
        t.e(context2, "context");
        t.e(callback2, "callback");
    }

    private final OpenHelper getDelegate() {
        return (OpenHelper) this.lazyDelegate.getValue();
    }

    private static Object getDelegate$delegate(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        return frameworkSQLiteOpenHelper.lazyDelegate;
    }

    /* access modifiers changed from: private */
    public static final OpenHelper lazyDelegate$lambda$0(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        OpenHelper openHelper;
        if (frameworkSQLiteOpenHelper.name == null || !frameworkSQLiteOpenHelper.useNoBackupDirectory) {
            openHelper = new OpenHelper(frameworkSQLiteOpenHelper.context, frameworkSQLiteOpenHelper.name, new DBRefHolder((FrameworkSQLiteDatabase) null), frameworkSQLiteOpenHelper.callback, frameworkSQLiteOpenHelper.allowDataLossOnRecovery);
        } else {
            openHelper = new OpenHelper(frameworkSQLiteOpenHelper.context, new File(SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(frameworkSQLiteOpenHelper.context), frameworkSQLiteOpenHelper.name).getAbsolutePath(), new DBRefHolder((FrameworkSQLiteDatabase) null), frameworkSQLiteOpenHelper.callback, frameworkSQLiteOpenHelper.allowDataLossOnRecovery);
        }
        openHelper.setWriteAheadLoggingEnabled(frameworkSQLiteOpenHelper.writeAheadLoggingEnabled);
        return openHelper;
    }

    public void close() {
        if (this.lazyDelegate.isInitialized()) {
            getDelegate().close();
        }
    }

    public String getDatabaseName() {
        return this.name;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getSupportDatabase(false);
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    public void setWriteAheadLoggingEnabled(boolean z4) {
        if (this.lazyDelegate.isInitialized()) {
            getDelegate().setWriteAheadLoggingEnabled(z4);
        }
        this.writeAheadLoggingEnabled = z4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteOpenHelper(Context context2, String str, SupportSQLiteOpenHelper.Callback callback2, boolean z4) {
        this(context2, str, callback2, z4, false, 16, (C2633k) null);
        t.e(context2, "context");
        t.e(callback2, "callback");
    }

    public FrameworkSQLiteOpenHelper(Context context2, String str, SupportSQLiteOpenHelper.Callback callback2, boolean z4, boolean z5) {
        t.e(context2, "context");
        t.e(callback2, "callback");
        this.context = context2;
        this.name = str;
        this.callback = callback2;
        this.useNoBackupDirectory = z4;
        this.allowDataLossOnRecovery = z5;
        this.lazyDelegate = m.b(new f(this));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FrameworkSQLiteOpenHelper(android.content.Context r2, java.lang.String r3, androidx.sqlite.db.SupportSQLiteOpenHelper.Callback r4, boolean r5, boolean r6, int r7, kotlin.jvm.internal.C2633k r8) {
        /*
            r1 = this;
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto L_0x0006
            r5 = r0
        L_0x0006:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x0011
            r7 = r0
        L_0x000b:
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x0013
        L_0x0011:
            r7 = r6
            goto L_0x000b
        L_0x0013:
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Callback, boolean, boolean, int, kotlin.jvm.internal.k):void");
    }
}
