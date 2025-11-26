package androidx.collection;

import java.util.Iterator;
import l3.C2677a;

public final class SparseArrayKt$valueIterator$1 implements Iterator<T>, C2677a {
    final /* synthetic */ SparseArrayCompat<T> $this_valueIterator;
    private int index;

    SparseArrayKt$valueIterator$1(SparseArrayCompat<T> sparseArrayCompat) {
        this.$this_valueIterator = sparseArrayCompat;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        if (this.index < this.$this_valueIterator.size()) {
            return true;
        }
        return false;
    }

    public T next() {
        SparseArrayCompat<T> sparseArrayCompat = this.$this_valueIterator;
        int i5 = this.index;
        this.index = i5 + 1;
        return sparseArrayCompat.valueAt(i5);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i5) {
        this.index = i5;
    }
}
