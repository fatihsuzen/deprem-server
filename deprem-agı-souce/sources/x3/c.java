package X3;

import U3.B;
import U3.C2202a;
import U3.e;
import U3.h;
import U3.i;
import U3.o;
import U3.p;
import U3.r;
import U3.s;
import U3.u;
import U3.v;
import U3.x;
import U3.z;
import V3.d;
import Z3.a;
import a4.b;
import a4.g;
import c4.f;
import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import e4.C2357f;
import e4.C2358g;
import e4.L;
import e4.Z;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class c extends g.h implements h {

    /* renamed from: b  reason: collision with root package name */
    private final i f20076b;

    /* renamed from: c  reason: collision with root package name */
    private final B f20077c;

    /* renamed from: d  reason: collision with root package name */
    private Socket f20078d;

    /* renamed from: e  reason: collision with root package name */
    private Socket f20079e;

    /* renamed from: f  reason: collision with root package name */
    private p f20080f;

    /* renamed from: g  reason: collision with root package name */
    private v f20081g;

    /* renamed from: h  reason: collision with root package name */
    private g f20082h;

    /* renamed from: i  reason: collision with root package name */
    private C2358g f20083i;

    /* renamed from: j  reason: collision with root package name */
    private C2357f f20084j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f20085k;

    /* renamed from: l  reason: collision with root package name */
    public int f20086l;

    /* renamed from: m  reason: collision with root package name */
    public int f20087m = 1;

    /* renamed from: n  reason: collision with root package name */
    public final List f20088n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public long f20089o = Long.MAX_VALUE;

    public c(i iVar, B b5) {
        this.f20076b = iVar;
        this.f20077c = b5;
    }

    private void d(int i5, int i6, e eVar, o oVar) {
        Socket socket;
        Proxy b5 = this.f20077c.b();
        C2202a a5 = this.f20077c.a();
        if (b5.type() == Proxy.Type.DIRECT || b5.type() == Proxy.Type.HTTP) {
            socket = a5.j().createSocket();
        } else {
            socket = new Socket(b5);
        }
        this.f20078d = socket;
        oVar.f(eVar, this.f20077c.d(), b5);
        this.f20078d.setSoTimeout(i6);
        try {
            f.i().g(this.f20078d, this.f20077c.d(), i5);
            try {
                this.f20083i = L.d(L.m(this.f20078d));
                this.f20084j = L.c(L.i(this.f20078d));
            } catch (NullPointerException e5) {
                if ("throw with null exception".equals(e5.getMessage())) {
                    throw new IOException(e5);
                }
            }
        } catch (ConnectException e6) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f20077c.d());
            connectException.initCause(e6);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011e A[Catch:{ all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0124 A[Catch:{ all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(X3.b r8) {
        /*
            r7 = this;
            U3.B r0 = r7.f20077c
            U3.a r0 = r0.a()
            javax.net.ssl.SSLSocketFactory r1 = r0.k()
            r2 = 0
            java.net.Socket r3 = r7.f20078d     // Catch:{ AssertionError -> 0x0117 }
            U3.r r4 = r0.l()     // Catch:{ AssertionError -> 0x0117 }
            java.lang.String r4 = r4.k()     // Catch:{ AssertionError -> 0x0117 }
            U3.r r5 = r0.l()     // Catch:{ AssertionError -> 0x0117 }
            int r5 = r5.w()     // Catch:{ AssertionError -> 0x0117 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x0117 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x0117 }
            U3.j r8 = r8.a(r1)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r3 = r8.f()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r3 == 0) goto L_0x004a
            c4.f r3 = c4.f.i()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            U3.r r4 = r0.l()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r4 = r4.k()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.util.List r5 = r0.f()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.f(r1, r4, r5)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            goto L_0x004a
        L_0x0042:
            r8 = move-exception
            r2 = r1
            goto L_0x0125
        L_0x0046:
            r8 = move-exception
            r2 = r1
            goto L_0x0118
        L_0x004a:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r4 = r7.n(r3)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r4 == 0) goto L_0x010d
            U3.p r4 = U3.p.c(r3)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            javax.net.ssl.HostnameVerifier r5 = r0.e()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            U3.r r6 = r0.l()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r6 = r6.k()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r3 == 0) goto L_0x00bb
            U3.f r3 = r0.a()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            U3.r r0 = r0.l()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.k()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.util.List r5 = r4.e()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.a(r0, r5)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r8 = r8.f()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r8 == 0) goto L_0x008e
            c4.f r8 = c4.f.i()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r2 = r8.l(r1)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x008e:
            r7.f20079e = r1     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            e4.Z r8 = e4.L.m(r1)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            e4.g r8 = e4.L.d(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r7.f20083i = r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.net.Socket r8 = r7.f20079e     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            e4.X r8 = e4.L.i(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            e4.f r8 = e4.L.c(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r7.f20084j = r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r7.f20080f = r4     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r2 == 0) goto L_0x00af
            U3.v r8 = U3.v.a(r2)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            goto L_0x00b1
        L_0x00af:
            U3.v r8 = U3.v.HTTP_1_1     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x00b1:
            r7.f20081g = r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            c4.f r8 = c4.f.i()
            r8.a(r1)
            return
        L_0x00bb:
            java.util.List r8 = r4.e()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.<init>()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r4 = "Hostname "
            r3.append(r4)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            U3.r r0 = r0.l()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.k()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = U3.f.c(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = "\n    DN: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.util.List r8 = d4.d.a(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.append(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r8 = r3.toString()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            throw r2     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x010d:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = "a valid ssl session was not established"
            r8.<init>(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            throw r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x0115:
            r8 = move-exception
            goto L_0x0125
        L_0x0117:
            r8 = move-exception
        L_0x0118:
            boolean r0 = V3.c.w(r8)     // Catch:{ all -> 0x0115 }
            if (r0 == 0) goto L_0x0124
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0115 }
            r0.<init>(r8)     // Catch:{ all -> 0x0115 }
            throw r0     // Catch:{ all -> 0x0115 }
        L_0x0124:
            throw r8     // Catch:{ all -> 0x0115 }
        L_0x0125:
            if (r2 == 0) goto L_0x012e
            c4.f r0 = c4.f.i()
            r0.a(r2)
        L_0x012e:
            V3.c.e(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.c.e(X3.b):void");
    }

    private void f(int i5, int i6, int i7, e eVar, o oVar) {
        x h5 = h();
        r i8 = h5.i();
        int i9 = 0;
        while (i9 < 21) {
            d(i5, i6, eVar, oVar);
            h5 = g(i6, i7, h5, i8);
            if (h5 != null) {
                V3.c.e(this.f20078d);
                this.f20078d = null;
                this.f20084j = null;
                this.f20083i = null;
                oVar.d(eVar, this.f20077c.d(), this.f20077c.b(), (v) null);
                i9++;
            } else {
                return;
            }
        }
    }

    private x g(int i5, int i6, x xVar, r rVar) {
        String str = "CONNECT " + V3.c.p(rVar, true) + " HTTP/1.1";
        while (true) {
            a aVar = new a((u) null, (g) null, this.f20083i, this.f20084j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f20083i.timeout().g((long) i5, timeUnit);
            this.f20084j.timeout().g((long) i6, timeUnit);
            aVar.l(xVar.d(), str);
            aVar.finishRequest();
            z c5 = aVar.readResponseHeaders(false).o(xVar).c();
            long b5 = Y3.e.b(c5);
            if (b5 == -1) {
                b5 = 0;
            }
            Z h5 = aVar.h(b5);
            V3.c.y(h5, Integer.MAX_VALUE, timeUnit);
            h5.close();
            int m5 = c5.m();
            if (m5 != 200) {
                if (m5 == 407) {
                    x a5 = this.f20077c.a().h().a(this.f20077c, c5);
                    if (a5 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if (CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equalsIgnoreCase(c5.o("Connection"))) {
                        return a5;
                    } else {
                        xVar = a5;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + c5.m());
                }
            } else if (this.f20083i.buffer().exhausted() && this.f20084j.buffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private x h() {
        return new x.a().g(this.f20077c.a().l()).c("Host", V3.c.p(this.f20077c.a().l(), true)).c("Proxy-Connection", "Keep-Alive").c(Command.HTTP_HEADER_USER_AGENT, d.a()).a();
    }

    private void i(b bVar, int i5, e eVar, o oVar) {
        if (this.f20077c.a().k() == null) {
            this.f20081g = v.HTTP_1_1;
            this.f20079e = this.f20078d;
            return;
        }
        oVar.u(eVar);
        e(bVar);
        oVar.t(eVar, this.f20080f);
        if (this.f20081g == v.HTTP_2) {
            this.f20079e.setSoTimeout(0);
            g a5 = new g.C0200g(true).d(this.f20079e, this.f20077c.a().l().k(), this.f20083i, this.f20084j).b(this).c(i5).a();
            this.f20082h = a5;
            a5.G();
        }
    }

    private boolean n(SSLSession sSLSession) {
        if ("NONE".equals(sSLSession.getProtocol()) || "SSL_NULL_WITH_NULL_NULL".equals(sSLSession.getCipherSuite())) {
            return false;
        }
        return true;
    }

    public void a(g gVar) {
        synchronized (this.f20076b) {
            this.f20087m = gVar.t();
        }
    }

    public void b(a4.i iVar) {
        iVar.d(b.REFUSED_STREAM);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: U3.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: U3.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: U3.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: U3.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: X3.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: U3.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: U3.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: X3.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: X3.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: U3.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: X3.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: U3.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: X3.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: U3.o} */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0099 A[Catch:{ IOException -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(int r13, int r14, int r15, int r16, boolean r17, U3.e r18, U3.o r19) {
        /*
            r12 = this;
            U3.v r0 = r12.f20081g
            if (r0 != 0) goto L_0x012f
            U3.B r0 = r12.f20077c
            U3.a r0 = r0.a()
            java.util.List r0 = r0.b()
            X3.b r7 = new X3.b
            r7.<init>(r0)
            U3.B r1 = r12.f20077c
            U3.a r1 = r1.a()
            javax.net.ssl.SSLSocketFactory r1 = r1.k()
            if (r1 != 0) goto L_0x006e
            U3.j r1 = U3.j.f19517h
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0061
            U3.B r0 = r12.f20077c
            U3.a r0 = r0.a()
            U3.r r0 = r0.l()
            java.lang.String r0 = r0.k()
            c4.f r1 = c4.f.i()
            boolean r1 = r1.n(r0)
            if (r1 == 0) goto L_0x0040
            goto L_0x006e
        L_0x0040:
            X3.e r13 = new X3.e
            java.net.UnknownServiceException r14 = new java.net.UnknownServiceException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r1 = "CLEARTEXT communication to "
            r15.append(r1)
            r15.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            r13.<init>(r14)
            throw r13
        L_0x0061:
            X3.e r13 = new X3.e
            java.net.UnknownServiceException r14 = new java.net.UnknownServiceException
            java.lang.String r15 = "CLEARTEXT communication not enabled for client"
            r14.<init>(r15)
            r13.<init>(r14)
            throw r13
        L_0x006e:
            r8 = 0
            r9 = r8
        L_0x0070:
            U3.B r0 = r12.f20077c     // Catch:{ IOException -> 0x00e8 }
            boolean r0 = r0.c()     // Catch:{ IOException -> 0x00e8 }
            if (r0 == 0) goto L_0x0099
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r18
            r6 = r19
            r1.f(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x0094 }
            r10 = r3
            r2 = r5
            r1 = r6
            java.net.Socket r0 = r12.f20078d     // Catch:{ IOException -> 0x008e }
            if (r0 != 0) goto L_0x008b
            goto L_0x00b6
        L_0x008b:
            r11 = r16
            goto L_0x00a2
        L_0x008e:
            r0 = move-exception
        L_0x008f:
            r11 = r16
        L_0x0091:
            r6 = r0
            goto L_0x00f1
        L_0x0094:
            r0 = move-exception
            r10 = r3
            r2 = r5
            r1 = r6
            goto L_0x008f
        L_0x0099:
            r10 = r14
            r2 = r18
            r1 = r19
            r12.d(r13, r14, r2, r1)     // Catch:{ IOException -> 0x008e }
            goto L_0x008b
        L_0x00a2:
            r12.i(r7, r11, r2, r1)     // Catch:{ IOException -> 0x00e6 }
            U3.B r0 = r12.f20077c     // Catch:{ IOException -> 0x00e6 }
            java.net.InetSocketAddress r0 = r0.d()     // Catch:{ IOException -> 0x00e6 }
            U3.B r3 = r12.f20077c     // Catch:{ IOException -> 0x00e6 }
            java.net.Proxy r3 = r3.b()     // Catch:{ IOException -> 0x00e6 }
            U3.v r4 = r12.f20081g     // Catch:{ IOException -> 0x00e6 }
            r1.d(r2, r0, r3, r4)     // Catch:{ IOException -> 0x00e6 }
        L_0x00b6:
            U3.B r13 = r12.f20077c
            boolean r13 = r13.c()
            if (r13 == 0) goto L_0x00d0
            java.net.Socket r13 = r12.f20078d
            if (r13 == 0) goto L_0x00c3
            goto L_0x00d0
        L_0x00c3:
            java.net.ProtocolException r13 = new java.net.ProtocolException
            java.lang.String r14 = "Too many tunnel connections attempted: 21"
            r13.<init>(r14)
            X3.e r14 = new X3.e
            r14.<init>(r13)
            throw r14
        L_0x00d0:
            a4.g r13 = r12.f20082h
            if (r13 == 0) goto L_0x00e5
            U3.i r13 = r12.f20076b
            monitor-enter(r13)
            a4.g r14 = r12.f20082h     // Catch:{ all -> 0x00e1 }
            int r14 = r14.t()     // Catch:{ all -> 0x00e1 }
            r12.f20087m = r14     // Catch:{ all -> 0x00e1 }
            monitor-exit(r13)     // Catch:{ all -> 0x00e1 }
            goto L_0x00e5
        L_0x00e1:
            r0 = move-exception
            r14 = r0
            monitor-exit(r13)     // Catch:{ all -> 0x00e1 }
            throw r14
        L_0x00e5:
            return
        L_0x00e6:
            r0 = move-exception
            goto L_0x0091
        L_0x00e8:
            r0 = move-exception
            r10 = r14
            r11 = r16
            r2 = r18
            r1 = r19
            goto L_0x0091
        L_0x00f1:
            java.net.Socket r0 = r12.f20079e
            V3.c.e(r0)
            java.net.Socket r0 = r12.f20078d
            V3.c.e(r0)
            r12.f20079e = r8
            r12.f20078d = r8
            r12.f20083i = r8
            r12.f20084j = r8
            r12.f20080f = r8
            r12.f20081g = r8
            r12.f20082h = r8
            U3.B r0 = r12.f20077c
            java.net.InetSocketAddress r3 = r0.d()
            U3.B r0 = r12.f20077c
            java.net.Proxy r4 = r0.b()
            r5 = 0
            r1.e(r2, r3, r4, r5, r6)
            if (r9 != 0) goto L_0x0121
            X3.e r9 = new X3.e
            r9.<init>(r6)
            goto L_0x0124
        L_0x0121:
            r9.a(r6)
        L_0x0124:
            if (r17 == 0) goto L_0x012e
            boolean r0 = r7.b(r6)
            if (r0 == 0) goto L_0x012e
            goto L_0x0070
        L_0x012e:
            throw r9
        L_0x012f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "already connected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.c.c(int, int, int, int, boolean, U3.e, U3.o):void");
    }

    public p j() {
        return this.f20080f;
    }

    public boolean k(C2202a aVar, B b5) {
        Proxy.Type type;
        if (this.f20088n.size() >= this.f20087m || this.f20085k || !V3.a.f19697a.g(this.f20077c.a(), aVar)) {
            return false;
        }
        if (aVar.l().k().equals(p().a().l().k())) {
            return true;
        }
        if (this.f20082h == null || b5 == null || b5.b().type() != (type = Proxy.Type.DIRECT) || this.f20077c.b().type() != type || !this.f20077c.d().equals(b5.d()) || b5.a().e() != d4.d.f21430a || !r(aVar.l())) {
            return false;
        }
        try {
            aVar.a().a(aVar.l().k(), j().e());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean l(boolean z4) {
        int soTimeout;
        if (this.f20079e.isClosed() || this.f20079e.isInputShutdown() || this.f20079e.isOutputShutdown()) {
            return false;
        }
        g gVar = this.f20082h;
        if (gVar != null) {
            return !gVar.s();
        }
        if (z4) {
            try {
                soTimeout = this.f20079e.getSoTimeout();
                this.f20079e.setSoTimeout(1);
                if (this.f20083i.exhausted()) {
                    this.f20079e.setSoTimeout(soTimeout);
                    return false;
                }
                this.f20079e.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f20079e.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public boolean m() {
        if (this.f20082h != null) {
            return true;
        }
        return false;
    }

    public Y3.c o(u uVar, s.a aVar, g gVar) {
        if (this.f20082h != null) {
            return new a4.f(uVar, aVar, gVar, this.f20082h);
        }
        this.f20079e.setSoTimeout(aVar.readTimeoutMillis());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f20083i.timeout().g((long) aVar.readTimeoutMillis(), timeUnit);
        this.f20084j.timeout().g((long) aVar.writeTimeoutMillis(), timeUnit);
        return new a(uVar, gVar, this.f20083i, this.f20084j);
    }

    public B p() {
        return this.f20077c;
    }

    public Socket q() {
        return this.f20079e;
    }

    public boolean r(r rVar) {
        if (rVar.w() != this.f20077c.a().l().w()) {
            return false;
        }
        if (rVar.k().equals(this.f20077c.a().l().k())) {
            return true;
        }
        if (this.f20080f == null || !d4.d.f21430a.c(rVar.k(), (X509Certificate) this.f20080f.e().get(0))) {
            return false;
        }
        return true;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f20077c.a().l().k());
        sb.append(":");
        sb.append(this.f20077c.a().l().w());
        sb.append(", proxy=");
        sb.append(this.f20077c.b());
        sb.append(" hostAddress=");
        sb.append(this.f20077c.d());
        sb.append(" cipherSuite=");
        p pVar = this.f20080f;
        if (pVar != null) {
            obj = pVar.a();
        } else {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f20081g);
        sb.append('}');
        return sb.toString();
    }
}
