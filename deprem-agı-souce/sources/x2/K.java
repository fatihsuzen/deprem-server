package X2;

import java.util.Iterator;
import l3.C2677a;

public abstract class K implements Iterator, C2677a {
    public abstract long nextLong();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
