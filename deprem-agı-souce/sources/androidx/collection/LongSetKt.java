package androidx.collection;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class LongSetKt {
    private static final long[] EmptyLongArray = new long[0];
    private static final MutableLongSet EmptyLongSet = new MutableLongSet(0);

    public static final LongSet emptyLongSet() {
        return EmptyLongSet;
    }

    public static final long[] getEmptyLongArray() {
        return EmptyLongArray;
    }

    public static final int hash(long j5) {
        int a5 = a.a(j5) * ScatterMapKt.MurmurHashC1;
        return a5 ^ (a5 << 16);
    }

    public static final LongSet longSetOf() {
        return EmptyLongSet;
    }

    public static final MutableLongSet mutableLongSetOf() {
        return new MutableLongSet(0, 1, (C2633k) null);
    }

    public static final LongSet longSetOf(long j5) {
        return mutableLongSetOf(j5);
    }

    public static final MutableLongSet mutableLongSetOf(long j5) {
        MutableLongSet mutableLongSet = new MutableLongSet(1);
        mutableLongSet.plusAssign(j5);
        return mutableLongSet;
    }

    public static final LongSet longSetOf(long j5, long j6) {
        return mutableLongSetOf(j5, j6);
    }

    public static final LongSet longSetOf(long j5, long j6, long j7) {
        return mutableLongSetOf(j5, j6, j7);
    }

    public static final MutableLongSet mutableLongSetOf(long j5, long j6) {
        MutableLongSet mutableLongSet = new MutableLongSet(2);
        mutableLongSet.plusAssign(j5);
        mutableLongSet.plusAssign(j6);
        return mutableLongSet;
    }

    public static final LongSet longSetOf(long... jArr) {
        t.e(jArr, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(jArr.length);
        mutableLongSet.plusAssign(jArr);
        return mutableLongSet;
    }

    public static final MutableLongSet mutableLongSetOf(long j5, long j6, long j7) {
        MutableLongSet mutableLongSet = new MutableLongSet(3);
        mutableLongSet.plusAssign(j5);
        mutableLongSet.plusAssign(j6);
        mutableLongSet.plusAssign(j7);
        return mutableLongSet;
    }

    public static final MutableLongSet mutableLongSetOf(long... jArr) {
        t.e(jArr, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(jArr.length);
        mutableLongSet.plusAssign(jArr);
        return mutableLongSet;
    }
}
