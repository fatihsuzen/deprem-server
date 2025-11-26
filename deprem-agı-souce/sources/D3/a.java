package D3;

import B3.D;
import B3.y;
import W2.J;
import W2.q;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSource;
import d3.C2345b;
import java.io.Closeable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import q3.C2729e;
import w3.C2864c;
import w3.Q;

public final class a implements Executor, Closeable {

    /* renamed from: h  reason: collision with root package name */
    public static final C0175a f18044h = new C0175a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f18045i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f18046j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18047k;

    /* renamed from: l  reason: collision with root package name */
    public static final D f18048l = new D("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* renamed from: a  reason: collision with root package name */
    public final int f18049a;

    /* renamed from: b  reason: collision with root package name */
    public final int f18050b;

    /* renamed from: c  reason: collision with root package name */
    public final long f18051c;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: d  reason: collision with root package name */
    public final String f18052d;

    /* renamed from: e  reason: collision with root package name */
    public final d f18053e;

    /* renamed from: f  reason: collision with root package name */
    public final d f18054f;

    /* renamed from: g  reason: collision with root package name */
    public final y f18055g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* renamed from: D3.a$a  reason: collision with other inner class name */
    public static final class C0175a {
        public /* synthetic */ C0175a(C2633k kVar) {
            this();
        }

        private C0175a() {
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18056a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                D3.a$d[] r0 = D3.a.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                D3.a$d r1 = D3.a.d.PARKING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                D3.a$d r1 = D3.a.d.BLOCKING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                D3.a$d r1 = D3.a.d.CPU_ACQUIRED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                D3.a$d r1 = D3.a.d.DORMANT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                D3.a$d r1 = D3.a.d.TERMINATED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f18056a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: D3.a.b.<clinit>():void");
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;

        static {
            d[] a5;
            f18072g = C2345b.a(a5);
        }
    }

    static {
        Class<a> cls = a.class;
        f18045i = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack$volatile");
        f18046j = AtomicLongFieldUpdater.newUpdater(cls, "controlState$volatile");
        f18047k = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated$volatile");
    }

    public a(int i5, int i6, long j5, String str) {
        this.f18049a = i5;
        this.f18050b = i6;
        this.f18051c = j5;
        this.f18052d = str;
        if (i5 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i5 + " should be at least 1").toString());
        } else if (i6 < i5) {
            throw new IllegalArgumentException(("Max pool size " + i6 + " should be greater than or equals to core pool size " + i5).toString());
        } else if (i6 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i6 + " should not exceed maximal supported number of threads 2097150").toString());
        } else if (j5 > 0) {
            this.f18053e = new d();
            this.f18054f = new d();
            this.f18055g = new y((i5 + 1) * 2);
            this.controlState$volatile = ((long) i5) << 42;
            this._isTerminated$volatile = 0;
        } else {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j5 + " must be positive").toString());
        }
    }

    private final void B(long j5, boolean z4) {
        if (!z4 && !I() && !G(j5)) {
            I();
        }
    }

    private final h F(c cVar, h hVar, boolean z4) {
        d dVar;
        if (cVar == null || (dVar = cVar.f18060c) == d.TERMINATED) {
            return hVar;
        }
        if (!hVar.f18083b && dVar == d.BLOCKING) {
            return hVar;
        }
        cVar.f18064g = true;
        return cVar.f18058a.a(hVar, z4);
    }

    private final boolean G(long j5) {
        if (C2729e.c(((int) (2097151 & j5)) - ((int) ((j5 & 4398044413952L) >> 21)), 0) < this.f18049a) {
            int l5 = l();
            if (l5 == 1 && this.f18049a > 1) {
                l();
            }
            if (l5 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean H(a aVar, long j5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            j5 = f18046j.get(aVar);
        }
        return aVar.G(j5);
    }

    private final boolean I() {
        c v5;
        do {
            v5 = v();
            if (v5 == null) {
                return false;
            }
        } while (!c.f18057i.compareAndSet(v5, -1, 0));
        LockSupport.unpark(v5);
        return true;
    }

    private final boolean d(h hVar) {
        if (hVar.f18083b) {
            return this.f18054f.a(hVar);
        }
        return this.f18053e.a(hVar);
    }

    private final int l() {
        synchronized (this.f18055g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                long j5 = f18046j.get(this);
                int i5 = (int) (j5 & 2097151);
                int c5 = C2729e.c(i5 - ((int) ((j5 & 4398044413952L) >> 21)), 0);
                if (c5 >= this.f18049a) {
                    return 0;
                }
                if (i5 >= this.f18050b) {
                    return 0;
                }
                int i6 = ((int) (f18046j.get(this) & 2097151)) + 1;
                if (i6 <= 0 || this.f18055g.b(i6) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                c cVar = new c(this, i6);
                this.f18055g.c(i6, cVar);
                if (i6 == ((int) (2097151 & f18046j.incrementAndGet(this)))) {
                    int i7 = c5 + 1;
                    cVar.start();
                    return i7;
                }
                throw new IllegalArgumentException("Failed requirement.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final c n() {
        c cVar;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof c) {
            cVar = (c) currentThread;
        } else {
            cVar = null;
        }
        if (cVar == null || !t.a(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public static /* synthetic */ void p(a aVar, Runnable runnable, boolean z4, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        if ((i5 & 4) != 0) {
            z5 = false;
        }
        aVar.o(runnable, z4, z5);
    }

    private final int u(c cVar) {
        Object g5 = cVar.g();
        while (g5 != f18048l) {
            if (g5 == null) {
                return 0;
            }
            c cVar2 = (c) g5;
            int f5 = cVar2.f();
            if (f5 != 0) {
                return f5;
            }
            g5 = cVar2.g();
        }
        return -1;
    }

    private final c v() {
        AtomicLongFieldUpdater s5 = f18045i;
        while (true) {
            long j5 = s5.get(this);
            c cVar = (c) this.f18055g.b((int) (2097151 & j5));
            if (cVar == null) {
                return null;
            }
            long j6 = (CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE + j5) & -2097152;
            int u5 = u(cVar);
            if (u5 >= 0) {
                if (f18045i.compareAndSet(this, j5, ((long) u5) | j6)) {
                    cVar.o(f18048l);
                    return cVar;
                }
            }
        }
    }

    public final void A(long j5) {
        int i5;
        h hVar;
        if (f18047k.compareAndSet(this, 0, 1)) {
            c n5 = n();
            synchronized (this.f18055g) {
                i5 = (int) (f18046j.get(this) & 2097151);
            }
            if (1 <= i5) {
                int i6 = 1;
                while (true) {
                    Object b5 = this.f18055g.b(i6);
                    t.b(b5);
                    c cVar = (c) b5;
                    if (cVar != n5) {
                        while (cVar.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(cVar);
                            cVar.join(j5);
                        }
                        cVar.f18058a.j(this.f18054f);
                    }
                    if (i6 == i5) {
                        break;
                    }
                    i6++;
                }
            }
            this.f18054f.b();
            this.f18053e.b();
            while (true) {
                if (n5 != null) {
                    hVar = n5.e(true);
                    if (hVar != null) {
                        continue;
                        z(hVar);
                    }
                }
                hVar = (h) this.f18053e.e();
                if (hVar == null && (hVar = (h) this.f18054f.e()) == null) {
                    break;
                }
                z(hVar);
            }
            if (n5 != null) {
                n5.r(d.TERMINATED);
            }
            f18045i.set(this, 0);
            f18046j.set(this, 0);
        }
    }

    public final void C() {
        if (!I() && !H(this, 0, 1, (Object) null)) {
            I();
        }
    }

    public void close() {
        A(WorkRequest.MIN_BACKOFF_MILLIS);
    }

    public void execute(Runnable runnable) {
        p(this, runnable, false, false, 6, (Object) null);
    }

    public final boolean isTerminated() {
        if (f18047k.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final h m(Runnable runnable, boolean z4) {
        long a5 = j.f18090f.a();
        if (!(runnable instanceof h)) {
            return j.b(runnable, a5, z4);
        }
        h hVar = (h) runnable;
        hVar.f18082a = a5;
        hVar.f18083b = z4;
        return hVar;
    }

    public final void o(Runnable runnable, boolean z4, boolean z5) {
        long j5;
        boolean z6;
        C2864c.a();
        h m5 = m(runnable, z4);
        boolean z7 = m5.f18083b;
        if (z7) {
            j5 = f18046j.addAndGet(this, CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE);
        } else {
            j5 = 0;
        }
        c n5 = n();
        h F4 = F(n5, m5, z5);
        if (F4 == null || d(F4)) {
            if (!z5 || n5 == null) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (z7) {
                B(j5, z6);
            } else if (!z6) {
                C();
            }
        } else {
            throw new RejectedExecutionException(this.f18052d + " was terminated");
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a5 = this.f18055g.a();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 1; i10 < a5; i10++) {
            c cVar = (c) this.f18055g.b(i10);
            if (cVar != null) {
                int i11 = cVar.f18058a.i();
                int i12 = b.f18056a[cVar.f18060c.ordinal()];
                if (i12 == 1) {
                    i7++;
                } else if (i12 == 2) {
                    i6++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i11);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i12 == 3) {
                    i5++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i11);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i12 == 4) {
                    i8++;
                    if (i11 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i11);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i12 == 5) {
                    i9++;
                } else {
                    throw new q();
                }
            }
        }
        long j5 = f18046j.get(this);
        return this.f18052d + '@' + Q.b(this) + "[Pool Size {core = " + this.f18049a + ", max = " + this.f18050b + "}, Worker States {CPU = " + i5 + ", blocking = " + i6 + ", parked = " + i7 + ", dormant = " + i8 + ", terminated = " + i9 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f18053e.c() + ", global blocking queue size = " + this.f18054f.c() + ", Control State {created workers= " + ((int) (2097151 & j5)) + ", blocking tasks = " + ((int) ((4398044413952L & j5) >> 21)) + ", CPUs acquired = " + (this.f18049a - ((int) ((9223367638808264704L & j5) >> 42))) + "}]";
    }

    public final boolean x(c cVar) {
        long j5;
        int f5;
        if (cVar.g() != f18048l) {
            return false;
        }
        AtomicLongFieldUpdater s5 = f18045i;
        do {
            j5 = s5.get(this);
            f5 = cVar.f();
            cVar.o(this.f18055g.b((int) (2097151 & j5)));
        } while (!f18045i.compareAndSet(this, j5, ((CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE + j5) & -2097152) | ((long) f5)));
        return true;
    }

    public final void y(c cVar, int i5, int i6) {
        AtomicLongFieldUpdater s5 = f18045i;
        while (true) {
            long j5 = s5.get(this);
            int i7 = (int) (2097151 & j5);
            long j6 = (CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE + j5) & -2097152;
            if (i7 == i5) {
                if (i6 == 0) {
                    i7 = u(cVar);
                } else {
                    i7 = i6;
                }
            }
            if (i7 >= 0) {
                if (f18045i.compareAndSet(this, j5, j6 | ((long) i7))) {
                    return;
                }
            }
        }
    }

    public final void z(h hVar) {
        try {
            hVar.run();
        } catch (Throwable th) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        } finally {
            C2864c.a();
        }
    }

    public final class c extends Thread {
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f18057i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl$volatile");

        /* renamed from: a  reason: collision with root package name */
        public final l f18058a;

        /* renamed from: b  reason: collision with root package name */
        private final L f18059b;

        /* renamed from: c  reason: collision with root package name */
        public d f18060c;

        /* renamed from: d  reason: collision with root package name */
        private long f18061d;

        /* renamed from: e  reason: collision with root package name */
        private long f18062e;

        /* renamed from: f  reason: collision with root package name */
        private int f18063f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f18064g;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        private c() {
            setDaemon(true);
            setContextClassLoader(a.this.getClass().getClassLoader());
            this.f18058a = new l();
            this.f18059b = new L();
            this.f18060c = d.DORMANT;
            this.nextParkedWorker = a.f18048l;
            int nanoTime = (int) System.nanoTime();
            this.f18063f = nanoTime == 0 ? 42 : nanoTime;
        }

        private final void b(h hVar) {
            this.f18061d = 0;
            if (this.f18060c == d.PARKING) {
                this.f18060c = d.BLOCKING;
            }
            if (hVar.f18083b) {
                if (r(d.BLOCKING)) {
                    a.this.C();
                }
                a.this.z(hVar);
                a.f18046j.addAndGet(a.this, -2097152);
                if (this.f18060c != d.TERMINATED) {
                    this.f18060c = d.DORMANT;
                    return;
                }
                return;
            }
            a.this.z(hVar);
        }

        private final h c(boolean z4) {
            boolean z5;
            h l5;
            h l6;
            if (z4) {
                if (j(a.this.f18049a * 2) == 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5 && (l6 = l()) != null) {
                    return l6;
                }
                h k5 = this.f18058a.k();
                if (k5 != null) {
                    return k5;
                }
                if (!z5 && (l5 = l()) != null) {
                    return l5;
                }
            } else {
                h l7 = l();
                if (l7 != null) {
                    return l7;
                }
            }
            return s(3);
        }

        private final h d() {
            h l5 = this.f18058a.l();
            if (l5 != null) {
                return l5;
            }
            h hVar = (h) a.this.f18054f.e();
            if (hVar == null) {
                return s(1);
            }
            return hVar;
        }

        private final boolean i() {
            if (this.nextParkedWorker != a.f18048l) {
                return true;
            }
            return false;
        }

        private final void k() {
            if (this.f18061d == 0) {
                this.f18061d = System.nanoTime() + a.this.f18051c;
            }
            LockSupport.parkNanos(a.this.f18051c);
            if (System.nanoTime() - this.f18061d >= 0) {
                this.f18061d = 0;
                t();
            }
        }

        private final h l() {
            if (j(2) == 0) {
                h hVar = (h) a.this.f18053e.e();
                if (hVar != null) {
                    return hVar;
                }
                return (h) a.this.f18054f.e();
            }
            h hVar2 = (h) a.this.f18054f.e();
            if (hVar2 != null) {
                return hVar2;
            }
            return (h) a.this.f18053e.e();
        }

        private final void m() {
            loop0:
            while (true) {
                boolean z4 = false;
                while (!a.this.isTerminated() && this.f18060c != d.TERMINATED) {
                    h e5 = e(this.f18064g);
                    if (e5 != null) {
                        this.f18062e = 0;
                        b(e5);
                    } else {
                        this.f18064g = false;
                        if (this.f18062e == 0) {
                            q();
                        } else if (!z4) {
                            z4 = true;
                        } else {
                            r(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f18062e);
                            this.f18062e = 0;
                        }
                    }
                }
            }
            r(d.TERMINATED);
        }

        private final boolean p() {
            long j5;
            if (this.f18060c == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            AtomicLongFieldUpdater a5 = a.f18046j;
            do {
                j5 = a5.get(aVar);
                if (((int) ((9223367638808264704L & j5) >> 42)) == 0) {
                    return false;
                }
            } while (!a.f18046j.compareAndSet(aVar, j5, j5 - 4398046511104L));
            this.f18060c = d.CPU_ACQUIRED;
            return true;
        }

        private final void q() {
            if (!i()) {
                a.this.x(this);
                return;
            }
            f18057i.set(this, -1);
            while (i() && f18057i.get(this) == -1 && !a.this.isTerminated() && this.f18060c != d.TERMINATED) {
                r(d.PARKING);
                Thread.interrupted();
                k();
            }
        }

        private final h s(int i5) {
            int i6 = (int) (a.f18046j.get(a.this) & 2097151);
            if (i6 < 2) {
                return null;
            }
            int j5 = j(i6);
            a aVar = a.this;
            long j6 = Long.MAX_VALUE;
            for (int i7 = 0; i7 < i6; i7++) {
                j5++;
                if (j5 > i6) {
                    j5 = 1;
                }
                c cVar = (c) aVar.f18055g.b(j5);
                if (cVar == null || cVar == this) {
                    int i8 = i5;
                } else {
                    long r5 = cVar.f18058a.r(i5, this.f18059b);
                    if (r5 == -1) {
                        L l5 = this.f18059b;
                        h hVar = (h) l5.f24690a;
                        l5.f24690a = null;
                        return hVar;
                    } else if (r5 > 0) {
                        j6 = Math.min(j6, r5);
                    }
                }
            }
            if (j6 == Long.MAX_VALUE) {
                j6 = 0;
            }
            this.f18062e = j6;
            return null;
        }

        private final void t() {
            a aVar = a.this;
            synchronized (aVar.f18055g) {
                try {
                    if (!aVar.isTerminated()) {
                        if (((int) (a.f18046j.get(aVar) & 2097151)) > aVar.f18049a) {
                            if (f18057i.compareAndSet(this, -1, 1)) {
                                int i5 = this.indexInArray;
                                n(0);
                                aVar.y(this, i5, 0);
                                int andDecrement = (int) (2097151 & a.f18046j.getAndDecrement(aVar));
                                if (andDecrement != i5) {
                                    Object b5 = aVar.f18055g.b(andDecrement);
                                    t.b(b5);
                                    c cVar = (c) b5;
                                    aVar.f18055g.c(i5, cVar);
                                    cVar.n(i5);
                                    aVar.y(cVar, andDecrement, i5);
                                }
                                aVar.f18055g.c(andDecrement, (Object) null);
                                J j5 = J.f19942a;
                                this.f18060c = d.TERMINATED;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final h e(boolean z4) {
            if (p()) {
                return c(z4);
            }
            return d();
        }

        public final int f() {
            return this.indexInArray;
        }

        public final Object g() {
            return this.nextParkedWorker;
        }

        public final int j(int i5) {
            int i6 = this.f18063f;
            int i7 = i6 ^ (i6 << 13);
            int i8 = i7 ^ (i7 >> 17);
            int i9 = i8 ^ (i8 << 5);
            this.f18063f = i9;
            int i10 = i5 - 1;
            if ((i10 & i5) == 0) {
                return i9 & i10;
            }
            return (i9 & Integer.MAX_VALUE) % i5;
        }

        public final void n(int i5) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f18052d);
            sb.append("-worker-");
            if (i5 == 0) {
                str = "TERMINATED";
            } else {
                str = String.valueOf(i5);
            }
            sb.append(str);
            setName(sb.toString());
            this.indexInArray = i5;
        }

        public final void o(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean r(d dVar) {
            boolean z4;
            d dVar2 = this.f18060c;
            if (dVar2 == d.CPU_ACQUIRED) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                a.f18046j.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f18060c = dVar;
            }
            return z4;
        }

        public void run() {
            m();
        }

        public c(a aVar, int i5) {
            this();
            n(i5);
        }
    }
}
