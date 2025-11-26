package androidx.core.util;

import X2.J;
import android.util.SparseArray;
import java.util.Iterator;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.t;

public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArray<T> sparseArray, int i5) {
        if (sparseArray.indexOfKey(i5) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i5) {
        if (sparseArray.indexOfKey(i5) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t5) {
        if (sparseArray.indexOfValue(t5) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, p pVar) {
        int size = sparseArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Integer.valueOf(sparseArray.keyAt(i5)), sparseArray.valueAt(i5));
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i5, T t5) {
        T t6 = sparseArray.get(i5);
        if (t6 == null) {
            return t5;
        }
        return t6;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i5, C2616a aVar) {
        T t5 = sparseArray.get(i5);
        if (t5 == null) {
            return aVar.invoke();
        }
        return t5;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        if (sparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        if (sparseArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final <T> J keyIterator(SparseArray<T> sparseArray) {
        return new SparseArrayKt$keyIterator$1(sparseArray);
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        int size = sparseArray2.size();
        for (int i5 = 0; i5 < size; i5++) {
            sparseArray.put(sparseArray2.keyAt(i5), sparseArray2.valueAt(i5));
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i5, T t5) {
        int indexOfKey = sparseArray.indexOfKey(i5);
        if (indexOfKey < 0 || !t.a(t5, sparseArray.valueAt(indexOfKey))) {
            return false;
        }
        sparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i5, T t5) {
        sparseArray.put(i5, t5);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        return new SparseArrayKt$valueIterator$1(sparseArray);
    }
}
