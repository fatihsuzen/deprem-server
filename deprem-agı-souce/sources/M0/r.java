package m0;

import java.util.Comparator;
import l0.c;

public abstract class r implements Comparator {
    protected r() {
    }

    public static r a(Comparator comparator) {
        if (comparator instanceof r) {
            return (r) comparator;
        }
        return new C1717f(comparator);
    }

    public r b(c cVar) {
        return new C1714c(cVar, this);
    }

    public abstract int compare(Object obj, Object obj2);
}
