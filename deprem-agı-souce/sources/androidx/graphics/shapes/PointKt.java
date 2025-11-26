package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import kotlin.jvm.internal.t;

public final class PointKt {
    /* renamed from: clockwise-ybeJwSQ  reason: not valid java name */
    public static final boolean m30clockwiseybeJwSQ(long j5, long j6) {
        if ((m39getXDnnuFBc(j5) * m40getYDnnuFBc(j6)) - (m40getYDnnuFBc(j5) * m39getXDnnuFBc(j6)) > 0.0f) {
            return true;
        }
        return false;
    }

    /* renamed from: copy-5P9i7ZU  reason: not valid java name */
    public static final long m31copy5P9i7ZU(long j5, float f5, float f6) {
        return FloatFloatPair.m3constructorimpl(f5, f6);
    }

    /* renamed from: copy-5P9i7ZU$default  reason: not valid java name */
    public static /* synthetic */ long m32copy5P9i7ZU$default(long j5, float f5, float f6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Float.intBitsToFloat((int) (j5 >> 32));
        }
        if ((i5 & 2) != 0) {
            f6 = Float.intBitsToFloat((int) (4294967295L & j5));
        }
        return m31copy5P9i7ZU(j5, f5, f6);
    }

    /* renamed from: div-so9K2fw  reason: not valid java name */
    public static final long m33divso9K2fw(long j5, float f5) {
        return FloatFloatPair.m3constructorimpl(m39getXDnnuFBc(j5) / f5, m40getYDnnuFBc(j5) / f5);
    }

    /* renamed from: dotProduct-5P9i7ZU  reason: not valid java name */
    public static final float m34dotProduct5P9i7ZU(long j5, float f5, float f6) {
        return (m39getXDnnuFBc(j5) * f5) + (m40getYDnnuFBc(j5) * f6);
    }

    /* renamed from: dotProduct-ybeJwSQ  reason: not valid java name */
    public static final float m35dotProductybeJwSQ(long j5, long j6) {
        return (m39getXDnnuFBc(j5) * m39getXDnnuFBc(j6)) + (m40getYDnnuFBc(j5) * m40getYDnnuFBc(j6));
    }

    /* renamed from: getDirection-DnnuFBc  reason: not valid java name */
    public static final long m36getDirectionDnnuFBc(long j5) {
        float r02 = m37getDistanceDnnuFBc(j5);
        if (r02 > 0.0f) {
            return m33divso9K2fw(j5, r02);
        }
        throw new IllegalArgumentException("Can't get the direction of a 0-length vector");
    }

    /* renamed from: getDistance-DnnuFBc  reason: not valid java name */
    public static final float m37getDistanceDnnuFBc(long j5) {
        return (float) Math.sqrt((double) ((m39getXDnnuFBc(j5) * m39getXDnnuFBc(j5)) + (m40getYDnnuFBc(j5) * m40getYDnnuFBc(j5))));
    }

    /* renamed from: getDistanceSquared-DnnuFBc  reason: not valid java name */
    public static final float m38getDistanceSquaredDnnuFBc(long j5) {
        return (m39getXDnnuFBc(j5) * m39getXDnnuFBc(j5)) + (m40getYDnnuFBc(j5) * m40getYDnnuFBc(j5));
    }

    /* renamed from: getX-DnnuFBc  reason: not valid java name */
    public static final float m39getXDnnuFBc(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: getY-DnnuFBc  reason: not valid java name */
    public static final float m40getYDnnuFBc(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: interpolate-dLqxh1s  reason: not valid java name */
    public static final long m41interpolatedLqxh1s(long j5, long j6, float f5) {
        return FloatFloatPair.m3constructorimpl(Utils.interpolate(m39getXDnnuFBc(j5), m39getXDnnuFBc(j6), f5), Utils.interpolate(m40getYDnnuFBc(j5), m40getYDnnuFBc(j6), f5));
    }

    /* renamed from: minus-ybeJwSQ  reason: not valid java name */
    public static final long m42minusybeJwSQ(long j5, long j6) {
        return FloatFloatPair.m3constructorimpl(m39getXDnnuFBc(j5) - m39getXDnnuFBc(j6), m40getYDnnuFBc(j5) - m40getYDnnuFBc(j6));
    }

    /* renamed from: plus-ybeJwSQ  reason: not valid java name */
    public static final long m43plusybeJwSQ(long j5, long j6) {
        return FloatFloatPair.m3constructorimpl(m39getXDnnuFBc(j5) + m39getXDnnuFBc(j6), m40getYDnnuFBc(j5) + m40getYDnnuFBc(j6));
    }

    /* renamed from: rem-so9K2fw  reason: not valid java name */
    public static final long m44remso9K2fw(long j5, float f5) {
        return FloatFloatPair.m3constructorimpl(m39getXDnnuFBc(j5) % f5, m40getYDnnuFBc(j5) % f5);
    }

    /* renamed from: times-so9K2fw  reason: not valid java name */
    public static final long m45timesso9K2fw(long j5, float f5) {
        return FloatFloatPair.m3constructorimpl(m39getXDnnuFBc(j5) * f5, m40getYDnnuFBc(j5) * f5);
    }

    /* renamed from: transformed-so9K2fw  reason: not valid java name */
    public static final long m46transformedso9K2fw(long j5, PointTransformer pointTransformer) {
        t.e(pointTransformer, "f");
        long r22 = pointTransformer.m48transformXgqJiTY(m39getXDnnuFBc(j5), m40getYDnnuFBc(j5));
        return FloatFloatPair.m3constructorimpl(Float.intBitsToFloat((int) (r22 >> 32)), Float.intBitsToFloat((int) (r22 & 4294967295L)));
    }

    /* renamed from: unaryMinus-DnnuFBc  reason: not valid java name */
    public static final long m47unaryMinusDnnuFBc(long j5) {
        return FloatFloatPair.m3constructorimpl(-m39getXDnnuFBc(j5), -m40getYDnnuFBc(j5));
    }
}
