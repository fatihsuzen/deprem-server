package androidx.graphics.shapes;

import X2.C2250q;
import androidx.collection.FloatFloatPair;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class RoundedPolygon {
    public static final Companion Companion = new Companion((C2633k) null);
    private final float centerX;
    private final float centerY;
    private final List<Cubic> cubics;
    private final List<Feature> features;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ef A[LOOP:0: B:9:0x0092->B:31:0x00ef, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a2 A[EDGE_INSN: B:47:0x00a2->B:15:0x00a2 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RoundedPolygon(java.util.List<? extends androidx.graphics.shapes.Feature> r18, float r19, float r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "features"
            kotlin.jvm.internal.t.e(r1, r2)
            r0.<init>()
            r0.features = r1
            r2 = r19
            r0.centerX = r2
            r2 = r20
            r0.centerY = r2
            java.util.List r2 = X2.C2250q.c()
            int r3 = r1.size()
            r4 = 1
            r5 = 0
            r6 = 0
            if (r3 <= 0) goto L_0x0088
            java.lang.Object r3 = r1.get(r5)
            androidx.graphics.shapes.Feature r3 = (androidx.graphics.shapes.Feature) r3
            java.util.List r3 = r3.getCubics()
            int r3 = r3.size()
            r7 = 3
            if (r3 != r7) goto L_0x0088
            java.lang.Object r3 = r1.get(r5)
            androidx.graphics.shapes.Feature r3 = (androidx.graphics.shapes.Feature) r3
            java.util.List r3 = r3.getCubics()
            java.lang.Object r3 = r3.get(r4)
            androidx.graphics.shapes.Cubic r3 = (androidx.graphics.shapes.Cubic) r3
            r7 = 1056964608(0x3f000000, float:0.5)
            W2.s r3 = r3.split(r7)
            java.lang.Object r7 = r3.a()
            androidx.graphics.shapes.Cubic r7 = (androidx.graphics.shapes.Cubic) r7
            java.lang.Object r3 = r3.b()
            androidx.graphics.shapes.Cubic r3 = (androidx.graphics.shapes.Cubic) r3
            r8 = 2
            androidx.graphics.shapes.Cubic[] r9 = new androidx.graphics.shapes.Cubic[r8]
            java.lang.Object r10 = r1.get(r5)
            androidx.graphics.shapes.Feature r10 = (androidx.graphics.shapes.Feature) r10
            java.util.List r10 = r10.getCubics()
            java.lang.Object r10 = r10.get(r5)
            r9[r5] = r10
            r9[r4] = r7
            java.util.List r7 = X2.C2250q.l(r9)
            androidx.graphics.shapes.Cubic[] r9 = new androidx.graphics.shapes.Cubic[r8]
            r9[r5] = r3
            java.lang.Object r3 = r1.get(r5)
            androidx.graphics.shapes.Feature r3 = (androidx.graphics.shapes.Feature) r3
            java.util.List r3 = r3.getCubics()
            java.lang.Object r3 = r3.get(r8)
            r9[r4] = r3
            java.util.List r3 = X2.C2250q.l(r9)
            goto L_0x008a
        L_0x0088:
            r3 = r6
            r7 = r3
        L_0x008a:
            int r1 = r1.size()
            if (r1 < 0) goto L_0x00f2
            r9 = r5
            r8 = r6
        L_0x0092:
            if (r9 != 0) goto L_0x0098
            if (r3 == 0) goto L_0x0098
            r10 = r3
            goto L_0x00b3
        L_0x0098:
            java.util.List<androidx.graphics.shapes.Feature> r10 = r0.features
            int r10 = r10.size()
            if (r9 != r10) goto L_0x00a7
            if (r7 != 0) goto L_0x00a5
        L_0x00a2:
            r1 = r6
            r6 = r8
            goto L_0x00f3
        L_0x00a5:
            r10 = r7
            goto L_0x00b3
        L_0x00a7:
            java.util.List<androidx.graphics.shapes.Feature> r10 = r0.features
            java.lang.Object r10 = r10.get(r9)
            androidx.graphics.shapes.Feature r10 = (androidx.graphics.shapes.Feature) r10
            java.util.List r10 = r10.getCubics()
        L_0x00b3:
            int r11 = r10.size()
            r12 = r5
        L_0x00b8:
            if (r12 >= r11) goto L_0x00ed
            java.lang.Object r13 = r10.get(r12)
            androidx.graphics.shapes.Cubic r13 = (androidx.graphics.shapes.Cubic) r13
            boolean r14 = r13.zeroLength$graphics_shapes_release()
            if (r14 != 0) goto L_0x00d2
            if (r8 == 0) goto L_0x00cb
            r2.add(r8)
        L_0x00cb:
            if (r6 != 0) goto L_0x00d0
            r6 = r13
            r8 = r6
            goto L_0x00ea
        L_0x00d0:
            r8 = r13
            goto L_0x00ea
        L_0x00d2:
            if (r8 == 0) goto L_0x00ea
            float[] r14 = r8.getPoints$graphics_shapes_release()
            r15 = 6
            float r16 = r13.getAnchor1X()
            r14[r15] = r16
            float[] r14 = r8.getPoints$graphics_shapes_release()
            r15 = 7
            float r13 = r13.getAnchor1Y()
            r14[r15] = r13
        L_0x00ea:
            int r12 = r12 + 1
            goto L_0x00b8
        L_0x00ed:
            if (r9 == r1) goto L_0x00a2
            int r9 = r9 + 1
            goto L_0x0092
        L_0x00f2:
            r1 = r6
        L_0x00f3:
            if (r6 == 0) goto L_0x011e
            if (r1 == 0) goto L_0x011e
            float r7 = r6.getAnchor0X()
            float r8 = r6.getAnchor0Y()
            float r9 = r6.getControl0X()
            float r10 = r6.getControl0Y()
            float r11 = r6.getControl1X()
            float r12 = r6.getControl1Y()
            float r13 = r1.getAnchor0X()
            float r14 = r1.getAnchor0Y()
            androidx.graphics.shapes.Cubic r1 = androidx.graphics.shapes.CubicKt.Cubic(r7, r8, r9, r10, r11, r12, r13, r14)
            r2.add(r1)
        L_0x011e:
            java.util.List r1 = X2.C2250q.a(r2)
            r0.cubics = r1
            int r2 = r1.size()
            int r2 = r2 - r4
            java.lang.Object r2 = r1.get(r2)
            int r1 = r1.size()
        L_0x0131:
            if (r5 >= r1) goto L_0x016e
            java.util.List<androidx.graphics.shapes.Cubic> r3 = r0.cubics
            java.lang.Object r3 = r3.get(r5)
            androidx.graphics.shapes.Cubic r3 = (androidx.graphics.shapes.Cubic) r3
            float r4 = r3.getAnchor0X()
            androidx.graphics.shapes.Cubic r2 = (androidx.graphics.shapes.Cubic) r2
            float r6 = r2.getAnchor1X()
            float r4 = r4 - r6
            float r4 = java.lang.Math.abs(r4)
            r6 = 953267991(0x38d1b717, float:1.0E-4)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 > 0) goto L_0x0166
            float r4 = r3.getAnchor0Y()
            float r2 = r2.getAnchor1Y()
            float r4 = r4 - r2
            float r2 = java.lang.Math.abs(r4)
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x0166
            int r5 = r5 + 1
            r2 = r3
            goto L_0x0131
        L_0x0166:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "RoundedPolygon must be contiguous, with the anchor points of all curves matching the anchor points of the preceding and succeeding cubics"
            r1.<init>(r2)
            throw r1
        L_0x016e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.graphics.shapes.RoundedPolygon.<init>(java.util.List, float, float):void");
    }

    public static /* synthetic */ float[] calculateBounds$default(RoundedPolygon roundedPolygon, float[] fArr, boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i5 & 2) != 0) {
            z4 = true;
        }
        return roundedPolygon.calculateBounds(fArr, z4);
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(RoundedPolygon roundedPolygon, float[] fArr, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            fArr = new float[4];
        }
        return roundedPolygon.calculateMaxBounds(fArr);
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, (float[]) null, false, 3, (Object) null);
    }

    public final float[] calculateMaxBounds(float[] fArr) {
        t.e(fArr, "bounds");
        if (fArr.length >= 4) {
            int size = this.cubics.size();
            float f5 = 0.0f;
            for (int i5 = 0; i5 < size; i5++) {
                Cubic cubic = this.cubics.get(i5);
                float distanceSquared = Utils.distanceSquared(cubic.getAnchor0X() - this.centerX, cubic.getAnchor0Y() - this.centerY);
                long r6 = cubic.m27pointOnCurveOOQOV4g$graphics_shapes_release(0.5f);
                f5 = Math.max(f5, Math.max(distanceSquared, Utils.distanceSquared(PointKt.m39getXDnnuFBc(r6) - this.centerX, PointKt.m40getYDnnuFBc(r6) - this.centerY)));
            }
            float sqrt = (float) Math.sqrt((double) f5);
            float f6 = this.centerX;
            fArr[0] = f6 - sqrt;
            float f7 = this.centerY;
            fArr[1] = f7 - sqrt;
            fArr[2] = f6 + sqrt;
            fArr[3] = f7 + sqrt;
            return fArr;
        }
        throw new IllegalArgumentException("Required bounds size of 4");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundedPolygon)) {
            return false;
        }
        return t.a(this.features, ((RoundedPolygon) obj).features);
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public final List<Feature> getFeatures$graphics_shapes_release() {
        return this.features;
    }

    public int hashCode() {
        return this.features.hashCode();
    }

    public final RoundedPolygon normalized() {
        float[] calculateBounds$default = calculateBounds$default(this, (float[]) null, false, 3, (Object) null);
        float f5 = calculateBounds$default[2] - calculateBounds$default[0];
        float f6 = calculateBounds$default[3] - calculateBounds$default[1];
        float max = Math.max(f5, f6);
        float f7 = (float) 2;
        return transformed(new RoundedPolygon$normalized$1(((max - f5) / f7) - calculateBounds$default[0], max, ((max - f6) / f7) - calculateBounds$default[1]));
    }

    public String toString() {
        return "[RoundedPolygon. Cubics = " + C2250q.V(this.cubics, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 63, (Object) null) + " || Features = " + C2250q.V(this.features, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 63, (Object) null) + " || Center = (" + this.centerX + ", " + this.centerY + ")]";
    }

    public final RoundedPolygon transformed(PointTransformer pointTransformer) {
        t.e(pointTransformer, "f");
        long r02 = PointKt.m46transformedso9K2fw(FloatFloatPair.m3constructorimpl(this.centerX, this.centerY), pointTransformer);
        List c5 = C2250q.c();
        int size = this.features.size();
        for (int i5 = 0; i5 < size; i5++) {
            c5.add(this.features.get(i5).transformed$graphics_shapes_release(pointTransformer));
        }
        return new RoundedPolygon(C2250q.a(c5), PointKt.m39getXDnnuFBc(r02), PointKt.m40getYDnnuFBc(r02));
    }

    public final float[] calculateBounds(float[] fArr) {
        t.e(fArr, "bounds");
        return calculateBounds$default(this, fArr, false, 2, (Object) null);
    }

    public final float[] calculateBounds(float[] fArr, boolean z4) {
        t.e(fArr, "bounds");
        if (fArr.length >= 4) {
            int size = this.cubics.size();
            float f5 = Float.MIN_VALUE;
            float f6 = Float.MAX_VALUE;
            float f7 = Float.MAX_VALUE;
            float f8 = Float.MIN_VALUE;
            for (int i5 = 0; i5 < size; i5++) {
                this.cubics.get(i5).calculateBounds$graphics_shapes_release(fArr, z4);
                f6 = Math.min(f6, fArr[0]);
                f7 = Math.min(f7, fArr[1]);
                f5 = Math.max(f5, fArr[2]);
                f8 = Math.max(f8, fArr[3]);
            }
            fArr[0] = f6;
            fArr[1] = f7;
            fArr[2] = f5;
            fArr[3] = f8;
            return fArr;
        }
        throw new IllegalArgumentException("Required bounds size of 4");
    }
}
