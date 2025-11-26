package androidx.core.util;

import X2.J;
import android.util.SparseArray;

public final class SparseArrayKt$keyIterator$1 extends J {
    final /* synthetic */ SparseArray<T> $this_keyIterator;
    private int index;

    SparseArrayKt$keyIterator$1(SparseArray<T> sparseArray) {
        this.$this_keyIterator = sparseArray;
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
        SparseArray<T> sparseArray = this.$this_keyIterator;
        int i5 = this.index;
        this.index = i5 + 1;
        return sparseArray.keyAt(i5);
    }

    public final void setIndex(int i5) {
        this.index = i5;
    }
}
