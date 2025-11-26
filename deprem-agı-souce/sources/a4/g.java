package a4;

import a4.h;
import e4.C2356e;
import e4.C2357f;
import e4.C2358g;
import e4.C2359h;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class g implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public static final ExecutorService f20357u = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), V3.c.B("OkHttp Http2Connection", true));

    /* renamed from: a  reason: collision with root package name */
    final boolean f20358a;

    /* renamed from: b  reason: collision with root package name */
    final h f20359b;

    /* renamed from: c  reason: collision with root package name */
    final Map f20360c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    final String f20361d;

    /* renamed from: e  reason: collision with root package name */
    int f20362e;

    /* renamed from: f  reason: collision with root package name */
    int f20363f;

    /* renamed from: g  reason: collision with root package name */
    boolean f20364g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final ScheduledExecutorService f20365h;

    /* renamed from: i  reason: collision with root package name */
    private final ExecutorService f20366i;

    /* renamed from: j  reason: collision with root package name */
    final l f20367j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f20368k;

    /* renamed from: l  reason: collision with root package name */
    long f20369l = 0;

    /* renamed from: m  reason: collision with root package name */
    long f20370m;

    /* renamed from: n  reason: collision with root package name */
    m f20371n = new m();

    /* renamed from: o  reason: collision with root package name */
    final m f20372o;

    /* renamed from: p  reason: collision with root package name */
    boolean f20373p;

    /* renamed from: q  reason: collision with root package name */
    final Socket f20374q;

    /* renamed from: r  reason: collision with root package name */
    final j f20375r;

    /* renamed from: s  reason: collision with root package name */
    final j f20376s;

    /* renamed from: t  reason: collision with root package name */
    final Set f20377t;

    class a extends V3.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f20378b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f20379c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i5, b bVar) {
            super(str, objArr);
            this.f20378b = i5;
            this.f20379c = bVar;
        }

        public void e() {
            try {
                g.this.K(this.f20378b, this.f20379c);
            } catch (IOException unused) {
                g.this.p();
            }
        }
    }

    class b extends V3.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f20381b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f20382c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i5, long j5) {
            super(str, objArr);
            this.f20381b = i5;
            this.f20382c = j5;
        }

        public void e() {
            try {
                g.this.f20375r.y(this.f20381b, this.f20382c);
            } catch (IOException unused) {
                g.this.p();
            }
        }
    }

    class c extends V3.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f20384b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f20385c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, int i5, List list) {
            super(str, objArr);
            this.f20384b = i5;
            this.f20385c = list;
        }

        public void e() {
            if (g.this.f20367j.onRequest(this.f20384b, this.f20385c)) {
                try {
                    g.this.f20375r.u(this.f20384b, b.CANCEL);
                    synchronized (g.this) {
                        g.this.f20377t.remove(Integer.valueOf(this.f20384b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    class d extends V3.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f20387b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f20388c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f20389d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i5, List list, boolean z4) {
            super(str, objArr);
            this.f20387b = i5;
            this.f20388c = list;
            this.f20389d = z4;
        }

        public void e() {
            boolean onHeaders = g.this.f20367j.onHeaders(this.f20387b, this.f20388c, this.f20389d);
            if (onHeaders) {
                try {
                    g.this.f20375r.u(this.f20387b, b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (onHeaders || this.f20389d) {
                synchronized (g.this) {
                    g.this.f20377t.remove(Integer.valueOf(this.f20387b));
                }
            }
        }
    }

    class e extends V3.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f20391b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2356e f20392c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f20393d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f20394e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i5, C2356e eVar, int i6, boolean z4) {
            super(str, objArr);
            this.f20391b = i5;
            this.f20392c = eVar;
            this.f20393d = i6;
            this.f20394e = z4;
        }

        public void e() {
            try {
                boolean a5 = g.this.f20367j.a(this.f20391b, this.f20392c, this.f20393d, this.f20394e);
                if (a5) {
                    g.this.f20375r.u(this.f20391b, b.CANCEL);
                }
                if (a5 || this.f20394e) {
                    synchronized (g.this) {
                        g.this.f20377t.remove(Integer.valueOf(this.f20391b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    class f extends V3.b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f20396b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f20397c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i5, b bVar) {
            super(str, objArr);
            this.f20396b = i5;
            this.f20397c = bVar;
        }

        public void e() {
            g.this.f20367j.b(this.f20396b, this.f20397c);
            synchronized (g.this) {
                g.this.f20377t.remove(Integer.valueOf(this.f20396b));
            }
        }
    }

    /* renamed from: a4.g$g  reason: collision with other inner class name */
    public static class C0200g {

        /* renamed from: a  reason: collision with root package name */
        Socket f20399a;

        /* renamed from: b  reason: collision with root package name */
        String f20400b;

        /* renamed from: c  reason: collision with root package name */
        C2358g f20401c;

        /* renamed from: d  reason: collision with root package name */
        C2357f f20402d;

        /* renamed from: e  reason: collision with root package name */
        h f20403e = h.f20407a;

        /* renamed from: f  reason: collision with root package name */
        l f20404f = l.f20467a;

        /* renamed from: g  reason: collision with root package name */
        boolean f20405g;

        /* renamed from: h  reason: collision with root package name */
        int f20406h;

        public C0200g(boolean z4) {
            this.f20405g = z4;
        }

        public g a() {
            return new g(this);
        }

        public C0200g b(h hVar) {
            this.f20403e = hVar;
            return this;
        }

        public C0200g c(int i5) {
            this.f20406h = i5;
            return this;
        }

        public C0200g d(Socket socket, String str, C2358g gVar, C2357f fVar) {
            this.f20399a = socket;
            this.f20400b = str;
            this.f20401c = gVar;
            this.f20402d = fVar;
            return this;
        }
    }

    final class i extends V3.b {

        /* renamed from: b  reason: collision with root package name */
        final boolean f20408b;

        /* renamed from: c  reason: collision with root package name */
        final int f20409c;

        /* renamed from: d  reason: collision with root package name */
        final int f20410d;

        i(boolean z4, int i5, int i6) {
            super("OkHttp %s ping %08x%08x", g.this.f20361d, Integer.valueOf(i5), Integer.valueOf(i6));
            this.f20408b = z4;
            this.f20409c = i5;
            this.f20410d = i6;
        }

        public void e() {
            g.this.J(this.f20408b, this.f20409c, this.f20410d);
        }
    }

    g(C0200g gVar) {
        int i5;
        C0200g gVar2 = gVar;
        m mVar = new m();
        this.f20372o = mVar;
        this.f20373p = false;
        this.f20377t = new LinkedHashSet();
        this.f20367j = gVar2.f20404f;
        boolean z4 = gVar2.f20405g;
        this.f20358a = z4;
        this.f20359b = gVar2.f20403e;
        if (z4) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        this.f20363f = i5;
        if (z4) {
            this.f20363f = i5 + 2;
        }
        if (z4) {
            this.f20371n.i(7, 16777216);
        }
        String str = gVar2.f20400b;
        this.f20361d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, V3.c.B(V3.c.o("OkHttp %s Writer", str), false));
        this.f20365h = scheduledThreadPoolExecutor;
        if (gVar2.f20406h != 0) {
            i iVar = new i(false, 0, 0);
            int i6 = gVar2.f20406h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, (long) i6, (long) i6, TimeUnit.MILLISECONDS);
        }
        this.f20366i = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), V3.c.B(V3.c.o("OkHttp %s Push Observer", str), true));
        mVar.i(7, 65535);
        mVar.i(5, 16384);
        this.f20370m = (long) mVar.d();
        this.f20374q = gVar2.f20399a;
        this.f20375r = new j(gVar2.f20402d, z4);
        this.f20376s = new j(new h(gVar2.f20401c, z4));
    }

    /* access modifiers changed from: private */
    public void p() {
        try {
            b bVar = b.PROTOCOL_ERROR;
            o(bVar, bVar);
        } catch (IOException unused) {
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private a4.i u(int r10, java.util.List r11, boolean r12) {
        /*
            r9 = this;
            r3 = r12 ^ 1
            a4.j r6 = r9.f20375r
            monitor-enter(r6)
            monitor-enter(r9)     // Catch:{ all -> 0x0082 }
            int r0 = r9.f20363f     // Catch:{ all -> 0x0076 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0018
            a4.b r0 = a4.b.REFUSED_STREAM     // Catch:{ all -> 0x0013 }
            r9.F(r0)     // Catch:{ all -> 0x0013 }
            goto L_0x0018
        L_0x0013:
            r0 = move-exception
            r10 = r0
            r2 = r9
            goto L_0x0080
        L_0x0018:
            boolean r0 = r9.f20364g     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0079
            int r1 = r9.f20363f     // Catch:{ all -> 0x0076 }
            int r0 = r1 + 2
            r9.f20363f = r0     // Catch:{ all -> 0x0076 }
            a4.i r0 = new a4.i     // Catch:{ all -> 0x0076 }
            r4 = 0
            r2 = r9
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x003d }
            if (r12 == 0) goto L_0x0040
            long r11 = r2.f20370m     // Catch:{ all -> 0x003d }
            r7 = 0
            int r11 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x0040
            long r11 = r0.f20431b     // Catch:{ all -> 0x003d }
            int r11 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r11 != 0) goto L_0x003b
            goto L_0x0040
        L_0x003b:
            r11 = 0
            goto L_0x0041
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            r10 = r0
            goto L_0x0080
        L_0x0040:
            r11 = 1
        L_0x0041:
            boolean r12 = r0.k()     // Catch:{ all -> 0x003d }
            if (r12 == 0) goto L_0x0050
            java.util.Map r12 = r2.f20360c     // Catch:{ all -> 0x003d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x003d }
            r12.put(r4, r0)     // Catch:{ all -> 0x003d }
        L_0x0050:
            monitor-exit(r9)     // Catch:{ all -> 0x003d }
            if (r10 != 0) goto L_0x005c
            a4.j r12 = r2.f20375r     // Catch:{ all -> 0x0059 }
            r12.x(r3, r1, r10, r5)     // Catch:{ all -> 0x0059 }
            goto L_0x0065
        L_0x0059:
            r0 = move-exception
        L_0x005a:
            r10 = r0
            goto L_0x0085
        L_0x005c:
            boolean r12 = r2.f20358a     // Catch:{ all -> 0x0059 }
            if (r12 != 0) goto L_0x006e
            a4.j r12 = r2.f20375r     // Catch:{ all -> 0x0059 }
            r12.t(r10, r1, r5)     // Catch:{ all -> 0x0059 }
        L_0x0065:
            monitor-exit(r6)     // Catch:{ all -> 0x0059 }
            if (r11 == 0) goto L_0x006d
            a4.j r10 = r2.f20375r
            r10.flush()
        L_0x006d:
            return r0
        L_0x006e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            r10.<init>(r11)     // Catch:{ all -> 0x0059 }
            throw r10     // Catch:{ all -> 0x0059 }
        L_0x0076:
            r0 = move-exception
            r2 = r9
            goto L_0x003e
        L_0x0079:
            r2 = r9
            a4.a r10 = new a4.a     // Catch:{ all -> 0x003d }
            r10.<init>()     // Catch:{ all -> 0x003d }
            throw r10     // Catch:{ all -> 0x003d }
        L_0x0080:
            monitor-exit(r9)     // Catch:{ all -> 0x003d }
            throw r10     // Catch:{ all -> 0x0059 }
        L_0x0082:
            r0 = move-exception
            r2 = r9
            goto L_0x005a
        L_0x0085:
            monitor-exit(r6)     // Catch:{ all -> 0x0059 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.g.u(int, java.util.List, boolean):a4.i");
    }

    /* access modifiers changed from: package-private */
    public void A(int i5, b bVar) {
        this.f20366i.execute(new f("OkHttp %s Push Reset[%s]", new Object[]{this.f20361d, Integer.valueOf(i5)}, i5, bVar));
    }

    /* access modifiers changed from: package-private */
    public boolean B(int i5) {
        if (i5 == 0 || (i5 & 1) != 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public synchronized i C(int i5) {
        i iVar;
        iVar = (i) this.f20360c.remove(Integer.valueOf(i5));
        notifyAll();
        return iVar;
    }

    public void F(b bVar) {
        synchronized (this.f20375r) {
            synchronized (this) {
                if (!this.f20364g) {
                    this.f20364g = true;
                    int i5 = this.f20362e;
                    this.f20375r.o(i5, bVar, V3.c.f19699a);
                }
            }
        }
    }

    public void G() {
        H(true);
    }

    /* access modifiers changed from: package-private */
    public void H(boolean z4) {
        if (z4) {
            this.f20375r.d();
            this.f20375r.v(this.f20371n);
            int d5 = this.f20371n.d();
            if (d5 != 65535) {
                this.f20375r.y(0, (long) (d5 - 65535));
            }
        }
        new Thread(this.f20376s).start();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.f20375r.q());
        r6 = (long) r2;
        r8.f20370m -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void I(int r9, boolean r10, e4.C2356e r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto L_0x000d
            a4.j r12 = r8.f20375r
            r12.l(r10, r9, r11, r3)
            return
        L_0x000d:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0060
            monitor-enter(r8)
        L_0x0012:
            long r4 = r8.f20370m     // Catch:{ InterruptedException -> 0x0058 }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0032
            java.util.Map r2 = r8.f20360c     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r2 = r2.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r2 == 0) goto L_0x002a
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            r9 = move-exception
            goto L_0x005e
        L_0x002a:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0032:
            long r4 = java.lang.Math.min(r12, r4)     // Catch:{ all -> 0x0028 }
            int r2 = (int) r4     // Catch:{ all -> 0x0028 }
            a4.j r4 = r8.f20375r     // Catch:{ all -> 0x0028 }
            int r4 = r4.q()     // Catch:{ all -> 0x0028 }
            int r2 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x0028 }
            long r4 = r8.f20370m     // Catch:{ all -> 0x0028 }
            long r6 = (long) r2     // Catch:{ all -> 0x0028 }
            long r4 = r4 - r6
            r8.f20370m = r4     // Catch:{ all -> 0x0028 }
            monitor-exit(r8)     // Catch:{ all -> 0x0028 }
            long r12 = r12 - r6
            a4.j r4 = r8.f20375r
            if (r10 == 0) goto L_0x0053
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0053:
            r5 = r3
        L_0x0054:
            r4.l(r5, r9, r11, r2)
            goto L_0x000d
        L_0x0058:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0028 }
            r9.<init>()     // Catch:{ all -> 0x0028 }
            throw r9     // Catch:{ all -> 0x0028 }
        L_0x005e:
            monitor-exit(r8)     // Catch:{ all -> 0x0028 }
            throw r9
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.g.I(int, boolean, e4.e, long):void");
    }

    /* access modifiers changed from: package-private */
    public void J(boolean z4, int i5, int i6) {
        boolean z5;
        if (!z4) {
            synchronized (this) {
                z5 = this.f20368k;
                this.f20368k = true;
            }
            if (z5) {
                p();
                return;
            }
        }
        try {
            this.f20375r.s(z4, i5, i6);
        } catch (IOException unused) {
            p();
        }
    }

    /* access modifiers changed from: package-private */
    public void K(int i5, b bVar) {
        this.f20375r.u(i5, bVar);
    }

    /* access modifiers changed from: package-private */
    public void L(int i5, b bVar) {
        try {
            this.f20365h.execute(new a("OkHttp %s stream %d", new Object[]{this.f20361d, Integer.valueOf(i5)}, i5, bVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void M(int i5, long j5) {
        try {
            this.f20365h.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f20361d, Integer.valueOf(i5)}, i5, j5));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void close() {
        o(b.NO_ERROR, b.CANCEL);
    }

    public void flush() {
        this.f20375r.flush();
    }

    /* access modifiers changed from: package-private */
    public void n(long j5) {
        this.f20370m += j5;
        if (j5 > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void o(b bVar, b bVar2) {
        i[] iVarArr = null;
        try {
            F(bVar);
            e = null;
        } catch (IOException e5) {
            e = e5;
        }
        synchronized (this) {
            try {
                if (!this.f20360c.isEmpty()) {
                    iVarArr = (i[]) this.f20360c.values().toArray(new i[this.f20360c.size()]);
                    this.f20360c.clear();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (iVarArr != null) {
            for (i d5 : iVarArr) {
                try {
                    d5.d(bVar2);
                } catch (IOException e6) {
                    if (e != null) {
                        e = e6;
                    }
                }
            }
        }
        try {
            this.f20375r.close();
        } catch (IOException e7) {
            if (e == null) {
                e = e7;
            }
        }
        try {
            this.f20374q.close();
        } catch (IOException e8) {
            e = e8;
        }
        this.f20365h.shutdown();
        this.f20366i.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized i q(int i5) {
        return (i) this.f20360c.get(Integer.valueOf(i5));
    }

    public synchronized boolean s() {
        return this.f20364g;
    }

    public synchronized int t() {
        return this.f20372o.e(Integer.MAX_VALUE);
    }

    public i v(List list, boolean z4) {
        return u(0, list, z4);
    }

    /* access modifiers changed from: package-private */
    public void x(int i5, C2358g gVar, int i6, boolean z4) {
        C2356e eVar = new C2356e();
        long j5 = (long) i6;
        gVar.require(j5);
        gVar.e(eVar, j5);
        if (eVar.size() == j5) {
            this.f20366i.execute(new e("OkHttp %s Push Data[%s]", new Object[]{this.f20361d, Integer.valueOf(i5)}, i5, eVar, i6, z4));
            return;
        }
        throw new IOException(eVar.size() + " != " + i6);
    }

    /* access modifiers changed from: package-private */
    public void y(int i5, List list, boolean z4) {
        try {
            this.f20366i.execute(new d("OkHttp %s Push Headers[%s]", new Object[]{this.f20361d, Integer.valueOf(i5)}, i5, list, z4));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void z(int i5, List list) {
        Throwable th;
        synchronized (this) {
            try {
                if (this.f20377t.contains(Integer.valueOf(i5))) {
                    try {
                        L(i5, b.PROTOCOL_ERROR);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            throw th;
                        }
                        throw th;
                    }
                } else {
                    this.f20377t.add(Integer.valueOf(i5));
                    try {
                        try {
                            this.f20366i.execute(new c("OkHttp %s Push Request[%s]", new Object[]{this.f20361d, Integer.valueOf(i5)}, i5, list));
                        } catch (RejectedExecutionException unused) {
                        }
                    } catch (RejectedExecutionException unused2) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    class j extends V3.b implements h.b {

        /* renamed from: b  reason: collision with root package name */
        final h f20412b;

        class a extends V3.b {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ i f20414b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, i iVar) {
                super(str, objArr);
                this.f20414b = iVar;
            }

            public void e() {
                try {
                    g.this.f20359b.b(this.f20414b);
                } catch (IOException e5) {
                    c4.f i5 = c4.f.i();
                    i5.p(4, "Http2Connection.Listener failure for " + g.this.f20361d, e5);
                    try {
                        this.f20414b.d(b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        class b extends V3.b {
            b(String str, Object... objArr) {
                super(str, objArr);
            }

            public void e() {
                g gVar = g.this;
                gVar.f20359b.a(gVar);
            }
        }

        class c extends V3.b {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ m f20417b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(String str, Object[] objArr, m mVar) {
                super(str, objArr);
                this.f20417b = mVar;
            }

            public void e() {
                try {
                    g.this.f20375r.a(this.f20417b);
                } catch (IOException unused) {
                    g.this.p();
                }
            }
        }

        j(h hVar) {
            super("OkHttp %s", g.this.f20361d);
            this.f20412b = hVar;
        }

        private void f(m mVar) {
            try {
                g.this.f20365h.execute(new c("OkHttp %s ACK Settings", new Object[]{g.this.f20361d}, mVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void a(int i5, b bVar, C2359h hVar) {
            i[] iVarArr;
            hVar.F();
            synchronized (g.this) {
                iVarArr = (i[]) g.this.f20360c.values().toArray(new i[g.this.f20360c.size()]);
                g.this.f20364g = true;
            }
            for (i iVar : iVarArr) {
                if (iVar.g() > i5 && iVar.j()) {
                    iVar.p(b.REFUSED_STREAM);
                    g.this.C(iVar.g());
                }
            }
        }

        public void b(boolean z4, int i5, C2358g gVar, int i6) {
            if (g.this.B(i5)) {
                g.this.x(i5, gVar, i6, z4);
                return;
            }
            i q5 = g.this.q(i5);
            if (q5 == null) {
                g.this.L(i5, b.PROTOCOL_ERROR);
                gVar.skip((long) i6);
                return;
            }
            q5.m(gVar, i6);
            if (z4) {
                q5.n();
            }
        }

        /* JADX WARNING: type inference failed for: r1v12, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(boolean r11, a4.m r12) {
            /*
                r10 = this;
                a4.g r0 = a4.g.this
                monitor-enter(r0)
                a4.g r1 = a4.g.this     // Catch:{ all -> 0x0015 }
                a4.m r1 = r1.f20372o     // Catch:{ all -> 0x0015 }
                int r1 = r1.d()     // Catch:{ all -> 0x0015 }
                if (r11 == 0) goto L_0x0018
                a4.g r11 = a4.g.this     // Catch:{ all -> 0x0015 }
                a4.m r11 = r11.f20372o     // Catch:{ all -> 0x0015 }
                r11.a()     // Catch:{ all -> 0x0015 }
                goto L_0x0018
            L_0x0015:
                r11 = move-exception
                goto L_0x0096
            L_0x0018:
                a4.g r11 = a4.g.this     // Catch:{ all -> 0x0015 }
                a4.m r11 = r11.f20372o     // Catch:{ all -> 0x0015 }
                r11.h(r12)     // Catch:{ all -> 0x0015 }
                r10.f(r12)     // Catch:{ all -> 0x0015 }
                a4.g r11 = a4.g.this     // Catch:{ all -> 0x0015 }
                a4.m r11 = r11.f20372o     // Catch:{ all -> 0x0015 }
                int r11 = r11.d()     // Catch:{ all -> 0x0015 }
                r12 = -1
                r2 = 1
                r3 = 0
                r5 = 0
                if (r11 == r12) goto L_0x0066
                if (r11 == r1) goto L_0x0066
                int r11 = r11 - r1
                long r11 = (long) r11     // Catch:{ all -> 0x0015 }
                a4.g r1 = a4.g.this     // Catch:{ all -> 0x0015 }
                boolean r6 = r1.f20373p     // Catch:{ all -> 0x0015 }
                if (r6 != 0) goto L_0x0042
                r1.n(r11)     // Catch:{ all -> 0x0015 }
                a4.g r1 = a4.g.this     // Catch:{ all -> 0x0015 }
                r1.f20373p = r2     // Catch:{ all -> 0x0015 }
            L_0x0042:
                a4.g r1 = a4.g.this     // Catch:{ all -> 0x0015 }
                java.util.Map r1 = r1.f20360c     // Catch:{ all -> 0x0015 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0015 }
                if (r1 != 0) goto L_0x0067
                a4.g r1 = a4.g.this     // Catch:{ all -> 0x0015 }
                java.util.Map r1 = r1.f20360c     // Catch:{ all -> 0x0015 }
                java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0015 }
                a4.g r5 = a4.g.this     // Catch:{ all -> 0x0015 }
                java.util.Map r5 = r5.f20360c     // Catch:{ all -> 0x0015 }
                int r5 = r5.size()     // Catch:{ all -> 0x0015 }
                a4.i[] r5 = new a4.i[r5]     // Catch:{ all -> 0x0015 }
                java.lang.Object[] r1 = r1.toArray(r5)     // Catch:{ all -> 0x0015 }
                r5 = r1
                a4.i[] r5 = (a4.i[]) r5     // Catch:{ all -> 0x0015 }
                goto L_0x0067
            L_0x0066:
                r11 = r3
            L_0x0067:
                java.util.concurrent.ExecutorService r1 = a4.g.f20357u     // Catch:{ all -> 0x0015 }
                a4.g$j$b r6 = new a4.g$j$b     // Catch:{ all -> 0x0015 }
                java.lang.String r7 = "OkHttp %s settings"
                a4.g r8 = a4.g.this     // Catch:{ all -> 0x0015 }
                java.lang.String r8 = r8.f20361d     // Catch:{ all -> 0x0015 }
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0015 }
                r9 = 0
                r2[r9] = r8     // Catch:{ all -> 0x0015 }
                r6.<init>(r7, r2)     // Catch:{ all -> 0x0015 }
                r1.execute(r6)     // Catch:{ all -> 0x0015 }
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                if (r5 == 0) goto L_0x0095
                int r0 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
                if (r0 == 0) goto L_0x0095
                int r0 = r5.length
            L_0x0086:
                if (r9 >= r0) goto L_0x0095
                r1 = r5[r9]
                monitor-enter(r1)
                r1.a(r11)     // Catch:{ all -> 0x0092 }
                monitor-exit(r1)     // Catch:{ all -> 0x0092 }
                int r9 = r9 + 1
                goto L_0x0086
            L_0x0092:
                r11 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0092 }
                throw r11
            L_0x0095:
                return
            L_0x0096:
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: a4.g.j.c(boolean, a4.m):void");
        }

        public void d(int i5, b bVar) {
            if (g.this.B(i5)) {
                g.this.A(i5, bVar);
                return;
            }
            i C4 = g.this.C(i5);
            if (C4 != null) {
                C4.p(bVar);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r0 = a4.b.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r4.f20413c.o(r0, r0);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e() {
            /*
                r4 = this;
                a4.b r0 = a4.b.INTERNAL_ERROR
                a4.h r1 = r4.f20412b     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                r1.l(r4)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            L_0x0007:
                a4.h r1 = r4.f20412b     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                r2 = 0
                boolean r1 = r1.d(r2, r4)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                a4.b r1 = a4.b.NO_ERROR     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                a4.b r0 = a4.b.CANCEL     // Catch:{ IOException -> 0x0026 }
                a4.g r2 = a4.g.this     // Catch:{ IOException -> 0x001a }
                r2.o(r1, r0)     // Catch:{ IOException -> 0x001a }
            L_0x001a:
                a4.h r0 = r4.f20412b
                V3.c.d(r0)
                goto L_0x002e
            L_0x0020:
                r2 = move-exception
                goto L_0x002f
            L_0x0022:
                r2 = move-exception
                r1 = r0
                goto L_0x002f
            L_0x0025:
                r1 = r0
            L_0x0026:
                a4.b r0 = a4.b.PROTOCOL_ERROR     // Catch:{ all -> 0x0020 }
                a4.g r1 = a4.g.this     // Catch:{ IOException -> 0x001a }
                r1.o(r0, r0)     // Catch:{ IOException -> 0x001a }
                goto L_0x001a
            L_0x002e:
                return
            L_0x002f:
                a4.g r3 = a4.g.this     // Catch:{ IOException -> 0x0034 }
                r3.o(r1, r0)     // Catch:{ IOException -> 0x0034 }
            L_0x0034:
                a4.h r0 = r4.f20412b
                V3.c.d(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: a4.g.j.e():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006f, code lost:
            r0.o(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0072, code lost:
            if (r7 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0074, code lost:
            r0.n();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r10, int r11, int r12, java.util.List r13) {
            /*
                r9 = this;
                a4.g r12 = a4.g.this
                boolean r12 = r12.B(r11)
                if (r12 == 0) goto L_0x000e
                a4.g r12 = a4.g.this
                r12.y(r11, r13, r10)
                return
            L_0x000e:
                a4.g r12 = a4.g.this
                monitor-enter(r12)
                a4.g r0 = a4.g.this     // Catch:{ all -> 0x0021 }
                a4.i r0 = r0.q(r11)     // Catch:{ all -> 0x0021 }
                if (r0 != 0) goto L_0x006c
                a4.g r0 = a4.g.this     // Catch:{ all -> 0x0021 }
                boolean r1 = r0.f20364g     // Catch:{ all -> 0x0021 }
                if (r1 == 0) goto L_0x0024
                monitor-exit(r12)     // Catch:{ all -> 0x0021 }
                return
            L_0x0021:
                r0 = move-exception
                r10 = r0
                goto L_0x0078
            L_0x0024:
                int r1 = r0.f20362e     // Catch:{ all -> 0x0021 }
                if (r11 > r1) goto L_0x002a
                monitor-exit(r12)     // Catch:{ all -> 0x0021 }
                return
            L_0x002a:
                int r1 = r11 % 2
                int r0 = r0.f20363f     // Catch:{ all -> 0x0021 }
                r2 = 2
                int r0 = r0 % r2
                if (r1 != r0) goto L_0x0034
                monitor-exit(r12)     // Catch:{ all -> 0x0021 }
                return
            L_0x0034:
                a4.i r3 = new a4.i     // Catch:{ all -> 0x0021 }
                a4.g r5 = a4.g.this     // Catch:{ all -> 0x0021 }
                r6 = 0
                r7 = r10
                r4 = r11
                r8 = r13
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0021 }
                a4.g r10 = a4.g.this     // Catch:{ all -> 0x0021 }
                r10.f20362e = r4     // Catch:{ all -> 0x0021 }
                java.util.Map r10 = r10.f20360c     // Catch:{ all -> 0x0021 }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0021 }
                r10.put(r11, r3)     // Catch:{ all -> 0x0021 }
                java.util.concurrent.ExecutorService r10 = a4.g.f20357u     // Catch:{ all -> 0x0021 }
                a4.g$j$a r11 = new a4.g$j$a     // Catch:{ all -> 0x0021 }
                java.lang.String r13 = "OkHttp %s stream %d"
                a4.g r0 = a4.g.this     // Catch:{ all -> 0x0021 }
                java.lang.String r0 = r0.f20361d     // Catch:{ all -> 0x0021 }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0021 }
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0021 }
                r4 = 0
                r2[r4] = r0     // Catch:{ all -> 0x0021 }
                r0 = 1
                r2[r0] = r1     // Catch:{ all -> 0x0021 }
                r11.<init>(r13, r2, r3)     // Catch:{ all -> 0x0021 }
                r10.execute(r11)     // Catch:{ all -> 0x0021 }
                monitor-exit(r12)     // Catch:{ all -> 0x0021 }
                return
            L_0x006c:
                r7 = r10
                r8 = r13
                monitor-exit(r12)     // Catch:{ all -> 0x0021 }
                r0.o(r8)
                if (r7 == 0) goto L_0x0077
                r0.n()
            L_0x0077:
                return
            L_0x0078:
                monitor-exit(r12)     // Catch:{ all -> 0x0021 }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: a4.g.j.headers(boolean, int, int, java.util.List):void");
        }

        public void ping(boolean z4, int i5, int i6) {
            if (z4) {
                synchronized (g.this) {
                    boolean unused = g.this.f20368k = false;
                    g.this.notifyAll();
                }
                return;
            }
            try {
                g.this.f20365h.execute(new i(true, i5, i6));
            } catch (RejectedExecutionException unused2) {
            }
        }

        public void pushPromise(int i5, int i6, List list) {
            g.this.z(i6, list);
        }

        public void windowUpdate(int i5, long j5) {
            if (i5 == 0) {
                synchronized (g.this) {
                    g gVar = g.this;
                    gVar.f20370m += j5;
                    gVar.notifyAll();
                }
                return;
            }
            i q5 = g.this.q(i5);
            if (q5 != null) {
                synchronized (q5) {
                    q5.a(j5);
                }
            }
        }

        public void ackSettings() {
        }

        public void priority(int i5, int i6, int i7, boolean z4) {
        }
    }

    public static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        public static final h f20407a = new a();

        class a extends h {
            a() {
            }

            public void b(i iVar) {
                iVar.d(b.REFUSED_STREAM);
            }
        }

        public abstract void b(i iVar);

        public void a(g gVar) {
        }
    }
}
