package A0;

import A0.F;
import java.util.List;

final class y extends F.e.d.f {

    /* renamed from: a  reason: collision with root package name */
    private final List f2271a;

    static final class b extends F.e.d.f.a {

        /* renamed from: a  reason: collision with root package name */
        private List f2272a;

        b() {
        }

        public F.e.d.f a() {
            List list = this.f2272a;
            if (list != null) {
                return new y(list);
            }
            throw new IllegalStateException("Missing required properties:" + " rolloutAssignments");
        }

        public F.e.d.f.a b(List list) {
            if (list != null) {
                this.f2272a = list;
                return this;
            }
            throw new NullPointerException("Null rolloutAssignments");
        }
    }

    public List b() {
        return this.f2271a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.f) {
            return this.f2271a.equals(((F.e.d.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f2271a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f2271a + "}";
    }

    private y(List list) {
        this.f2271a = list;
    }
}
