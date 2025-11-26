package E0;

import F0.d;
import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k0.C1699m;
import p.C1746d;
import p.f;
import p.i;
import r.l;
import u0.g;
import x0.C1903A;
import x0.N;
import x0.c0;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private final double f2402a;

    /* renamed from: b  reason: collision with root package name */
    private final double f2403b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2404c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2405d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2406e;

    /* renamed from: f  reason: collision with root package name */
    private final BlockingQueue f2407f;

    /* renamed from: g  reason: collision with root package name */
    private final ThreadPoolExecutor f2408g;

    /* renamed from: h  reason: collision with root package name */
    private final i f2409h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final N f2410i;

    /* renamed from: j  reason: collision with root package name */
    private int f2411j;

    /* renamed from: k  reason: collision with root package name */
    private long f2412k;

    private final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final C1903A f2413a;

        /* renamed from: b  reason: collision with root package name */
        private final C1699m f2414b;

        public void run() {
            e.this.n(this.f2413a, this.f2414b);
            e.this.f2410i.c();
            double e5 = e.this.g();
            g f5 = g.f();
            f5.b("Delay for: " + String.format(Locale.US, "%.2f", new Object[]{Double.valueOf(e5 / 1000.0d)}) + " s for report: " + this.f2413a.d());
            e.o(e5);
        }

        private b(C1903A a5, C1699m mVar) {
            this.f2413a = a5;
            this.f2414b = mVar;
        }
    }

    e(i iVar, d dVar, N n5) {
        this(dVar.f2426f, dVar.f2427g, ((long) dVar.f2428h) * 1000, iVar, n5);
    }

    public static /* synthetic */ void a(e eVar, C1699m mVar, boolean z4, C1903A a5, Exception exc) {
        eVar.getClass();
        if (exc != null) {
            mVar.d(exc);
            return;
        }
        if (z4) {
            eVar.j();
        }
        mVar.e(a5);
    }

    public static /* synthetic */ void b(e eVar, CountDownLatch countDownLatch) {
        eVar.getClass();
        try {
            l.a(eVar.f2409h, f.HIGHEST);
        } catch (Exception unused) {
        }
        countDownLatch.countDown();
    }

    /* access modifiers changed from: private */
    public double g() {
        return Math.min(3600000.0d, (60000.0d / this.f2402a) * Math.pow(this.f2403b, (double) h()));
    }

    private int h() {
        int i5;
        if (this.f2412k == 0) {
            this.f2412k = m();
        }
        int m5 = (int) ((m() - this.f2412k) / this.f2404c);
        if (l()) {
            i5 = Math.min(100, this.f2411j + m5);
        } else {
            i5 = Math.max(0, this.f2411j - m5);
        }
        if (this.f2411j != i5) {
            this.f2411j = i5;
            this.f2412k = m();
        }
        return i5;
    }

    private boolean k() {
        if (this.f2407f.size() < this.f2406e) {
            return true;
        }
        return false;
    }

    private boolean l() {
        if (this.f2407f.size() == this.f2406e) {
            return true;
        }
        return false;
    }

    private long m() {
        return System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public void n(C1903A a5, C1699m mVar) {
        boolean z4;
        g f5 = g.f();
        f5.b("Sending report through Google DataTransport: " + a5.d());
        if (SystemClock.elapsedRealtime() - this.f2405d < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2409h.a(C1746d.h(a5.b()), new c(this, mVar, z4, a5));
    }

    /* access modifiers changed from: private */
    public static void o(double d5) {
        try {
            Thread.sleep((long) d5);
        } catch (InterruptedException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public C1699m i(C1903A a5, boolean z4) {
        synchronized (this.f2407f) {
            try {
                C1699m mVar = new C1699m();
                if (z4) {
                    this.f2410i.b();
                    if (k()) {
                        g f5 = g.f();
                        f5.b("Enqueueing report: " + a5.d());
                        g f6 = g.f();
                        f6.b("Queue size: " + this.f2407f.size());
                        this.f2408g.execute(new b(a5, mVar));
                        g f7 = g.f();
                        f7.b("Closing task for report: " + a5.d());
                        mVar.e(a5);
                        return mVar;
                    }
                    h();
                    g f8 = g.f();
                    f8.b("Dropping report due to queue being full: " + a5.d());
                    this.f2410i.a();
                    mVar.e(a5);
                    return mVar;
                }
                n(a5, mVar);
                return mVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new d(this, countDownLatch)).start();
        c0.c(countDownLatch, 2, TimeUnit.SECONDS);
    }

    e(double d5, double d6, long j5, i iVar, N n5) {
        this.f2402a = d5;
        this.f2403b = d6;
        this.f2404c = j5;
        this.f2409h = iVar;
        this.f2410i = n5;
        this.f2405d = SystemClock.elapsedRealtime();
        int i5 = (int) d5;
        this.f2406e = i5;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i5);
        this.f2407f = arrayBlockingQueue;
        this.f2408g = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f2411j = 0;
        this.f2412k = 0;
    }
}
