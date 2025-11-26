package d4;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public final class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Map f21429a = new LinkedHashMap();

    public b(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set set = (Set) this.f21429a.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet(1);
                this.f21429a.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b) || !((b) obj).f21429a.equals(this.f21429a)) {
            return false;
        }
        return true;
    }

    public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
        Set<X509Certificate> set = (Set) this.f21429a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public int hashCode() {
        return this.f21429a.hashCode();
    }
}
