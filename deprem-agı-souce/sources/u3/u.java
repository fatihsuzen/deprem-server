package U3;

import U3.e;
import U3.o;
import U3.q;
import U3.z;
import V3.c;
import W3.f;
import X3.d;
import X3.g;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class u implements Cloneable, e.a {

    /* renamed from: B  reason: collision with root package name */
    static final List f19580B = c.r(v.HTTP_2, v.HTTP_1_1);

    /* renamed from: C  reason: collision with root package name */
    static final List f19581C = c.r(j.f19515f, j.f19517h);

    /* renamed from: A  reason: collision with root package name */
    final int f19582A;

    /* renamed from: a  reason: collision with root package name */
    final m f19583a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f19584b;

    /* renamed from: c  reason: collision with root package name */
    final List f19585c;

    /* renamed from: d  reason: collision with root package name */
    final List f19586d;

    /* renamed from: e  reason: collision with root package name */
    final List f19587e;

    /* renamed from: f  reason: collision with root package name */
    final List f19588f;

    /* renamed from: g  reason: collision with root package name */
    final o.c f19589g;

    /* renamed from: h  reason: collision with root package name */
    final ProxySelector f19590h;

    /* renamed from: i  reason: collision with root package name */
    final l f19591i;

    /* renamed from: j  reason: collision with root package name */
    final C2204c f19592j;

    /* renamed from: k  reason: collision with root package name */
    final f f19593k;

    /* renamed from: l  reason: collision with root package name */
    final SocketFactory f19594l;

    /* renamed from: m  reason: collision with root package name */
    final SSLSocketFactory f19595m;

    /* renamed from: n  reason: collision with root package name */
    final d4.c f19596n;

    /* renamed from: o  reason: collision with root package name */
    final HostnameVerifier f19597o;

    /* renamed from: p  reason: collision with root package name */
    final f f19598p;

    /* renamed from: q  reason: collision with root package name */
    final C2203b f19599q;

    /* renamed from: r  reason: collision with root package name */
    final C2203b f19600r;

    /* renamed from: s  reason: collision with root package name */
    final i f19601s;

    /* renamed from: t  reason: collision with root package name */
    final n f19602t;

    /* renamed from: u  reason: collision with root package name */
    final boolean f19603u;

    /* renamed from: v  reason: collision with root package name */
    final boolean f19604v;

    /* renamed from: w  reason: collision with root package name */
    final boolean f19605w;

    /* renamed from: x  reason: collision with root package name */
    final int f19606x;

    /* renamed from: y  reason: collision with root package name */
    final int f19607y;

    /* renamed from: z  reason: collision with root package name */
    final int f19608z;

    class a extends V3.a {
        a() {
        }

        public void a(q.a aVar, String str) {
            aVar.b(str);
        }

        public void b(q.a aVar, String str, String str2) {
            aVar.c(str, str2);
        }

        public void c(j jVar, SSLSocket sSLSocket, boolean z4) {
            jVar.a(sSLSocket, z4);
        }

        public int d(z.a aVar) {
            return aVar.f19678c;
        }

        public boolean e(i iVar, X3.c cVar) {
            return iVar.b(cVar);
        }

        public Socket f(i iVar, C2202a aVar, g gVar) {
            return iVar.c(aVar, gVar);
        }

        public boolean g(C2202a aVar, C2202a aVar2) {
            return aVar.d(aVar2);
        }

        public X3.c h(i iVar, C2202a aVar, g gVar, B b5) {
            return iVar.d(aVar, gVar, b5);
        }

        public void i(i iVar, X3.c cVar) {
            iVar.f(cVar);
        }

        public d j(i iVar) {
            return iVar.f19511e;
        }
    }

    public static final class b {

        /* renamed from: A  reason: collision with root package name */
        int f19609A;

        /* renamed from: a  reason: collision with root package name */
        m f19610a = new m();

        /* renamed from: b  reason: collision with root package name */
        Proxy f19611b;

        /* renamed from: c  reason: collision with root package name */
        List f19612c = u.f19580B;

        /* renamed from: d  reason: collision with root package name */
        List f19613d = u.f19581C;

        /* renamed from: e  reason: collision with root package name */
        final List f19614e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        final List f19615f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        o.c f19616g = o.k(o.f19548a);

        /* renamed from: h  reason: collision with root package name */
        ProxySelector f19617h = ProxySelector.getDefault();

        /* renamed from: i  reason: collision with root package name */
        l f19618i = l.f19539a;

        /* renamed from: j  reason: collision with root package name */
        C2204c f19619j;

        /* renamed from: k  reason: collision with root package name */
        f f19620k;

        /* renamed from: l  reason: collision with root package name */
        SocketFactory f19621l = SocketFactory.getDefault();

        /* renamed from: m  reason: collision with root package name */
        SSLSocketFactory f19622m;

        /* renamed from: n  reason: collision with root package name */
        d4.c f19623n;

        /* renamed from: o  reason: collision with root package name */
        HostnameVerifier f19624o = d4.d.f21430a;

        /* renamed from: p  reason: collision with root package name */
        f f19625p = f.f19387c;

        /* renamed from: q  reason: collision with root package name */
        C2203b f19626q;

        /* renamed from: r  reason: collision with root package name */
        C2203b f19627r;

        /* renamed from: s  reason: collision with root package name */
        i f19628s;

        /* renamed from: t  reason: collision with root package name */
        n f19629t;

        /* renamed from: u  reason: collision with root package name */
        boolean f19630u;

        /* renamed from: v  reason: collision with root package name */
        boolean f19631v;

        /* renamed from: w  reason: collision with root package name */
        boolean f19632w;

        /* renamed from: x  reason: collision with root package name */
        int f19633x;

        /* renamed from: y  reason: collision with root package name */
        int f19634y;

        /* renamed from: z  reason: collision with root package name */
        int f19635z;

        public b() {
            C2203b bVar = C2203b.f19329a;
            this.f19626q = bVar;
            this.f19627r = bVar;
            this.f19628s = new i();
            this.f19629t = n.f19547a;
            this.f19630u = true;
            this.f19631v = true;
            this.f19632w = true;
            this.f19633x = 10000;
            this.f19634y = 10000;
            this.f19635z = 10000;
            this.f19609A = 0;
        }

        public u a() {
            return new u(this);
        }

        public b b(C2204c cVar) {
            this.f19619j = cVar;
            this.f19620k = null;
            return this;
        }
    }

    static {
        V3.a.f19697a = new a();
    }

    u(b bVar) {
        boolean z4;
        this.f19583a = bVar.f19610a;
        this.f19584b = bVar.f19611b;
        this.f19585c = bVar.f19612c;
        List list = bVar.f19613d;
        this.f19586d = list;
        this.f19587e = c.q(bVar.f19614e);
        this.f19588f = c.q(bVar.f19615f);
        this.f19589g = bVar.f19616g;
        this.f19590h = bVar.f19617h;
        this.f19591i = bVar.f19618i;
        this.f19592j = bVar.f19619j;
        this.f19593k = bVar.f19620k;
        this.f19594l = bVar.f19621l;
        Iterator it = list.iterator();
        loop0:
        while (true) {
            z4 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                j jVar = (j) it.next();
                if (z4 || jVar.d()) {
                    z4 = true;
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.f19622m;
        if (sSLSocketFactory != null || !z4) {
            this.f19595m = sSLSocketFactory;
            this.f19596n = bVar.f19623n;
        } else {
            X509TrustManager E4 = E();
            this.f19595m = D(E4);
            this.f19596n = d4.c.b(E4);
        }
        this.f19597o = bVar.f19624o;
        this.f19598p = bVar.f19625p.e(this.f19596n);
        this.f19599q = bVar.f19626q;
        this.f19600r = bVar.f19627r;
        this.f19601s = bVar.f19628s;
        this.f19602t = bVar.f19629t;
        this.f19603u = bVar.f19630u;
        this.f19604v = bVar.f19631v;
        this.f19605w = bVar.f19632w;
        this.f19606x = bVar.f19633x;
        this.f19607y = bVar.f19634y;
        this.f19608z = bVar.f19635z;
        this.f19582A = bVar.f19609A;
        if (this.f19587e.contains((Object) null)) {
            throw new IllegalStateException("Null interceptor: " + this.f19587e);
        } else if (this.f19588f.contains((Object) null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f19588f);
        }
    }

    private SSLSocketFactory D(X509TrustManager x509TrustManager) {
        try {
            SSLContext k5 = c4.f.i().k();
            k5.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return k5.getSocketFactory();
        } catch (GeneralSecurityException e5) {
            throw c.a("No System TLS", e5);
        }
    }

    private X509TrustManager E() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e5) {
            throw c.a("No System TLS", e5);
        }
    }

    public boolean A() {
        return this.f19605w;
    }

    public SocketFactory B() {
        return this.f19594l;
    }

    public SSLSocketFactory C() {
        return this.f19595m;
    }

    public int F() {
        return this.f19608z;
    }

    public e a(x xVar) {
        return w.d(this, xVar, false);
    }

    public C2203b b() {
        return this.f19600r;
    }

    public C2204c c() {
        return this.f19592j;
    }

    public f d() {
        return this.f19598p;
    }

    public int e() {
        return this.f19606x;
    }

    public i f() {
        return this.f19601s;
    }

    public List g() {
        return this.f19586d;
    }

    public l h() {
        return this.f19591i;
    }

    public m i() {
        return this.f19583a;
    }

    public n j() {
        return this.f19602t;
    }

    public o.c k() {
        return this.f19589g;
    }

    public boolean m() {
        return this.f19604v;
    }

    public boolean n() {
        return this.f19603u;
    }

    public HostnameVerifier o() {
        return this.f19597o;
    }

    public List p() {
        return this.f19587e;
    }

    /* access modifiers changed from: package-private */
    public f q() {
        C2204c cVar = this.f19592j;
        if (cVar != null) {
            return cVar.f19330a;
        }
        return this.f19593k;
    }

    public List r() {
        return this.f19588f;
    }

    public int s() {
        return this.f19582A;
    }

    public List t() {
        return this.f19585c;
    }

    public Proxy w() {
        return this.f19584b;
    }

    public C2203b x() {
        return this.f19599q;
    }

    public ProxySelector y() {
        return this.f19590h;
    }

    public int z() {
        return this.f19607y;
    }
}
