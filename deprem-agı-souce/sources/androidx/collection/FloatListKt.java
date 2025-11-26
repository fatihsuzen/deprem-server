package androidx.collection;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class FloatListKt {
    private static final FloatList EmptyFloatList = new MutableFloatList(0);

    public static final FloatList emptyFloatList() {
        return EmptyFloatList;
    }

    public static final FloatList floatListOf() {
        return EmptyFloatList;
    }

    public static final MutableFloatList mutableFloatListOf() {
        return new MutableFloatList(0, 1, (C2633k) null);
    }

    public static final FloatList floatListOf(float f5) {
        return mutableFloatListOf(f5);
    }

    public static final MutableFloatList mutableFloatListOf(float f5) {
        MutableFloatList mutableFloatList = new MutableFloatList(1);
        mutableFloatList.add(f5);
        return mutableFloatList;
    }

    public static final FloatList floatListOf(float f5, float f6) {
        return mutableFloatListOf(f5, f6);
    }

    public static final FloatList floatListOf(float f5, float f6, float f7) {
        return mutableFloatListOf(f5, f6, f7);
    }

    public static final MutableFloatList mutableFloatListOf(float f5, float f6) {
        MutableFloatList mutableFloatList = new MutableFloatList(2);
        mutableFloatList.add(f5);
        mutableFloatList.add(f6);
        return mutableFloatList;
    }

    public static final FloatList floatListOf(float... fArr) {
        t.e(fArr, "elements");
        MutableFloatList mutableFloatList = new MutableFloatList(fArr.length);
        mutableFloatList.plusAssign(fArr);
        return mutableFloatList;
    }

    public static final MutableFloatList mutableFloatListOf(float f5, float f6, float f7) {
        MutableFloatList mutableFloatList = new MutableFloatList(3);
        mutableFloatList.add(f5);
        mutableFloatList.add(f6);
        mutableFloatList.add(f7);
        return mutableFloatList;
    }

    public static final MutableFloatList mutableFloatListOf(float... fArr) {
        t.e(fArr, "elements");
        MutableFloatList mutableFloatList = new MutableFloatList(fArr.length);
        mutableFloatList.plusAssign(fArr);
        return mutableFloatList;
    }
}
