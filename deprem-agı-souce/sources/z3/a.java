package Z3;

import U3.A;
import U3.q;
import U3.r;
import U3.u;
import U3.x;
import U3.z;
import Y3.h;
import Y3.i;
import Y3.k;
import e4.C2356e;
import e4.C2357f;
import e4.C2358g;
import e4.C2365n;
import e4.L;
import e4.X;
import e4.Z;
import e4.a0;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

public final class a implements Y3.c {

    /* renamed from: a  reason: collision with root package name */
    final u f20268a;

    /* renamed from: b  reason: collision with root package name */
    final X3.g f20269b;

    /* renamed from: c  reason: collision with root package name */
    final C2358g f20270c;

    /* renamed from: d  reason: collision with root package name */
    final C2357f f20271d;

    /* renamed from: e  reason: collision with root package name */
    int f20272e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f20273f = 262144;

    private abstract class b implements Z {

        /* renamed from: a  reason: collision with root package name */
        protected final C2365n f20274a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f20275b;

        /* renamed from: c  reason: collision with root package name */
        protected long f20276c;

        private b() {
            this.f20274a = new C2365n(a.this.f20270c.timeout());
            this.f20276c = 0;
        }

        /* access modifiers changed from: protected */
        public final void a(boolean z4, IOException iOException) {
            a aVar = a.this;
            int i5 = aVar.f20272e;
            if (i5 != 6) {
                if (i5 == 5) {
                    aVar.d(this.f20274a);
                    a aVar2 = a.this;
                    aVar2.f20272e = 6;
                    X3.g gVar = aVar2.f20269b;
                    if (gVar != null) {
                        gVar.q(!z4, aVar2, this.f20276c, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + a.this.f20272e);
            }
        }

        public long e(C2356e eVar, long j5) {
            try {
                long e5 = a.this.f20270c.e(eVar, j5);
                if (e5 <= 0) {
                    return e5;
                }
                this.f20276c += e5;
                return e5;
            } catch (IOException e6) {
                a(false, e6);
                throw e6;
            }
        }

        public a0 timeout() {
            return this.f20274a;
        }
    }

    private final class c implements X {

        /* renamed from: a  reason: collision with root package name */
        private final C2365n f20278a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f20279b;

        c() {
            this.f20278a = new C2365n(a.this.f20271d.timeout());
        }

        public synchronized void close() {
            if (!this.f20279b) {
                this.f20279b = true;
                a.this.f20271d.writeUtf8("0\r\n\r\n");
                a.this.d(this.f20278a);
                a.this.f20272e = 3;
            }
        }

        public void f(C2356e eVar, long j5) {
            if (this.f20279b) {
                throw new IllegalStateException("closed");
            } else if (j5 != 0) {
                a.this.f20271d.writeHexadecimalUnsignedLong(j5);
                a.this.f20271d.writeUtf8("\r\n");
                a.this.f20271d.f(eVar, j5);
                a.this.f20271d.writeUtf8("\r\n");
            }
        }

        public synchronized void flush() {
            if (!this.f20279b) {
                a.this.f20271d.flush();
            }
        }

        public a0 timeout() {
            return this.f20278a;
        }
    }

    private class d extends b {

        /* renamed from: e  reason: collision with root package name */
        private final r f20281e;

        /* renamed from: f  reason: collision with root package name */
        private long f20282f = -1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f20283g = true;

        d(r rVar) {
            super();
            this.f20281e = rVar;
        }

        private void d() {
            if (this.f20282f != -1) {
                a.this.f20270c.readUtf8LineStrict();
            }
            try {
                this.f20282f = a.this.f20270c.readHexadecimalUnsignedLong();
                String trim = a.this.f20270c.readUtf8LineStrict().trim();
                if (this.f20282f < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f20282f + trim + "\"");
                } else if (this.f20282f == 0) {
                    this.f20283g = false;
                    Y3.e.g(a.this.f20268a.h(), this.f20281e, a.this.k());
                    a(true, (IOException) null);
                }
            } catch (NumberFormatException e5) {
                throw new ProtocolException(e5.getMessage());
            }
        }

        public void close() {
            if (!this.f20275b) {
                if (this.f20283g && !V3.c.m(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, (IOException) null);
                }
                this.f20275b = true;
            }
        }

        public long e(C2356e eVar, long j5) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (this.f20275b) {
                throw new IllegalStateException("closed");
            } else if (!this.f20283g) {
                return -1;
            } else {
                long j6 = this.f20282f;
                if (j6 == 0 || j6 == -1) {
                    d();
                    if (!this.f20283g) {
                        return -1;
                    }
                }
                long e5 = super.e(eVar, Math.min(j5, this.f20282f));
                if (e5 != -1) {
                    this.f20282f -= e5;
                    return e5;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
        }
    }

    private final class e implements X {

        /* renamed from: a  reason: collision with root package name */
        private final C2365n f20285a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f20286b;

        /* renamed from: c  reason: collision with root package name */
        private long f20287c;

        e(long j5) {
            this.f20285a = new C2365n(a.this.f20271d.timeout());
            this.f20287c = j5;
        }

        public void close() {
            if (!this.f20286b) {
                this.f20286b = true;
                if (this.f20287c <= 0) {
                    a.this.d(this.f20285a);
                    a.this.f20272e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void f(C2356e eVar, long j5) {
            if (!this.f20286b) {
                long j6 = j5;
                V3.c.c(eVar.size(), 0, j6);
                if (j6 <= this.f20287c) {
                    a.this.f20271d.f(eVar, j6);
                    this.f20287c -= j6;
                    return;
                }
                throw new ProtocolException("expected " + this.f20287c + " bytes but received " + j6);
            }
            throw new IllegalStateException("closed");
        }

        public void flush() {
            if (!this.f20286b) {
                a.this.f20271d.flush();
            }
        }

        public a0 timeout() {
            return this.f20285a;
        }
    }

    private class f extends b {

        /* renamed from: e  reason: collision with root package name */
        private long f20289e;

        f(long j5) {
            super();
            this.f20289e = j5;
            if (j5 == 0) {
                a(true, (IOException) null);
            }
        }

        public void close() {
            if (!this.f20275b) {
                if (this.f20289e != 0 && !V3.c.m(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, (IOException) null);
                }
                this.f20275b = true;
            }
        }

        public long e(C2356e eVar, long j5) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (!this.f20275b) {
                long j6 = this.f20289e;
                if (j6 == 0) {
                    return -1;
                }
                long e5 = super.e(eVar, Math.min(j6, j5));
                if (e5 != -1) {
                    long j7 = this.f20289e - e5;
                    this.f20289e = j7;
                    if (j7 == 0) {
                        a(true, (IOException) null);
                    }
                    return e5;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    private class g extends b {

        /* renamed from: e  reason: collision with root package name */
        private boolean f20291e;

        g() {
            super();
        }

        public void close() {
            if (!this.f20275b) {
                if (!this.f20291e) {
                    a(false, (IOException) null);
                }
                this.f20275b = true;
            }
        }

        public long e(C2356e eVar, long j5) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (this.f20275b) {
                throw new IllegalStateException("closed");
            } else if (this.f20291e) {
                return -1;
            } else {
                long e5 = super.e(eVar, j5);
                if (e5 != -1) {
                    return e5;
                }
                this.f20291e = true;
                a(true, (IOException) null);
                return -1;
            }
        }
    }

    public a(u uVar, X3.g gVar, C2358g gVar2, C2357f fVar) {
        this.f20268a = uVar;
        this.f20269b = gVar;
        this.f20270c = gVar2;
        this.f20271d = fVar;
    }

    private String j() {
        String readUtf8LineStrict = this.f20270c.readUtf8LineStrict(this.f20273f);
        this.f20273f -= (long) readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    public A a(z zVar) {
        X3.g gVar = this.f20269b;
        gVar.f20108f.q(gVar.f20107e);
        String o5 = zVar.o("Content-Type");
        if (!Y3.e.c(zVar)) {
            return new h(o5, 0, L.d(h(0)));
        }
        if ("chunked".equalsIgnoreCase(zVar.o("Transfer-Encoding"))) {
            return new h(o5, -1, L.d(f(zVar.A().i())));
        }
        long b5 = Y3.e.b(zVar);
        if (b5 != -1) {
            return new h(o5, b5, L.d(h(b5)));
        }
        return new h(o5, -1, L.d(i()));
    }

    public void b(x xVar) {
        l(xVar.d(), i.a(xVar, this.f20269b.c().p().b().type()));
    }

    public X c(x xVar, long j5) {
        if ("chunked".equalsIgnoreCase(xVar.c("Transfer-Encoding"))) {
            return e();
        }
        if (j5 != -1) {
            return g(j5);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* access modifiers changed from: package-private */
    public void d(C2365n nVar) {
        a0 i5 = nVar.i();
        nVar.j(a0.f21531e);
        i5.a();
        i5.b();
    }

    public X e() {
        if (this.f20272e == 1) {
            this.f20272e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f20272e);
    }

    public Z f(r rVar) {
        if (this.f20272e == 4) {
            this.f20272e = 5;
            return new d(rVar);
        }
        throw new IllegalStateException("state: " + this.f20272e);
    }

    public void finishRequest() {
        this.f20271d.flush();
    }

    public void flushRequest() {
        this.f20271d.flush();
    }

    public X g(long j5) {
        if (this.f20272e == 1) {
            this.f20272e = 2;
            return new e(j5);
        }
        throw new IllegalStateException("state: " + this.f20272e);
    }

    public Z h(long j5) {
        if (this.f20272e == 4) {
            this.f20272e = 5;
            return new f(j5);
        }
        throw new IllegalStateException("state: " + this.f20272e);
    }

    public Z i() {
        if (this.f20272e == 4) {
            X3.g gVar = this.f20269b;
            if (gVar != null) {
                this.f20272e = 5;
                gVar.i();
                return new g();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f20272e);
    }

    public q k() {
        q.a aVar = new q.a();
        while (true) {
            String j5 = j();
            if (j5.length() == 0) {
                return aVar.d();
            }
            V3.a.f19697a.a(aVar, j5);
        }
    }

    public void l(q qVar, String str) {
        if (this.f20272e == 0) {
            this.f20271d.writeUtf8(str).writeUtf8("\r\n");
            int e5 = qVar.e();
            for (int i5 = 0; i5 < e5; i5++) {
                this.f20271d.writeUtf8(qVar.c(i5)).writeUtf8(": ").writeUtf8(qVar.f(i5)).writeUtf8("\r\n");
            }
            this.f20271d.writeUtf8("\r\n");
            this.f20272e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f20272e);
    }

    public z.a readResponseHeaders(boolean z4) {
        int i5 = this.f20272e;
        if (i5 == 1 || i5 == 3) {
            try {
                k a5 = k.a(j());
                z.a i6 = new z.a().m(a5.f20224a).g(a5.f20225b).j(a5.f20226c).i(k());
                if (z4 && a5.f20225b == 100) {
                    return null;
                }
                if (a5.f20225b == 100) {
                    this.f20272e = 3;
                    return i6;
                }
                this.f20272e = 4;
                return i6;
            } catch (EOFException e5) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f20269b);
                iOException.initCause(e5);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.f20272e);
        }
    }
}
