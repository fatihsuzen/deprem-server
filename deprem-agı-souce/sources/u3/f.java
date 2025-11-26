package U3;

import d4.c;
import e4.C2359h;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class f {

    /* renamed from: c  reason: collision with root package name */
    public static final f f19387c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final Set f19388a;

    /* renamed from: b  reason: collision with root package name */
    private final c f19389b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f19390a = new ArrayList();

        public f a() {
            return new f(new LinkedHashSet(this.f19390a), (c) null);
        }
    }

    f(Set set, c cVar) {
        this.f19388a = set;
        this.f19389b = cVar;
    }

    public static String c(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + d((X509Certificate) certificate).a();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static C2359h d(X509Certificate x509Certificate) {
        return C2359h.w(x509Certificate.getPublicKey().getEncoded()).E();
    }

    public void a(String str, List list) {
        List b5 = b(str);
        if (!b5.isEmpty()) {
            c cVar = this.f19389b;
            if (cVar != null) {
                list = cVar.a(list, str);
            }
            int size = list.size();
            int i5 = 0;
            while (i5 < size) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i5);
                if (b5.size() <= 0) {
                    i5++;
                } else {
                    android.support.v4.media.a.a(b5.get(0));
                    throw null;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size2 = list.size();
            for (int i6 = 0; i6 < size2; i6++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i6);
                sb.append("\n    ");
                sb.append(c(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size3 = b5.size();
            for (int i7 = 0; i7 < size3; i7++) {
                android.support.v4.media.a.a(b5.get(i7));
                sb.append("\n    ");
                sb.append((Object) null);
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public List b(String str) {
        List list = Collections.EMPTY_LIST;
        Iterator it = this.f19388a.iterator();
        if (!it.hasNext()) {
            return list;
        }
        android.support.v4.media.a.a(it.next());
        throw null;
    }

    /* access modifiers changed from: package-private */
    public f e(c cVar) {
        if (V3.c.n(this.f19389b, cVar)) {
            return this;
        }
        return new f(this.f19388a, cVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (!V3.c.n(this.f19389b, fVar.f19389b) || !this.f19388a.equals(fVar.f19388a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i5;
        c cVar = this.f19389b;
        if (cVar != null) {
            i5 = cVar.hashCode();
        } else {
            i5 = 0;
        }
        return (i5 * 31) + this.f19388a.hashCode();
    }
}
