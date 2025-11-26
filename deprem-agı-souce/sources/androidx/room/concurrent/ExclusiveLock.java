package androidx.room.concurrent;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class ExclusiveLock {
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    public static final Map<String, ReentrantLock> threadLocksMap = new LinkedHashMap();
    private final FileLock fileLock;
    private final ReentrantLock threadLock;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final FileLock getFileLock(String str) {
            return new FileLock(str);
        }

        /* access modifiers changed from: private */
        public final ReentrantLock getThreadLock(String str) {
            ReentrantLock reentrantLock;
            synchronized (this) {
                try {
                    Map access$getThreadLocksMap$cp = ExclusiveLock.threadLocksMap;
                    Object obj = access$getThreadLocksMap$cp.get(str);
                    if (obj == null) {
                        obj = new ReentrantLock();
                        access$getThreadLocksMap$cp.put(str, obj);
                    }
                    reentrantLock = (ReentrantLock) obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return reentrantLock;
        }

        private Companion() {
        }
    }

    public ExclusiveLock(String str, boolean z4) {
        FileLock fileLock2;
        t.e(str, "filename");
        Companion companion = Companion;
        this.threadLock = companion.getThreadLock(str);
        if (z4) {
            fileLock2 = companion.getFileLock(str);
        } else {
            fileLock2 = null;
        }
        this.fileLock = fileLock2;
    }

    public final <T> T withLock(C2616a aVar, l lVar) {
        t.e(aVar, "onLocked");
        t.e(lVar, "onLockError");
        this.threadLock.lock();
        boolean z4 = false;
        try {
            FileLock fileLock2 = this.fileLock;
            if (fileLock2 != null) {
                fileLock2.lock();
            }
            z4 = true;
            T invoke = aVar.invoke();
            FileLock fileLock3 = this.fileLock;
            if (fileLock3 != null) {
                fileLock3.unlock();
            }
            this.threadLock.unlock();
            return invoke;
        } catch (Throwable th) {
            this.threadLock.unlock();
            throw th;
        }
    }
}
