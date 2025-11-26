package androidx.room.coroutines;

import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.coroutines.ConnectionPool;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.driver.AndroidSQLiteConnection;
import b3.C2308e;
import k3.l;
import k3.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.jvm.internal.t;

final class AndroidSQLiteDriverPooledConnection implements Transactor, RawConnectionAccessor {
    /* access modifiers changed from: private */
    public Transactor.SQLiteTransactionType currentTransactionType;
    private final AndroidSQLiteConnection delegate;

    private final class AndroidSQLiteDriverTransactor<T> implements TransactionScope<T>, RawConnectionAccessor {
        public AndroidSQLiteDriverTransactor() {
        }

        public SQLiteConnection getRawConnection() {
            return AndroidSQLiteDriverPooledConnection.this.getRawConnection();
        }

        public Object rollback(T t5, C2308e eVar) {
            throw new ConnectionPool.RollbackException(t5);
        }

        public <R> Object usePrepared(String str, l lVar, C2308e eVar) {
            return AndroidSQLiteDriverPooledConnection.this.usePrepared(str, lVar, eVar);
        }

        public <R> Object withNestedTransaction(p pVar, C2308e eVar) {
            AndroidSQLiteDriverPooledConnection androidSQLiteDriverPooledConnection = AndroidSQLiteDriverPooledConnection.this;
            Transactor.SQLiteTransactionType access$getCurrentTransactionType$p = androidSQLiteDriverPooledConnection.currentTransactionType;
            if (access$getCurrentTransactionType$p != null) {
                return androidSQLiteDriverPooledConnection.transaction(access$getCurrentTransactionType$p, pVar, eVar);
            }
            throw new IllegalStateException("Required value was null.");
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.room.Transactor$SQLiteTransactionType[] r0 = androidx.room.Transactor.SQLiteTransactionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.room.Transactor$SQLiteTransactionType r1 = androidx.room.Transactor.SQLiteTransactionType.DEFERRED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.room.Transactor$SQLiteTransactionType r1 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.room.Transactor$SQLiteTransactionType r1 = androidx.room.Transactor.SQLiteTransactionType.EXCLUSIVE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.AndroidSQLiteDriverPooledConnection.WhenMappings.<clinit>():void");
        }
    }

    public AndroidSQLiteDriverPooledConnection(AndroidSQLiteConnection androidSQLiteConnection) {
        t.e(androidSQLiteConnection, "delegate");
        this.delegate = androidSQLiteConnection;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> java.lang.Object transaction(androidx.room.Transactor.SQLiteTransactionType r6, k3.p r7, b3.C2308e r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1 r0 = (androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1 r0 = new androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r4) goto L_0x0038
            java.lang.Object r6 = r0.L$1
            android.database.sqlite.SQLiteDatabase r6 = (android.database.sqlite.SQLiteDatabase) r6
            java.lang.Object r7 = r0.L$0
            androidx.room.coroutines.AndroidSQLiteDriverPooledConnection r7 = (androidx.room.coroutines.AndroidSQLiteDriverPooledConnection) r7
            W2.u.b(r8)     // Catch:{ RollbackException -> 0x0035 }
            goto L_0x0088
        L_0x0032:
            r8 = move-exception
            goto L_0x00b2
        L_0x0035:
            r8 = move-exception
            goto L_0x00a2
        L_0x0038:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0040:
            W2.u.b(r8)
            androidx.sqlite.driver.AndroidSQLiteConnection r8 = r5.delegate
            android.database.sqlite.SQLiteDatabase r8 = r8.getDb()
            boolean r2 = r8.inTransaction()
            if (r2 != 0) goto L_0x0051
            r5.currentTransactionType = r6
        L_0x0051:
            int[] r2 = androidx.room.coroutines.AndroidSQLiteDriverPooledConnection.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r2[r6]
            if (r6 == r4) goto L_0x006f
            r2 = 2
            if (r6 == r2) goto L_0x006b
            r2 = 3
            if (r6 != r2) goto L_0x0065
            r8.beginTransaction()
            goto L_0x0072
        L_0x0065:
            W2.q r6 = new W2.q
            r6.<init>()
            throw r6
        L_0x006b:
            r8.beginTransactionNonExclusive()
            goto L_0x0072
        L_0x006f:
            r8.beginTransactionNonExclusive()
        L_0x0072:
            androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$AndroidSQLiteDriverTransactor r6 = new androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$AndroidSQLiteDriverTransactor     // Catch:{ RollbackException -> 0x009d, all -> 0x0097 }
            r6.<init>()     // Catch:{ RollbackException -> 0x009d, all -> 0x0097 }
            r0.L$0 = r5     // Catch:{ RollbackException -> 0x009d, all -> 0x0097 }
            r0.L$1 = r8     // Catch:{ RollbackException -> 0x009d, all -> 0x0097 }
            r0.label = r4     // Catch:{ RollbackException -> 0x009d, all -> 0x0097 }
            java.lang.Object r6 = r7.invoke(r6, r0)     // Catch:{ RollbackException -> 0x009d, all -> 0x0097 }
            if (r6 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L_0x0088:
            r6.setTransactionSuccessful()     // Catch:{ RollbackException -> 0x0035 }
            r6.endTransaction()
            boolean r6 = r6.inTransaction()
            if (r6 != 0) goto L_0x0096
            r7.currentTransactionType = r3
        L_0x0096:
            return r8
        L_0x0097:
            r6 = move-exception
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L_0x00b2
        L_0x009d:
            r6 = move-exception
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L_0x00a2:
            java.lang.Object r8 = r8.getResult()     // Catch:{ all -> 0x0032 }
            r6.endTransaction()
            boolean r6 = r6.inTransaction()
            if (r6 != 0) goto L_0x00b1
            r7.currentTransactionType = r3
        L_0x00b1:
            return r8
        L_0x00b2:
            r6.endTransaction()
            boolean r6 = r6.inTransaction()
            if (r6 != 0) goto L_0x00bd
            r7.currentTransactionType = r3
        L_0x00bd:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.AndroidSQLiteDriverPooledConnection.transaction(androidx.room.Transactor$SQLiteTransactionType, k3.p, b3.e):java.lang.Object");
    }

    public final AndroidSQLiteConnection getDelegate() {
        return this.delegate;
    }

    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    public Object inTransaction(C2308e eVar) {
        return b.a(this.delegate.getDb().inTransaction());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        i3.C2579a.a(r1, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> java.lang.Object usePrepared(java.lang.String r1, k3.l r2, b3.C2308e r3) {
        /*
            r0 = this;
            androidx.sqlite.driver.AndroidSQLiteConnection r3 = r0.delegate
            androidx.sqlite.SQLiteStatement r1 = r3.prepare(r1)
            java.lang.Object r2 = r2.invoke(r1)     // Catch:{ all -> 0x000f }
            r3 = 0
            i3.C2579a.a(r1, r3)
            return r2
        L_0x000f:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0011 }
        L_0x0011:
            r3 = move-exception
            i3.C2579a.a(r1, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.AndroidSQLiteDriverPooledConnection.usePrepared(java.lang.String, k3.l, b3.e):java.lang.Object");
    }

    public <R> Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, p pVar, C2308e eVar) {
        return transaction(sQLiteTransactionType, pVar, eVar);
    }
}
