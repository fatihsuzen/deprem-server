package X3;

import U3.B;
import U3.C2202a;
import U3.e;
import U3.i;
import U3.o;
import U3.s;
import U3.u;
import X3.f;
import Y3.c;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final C2202a f20103a;

    /* renamed from: b  reason: collision with root package name */
    private f.a f20104b;

    /* renamed from: c  reason: collision with root package name */
    private B f20105c;

    /* renamed from: d  reason: collision with root package name */
    private final i f20106d;

    /* renamed from: e  reason: collision with root package name */
    public final e f20107e;

    /* renamed from: f  reason: collision with root package name */
    public final o f20108f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f20109g;

    /* renamed from: h  reason: collision with root package name */
    private final f f20110h;

    /* renamed from: i  reason: collision with root package name */
    private int f20111i;

    /* renamed from: j  reason: collision with root package name */
    private c f20112j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f20113k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f20114l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f20115m;

    /* renamed from: n  reason: collision with root package name */
    private c f20116n;

    public static final class a extends WeakReference {

        /* renamed from: a  reason: collision with root package name */
        public final Object f20117a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f20117a = obj;
        }
    }

    public g(i iVar, C2202a aVar, e eVar, o oVar, Object obj) {
        this.f20106d = iVar;
        this.f20103a = aVar;
        this.f20107e = eVar;
        this.f20108f = oVar;
        this.f20110h = new f(aVar, o(), eVar, oVar);
        this.f20109g = obj;
    }

    private Socket d(boolean z4, boolean z5, boolean z6) {
        Socket socket;
        if (z6) {
            this.f20116n = null;
        }
        if (z5) {
            this.f20114l = true;
        }
        c cVar = this.f20112j;
        if (cVar != null) {
            if (z4) {
                cVar.f20085k = true;
            }
            if (this.f20116n == null && (this.f20114l || cVar.f20085k)) {
                k(cVar);
                if (this.f20112j.f20088n.isEmpty()) {
                    this.f20112j.f20089o = System.nanoTime();
                    if (V3.a.f19697a.e(this.f20106d, this.f20112j)) {
                        socket = this.f20112j.q();
                        this.f20112j = null;
                        return socket;
                    }
                }
                socket = null;
                this.f20112j = null;
                return socket;
            }
        }
        return null;
    }

    private c e(int i5, int i6, int i7, int i8, boolean z4) {
        c cVar;
        Socket m5;
        c cVar2;
        Socket socket;
        boolean z5;
        B b5;
        boolean z6;
        c cVar3;
        f.a aVar;
        synchronized (this.f20106d) {
            try {
                if (this.f20114l) {
                    throw new IllegalStateException("released");
                } else if (this.f20116n != null) {
                    throw new IllegalStateException("codec != null");
                } else if (!this.f20115m) {
                    cVar = this.f20112j;
                    m5 = m();
                    cVar2 = this.f20112j;
                    socket = null;
                    if (cVar2 != null) {
                        cVar = null;
                    } else {
                        cVar2 = null;
                    }
                    if (!this.f20113k) {
                        cVar = null;
                    }
                    if (cVar2 == null) {
                        V3.a.f19697a.h(this.f20106d, this.f20103a, this, (B) null);
                        c cVar4 = this.f20112j;
                        if (cVar4 != null) {
                            z5 = true;
                            cVar2 = cVar4;
                            b5 = null;
                        } else {
                            b5 = this.f20105c;
                        }
                    } else {
                        b5 = null;
                    }
                    z5 = false;
                } else {
                    throw new IOException("Canceled");
                }
            } finally {
                Throwable th = th;
            }
        }
        V3.c.e(m5);
        if (cVar != null) {
            this.f20108f.h(this.f20107e, cVar);
        }
        if (z5) {
            this.f20108f.g(this.f20107e, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (b5 != null || ((aVar = this.f20104b) != null && aVar.b())) {
            z6 = false;
        } else {
            this.f20104b = this.f20110h.e();
            z6 = true;
        }
        synchronized (this.f20106d) {
            try {
                if (!this.f20115m) {
                    if (z6) {
                        List a5 = this.f20104b.a();
                        int size = a5.size();
                        int i9 = 0;
                        while (true) {
                            if (i9 >= size) {
                                break;
                            }
                            B b6 = (B) a5.get(i9);
                            V3.a.f19697a.h(this.f20106d, this.f20103a, this, b6);
                            c cVar5 = this.f20112j;
                            if (cVar5 != null) {
                                this.f20105c = b6;
                                z5 = true;
                                cVar2 = cVar5;
                                break;
                            }
                            i9++;
                        }
                    }
                    if (!z5) {
                        if (b5 == null) {
                            b5 = this.f20104b.c();
                        }
                        this.f20105c = b5;
                        this.f20111i = 0;
                        cVar2 = new c(this.f20106d, b5);
                        a(cVar2, false);
                    }
                    cVar3 = cVar2;
                } else {
                    throw new IOException("Canceled");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z5) {
            this.f20108f.g(this.f20107e, cVar3);
            return cVar3;
        }
        cVar3.c(i5, i6, i7, i8, z4, this.f20107e, this.f20108f);
        o().a(cVar3.p());
        synchronized (this.f20106d) {
            try {
                this.f20113k = true;
                V3.a.f19697a.i(this.f20106d, cVar3);
                if (cVar3.m()) {
                    socket = V3.a.f19697a.f(this.f20106d, this.f20103a, this);
                    cVar3 = this.f20112j;
                }
            } catch (Throwable th3) {
                while (true) {
                    throw th3;
                }
            }
        }
        V3.c.e(socket);
        this.f20108f.g(this.f20107e, cVar3);
        return cVar3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r0.l(r10) != false) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private X3.c f(int r5, int r6, int r7, int r8, boolean r9, boolean r10) {
        /*
            r4 = this;
        L_0x0000:
            X3.c r0 = r4.e(r5, r6, r7, r8, r9)
            r1 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            U3.i r2 = r5.f20106d
            monitor-enter(r2)
            int r3 = r0.f20086l     // Catch:{ all -> 0x0013 }
            if (r3 != 0) goto L_0x0016
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            return r0
        L_0x0013:
            r0 = move-exception
            r6 = r0
            goto L_0x0027
        L_0x0016:
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            boolean r2 = r0.l(r10)
            if (r2 != 0) goto L_0x0026
            r4.i()
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r1
            goto L_0x0000
        L_0x0026:
            return r0
        L_0x0027:
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.g.f(int, int, int, int, boolean, boolean):X3.c");
    }

    private void k(c cVar) {
        int size = cVar.f20088n.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (((Reference) cVar.f20088n.get(i5)).get() == this) {
                cVar.f20088n.remove(i5);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private Socket m() {
        c cVar = this.f20112j;
        if (cVar == null || !cVar.f20085k) {
            return null;
        }
        return d(false, false, true);
    }

    private d o() {
        return V3.a.f19697a.j(this.f20106d);
    }

    public void a(c cVar, boolean z4) {
        if (this.f20112j == null) {
            this.f20112j = cVar;
            this.f20113k = z4;
            cVar.f20088n.add(new a(this, this.f20109g));
            return;
        }
        throw new IllegalStateException();
    }

    public c b() {
        c cVar;
        synchronized (this.f20106d) {
            cVar = this.f20116n;
        }
        return cVar;
    }

    public synchronized c c() {
        return this.f20112j;
    }

    public boolean g() {
        if (this.f20105c != null) {
            return true;
        }
        f.a aVar = this.f20104b;
        if ((aVar == null || !aVar.b()) && !this.f20110h.c()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    public c h(u uVar, s.a aVar, boolean z4) {
        try {
            c o5 = f(aVar.connectTimeoutMillis(), aVar.readTimeoutMillis(), aVar.writeTimeoutMillis(), uVar.s(), uVar.A(), z4).o(uVar, aVar, this);
            synchronized (this.f20106d) {
                this.f20116n = o5;
            }
            return o5;
        } catch (IOException e5) {
            throw new e(e5);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void i() {
        c cVar;
        Socket d5;
        synchronized (this.f20106d) {
            cVar = this.f20112j;
            d5 = d(true, false, false);
            if (this.f20112j != null) {
                cVar = null;
            }
        }
        V3.c.e(d5);
        if (cVar != null) {
            this.f20108f.h(this.f20107e, cVar);
        }
    }

    public void j() {
        c cVar;
        Socket d5;
        synchronized (this.f20106d) {
            cVar = this.f20112j;
            d5 = d(false, true, false);
            if (this.f20112j != null) {
                cVar = null;
            }
        }
        V3.c.e(d5);
        if (cVar != null) {
            this.f20108f.h(this.f20107e, cVar);
        }
    }

    public Socket l(c cVar) {
        if (this.f20116n == null && this.f20112j.f20088n.size() == 1) {
            Socket d5 = d(true, false, false);
            this.f20112j = cVar;
            cVar.f20088n.add((Reference) this.f20112j.f20088n.get(0));
            return d5;
        }
        throw new IllegalStateException();
    }

    public B n() {
        return this.f20105c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0051 A[Catch:{ all -> 0x0018 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p(java.io.IOException r7) {
        /*
            r6 = this;
            U3.i r0 = r6.f20106d
            monitor-enter(r0)
            boolean r1 = r7 instanceof a4.n     // Catch:{ all -> 0x0018 }
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0023
            a4.n r7 = (a4.n) r7     // Catch:{ all -> 0x0018 }
            a4.b r7 = r7.f20470a     // Catch:{ all -> 0x0018 }
            a4.b r1 = a4.b.REFUSED_STREAM     // Catch:{ all -> 0x0018 }
            if (r7 != r1) goto L_0x001a
            int r5 = r6.f20111i     // Catch:{ all -> 0x0018 }
            int r5 = r5 + r3
            r6.f20111i = r5     // Catch:{ all -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            r7 = move-exception
            goto L_0x0065
        L_0x001a:
            if (r7 != r1) goto L_0x0020
            int r7 = r6.f20111i     // Catch:{ all -> 0x0018 }
            if (r7 <= r3) goto L_0x0046
        L_0x0020:
            r6.f20105c = r2     // Catch:{ all -> 0x0018 }
            goto L_0x0044
        L_0x0023:
            X3.c r1 = r6.f20112j     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0046
            boolean r1 = r1.m()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0031
            boolean r1 = r7 instanceof a4.a     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0046
        L_0x0031:
            X3.c r1 = r6.f20112j     // Catch:{ all -> 0x0018 }
            int r1 = r1.f20086l     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x0044
            U3.B r1 = r6.f20105c     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0042
            if (r7 == 0) goto L_0x0042
            X3.f r5 = r6.f20110h     // Catch:{ all -> 0x0018 }
            r5.a(r1, r7)     // Catch:{ all -> 0x0018 }
        L_0x0042:
            r6.f20105c = r2     // Catch:{ all -> 0x0018 }
        L_0x0044:
            r7 = r3
            goto L_0x0047
        L_0x0046:
            r7 = r4
        L_0x0047:
            X3.c r1 = r6.f20112j     // Catch:{ all -> 0x0018 }
            java.net.Socket r7 = r6.d(r7, r4, r3)     // Catch:{ all -> 0x0018 }
            X3.c r3 = r6.f20112j     // Catch:{ all -> 0x0018 }
            if (r3 != 0) goto L_0x0057
            boolean r3 = r6.f20113k     // Catch:{ all -> 0x0018 }
            if (r3 != 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r2 = r1
        L_0x0057:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            V3.c.e(r7)
            if (r2 == 0) goto L_0x0064
            U3.o r7 = r6.f20108f
            U3.e r0 = r6.f20107e
            r7.h(r0, r2)
        L_0x0064:
            return
        L_0x0065:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.g.p(java.io.IOException):void");
    }

    public void q(boolean z4, c cVar, long j5, IOException iOException) {
        c cVar2;
        Socket d5;
        boolean z5;
        this.f20108f.p(this.f20107e, j5);
        synchronized (this.f20106d) {
            if (cVar != null) {
                try {
                    if (cVar == this.f20116n) {
                        if (!z4) {
                            this.f20112j.f20086l++;
                        }
                        cVar2 = this.f20112j;
                        d5 = d(z4, false, true);
                        if (this.f20112j != null) {
                            cVar2 = null;
                        }
                        z5 = this.f20114l;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IllegalStateException("expected " + this.f20116n + " but was " + cVar);
        }
        V3.c.e(d5);
        if (cVar2 != null) {
            this.f20108f.h(this.f20107e, cVar2);
        }
        if (iOException != null) {
            this.f20108f.b(this.f20107e, iOException);
        } else if (z5) {
            this.f20108f.a(this.f20107e);
        }
    }

    public String toString() {
        c c5 = c();
        if (c5 != null) {
            return c5.toString();
        }
        return this.f20103a.toString();
    }
}
