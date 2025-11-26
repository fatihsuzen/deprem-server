package androidx.core.util;

import X2.K;
import android.util.LongSparseArray;
import java.util.Iterator;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.t;

public final class LongSparseArrayKt {
    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j5) {
        if (longSparseArray.indexOfKey(j5) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long j5) {
        if (longSparseArray.indexOfKey(j5) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t5) {
        if (longSparseArray.indexOfValue(t5) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, p pVar) {
        int size = longSparseArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Long.valueOf(longSparseArray.keyAt(i5)), longSparseArray.valueAt(i5));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j5, T t5) {
        T t6 = longSparseArray.get(j5);
        if (t6 == null) {
            return t5;
        }
        return t6;
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j5, C2616a aVar) {
        T t5 = longSparseArray.get(j5);
        if (t5 == null) {
            return aVar.invoke();
        }
        return t5;
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        return longSparseArray.size();
    }

    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        if (longSparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        if (longSparseArray.size() != 0) {
            return true;
        }
        return false;
    }

    public static final <T> K keyIterator(LongSparseArray<T> longSparseArray) {
        return new LongSparseArrayKt$keyIterator$1(longSparseArray);
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        int size = longSparseArray2.size();
        for (int i5 = 0; i5 < size; i5++) {
            longSparseArray.put(longSparseArray2.keyAt(i5), longSparseArray2.valueAt(i5));
        }
    }

    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j5, T t5) {
        int indexOfKey = longSparseArray.indexOfKey(j5);
        if (indexOfKey < 0 || !t.a(t5, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j5, T t5) {
        longSparseArray.put(j5, t5);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }
}
