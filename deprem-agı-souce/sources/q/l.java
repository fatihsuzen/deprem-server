package q;

final class l extends v {

    /* renamed from: a  reason: collision with root package name */
    private final long f15812a;

    l(long j5) {
        this.f15812a = j5;
    }

    public long c() {
        return this.f15812a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v) || this.f15812a != ((v) obj).c()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j5 = this.f15812a;
        return ((int) (j5 ^ (j5 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f15812a + "}";
    }
}
