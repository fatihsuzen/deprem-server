package androidx.graphics.shapes;

import X2.C2250q;
import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.jvm.internal.C2633k;

final class RoundedCorner {
    private long center;
    private final float cornerRadius;
    private final float cosAngle;

    /* renamed from: d1  reason: collision with root package name */
    private final long f363d1;

    /* renamed from: d2  reason: collision with root package name */
    private final long f364d2;
    private final float expectedRoundCut;

    /* renamed from: p0  reason: collision with root package name */
    private final long f365p0;

    /* renamed from: p1  reason: collision with root package name */
    private final long f366p1;

    /* renamed from: p2  reason: collision with root package name */
    private final long f367p2;
    private final CornerRounding rounding;
    private final float sinAngle;
    private final float smoothing;

    public /* synthetic */ RoundedCorner(long j5, long j6, long j7, CornerRounding cornerRounding, C2633k kVar) {
        this(j5, j6, j7, cornerRounding);
    }

    private final float calculateActualSmoothingValue(float f5) {
        if (f5 > getExpectedCut()) {
            return this.smoothing;
        }
        float f6 = this.expectedRoundCut;
        if (f5 > f6) {
            return (this.smoothing * (f5 - f6)) / (getExpectedCut() - this.expectedRoundCut);
        }
        return 0.0f;
    }

    /* renamed from: computeFlankingCurve-oAJzIJU  reason: not valid java name */
    private final Cubic m49computeFlankingCurveoAJzIJU(float f5, float f6, long j5, long j6, long j7, long j8, long j9, float f7) {
        float f8 = f6;
        long j10 = j5;
        long j11 = j9;
        long j12 = j6;
        long r7 = PointKt.m36getDirectionDnnuFBc(PointKt.m42minusybeJwSQ(j12, j10));
        long r9 = PointKt.m43plusybeJwSQ(j10, PointKt.m45timesso9K2fw(PointKt.m45timesso9K2fw(r7, f5), ((float) 1) + f8));
        long j13 = j7;
        long r02 = PointKt.m41interpolatedLqxh1s(j13, PointKt.m33divso9K2fw(PointKt.m43plusybeJwSQ(j7, j8), 2.0f), f8);
        long r03 = PointKt.m43plusybeJwSQ(j11, PointKt.m45timesso9K2fw(Utils.directionVector(PointKt.m39getXDnnuFBc(r02) - PointKt.m39getXDnnuFBc(j11), PointKt.m40getYDnnuFBc(r02) - PointKt.m40getYDnnuFBc(j11)), f7));
        long j14 = r7;
        long j15 = r03;
        long j16 = j12;
        long j17 = j15;
        FloatFloatPair r12 = m50lineIntersectionCBFvKDc(j16, j14, j17, Utils.m62rotate90DnnuFBc(PointKt.m42minusybeJwSQ(r03, j11)));
        if (r12 != null) {
            j13 = r12.m11unboximpl();
        }
        return new Cubic(r9, PointKt.m33divso9K2fw(PointKt.m43plusybeJwSQ(r9, PointKt.m45timesso9K2fw(j13, 2.0f)), 3.0f), j13, j17, (C2633k) null);
    }

    public static /* synthetic */ List getCubics$default(RoundedCorner roundedCorner, float f5, float f6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            f6 = f5;
        }
        return roundedCorner.getCubics(f5, f6);
    }

    /* renamed from: lineIntersection-CBFvKDc  reason: not valid java name */
    private final FloatFloatPair m50lineIntersectionCBFvKDc(long j5, long j6, long j7, long j8) {
        long r11 = Utils.m62rotate90DnnuFBc(j8);
        float r02 = PointKt.m35dotProductybeJwSQ(j6, r11);
        if (Math.abs(r02) < 1.0E-4f) {
            return null;
        }
        float r9 = PointKt.m35dotProductybeJwSQ(PointKt.m42minusybeJwSQ(j7, j5), r11);
        if (Math.abs(r02) < Math.abs(r9) * 1.0E-4f) {
            return null;
        }
        return FloatFloatPair.m0boximpl(PointKt.m43plusybeJwSQ(j5, PointKt.m45timesso9K2fw(j6, r9 / r02)));
    }

    /* renamed from: getCenter-1ufDz9w  reason: not valid java name */
    public final long m51getCenter1ufDz9w() {
        return this.center;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getCosAngle() {
        return this.cosAngle;
    }

    public final List<Cubic> getCubics(float f5) {
        return getCubics$default(this, f5, 0.0f, 2, (Object) null);
    }

    /* renamed from: getD1-1ufDz9w  reason: not valid java name */
    public final long m52getD11ufDz9w() {
        return this.f363d1;
    }

    /* renamed from: getD2-1ufDz9w  reason: not valid java name */
    public final long m53getD21ufDz9w() {
        return this.f364d2;
    }

    public final float getExpectedCut() {
        return (((float) 1) + this.smoothing) * this.expectedRoundCut;
    }

    public final float getExpectedRoundCut() {
        return this.expectedRoundCut;
    }

    /* renamed from: getP0-1ufDz9w  reason: not valid java name */
    public final long m54getP01ufDz9w() {
        return this.f365p0;
    }

    /* renamed from: getP1-1ufDz9w  reason: not valid java name */
    public final long m55getP11ufDz9w() {
        return this.f366p1;
    }

    /* renamed from: getP2-1ufDz9w  reason: not valid java name */
    public final long m56getP21ufDz9w() {
        return this.f367p2;
    }

    public final CornerRounding getRounding() {
        return this.rounding;
    }

    public final float getSinAngle() {
        return this.sinAngle;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    /* renamed from: setCenter-DnnuFBc  reason: not valid java name */
    public final void m57setCenterDnnuFBc(long j5) {
        this.center = j5;
    }

    private RoundedCorner(long j5, long j6, long j7, CornerRounding cornerRounding) {
        this.f365p0 = j5;
        this.f366p1 = j6;
        this.f367p2 = j7;
        this.rounding = cornerRounding;
        long r5 = PointKt.m36getDirectionDnnuFBc(PointKt.m42minusybeJwSQ(j5, j6));
        this.f363d1 = r5;
        long r7 = PointKt.m36getDirectionDnnuFBc(PointKt.m42minusybeJwSQ(j7, j6));
        this.f364d2 = r7;
        float radius = cornerRounding != null ? cornerRounding.getRadius() : 0.0f;
        this.cornerRadius = radius;
        this.smoothing = cornerRounding != null ? cornerRounding.getSmoothing() : 0.0f;
        float r52 = PointKt.m35dotProductybeJwSQ(r5, r7);
        this.cosAngle = r52;
        float f5 = (float) 1;
        float sqrt = (float) Math.sqrt((double) (f5 - Utils.square(r52)));
        this.sinAngle = sqrt;
        this.expectedRoundCut = ((double) sqrt) > 0.001d ? (radius * (r52 + f5)) / sqrt : 0.0f;
        this.center = FloatFloatPair.m3constructorimpl(0.0f, 0.0f);
    }

    public final List<Cubic> getCubics(float f5, float f6) {
        float min = Math.min(f5, f6);
        float f7 = this.expectedRoundCut;
        if (f7 < 1.0E-4f || min < 1.0E-4f || this.cornerRadius < 1.0E-4f) {
            long j5 = this.f366p1;
            this.center = j5;
            return C2250q.d(Cubic.Companion.straightLine(PointKt.m39getXDnnuFBc(j5), PointKt.m40getYDnnuFBc(this.f366p1), PointKt.m39getXDnnuFBc(this.f366p1), PointKt.m40getYDnnuFBc(this.f366p1)));
        }
        float min2 = Math.min(min, f7);
        float calculateActualSmoothingValue = calculateActualSmoothingValue(f5);
        float calculateActualSmoothingValue2 = calculateActualSmoothingValue(f6);
        float f8 = (this.cornerRadius * min2) / this.expectedRoundCut;
        this.center = PointKt.m43plusybeJwSQ(this.f366p1, PointKt.m45timesso9K2fw(PointKt.m36getDirectionDnnuFBc(PointKt.m33divso9K2fw(PointKt.m43plusybeJwSQ(this.f363d1, this.f364d2), 2.0f)), (float) Math.sqrt((double) (Utils.square(f8) + Utils.square(min2)))));
        long r7 = PointKt.m43plusybeJwSQ(this.f366p1, PointKt.m45timesso9K2fw(this.f363d1, min2));
        long r9 = PointKt.m43plusybeJwSQ(this.f366p1, PointKt.m45timesso9K2fw(this.f364d2, min2));
        Cubic r15 = m49computeFlankingCurveoAJzIJU(min2, calculateActualSmoothingValue, this.f366p1, this.f365p0, r7, r9, this.center, f8);
        long j6 = r9;
        long j7 = r7;
        float f9 = calculateActualSmoothingValue2;
        Cubic reverse = m49computeFlankingCurveoAJzIJU(min2, f9, this.f366p1, this.f367p2, j6, j7, this.center, f8).reverse();
        return C2250q.j(r15, Cubic.Companion.circularArc(PointKt.m39getXDnnuFBc(this.center), PointKt.m40getYDnnuFBc(this.center), r15.getAnchor1X(), r15.getAnchor1Y(), reverse.getAnchor0X(), reverse.getAnchor0Y()), reverse);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoundedCorner(long j5, long j6, long j7, CornerRounding cornerRounding, int i5, C2633k kVar) {
        this(j5, j6, j7, (i5 & 8) != 0 ? null : cornerRounding, (C2633k) null);
    }
}
