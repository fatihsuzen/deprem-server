package androidx.core.util;

import X2.J;
import android.util.SparseIntArray;

public final class SparseIntArrayKt$valueIterator$1 extends J {
    final /* synthetic */ SparseIntArray $this_valueIterator;
    private int index;

    SparseIntArrayKt$valueIterator$1(SparseIntArray sparseIntArray) {
        this.$this_valueIterator = sparseIntArray;
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

    public int nextInt() {
        SparseIntArray sparseIntArray = this.$this_valueIterator;
        int i5 = this.index;
        this.index = i5 + 1;
        return sparseIntArray.valueAt(i5);
    }

    public final void setIndex(int i5) {
        this.index = i5;
    }
}
