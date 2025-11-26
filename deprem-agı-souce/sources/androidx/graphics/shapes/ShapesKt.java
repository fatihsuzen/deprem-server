package androidx.graphics.shapes;

import X2.C2250q;
import X2.J;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.graphics.shapes.RoundedPolygon;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2728d;
import q3.C2729e;

public final class ShapesKt {
    public static final RoundedPolygon circle(RoundedPolygon.Companion companion) {
        t.e(companion, "<this>");
        return circle$default(companion, 0, 0.0f, 0.0f, 0.0f, 15, (Object) null);
    }

    public static /* synthetic */ RoundedPolygon circle$default(RoundedPolygon.Companion companion, int i5, float f5, float f6, float f7, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = 8;
        }
        if ((i6 & 2) != 0) {
            f5 = 1.0f;
        }
        if ((i6 & 4) != 0) {
            f6 = 0.0f;
        }
        if ((i6 & 8) != 0) {
            f7 = 0.0f;
        }
        return circle(companion, i5, f5, f6, f7);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion) {
        t.e(companion, "<this>");
        return pill$default(companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 31, (Object) null);
    }

    public static /* synthetic */ RoundedPolygon pill$default(RoundedPolygon.Companion companion, float f5, float f6, float f7, float f8, float f9, int i5, Object obj) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        RoundedPolygon.Companion companion2;
        if ((i5 & 1) != 0) {
            f5 = 2.0f;
        }
        if ((i5 & 2) != 0) {
            f6 = 1.0f;
        }
        if ((i5 & 4) != 0) {
            f7 = 0.0f;
        }
        if ((i5 & 8) != 0) {
            f8 = 0.0f;
        }
        if ((i5 & 16) != 0) {
            f10 = 0.0f;
            f12 = f7;
            f11 = f8;
            f14 = f5;
            f13 = f6;
            companion2 = companion;
        } else {
            f10 = f9;
            f11 = f8;
            f13 = f6;
            f12 = f7;
            companion2 = companion;
            f14 = f5;
        }
        return pill(companion2, f14, f13, f12, f11, f10);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion) {
        t.e(companion, "<this>");
        return pillStar$default(companion, 0.0f, 0.0f, 0, 0.0f, (CornerRounding) null, (CornerRounding) null, (List) null, 0.0f, 0.0f, 0.0f, 0.0f, 2047, (Object) null);
    }

    public static /* synthetic */ RoundedPolygon pillStar$default(RoundedPolygon.Companion companion, float f5, float f6, int i5, float f7, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f8, float f9, float f10, float f11, int i6, Object obj) {
        float f12;
        float f13;
        float f14;
        float f15;
        List list2;
        CornerRounding cornerRounding3;
        CornerRounding cornerRounding4;
        float f16;
        int i7;
        float f17;
        float f18;
        RoundedPolygon.Companion companion2;
        if ((i6 & 1) != 0) {
            f5 = 2.0f;
        }
        if ((i6 & 2) != 0) {
            f6 = 1.0f;
        }
        if ((i6 & 4) != 0) {
            i5 = 8;
        }
        if ((i6 & 8) != 0) {
            f7 = 0.5f;
        }
        if ((i6 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i6 & 32) != 0) {
            cornerRounding2 = null;
        }
        if ((i6 & 64) != 0) {
            list = null;
        }
        if ((i6 & 128) != 0) {
            f8 = 0.5f;
        }
        if ((i6 & 256) != 0) {
            f9 = 0.0f;
        }
        if ((i6 & 512) != 0) {
            f10 = 0.0f;
        }
        if ((i6 & 1024) != 0) {
            f12 = 0.0f;
            f14 = f9;
            f13 = f10;
            list2 = list;
            f15 = f8;
            cornerRounding4 = cornerRounding;
            cornerRounding3 = cornerRounding2;
            i7 = i5;
            f16 = f7;
            f18 = f5;
            f17 = f6;
            companion2 = companion;
        } else {
            f12 = f11;
            f13 = f10;
            f15 = f8;
            f14 = f9;
            cornerRounding3 = cornerRounding2;
            list2 = list;
            f16 = f7;
            cornerRounding4 = cornerRounding;
            f17 = f6;
            i7 = i5;
            companion2 = companion;
            f18 = f5;
        }
        return pillStar(companion2, f18, f17, i7, f16, cornerRounding4, cornerRounding3, list2, f15, f14, f13, f12);
    }

    private static final float[] pillStarVerticesFromNumVerts(int i5, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        int i6;
        float f12;
        float f13;
        long j5;
        float f14;
        float min = Math.min(f5, f6);
        float b5 = C2729e.b(f6 - f5, 0.0f);
        float b6 = C2729e.b(f5 - f6, 0.0f);
        float f15 = (float) 2;
        float f16 = b5 / f15;
        float f17 = b6 / f15;
        float twoPi = Utils.getTwoPi() * min * Utils.interpolate(f7, 1.0f, f8);
        float f18 = (f15 * b6) + (f15 * b5) + twoPi;
        float f19 = twoPi / ((float) 4);
        float f20 = f16 + f19;
        float f21 = f20 + b6;
        float f22 = f21 + f19;
        float f23 = f22 + b5;
        float f24 = f23 + f19;
        float f25 = f24 + b6;
        float f26 = f25 + f19;
        float[] fArr = {0.0f, f16, f20, f21, f22, f23, f24, f25, f26, f26 + f16, f18};
        int i7 = i5 * 2;
        float f27 = f18 / ((float) i7);
        float f28 = f9 * f18;
        float[] fArr2 = new float[(i5 * 4)];
        float f29 = b6;
        long r32 = FloatFloatPair.m3constructorimpl(f17, f16);
        float f30 = -f17;
        float[] fArr3 = fArr;
        long r11 = FloatFloatPair.m3constructorimpl(f30, f16);
        float f31 = -f16;
        float f32 = min;
        long r02 = FloatFloatPair.m3constructorimpl(f30, f31);
        float f33 = f30;
        float f34 = f15;
        long r5 = FloatFloatPair.m3constructorimpl(f17, f31);
        float f35 = b5;
        float f36 = f16;
        int i8 = 0;
        float f37 = 0.0f;
        boolean z4 = false;
        int i9 = 0;
        int i10 = 0;
        while (i8 < i7) {
            float f38 = f28 % f18;
            if (f38 < f37) {
                i9 = 0;
            }
            while (true) {
                int i11 = (i9 + 1) % 11;
                float f39 = fArr3[i11];
                if (f38 >= f39) {
                    f36 = fArr3[(i11 + 1) % 11];
                    i9 = i11;
                    f37 = f39;
                } else {
                    float f40 = (f38 - f37) / (f36 - f37);
                    if (z4) {
                        i6 = i8;
                        f12 = f32 * f7;
                    } else {
                        i6 = i8;
                        f12 = f32;
                    }
                    switch (i9) {
                        case 0:
                            f13 = f16;
                            float f41 = f12;
                            f14 = f17;
                            j5 = FloatFloatPair.m3constructorimpl(f41, f40 * f13);
                            break;
                        case 1:
                            f13 = f16;
                            float f42 = f12;
                            f14 = f17;
                            j5 = PointKt.m43plusybeJwSQ(Utils.m61radialToCartesianL6JJ3z0$default(f42, (f40 * Utils.getFloatPi()) / f34, 0, 4, (Object) null), r32);
                            break;
                        case 2:
                            f13 = f16;
                            float f43 = f12;
                            f14 = f17;
                            j5 = FloatFloatPair.m3constructorimpl(f14 - (f40 * f29), f43);
                            break;
                        case 3:
                            f13 = f16;
                            float f44 = f12;
                            f14 = f17;
                            j5 = PointKt.m43plusybeJwSQ(Utils.m61radialToCartesianL6JJ3z0$default(f44, (Utils.getFloatPi() / f34) + ((f40 * Utils.getFloatPi()) / f34), 0, 4, (Object) null), r11);
                            break;
                        case 4:
                            f13 = f16;
                            float f45 = f12;
                            f14 = f17;
                            j5 = FloatFloatPair.m3constructorimpl(-f45, f13 - (f40 * f35));
                            break;
                        case 5:
                            f13 = f16;
                            float f46 = f12;
                            f14 = f17;
                            j5 = PointKt.m43plusybeJwSQ(Utils.m61radialToCartesianL6JJ3z0$default(f46, Utils.getFloatPi() + ((f40 * Utils.getFloatPi()) / f34), 0, 4, (Object) null), r02);
                            break;
                        case 6:
                            f13 = f16;
                            float f47 = f12;
                            f14 = f17;
                            j5 = FloatFloatPair.m3constructorimpl(f33 + (f40 * f29), -f47);
                            break;
                        case 7:
                            f13 = f16;
                            float f48 = f12;
                            f14 = f17;
                            j5 = PointKt.m43plusybeJwSQ(Utils.m61radialToCartesianL6JJ3z0$default(f48, (Utils.getFloatPi() * 1.5f) + ((f40 * Utils.getFloatPi()) / f34), 0, 4, (Object) null), r5);
                            break;
                        default:
                            f13 = f16;
                            j5 = FloatFloatPair.m3constructorimpl(f12, f31 + (f40 * f16));
                            f14 = f17;
                            break;
                    }
                    int i12 = i10 + 1;
                    fArr2[i10] = PointKt.m39getXDnnuFBc(j5) + f10;
                    i10 += 2;
                    fArr2[i12] = PointKt.m40getYDnnuFBc(j5) + f11;
                    f28 += f27;
                    z4 = !z4;
                    f17 = f14;
                    i8 = i6 + 1;
                    f16 = f13;
                }
            }
        }
        return fArr2;
    }

    public static final RoundedPolygon rectangle(RoundedPolygon.Companion companion, float f5, float f6, CornerRounding cornerRounding, List<CornerRounding> list, float f7, float f8) {
        t.e(companion, "<this>");
        t.e(cornerRounding, "rounding");
        float f9 = (float) 2;
        float f10 = f5 / f9;
        float f11 = f7 - f10;
        float f12 = f6 / f9;
        float f13 = f8 - f12;
        float f14 = f10 + f7;
        float f15 = f12 + f8;
        return RoundedPolygonKt.RoundedPolygon(new float[]{f14, f15, f11, f15, f11, f13, f14, f13}, cornerRounding, list, f7, f8);
    }

    public static /* synthetic */ RoundedPolygon rectangle$default(RoundedPolygon.Companion companion, float f5, float f6, CornerRounding cornerRounding, List list, float f7, float f8, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = 2.0f;
        }
        if ((i5 & 2) != 0) {
            f6 = 2.0f;
        }
        if ((i5 & 4) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i5 & 8) != 0) {
            list = null;
        }
        if ((i5 & 16) != 0) {
            f7 = 0.0f;
        }
        if ((i5 & 32) != 0) {
            f8 = 0.0f;
        }
        return rectangle(companion, f5, f6, cornerRounding, list, f7, f8);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i5) {
        t.e(companion, "<this>");
        return star$default(companion, i5, 0.0f, 0.0f, (CornerRounding) null, (CornerRounding) null, (List) null, 0.0f, 0.0f, 254, (Object) null);
    }

    public static /* synthetic */ RoundedPolygon star$default(RoundedPolygon.Companion companion, int i5, float f5, float f6, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f7, float f8, int i6, Object obj) {
        int i7 = i6;
        float f9 = (i7 & 2) != 0 ? 1.0f : f5;
        float f10 = (i7 & 4) != 0 ? 0.5f : f6;
        CornerRounding cornerRounding3 = (i7 & 8) != 0 ? CornerRounding.Unrounded : cornerRounding;
        List list2 = null;
        CornerRounding cornerRounding4 = (i7 & 16) != 0 ? null : cornerRounding2;
        if ((i7 & 32) == 0) {
            list2 = list;
        }
        return star(companion, i5, f9, f10, cornerRounding3, cornerRounding4, list2, (i7 & 64) != 0 ? 0.0f : f7, (i7 & 128) != 0 ? 0.0f : f8);
    }

    private static final float[] starVerticesFromNumVerts(int i5, float f5, float f6, float f7, float f8) {
        float[] fArr = new float[(i5 * 4)];
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            float f9 = (float) i5;
            long r7 = Utils.m61radialToCartesianL6JJ3z0$default(f5, (Utils.getFloatPi() / f9) * ((float) 2) * ((float) i7), 0, 4, (Object) null);
            fArr[i6] = PointKt.m39getXDnnuFBc(r7) + f7;
            fArr[i6 + 1] = PointKt.m40getYDnnuFBc(r7) + f8;
            long r32 = Utils.m61radialToCartesianL6JJ3z0$default(f6, (Utils.getFloatPi() / f9) * ((float) ((i7 * 2) + 1)), 0, 4, (Object) null);
            int i8 = i6 + 3;
            fArr[i6 + 2] = PointKt.m39getXDnnuFBc(r32) + f7;
            i6 += 4;
            fArr[i8] = PointKt.m40getYDnnuFBc(r32) + f8;
        }
        return fArr;
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i5) {
        t.e(companion, "<this>");
        return circle$default(companion, i5, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f5) {
        t.e(companion, "<this>");
        return pill$default(companion, f5, 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f5) {
        t.e(companion, "<this>");
        return pillStar$default(companion, f5, 0.0f, 0, 0.0f, (CornerRounding) null, (CornerRounding) null, (List) null, 0.0f, 0.0f, 0.0f, 0.0f, 2046, (Object) null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i5, float f5) {
        t.e(companion, "<this>");
        return star$default(companion, i5, f5, 0.0f, (CornerRounding) null, (CornerRounding) null, (List) null, 0.0f, 0.0f, 252, (Object) null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i5, float f5) {
        t.e(companion, "<this>");
        return circle$default(companion, i5, f5, 0.0f, 0.0f, 12, (Object) null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f5, float f6) {
        t.e(companion, "<this>");
        return pill$default(companion, f5, f6, 0.0f, 0.0f, 0.0f, 28, (Object) null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f5, float f6) {
        t.e(companion, "<this>");
        return pillStar$default(companion, f5, f6, 0, 0.0f, (CornerRounding) null, (CornerRounding) null, (List) null, 0.0f, 0.0f, 0.0f, 0.0f, 2044, (Object) null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i5, float f5, float f6) {
        t.e(companion, "<this>");
        return star$default(companion, i5, f5, f6, (CornerRounding) null, (CornerRounding) null, (List) null, 0.0f, 0.0f, 248, (Object) null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i5, float f5, float f6) {
        t.e(companion, "<this>");
        return circle$default(companion, i5, f5, f6, 0.0f, 8, (Object) null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f5, float f6, float f7) {
        t.e(companion, "<this>");
        return pill$default(companion, f5, f6, f7, 0.0f, 0.0f, 24, (Object) null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f5, float f6, int i5) {
        t.e(companion, "<this>");
        return pillStar$default(companion, f5, f6, i5, 0.0f, (CornerRounding) null, (CornerRounding) null, (List) null, 0.0f, 0.0f, 0.0f, 0.0f, 2040, (Object) null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i5, float f5, float f6, CornerRounding cornerRounding) {
        t.e(companion, "<this>");
        CornerRounding cornerRounding2 = cornerRounding;
        t.e(cornerRounding2, "rounding");
        return star$default(companion, i5, f5, f6, cornerRounding2, (CornerRounding) null, (List) null, 0.0f, 0.0f, PsExtractor.VIDEO_STREAM_MASK, (Object) null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i5, float f5, float f6, float f7) {
        t.e(companion, "<this>");
        if (i5 >= 3) {
            return RoundedPolygonKt.RoundedPolygon$default(i5, f5 / ((float) Math.cos((double) (Utils.getFloatPi() / ((float) i5)))), f6, f7, new CornerRounding(f5, 0.0f, 2, (C2633k) null), (List) null, 32, (Object) null);
        }
        throw new IllegalArgumentException("Circle must have at least three vertices");
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f5, float f6, float f7, float f8) {
        t.e(companion, "<this>");
        return pill$default(companion, f5, f6, f7, f8, 0.0f, 16, (Object) null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f5, float f6, int i5, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f7) {
        t.e(companion, "<this>");
        return pillStar$default(companion, f5, f6, i5, f7, (CornerRounding) null, (CornerRounding) null, (List) null, 0.0f, 0.0f, 0.0f, 0.0f, 2032, (Object) null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i5, float f5, float f6, CornerRounding cornerRounding, CornerRounding cornerRounding2) {
        t.e(companion, "<this>");
        CornerRounding cornerRounding3 = cornerRounding;
        t.e(cornerRounding3, "rounding");
        return star$default(companion, i5, f5, f6, cornerRounding3, cornerRounding2, (List) null, 0.0f, 0.0f, 224, (Object) null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f5, float f6, float f7, float f8, float f9) {
        t.e(companion, "<this>");
        if (f5 <= 0.0f || f6 <= 0.0f) {
            throw new IllegalArgumentException("Pill shapes must have positive width and height");
        }
        float f10 = (float) 2;
        float f11 = f5 / f10;
        float f12 = f6 / f10;
        float f13 = f11 + f8;
        float f14 = f12 + f9;
        float f15 = (-f11) + f8;
        float f16 = (-f12) + f9;
        return RoundedPolygonKt.RoundedPolygon$default(new float[]{f13, f14, f15, f14, f15, f16, f13, f16}, new CornerRounding(Math.min(f11, f12), f7), (List) null, f8, f9, 4, (Object) null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f5, float f6, int i5, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f7, CornerRounding cornerRounding) {
        t.e(companion, "<this>");
        CornerRounding cornerRounding2 = cornerRounding;
        t.e(cornerRounding2, "rounding");
        return pillStar$default(companion, f5, f6, i5, f7, cornerRounding2, (CornerRounding) null, (List) null, 0.0f, 0.0f, 0.0f, 0.0f, 2016, (Object) null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i5, float f5, float f6, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list) {
        t.e(companion, "<this>");
        CornerRounding cornerRounding3 = cornerRounding;
        t.e(cornerRounding3, "rounding");
        return star$default(companion, i5, f5, f6, cornerRounding3, cornerRounding2, list, 0.0f, 0.0f, PsExtractor.AUDIO_STREAM, (Object) null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f5, float f6, int i5, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f7, CornerRounding cornerRounding, CornerRounding cornerRounding2) {
        t.e(companion, "<this>");
        CornerRounding cornerRounding3 = cornerRounding;
        t.e(cornerRounding3, "rounding");
        return pillStar$default(companion, f5, f6, i5, f7, cornerRounding3, cornerRounding2, (List) null, 0.0f, 0.0f, 0.0f, 0.0f, 1984, (Object) null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i5, float f5, float f6, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, float f7) {
        t.e(companion, "<this>");
        CornerRounding cornerRounding3 = cornerRounding;
        t.e(cornerRounding3, "rounding");
        return star$default(companion, i5, f5, f6, cornerRounding3, cornerRounding2, list, f7, 0.0f, 128, (Object) null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f5, float f6, int i5, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f7, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list) {
        t.e(companion, "<this>");
        CornerRounding cornerRounding3 = cornerRounding;
        t.e(cornerRounding3, "rounding");
        return pillStar$default(companion, f5, f6, i5, f7, cornerRounding3, cornerRounding2, list, 0.0f, 0.0f, 0.0f, 0.0f, 1920, (Object) null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i5, float f5, float f6, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, float f7, float f8) {
        t.e(companion, "<this>");
        t.e(cornerRounding, "rounding");
        if (f5 <= 0.0f || f6 <= 0.0f) {
            throw new IllegalArgumentException("Star radii must both be greater than 0");
        } else if (f6 < f5) {
            if (list == null && cornerRounding2 != null) {
                C2728d l5 = C2729e.l(0, i5);
                ArrayList arrayList = new ArrayList();
                Iterator it = l5.iterator();
                while (it.hasNext()) {
                    ((J) it).nextInt();
                    C2250q.u(arrayList, C2250q.j(cornerRounding, cornerRounding2));
                }
                list = arrayList;
            }
            return RoundedPolygonKt.RoundedPolygon(starVerticesFromNumVerts(i5, f5, f6, f7, f8), cornerRounding, list, f7, f8);
        } else {
            throw new IllegalArgumentException("innerRadius must be less than radius");
        }
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f5, float f6, int i5, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f7, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f8) {
        t.e(companion, "<this>");
        CornerRounding cornerRounding3 = cornerRounding;
        t.e(cornerRounding3, "rounding");
        return pillStar$default(companion, f5, f6, i5, f7, cornerRounding3, cornerRounding2, list, f8, 0.0f, 0.0f, 0.0f, 1792, (Object) null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f5, float f6, int i5, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f7, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f8, @FloatRange(from = 0.0d, to = 1.0d) float f9) {
        t.e(companion, "<this>");
        CornerRounding cornerRounding3 = cornerRounding;
        t.e(cornerRounding3, "rounding");
        return pillStar$default(companion, f5, f6, i5, f7, cornerRounding3, cornerRounding2, list, f8, f9, 0.0f, 0.0f, 1536, (Object) null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f5, float f6, int i5, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f7, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f8, @FloatRange(from = 0.0d, to = 1.0d) float f9, float f10) {
        t.e(companion, "<this>");
        CornerRounding cornerRounding3 = cornerRounding;
        t.e(cornerRounding3, "rounding");
        return pillStar$default(companion, f5, f6, i5, f7, cornerRounding3, cornerRounding2, list, f8, f9, f10, 0.0f, 1024, (Object) null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f5, float f6, int i5, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f7, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f8, @FloatRange(from = 0.0d, to = 1.0d) float f9, float f10, float f11) {
        List<CornerRounding> list2;
        t.e(companion, "<this>");
        t.e(cornerRounding, "rounding");
        if (f5 <= 0.0f || f6 <= 0.0f) {
            throw new IllegalArgumentException("Pill shapes must have positive width and height");
        } else if (f7 <= 0.0f || f7 > 1.0f) {
            throw new IllegalArgumentException("innerRadius must be between 0 and 1");
        } else {
            if (list != null || cornerRounding2 == null) {
                list2 = list;
            } else {
                C2728d l5 = C2729e.l(0, i5);
                list2 = new ArrayList<>();
                Iterator it = l5.iterator();
                while (it.hasNext()) {
                    ((J) it).nextInt();
                    C2250q.u(list2, C2250q.j(cornerRounding, cornerRounding2));
                }
            }
            float f12 = f10;
            float f13 = f11;
            return RoundedPolygonKt.RoundedPolygon(pillStarVerticesFromNumVerts(i5, f5, f6, f7, f8, f9, f12, f13), cornerRounding, list2, f12, f13);
        }
    }
}
