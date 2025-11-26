package androidx.collection;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class IntObjectMapKt {
    private static final MutableIntObjectMap EmptyIntObjectMap = new MutableIntObjectMap(0);

    public static final <V> IntObjectMap<V> emptyIntObjectMap() {
        MutableIntObjectMap mutableIntObjectMap = EmptyIntObjectMap;
        t.c(mutableIntObjectMap, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.emptyIntObjectMap>");
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf() {
        MutableIntObjectMap mutableIntObjectMap = EmptyIntObjectMap;
        t.c(mutableIntObjectMap, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.intObjectMapOf>");
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf() {
        return new MutableIntObjectMap<>(0, 1, (C2633k) null);
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i5, V v5) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, (C2633k) null);
        mutableIntObjectMap.set(i5, v5);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i5, V v5) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, (C2633k) null);
        mutableIntObjectMap.set(i5, v5);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i5, V v5, int i6, V v6) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, (C2633k) null);
        mutableIntObjectMap.set(i5, v5);
        mutableIntObjectMap.set(i6, v6);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i5, V v5, int i6, V v6) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, (C2633k) null);
        mutableIntObjectMap.set(i5, v5);
        mutableIntObjectMap.set(i6, v6);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i5, V v5, int i6, V v6, int i7, V v7) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, (C2633k) null);
        mutableIntObjectMap.set(i5, v5);
        mutableIntObjectMap.set(i6, v6);
        mutableIntObjectMap.set(i7, v7);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i5, V v5, int i6, V v6, int i7, V v7) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, (C2633k) null);
        mutableIntObjectMap.set(i5, v5);
        mutableIntObjectMap.set(i6, v6);
        mutableIntObjectMap.set(i7, v7);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i5, V v5, int i6, V v6, int i7, V v7, int i8, V v8) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, (C2633k) null);
        mutableIntObjectMap.set(i5, v5);
        mutableIntObjectMap.set(i6, v6);
        mutableIntObjectMap.set(i7, v7);
        mutableIntObjectMap.set(i8, v8);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i5, V v5, int i6, V v6, int i7, V v7, int i8, V v8) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, (C2633k) null);
        mutableIntObjectMap.set(i5, v5);
        mutableIntObjectMap.set(i6, v6);
        mutableIntObjectMap.set(i7, v7);
        mutableIntObjectMap.set(i8, v8);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i5, V v5, int i6, V v6, int i7, V v7, int i8, V v8, int i9, V v9) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, (C2633k) null);
        mutableIntObjectMap.set(i5, v5);
        mutableIntObjectMap.set(i6, v6);
        mutableIntObjectMap.set(i7, v7);
        mutableIntObjectMap.set(i8, v8);
        mutableIntObjectMap.set(i9, v9);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i5, V v5, int i6, V v6, int i7, V v7, int i8, V v8, int i9, V v9) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, (C2633k) null);
        mutableIntObjectMap.set(i5, v5);
        mutableIntObjectMap.set(i6, v6);
        mutableIntObjectMap.set(i7, v7);
        mutableIntObjectMap.set(i8, v8);
        mutableIntObjectMap.set(i9, v9);
        return mutableIntObjectMap;
    }
}
