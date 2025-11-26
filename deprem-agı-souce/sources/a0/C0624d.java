package A0;

import A0.F;

/* renamed from: A0.d  reason: case insensitive filesystem */
final class C0624d extends F.a.C0021a {

    /* renamed from: a  reason: collision with root package name */
    private final String f2077a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2078b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2079c;

    /* renamed from: A0.d$b */
    static final class b extends F.a.C0021a.C0022a {

        /* renamed from: a  reason: collision with root package name */
        private String f2080a;

        /* renamed from: b  reason: collision with root package name */
        private String f2081b;

        /* renamed from: c  reason: collision with root package name */
        private String f2082c;

        b() {
        }

        public F.a.C0021a a() {
            String str;
            String str2;
            String str3 = this.f2080a;
            if (str3 != null && (str = this.f2081b) != null && (str2 = this.f2082c) != null) {
                return new C0624d(str3, str, str2);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2080a == null) {
                sb.append(" arch");
            }
            if (this.f2081b == null) {
                sb.append(" libraryName");
            }
            if (this.f2082c == null) {
                sb.append(" buildId");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.a.C0021a.C0022a b(String str) {
            if (str != null) {
                this.f2080a = str;
                return this;
            }
            throw new NullPointerException("Null arch");
        }

        public F.a.C0021a.C0022a c(String str) {
            if (str != null) {
                this.f2082c = str;
                return this;
            }
            throw new NullPointerException("Null buildId");
        }

        public F.a.C0021a.C0022a d(String str) {
            if (str != null) {
                this.f2081b = str;
                return this;
            }
            throw new NullPointerException("Null libraryName");
        }
    }

    public String b() {
        return this.f2077a;
    }

    public String c() {
        return this.f2079c;
    }

    public String d() {
        return this.f2078b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.a.C0021a) {
            F.a.C0021a aVar = (F.a.C0021a) obj;
            if (!this.f2077a.equals(aVar.b()) || !this.f2078b.equals(aVar.d()) || !this.f2079c.equals(aVar.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f2077a.hashCode() ^ 1000003) * 1000003) ^ this.f2078b.hashCode()) * 1000003) ^ this.f2079c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.f2077a + ", libraryName=" + this.f2078b + ", buildId=" + this.f2079c + "}";
    }

    private C0624d(String str, String str2, String str3) {
        this.f2077a = str;
        this.f2078b = str2;
        this.f2079c = str3;
    }
}
