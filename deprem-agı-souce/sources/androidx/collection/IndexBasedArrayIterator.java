package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import l3.C2677a;

public abstract class IndexBasedArrayIterator<T> implements Iterator<T>, C2677a {
    private boolean canRemove;
    private int index;
    private int size;

    public IndexBasedArrayIterator(int i5) {
        this.size = i5;
    }

    /* access modifiers changed from: protected */
    public abstract T elementAt(int i5);

    public boolean hasNext() {
        if (this.index < this.size) {
            return true;
        }
        return false;
    }

    public T next() {
        if (hasNext()) {
            T elementAt = elementAt(this.index);
            this.index++;
            this.canRemove = true;
            return elementAt;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (this.canRemove) {
            int i5 = this.index - 1;
            this.index = i5;
            removeAt(i5);
            this.size--;
            this.canRemove = false;
            return;
        }
        throw new IllegalStateException("Call next() before removing an element.");
    }

    /* access modifiers changed from: protected */
    public abstract void removeAt(int i5);
}
