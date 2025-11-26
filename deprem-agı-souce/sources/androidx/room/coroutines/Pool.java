package androidx.room.coroutines;

import F3.a;
import F3.h;
import F3.l;
import W2.J;
import X2.C2250q;
import androidx.collection.CircularArray;
import androidx.sqlite.SQLiteConnection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

final class Pool {
    private final CircularArray<ConnectionWithLock> availableConnections;
    private final int capacity;
    private final C2616a connectionFactory;
    private final h connectionPermits;
    private final ConnectionWithLock[] connections;
    private boolean isClosed;
    private final ReentrantLock lock = new ReentrantLock();
    private int size;

    public Pool(int i5, C2616a aVar) {
        t.e(aVar, "connectionFactory");
        this.capacity = i5;
        this.connectionFactory = aVar;
        this.connections = new ConnectionWithLock[i5];
        this.connectionPermits = l.b(i5, 0, 2, (Object) null);
        this.availableConnections = new CircularArray<>(i5);
    }

    private final void tryOpenNewConnectionLocked() {
        if (this.size < this.capacity) {
            ConnectionWithLock connectionWithLock = new ConnectionWithLock((SQLiteConnection) this.connectionFactory.invoke(), (a) null, 2, (C2633k) null);
            ConnectionWithLock[] connectionWithLockArr = this.connections;
            int i5 = this.size;
            this.size = i5 + 1;
            connectionWithLockArr[i5] = connectionWithLock;
            this.availableConnections.addLast(connectionWithLock);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f A[Catch:{ all -> 0x005b, all -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object acquire(b3.C2308e r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.room.coroutines.Pool$acquire$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.room.coroutines.Pool$acquire$1 r0 = (androidx.room.coroutines.Pool$acquire$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.coroutines.Pool$acquire$1 r0 = new androidx.room.coroutines.Pool$acquire$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.Pool r0 = (androidx.room.coroutines.Pool) r0
            W2.u.b(r5)
            goto L_0x0046
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            W2.u.b(r5)
            F3.h r5 = r4.connectionPermits
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.b(r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r0 = r4
        L_0x0046:
            java.util.concurrent.locks.ReentrantLock r5 = r0.lock     // Catch:{ all -> 0x0069 }
            r5.lock()     // Catch:{ all -> 0x0069 }
            boolean r1 = r0.isClosed     // Catch:{ all -> 0x005b }
            if (r1 != 0) goto L_0x006b
            androidx.collection.CircularArray<androidx.room.coroutines.ConnectionWithLock> r1 = r0.availableConnections     // Catch:{ all -> 0x005b }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x005d
            r0.tryOpenNewConnectionLocked()     // Catch:{ all -> 0x005b }
            goto L_0x005d
        L_0x005b:
            r1 = move-exception
            goto L_0x0078
        L_0x005d:
            androidx.collection.CircularArray<androidx.room.coroutines.ConnectionWithLock> r1 = r0.availableConnections     // Catch:{ all -> 0x005b }
            java.lang.Object r1 = r1.popFirst()     // Catch:{ all -> 0x005b }
            androidx.room.coroutines.ConnectionWithLock r1 = (androidx.room.coroutines.ConnectionWithLock) r1     // Catch:{ all -> 0x005b }
            r5.unlock()     // Catch:{ all -> 0x0069 }
            return r1
        L_0x0069:
            r5 = move-exception
            goto L_0x007c
        L_0x006b:
            java.lang.String r1 = "Connection pool is closed"
            r2 = 21
            androidx.sqlite.SQLite.throwSQLiteException(r2, r1)     // Catch:{ all -> 0x005b }
            W2.h r1 = new W2.h     // Catch:{ all -> 0x005b }
            r1.<init>()     // Catch:{ all -> 0x005b }
            throw r1     // Catch:{ all -> 0x005b }
        L_0x0078:
            r5.unlock()     // Catch:{ all -> 0x0069 }
            throw r1     // Catch:{ all -> 0x0069 }
        L_0x007c:
            F3.h r0 = r0.connectionPermits
            r0.release()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.acquire(b3.e):java.lang.Object");
    }

    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isClosed = true;
            for (ConnectionWithLock connectionWithLock : this.connections) {
                if (connectionWithLock != null) {
                    connectionWithLock.close();
                }
            }
            J j5 = J.f19942a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void dump(StringBuilder sb) {
        String str;
        t.e(sb, "builder");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List c5 = C2250q.c();
            int size2 = this.availableConnections.size();
            for (int i5 = 0; i5 < size2; i5++) {
                c5.add(this.availableConnections.get(i5));
            }
            List a5 = C2250q.a(c5);
            sb.append(9 + super.toString() + " (");
            sb.append("capacity=" + this.capacity + ", ");
            sb.append("permits=" + this.connectionPermits.a() + ", ");
            sb.append("queue=(size=" + a5.size() + ")[" + C2250q.V(a5, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (k3.l) null, 63, (Object) null) + "], ");
            sb.append(")");
            sb.append(10);
            int i6 = 0;
            for (ConnectionWithLock connectionWithLock : this.connections) {
                i6++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\t\t[");
                sb2.append(i6);
                sb2.append("] - ");
                if (connectionWithLock != null) {
                    str = connectionWithLock.toString();
                } else {
                    str = null;
                }
                sb2.append(str);
                sb.append(sb2.toString());
                sb.append(10);
                if (connectionWithLock != null) {
                    connectionWithLock.dump(sb);
                }
            }
            J j5 = J.f19942a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final C2616a getConnectionFactory() {
        return this.connectionFactory;
    }

    /* JADX INFO: finally extract failed */
    public final void recycle(ConnectionWithLock connectionWithLock) {
        t.e(connectionWithLock, "connection");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.availableConnections.addLast(connectionWithLock);
            J j5 = J.f19942a;
            reentrantLock.unlock();
            this.connectionPermits.release();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
