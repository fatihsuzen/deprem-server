package androidx.graphics.shapes;

import W2.s;
import W2.y;
import X2.C2242i;
import androidx.collection.FloatFloatPair;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public class Cubic {
    public static final Companion Companion = new Companion((C2633k) null);
    private final float[] points;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final Cubic circularArc(float f5, float f6, float f7, float f8, float f9, float f10) {
            boolean z4;
            float f11;
            float f12 = f7;
            float f13 = f8;
            float f14 = f9;
            float f15 = f10;
            float f16 = f12 - f5;
            float f17 = f13 - f6;
            long directionVector = Utils.directionVector(f16, f17);
            float f18 = f14 - f5;
            float f19 = f15 - f6;
            long directionVector2 = Utils.directionVector(f18, f19);
            long r12 = Utils.m62rotate90DnnuFBc(directionVector);
            long r14 = Utils.m62rotate90DnnuFBc(directionVector2);
            if (PointKt.m34dotProduct5P9i7ZU(r12, f18, f19) >= 0.0f) {
                z4 = true;
            } else {
                z4 = false;
            }
            float r42 = PointKt.m35dotProductybeJwSQ(directionVector, directionVector2);
            if (r42 > 0.999f) {
                return straightLine(f12, f13, f14, f15);
            }
            float f20 = (float) 1;
            float f21 = f20 - r42;
            float distance = (((Utils.distance(f16, f17) * 4.0f) / 3.0f) * (((float) Math.sqrt((double) (((float) 2) * f21))) - ((float) Math.sqrt((double) (f20 - (r42 * r42)))))) / f21;
            if (z4) {
                f11 = 1.0f;
            } else {
                f11 = -1.0f;
            }
            float f22 = distance * f11;
            return CubicKt.Cubic(f7, f8, f7 + (PointKt.m39getXDnnuFBc(r12) * f22), f8 + (PointKt.m40getYDnnuFBc(r12) * f22), f14 - (PointKt.m39getXDnnuFBc(r14) * f22), f15 - (PointKt.m40getYDnnuFBc(r14) * f22), f14, f15);
        }

        public final Cubic straightLine(float f5, float f6, float f7, float f8) {
            return CubicKt.Cubic(f5, f6, Utils.interpolate(f5, f7, 0.33333334f), Utils.interpolate(f6, f8, 0.33333334f), Utils.interpolate(f5, f7, 0.6666667f), Utils.interpolate(f6, f8, 0.6666667f), f7, f8);
        }

        private Companion() {
        }
    }

    public Cubic() {
        this((float[]) null, 1, (C2633k) null);
    }

    public static /* synthetic */ void calculateBounds$graphics_shapes_release$default(Cubic cubic, float[] fArr, boolean z4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                fArr = new float[4];
            }
            if ((i5 & 2) != 0) {
                z4 = false;
            }
            cubic.calculateBounds$graphics_shapes_release(fArr, z4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateBounds");
    }

    public static final Cubic circularArc(float f5, float f6, float f7, float f8, float f9, float f10) {
        return Companion.circularArc(f5, f6, f7, f8, f9, f10);
    }

    public static final Cubic straightLine(float f5, float f6, float f7, float f8) {
        return Companion.straightLine(f5, f6, f7, f8);
    }

    private final boolean zeroIsh(float f5) {
        if (Math.abs(f5) < 1.0E-4f) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01c7, code lost:
        if (r3 > r9) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0218, code lost:
        if (r3 > r9) goto L_0x01c9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void calculateBounds$graphics_shapes_release(float[] r23, boolean r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            java.lang.String r2 = "bounds"
            kotlin.jvm.internal.t.e(r1, r2)
            boolean r2 = r0.zeroLength$graphics_shapes_release()
            r3 = 1
            r4 = 0
            r5 = 3
            r6 = 2
            if (r2 == 0) goto L_0x002c
            float r2 = r0.getAnchor0X()
            r1[r4] = r2
            float r2 = r0.getAnchor0Y()
            r1[r3] = r2
            float r2 = r0.getAnchor0X()
            r1[r6] = r2
            float r2 = r0.getAnchor0Y()
            r1[r5] = r2
            return
        L_0x002c:
            float r2 = r0.getAnchor0X()
            float r7 = r0.getAnchor1X()
            float r2 = java.lang.Math.min(r2, r7)
            float r7 = r0.getAnchor0Y()
            float r8 = r0.getAnchor1Y()
            float r7 = java.lang.Math.min(r7, r8)
            float r8 = r0.getAnchor0X()
            float r9 = r0.getAnchor1X()
            float r8 = java.lang.Math.max(r8, r9)
            float r9 = r0.getAnchor0Y()
            float r10 = r0.getAnchor1Y()
            float r9 = java.lang.Math.max(r9, r10)
            if (r24 == 0) goto L_0x00a7
            float r10 = r0.getControl0X()
            float r11 = r0.getControl1X()
            float r10 = java.lang.Math.min(r10, r11)
            float r2 = java.lang.Math.min(r2, r10)
            r1[r4] = r2
            float r2 = r0.getControl0Y()
            float r4 = r0.getControl1Y()
            float r2 = java.lang.Math.min(r2, r4)
            float r2 = java.lang.Math.min(r7, r2)
            r1[r3] = r2
            float r2 = r0.getControl0X()
            float r3 = r0.getControl1X()
            float r2 = java.lang.Math.max(r2, r3)
            float r2 = java.lang.Math.max(r8, r2)
            r1[r6] = r2
            float r2 = r0.getControl0Y()
            float r3 = r0.getControl1Y()
            float r2 = java.lang.Math.max(r2, r3)
            float r2 = java.lang.Math.max(r9, r2)
            r1[r5] = r2
            return
        L_0x00a7:
            float r10 = r0.getAnchor0X()
            float r10 = -r10
            float r11 = (float) r5
            float r12 = r0.getControl0X()
            float r12 = r12 * r11
            float r10 = r10 + r12
            float r12 = r0.getControl1X()
            float r12 = r12 * r11
            float r10 = r10 - r12
            float r12 = r0.getAnchor1X()
            float r10 = r10 + r12
            float r12 = (float) r6
            float r13 = r0.getAnchor0X()
            float r13 = r13 * r12
            r14 = 4
            float r14 = (float) r14
            float r15 = r0.getControl0X()
            float r15 = r15 * r14
            float r13 = r13 - r15
            float r15 = r0.getControl1X()
            float r15 = r15 * r12
            float r13 = r13 + r15
            float r15 = r0.getAnchor0X()
            float r15 = -r15
            float r16 = r0.getControl0X()
            float r15 = r15 + r16
            boolean r16 = r0.zeroIsh(r10)
            r17 = r3
            r3 = -2
            r18 = 1065353216(0x3f800000, float:1.0)
            r19 = 0
            if (r16 == 0) goto L_0x0115
            int r10 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r10 != 0) goto L_0x00ef
            goto L_0x010d
        L_0x00ef:
            float r15 = r15 * r12
            float r10 = (float) r3
            float r10 = r10 * r13
            float r15 = r15 / r10
            int r10 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r10 > 0) goto L_0x010d
            int r10 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r10 > 0) goto L_0x010d
            long r15 = r0.m27pointOnCurveOOQOV4g$graphics_shapes_release(r15)
            float r10 = androidx.graphics.shapes.PointKt.m39getXDnnuFBc(r15)
            int r13 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r13 >= 0) goto L_0x0108
            r2 = r10
        L_0x0108:
            int r13 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r13 <= 0) goto L_0x010d
            r8 = r10
        L_0x010d:
            r20 = r4
            r16 = r5
            r21 = r6
            r15 = r7
            goto L_0x016d
        L_0x0115:
            float r16 = r13 * r13
            float r20 = r14 * r10
            float r20 = r20 * r15
            float r15 = r16 - r20
            int r16 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
            if (r16 < 0) goto L_0x010d
            float r13 = -r13
            r20 = r4
            r16 = r5
            double r4 = (double) r15
            r21 = r6
            r15 = r7
            double r6 = java.lang.Math.sqrt(r4)
            float r6 = (float) r6
            float r6 = r6 + r13
            float r10 = r10 * r12
            float r6 = r6 / r10
            int r7 = (r19 > r6 ? 1 : (r19 == r6 ? 0 : -1))
            if (r7 > 0) goto L_0x014c
            int r7 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1))
            if (r7 > 0) goto L_0x014c
            long r6 = r0.m27pointOnCurveOOQOV4g$graphics_shapes_release(r6)
            float r6 = androidx.graphics.shapes.PointKt.m39getXDnnuFBc(r6)
            int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0147
            r2 = r6
        L_0x0147:
            int r7 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x014c
            r8 = r6
        L_0x014c:
            double r4 = java.lang.Math.sqrt(r4)
            float r4 = (float) r4
            float r13 = r13 - r4
            float r13 = r13 / r10
            int r4 = (r19 > r13 ? 1 : (r19 == r13 ? 0 : -1))
            if (r4 > 0) goto L_0x016d
            int r4 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r4 > 0) goto L_0x016d
            long r4 = r0.m27pointOnCurveOOQOV4g$graphics_shapes_release(r13)
            float r4 = androidx.graphics.shapes.PointKt.m39getXDnnuFBc(r4)
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x0168
            r2 = r4
        L_0x0168:
            int r5 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x016d
            r8 = r4
        L_0x016d:
            float r4 = r0.getAnchor0Y()
            float r4 = -r4
            float r5 = r0.getControl0Y()
            float r5 = r5 * r11
            float r4 = r4 + r5
            float r5 = r0.getControl1Y()
            float r11 = r11 * r5
            float r4 = r4 - r11
            float r5 = r0.getAnchor1Y()
            float r4 = r4 + r5
            float r5 = r0.getAnchor0Y()
            float r5 = r5 * r12
            float r6 = r0.getControl0Y()
            float r6 = r6 * r14
            float r5 = r5 - r6
            float r6 = r0.getControl1Y()
            float r6 = r6 * r12
            float r5 = r5 + r6
            float r6 = r0.getAnchor0Y()
            float r6 = -r6
            float r7 = r0.getControl0Y()
            float r6 = r6 + r7
            boolean r7 = r0.zeroIsh(r4)
            if (r7 == 0) goto L_0x01cb
            int r4 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r4 != 0) goto L_0x01aa
            goto L_0x021b
        L_0x01aa:
            float r12 = r12 * r6
            float r3 = (float) r3
            float r3 = r3 * r5
            float r12 = r12 / r3
            int r3 = (r19 > r12 ? 1 : (r19 == r12 ? 0 : -1))
            if (r3 > 0) goto L_0x021b
            int r3 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r3 > 0) goto L_0x021b
            long r3 = r0.m27pointOnCurveOOQOV4g$graphics_shapes_release(r12)
            float r3 = androidx.graphics.shapes.PointKt.m40getYDnnuFBc(r3)
            int r4 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r4 >= 0) goto L_0x01c4
            r7 = r3
            goto L_0x01c5
        L_0x01c4:
            r7 = r15
        L_0x01c5:
            int r4 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x021c
        L_0x01c9:
            r9 = r3
            goto L_0x021c
        L_0x01cb:
            float r3 = r5 * r5
            float r14 = r14 * r4
            float r14 = r14 * r6
            float r3 = r3 - r14
            int r6 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r6 < 0) goto L_0x021b
            float r5 = -r5
            double r6 = (double) r3
            double r10 = java.lang.Math.sqrt(r6)
            float r3 = (float) r10
            float r3 = r3 + r5
            float r12 = r12 * r4
            float r3 = r3 / r12
            int r4 = (r19 > r3 ? 1 : (r19 == r3 ? 0 : -1))
            if (r4 > 0) goto L_0x01f8
            int r4 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r4 > 0) goto L_0x01f8
            long r3 = r0.m27pointOnCurveOOQOV4g$graphics_shapes_release(r3)
            float r3 = androidx.graphics.shapes.PointKt.m40getYDnnuFBc(r3)
            int r4 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r4 >= 0) goto L_0x01f3
            r15 = r3
        L_0x01f3:
            int r4 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x01f8
            r9 = r3
        L_0x01f8:
            double r3 = java.lang.Math.sqrt(r6)
            float r3 = (float) r3
            float r5 = r5 - r3
            float r5 = r5 / r12
            int r3 = (r19 > r5 ? 1 : (r19 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x021b
            int r3 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r3 > 0) goto L_0x021b
            long r3 = r0.m27pointOnCurveOOQOV4g$graphics_shapes_release(r5)
            float r3 = androidx.graphics.shapes.PointKt.m40getYDnnuFBc(r3)
            int r4 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r4 >= 0) goto L_0x0215
            r7 = r3
            goto L_0x0216
        L_0x0215:
            r7 = r15
        L_0x0216:
            int r4 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x021c
            goto L_0x01c9
        L_0x021b:
            r7 = r15
        L_0x021c:
            r1[r20] = r2
            r1[r17] = r7
            r1[r21] = r8
            r1[r16] = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.graphics.shapes.Cubic.calculateBounds$graphics_shapes_release(float[], boolean):void");
    }

    public final Cubic div(float f5) {
        return times(1.0f / f5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cubic)) {
            return false;
        }
        return Arrays.equals(this.points, ((Cubic) obj).points);
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    public final float[] getPoints$graphics_shapes_release() {
        return this.points;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    public final Cubic plus(Cubic cubic) {
        t.e(cubic, "o");
        float[] fArr = new float[8];
        for (int i5 = 0; i5 < 8; i5++) {
            fArr[i5] = this.points[i5] + cubic.points[i5];
        }
        return new Cubic(fArr);
    }

    /* renamed from: pointOnCurve-OOQOV4g$graphics_shapes_release  reason: not valid java name */
    public final long m27pointOnCurveOOQOV4g$graphics_shapes_release(float f5) {
        float f6 = ((float) 1) - f5;
        float f7 = f6 * f6 * f6;
        float f8 = ((float) 3) * f5;
        float f9 = f8 * f6 * f6;
        float f10 = f8 * f5 * f6;
        float f11 = f5 * f5 * f5;
        return FloatFloatPair.m3constructorimpl((getAnchor0X() * f7) + (getControl0X() * f9) + (getControl1X() * f10) + (getAnchor1X() * f11), (getAnchor0Y() * f7) + (getControl0Y() * f9) + (getControl1Y() * f10) + (getAnchor1Y() * f11));
    }

    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    public final s split(float f5) {
        float f6 = ((float) 1) - f5;
        long r12 = m27pointOnCurveOOQOV4g$graphics_shapes_release(f5);
        float f7 = f6 * f6;
        float f8 = ((float) 2) * f6 * f5;
        float f9 = f5 * f5;
        return y.a(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f6) + (getControl0X() * f5), (getAnchor0Y() * f6) + (getControl0Y() * f5), (getAnchor0X() * f7) + (getControl0X() * f8) + (getControl1X() * f9), (getAnchor0Y() * f7) + (getControl0Y() * f8) + (getControl1Y() * f9), PointKt.m39getXDnnuFBc(r12), PointKt.m40getYDnnuFBc(r12)), CubicKt.Cubic(PointKt.m39getXDnnuFBc(r12), PointKt.m40getYDnnuFBc(r12), (getControl0X() * f7) + (getControl1X() * f8) + (getAnchor1X() * f9), (getControl0Y() * f7) + (getControl1Y() * f8) + (getAnchor1Y() * f9), (getControl1X() * f6) + (getAnchor1X() * f5), (getControl1Y() * f6) + (getAnchor1Y() * f5), getAnchor1X(), getAnchor1Y()));
    }

    public final Cubic times(float f5) {
        float[] fArr = new float[8];
        for (int i5 = 0; i5 < 8; i5++) {
            fArr[i5] = this.points[i5] * f5;
        }
        return new Cubic(fArr);
    }

    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    public final Cubic transformed(PointTransformer pointTransformer) {
        t.e(pointTransformer, "f");
        MutableCubic mutableCubic = new MutableCubic();
        C2242i.n(this.points, mutableCubic.getPoints$graphics_shapes_release(), 0, 0, 0, 14, (Object) null);
        mutableCubic.transform(pointTransformer);
        return mutableCubic;
    }

    public final boolean zeroLength$graphics_shapes_release() {
        if (Math.abs(getAnchor0X() - getAnchor1X()) >= 1.0E-4f || Math.abs(getAnchor0Y() - getAnchor1Y()) >= 1.0E-4f) {
            return false;
        }
        return true;
    }

    public /* synthetic */ Cubic(long j5, long j6, long j7, long j8, C2633k kVar) {
        this(j5, j6, j7, j8);
    }

    public final Cubic div(int i5) {
        return div((float) i5);
    }

    public final Cubic times(int i5) {
        return times((float) i5);
    }

    public Cubic(float[] fArr) {
        t.e(fArr, "points");
        this.points = fArr;
        if (fArr.length != 8) {
            throw new IllegalArgumentException("Points array size should be 8");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cubic(float[] fArr, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? new float[8] : fArr);
    }

    private Cubic(long j5, long j6, long j7, long j8) {
        this(new float[]{PointKt.m39getXDnnuFBc(j5), PointKt.m40getYDnnuFBc(j5), PointKt.m39getXDnnuFBc(j6), PointKt.m40getYDnnuFBc(j6), PointKt.m39getXDnnuFBc(j7), PointKt.m40getYDnnuFBc(j7), PointKt.m39getXDnnuFBc(j8), PointKt.m40getYDnnuFBc(j8)});
    }
}
