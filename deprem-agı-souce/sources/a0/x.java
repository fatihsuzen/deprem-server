package A0;

import A0.F;

final class x extends F.e.d.C0037e.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2267a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2268b;

    static final class b extends F.e.d.C0037e.b.a {

        /* renamed from: a  reason: collision with root package name */
        private String f2269a;

        /* renamed from: b  reason: collision with root package name */
        private String f2270b;

        b() {
        }

        public F.e.d.C0037e.b a() {
            String str;
            String str2 = this.f2269a;
            if (str2 != null && (str = this.f2270b) != null) {
                return new x(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2269a == null) {
                sb.append(" rolloutId");
            }
            if (this.f2270b == null) {
                sb.append(" variantId");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.C0037e.b.a b(String str) {
            if (str != null) {
                this.f2269a = str;
                return this;
            }
            throw new NullPointerException("Null rolloutId");
        }

        public F.e.d.C0037e.b.a c(String str) {
            if (str != null) {
                this.f2270b = str;
                return this;
            }
            throw new NullPointerException("Null variantId");
        }
    }

    public String b() {
        return this.f2267a;
    }

    public String c() {
        return this.f2268b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.C0037e.b) {
            F.e.d.C0037e.b bVar = (F.e.d.C0037e.b) obj;
            if (!this.f2267a.equals(bVar.b()) || !this.f2268b.equals(bVar.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f2267a.hashCode() ^ 1000003) * 1000003) ^ this.f2268b.hashCode();
    }

    public String toString() {
        return "RolloutVariant{rolloutId=" + this.f2267a + ", variantId=" + this.f2268b + "}";
    }

    private x(String str, String str2) {
        this.f2267a = str;
        this.f2268b = str2;
    }
}
