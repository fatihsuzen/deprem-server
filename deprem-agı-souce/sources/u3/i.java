package U3;

import V3.c;
import X3.d;
import X3.g;
import c4.f;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class i {

    /* renamed from: g  reason: collision with root package name */
    private static final Executor f19506g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.B("OkHttp ConnectionPool", true));

    /* renamed from: a  reason: collision with root package name */
    private final int f19507a;

    /* renamed from: b  reason: collision with root package name */
    private final long f19508b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f19509c;

    /* renamed from: d  reason: collision with root package name */
    private final Deque f19510d;

    /* renamed from: e  reason: collision with root package name */
    final d f19511e;

    /* renamed from: f  reason: collision with root package name */
    boolean f19512f;

    class a implements Runnable {
        a() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                U3.i r0 = U3.i.this
                long r1 = java.lang.System.nanoTime()
                long r0 = r0.a(r1)
                r2 = -1
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 != 0) goto L_0x0011
                return
            L_0x0011:
                r2 = 0
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 <= 0) goto L_0x0000
                r2 = 1000000(0xf4240, double:4.940656E-318)
                long r4 = r0 / r2
                long r2 = r2 * r4
                long r0 = r0 - r2
                U3.i r2 = U3.i.this
                monitor-enter(r2)
                U3.i r3 = U3.i.this     // Catch:{ InterruptedException -> 0x002a }
                int r0 = (int) r0     // Catch:{ InterruptedException -> 0x002a }
                r3.wait(r4, r0)     // Catch:{ InterruptedException -> 0x002a }
                goto L_0x002a
            L_0x0028:
                r0 = move-exception
                goto L_0x002c
            L_0x002a:
                monitor-exit(r2)     // Catch:{ all -> 0x0028 }
                goto L_0x0000
            L_0x002c:
                monitor-exit(r2)     // Catch:{ all -> 0x0028 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: U3.i.a.run():void");
        }
    }

    public i() {
        this(5, 5, TimeUnit.MINUTES);
    }

    private int e(X3.c cVar, long j5) {
        List list = cVar.f20088n;
        int i5 = 0;
        while (i5 < list.size()) {
            Reference reference = (Reference) list.get(i5);
            if (reference.get() != null) {
                i5++;
            } else {
                f.i().q("A connection to " + cVar.p().a().l() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f20117a);
                list.remove(i5);
                cVar.f20085k = true;
                if (list.isEmpty()) {
                    cVar.f20089o = j5 - this.f19508b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* access modifiers changed from: package-private */
    public long a(long j5) {
        synchronized (this) {
            try {
                X3.c cVar = null;
                long j6 = Long.MIN_VALUE;
                int i5 = 0;
                int i6 = 0;
                for (X3.c cVar2 : this.f19510d) {
                    if (e(cVar2, j5) > 0) {
                        i6++;
                    } else {
                        i5++;
                        long j7 = j5 - cVar2.f20089o;
                        if (j7 > j6) {
                            cVar = cVar2;
                            j6 = j7;
                        }
                    }
                }
                long j8 = this.f19508b;
                if (j6 < j8) {
                    if (i5 <= this.f19507a) {
                        if (i5 > 0) {
                            long j9 = j8 - j6;
                            return j9;
                        } else if (i6 > 0) {
                            return j8;
                        } else {
                            this.f19512f = false;
                            return -1;
                        }
                    }
                }
                this.f19510d.remove(cVar);
                c.e(cVar.q());
                return 0;
            } finally {
                while (true) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(X3.c cVar) {
        if (cVar.f20085k || this.f19507a == 0) {
            this.f19510d.remove(cVar);
            return true;
        }
        notifyAll();
        return false;
    }

    /* access modifiers changed from: package-private */
    public Socket c(C2202a aVar, g gVar) {
        for (X3.c cVar : this.f19510d) {
            if (cVar.k(aVar, (B) null) && cVar.m() && cVar != gVar.c()) {
                return gVar.l(cVar);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public X3.c d(C2202a aVar, g gVar, B b5) {
        for (X3.c cVar : this.f19510d) {
            if (cVar.k(aVar, b5)) {
                gVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void f(X3.c cVar) {
        if (!this.f19512f) {
            this.f19512f = true;
            f19506g.execute(this.f19509c);
        }
        this.f19510d.add(cVar);
    }

    public i(int i5, long j5, TimeUnit timeUnit) {
        this.f19509c = new a();
        this.f19510d = new ArrayDeque();
        this.f19511e = new d();
        this.f19507a = i5;
        this.f19508b = timeUnit.toNanos(j5);
        if (j5 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j5);
        }
    }
}
