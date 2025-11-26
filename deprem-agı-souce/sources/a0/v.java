package A0;

import A0.F;

final class v extends F.e.d.C0036d {

    /* renamed from: a  reason: collision with root package name */
    private final String f2256a;

    static final class b extends F.e.d.C0036d.a {

        /* renamed from: a  reason: collision with root package name */
        private String f2257a;

        b() {
        }

        public F.e.d.C0036d a() {
            String str = this.f2257a;
            if (str != null) {
                return new v(str);
            }
            throw new IllegalStateException("Missing required properties:" + " content");
        }

        public F.e.d.C0036d.a b(String str) {
            if (str != null) {
                this.f2257a = str;
                return this;
            }
            throw new NullPointerException("Null content");
        }
    }

    public String b() {
        return this.f2256a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.C0036d) {
            return this.f2256a.equals(((F.e.d.C0036d) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f2256a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f2256a + "}";
    }

    private v(String str) {
        this.f2256a = str;
    }
}
