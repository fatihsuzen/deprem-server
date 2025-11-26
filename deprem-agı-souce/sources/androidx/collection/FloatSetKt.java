package androidx.collection;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class FloatSetKt {
    private static final float[] EmptyFloatArray = new float[0];
    private static final MutableFloatSet EmptyFloatSet = new MutableFloatSet(0);

    public static final FloatSet emptyFloatSet() {
        return EmptyFloatSet;
    }

    public static final FloatSet floatSetOf() {
        return EmptyFloatSet;
    }

    public static final float[] getEmptyFloatArray() {
        return EmptyFloatArray;
    }

    public static final int hash(float f5) {
        int floatToIntBits = Float.floatToIntBits(f5) * ScatterMapKt.MurmurHashC1;
        return floatToIntBits ^ (floatToIntBits << 16);
    }

    public static final MutableFloatSet mutableFloatSetOf() {
        return new MutableFloatSet(0, 1, (C2633k) null);
    }

    public static final FloatSet floatSetOf(float f5) {
        return mutableFloatSetOf(f5);
    }

    public static final MutableFloatSet mutableFloatSetOf(float f5) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(1);
        mutableFloatSet.plusAssign(f5);
        return mutableFloatSet;
    }

    public static final FloatSet floatSetOf(float f5, float f6) {
        return mutableFloatSetOf(f5, f6);
    }

    public static final FloatSet floatSetOf(float f5, float f6, float f7) {
        return mutableFloatSetOf(f5, f6, f7);
    }

    public static final MutableFloatSet mutableFloatSetOf(float f5, float f6) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(2);
        mutableFloatSet.plusAssign(f5);
        mutableFloatSet.plusAssign(f6);
        return mutableFloatSet;
    }

    public static final FloatSet floatSetOf(float... fArr) {
        t.e(fArr, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(fArr.length);
        mutableFloatSet.plusAssign(fArr);
        return mutableFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf(float f5, float f6, float f7) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(3);
        mutableFloatSet.plusAssign(f5);
        mutableFloatSet.plusAssign(f6);
        mutableFloatSet.plusAssign(f7);
        return mutableFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf(float... fArr) {
        t.e(fArr, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(fArr.length);
        mutableFloatSet.plusAssign(fArr);
        return mutableFloatSet;
    }
}
