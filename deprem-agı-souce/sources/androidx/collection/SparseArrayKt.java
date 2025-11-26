package androidx.collection;

import X2.J;
import java.util.Iterator;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.t;

public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArrayCompat<T> sparseArrayCompat, int i5) {
        t.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.containsKey(i5);
    }

    public static final <T> void forEach(SparseArrayCompat<T> sparseArrayCompat, p pVar) {
        t.e(sparseArrayCompat, "<this>");
        t.e(pVar, "action");
        int size = sparseArrayCompat.size();
        for (int i5 = 0; i5 < size; i5++) {
            pVar.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i5)), sparseArrayCompat.valueAt(i5));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> sparseArrayCompat, int i5, T t5) {
        t.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.get(i5, t5);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> sparseArrayCompat, int i5, C2616a aVar) {
        t.e(sparseArrayCompat, "<this>");
        t.e(aVar, "defaultValue");
        T t5 = sparseArrayCompat.get(i5);
        if (t5 == null) {
            return aVar.invoke();
        }
        return t5;
    }

    public static final <T> int getSize(SparseArrayCompat<T> sparseArrayCompat) {
        t.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> sparseArrayCompat) {
        t.e(sparseArrayCompat, "<this>");
        return !sparseArrayCompat.isEmpty();
    }

    public static final <T> J keyIterator(SparseArrayCompat<T> sparseArrayCompat) {
        t.e(sparseArrayCompat, "<this>");
        return new SparseArrayKt$keyIterator$1(sparseArrayCompat);
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> sparseArrayCompat, SparseArrayCompat<T> sparseArrayCompat2) {
        t.e(sparseArrayCompat, "<this>");
        t.e(sparseArrayCompat2, "other");
        SparseArrayCompat<T> sparseArrayCompat3 = new SparseArrayCompat<>(sparseArrayCompat.size() + sparseArrayCompat2.size());
        sparseArrayCompat3.putAll(sparseArrayCompat);
        sparseArrayCompat3.putAll(sparseArrayCompat2);
        return sparseArrayCompat3;
    }

    public static final <T> void set(SparseArrayCompat<T> sparseArrayCompat, int i5, T t5) {
        t.e(sparseArrayCompat, "<this>");
        sparseArrayCompat.put(i5, t5);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> sparseArrayCompat) {
        t.e(sparseArrayCompat, "<this>");
        return new SparseArrayKt$valueIterator$1(sparseArrayCompat);
    }
}
