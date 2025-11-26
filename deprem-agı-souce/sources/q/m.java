package q;

import q.w;

final class m extends w {

    /* renamed from: a  reason: collision with root package name */
    private final w.c f15813a;

    /* renamed from: b  reason: collision with root package name */
    private final w.b f15814b;

    static final class b extends w.a {

        /* renamed from: a  reason: collision with root package name */
        private w.c f15815a;

        /* renamed from: b  reason: collision with root package name */
        private w.b f15816b;

        b() {
        }

        public w a() {
            return new m(this.f15815a, this.f15816b);
        }

        public w.a b(w.b bVar) {
            this.f15816b = bVar;
            return this;
        }

        public w.a c(w.c cVar) {
            this.f15815a = cVar;
            return this;
        }
    }

    public w.b b() {
        return this.f15814b;
    }

    public w.c c() {
        return this.f15813a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            w.c cVar = this.f15813a;
            if (cVar != null ? cVar.equals(wVar.c()) : wVar.c() == null) {
                w.b bVar = this.f15814b;
                if (bVar != null ? !bVar.equals(wVar.b()) : wVar.b() != null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i5;
        w.c cVar = this.f15813a;
        int i6 = 0;
        if (cVar == null) {
            i5 = 0;
        } else {
            i5 = cVar.hashCode();
        }
        int i7 = (i5 ^ 1000003) * 1000003;
        w.b bVar = this.f15814b;
        if (bVar != null) {
            i6 = bVar.hashCode();
        }
        return i7 ^ i6;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f15813a + ", mobileSubtype=" + this.f15814b + "}";
    }

    private m(w.c cVar, w.b bVar) {
        this.f15813a = cVar;
        this.f15814b = bVar;
    }
}
