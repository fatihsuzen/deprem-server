package A0;

import A0.G;
import u0.C1891f;

final class C extends G.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f1867a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1868b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1869c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1870d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1871e;

    /* renamed from: f  reason: collision with root package name */
    private final C1891f f1872f;

    C(String str, String str2, String str3, String str4, int i5, C1891f fVar) {
        if (str != null) {
            this.f1867a = str;
            if (str2 != null) {
                this.f1868b = str2;
                if (str3 != null) {
                    this.f1869c = str3;
                    if (str4 != null) {
                        this.f1870d = str4;
                        this.f1871e = i5;
                        if (fVar != null) {
                            this.f1872f = fVar;
                            return;
                        }
                        throw new NullPointerException("Null developmentPlatformProvider");
                    }
                    throw new NullPointerException("Null installUuid");
                }
                throw new NullPointerException("Null versionName");
            }
            throw new NullPointerException("Null versionCode");
        }
        throw new NullPointerException("Null appIdentifier");
    }

    public String a() {
        return this.f1867a;
    }

    public int c() {
        return this.f1871e;
    }

    public C1891f d() {
        return this.f1872f;
    }

    public String e() {
        return this.f1870d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof G.a) {
            G.a aVar = (G.a) obj;
            if (!this.f1867a.equals(aVar.a()) || !this.f1868b.equals(aVar.f()) || !this.f1869c.equals(aVar.g()) || !this.f1870d.equals(aVar.e()) || this.f1871e != aVar.c() || !this.f1872f.equals(aVar.d())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String f() {
        return this.f1868b;
    }

    public String g() {
        return this.f1869c;
    }

    public int hashCode() {
        return ((((((((((this.f1867a.hashCode() ^ 1000003) * 1000003) ^ this.f1868b.hashCode()) * 1000003) ^ this.f1869c.hashCode()) * 1000003) ^ this.f1870d.hashCode()) * 1000003) ^ this.f1871e) * 1000003) ^ this.f1872f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f1867a + ", versionCode=" + this.f1868b + ", versionName=" + this.f1869c + ", installUuid=" + this.f1870d + ", deliveryMechanism=" + this.f1871e + ", developmentPlatformProvider=" + this.f1872f + "}";
    }
}
