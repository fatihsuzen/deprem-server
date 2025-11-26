package androidx.core.view;

import X2.C2250q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.l;
import l3.C2677a;

public final class TreeIterator<T> implements Iterator<T>, C2677a {
    private final l getChildIterator;
    private Iterator<? extends T> iterator;
    private final List<Iterator<T>> stack = new ArrayList();

    public TreeIterator(Iterator<? extends T> it, l lVar) {
        this.getChildIterator = lVar;
        this.iterator = it;
    }

    private final void prepareNextIterator(T t5) {
        Iterator<? extends T> it = (Iterator) this.getChildIterator.invoke(t5);
        if (it == null || !it.hasNext()) {
            while (!this.iterator.hasNext() && !this.stack.isEmpty()) {
                this.iterator = (Iterator) C2250q.X(this.stack);
                C2250q.z(this.stack);
            }
            return;
        }
        this.stack.add(this.iterator);
        this.iterator = it;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public T next() {
        T next = this.iterator.next();
        prepareNextIterator(next);
        return next;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
