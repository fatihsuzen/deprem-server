package androidx.core.util;

import X2.K;
import android.util.LongSparseArray;

public final class LongSparseArrayKt$keyIterator$1 extends K {
    final /* synthetic */ LongSparseArray<T> $this_keyIterator;
    private int index;

    LongSparseArrayKt$keyIterator$1(LongSparseArray<T> longSparseArray) {
        this.$this_keyIterator = longSparseArray;
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

    public long nextLong() {
        LongSparseArray<T> longSparseArray = this.$this_keyIterator;
        int i5 = this.index;
        this.index = i5 + 1;
        return longSparseArray.keyAt(i5);
    }

    public final void setIndex(int i5) {
        this.index = i5;
    }
}
