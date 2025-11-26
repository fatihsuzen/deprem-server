package a4;

import e4.C2354c;
import e4.C2356e;
import e4.C2358g;
import e4.X;
import e4.Z;
import e4.a0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    long f20430a = 0;

    /* renamed from: b  reason: collision with root package name */
    long f20431b;

    /* renamed from: c  reason: collision with root package name */
    final int f20432c;

    /* renamed from: d  reason: collision with root package name */
    final g f20433d;

    /* renamed from: e  reason: collision with root package name */
    private final List f20434e;

    /* renamed from: f  reason: collision with root package name */
    private List f20435f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20436g;

    /* renamed from: h  reason: collision with root package name */
    private final b f20437h;

    /* renamed from: i  reason: collision with root package name */
    final a f20438i;

    /* renamed from: j  reason: collision with root package name */
    final c f20439j = new c();

    /* renamed from: k  reason: collision with root package name */
    final c f20440k = new c();

    /* renamed from: l  reason: collision with root package name */
    b f20441l = null;

    final class a implements X {

        /* renamed from: a  reason: collision with root package name */
        private final C2356e f20442a = new C2356e();

        /* renamed from: b  reason: collision with root package name */
        boolean f20443b;

        /* renamed from: c  reason: collision with root package name */
        boolean f20444c;

        a() {
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r0.f20440k.C();
            r12.f20445d.c();
            r10 = java.lang.Math.min(r12.f20445d.f20431b, r12.f20442a.size());
            r0 = r12.f20445d;
            r0.f20431b -= r10;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(boolean r13) {
            /*
                r12 = this;
                a4.i r1 = a4.i.this
                monitor-enter(r1)
                a4.i r0 = a4.i.this     // Catch:{ all -> 0x007b }
                a4.i$c r0 = r0.f20440k     // Catch:{ all -> 0x007b }
                r0.v()     // Catch:{ all -> 0x007b }
            L_0x000a:
                a4.i r0 = a4.i.this     // Catch:{ all -> 0x0024 }
                long r2 = r0.f20431b     // Catch:{ all -> 0x0024 }
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 > 0) goto L_0x0027
                boolean r2 = r12.f20444c     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0027
                boolean r2 = r12.f20443b     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0027
                a4.b r2 = r0.f20441l     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0027
                r0.r()     // Catch:{ all -> 0x0024 }
                goto L_0x000a
            L_0x0024:
                r0 = move-exception
                r13 = r0
                goto L_0x007e
            L_0x0027:
                a4.i$c r0 = r0.f20440k     // Catch:{ all -> 0x007b }
                r0.C()     // Catch:{ all -> 0x007b }
                a4.i r0 = a4.i.this     // Catch:{ all -> 0x007b }
                r0.c()     // Catch:{ all -> 0x007b }
                a4.i r0 = a4.i.this     // Catch:{ all -> 0x007b }
                long r2 = r0.f20431b     // Catch:{ all -> 0x007b }
                e4.e r0 = r12.f20442a     // Catch:{ all -> 0x007b }
                long r4 = r0.size()     // Catch:{ all -> 0x007b }
                long r10 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x007b }
                a4.i r0 = a4.i.this     // Catch:{ all -> 0x007b }
                long r2 = r0.f20431b     // Catch:{ all -> 0x007b }
                long r2 = r2 - r10
                r0.f20431b = r2     // Catch:{ all -> 0x007b }
                monitor-exit(r1)     // Catch:{ all -> 0x007b }
                a4.i$c r0 = r0.f20440k
                r0.v()
                a4.i r0 = a4.i.this     // Catch:{ all -> 0x0061 }
                a4.g r6 = r0.f20433d     // Catch:{ all -> 0x0061 }
                int r7 = r0.f20432c     // Catch:{ all -> 0x0061 }
                if (r13 == 0) goto L_0x0064
                e4.e r13 = r12.f20442a     // Catch:{ all -> 0x0061 }
                long r0 = r13.size()     // Catch:{ all -> 0x0061 }
                int r13 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r13 != 0) goto L_0x0064
                r13 = 1
            L_0x005f:
                r8 = r13
                goto L_0x0066
            L_0x0061:
                r0 = move-exception
                r13 = r0
                goto L_0x0073
            L_0x0064:
                r13 = 0
                goto L_0x005f
            L_0x0066:
                e4.e r9 = r12.f20442a     // Catch:{ all -> 0x0061 }
                r6.I(r7, r8, r9, r10)     // Catch:{ all -> 0x0061 }
                a4.i r13 = a4.i.this
                a4.i$c r13 = r13.f20440k
                r13.C()
                return
            L_0x0073:
                a4.i r0 = a4.i.this
                a4.i$c r0 = r0.f20440k
                r0.C()
                throw r13
            L_0x007b:
                r0 = move-exception
                r13 = r0
                goto L_0x0086
            L_0x007e:
                a4.i r0 = a4.i.this     // Catch:{ all -> 0x007b }
                a4.i$c r0 = r0.f20440k     // Catch:{ all -> 0x007b }
                r0.C()     // Catch:{ all -> 0x007b }
                throw r13     // Catch:{ all -> 0x007b }
            L_0x0086:
                monitor-exit(r1)     // Catch:{ all -> 0x007b }
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: a4.i.a.a(boolean):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            if (r8.f20445d.f20438i.f20444c != false) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
            if (r8.f20442a.size() <= 0) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            if (r8.f20442a.size() <= 0) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
            r0 = r8.f20445d;
            r0.f20433d.I(r0.f20432c, true, (e4.C2356e) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
            r2 = r8.f20445d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r8.f20443b = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
            r8.f20445d.f20433d.flush();
            r8.f20445d.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r8 = this;
                a4.i r1 = a4.i.this
                monitor-enter(r1)
                boolean r0 = r8.f20443b     // Catch:{ all -> 0x0009 }
                if (r0 == 0) goto L_0x000b
                monitor-exit(r1)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r0 = move-exception
                goto L_0x0052
            L_0x000b:
                monitor-exit(r1)     // Catch:{ all -> 0x0009 }
                a4.i r0 = a4.i.this
                a4.i$a r0 = r0.f20438i
                boolean r0 = r0.f20444c
                r1 = 1
                if (r0 != 0) goto L_0x003c
                e4.e r0 = r8.f20442a
                long r2 = r0.size()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x002f
            L_0x0021:
                e4.e r0 = r8.f20442a
                long r2 = r0.size()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003c
                r8.a(r1)
                goto L_0x0021
            L_0x002f:
                a4.i r0 = a4.i.this
                a4.g r2 = r0.f20433d
                int r3 = r0.f20432c
                r5 = 0
                r6 = 0
                r4 = 1
                r2.I(r3, r4, r5, r6)
            L_0x003c:
                a4.i r2 = a4.i.this
                monitor-enter(r2)
                r8.f20443b = r1     // Catch:{ all -> 0x004f }
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                a4.i r0 = a4.i.this
                a4.g r0 = r0.f20433d
                r0.flush()
                a4.i r0 = a4.i.this
                r0.b()
                return
            L_0x004f:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                throw r0
            L_0x0052:
                monitor-exit(r1)     // Catch:{ all -> 0x0009 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: a4.i.a.close():void");
        }

        public void f(C2356e eVar, long j5) {
            this.f20442a.f(eVar, j5);
            while (this.f20442a.size() >= 16384) {
                a(false);
            }
        }

        public void flush() {
            synchronized (i.this) {
                i.this.c();
            }
            while (this.f20442a.size() > 0) {
                a(false);
                i.this.f20433d.flush();
            }
        }

        public a0 timeout() {
            return i.this.f20440k;
        }
    }

    private final class b implements Z {

        /* renamed from: a  reason: collision with root package name */
        private final C2356e f20446a = new C2356e();

        /* renamed from: b  reason: collision with root package name */
        private final C2356e f20447b = new C2356e();

        /* renamed from: c  reason: collision with root package name */
        private final long f20448c;

        /* renamed from: d  reason: collision with root package name */
        boolean f20449d;

        /* renamed from: e  reason: collision with root package name */
        boolean f20450e;

        b(long j5) {
            this.f20448c = j5;
        }

        private void a() {
            if (this.f20449d) {
                throw new IOException("stream closed");
            } else if (i.this.f20441l != null) {
                throw new n(i.this.f20441l);
            }
        }

        private void l() {
            i.this.f20439j.v();
            while (this.f20447b.size() == 0 && !this.f20450e && !this.f20449d) {
                try {
                    i iVar = i.this;
                    if (iVar.f20441l != null) {
                        break;
                    }
                    iVar.r();
                } finally {
                    i.this.f20439j.C();
                }
            }
        }

        public void close() {
            synchronized (i.this) {
                this.f20449d = true;
                this.f20447b.a();
                i.this.notifyAll();
            }
            i.this.b();
        }

        /* access modifiers changed from: package-private */
        public void d(C2358g gVar, long j5) {
            boolean z4;
            boolean z5;
            boolean z6;
            while (j5 > 0) {
                synchronized (i.this) {
                    z4 = this.f20450e;
                    z5 = false;
                    if (this.f20447b.size() + j5 > this.f20448c) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                }
                if (z6) {
                    gVar.skip(j5);
                    i.this.f(b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z4) {
                    gVar.skip(j5);
                    return;
                } else {
                    long e5 = gVar.e(this.f20446a, j5);
                    if (e5 != -1) {
                        j5 -= e5;
                        synchronized (i.this) {
                            try {
                                if (this.f20447b.size() == 0) {
                                    z5 = true;
                                }
                                this.f20447b.I(this.f20446a);
                                if (z5) {
                                    i.this.notifyAll();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
            r10 = r7.f20451f.f20433d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r2 = r7.f20451f.f20433d;
            r3 = r2.f20369l + r8;
            r2.f20369l = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
            if (r3 < ((long) (r2.f20371n.d() / 2))) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
            r2 = r7.f20451f.f20433d;
            r2.M(0, r2.f20369l);
            r7.f20451f.f20433d.f20369l = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0082, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
            throw r8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long e(e4.C2356e r8, long r9) {
            /*
                r7 = this;
                r0 = 0
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 < 0) goto L_0x0087
                a4.i r2 = a4.i.this
                monitor-enter(r2)
                r7.l()     // Catch:{ all -> 0x001d }
                r7.a()     // Catch:{ all -> 0x001d }
                e4.e r3 = r7.f20447b     // Catch:{ all -> 0x001d }
                long r3 = r3.size()     // Catch:{ all -> 0x001d }
                int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r3 != 0) goto L_0x001f
                r8 = -1
                monitor-exit(r2)     // Catch:{ all -> 0x001d }
                return r8
            L_0x001d:
                r8 = move-exception
                goto L_0x0085
            L_0x001f:
                e4.e r3 = r7.f20447b     // Catch:{ all -> 0x001d }
                long r4 = r3.size()     // Catch:{ all -> 0x001d }
                long r9 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x001d }
                long r8 = r3.e(r8, r9)     // Catch:{ all -> 0x001d }
                a4.i r10 = a4.i.this     // Catch:{ all -> 0x001d }
                long r3 = r10.f20430a     // Catch:{ all -> 0x001d }
                long r3 = r3 + r8
                r10.f20430a = r3     // Catch:{ all -> 0x001d }
                a4.g r10 = r10.f20433d     // Catch:{ all -> 0x001d }
                a4.m r10 = r10.f20371n     // Catch:{ all -> 0x001d }
                int r10 = r10.d()     // Catch:{ all -> 0x001d }
                int r10 = r10 / 2
                long r5 = (long) r10     // Catch:{ all -> 0x001d }
                int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r10 < 0) goto L_0x0052
                a4.i r10 = a4.i.this     // Catch:{ all -> 0x001d }
                a4.g r3 = r10.f20433d     // Catch:{ all -> 0x001d }
                int r4 = r10.f20432c     // Catch:{ all -> 0x001d }
                long r5 = r10.f20430a     // Catch:{ all -> 0x001d }
                r3.M(r4, r5)     // Catch:{ all -> 0x001d }
                a4.i r10 = a4.i.this     // Catch:{ all -> 0x001d }
                r10.f20430a = r0     // Catch:{ all -> 0x001d }
            L_0x0052:
                monitor-exit(r2)     // Catch:{ all -> 0x001d }
                a4.i r10 = a4.i.this
                a4.g r10 = r10.f20433d
                monitor-enter(r10)
                a4.i r2 = a4.i.this     // Catch:{ all -> 0x007f }
                a4.g r2 = r2.f20433d     // Catch:{ all -> 0x007f }
                long r3 = r2.f20369l     // Catch:{ all -> 0x007f }
                long r3 = r3 + r8
                r2.f20369l = r3     // Catch:{ all -> 0x007f }
                a4.m r2 = r2.f20371n     // Catch:{ all -> 0x007f }
                int r2 = r2.d()     // Catch:{ all -> 0x007f }
                int r2 = r2 / 2
                long r5 = (long) r2     // Catch:{ all -> 0x007f }
                int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r2 < 0) goto L_0x0081
                a4.i r2 = a4.i.this     // Catch:{ all -> 0x007f }
                a4.g r2 = r2.f20433d     // Catch:{ all -> 0x007f }
                long r3 = r2.f20369l     // Catch:{ all -> 0x007f }
                r5 = 0
                r2.M(r5, r3)     // Catch:{ all -> 0x007f }
                a4.i r2 = a4.i.this     // Catch:{ all -> 0x007f }
                a4.g r2 = r2.f20433d     // Catch:{ all -> 0x007f }
                r2.f20369l = r0     // Catch:{ all -> 0x007f }
                goto L_0x0081
            L_0x007f:
                r8 = move-exception
                goto L_0x0083
            L_0x0081:
                monitor-exit(r10)     // Catch:{ all -> 0x007f }
                return r8
            L_0x0083:
                monitor-exit(r10)     // Catch:{ all -> 0x007f }
                throw r8
            L_0x0085:
                monitor-exit(r2)     // Catch:{ all -> 0x001d }
                throw r8
            L_0x0087:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r9)
                java.lang.String r9 = r0.toString()
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: a4.i.b.e(e4.e, long):long");
        }

        public a0 timeout() {
            return i.this.f20439j;
        }
    }

    class c extends C2354c {
        c() {
        }

        /* access modifiers changed from: protected */
        public void B() {
            i.this.f(b.CANCEL);
        }

        public void C() {
            if (w()) {
                throw x((IOException) null);
            }
        }

        /* access modifiers changed from: protected */
        public IOException x(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    i(int i5, g gVar, boolean z4, boolean z5, List list) {
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.f20432c = i5;
            this.f20433d = gVar;
            this.f20431b = (long) gVar.f20372o.d();
            b bVar = new b((long) gVar.f20371n.d());
            this.f20437h = bVar;
            a aVar = new a();
            this.f20438i = aVar;
            bVar.f20450e = z5;
            aVar.f20444c = z4;
            this.f20434e = list;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    private boolean e(b bVar) {
        synchronized (this) {
            try {
                if (this.f20441l != null) {
                    return false;
                }
                if (this.f20437h.f20450e && this.f20438i.f20444c) {
                    return false;
                }
                this.f20441l = bVar;
                notifyAll();
                this.f20433d.C(this.f20432c);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j5) {
        this.f20431b += j5;
        if (j5 > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        boolean z4;
        boolean k5;
        synchronized (this) {
            try {
                b bVar = this.f20437h;
                if (!bVar.f20450e && bVar.f20449d) {
                    a aVar = this.f20438i;
                    if (!aVar.f20444c) {
                        if (aVar.f20443b) {
                        }
                    }
                    z4 = true;
                    k5 = k();
                }
                z4 = false;
                k5 = k();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (z4) {
            d(b.CANCEL);
        } else if (!k5) {
            this.f20433d.C(this.f20432c);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        a aVar = this.f20438i;
        if (aVar.f20443b) {
            throw new IOException("stream closed");
        } else if (aVar.f20444c) {
            throw new IOException("stream finished");
        } else if (this.f20441l != null) {
            throw new n(this.f20441l);
        }
    }

    public void d(b bVar) {
        if (e(bVar)) {
            this.f20433d.K(this.f20432c, bVar);
        }
    }

    public void f(b bVar) {
        if (e(bVar)) {
            this.f20433d.L(this.f20432c, bVar);
        }
    }

    public int g() {
        return this.f20432c;
    }

    public X h() {
        synchronized (this) {
            try {
                if (!this.f20436g) {
                    if (!j()) {
                        throw new IllegalStateException("reply before requesting the sink");
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return this.f20438i;
    }

    public Z i() {
        return this.f20437h;
    }

    public boolean j() {
        boolean z4;
        if ((this.f20432c & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f20433d.f20358a == z4) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean k() {
        /*
            r3 = this;
            monitor-enter(r3)
            a4.b r0 = r3.f20441l     // Catch:{ all -> 0x0013 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            a4.i$b r0 = r3.f20437h     // Catch:{ all -> 0x0013 }
            boolean r2 = r0.f20450e     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x0015
            boolean r0 = r0.f20449d     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
            goto L_0x0015
        L_0x0013:
            r0 = move-exception
            goto L_0x0028
        L_0x0015:
            a4.i$a r0 = r3.f20438i     // Catch:{ all -> 0x0013 }
            boolean r2 = r0.f20444c     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x001f
            boolean r0 = r0.f20443b     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
        L_0x001f:
            boolean r0 = r3.f20436g     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
            monitor-exit(r3)
            return r1
        L_0x0025:
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0028:
            monitor-exit(r3)     // Catch:{ all -> 0x0013 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.i.k():boolean");
    }

    public a0 l() {
        return this.f20439j;
    }

    /* access modifiers changed from: package-private */
    public void m(C2358g gVar, int i5) {
        this.f20437h.d(gVar, (long) i5);
    }

    /* access modifiers changed from: package-private */
    public void n() {
        boolean k5;
        synchronized (this) {
            this.f20437h.f20450e = true;
            k5 = k();
            notifyAll();
        }
        if (!k5) {
            this.f20433d.C(this.f20432c);
        }
    }

    /* access modifiers changed from: package-private */
    public void o(List list) {
        boolean z4;
        synchronized (this) {
            z4 = true;
            try {
                this.f20436g = true;
                if (this.f20435f == null) {
                    this.f20435f = list;
                    z4 = k();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f20435f);
                    arrayList.add((Object) null);
                    arrayList.addAll(list);
                    this.f20435f = arrayList;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (!z4) {
            this.f20433d.C(this.f20432c);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void p(b bVar) {
        if (this.f20441l == null) {
            this.f20441l = bVar;
            notifyAll();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized List q() {
        List list;
        if (j()) {
            this.f20439j.v();
            while (this.f20435f == null && this.f20441l == null) {
                try {
                    r();
                } catch (Throwable th) {
                    this.f20439j.C();
                    throw th;
                }
            }
            this.f20439j.C();
            list = this.f20435f;
            if (list != null) {
                this.f20435f = null;
            } else {
                throw new n(this.f20441l);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public a0 s() {
        return this.f20440k;
    }
}
