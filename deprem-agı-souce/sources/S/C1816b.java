package s;

import s.g;

/* renamed from: s.b  reason: case insensitive filesystem */
final class C1816b extends g {

    /* renamed from: a  reason: collision with root package name */
    private final g.a f16456a;

    /* renamed from: b  reason: collision with root package name */
    private final long f16457b;

    C1816b(g.a aVar, long j5) {
        if (aVar != null) {
            this.f16456a = aVar;
            this.f16457b = j5;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public long b() {
        return this.f16457b;
    }

    public g.a c() {
        return this.f16456a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (!this.f16456a.equals(gVar.c()) || this.f16457b != gVar.b()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f16457b;
        return ((this.f16456a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f16456a + ", nextRequestWaitMillis=" + this.f16457b + "}";
    }
}
