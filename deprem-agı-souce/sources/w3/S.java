package w3;

import b3.C2312i;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.t;
import q3.C2729e;
import w3.C2879j0;

public final class S extends C2879j0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: g  reason: collision with root package name */
    public static final S f26256g;

    /* renamed from: h  reason: collision with root package name */
    private static final long f26257h;

    static {
        Long l5;
        S s5 = new S();
        f26256g = s5;
        C2877i0.L(s5, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l5 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l5 = 1000L;
        }
        f26257h = timeUnit.toNanos(l5.longValue());
    }

    private S() {
    }

    private final synchronized void l0() {
        if (o0()) {
            debugStatus = 3;
            f0();
            t.c(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    private final synchronized Thread m0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setContextClassLoader(f26256g.getClass().getClassLoader());
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean n0() {
        if (debugStatus == 4) {
            return true;
        }
        return false;
    }

    private final boolean o0() {
        int i5 = debugStatus;
        if (i5 == 2 || i5 == 3) {
            return true;
        }
        return false;
    }

    private final synchronized boolean p0() {
        if (o0()) {
            return false;
        }
        debugStatus = 1;
        t.c(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    private final void q0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    /* access modifiers changed from: protected */
    public Thread R() {
        Thread thread = _thread;
        if (thread == null) {
            return m0();
        }
        return thread;
    }

    /* access modifiers changed from: protected */
    public void S(long j5, C2879j0.c cVar) {
        q0();
    }

    public void X(Runnable runnable) {
        if (n0()) {
            q0();
        }
        super.X(runnable);
    }

    public C2869e0 q(long j5, Runnable runnable, C2312i iVar) {
        return i0(j5, runnable);
    }

    public void run() {
        W0.f26260a.d(this);
        C2864c.a();
        try {
            if (p0()) {
                long j5 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long O4 = O();
                    if (O4 == Long.MAX_VALUE) {
                        C2864c.a();
                        long nanoTime = System.nanoTime();
                        if (j5 == Long.MAX_VALUE) {
                            j5 = f26257h + nanoTime;
                        }
                        long j6 = j5 - nanoTime;
                        if (j6 <= 0) {
                            _thread = null;
                            l0();
                            C2864c.a();
                            if (!d0()) {
                                R();
                                return;
                            }
                            return;
                        }
                        O4 = C2729e.f(O4, j6);
                    } else {
                        j5 = Long.MAX_VALUE;
                    }
                    if (O4 > 0) {
                        if (o0()) {
                            _thread = null;
                            l0();
                            C2864c.a();
                            if (!d0()) {
                                R();
                                return;
                            }
                            return;
                        }
                        C2864c.a();
                        LockSupport.parkNanos(this, O4);
                    }
                }
            }
        } finally {
            _thread = null;
            l0();
            C2864c.a();
            if (!d0()) {
                R();
            }
        }
    }

    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    public String toString() {
        return "DefaultExecutor";
    }
}
