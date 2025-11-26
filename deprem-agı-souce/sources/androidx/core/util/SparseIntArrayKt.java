package androidx.core.util;

import X2.J;
import android.util.SparseIntArray;
import k3.C2616a;
import k3.p;

public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray sparseIntArray, int i5) {
        if (sparseIntArray.indexOfKey(i5) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i5) {
        if (sparseIntArray.indexOfKey(i5) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i5) {
        if (sparseIntArray.indexOfValue(i5) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(SparseIntArray sparseIntArray, p pVar) {
        int size = sparseIntArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Integer.valueOf(sparseIntArray.keyAt(i5)), Integer.valueOf(sparseIntArray.valueAt(i5)));
        }
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i5, int i6) {
        return sparseIntArray.get(i5, i6);
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i5, C2616a aVar) {
        int indexOfKey = sparseIntArray.indexOfKey(i5);
        if (indexOfKey >= 0) {
            return sparseIntArray.valueAt(indexOfKey);
        }
        return ((Number) aVar.invoke()).intValue();
    }

    public static final int getSize(SparseIntArray sparseIntArray) {
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        if (sparseIntArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        if (sparseIntArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final J keyIterator(SparseIntArray sparseIntArray) {
        return new SparseIntArrayKt$keyIterator$1(sparseIntArray);
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        int size = sparseIntArray2.size();
        for (int i5 = 0; i5 < size; i5++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i5), sparseIntArray2.valueAt(i5));
        }
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i5, int i6) {
        int indexOfKey = sparseIntArray.indexOfKey(i5);
        if (indexOfKey < 0 || i6 != sparseIntArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(SparseIntArray sparseIntArray, int i5, int i6) {
        sparseIntArray.put(i5, i6);
    }

    public static final J valueIterator(SparseIntArray sparseIntArray) {
        return new SparseIntArrayKt$valueIterator$1(sparseIntArray);
    }
}
