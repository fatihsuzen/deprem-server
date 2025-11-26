package androidx.collection;

import X2.J;

public final class SparseArrayKt$keyIterator$1 extends J {
    final /* synthetic */ SparseArrayCompat<T> $this_keyIterator;
    private int index;

    SparseArrayKt$keyIterator$1(SparseArrayCompat<T> sparseArrayCompat) {
        this.$this_keyIterator = sparseArrayCompat;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        if (this.index < this.$this_keyIterator.size()) {
            return true;
        }
        return false;
    }

    public int nextInt() {
        SparseArrayCompat<T> sparseArrayCompat = this.$this_keyIterator;
        int i5 = this.index;
        this.index = i5 + 1;
        return sparseArrayCompat.keyAt(i5);
    }

    public final void setIndex(int i5) {
        this.index = i5;
    }
}
