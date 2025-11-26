package A0;

import A0.F;
import java.util.List;

final class n extends F.e.d.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final List f2179a;

    /* renamed from: b  reason: collision with root package name */
    private final F.e.d.a.b.c f2180b;

    /* renamed from: c  reason: collision with root package name */
    private final F.a f2181c;

    /* renamed from: d  reason: collision with root package name */
    private final F.e.d.a.b.C0029d f2182d;

    /* renamed from: e  reason: collision with root package name */
    private final List f2183e;

    static final class b extends F.e.d.a.b.C0027b {

        /* renamed from: a  reason: collision with root package name */
        private List f2184a;

        /* renamed from: b  reason: collision with root package name */
        private F.e.d.a.b.c f2185b;

        /* renamed from: c  reason: collision with root package name */
        private F.a f2186c;

        /* renamed from: d  reason: collision with root package name */
        private F.e.d.a.b.C0029d f2187d;

        /* renamed from: e  reason: collision with root package name */
        private List f2188e;

        b() {
        }

        public F.e.d.a.b a() {
            List list;
            F.e.d.a.b.C0029d dVar = this.f2187d;
            if (dVar != null && (list = this.f2188e) != null) {
                return new n(this.f2184a, this.f2185b, this.f2186c, dVar, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2187d == null) {
                sb.append(" signal");
            }
            if (this.f2188e == null) {
                sb.append(" binaries");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.b.C0027b b(F.a aVar) {
            this.f2186c = aVar;
            return this;
        }

        public F.e.d.a.b.C0027b c(List list) {
            if (list != null) {
                this.f2188e = list;
                return this;
            }
            throw new NullPointerException("Null binaries");
        }

        public F.e.d.a.b.C0027b d(F.e.d.a.b.c cVar) {
            this.f2185b = cVar;
            return this;
        }

        public F.e.d.a.b.C0027b e(F.e.d.a.b.C0029d dVar) {
            if (dVar != null) {
                this.f2187d = dVar;
                return this;
            }
            throw new NullPointerException("Null signal");
        }

        public F.e.d.a.b.C0027b f(List list) {
            this.f2184a = list;
            return this;
        }
    }

    public F.a b() {
        return this.f2181c;
    }

    public List c() {
        return this.f2183e;
    }

    public F.e.d.a.b.c d() {
        return this.f2180b;
    }

    public F.e.d.a.b.C0029d e() {
        return this.f2182d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.b) {
            F.e.d.a.b bVar = (F.e.d.a.b) obj;
            List list = this.f2179a;
            if (list != null ? list.equals(bVar.f()) : bVar.f() == null) {
                F.e.d.a.b.c cVar = this.f2180b;
                if (cVar != null ? cVar.equals(bVar.d()) : bVar.d() == null) {
                    F.a aVar = this.f2181c;
                    if (aVar != null ? aVar.equals(bVar.b()) : bVar.b() == null) {
                        if (!this.f2182d.equals(bVar.e()) || !this.f2183e.equals(bVar.c())) {
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List f() {
        return this.f2179a;
    }

    public int hashCode() {
        int i5;
        int i6;
        List list = this.f2179a;
        int i7 = 0;
        if (list == null) {
            i5 = 0;
        } else {
            i5 = list.hashCode();
        }
        int i8 = (i5 ^ 1000003) * 1000003;
        F.e.d.a.b.c cVar = this.f2180b;
        if (cVar == null) {
            i6 = 0;
        } else {
            i6 = cVar.hashCode();
        }
        int i9 = (i8 ^ i6) * 1000003;
        F.a aVar = this.f2181c;
        if (aVar != null) {
            i7 = aVar.hashCode();
        }
        return ((((i9 ^ i7) * 1000003) ^ this.f2182d.hashCode()) * 1000003) ^ this.f2183e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f2179a + ", exception=" + this.f2180b + ", appExitInfo=" + this.f2181c + ", signal=" + this.f2182d + ", binaries=" + this.f2183e + "}";
    }

    private n(List list, F.e.d.a.b.c cVar, F.a aVar, F.e.d.a.b.C0029d dVar, List list2) {
        this.f2179a = list;
        this.f2180b = cVar;
        this.f2181c = aVar;
        this.f2182d = dVar;
        this.f2183e = list2;
    }
}
