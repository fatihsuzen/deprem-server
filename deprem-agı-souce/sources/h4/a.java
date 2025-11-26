package h4;

import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import g4.d;
import j4.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class a implements e {
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final String f23734q = g4.b.i(a.class);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Object f23735a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final h f23736b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Semaphore f23737c = new Semaphore(0);

    /* renamed from: d  reason: collision with root package name */
    private final c f23738d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final k f23739e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final l f23740f;

    /* renamed from: g  reason: collision with root package name */
    private volatile int f23741g = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public volatile long f23742h = 120000;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile int f23743i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f23744j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23745k = false;

    /* renamed from: l  reason: collision with root package name */
    private volatile d f23746l = d.ALWAYS;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public volatile boolean f23747m = false;

    /* renamed from: n  reason: collision with root package name */
    private volatile Thread f23748n = null;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public List f23749o = null;

    /* renamed from: p  reason: collision with root package name */
    private final Runnable f23750p = new C0242a();

    /* renamed from: h4.a$a  reason: collision with other inner class name */
    class C0242a implements Runnable {
        C0242a() {
        }

        public void run() {
            boolean z4;
            a.this.f23743i = 0;
            while (a.this.f23747m) {
                try {
                    long c5 = a.this.f23742h;
                    if (a.this.f23743i > 1) {
                        c5 += Math.min(((long) a.this.f23743i) * a.this.f23742h, a.this.f23742h * 5);
                    }
                    a.this.f23737c.tryAcquire(c5, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e5) {
                    p4.a.b(a.f23734q).d(e5);
                }
                if (a.this.f23736b.e(a.this.q())) {
                    ArrayList arrayList = new ArrayList();
                    a.this.f23736b.b(arrayList);
                    p4.a.b(a.f23734q).a("Drained %s events.", Integer.valueOf(arrayList.size()));
                    Iterator it = a.this.f23739e.c(arrayList).iterator();
                    int i5 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        j jVar = (j) it.next();
                        if (a.this.f23749o != null) {
                            p4.a.b(a.f23734q).a("DryRun, stored HttpRequest, now %d.", Integer.valueOf(a.this.f23749o.size()));
                            z4 = a.this.f23749o.add(jVar);
                        } else {
                            z4 = a.this.f23740f.a(jVar);
                        }
                        if (!z4) {
                            p4.a.b(a.f23734q).a("Failure while trying to send packet", new Object[0]);
                            a aVar = a.this;
                            aVar.f23743i = aVar.f23743i + 1;
                            break;
                        }
                        i5 += jVar.a();
                        a.this.f23743i = 0;
                        if (!a.this.q()) {
                            p4.a.b(a.f23734q).a("Disconnected during dispatch loop", new Object[0]);
                            break;
                        }
                    }
                    p4.a.b(a.f23734q).a("Dispatched %d events.", Integer.valueOf(i5));
                    if (i5 < arrayList.size()) {
                        p4.a.b(a.f23734q).a("Unable to send all events, requeueing %d events", Integer.valueOf(arrayList.size() - i5));
                        a.this.f23736b.d(arrayList.subList(i5, arrayList.size()));
                        a.this.f23736b.e(a.this.q());
                    }
                }
                synchronized (a.this.f23735a) {
                    try {
                        if (!a.this.f23744j && !a.this.f23736b.c()) {
                            if (a.this.f23742h < 0) {
                            }
                        }
                        a.this.f23747m = false;
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23752a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                h4.d[] r0 = h4.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23752a = r0
                h4.d r1 = h4.d.EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23752a     // Catch:{ NoSuchFieldError -> 0x001d }
                h4.d r1 = h4.d.ALWAYS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23752a     // Catch:{ NoSuchFieldError -> 0x0028 }
                h4.d r1 = h4.d.WIFI_ONLY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h4.a.b.<clinit>():void");
        }
    }

    public a(h hVar, c cVar, k kVar, l lVar) {
        this.f23738d = cVar;
        this.f23736b = hVar;
        this.f23739e = kVar;
        this.f23740f = lVar;
        lVar.c(this.f23745k);
        lVar.b((long) this.f23741g);
    }

    /* access modifiers changed from: private */
    public boolean q() {
        if (!this.f23738d.b()) {
            return false;
        }
        int i5 = b.f23752a[this.f23746l.ordinal()];
        if (i5 == 2) {
            return true;
        }
        if (i5 == 3 && this.f23738d.a() == c.a.WIFI) {
            return true;
        }
        return false;
    }

    private boolean r() {
        synchronized (this.f23735a) {
            try {
                if (this.f23747m) {
                    return false;
                }
                this.f23747m = true;
                Thread thread = new Thread(this.f23750p);
                thread.setPriority(1);
                thread.setName("Matomo-default-dispatcher");
                this.f23748n = thread;
                thread.start();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(d dVar) {
        this.f23746l = dVar;
    }

    public void b(d dVar) {
        this.f23736b.a(new g(dVar.e()));
        if (this.f23742h != -1) {
            r();
        }
    }
}
