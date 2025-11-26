package androidx.core.util;

import X2.J;
import android.util.SparseIntArray;

public final class SparseIntArrayKt$keyIterator$1 extends J {
    final /* synthetic */ SparseIntArray $this_keyIterator;
    private int index;

    SparseIntArrayKt$keyIterator$1(SparseIntArray sparseIntArray) {
        this.$this_keyIterator = sparseIntArray;
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
        SparseIntArray sparseIntArray = this.$this_keyIterator;
        int i5 = this.index;
        this.index = i5 + 1;
        return sparseIntArray.keyAt(i5);
    }

    public final void setIndex(int i5) {
        this.index = i5;
    }
}
