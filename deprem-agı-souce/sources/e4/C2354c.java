package e4;

import W2.J;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: e4.c  reason: case insensitive filesystem */
public class C2354c extends a0 {

    /* renamed from: i  reason: collision with root package name */
    public static final a f21543i = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final ReentrantLock f21544j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Condition f21545k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final long f21546l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final long f21547m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static C2354c f21548n;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f21549f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public C2354c f21550g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public long f21551h;

    /* renamed from: e4.c$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean d(C2354c cVar) {
            ReentrantLock f5 = C2354c.f21543i.f();
            f5.lock();
            try {
                if (!cVar.f21549f) {
                    return false;
                }
                cVar.f21549f = false;
                for (C2354c j5 = C2354c.f21548n; j5 != null; j5 = j5.f21550g) {
                    if (j5.f21550g == cVar) {
                        j5.f21550g = cVar.f21550g;
                        cVar.f21550g = null;
                        f5.unlock();
                        return false;
                    }
                }
                f5.unlock();
                return true;
            } finally {
                f5.unlock();
            }
        }

        /* access modifiers changed from: private */
        public final void g(C2354c cVar, long j5, boolean z4) {
            ReentrantLock f5 = C2354c.f21543i.f();
            f5.lock();
            try {
                if (!cVar.f21549f) {
                    cVar.f21549f = true;
                    if (C2354c.f21548n == null) {
                        C2354c.f21548n = new C2354c();
                        new b().start();
                    }
                    long nanoTime = System.nanoTime();
                    int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
                    if (i5 != 0 && z4) {
                        cVar.f21551h = Math.min(j5, cVar.c() - nanoTime) + nanoTime;
                    } else if (i5 != 0) {
                        cVar.f21551h = j5 + nanoTime;
                    } else if (z4) {
                        cVar.f21551h = cVar.c();
                    } else {
                        throw new AssertionError();
                    }
                    long q5 = cVar.y(nanoTime);
                    C2354c j6 = C2354c.f21548n;
                    t.b(j6);
                    while (true) {
                        if (j6.f21550g == null) {
                            break;
                        }
                        C2354c o5 = j6.f21550g;
                        t.b(o5);
                        if (q5 < o5.y(nanoTime)) {
                            break;
                        }
                        j6 = j6.f21550g;
                        t.b(j6);
                    }
                    cVar.f21550g = j6.f21550g;
                    j6.f21550g = cVar;
                    if (j6 == C2354c.f21548n) {
                        C2354c.f21543i.e().signal();
                    }
                    J j7 = J.f19942a;
                    f5.unlock();
                    return;
                }
                throw new IllegalStateException("Unbalanced enter/exit");
            } catch (Throwable th) {
                f5.unlock();
                throw th;
            }
        }

        public final C2354c c() {
            C2354c j5 = C2354c.f21548n;
            t.b(j5);
            C2354c o5 = j5.f21550g;
            if (o5 == null) {
                long nanoTime = System.nanoTime();
                e().await(C2354c.f21546l, TimeUnit.MILLISECONDS);
                C2354c j6 = C2354c.f21548n;
                t.b(j6);
                if (j6.f21550g != null || System.nanoTime() - nanoTime < C2354c.f21547m) {
                    return null;
                }
                return C2354c.f21548n;
            }
            long q5 = o5.y(System.nanoTime());
            if (q5 > 0) {
                e().await(q5, TimeUnit.NANOSECONDS);
                return null;
            }
            C2354c j7 = C2354c.f21548n;
            t.b(j7);
            j7.f21550g = o5.f21550g;
            o5.f21550g = null;
            return o5;
        }

        public final Condition e() {
            return C2354c.f21545k;
        }

        public final ReentrantLock f() {
            return C2354c.f21544j;
        }

        private a() {
        }
    }

    /* renamed from: e4.c$b */
    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|(5:5|6|7|19|8)(5:10|11|12|13|(2:15|23)(1:22))|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
            r1.unlock();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:18:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                e4.c$a r0 = e4.C2354c.f21543i     // Catch:{ InterruptedException -> 0x0000 }
                java.util.concurrent.locks.ReentrantLock r1 = r0.f()     // Catch:{ InterruptedException -> 0x0000 }
                r1.lock()     // Catch:{ InterruptedException -> 0x0000 }
                e4.c r0 = r0.c()     // Catch:{ all -> 0x001b }
                e4.c r2 = e4.C2354c.f21548n     // Catch:{ all -> 0x001b }
                if (r0 != r2) goto L_0x001d
                r0 = 0
                e4.C2354c.f21548n = r0     // Catch:{ all -> 0x001b }
                r1.unlock()     // Catch:{ InterruptedException -> 0x0000 }
                return
            L_0x001b:
                r0 = move-exception
                goto L_0x0028
            L_0x001d:
                W2.J r2 = W2.J.f19942a     // Catch:{ all -> 0x001b }
                r1.unlock()     // Catch:{ InterruptedException -> 0x0000 }
                if (r0 == 0) goto L_0x0000
                r0.B()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0028:
                r1.unlock()     // Catch:{ InterruptedException -> 0x0000 }
                throw r0     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: e4.C2354c.b.run():void");
        }
    }

    /* renamed from: e4.c$c  reason: collision with other inner class name */
    public static final class C0221c implements X {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2354c f21552a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ X f21553b;

        C0221c(C2354c cVar, X x4) {
            this.f21552a = cVar;
            this.f21553b = x4;
        }

        /* renamed from: a */
        public C2354c timeout() {
            return this.f21552a;
        }

        public void close() {
            C2354c cVar = this.f21552a;
            X x4 = this.f21553b;
            cVar.v();
            try {
                x4.close();
                J j5 = J.f19942a;
                if (cVar.w()) {
                    throw cVar.p((IOException) null);
                }
            } catch (IOException e5) {
                e = e5;
                if (cVar.w()) {
                    e = cVar.p(e);
                }
                throw e;
            } finally {
                cVar.w();
            }
        }

        public void f(C2356e eVar, long j5) {
            t.e(eVar, "source");
            C2353b.b(eVar.size(), 0, j5);
            while (true) {
                long j6 = 0;
                if (j5 > 0) {
                    U u5 = eVar.f21556a;
                    t.b(u5);
                    while (true) {
                        if (j6 >= 65536) {
                            break;
                        }
                        j6 += (long) (u5.f21515c - u5.f21514b);
                        if (j6 >= j5) {
                            j6 = j5;
                            break;
                        } else {
                            u5 = u5.f21518f;
                            t.b(u5);
                        }
                    }
                    C2354c cVar = this.f21552a;
                    X x4 = this.f21553b;
                    cVar.v();
                    try {
                        x4.f(eVar, j6);
                        J j7 = J.f19942a;
                        if (!cVar.w()) {
                            j5 -= j6;
                        } else {
                            throw cVar.p((IOException) null);
                        }
                    } catch (IOException e5) {
                        IOException iOException = e5;
                        if (cVar.w()) {
                            iOException = cVar.p(iOException);
                        }
                        throw iOException;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        cVar.w();
                        throw th2;
                    }
                } else {
                    return;
                }
            }
        }

        public void flush() {
            C2354c cVar = this.f21552a;
            X x4 = this.f21553b;
            cVar.v();
            try {
                x4.flush();
                J j5 = J.f19942a;
                if (cVar.w()) {
                    throw cVar.p((IOException) null);
                }
            } catch (IOException e5) {
                e = e5;
                if (cVar.w()) {
                    e = cVar.p(e);
                }
                throw e;
            } finally {
                cVar.w();
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f21553b + ')';
        }
    }

    /* renamed from: e4.c$d */
    public static final class d implements Z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2354c f21554a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Z f21555b;

        d(C2354c cVar, Z z4) {
            this.f21554a = cVar;
            this.f21555b = z4;
        }

        /* renamed from: a */
        public C2354c timeout() {
            return this.f21554a;
        }

        public void close() {
            C2354c cVar = this.f21554a;
            Z z4 = this.f21555b;
            cVar.v();
            try {
                z4.close();
                J j5 = J.f19942a;
                if (cVar.w()) {
                    throw cVar.p((IOException) null);
                }
            } catch (IOException e5) {
                e = e5;
                if (cVar.w()) {
                    e = cVar.p(e);
                }
                throw e;
            } finally {
                cVar.w();
            }
        }

        public long e(C2356e eVar, long j5) {
            t.e(eVar, "sink");
            C2354c cVar = this.f21554a;
            Z z4 = this.f21555b;
            cVar.v();
            try {
                long e5 = z4.e(eVar, j5);
                if (!cVar.w()) {
                    return e5;
                }
                throw cVar.p((IOException) null);
            } catch (IOException e6) {
                e = e6;
                if (cVar.w()) {
                    e = cVar.p(e);
                }
                throw e;
            } finally {
                cVar.w();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f21555b + ')';
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f21544j = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        t.d(newCondition, "lock.newCondition()");
        f21545k = newCondition;
        long millis = TimeUnit.SECONDS.toMillis(60);
        f21546l = millis;
        f21547m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* access modifiers changed from: private */
    public final long y(long j5) {
        return this.f21551h - j5;
    }

    public final Z A(Z z4) {
        t.e(z4, "source");
        return new d(this, z4);
    }

    public final IOException p(IOException iOException) {
        return x(iOException);
    }

    public final void v() {
        long h5 = h();
        boolean e5 = e();
        if (h5 != 0 || e5) {
            f21543i.g(this, h5, e5);
        }
    }

    public final boolean w() {
        return f21543i.d(this);
    }

    /* access modifiers changed from: protected */
    public IOException x(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final X z(X x4) {
        t.e(x4, "sink");
        return new C0221c(this, x4);
    }

    /* access modifiers changed from: protected */
    public void B() {
    }
}
