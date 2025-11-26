package A0;

import A0.G;

final class E extends G.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f1882a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1883b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1884c;

    E(String str, String str2, boolean z4) {
        if (str != null) {
            this.f1882a = str;
            if (str2 != null) {
                this.f1883b = str2;
                this.f1884c = z4;
                return;
            }
            throw new NullPointerException("Null osCodeName");
        }
        throw new NullPointerException("Null osRelease");
    }

    public boolean b() {
        return this.f1884c;
    }

    public String c() {
        return this.f1883b;
    }

    public String d() {
        return this.f1882a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof G.c) {
            G.c cVar = (G.c) obj;
            if (!this.f1882a.equals(cVar.d()) || !this.f1883b.equals(cVar.c()) || this.f1884c != cVar.b()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        int hashCode = (((this.f1882a.hashCode() ^ 1000003) * 1000003) ^ this.f1883b.hashCode()) * 1000003;
        if (this.f1884c) {
            i5 = 1231;
        } else {
            i5 = 1237;
        }
        return hashCode ^ i5;
    }

    public String toString() {
        return "OsData{osRelease=" + this.f1882a + ", osCodeName=" + this.f1883b + ", isRooted=" + this.f1884c + "}";
    }
}
