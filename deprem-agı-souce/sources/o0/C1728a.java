package o0;

/* renamed from: o0.a  reason: case insensitive filesystem */
final class C1728a extends p {

    /* renamed from: a  reason: collision with root package name */
    private final long f15631a;

    /* renamed from: b  reason: collision with root package name */
    private final long f15632b;

    /* renamed from: c  reason: collision with root package name */
    private final long f15633c;

    C1728a(long j5, long j6, long j7) {
        this.f15631a = j5;
        this.f15632b = j6;
        this.f15633c = j7;
    }

    public long b() {
        return this.f15632b;
    }

    public long c() {
        return this.f15631a;
    }

    public long d() {
        return this.f15633c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f15631a == pVar.c() && this.f15632b == pVar.b() && this.f15633c == pVar.d()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f15631a;
        long j6 = this.f15632b;
        long j7 = this.f15633c;
        return ((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ ((int) ((j7 >>> 32) ^ j7));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f15631a + ", elapsedRealtime=" + this.f15632b + ", uptimeMillis=" + this.f15633c + "}";
    }
}
