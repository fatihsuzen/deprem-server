package q;

import q.o;

final class e extends o {

    /* renamed from: a  reason: collision with root package name */
    private final o.b f15764a;

    /* renamed from: b  reason: collision with root package name */
    private final C1755a f15765b;

    static final class b extends o.a {

        /* renamed from: a  reason: collision with root package name */
        private o.b f15766a;

        /* renamed from: b  reason: collision with root package name */
        private C1755a f15767b;

        b() {
        }

        public o a() {
            return new e(this.f15766a, this.f15767b);
        }

        public o.a b(C1755a aVar) {
            this.f15767b = aVar;
            return this;
        }

        public o.a c(o.b bVar) {
            this.f15766a = bVar;
            return this;
        }
    }

    public C1755a b() {
        return this.f15765b;
    }

    public o.b c() {
        return this.f15764a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            o.b bVar = this.f15764a;
            if (bVar != null ? bVar.equals(oVar.c()) : oVar.c() == null) {
                C1755a aVar = this.f15765b;
                if (aVar != null ? !aVar.equals(oVar.b()) : oVar.b() != null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i5;
        o.b bVar = this.f15764a;
        int i6 = 0;
        if (bVar == null) {
            i5 = 0;
        } else {
            i5 = bVar.hashCode();
        }
        int i7 = (i5 ^ 1000003) * 1000003;
        C1755a aVar = this.f15765b;
        if (aVar != null) {
            i6 = aVar.hashCode();
        }
        return i7 ^ i6;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f15764a + ", androidClientInfo=" + this.f15765b + "}";
    }

    private e(o.b bVar, C1755a aVar) {
        this.f15764a = bVar;
        this.f15765b = aVar;
    }
}
