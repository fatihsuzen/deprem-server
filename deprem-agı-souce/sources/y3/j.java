package Y3;

import U3.A;
import U3.B;
import U3.C2202a;
import U3.e;
import U3.f;
import U3.o;
import U3.r;
import U3.s;
import U3.u;
import U3.x;
import U3.y;
import U3.z;
import X3.c;
import X3.g;
import a4.a;
import androidx.browser.trusted.sharing.ShareTarget;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class j implements s {

    /* renamed from: a  reason: collision with root package name */
    private final u f20219a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20220b;

    /* renamed from: c  reason: collision with root package name */
    private volatile g f20221c;

    /* renamed from: d  reason: collision with root package name */
    private Object f20222d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f20223e;

    public j(u uVar, boolean z4) {
        this.f20219a = uVar;
        this.f20220b = z4;
    }

    private C2202a b(r rVar) {
        f fVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (rVar.l()) {
            sSLSocketFactory = this.f20219a.C();
            hostnameVerifier = this.f20219a.o();
            fVar = this.f20219a.d();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            fVar = null;
        }
        return new C2202a(rVar.k(), rVar.w(), this.f20219a.j(), this.f20219a.B(), sSLSocketFactory, hostnameVerifier, fVar, this.f20219a.x(), this.f20219a.w(), this.f20219a.t(), this.f20219a.g(), this.f20219a.y());
    }

    private x c(z zVar, B b5) {
        String o5;
        r z4;
        Proxy proxy;
        if (zVar != null) {
            int m5 = zVar.m();
            String g5 = zVar.A().g();
            y yVar = null;
            if (m5 == 307 || m5 == 308) {
                if (!g5.equals(ShareTarget.METHOD_GET) && !g5.equals("HEAD")) {
                    return null;
                }
            } else if (m5 == 401) {
                return this.f20219a.b().a(b5, zVar);
            } else {
                if (m5 != 503) {
                    if (m5 == 407) {
                        if (b5 != null) {
                            proxy = b5.b();
                        } else {
                            proxy = this.f20219a.w();
                        }
                        if (proxy.type() == Proxy.Type.HTTP) {
                            return this.f20219a.x().a(b5, zVar);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (m5 != 408) {
                        switch (m5) {
                            case MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.f20219a.A()) {
                        return null;
                    } else {
                        zVar.A().a();
                        if ((zVar.x() == null || zVar.x().m() != 408) && f(zVar, 0) <= 0) {
                            return zVar.A();
                        }
                        return null;
                    }
                } else if ((zVar.x() == null || zVar.x().m() != 503) && f(zVar, Integer.MAX_VALUE) == 0) {
                    return zVar.A();
                } else {
                    return null;
                }
            }
            if (!this.f20219a.m() || (o5 = zVar.o("Location")) == null || (z4 = zVar.A().i().z(o5)) == null) {
                return null;
            }
            if (!z4.A().equals(zVar.A().i().A()) && !this.f20219a.n()) {
                return null;
            }
            x.a h5 = zVar.A().h();
            if (f.b(g5)) {
                boolean d5 = f.d(g5);
                if (f.c(g5)) {
                    h5.e(ShareTarget.METHOD_GET, (y) null);
                } else {
                    if (d5) {
                        yVar = zVar.A().a();
                    }
                    h5.e(g5, yVar);
                }
                if (!d5) {
                    h5.f("Transfer-Encoding");
                    h5.f("Content-Length");
                    h5.f("Content-Type");
                }
            }
            if (!g(zVar, z4)) {
                h5.f("Authorization");
            }
            return h5.g(z4).a();
        }
        throw new IllegalStateException();
    }

    private boolean d(IOException iOException, boolean z4) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z4) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean e(IOException iOException, g gVar, boolean z4, x xVar) {
        gVar.p(iOException);
        if (!this.f20219a.A()) {
            return false;
        }
        if (z4) {
            xVar.a();
        }
        if (d(iOException, z4) && gVar.g()) {
            return true;
        }
        return false;
    }

    private int f(z zVar, int i5) {
        String o5 = zVar.o("Retry-After");
        if (o5 == null) {
            return i5;
        }
        if (o5.matches("\\d+")) {
            return Integer.valueOf(o5).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean g(z zVar, r rVar) {
        r i5 = zVar.A().i();
        if (!i5.k().equals(rVar.k()) || i5.w() != rVar.w() || !i5.A().equals(rVar.A())) {
            return false;
        }
        return true;
    }

    public z a(s.a aVar) {
        x request = aVar.request();
        g gVar = (g) aVar;
        e b5 = gVar.b();
        o d5 = gVar.d();
        g gVar2 = new g(this.f20219a.f(), b(request.i()), b5, d5, this.f20222d);
        this.f20221c = gVar2;
        g gVar3 = gVar2;
        int i5 = 0;
        z zVar = null;
        x xVar = request;
        while (!this.f20223e) {
            try {
                z f5 = gVar.f(xVar, gVar3, (c) null, (c) null);
                if (zVar != null) {
                    f5 = f5.v().l(zVar.v().b((A) null).c()).c();
                }
                x c5 = c(f5, gVar3.n());
                if (c5 == null) {
                    if (!this.f20220b) {
                        gVar3.j();
                    }
                    return f5;
                }
                V3.c.d(f5.a());
                int i6 = i5 + 1;
                if (i6 <= 20) {
                    c5.a();
                    if (!g(f5, c5.i())) {
                        gVar3.j();
                        g gVar4 = new g(this.f20219a.f(), b(c5.i()), b5, d5, this.f20222d);
                        this.f20221c = gVar4;
                        gVar3 = gVar4;
                    } else if (gVar3.b() != null) {
                        throw new IllegalStateException("Closing the body of " + f5 + " didn't close its backing stream. Bad interceptor?");
                    }
                    zVar = f5;
                    xVar = c5;
                    i5 = i6;
                } else {
                    gVar3.j();
                    throw new ProtocolException("Too many follow-up requests: " + i6);
                }
            } catch (X3.e e5) {
                if (!e(e5.c(), gVar3, false, xVar)) {
                    throw e5.c();
                }
            } catch (IOException e6) {
                if (!e(e6, gVar3, !(e6 instanceof a), xVar)) {
                    throw e6;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                gVar3.p((IOException) null);
                gVar3.j();
                throw th2;
            }
        }
        gVar3.j();
        throw new IOException("Canceled");
    }

    public void h(Object obj) {
        this.f20222d = obj;
    }
}
