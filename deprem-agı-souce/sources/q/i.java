package q;

import q.s;

final class i extends s {

    /* renamed from: a  reason: collision with root package name */
    private final r f15778a;

    static final class b extends s.a {

        /* renamed from: a  reason: collision with root package name */
        private r f15779a;

        b() {
        }

        public s a() {
            return new i(this.f15779a);
        }

        public s.a b(r rVar) {
            this.f15779a = rVar;
            return this;
        }
    }

    public r b() {
        return this.f15778a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        r rVar = this.f15778a;
        r b5 = ((s) obj).b();
        if (rVar != null) {
            return rVar.equals(b5);
        }
        if (b5 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        r rVar = this.f15778a;
        if (rVar == null) {
            i5 = 0;
        } else {
            i5 = rVar.hashCode();
        }
        return i5 ^ 1000003;
    }

    public String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f15778a + "}";
    }

    private i(r rVar) {
        this.f15778a = rVar;
    }
}
