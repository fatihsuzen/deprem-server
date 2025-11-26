package androidx.collection;

import b3.C2308e;
import java.util.Iterator;
import l3.C2677a;
import s3.C2754h;

public final class MutableScatterSet$MutableSetWrapper$iterator$1 implements Iterator<E>, C2677a {
    private int current = -1;
    private final Iterator<E> iterator;
    final /* synthetic */ MutableScatterSet<E> this$0;

    MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet<E> mutableScatterSet) {
        this.this$0 = mutableScatterSet;
        this.iterator = C2754h.a(new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(mutableScatterSet, this, (C2308e) null));
    }

    public final int getCurrent() {
        return this.current;
    }

    public final Iterator<E> getIterator() {
        return this.iterator;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public E next() {
        return this.iterator.next();
    }

    public void remove() {
        int i5 = this.current;
        if (i5 != -1) {
            this.this$0.removeElementAt(i5);
            this.current = -1;
        }
    }

    public final void setCurrent(int i5) {
        this.current = i5;
    }
}
