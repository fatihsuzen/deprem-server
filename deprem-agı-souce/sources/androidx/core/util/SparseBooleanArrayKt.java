package androidx.core.util;

import X2.C2249p;
import X2.J;
import android.util.SparseBooleanArray;
import k3.C2616a;
import k3.p;

public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i5) {
        if (sparseBooleanArray.indexOfKey(i5) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i5) {
        if (sparseBooleanArray.indexOfKey(i5) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z4) {
        if (sparseBooleanArray.indexOfValue(z4) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, p pVar) {
        int size = sparseBooleanArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i5)), Boolean.valueOf(sparseBooleanArray.valueAt(i5)));
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i5, boolean z4) {
        return sparseBooleanArray.get(i5, z4);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i5, C2616a aVar) {
        int indexOfKey = sparseBooleanArray.indexOfKey(i5);
        if (indexOfKey >= 0) {
            return sparseBooleanArray.valueAt(indexOfKey);
        }
        return ((Boolean) aVar.invoke()).booleanValue();
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final J keyIterator(SparseBooleanArray sparseBooleanArray) {
        return new SparseBooleanArrayKt$keyIterator$1(sparseBooleanArray);
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        int size = sparseBooleanArray2.size();
        for (int i5 = 0; i5 < size; i5++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i5), sparseBooleanArray2.valueAt(i5));
        }
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i5, boolean z4) {
        int indexOfKey = sparseBooleanArray.indexOfKey(i5);
        if (indexOfKey < 0 || z4 != sparseBooleanArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i5);
        return true;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i5, boolean z4) {
        sparseBooleanArray.put(i5, z4);
    }

    public static final C2249p valueIterator(SparseBooleanArray sparseBooleanArray) {
        return new SparseBooleanArrayKt$valueIterator$1(sparseBooleanArray);
    }
}
