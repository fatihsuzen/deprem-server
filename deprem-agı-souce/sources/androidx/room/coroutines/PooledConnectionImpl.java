package androidx.room.coroutines;

import W2.C2219h;
import X2.C2241h;
import android.database.SQLException;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import b3.C2308e;
import j.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.C2616a;
import k3.l;
import k3.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;

final class PooledConnectionImpl implements Transactor, RawConnectionAccessor {
    private final AtomicBoolean _isRecycled = new AtomicBoolean(false);
    private final ConnectionWithLock delegate;
    private final boolean isReadOnly;
    /* access modifiers changed from: private */
    public final C2241h transactionStack = new C2241h();

    private final class StatementWrapper implements SQLiteStatement {
        private final SQLiteStatement delegate;
        final /* synthetic */ PooledConnectionImpl this$0;
        private final long threadId = ThreadLocal_jvmAndroidKt.currentThreadId();

        public StatementWrapper(PooledConnectionImpl pooledConnectionImpl, SQLiteStatement sQLiteStatement) {
            t.e(sQLiteStatement, "delegate");
            this.this$0 = pooledConnectionImpl;
            this.delegate = sQLiteStatement;
        }

        private final <R> R withStateCheck(C2616a aVar) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return aVar.invoke();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public void bindBlob(int i5, byte[] bArr) {
            t.e(bArr, "value");
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.bindBlob(i5, bArr);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public /* synthetic */ void bindBoolean(int i5, boolean z4) {
            a.a(this, i5, z4);
        }

        public void bindDouble(int i5, double d5) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.bindDouble(i5, d5);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public /* synthetic */ void bindFloat(int i5, float f5) {
            a.b(this, i5, f5);
        }

        public /* synthetic */ void bindInt(int i5, int i6) {
            a.c(this, i5, i6);
        }

        public void bindLong(int i5, long j5) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.bindLong(i5, j5);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public void bindNull(int i5) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.bindNull(i5);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public void bindText(int i5, String str) {
            t.e(str, "value");
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.bindText(i5, str);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public void clearBindings() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.clearBindings();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public void close() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.close();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public byte[] getBlob(int i5) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getBlob(i5);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public /* synthetic */ boolean getBoolean(int i5) {
            return a.d(this, i5);
        }

        public int getColumnCount() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnCount();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public String getColumnName(int i5) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnName(i5);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public /* synthetic */ List getColumnNames() {
            return a.e(this);
        }

        public int getColumnType(int i5) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnType(i5);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public double getDouble(int i5) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getDouble(i5);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public /* synthetic */ float getFloat(int i5) {
            return a.f(this, i5);
        }

        public /* synthetic */ int getInt(int i5) {
            return a.g(this, i5);
        }

        public long getLong(int i5) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getLong(i5);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public String getText(int i5) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getText(i5);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public boolean isNull(int i5) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.isNull(i5);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public void reset() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.reset();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }

        public boolean step() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new C2219h();
            } else if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.step();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new C2219h();
            }
        }
    }

    private final class TransactionImpl<T> implements TransactionScope<T>, RawConnectionAccessor {
        public TransactionImpl() {
        }

        public SQLiteConnection getRawConnection() {
            return PooledConnectionImpl.this.getRawConnection();
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object rollback(T r8, b3.C2308e r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1
                if (r0 == 0) goto L_0x0013
                r0 = r9
                androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1
                r0.<init>(r7, r9)
            L_0x0018:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.label
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L_0x003c
                if (r2 == r3) goto L_0x002e
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L_0x002e:
                java.lang.Object r8 = r0.L$2
                F3.a r8 = (F3.a) r8
                java.lang.Object r1 = r0.L$1
                androidx.room.coroutines.PooledConnectionImpl r1 = (androidx.room.coroutines.PooledConnectionImpl) r1
                java.lang.Object r0 = r0.L$0
                W2.u.b(r9)
                goto L_0x007d
            L_0x003c:
                W2.u.b(r9)
                androidx.room.coroutines.PooledConnectionImpl r9 = androidx.room.coroutines.PooledConnectionImpl.this
                boolean r2 = r9.isRecycled()
                r5 = 21
                if (r2 != 0) goto L_0x00ad
                b3.i r2 = r0.getContext()
                androidx.room.coroutines.ConnectionElement$Key r6 = androidx.room.coroutines.ConnectionElement.Key
                b3.i$b r2 = r2.get(r6)
                androidx.room.coroutines.ConnectionElement r2 = (androidx.room.coroutines.ConnectionElement) r2
                if (r2 == 0) goto L_0x00a2
                androidx.room.coroutines.PooledConnectionImpl r2 = r2.getConnectionWrapper()
                if (r2 != r9) goto L_0x00a2
                X2.h r2 = r9.transactionStack
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x009a
                androidx.room.coroutines.ConnectionWithLock r2 = r9.getDelegate()
                r0.L$0 = r8
                r0.L$1 = r9
                r0.L$2 = r2
                r0.label = r3
                java.lang.Object r0 = r2.lock(r4, r0)
                if (r0 != r1) goto L_0x007a
                return r1
            L_0x007a:
                r0 = r8
                r1 = r9
                r8 = r2
            L_0x007d:
                X2.h r9 = r1.transactionStack     // Catch:{ all -> 0x0095 }
                java.lang.Object r9 = r9.last()     // Catch:{ all -> 0x0095 }
                androidx.room.coroutines.PooledConnectionImpl$TransactionItem r9 = (androidx.room.coroutines.PooledConnectionImpl.TransactionItem) r9     // Catch:{ all -> 0x0095 }
                r9.setShouldRollback(r3)     // Catch:{ all -> 0x0095 }
                W2.J r9 = W2.J.f19942a     // Catch:{ all -> 0x0095 }
                r8.unlock(r4)
                androidx.room.coroutines.ConnectionPool$RollbackException r8 = new androidx.room.coroutines.ConnectionPool$RollbackException
                r8.<init>(r0)
                throw r8
            L_0x0095:
                r9 = move-exception
                r8.unlock(r4)
                throw r9
            L_0x009a:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "Not in a transaction"
                r8.<init>(r9)
                throw r8
            L_0x00a2:
                java.lang.String r8 = "Attempted to use connection on a different coroutine"
                androidx.sqlite.SQLite.throwSQLiteException(r5, r8)
                W2.h r8 = new W2.h
                r8.<init>()
                throw r8
            L_0x00ad:
                java.lang.String r8 = "Connection is recycled"
                androidx.sqlite.SQLite.throwSQLiteException(r5, r8)
                W2.h r8 = new W2.h
                r8.<init>()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.TransactionImpl.rollback(java.lang.Object, b3.e):java.lang.Object");
        }

        public <R> Object usePrepared(String str, l lVar, C2308e eVar) {
            return PooledConnectionImpl.this.usePrepared(str, lVar, eVar);
        }

        public <R> Object withNestedTransaction(p pVar, C2308e eVar) {
            PooledConnectionImpl pooledConnectionImpl = PooledConnectionImpl.this;
            if (!pooledConnectionImpl.isRecycled()) {
                ConnectionElement connectionElement = (ConnectionElement) eVar.getContext().get(ConnectionElement.Key);
                if (connectionElement != null && connectionElement.getConnectionWrapper() == pooledConnectionImpl) {
                    return pooledConnectionImpl.transaction((Transactor.SQLiteTransactionType) null, pVar, eVar);
                }
                SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
                throw new C2219h();
            }
            SQLite.throwSQLiteException(21, "Connection is recycled");
            throw new C2219h();
        }
    }

    private static final class TransactionItem {
        private final int id;
        private boolean shouldRollback;

        public TransactionItem(int i5, boolean z4) {
            this.id = i5;
            this.shouldRollback = z4;
        }

        public final int getId() {
            return this.id;
        }

        public final boolean getShouldRollback() {
            return this.shouldRollback;
        }

        public final void setShouldRollback(boolean z4) {
            this.shouldRollback = z4;
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.WhenMappings.<clinit>():void");
        }
    }

    public PooledConnectionImpl(ConnectionWithLock connectionWithLock, boolean z4) {
        t.e(connectionWithLock, "delegate");
        this.delegate = connectionWithLock;
        this.isReadOnly = z4;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063 A[Catch:{ all -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0093 A[Catch:{ all -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object beginTransaction(androidx.room.Transactor.SQLiteTransactionType r6, b3.C2308e r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r6 = r0.L$2
            F3.a r6 = (F3.a) r6
            java.lang.Object r1 = r0.L$1
            androidx.room.Transactor$SQLiteTransactionType r1 = (androidx.room.Transactor.SQLiteTransactionType) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.PooledConnectionImpl r0 = (androidx.room.coroutines.PooledConnectionImpl) r0
            W2.u.b(r7)
            r7 = r6
            r6 = r1
            goto L_0x0055
        L_0x0038:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0040:
            W2.u.b(r7)
            androidx.room.coroutines.ConnectionWithLock r7 = r5.delegate
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r0 = r5
        L_0x0055:
            X2.h r1 = r0.transactionStack     // Catch:{ all -> 0x007b }
            int r1 = r1.size()     // Catch:{ all -> 0x007b }
            X2.h r2 = r0.transactionStack     // Catch:{ all -> 0x007b }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x007b }
            if (r2 == 0) goto L_0x0093
            int[] r2 = androidx.room.coroutines.PooledConnectionImpl.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x007b }
            int r6 = r6.ordinal()     // Catch:{ all -> 0x007b }
            r6 = r2[r6]     // Catch:{ all -> 0x007b }
            if (r6 == r3) goto L_0x008b
            r2 = 2
            if (r6 == r2) goto L_0x0083
            r2 = 3
            if (r6 != r2) goto L_0x007d
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch:{ all -> 0x007b }
            java.lang.String r2 = "BEGIN EXCLUSIVE TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r6, r2)     // Catch:{ all -> 0x007b }
            goto L_0x00ae
        L_0x007b:
            r6 = move-exception
            goto L_0x00bf
        L_0x007d:
            W2.q r6 = new W2.q     // Catch:{ all -> 0x007b }
            r6.<init>()     // Catch:{ all -> 0x007b }
            throw r6     // Catch:{ all -> 0x007b }
        L_0x0083:
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch:{ all -> 0x007b }
            java.lang.String r2 = "BEGIN IMMEDIATE TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r6, r2)     // Catch:{ all -> 0x007b }
            goto L_0x00ae
        L_0x008b:
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch:{ all -> 0x007b }
            java.lang.String r2 = "BEGIN DEFERRED TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r6, r2)     // Catch:{ all -> 0x007b }
            goto L_0x00ae
        L_0x0093:
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch:{ all -> 0x007b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x007b }
            r2.<init>()     // Catch:{ all -> 0x007b }
            java.lang.String r3 = "SAVEPOINT '"
            r2.append(r3)     // Catch:{ all -> 0x007b }
            r2.append(r1)     // Catch:{ all -> 0x007b }
            r3 = 39
            r2.append(r3)     // Catch:{ all -> 0x007b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x007b }
            androidx.sqlite.SQLite.execSQL(r6, r2)     // Catch:{ all -> 0x007b }
        L_0x00ae:
            X2.h r6 = r0.transactionStack     // Catch:{ all -> 0x007b }
            androidx.room.coroutines.PooledConnectionImpl$TransactionItem r0 = new androidx.room.coroutines.PooledConnectionImpl$TransactionItem     // Catch:{ all -> 0x007b }
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x007b }
            r6.addLast(r0)     // Catch:{ all -> 0x007b }
            W2.J r6 = W2.J.f19942a     // Catch:{ all -> 0x007b }
            r7.unlock(r4)
            return r6
        L_0x00bf:
            r7.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.beginTransaction(androidx.room.Transactor$SQLiteTransactionType, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cf A[SYNTHETIC, Splitter:B:36:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object endTransaction(boolean r6, b3.C2308e r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.coroutines.PooledConnectionImpl$endTransaction$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.room.coroutines.PooledConnectionImpl$endTransaction$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$endTransaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.coroutines.PooledConnectionImpl$endTransaction$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$endTransaction$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            boolean r6 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            F3.a r1 = (F3.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.PooledConnectionImpl r0 = (androidx.room.coroutines.PooledConnectionImpl) r0
            W2.u.b(r7)
            goto L_0x0052
        L_0x0034:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003c:
            W2.u.b(r7)
            androidx.room.coroutines.ConnectionWithLock r7 = r5.delegate
            r0.L$0 = r5
            r0.L$1 = r7
            r0.Z$0 = r6
            r0.label = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r0 = r5
            r1 = r7
        L_0x0052:
            X2.h r7 = r0.transactionStack     // Catch:{ all -> 0x007c }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x007c }
            if (r7 != 0) goto L_0x00cf
            X2.h r7 = r0.transactionStack     // Catch:{ all -> 0x007c }
            java.lang.Object r7 = X2.C2250q.z(r7)     // Catch:{ all -> 0x007c }
            androidx.room.coroutines.PooledConnectionImpl$TransactionItem r7 = (androidx.room.coroutines.PooledConnectionImpl.TransactionItem) r7     // Catch:{ all -> 0x007c }
            r2 = 39
            if (r6 == 0) goto L_0x009c
            boolean r6 = r7.getShouldRollback()     // Catch:{ all -> 0x007c }
            if (r6 != 0) goto L_0x009c
            X2.h r6 = r0.transactionStack     // Catch:{ all -> 0x007c }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x007c }
            if (r6 == 0) goto L_0x007e
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch:{ all -> 0x007c }
            java.lang.String r7 = "END TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r6, r7)     // Catch:{ all -> 0x007c }
            goto L_0x00c9
        L_0x007c:
            r6 = move-exception
            goto L_0x00d7
        L_0x007e:
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r0.<init>()     // Catch:{ all -> 0x007c }
            java.lang.String r3 = "RELEASE SAVEPOINT '"
            r0.append(r3)     // Catch:{ all -> 0x007c }
            int r7 = r7.getId()     // Catch:{ all -> 0x007c }
            r0.append(r7)     // Catch:{ all -> 0x007c }
            r0.append(r2)     // Catch:{ all -> 0x007c }
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x007c }
            androidx.sqlite.SQLite.execSQL(r6, r7)     // Catch:{ all -> 0x007c }
            goto L_0x00c9
        L_0x009c:
            X2.h r6 = r0.transactionStack     // Catch:{ all -> 0x007c }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x007c }
            if (r6 == 0) goto L_0x00ac
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch:{ all -> 0x007c }
            java.lang.String r7 = "ROLLBACK TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r6, r7)     // Catch:{ all -> 0x007c }
            goto L_0x00c9
        L_0x00ac:
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r0.<init>()     // Catch:{ all -> 0x007c }
            java.lang.String r3 = "ROLLBACK TRANSACTION TO SAVEPOINT '"
            r0.append(r3)     // Catch:{ all -> 0x007c }
            int r7 = r7.getId()     // Catch:{ all -> 0x007c }
            r0.append(r7)     // Catch:{ all -> 0x007c }
            r0.append(r2)     // Catch:{ all -> 0x007c }
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x007c }
            androidx.sqlite.SQLite.execSQL(r6, r7)     // Catch:{ all -> 0x007c }
        L_0x00c9:
            W2.J r6 = W2.J.f19942a     // Catch:{ all -> 0x007c }
            r1.unlock(r4)
            return r6
        L_0x00cf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r7 = "Not in a transaction"
            r6.<init>(r7)     // Catch:{ all -> 0x007c }
            throw r6     // Catch:{ all -> 0x007c }
        L_0x00d7:
            r1.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.endTransaction(boolean, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final boolean isRecycled() {
        return this._isRecycled.get();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: k3.p} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d0, code lost:
        if (r13.endTransaction(false, r0) != r1) goto L_0x00da;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> java.lang.Object transaction(androidx.room.Transactor.SQLiteTransactionType r12, k3.p r13, b3.C2308e r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof androidx.room.coroutines.PooledConnectionImpl$transaction$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            androidx.room.coroutines.PooledConnectionImpl$transaction$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$transaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.coroutines.PooledConnectionImpl$transaction$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$transaction$1
            r0.<init>(r11, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            r9 = 0
            if (r2 == 0) goto L_0x006a
            if (r2 == r8) goto L_0x005d
            if (r2 == r6) goto L_0x0051
            if (r2 == r5) goto L_0x004b
            if (r2 == r4) goto L_0x004b
            if (r2 == r3) goto L_0x003b
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003b:
            java.lang.Object r12 = r0.L$1
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            java.lang.Object r13 = r0.L$0
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            W2.u.b(r14)     // Catch:{ SQLException -> 0x0048 }
            goto L_0x00da
        L_0x0048:
            r14 = move-exception
            goto L_0x00d5
        L_0x004b:
            java.lang.Object r12 = r0.L$0
            W2.u.b(r14)
            return r12
        L_0x0051:
            int r12 = r0.I$0
            java.lang.Object r13 = r0.L$0
            androidx.room.coroutines.PooledConnectionImpl r13 = (androidx.room.coroutines.PooledConnectionImpl) r13
            W2.u.b(r14)     // Catch:{ all -> 0x005b }
            goto L_0x0095
        L_0x005b:
            r12 = move-exception
            goto L_0x00a8
        L_0x005d:
            java.lang.Object r12 = r0.L$1
            r13 = r12
            k3.p r13 = (k3.p) r13
            java.lang.Object r12 = r0.L$0
            androidx.room.coroutines.PooledConnectionImpl r12 = (androidx.room.coroutines.PooledConnectionImpl) r12
            W2.u.b(r14)
            goto L_0x007f
        L_0x006a:
            W2.u.b(r14)
            if (r12 != 0) goto L_0x0071
            androidx.room.Transactor$SQLiteTransactionType r12 = androidx.room.Transactor.SQLiteTransactionType.DEFERRED
        L_0x0071:
            r0.L$0 = r11
            r0.L$1 = r13
            r0.label = r8
            java.lang.Object r12 = r11.beginTransaction(r12, r0)
            if (r12 != r1) goto L_0x007e
            goto L_0x00d2
        L_0x007e:
            r12 = r11
        L_0x007f:
            androidx.room.coroutines.PooledConnectionImpl$TransactionImpl r14 = new androidx.room.coroutines.PooledConnectionImpl$TransactionImpl     // Catch:{ all -> 0x00a4 }
            r14.<init>()     // Catch:{ all -> 0x00a4 }
            r0.L$0 = r12     // Catch:{ all -> 0x00a4 }
            r0.L$1 = r9     // Catch:{ all -> 0x00a4 }
            r0.I$0 = r8     // Catch:{ all -> 0x00a4 }
            r0.label = r6     // Catch:{ all -> 0x00a4 }
            java.lang.Object r14 = r13.invoke(r14, r0)     // Catch:{ all -> 0x00a4 }
            if (r14 != r1) goto L_0x0093
            goto L_0x00d2
        L_0x0093:
            r13 = r12
            r12 = r8
        L_0x0095:
            if (r12 == 0) goto L_0x0098
            r7 = r8
        L_0x0098:
            r0.L$0 = r14
            r0.label = r5
            java.lang.Object r12 = r13.endTransaction(r7, r0)
            if (r12 != r1) goto L_0x00a3
            goto L_0x00d2
        L_0x00a3:
            return r14
        L_0x00a4:
            r13 = move-exception
            r10 = r13
            r13 = r12
            r12 = r10
        L_0x00a8:
            boolean r14 = r12 instanceof androidx.room.coroutines.ConnectionPool.RollbackException     // Catch:{ all -> 0x00c0 }
            if (r14 == 0) goto L_0x00c2
            androidx.room.coroutines.ConnectionPool$RollbackException r12 = (androidx.room.coroutines.ConnectionPool.RollbackException) r12     // Catch:{ all -> 0x00c0 }
            java.lang.Object r12 = r12.getResult()     // Catch:{ all -> 0x00c0 }
            r0.L$0 = r12
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r13 = r13.endTransaction(r7, r0)
            if (r13 != r1) goto L_0x00bf
            goto L_0x00d2
        L_0x00bf:
            return r12
        L_0x00c0:
            r12 = move-exception
            goto L_0x00c6
        L_0x00c2:
            throw r12     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r14 = move-exception
            r9 = r12
            r12 = r14
        L_0x00c6:
            r0.L$0 = r9     // Catch:{ SQLException -> 0x00d3 }
            r0.L$1 = r12     // Catch:{ SQLException -> 0x00d3 }
            r0.label = r3     // Catch:{ SQLException -> 0x00d3 }
            java.lang.Object r13 = r13.endTransaction(r7, r0)     // Catch:{ SQLException -> 0x00d3 }
            if (r13 != r1) goto L_0x00da
        L_0x00d2:
            return r1
        L_0x00d3:
            r14 = move-exception
            r13 = r9
        L_0x00d5:
            if (r13 == 0) goto L_0x00db
            W2.C2216e.a(r13, r14)
        L_0x00da:
            throw r12
        L_0x00db:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.transaction(androidx.room.Transactor$SQLiteTransactionType, k3.p, b3.e):java.lang.Object");
    }

    private final <R> Object withStateCheck(C2616a aVar, C2308e eVar) {
        if (isRecycled()) {
            SQLite.throwSQLiteException(21, "Connection is recycled");
            throw new C2219h();
        }
        r.c(3);
        throw null;
    }

    public final ConnectionWithLock getDelegate() {
        return this.delegate;
    }

    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    public Object inTransaction(C2308e eVar) {
        if (!isRecycled()) {
            ConnectionElement connectionElement = (ConnectionElement) eVar.getContext().get(ConnectionElement.Key);
            if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
                return b.a(!this.transactionStack.isEmpty());
            }
            SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
            throw new C2219h();
        }
        SQLite.throwSQLiteException(21, "Connection is recycled");
        throw new C2219h();
    }

    public final boolean isReadOnly() {
        return this.isReadOnly;
    }

    public final void markRecycled() {
        if (this._isRecycled.compareAndSet(false, true)) {
            try {
                SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
            } catch (SQLException unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0091, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        i3.C2579a.a(r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0095, code lost:
        throw r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> java.lang.Object usePrepared(java.lang.String r7, k3.l r8, b3.C2308e r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$usePrepared$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r7 = r0.L$3
            F3.a r7 = (F3.a) r7
            java.lang.Object r8 = r0.L$2
            k3.l r8 = (k3.l) r8
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.PooledConnectionImpl r0 = (androidx.room.coroutines.PooledConnectionImpl) r0
            W2.u.b(r9)
            r9 = r7
            r7 = r1
            goto L_0x0077
        L_0x003c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0044:
            W2.u.b(r9)
            boolean r9 = r6.isRecycled()
            r2 = 21
            if (r9 != 0) goto L_0x00a5
            b3.i r9 = r0.getContext()
            androidx.room.coroutines.ConnectionElement$Key r5 = androidx.room.coroutines.ConnectionElement.Key
            b3.i$b r9 = r9.get(r5)
            androidx.room.coroutines.ConnectionElement r9 = (androidx.room.coroutines.ConnectionElement) r9
            if (r9 == 0) goto L_0x009a
            androidx.room.coroutines.PooledConnectionImpl r9 = r9.getConnectionWrapper()
            if (r9 != r6) goto L_0x009a
            androidx.room.coroutines.ConnectionWithLock r9 = r6.delegate
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.L$3 = r9
            r0.label = r3
            java.lang.Object r0 = r9.lock(r4, r0)
            if (r0 != r1) goto L_0x0076
            return r1
        L_0x0076:
            r0 = r6
        L_0x0077:
            androidx.room.coroutines.PooledConnectionImpl$StatementWrapper r1 = new androidx.room.coroutines.PooledConnectionImpl$StatementWrapper     // Catch:{ all -> 0x008d }
            androidx.room.coroutines.ConnectionWithLock r2 = r0.delegate     // Catch:{ all -> 0x008d }
            androidx.sqlite.SQLiteStatement r7 = r2.prepare(r7)     // Catch:{ all -> 0x008d }
            r1.<init>(r0, r7)     // Catch:{ all -> 0x008d }
            java.lang.Object r7 = r8.invoke(r1)     // Catch:{ all -> 0x008f }
            i3.C2579a.a(r1, r4)     // Catch:{ all -> 0x008d }
            r9.unlock(r4)
            return r7
        L_0x008d:
            r7 = move-exception
            goto L_0x0096
        L_0x008f:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r8 = move-exception
            i3.C2579a.a(r1, r7)     // Catch:{ all -> 0x008d }
            throw r8     // Catch:{ all -> 0x008d }
        L_0x0096:
            r9.unlock(r4)
            throw r7
        L_0x009a:
            java.lang.String r7 = "Attempted to use connection on a different coroutine"
            androidx.sqlite.SQLite.throwSQLiteException(r2, r7)
            W2.h r7 = new W2.h
            r7.<init>()
            throw r7
        L_0x00a5:
            java.lang.String r7 = "Connection is recycled"
            androidx.sqlite.SQLite.throwSQLiteException(r2, r7)
            W2.h r7 = new W2.h
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.usePrepared(java.lang.String, k3.l, b3.e):java.lang.Object");
    }

    public <R> Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, p pVar, C2308e eVar) {
        if (!isRecycled()) {
            ConnectionElement connectionElement = (ConnectionElement) eVar.getContext().get(ConnectionElement.Key);
            if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
                return transaction(sQLiteTransactionType, pVar, eVar);
            }
            SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
            throw new C2219h();
        }
        SQLite.throwSQLiteException(21, "Connection is recycled");
        throw new C2219h();
    }
}
