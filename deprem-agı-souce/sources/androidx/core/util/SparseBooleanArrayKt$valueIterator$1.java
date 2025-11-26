package androidx.core.util;

import X2.C2249p;
import android.util.SparseBooleanArray;

public final class SparseBooleanArrayKt$valueIterator$1 extends C2249p {
    final /* synthetic */ SparseBooleanArray $this_valueIterator;
    private int index;

    SparseBooleanArrayKt$valueIterator$1(SparseBooleanArray sparseBooleanArray) {
        this.$this_valueIterator = sparseBooleanArray;
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

    public boolean nextBoolean() {
        SparseBooleanArray sparseBooleanArray = this.$this_valueIterator;
        int i5 = this.index;
        this.index = i5 + 1;
        return sparseBooleanArray.valueAt(i5);
    }

    public final void setIndex(int i5) {
        this.index = i5;
    }
}
