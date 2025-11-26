package U3;

import U3.r;
import V3.c;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: U3.a  reason: case insensitive filesystem */
public final class C2202a {

    /* renamed from: a  reason: collision with root package name */
    final r f19318a;

    /* renamed from: b  reason: collision with root package name */
    final n f19319b;

    /* renamed from: c  reason: collision with root package name */
    final SocketFactory f19320c;

    /* renamed from: d  reason: collision with root package name */
    final C2203b f19321d;

    /* renamed from: e  reason: collision with root package name */
    final List f19322e;

    /* renamed from: f  reason: collision with root package name */
    final List f19323f;

    /* renamed from: g  reason: collision with root package name */
    final ProxySelector f19324g;

    /* renamed from: h  reason: collision with root package name */
    final Proxy f19325h;

    /* renamed from: i  reason: collision with root package name */
    final SSLSocketFactory f19326i;

    /* renamed from: j  reason: collision with root package name */
    final HostnameVerifier f19327j;

    /* renamed from: k  reason: collision with root package name */
    final f f19328k;

    public C2202a(String str, int i5, n nVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, f fVar, C2203b bVar, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        String str2;
        r.a aVar = new r.a();
        if (sSLSocketFactory != null) {
            str2 = "https";
        } else {
            str2 = "http";
        }
        this.f19318a = aVar.p(str2).e(str).k(i5).a();
        if (nVar != null) {
            this.f19319b = nVar;
            if (socketFactory != null) {
                this.f19320c = socketFactory;
                if (bVar != null) {
                    this.f19321d = bVar;
                    if (list != null) {
                        this.f19322e = c.q(list);
                        if (list2 != null) {
                            this.f19323f = c.q(list2);
                            if (proxySelector != null) {
                                this.f19324g = proxySelector;
                                this.f19325h = proxy;
                                this.f19326i = sSLSocketFactory;
                                this.f19327j = hostnameVerifier;
                                this.f19328k = fVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public f a() {
        return this.f19328k;
    }

    public List b() {
        return this.f19323f;
    }

    public n c() {
        return this.f19319b;
    }

    /* access modifiers changed from: package-private */
    public boolean d(C2202a aVar) {
        if (!this.f19319b.equals(aVar.f19319b) || !this.f19321d.equals(aVar.f19321d) || !this.f19322e.equals(aVar.f19322e) || !this.f19323f.equals(aVar.f19323f) || !this.f19324g.equals(aVar.f19324g) || !c.n(this.f19325h, aVar.f19325h) || !c.n(this.f19326i, aVar.f19326i) || !c.n(this.f19327j, aVar.f19327j) || !c.n(this.f19328k, aVar.f19328k) || l().w() != aVar.l().w()) {
            return false;
        }
        return true;
    }

    public HostnameVerifier e() {
        return this.f19327j;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2202a)) {
            return false;
        }
        C2202a aVar = (C2202a) obj;
        if (!this.f19318a.equals(aVar.f19318a) || !d(aVar)) {
            return false;
        }
        return true;
    }

    public List f() {
        return this.f19322e;
    }

    public Proxy g() {
        return this.f19325h;
    }

    public C2203b h() {
        return this.f19321d;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        int hashCode = (((((((((((527 + this.f19318a.hashCode()) * 31) + this.f19319b.hashCode()) * 31) + this.f19321d.hashCode()) * 31) + this.f19322e.hashCode()) * 31) + this.f19323f.hashCode()) * 31) + this.f19324g.hashCode()) * 31;
        Proxy proxy = this.f19325h;
        int i8 = 0;
        if (proxy != null) {
            i5 = proxy.hashCode();
        } else {
            i5 = 0;
        }
        int i9 = (hashCode + i5) * 31;
        SSLSocketFactory sSLSocketFactory = this.f19326i;
        if (sSLSocketFactory != null) {
            i6 = sSLSocketFactory.hashCode();
        } else {
            i6 = 0;
        }
        int i10 = (i9 + i6) * 31;
        HostnameVerifier hostnameVerifier = this.f19327j;
        if (hostnameVerifier != null) {
            i7 = hostnameVerifier.hashCode();
        } else {
            i7 = 0;
        }
        int i11 = (i10 + i7) * 31;
        f fVar = this.f19328k;
        if (fVar != null) {
            i8 = fVar.hashCode();
        }
        return i11 + i8;
    }

    public ProxySelector i() {
        return this.f19324g;
    }

    public SocketFactory j() {
        return this.f19320c;
    }

    public SSLSocketFactory k() {
        return this.f19326i;
    }

    public r l() {
        return this.f19318a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f19318a.k());
        sb.append(":");
        sb.append(this.f19318a.w());
        if (this.f19325h != null) {
            sb.append(", proxy=");
            sb.append(this.f19325h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f19324g);
        }
        sb.append("}");
        return sb.toString();
    }
}
