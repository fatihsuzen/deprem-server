package z0;

/* renamed from: z0.b  reason: case insensitive filesystem */
final class C1973b extends j {

    /* renamed from: b  reason: collision with root package name */
    private final String f17180b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17181c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17182d;

    /* renamed from: e  reason: collision with root package name */
    private final String f17183e;

    /* renamed from: f  reason: collision with root package name */
    private final long f17184f;

    C1973b(String str, String str2, String str3, String str4, long j5) {
        if (str != null) {
            this.f17180b = str;
            if (str2 != null) {
                this.f17181c = str2;
                if (str3 != null) {
                    this.f17182d = str3;
                    if (str4 != null) {
                        this.f17183e = str4;
                        this.f17184f = j5;
                        return;
                    }
                    throw new NullPointerException("Null variantId");
                }
                throw new NullPointerException("Null parameterValue");
            }
            throw new NullPointerException("Null parameterKey");
        }
        throw new NullPointerException("Null rolloutId");
    }

    public String c() {
        return this.f17181c;
    }

    public String d() {
        return this.f17182d;
    }

    public String e() {
        return this.f17180b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (!this.f17180b.equals(jVar.e()) || !this.f17181c.equals(jVar.c()) || !this.f17182d.equals(jVar.d()) || !this.f17183e.equals(jVar.g()) || this.f17184f != jVar.f()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public long f() {
        return this.f17184f;
    }

    public String g() {
        return this.f17183e;
    }

    public int hashCode() {
        long j5 = this.f17184f;
        return ((((((((this.f17180b.hashCode() ^ 1000003) * 1000003) ^ this.f17181c.hashCode()) * 1000003) ^ this.f17182d.hashCode()) * 1000003) ^ this.f17183e.hashCode()) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f17180b + ", parameterKey=" + this.f17181c + ", parameterValue=" + this.f17182d + ", variantId=" + this.f17183e + ", templateVersion=" + this.f17184f + "}";
    }
}
