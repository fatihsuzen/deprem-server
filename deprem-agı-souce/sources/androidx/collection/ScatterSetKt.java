package androidx.collection;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class ScatterSetKt {
    private static final MutableScatterSet<Object> EmptyScatterSet = new MutableScatterSet<>(0);

    public static final <E> ScatterSet<E> emptyScatterSet() {
        MutableScatterSet<Object> mutableScatterSet = EmptyScatterSet;
        t.c(mutableScatterSet, "null cannot be cast to non-null type androidx.collection.ScatterSet<E of androidx.collection.ScatterSetKt.emptyScatterSet>");
        return mutableScatterSet;
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf() {
        return new MutableScatterSet<>(0, 1, (C2633k) null);
    }

    public static final <E> ScatterSet<E> scatterSetOf() {
        MutableScatterSet<Object> mutableScatterSet = EmptyScatterSet;
        t.c(mutableScatterSet, "null cannot be cast to non-null type androidx.collection.ScatterSet<E of androidx.collection.ScatterSetKt.scatterSetOf>");
        return mutableScatterSet;
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e5) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(1);
        mutableScatterSet.plusAssign(e5);
        return mutableScatterSet;
    }

    public static final <E> ScatterSet<E> scatterSetOf(E e5) {
        return mutableScatterSetOf(e5);
    }

    public static final <E> ScatterSet<E> scatterSetOf(E e5, E e6) {
        return mutableScatterSetOf(e5, e6);
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e5, E e6) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(2);
        mutableScatterSet.plusAssign(e5);
        mutableScatterSet.plusAssign(e6);
        return mutableScatterSet;
    }

    public static final <E> ScatterSet<E> scatterSetOf(E e5, E e6, E e7) {
        return mutableScatterSetOf(e5, e6, e7);
    }

    public static final <E> ScatterSet<E> scatterSetOf(E... eArr) {
        t.e(eArr, "elements");
        MutableScatterSet mutableScatterSet = new MutableScatterSet(eArr.length);
        mutableScatterSet.plusAssign(eArr);
        return mutableScatterSet;
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e5, E e6, E e7) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(3);
        mutableScatterSet.plusAssign(e5);
        mutableScatterSet.plusAssign(e6);
        mutableScatterSet.plusAssign(e7);
        return mutableScatterSet;
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E... eArr) {
        t.e(eArr, "elements");
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(eArr.length);
        mutableScatterSet.plusAssign(eArr);
        return mutableScatterSet;
    }
}
