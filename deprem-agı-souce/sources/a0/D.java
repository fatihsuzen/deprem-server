package A0;

import A0.G;

final class D extends G.b {

    /* renamed from: a  reason: collision with root package name */
    private final int f1873a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1874b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1875c;

    /* renamed from: d  reason: collision with root package name */
    private final long f1876d;

    /* renamed from: e  reason: collision with root package name */
    private final long f1877e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1878f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1879g;

    /* renamed from: h  reason: collision with root package name */
    private final String f1880h;

    /* renamed from: i  reason: collision with root package name */
    private final String f1881i;

    D(int i5, String str, int i6, long j5, long j6, boolean z4, int i7, String str2, String str3) {
        this.f1873a = i5;
        if (str != null) {
            this.f1874b = str;
            this.f1875c = i6;
            this.f1876d = j5;
            this.f1877e = j6;
            this.f1878f = z4;
            this.f1879g = i7;
            if (str2 != null) {
                this.f1880h = str2;
                if (str3 != null) {
                    this.f1881i = str3;
                    return;
                }
                throw new NullPointerException("Null modelClass");
            }
            throw new NullPointerException("Null manufacturer");
        }
        throw new NullPointerException("Null model");
    }

    public int a() {
        return this.f1873a;
    }

    public int b() {
        return this.f1875c;
    }

    public long d() {
        return this.f1877e;
    }

    public boolean e() {
        return this.f1878f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof G.b) {
            G.b bVar = (G.b) obj;
            if (this.f1873a == bVar.a() && this.f1874b.equals(bVar.g()) && this.f1875c == bVar.b() && this.f1876d == bVar.j() && this.f1877e == bVar.d() && this.f1878f == bVar.e() && this.f1879g == bVar.i() && this.f1880h.equals(bVar.f()) && this.f1881i.equals(bVar.h())) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String f() {
        return this.f1880h;
    }

    public String g() {
        return this.f1874b;
    }

    public String h() {
        return this.f1881i;
    }

    public int hashCode() {
        int i5;
        long j5 = this.f1876d;
        long j6 = this.f1877e;
        int hashCode = (((((((((this.f1873a ^ 1000003) * 1000003) ^ this.f1874b.hashCode()) * 1000003) ^ this.f1875c) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        if (this.f1878f) {
            i5 = 1231;
        } else {
            i5 = 1237;
        }
        return ((((((hashCode ^ i5) * 1000003) ^ this.f1879g) * 1000003) ^ this.f1880h.hashCode()) * 1000003) ^ this.f1881i.hashCode();
    }

    public int i() {
        return this.f1879g;
    }

    public long j() {
        return this.f1876d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f1873a + ", model=" + this.f1874b + ", availableProcessors=" + this.f1875c + ", totalRam=" + this.f1876d + ", diskSpace=" + this.f1877e + ", isEmulator=" + this.f1878f + ", state=" + this.f1879g + ", manufacturer=" + this.f1880h + ", modelClass=" + this.f1881i + "}";
    }
}
