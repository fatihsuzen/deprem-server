package A0;

import A0.F;

/* renamed from: A0.e  reason: case insensitive filesystem */
final class C0625e extends F.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f2083a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2084b;

    /* renamed from: A0.e$b */
    static final class b extends F.c.a {

        /* renamed from: a  reason: collision with root package name */
        private String f2085a;

        /* renamed from: b  reason: collision with root package name */
        private String f2086b;

        b() {
        }

        public F.c a() {
            String str;
            String str2 = this.f2085a;
            if (str2 != null && (str = this.f2086b) != null) {
                return new C0625e(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2085a == null) {
                sb.append(" key");
            }
            if (this.f2086b == null) {
                sb.append(" value");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.c.a b(String str) {
            if (str != null) {
                this.f2085a = str;
                return this;
            }
            throw new NullPointerException("Null key");
        }

        public F.c.a c(String str) {
            if (str != null) {
                this.f2086b = str;
                return this;
            }
            throw new NullPointerException("Null value");
        }
    }

    public String b() {
        return this.f2083a;
    }

    public String c() {
        return this.f2084b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.c) {
            F.c cVar = (F.c) obj;
            if (!this.f2083a.equals(cVar.b()) || !this.f2084b.equals(cVar.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f2083a.hashCode() ^ 1000003) * 1000003) ^ this.f2084b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f2083a + ", value=" + this.f2084b + "}";
    }

    private C0625e(String str, String str2) {
        this.f2083a = str;
        this.f2084b = str2;
    }
}
