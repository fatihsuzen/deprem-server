package X2;

import java.util.Iterator;
import l3.C2677a;

/* renamed from: X2.p  reason: case insensitive filesystem */
public abstract class C2249p implements Iterator, C2677a {
    public abstract boolean nextBoolean();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
