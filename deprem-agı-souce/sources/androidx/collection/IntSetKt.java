package androidx.collection;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class IntSetKt {
    private static final int[] EmptyIntArray = new int[0];
    private static final MutableIntSet EmptyIntSet = new MutableIntSet(0);

    public static final IntSet emptyIntSet() {
        return EmptyIntSet;
    }

    public static final int[] getEmptyIntArray() {
        return EmptyIntArray;
    }

    public static final int hash(int i5) {
        int i6 = i5 * ScatterMapKt.MurmurHashC1;
        return i6 ^ (i6 << 16);
    }

    public static final IntSet intSetOf() {
        return EmptyIntSet;
    }

    public static final MutableIntSet mutableIntSetOf() {
        return new MutableIntSet(0, 1, (C2633k) null);
    }

    public static final IntSet intSetOf(int i5) {
        return mutableIntSetOf(i5);
    }

    public static final MutableIntSet mutableIntSetOf(int i5) {
        MutableIntSet mutableIntSet = new MutableIntSet(1);
        mutableIntSet.plusAssign(i5);
        return mutableIntSet;
    }

    public static final IntSet intSetOf(int i5, int i6) {
        return mutableIntSetOf(i5, i6);
    }

    public static final IntSet intSetOf(int i5, int i6, int i7) {
        return mutableIntSetOf(i5, i6, i7);
    }

    public static final MutableIntSet mutableIntSetOf(int i5, int i6) {
        MutableIntSet mutableIntSet = new MutableIntSet(2);
        mutableIntSet.plusAssign(i5);
        mutableIntSet.plusAssign(i6);
        return mutableIntSet;
    }

    public static final IntSet intSetOf(int... iArr) {
        t.e(iArr, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(iArr.length);
        mutableIntSet.plusAssign(iArr);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int i5, int i6, int i7) {
        MutableIntSet mutableIntSet = new MutableIntSet(3);
        mutableIntSet.plusAssign(i5);
        mutableIntSet.plusAssign(i6);
        mutableIntSet.plusAssign(i7);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int... iArr) {
        t.e(iArr, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(iArr.length);
        mutableIntSet.plusAssign(iArr);
        return mutableIntSet;
    }
}
