package X2;

import java.util.Iterator;
import l3.C2677a;

public abstract class J implements Iterator, C2677a {
    public abstract int nextInt();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
