package m0;

import java.util.Iterator;

public abstract class z implements Iterator {
    protected z() {
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
