package A0;

import A0.F;

final class A extends F.e.f {

    /* renamed from: a  reason: collision with root package name */
    private final String f1862a;

    static final class b extends F.e.f.a {

        /* renamed from: a  reason: collision with root package name */
        private String f1863a;

        b() {
        }

        public F.e.f a() {
            String str = this.f1863a;
            if (str != null) {
                return new A(str);
            }
            throw new IllegalStateException("Missing required properties:" + " identifier");
        }

        public F.e.f.a b(String str) {
            if (str != null) {
                this.f1863a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }
    }

    public String b() {
        return this.f1862a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.f) {
            return this.f1862a.equals(((F.e.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f1862a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f1862a + "}";
    }

    private A(String str) {
        this.f1862a = str;
    }
}
