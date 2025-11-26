package q;

import q.p;

final class f extends p {

    /* renamed from: a  reason: collision with root package name */
    private final s f15768a;

    /* renamed from: b  reason: collision with root package name */
    private final p.b f15769b;

    static final class b extends p.a {

        /* renamed from: a  reason: collision with root package name */
        private s f15770a;

        /* renamed from: b  reason: collision with root package name */
        private p.b f15771b;

        b() {
        }

        public p a() {
            return new f(this.f15770a, this.f15771b);
        }

        public p.a b(s sVar) {
            this.f15770a = sVar;
            return this;
        }

        public p.a c(p.b bVar) {
            this.f15771b = bVar;
            return this;
        }
    }

    public s b() {
        return this.f15768a;
    }

    public p.b c() {
        return this.f15769b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            s sVar = this.f15768a;
            if (sVar != null ? sVar.equals(pVar.b()) : pVar.b() == null) {
                p.b bVar = this.f15769b;
                if (bVar != null ? !bVar.equals(pVar.c()) : pVar.c() != null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i5;
        s sVar = this.f15768a;
        int i6 = 0;
        if (sVar == null) {
            i5 = 0;
        } else {
            i5 = sVar.hashCode();
        }
        int i7 = (i5 ^ 1000003) * 1000003;
        p.b bVar = this.f15769b;
        if (bVar != null) {
            i6 = bVar.hashCode();
        }
        return i7 ^ i6;
    }

    public String toString() {
        return "ComplianceData{privacyContext=" + this.f15768a + ", productIdOrigin=" + this.f15769b + "}";
    }

    private f(s sVar, p.b bVar) {
        this.f15768a = sVar;
        this.f15769b = bVar;
    }
}
