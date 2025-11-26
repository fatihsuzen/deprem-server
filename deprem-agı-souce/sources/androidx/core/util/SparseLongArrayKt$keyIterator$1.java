package androidx.core.util;

import X2.J;
import android.util.SparseLongArray;

public final class SparseLongArrayKt$keyIterator$1 extends J {
    final /* synthetic */ SparseLongArray $this_keyIterator;
    private int index;

    SparseLongArrayKt$keyIterator$1(SparseLongArray sparseLongArray) {
        this.$this_keyIterator = sparseLongArray;
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
        SparseLongArray sparseLongArray = this.$this_keyIterator;
        int i5 = this.index;
        this.index = i5 + 1;
        return sparseLongArray.keyAt(i5);
    }

    public final void setIndex(int i5) {
        this.index = i5;
    }
}
