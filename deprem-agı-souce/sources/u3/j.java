package U3;

import V3.c;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class j {

    /* renamed from: e  reason: collision with root package name */
    private static final g[] f19514e;

    /* renamed from: f  reason: collision with root package name */
    public static final j f19515f;

    /* renamed from: g  reason: collision with root package name */
    public static final j f19516g;

    /* renamed from: h  reason: collision with root package name */
    public static final j f19517h = new a(false).a();

    /* renamed from: a  reason: collision with root package name */
    final boolean f19518a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f19519b;

    /* renamed from: c  reason: collision with root package name */
    final String[] f19520c;

    /* renamed from: d  reason: collision with root package name */
    final String[] f19521d;

    static {
        g[] gVarArr = {g.f19442Z0, g.f19453d1, g.f19444a1, g.f19456e1, g.f19474k1, g.f19471j1, g.f19412K0, g.f19414L0, g.f19467i0, g.f19470j0, g.f19403G, g.f19411K, g.f19472k};
        f19514e = gVarArr;
        a b5 = new a(true).b(gVarArr);
        C c5 = C.TLS_1_0;
        j a5 = b5.e(C.TLS_1_3, C.TLS_1_2, C.TLS_1_1, c5).d(true).a();
        f19515f = a5;
        f19516g = new a(a5).e(c5).d(true).a();
    }

    j(a aVar) {
        this.f19518a = aVar.f19522a;
        this.f19520c = aVar.f19523b;
        this.f19521d = aVar.f19524c;
        this.f19519b = aVar.f19525d;
    }

    private j e(SSLSocket sSLSocket, boolean z4) {
        String[] strArr;
        String[] strArr2;
        if (this.f19520c != null) {
            strArr = c.v(g.f19445b, sSLSocket.getEnabledCipherSuites(), this.f19520c);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f19521d != null) {
            strArr2 = c.v(c.f19715q, sSLSocket.getEnabledProtocols(), this.f19521d);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int s5 = c.s(g.f19445b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z4 && s5 != -1) {
            strArr = c.f(strArr, supportedCipherSuites[s5]);
        }
        return new a(this).c(strArr).f(strArr2).a();
    }

    /* access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z4) {
        j e5 = e(sSLSocket, z4);
        String[] strArr = e5.f19521d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = e5.f19520c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List b() {
        String[] strArr = this.f19520c;
        if (strArr != null) {
            return g.b(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f19518a) {
            return false;
        }
        String[] strArr = this.f19521d;
        if (strArr != null && !c.x(c.f19715q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f19520c;
        if (strArr2 == null || c.x(g.f19445b, strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public boolean d() {
        return this.f19518a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        j jVar = (j) obj;
        boolean z4 = this.f19518a;
        if (z4 != jVar.f19518a) {
            return false;
        }
        if (!z4 || (Arrays.equals(this.f19520c, jVar.f19520c) && Arrays.equals(this.f19521d, jVar.f19521d) && this.f19519b == jVar.f19519b)) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.f19519b;
    }

    public List g() {
        String[] strArr = this.f19521d;
        if (strArr != null) {
            return C.b(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f19518a) {
            return ((((527 + Arrays.hashCode(this.f19520c)) * 31) + Arrays.hashCode(this.f19521d)) * 31) + (this.f19519b ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        String str;
        if (!this.f19518a) {
            return "ConnectionSpec()";
        }
        String str2 = "[all enabled]";
        if (this.f19520c != null) {
            str = b().toString();
        } else {
            str = str2;
        }
        if (this.f19521d != null) {
            str2 = g().toString();
        }
        return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.f19519b + ")";
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f19522a;

        /* renamed from: b  reason: collision with root package name */
        String[] f19523b;

        /* renamed from: c  reason: collision with root package name */
        String[] f19524c;

        /* renamed from: d  reason: collision with root package name */
        boolean f19525d;

        a(boolean z4) {
            this.f19522a = z4;
        }

        public j a() {
            return new j(this);
        }

        public a b(g... gVarArr) {
            if (this.f19522a) {
                String[] strArr = new String[gVarArr.length];
                for (int i5 = 0; i5 < gVarArr.length; i5++) {
                    strArr[i5] = gVarArr[i5].f19505a;
                }
                return c(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a c(String... strArr) {
            if (!this.f19522a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f19523b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public a d(boolean z4) {
            if (this.f19522a) {
                this.f19525d = z4;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a e(C... cArr) {
            if (this.f19522a) {
                String[] strArr = new String[cArr.length];
                for (int i5 = 0; i5 < cArr.length; i5++) {
                    strArr[i5] = cArr[i5].f19317a;
                }
                return f(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a f(String... strArr) {
            if (!this.f19522a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f19524c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public a(j jVar) {
            this.f19522a = jVar.f19518a;
            this.f19523b = jVar.f19520c;
            this.f19524c = jVar.f19521d;
            this.f19525d = jVar.f19519b;
        }
    }
}
