package x0;

import x0.J;

/* renamed from: x0.d  reason: case insensitive filesystem */
final class C1908d extends J.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f16854a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16855b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16856c;

    C1908d(String str, String str2, String str3) {
        if (str != null) {
            this.f16854a = str;
            this.f16855b = str2;
            this.f16856c = str3;
            return;
        }
        throw new NullPointerException("Null crashlyticsInstallId");
    }

    public String c() {
        return this.f16854a;
    }

    public String d() {
        return this.f16856c;
    }

    public String e() {
        return this.f16855b;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof J.a) {
            J.a aVar = (J.a) obj;
            if (!this.f16854a.equals(aVar.c()) || ((str = this.f16855b) != null ? !str.equals(aVar.e()) : aVar.e() != null) || ((str2 = this.f16856c) != null ? !str2.equals(aVar.d()) : aVar.d() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        int hashCode = (this.f16854a.hashCode() ^ 1000003) * 1000003;
        String str = this.f16855b;
        int i6 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int i7 = (hashCode ^ i5) * 1000003;
        String str2 = this.f16856c;
        if (str2 != null) {
            i6 = str2.hashCode();
        }
        return i7 ^ i6;
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.f16854a + ", firebaseInstallationId=" + this.f16855b + ", firebaseAuthenticationToken=" + this.f16856c + "}";
    }
}
