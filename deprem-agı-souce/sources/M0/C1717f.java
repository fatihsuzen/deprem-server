package m0;

import java.io.Serializable;
import java.util.Comparator;
import l0.h;

/* renamed from: m0.f  reason: case insensitive filesystem */
final class C1717f extends r implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    final Comparator f15552a;

    C1717f(Comparator comparator) {
        this.f15552a = (Comparator) h.h(comparator);
    }

    public int compare(Object obj, Object obj2) {
        return this.f15552a.compare(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1717f) {
            return this.f15552a.equals(((C1717f) obj).f15552a);
        }
        return false;
    }

    public int hashCode() {
        return this.f15552a.hashCode();
    }

    public String toString() {
        return this.f15552a.toString();
    }
}
