package q;

import java.util.List;

final class d extends n {

    /* renamed from: a  reason: collision with root package name */
    private final List f15763a;

    d(List list) {
        if (list != null) {
            this.f15763a = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    public List c() {
        return this.f15763a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            return this.f15763a.equals(((n) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f15763a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f15763a + "}";
    }
}
