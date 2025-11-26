package androidx.core.util;

import X2.J;
import android.util.SparseBooleanArray;

public final class SparseBooleanArrayKt$keyIterator$1 extends J {
    final /* synthetic */ SparseBooleanArray $this_keyIterator;
    private int index;

    SparseBooleanArrayKt$keyIterator$1(SparseBooleanArray sparseBooleanArray) {
        this.$this_keyIterator = sparseBooleanArray;
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
        SparseBooleanArray sparseBooleanArray = this.$this_keyIterator;
        int i5 = this.index;
        this.index = i5 + 1;
        return sparseBooleanArray.keyAt(i5);
    }

    public final void setIndex(int i5) {
        this.index = i5;
    }
}
