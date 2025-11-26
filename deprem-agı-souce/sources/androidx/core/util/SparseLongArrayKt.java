package androidx.core.util;

import X2.J;
import X2.K;
import android.util.SparseLongArray;
import k3.C2616a;
import k3.p;

public final class SparseLongArrayKt {
    public static final boolean contains(SparseLongArray sparseLongArray, int i5) {
        if (sparseLongArray.indexOfKey(i5) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(SparseLongArray sparseLongArray, int i5) {
        if (sparseLongArray.indexOfKey(i5) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(SparseLongArray sparseLongArray, long j5) {
        if (sparseLongArray.indexOfValue(j5) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(SparseLongArray sparseLongArray, p pVar) {
        int size = sparseLongArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Integer.valueOf(sparseLongArray.keyAt(i5)), Long.valueOf(sparseLongArray.valueAt(i5)));
        }
    }

    public static final long getOrDefault(SparseLongArray sparseLongArray, int i5, long j5) {
        return sparseLongArray.get(i5, j5);
    }

    public static final long getOrElse(SparseLongArray sparseLongArray, int i5, C2616a aVar) {
        int indexOfKey = sparseLongArray.indexOfKey(i5);
        if (indexOfKey >= 0) {
            return sparseLongArray.valueAt(indexOfKey);
        }
        return ((Number) aVar.invoke()).longValue();
    }

    public static final int getSize(SparseLongArray sparseLongArray) {
        return sparseLongArray.size();
    }

    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final J keyIterator(SparseLongArray sparseLongArray) {
        return new SparseLongArrayKt$keyIterator$1(sparseLongArray);
    }

    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        int size = sparseLongArray2.size();
        for (int i5 = 0; i5 < size; i5++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i5), sparseLongArray2.valueAt(i5));
        }
    }

    public static final boolean remove(SparseLongArray sparseLongArray, int i5, long j5) {
        int indexOfKey = sparseLongArray.indexOfKey(i5);
        if (indexOfKey < 0 || j5 != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(SparseLongArray sparseLongArray, int i5, long j5) {
        sparseLongArray.put(i5, j5);
    }

    public static final K valueIterator(SparseLongArray sparseLongArray) {
        return new SparseLongArrayKt$valueIterator$1(sparseLongArray);
    }
}
