package androidx.room.coroutines;

import F3.a;
import F3.g;
import W2.C2216e;
import X2.C2250q;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import b3.C2308e;
import b3.C2312i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

final class ConnectionWithLock implements SQLiteConnection, a {
    private C2312i acquireCoroutineContext;
    private Throwable acquireThrowable;
    private final SQLiteConnection delegate;
    private final a lock;

    public ConnectionWithLock(SQLiteConnection sQLiteConnection, a aVar) {
        t.e(sQLiteConnection, "delegate");
        t.e(aVar, "lock");
        this.delegate = sQLiteConnection;
        this.lock = aVar;
    }

    public void close() {
        this.delegate.close();
    }

    public final void dump(StringBuilder sb) {
        t.e(sb, "builder");
        if (this.acquireCoroutineContext == null && this.acquireThrowable == null) {
            sb.append("\t\tStatus: Free connection");
            sb.append(10);
            return;
        }
        sb.append("\t\tStatus: Acquired connection");
        sb.append(10);
        C2312i iVar = this.acquireCoroutineContext;
        if (iVar != null) {
            sb.append("\t\tCoroutine: " + iVar);
            sb.append(10);
        }
        Throwable th = this.acquireThrowable;
        if (th != null) {
            sb.append("\t\tAcquired:");
            sb.append(10);
            for (String str : C2250q.F(s.o0(C2216e.b(th)), 1)) {
                sb.append("\t\t" + str);
                sb.append(10);
            }
        }
    }

    public E3.a getOnLock() {
        return this.lock.getOnLock();
    }

    public boolean holdsLock(Object obj) {
        t.e(obj, "owner");
        return this.lock.holdsLock(obj);
    }

    public boolean isLocked() {
        return this.lock.isLocked();
    }

    public Object lock(Object obj, C2308e eVar) {
        return this.lock.lock(obj, eVar);
    }

    public final ConnectionWithLock markAcquired(C2312i iVar) {
        t.e(iVar, "context");
        this.acquireCoroutineContext = iVar;
        this.acquireThrowable = new Throwable();
        return this;
    }

    public final ConnectionWithLock markReleased() {
        this.acquireCoroutineContext = null;
        this.acquireThrowable = null;
        return this;
    }

    public SQLiteStatement prepare(String str) {
        t.e(str, "sql");
        return this.delegate.prepare(str);
    }

    public String toString() {
        return this.delegate.toString();
    }

    public boolean tryLock(Object obj) {
        return this.lock.tryLock(obj);
    }

    public void unlock(Object obj) {
        this.lock.unlock(obj);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConnectionWithLock(SQLiteConnection sQLiteConnection, a aVar, int i5, C2633k kVar) {
        this(sQLiteConnection, (i5 & 2) != 0 ? g.b(false, 1, (Object) null) : aVar);
    }
}
