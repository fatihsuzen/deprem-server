package androidx.core.util;

import X2.K;
import android.util.SparseLongArray;

public final class SparseLongArrayKt$valueIterator$1 extends K {
    final /* synthetic */ SparseLongArray $this_valueIterator;
    private int index;

    SparseLongArrayKt$valueIterator$1(SparseLongArray sparseLongArray) {
        this.$this_valueIterator = sparseLongArray;
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

    public long nextLong() {
        SparseLongArray sparseLongArray = this.$this_valueIterator;
        int i5 = this.index;
        this.index = i5 + 1;
        return sparseLongArray.valueAt(i5);
    }

    public final void setIndex(int i5) {
        this.index = i5;
    }
}
