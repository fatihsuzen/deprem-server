package U3;

import V3.c;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final C f19550a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19551b;

    /* renamed from: c  reason: collision with root package name */
    private final List f19552c;

    /* renamed from: d  reason: collision with root package name */
    private final List f19553d;

    private p(C c5, g gVar, List list, List list2) {
        this.f19550a = c5;
        this.f19551b = gVar;
        this.f19552c = list;
        this.f19553d = list2;
    }

    public static p b(C c5, g gVar, List list, List list2) {
        if (c5 == null) {
            throw new NullPointerException("tlsVersion == null");
        } else if (gVar != null) {
            return new p(c5, gVar, c.q(list), c.q(list2));
        } else {
            throw new NullPointerException("cipherSuite == null");
        }
    }

    public static p c(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            g a5 = g.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                C a6 = C.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = c.r(certificateArr);
                } else {
                    list = Collections.EMPTY_LIST;
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = c.r(localCertificates);
                } else {
                    list2 = Collections.EMPTY_LIST;
                }
                return new p(a6, a5, list, list2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public g a() {
        return this.f19551b;
    }

    public List d() {
        return this.f19553d;
    }

    public List e() {
        return this.f19552c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (!this.f19550a.equals(pVar.f19550a) || !this.f19551b.equals(pVar.f19551b) || !this.f19552c.equals(pVar.f19552c) || !this.f19553d.equals(pVar.f19553d)) {
            return false;
        }
        return true;
    }

    public C f() {
        return this.f19550a;
    }

    public int hashCode() {
        return ((((((527 + this.f19550a.hashCode()) * 31) + this.f19551b.hashCode()) * 31) + this.f19552c.hashCode()) * 31) + this.f19553d.hashCode();
    }
}
