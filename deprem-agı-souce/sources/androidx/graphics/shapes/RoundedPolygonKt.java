package androidx.graphics.shapes;

import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.jvm.internal.t;

public final class RoundedPolygonKt {
    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i5) {
        return RoundedPolygon$default(i5, 0.0f, 0.0f, 0.0f, (CornerRounding) null, (List) null, 62, (Object) null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(int i5, float f5, float f6, float f7, CornerRounding cornerRounding, List list, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            f5 = 1.0f;
        }
        if ((i6 & 4) != 0) {
            f6 = 0.0f;
        }
        if ((i6 & 8) != 0) {
            f7 = 0.0f;
        }
        if ((i6 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i6 & 32) != 0) {
            list = null;
        }
        return RoundedPolygon(i5, f5, f6, f7, cornerRounding, list);
    }

    private static final long calculateCenter(float[] fArr) {
        float f5 = 0.0f;
        int i5 = 0;
        float f6 = 0.0f;
        while (i5 < fArr.length) {
            int i6 = i5 + 1;
            f5 += fArr[i5];
            i5 += 2;
            f6 += fArr[i6];
        }
        float f7 = (float) 2;
        return FloatFloatPair.m3constructorimpl((f5 / ((float) fArr.length)) / f7, (f6 / ((float) fArr.length)) / f7);
    }

    private static final float[] verticesFromNumVerts(int i5, float f5, float f6, float f7) {
        float[] fArr = new float[(i5 * 2)];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            float f8 = f5;
            long r7 = PointKt.m43plusybeJwSQ(Utils.m61radialToCartesianL6JJ3z0$default(f8, (Utils.getFloatPi() / ((float) i5)) * ((float) 2) * ((float) i6), 0, 4, (Object) null), FloatFloatPair.m3constructorimpl(f6, f7));
            int i8 = i7 + 1;
            fArr[i7] = PointKt.m39getXDnnuFBc(r7);
            i7 += 2;
            fArr[i8] = PointKt.m40getYDnnuFBc(r7);
            i6++;
            f5 = f8;
        }
        return fArr;
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i5, float f5) {
        return RoundedPolygon$default(i5, f5, 0.0f, 0.0f, (CornerRounding) null, (List) null, 60, (Object) null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i5, float f5, float f6) {
        return RoundedPolygon$default(i5, f5, f6, 0.0f, (CornerRounding) null, (List) null, 56, (Object) null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(float[] fArr, CornerRounding cornerRounding, List list, float f5, float f6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i5 & 4) != 0) {
            list = null;
        }
        if ((i5 & 8) != 0) {
            f5 = Float.MIN_VALUE;
        }
        if ((i5 & 16) != 0) {
            f6 = Float.MIN_VALUE;
        }
        return RoundedPolygon(fArr, cornerRounding, (List<CornerRounding>) list, f5, f6);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i5, float f5, float f6, float f7) {
        return RoundedPolygon$default(i5, f5, f6, f7, (CornerRounding) null, (List) null, 48, (Object) null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i5, float f5, float f6, float f7, CornerRounding cornerRounding) {
        t.e(cornerRounding, "rounding");
        return RoundedPolygon$default(i5, f5, f6, f7, cornerRounding, (List) null, 32, (Object) null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr) {
        t.e(fArr, "vertices");
        return RoundedPolygon$default(fArr, (CornerRounding) null, (List) null, 0.0f, 0.0f, 30, (Object) null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding cornerRounding) {
        t.e(fArr, "vertices");
        t.e(cornerRounding, "rounding");
        return RoundedPolygon$default(fArr, cornerRounding, (List) null, 0.0f, 0.0f, 28, (Object) null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding cornerRounding, List<CornerRounding> list) {
        t.e(fArr, "vertices");
        t.e(cornerRounding, "rounding");
        return RoundedPolygon$default(fArr, cornerRounding, list, 0.0f, 0.0f, 24, (Object) null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding cornerRounding, List<CornerRounding> list, float f5) {
        t.e(fArr, "vertices");
        t.e(cornerRounding, "rounding");
        return RoundedPolygon$default(fArr, cornerRounding, list, f5, 0.0f, 16, (Object) null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i5, float f5, float f6, float f7, CornerRounding cornerRounding, List<CornerRounding> list) {
        t.e(cornerRounding, "rounding");
        return RoundedPolygon(verticesFromNumVerts(i5, f5, f6, f7), cornerRounding, list, f6, f7);
    }

    public static final RoundedPolygon RoundedPolygon(RoundedPolygon roundedPolygon) {
        t.e(roundedPolygon, "source");
        return new RoundedPolygon(roundedPolygon.getFeatures$graphics_shapes_release(), roundedPolygon.getCenterX(), roundedPolygon.getCenterY());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r11 = r1.get(r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.graphics.shapes.RoundedPolygon RoundedPolygon(float[] r23, androidx.graphics.shapes.CornerRounding r24, java.util.List<androidx.graphics.shapes.CornerRounding> r25, float r26, float r27) {
        /*
            r0 = r23
            r1 = r25
            r2 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.String r3 = "vertices"
            kotlin.jvm.internal.t.e(r0, r3)
            java.lang.String r3 = "rounding"
            r4 = r24
            kotlin.jvm.internal.t.e(r4, r3)
            int r3 = r0.length
            r5 = 6
            if (r3 < r5) goto L_0x0272
            int r3 = r0.length
            r5 = 2
            int r3 = r3 % r5
            r6 = 1
            if (r3 == r6) goto L_0x026a
            if (r1 == 0) goto L_0x0033
            int r3 = r1.size()
            int r3 = r3 * r5
            int r7 = r0.length
            if (r3 != r7) goto L_0x002b
            goto L_0x0033
        L_0x002b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)"
            r0.<init>(r1)
            throw r0
        L_0x0033:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r7 = r0.length
            int r7 = r7 / r5
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r9 = 0
            r10 = r9
        L_0x0041:
            if (r10 >= r7) goto L_0x008f
            if (r1 == 0) goto L_0x0051
            java.lang.Object r11 = r1.get(r10)
            androidx.graphics.shapes.CornerRounding r11 = (androidx.graphics.shapes.CornerRounding) r11
            if (r11 != 0) goto L_0x004e
            goto L_0x0051
        L_0x004e:
            r19 = r11
            goto L_0x0053
        L_0x0051:
            r19 = r4
        L_0x0053:
            int r11 = r10 + r7
            int r11 = r11 - r6
            int r11 = r11 % r7
            int r11 = r11 * r5
            int r21 = r10 + 1
            int r12 = r21 % r7
            int r12 = r12 * r5
            r13 = r12
            androidx.graphics.shapes.RoundedCorner r12 = new androidx.graphics.shapes.RoundedCorner
            r14 = r0[r11]
            int r11 = r11 + r6
            r11 = r0[r11]
            long r14 = androidx.collection.FloatFloatPair.m3constructorimpl(r14, r11)
            int r10 = r10 * 2
            r11 = r0[r10]
            int r10 = r10 + r6
            r10 = r0[r10]
            long r10 = androidx.collection.FloatFloatPair.m3constructorimpl(r11, r10)
            r22 = r6
            r6 = r0[r13]
            int r13 = r13 + 1
            r13 = r0[r13]
            long r17 = androidx.collection.FloatFloatPair.m3constructorimpl(r6, r13)
            r20 = 0
            r13 = r14
            r15 = r10
            r12.<init>(r13, r15, r17, r19, r20)
            r8.add(r12)
            r10 = r21
            r6 = r22
            goto L_0x0041
        L_0x008f:
            r22 = r6
            q3.d r1 = q3.C2729e.l(r9, r7)
            java.util.ArrayList r4 = new java.util.ArrayList
            r6 = 10
            int r6 = X2.C2250q.p(r1, r6)
            r4.<init>(r6)
            java.util.Iterator r1 = r1.iterator()
        L_0x00a4:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x011d
            r6 = r1
            X2.J r6 = (X2.J) r6
            int r6 = r6.nextInt()
            java.lang.Object r10 = r8.get(r6)
            androidx.graphics.shapes.RoundedCorner r10 = (androidx.graphics.shapes.RoundedCorner) r10
            float r10 = r10.getExpectedRoundCut()
            int r11 = r6 + 1
            int r11 = r11 % r7
            java.lang.Object r12 = r8.get(r11)
            androidx.graphics.shapes.RoundedCorner r12 = (androidx.graphics.shapes.RoundedCorner) r12
            float r12 = r12.getExpectedRoundCut()
            float r10 = r10 + r12
            java.lang.Object r12 = r8.get(r6)
            androidx.graphics.shapes.RoundedCorner r12 = (androidx.graphics.shapes.RoundedCorner) r12
            float r12 = r12.getExpectedCut()
            java.lang.Object r13 = r8.get(r11)
            androidx.graphics.shapes.RoundedCorner r13 = (androidx.graphics.shapes.RoundedCorner) r13
            float r13 = r13.getExpectedCut()
            float r12 = r12 + r13
            int r6 = r6 * r5
            r13 = r0[r6]
            int r6 = r6 + 1
            r6 = r0[r6]
            int r11 = r11 * r5
            r14 = r0[r11]
            int r11 = r11 + 1
            r11 = r0[r11]
            float r13 = r13 - r14
            float r6 = r6 - r11
            float r6 = androidx.graphics.shapes.Utils.distance(r13, r6)
            int r11 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x0105
            float r6 = r6 / r10
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r10 = 0
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            W2.s r6 = W2.y.a(r6, r10)
            goto L_0x0119
        L_0x0105:
            int r11 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x0115
            float r6 = r6 - r10
            float r12 = r12 - r10
            float r6 = r6 / r12
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            W2.s r6 = W2.y.a(r2, r6)
            goto L_0x0119
        L_0x0115:
            W2.s r6 = W2.y.a(r2, r2)
        L_0x0119:
            r4.add(r6)
            goto L_0x00a4
        L_0x011d:
            r1 = r9
        L_0x011e:
            if (r1 >= r7) goto L_0x018a
            androidx.collection.MutableFloatList r2 = new androidx.collection.MutableFloatList
            r2.<init>(r5)
            r6 = r9
        L_0x0126:
            if (r6 >= r5) goto L_0x0170
            int r10 = r1 + r7
            int r10 = r10 + -1
            int r10 = r10 + r6
            int r10 = r10 % r7
            java.lang.Object r10 = r4.get(r10)
            W2.s r10 = (W2.s) r10
            java.lang.Object r11 = r10.a()
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            java.lang.Object r10 = r10.b()
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            java.lang.Object r12 = r8.get(r1)
            androidx.graphics.shapes.RoundedCorner r12 = (androidx.graphics.shapes.RoundedCorner) r12
            float r12 = r12.getExpectedRoundCut()
            float r12 = r12 * r11
            java.lang.Object r11 = r8.get(r1)
            androidx.graphics.shapes.RoundedCorner r11 = (androidx.graphics.shapes.RoundedCorner) r11
            float r11 = r11.getExpectedCut()
            java.lang.Object r13 = r8.get(r1)
            androidx.graphics.shapes.RoundedCorner r13 = (androidx.graphics.shapes.RoundedCorner) r13
            float r13 = r13.getExpectedRoundCut()
            float r11 = r11 - r13
            float r11 = r11 * r10
            float r12 = r12 + r11
            r2.add(r12)
            int r6 = r6 + 1
            goto L_0x0126
        L_0x0170:
            java.lang.Object r6 = r8.get(r1)
            androidx.graphics.shapes.RoundedCorner r6 = (androidx.graphics.shapes.RoundedCorner) r6
            float r10 = r2.get(r9)
            r11 = r22
            float r2 = r2.get(r11)
            java.util.List r2 = r6.getCubics(r10, r2)
            r3.add(r2)
            int r1 = r1 + 1
            goto L_0x011e
        L_0x018a:
            r11 = r22
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0191:
            if (r9 >= r7) goto L_0x023d
            int r2 = r9 + r7
            int r2 = r2 - r11
            int r2 = r2 % r7
            int r4 = r9 + 1
            int r6 = r4 % r7
            int r10 = r9 * 2
            r12 = r0[r10]
            int r10 = r10 + r11
            r10 = r0[r10]
            long r12 = androidx.collection.FloatFloatPair.m3constructorimpl(r12, r10)
            int r2 = r2 * r5
            r10 = r0[r2]
            int r2 = r2 + r11
            r2 = r0[r2]
            long r14 = androidx.collection.FloatFloatPair.m3constructorimpl(r10, r2)
            int r2 = r6 * 2
            r10 = r0[r2]
            int r2 = r2 + r11
            r2 = r0[r2]
            r24 = r6
            long r5 = androidx.collection.FloatFloatPair.m3constructorimpl(r10, r2)
            long r14 = androidx.graphics.shapes.PointKt.m42minusybeJwSQ(r12, r14)
            long r5 = androidx.graphics.shapes.PointKt.m42minusybeJwSQ(r5, r12)
            boolean r19 = androidx.graphics.shapes.PointKt.m30clockwiseybeJwSQ(r14, r5)
            r15 = r12
            androidx.graphics.shapes.Feature$Corner r13 = new androidx.graphics.shapes.Feature$Corner
            java.lang.Object r2 = r3.get(r9)
            r14 = r2
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r2 = r8.get(r9)
            androidx.graphics.shapes.RoundedCorner r2 = (androidx.graphics.shapes.RoundedCorner) r2
            long r17 = r2.m51getCenter1ufDz9w()
            r20 = 0
            r13.<init>(r14, r15, r17, r19, r20)
            r1.add(r13)
            androidx.graphics.shapes.Feature$Edge r2 = new androidx.graphics.shapes.Feature$Edge
            androidx.graphics.shapes.Cubic$Companion r5 = androidx.graphics.shapes.Cubic.Companion
            java.lang.Object r6 = r3.get(r9)
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r6 = X2.C2250q.X(r6)
            androidx.graphics.shapes.Cubic r6 = (androidx.graphics.shapes.Cubic) r6
            float r6 = r6.getAnchor1X()
            java.lang.Object r9 = r3.get(r9)
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r9 = X2.C2250q.X(r9)
            androidx.graphics.shapes.Cubic r9 = (androidx.graphics.shapes.Cubic) r9
            float r9 = r9.getAnchor1Y()
            r10 = r24
            java.lang.Object r12 = r3.get(r10)
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r12 = X2.C2250q.M(r12)
            androidx.graphics.shapes.Cubic r12 = (androidx.graphics.shapes.Cubic) r12
            float r12 = r12.getAnchor0X()
            java.lang.Object r10 = r3.get(r10)
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r10 = X2.C2250q.M(r10)
            androidx.graphics.shapes.Cubic r10 = (androidx.graphics.shapes.Cubic) r10
            float r10 = r10.getAnchor0Y()
            androidx.graphics.shapes.Cubic r5 = r5.straightLine(r6, r9, r12, r10)
            java.util.List r5 = X2.C2250q.d(r5)
            r2.<init>(r5)
            r1.add(r2)
            r9 = r4
            r5 = 2
            goto L_0x0191
        L_0x023d:
            r2 = 1
            int r3 = (r26 > r2 ? 1 : (r26 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0243
            goto L_0x0247
        L_0x0243:
            int r2 = (r27 > r2 ? 1 : (r27 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x024c
        L_0x0247:
            long r2 = calculateCenter(r0)
            goto L_0x0250
        L_0x024c:
            long r2 = androidx.collection.FloatFloatPair.m3constructorimpl(r26, r27)
        L_0x0250:
            r0 = 32
            long r4 = r2 >> r0
            int r0 = (int) r4
            float r0 = java.lang.Float.intBitsToFloat(r0)
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            int r2 = (int) r2
            float r2 = java.lang.Float.intBitsToFloat(r2)
            androidx.graphics.shapes.RoundedPolygon r3 = new androidx.graphics.shapes.RoundedPolygon
            r3.<init>(r1, r0, r2)
            return r3
        L_0x026a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The vertices array should have even size"
            r0.<init>(r1)
            throw r0
        L_0x0272:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Polygons must have at least 3 vertices"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.graphics.shapes.RoundedPolygonKt.RoundedPolygon(float[], androidx.graphics.shapes.CornerRounding, java.util.List, float, float):androidx.graphics.shapes.RoundedPolygon");
    }
}
