package androidx.room.coroutines;

import W2.C2219h;
import W2.y;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import b3.C2308e;
import b3.C2312i;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import u3.C2795a;
import u3.C2797c;
import u3.C2798d;
import w3.Z0;

public final class ConnectionPoolImpl implements ConnectionPool {
    private final AtomicBoolean _isClosed = new AtomicBoolean(false);
    private final SQLiteDriver driver;
    private final Pool readers;
    private final ThreadLocal<PooledConnectionImpl> threadLocal = new ThreadLocal<>();
    private long timeout;
    private final Pool writers;

    public ConnectionPoolImpl(SQLiteDriver sQLiteDriver, String str) {
        t.e(sQLiteDriver, "driver");
        t.e(str, "fileName");
        C2795a.C0262a aVar = C2795a.f25994b;
        this.timeout = C2797c.s(30, C2798d.SECONDS);
        this.driver = sQLiteDriver;
        Pool pool = new Pool(1, new d(sQLiteDriver, str));
        this.readers = pool;
        this.writers = pool;
    }

    /* access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$0(SQLiteDriver sQLiteDriver, String str) {
        return sQLiteDriver.open(str);
    }

    /* access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$4(SQLiteDriver sQLiteDriver, String str) {
        SQLiteConnection open = sQLiteDriver.open(str);
        SQLite.execSQL(open, "PRAGMA query_only = 1");
        return open;
    }

    /* access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$5(SQLiteDriver sQLiteDriver, String str) {
        return sQLiteDriver.open(str);
    }

    private final Object acquireWithTimeout(Pool pool, C2308e eVar) {
        Object obj;
        L l5 = new L();
        try {
            long j5 = this.timeout;
            obj = null;
            ConnectionPoolImpl$acquireWithTimeout$2 connectionPoolImpl$acquireWithTimeout$2 = new ConnectionPoolImpl$acquireWithTimeout$2(l5, pool, (C2308e) null);
            r.c(0);
            Z0.d(j5, connectionPoolImpl$acquireWithTimeout$2, eVar);
            r.c(1);
        } catch (Throwable th) {
            obj = th;
        }
        return y.a(l5.f24690a, obj);
    }

    private final C2312i createConnectionContext(PooledConnectionImpl pooledConnectionImpl) {
        return new ConnectionElement(pooledConnectionImpl).plus(ThreadLocal_jvmAndroidKt.asContextElement(this.threadLocal, pooledConnectionImpl));
    }

    private final boolean isClosed() {
        return this._isClosed.get();
    }

    private final Void throwTimeoutException(boolean z4) {
        String str;
        if (z4) {
            str = "reader";
        } else {
            str = "writer";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.");
        sb.append(10);
        sb.append(10);
        sb.append("Writer pool:");
        sb.append(10);
        this.writers.dump(sb);
        sb.append("Reader pool:");
        sb.append(10);
        this.readers.dump(sb);
        SQLite.throwSQLiteException(5, sb.toString());
        throw new C2219h();
    }

    public void close() {
        if (this._isClosed.compareAndSet(false, true)) {
            this.readers.close();
            this.writers.close();
        }
    }

    /* renamed from: getTimeout-UwyO8pc$room_runtime_release  reason: not valid java name */
    public final long m66getTimeoutUwyO8pc$room_runtime_release() {
        return this.timeout;
    }

    /* renamed from: setTimeout-LRDsOJo$room_runtime_release  reason: not valid java name */
    public final void m67setTimeoutLRDsOJo$room_runtime_release(long j5) {
        this.timeout = j5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014c A[Catch:{ all -> 0x0160 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0164 A[Catch:{ all -> 0x0160 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x016b A[Catch:{ all -> 0x0160 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x018c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0194 A[Catch:{ all -> 0x01a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01af A[Catch:{ all -> 0x0160 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> java.lang.Object useConnection(boolean r18, k3.p r19, b3.C2308e r20) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r19
            r0 = r20
            boolean r4 = r0 instanceof androidx.room.coroutines.ConnectionPoolImpl$useConnection$1
            if (r4 == 0) goto L_0x001b
            r4 = r0
            androidx.room.coroutines.ConnectionPoolImpl$useConnection$1 r4 = (androidx.room.coroutines.ConnectionPoolImpl$useConnection$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.label = r5
            goto L_0x0020
        L_0x001b:
            androidx.room.coroutines.ConnectionPoolImpl$useConnection$1 r4 = new androidx.room.coroutines.ConnectionPoolImpl$useConnection$1
            r4.<init>(r1, r0)
        L_0x0020:
            java.lang.Object r0 = r4.result
            java.lang.Object r5 = c3.C2316b.f()
            int r6 = r4.label
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            r11 = 0
            if (r6 == 0) goto L_0x0081
            if (r6 == r10) goto L_0x007d
            if (r6 == r9) goto L_0x0079
            if (r6 == r8) goto L_0x0051
            if (r6 != r7) goto L_0x0049
            java.lang.Object r2 = r4.L$1
            kotlin.jvm.internal.L r2 = (kotlin.jvm.internal.L) r2
            java.lang.Object r3 = r4.L$0
            androidx.room.coroutines.Pool r3 = (androidx.room.coroutines.Pool) r3
            W2.u.b(r0)     // Catch:{ all -> 0x0044 }
            goto L_0x018e
        L_0x0044:
            r0 = move-exception
        L_0x0045:
            r9 = r2
            r2 = r0
            goto L_0x01bb
        L_0x0049:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0051:
            boolean r2 = r4.Z$0
            java.lang.Object r3 = r4.L$5
            kotlin.jvm.internal.L r3 = (kotlin.jvm.internal.L) r3
            java.lang.Object r6 = r4.L$4
            b3.i r6 = (b3.C2312i) r6
            java.lang.Object r8 = r4.L$3
            kotlin.jvm.internal.L r8 = (kotlin.jvm.internal.L) r8
            java.lang.Object r9 = r4.L$2
            androidx.room.coroutines.Pool r9 = (androidx.room.coroutines.Pool) r9
            java.lang.Object r12 = r4.L$1
            k3.p r12 = (k3.p) r12
            java.lang.Object r13 = r4.L$0
            androidx.room.coroutines.ConnectionPoolImpl r13 = (androidx.room.coroutines.ConnectionPoolImpl) r13
            W2.u.b(r0)     // Catch:{ all -> 0x0070 }
            goto L_0x0125
        L_0x0070:
            r0 = move-exception
            r16 = r13
            r13 = r3
            r3 = r12
            r12 = r16
            goto L_0x0131
        L_0x0079:
            W2.u.b(r0)
            return r0
        L_0x007d:
            W2.u.b(r0)
            return r0
        L_0x0081:
            W2.u.b(r0)
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L_0x01db
            java.lang.ThreadLocal<androidx.room.coroutines.PooledConnectionImpl> r0 = r1.threadLocal
            java.lang.Object r0 = r0.get()
            androidx.room.coroutines.PooledConnectionImpl r0 = (androidx.room.coroutines.PooledConnectionImpl) r0
            if (r0 != 0) goto L_0x00a8
            b3.i r0 = r4.getContext()
            androidx.room.coroutines.ConnectionElement$Key r6 = androidx.room.coroutines.ConnectionElement.Key
            b3.i$b r0 = r0.get(r6)
            androidx.room.coroutines.ConnectionElement r0 = (androidx.room.coroutines.ConnectionElement) r0
            if (r0 == 0) goto L_0x00a7
            androidx.room.coroutines.PooledConnectionImpl r0 = r0.getConnectionWrapper()
            goto L_0x00a8
        L_0x00a7:
            r0 = r11
        L_0x00a8:
            if (r0 == 0) goto L_0x00e9
            if (r2 != 0) goto L_0x00be
            boolean r2 = r0.isReadOnly()
            if (r2 != 0) goto L_0x00b3
            goto L_0x00be
        L_0x00b3:
            java.lang.String r0 = "Cannot upgrade connection from reader to writer"
            androidx.sqlite.SQLite.throwSQLiteException(r10, r0)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        L_0x00be:
            b3.i r2 = r4.getContext()
            androidx.room.coroutines.ConnectionElement$Key r6 = androidx.room.coroutines.ConnectionElement.Key
            b3.i$b r2 = r2.get(r6)
            if (r2 != 0) goto L_0x00de
            b3.i r2 = r1.createConnectionContext(r0)
            androidx.room.coroutines.ConnectionPoolImpl$useConnection$2 r6 = new androidx.room.coroutines.ConnectionPoolImpl$useConnection$2
            r6.<init>(r3, r0, r11)
            r4.label = r10
            java.lang.Object r0 = w3.C2872g.g(r2, r6, r4)
            if (r0 != r5) goto L_0x00dd
            goto L_0x018c
        L_0x00dd:
            return r0
        L_0x00de:
            r4.label = r9
            java.lang.Object r0 = r3.invoke(r0, r4)
            if (r0 != r5) goto L_0x00e8
            goto L_0x018c
        L_0x00e8:
            return r0
        L_0x00e9:
            if (r2 == 0) goto L_0x00ef
            androidx.room.coroutines.Pool r0 = r1.readers
        L_0x00ed:
            r6 = r0
            goto L_0x00f2
        L_0x00ef:
            androidx.room.coroutines.Pool r0 = r1.writers
            goto L_0x00ed
        L_0x00f2:
            kotlin.jvm.internal.L r9 = new kotlin.jvm.internal.L
            r9.<init>()
            b3.i r12 = r4.getContext()     // Catch:{ all -> 0x01b8 }
            kotlin.jvm.internal.L r13 = new kotlin.jvm.internal.L     // Catch:{ all -> 0x01b8 }
            r13.<init>()     // Catch:{ all -> 0x01b8 }
            long r14 = r1.timeout     // Catch:{ all -> 0x012c }
            androidx.room.coroutines.ConnectionPoolImpl$acquireWithTimeout$2 r0 = new androidx.room.coroutines.ConnectionPoolImpl$acquireWithTimeout$2     // Catch:{ all -> 0x012c }
            r0.<init>(r13, r6, r11)     // Catch:{ all -> 0x012c }
            r4.L$0 = r1     // Catch:{ all -> 0x012c }
            r4.L$1 = r3     // Catch:{ all -> 0x012c }
            r4.L$2 = r6     // Catch:{ all -> 0x012c }
            r4.L$3 = r9     // Catch:{ all -> 0x012c }
            r4.L$4 = r12     // Catch:{ all -> 0x012c }
            r4.L$5 = r13     // Catch:{ all -> 0x012c }
            r4.Z$0 = r2     // Catch:{ all -> 0x012c }
            r4.label = r8     // Catch:{ all -> 0x012c }
            java.lang.Object r0 = w3.Z0.d(r14, r0, r4)     // Catch:{ all -> 0x012c }
            if (r0 != r5) goto L_0x011f
            goto L_0x018c
        L_0x011f:
            r8 = r9
            r9 = r6
            r6 = r12
            r12 = r3
            r3 = r13
            r13 = r1
        L_0x0125:
            r0 = r3
            r3 = r2
            r2 = r8
            r8 = r13
            r13 = r0
            r0 = r11
            goto L_0x0138
        L_0x012c:
            r0 = move-exception
            r8 = r9
            r9 = r6
            r6 = r12
            r12 = r1
        L_0x0131:
            r16 = r3
            r3 = r2
            r2 = r8
            r8 = r12
            r12 = r16
        L_0x0138:
            java.lang.Object r13 = r13.f24690a     // Catch:{ all -> 0x0160 }
            W2.s r0 = W2.y.a(r13, r0)     // Catch:{ all -> 0x0160 }
            java.lang.Object r13 = r0.a()     // Catch:{ all -> 0x0160 }
            androidx.room.coroutines.ConnectionWithLock r13 = (androidx.room.coroutines.ConnectionWithLock) r13     // Catch:{ all -> 0x0160 }
            java.lang.Object r0 = r0.b()     // Catch:{ all -> 0x0160 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0160 }
            if (r13 == 0) goto L_0x0164
            androidx.room.coroutines.PooledConnectionImpl r14 = new androidx.room.coroutines.PooledConnectionImpl     // Catch:{ all -> 0x0160 }
            androidx.room.coroutines.ConnectionWithLock r6 = r13.markAcquired(r6)     // Catch:{ all -> 0x0160 }
            androidx.room.coroutines.Pool r13 = r8.readers     // Catch:{ all -> 0x0160 }
            androidx.room.coroutines.Pool r15 = r8.writers     // Catch:{ all -> 0x0160 }
            if (r13 == r15) goto L_0x015b
            if (r3 == 0) goto L_0x015b
            goto L_0x015c
        L_0x015b:
            r10 = 0
        L_0x015c:
            r14.<init>(r6, r10)     // Catch:{ all -> 0x0160 }
            goto L_0x0165
        L_0x0160:
            r0 = move-exception
            r3 = r9
            goto L_0x0045
        L_0x0164:
            r14 = r11
        L_0x0165:
            r2.f24690a = r14     // Catch:{ all -> 0x0160 }
            boolean r6 = r0 instanceof w3.X0     // Catch:{ all -> 0x0160 }
            if (r6 != 0) goto L_0x01af
            if (r0 != 0) goto L_0x01ae
            if (r14 == 0) goto L_0x01a6
            b3.i r0 = r8.createConnectionContext(r14)     // Catch:{ all -> 0x0160 }
            androidx.room.coroutines.ConnectionPoolImpl$useConnection$4 r3 = new androidx.room.coroutines.ConnectionPoolImpl$useConnection$4     // Catch:{ all -> 0x0160 }
            r3.<init>(r12, r2, r11)     // Catch:{ all -> 0x0160 }
            r4.L$0 = r9     // Catch:{ all -> 0x0160 }
            r4.L$1 = r2     // Catch:{ all -> 0x0160 }
            r4.L$2 = r11     // Catch:{ all -> 0x0160 }
            r4.L$3 = r11     // Catch:{ all -> 0x0160 }
            r4.L$4 = r11     // Catch:{ all -> 0x0160 }
            r4.L$5 = r11     // Catch:{ all -> 0x0160 }
            r4.label = r7     // Catch:{ all -> 0x0160 }
            java.lang.Object r0 = w3.C2872g.g(r0, r3, r4)     // Catch:{ all -> 0x0160 }
            if (r0 != r5) goto L_0x018d
        L_0x018c:
            return r5
        L_0x018d:
            r3 = r9
        L_0x018e:
            java.lang.Object r2 = r2.f24690a     // Catch:{ all -> 0x01a5 }
            androidx.room.coroutines.PooledConnectionImpl r2 = (androidx.room.coroutines.PooledConnectionImpl) r2     // Catch:{ all -> 0x01a5 }
            if (r2 == 0) goto L_0x01a5
            r2.markRecycled()     // Catch:{ all -> 0x01a5 }
            androidx.room.coroutines.ConnectionWithLock r4 = r2.getDelegate()     // Catch:{ all -> 0x01a5 }
            r4.markReleased()     // Catch:{ all -> 0x01a5 }
            androidx.room.coroutines.ConnectionWithLock r2 = r2.getDelegate()     // Catch:{ all -> 0x01a5 }
            r3.recycle(r2)     // Catch:{ all -> 0x01a5 }
        L_0x01a5:
            return r0
        L_0x01a6:
            java.lang.String r0 = "Required value was null."
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0160 }
            r3.<init>(r0)     // Catch:{ all -> 0x0160 }
            throw r3     // Catch:{ all -> 0x0160 }
        L_0x01ae:
            throw r0     // Catch:{ all -> 0x0160 }
        L_0x01af:
            r8.throwTimeoutException(r3)     // Catch:{ all -> 0x0160 }
            W2.h r0 = new W2.h     // Catch:{ all -> 0x0160 }
            r0.<init>()     // Catch:{ all -> 0x0160 }
            throw r0     // Catch:{ all -> 0x0160 }
        L_0x01b8:
            r0 = move-exception
            r2 = r0
            r3 = r6
        L_0x01bb:
            throw r2     // Catch:{ all -> 0x01bc }
        L_0x01bc:
            r0 = move-exception
            r4 = r0
            java.lang.Object r0 = r9.f24690a     // Catch:{ all -> 0x01d6 }
            androidx.room.coroutines.PooledConnectionImpl r0 = (androidx.room.coroutines.PooledConnectionImpl) r0     // Catch:{ all -> 0x01d6 }
            if (r0 == 0) goto L_0x01da
            r0.markRecycled()     // Catch:{ all -> 0x01d6 }
            androidx.room.coroutines.ConnectionWithLock r5 = r0.getDelegate()     // Catch:{ all -> 0x01d6 }
            r5.markReleased()     // Catch:{ all -> 0x01d6 }
            androidx.room.coroutines.ConnectionWithLock r0 = r0.getDelegate()     // Catch:{ all -> 0x01d6 }
            r3.recycle(r0)     // Catch:{ all -> 0x01d6 }
            goto L_0x01da
        L_0x01d6:
            r0 = move-exception
            W2.C2216e.a(r2, r0)
        L_0x01da:
            throw r4
        L_0x01db:
            r0 = 21
            java.lang.String r2 = "Connection pool is closed"
            androidx.sqlite.SQLite.throwSQLiteException(r0, r2)
            W2.h r0 = new W2.h
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionPoolImpl.useConnection(boolean, k3.p, b3.e):java.lang.Object");
    }

    public ConnectionPoolImpl(SQLiteDriver sQLiteDriver, String str, int i5, int i6) {
        t.e(sQLiteDriver, "driver");
        t.e(str, "fileName");
        C2795a.C0262a aVar = C2795a.f25994b;
        this.timeout = C2797c.s(30, C2798d.SECONDS);
        if (i5 <= 0) {
            throw new IllegalArgumentException("Maximum number of readers must be greater than 0");
        } else if (i6 > 0) {
            this.driver = sQLiteDriver;
            this.readers = new Pool(i5, new b(sQLiteDriver, str));
            this.writers = new Pool(i6, new c(sQLiteDriver, str));
        } else {
            throw new IllegalArgumentException("Maximum number of writers must be greater than 0");
        }
    }
}
