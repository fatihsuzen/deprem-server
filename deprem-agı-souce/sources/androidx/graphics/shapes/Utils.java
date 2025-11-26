package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import k3.C2616a;
import kotlin.jvm.internal.t;

public final class Utils {
    public static final float AngleEpsilon = 1.0E-6f;
    public static final boolean DEBUG = false;
    public static final float DistanceEpsilon = 1.0E-4f;
    private static final float FloatPi = 3.1415927f;
    private static final float TwoPi = 6.2831855f;
    private static final long Zero = FloatFloatPair.m3constructorimpl(0.0f, 0.0f);

    public static final float angle(float f5, float f6) {
        float f7 = TwoPi;
        return (((float) Math.atan2((double) f6, (double) f5)) + f7) % f7;
    }

    public static final void debugLog(String str, C2616a aVar) {
        t.e(str, "tag");
        t.e(aVar, "messageFactory");
    }

    public static final long directionVector(float f5, float f6) {
        float distance = distance(f5, f6);
        if (distance > 0.0f) {
            return FloatFloatPair.m3constructorimpl(f5 / distance, f6 / distance);
        }
        throw new IllegalArgumentException("Required distance greater than zero");
    }

    public static final float distance(float f5, float f6) {
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    public static final float distanceSquared(float f5, float f6) {
        return (f5 * f5) + (f6 * f6);
    }

    public static final float findMinimum(float f5, float f6, float f7, FindMinimumFunction findMinimumFunction) {
        t.e(findMinimumFunction, "f");
        while (f6 - f5 > f7) {
            float f8 = (float) 2;
            float f9 = (float) 3;
            float f10 = ((f8 * f5) + f6) / f9;
            float f11 = ((f8 * f6) + f5) / f9;
            if (findMinimumFunction.invoke(f10) < findMinimumFunction.invoke(f11)) {
                f6 = f11;
            } else {
                f5 = f10;
            }
        }
        return (f5 + f6) / ((float) 2);
    }

    public static /* synthetic */ float findMinimum$default(float f5, float f6, float f7, FindMinimumFunction findMinimumFunction, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            f7 = 0.001f;
        }
        return findMinimum(f5, f6, f7, findMinimumFunction);
    }

    public static final float getFloatPi() {
        return FloatPi;
    }

    public static final float getTwoPi() {
        return TwoPi;
    }

    public static final long getZero() {
        return Zero;
    }

    public static final float interpolate(float f5, float f6, float f7) {
        return ((((float) 1) - f7) * f5) + (f7 * f6);
    }

    public static final float positiveModulo(float f5, float f6) {
        return ((f5 % f6) + f6) % f6;
    }

    /* renamed from: radialToCartesian-L6JJ3z0  reason: not valid java name */
    public static final long m60radialToCartesianL6JJ3z0(float f5, float f6, long j5) {
        return PointKt.m43plusybeJwSQ(PointKt.m45timesso9K2fw(directionVector(f6), f5), j5);
    }

    /* renamed from: radialToCartesian-L6JJ3z0$default  reason: not valid java name */
    public static /* synthetic */ long m61radialToCartesianL6JJ3z0$default(float f5, float f6, long j5, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            j5 = Zero;
        }
        return m60radialToCartesianL6JJ3z0(f5, f6, j5);
    }

    /* renamed from: rotate90-DnnuFBc  reason: not valid java name */
    public static final long m62rotate90DnnuFBc(long j5) {
        return FloatFloatPair.m3constructorimpl(-PointKt.m40getYDnnuFBc(j5), PointKt.m39getXDnnuFBc(j5));
    }

    public static final float square(float f5) {
        return f5 * f5;
    }

    public static final long directionVector(float f5) {
        double d5 = (double) f5;
        return FloatFloatPair.m3constructorimpl((float) Math.cos(d5), (float) Math.sin(d5));
    }
}
