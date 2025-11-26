package q;

import q.r;

final class h extends r {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f15776a;

    static final class b extends r.a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f15777a;

        b() {
        }

        public r a() {
            return new h(this.f15777a);
        }

        public r.a b(Integer num) {
            this.f15777a = num;
            return this;
        }
    }

    public Integer b() {
        return this.f15776a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        Integer num = this.f15776a;
        Integer b5 = ((r) obj).b();
        if (num != null) {
            return num.equals(b5);
        }
        if (b5 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        Integer num = this.f15776a;
        if (num == null) {
            i5 = 0;
        } else {
            i5 = num.hashCode();
        }
        return i5 ^ 1000003;
    }

    public String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f15776a + "}";
    }

    private h(Integer num) {
        this.f15776a = num;
    }
}
