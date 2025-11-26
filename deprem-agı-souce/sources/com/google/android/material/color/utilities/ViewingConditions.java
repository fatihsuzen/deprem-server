package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ViewingConditions {
    public static final ViewingConditions DEFAULT = defaultWithBackgroundLstar(50.0d);
    private final double aw;

    /* renamed from: c  reason: collision with root package name */
    private final double f7000c;
    private final double fl;
    private final double flRoot;

    /* renamed from: n  reason: collision with root package name */
    private final double f7001n;
    private final double nbb;
    private final double nc;
    private final double ncb;
    private final double[] rgbD;

    /* renamed from: z  reason: collision with root package name */
    private final double f7002z;

    private ViewingConditions(double d5, double d6, double d7, double d8, double d9, double d10, double[] dArr, double d11, double d12, double d13) {
        this.f7001n = d5;
        this.aw = d6;
        this.nbb = d7;
        this.ncb = d8;
        this.f7000c = d9;
        this.nc = d10;
        this.rgbD = dArr;
        this.fl = d11;
        this.flRoot = d12;
        this.f7002z = d13;
    }

    public static ViewingConditions defaultWithBackgroundLstar(double d5) {
        return make(ColorUtils.whitePointD65(), (ColorUtils.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d, d5, 2.0d, false);
    }

    public static ViewingConditions make(double[] dArr, double d5, double d6, double d7, boolean z4) {
        double lerp;
        double d8;
        double d9;
        double d10 = d5;
        double max = Math.max(0.1d, d6);
        double[][] dArr2 = Cam16.XYZ_TO_CAM16RGB;
        double d11 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d12 = dArr[1];
        double d13 = dArr[2];
        double d14 = (dArr3[0] * d11) + (dArr3[1] * d12) + (dArr3[2] * d13);
        double[] dArr4 = dArr2[1];
        double d15 = (dArr4[0] * d11) + (dArr4[1] * d12) + (dArr4[2] * d13);
        double[] dArr5 = dArr2[2];
        double d16 = (d11 * dArr5[0]) + (d12 * dArr5[1]) + (d13 * dArr5[2]);
        double d17 = (d7 / 10.0d) + 0.8d;
        if (d17 >= 0.9d) {
            lerp = MathUtils.lerp(0.59d, 0.69d, (d17 - 0.9d) * 10.0d);
        } else {
            lerp = MathUtils.lerp(0.525d, 0.59d, (d17 - 0.8d) * 10.0d);
        }
        double d18 = lerp;
        if (z4) {
            d9 = 0.1d;
            d8 = 1.0d;
        } else {
            d9 = 0.1d;
            d8 = (1.0d - (Math.exp(((-d10) - 42.0d) / 92.0d) * 0.2777777777777778d)) * d17;
        }
        double clampDouble = MathUtils.clampDouble(0.0d, 1.0d, d8);
        double[] dArr6 = {(((100.0d / d14) * clampDouble) + 1.0d) - clampDouble, (((100.0d / d15) * clampDouble) + 1.0d) - clampDouble, (((100.0d / d16) * clampDouble) + 1.0d) - clampDouble};
        double d19 = 5.0d * d10;
        double d20 = 1.0d / (d19 + 1.0d);
        double d21 = d20 * d20 * d20 * d20;
        double d22 = 1.0d - d21;
        double cbrt = (d21 * d10) + (d22 * d9 * d22 * Math.cbrt(d19));
        double yFromLstar = ColorUtils.yFromLstar(max) / dArr[1];
        double sqrt = Math.sqrt(yFromLstar) + 1.48d;
        double pow = 0.725d / Math.pow(yFromLstar, 0.2d);
        double[] dArr7 = {Math.pow(((dArr6[0] * cbrt) * d14) / 100.0d, 0.42d), Math.pow(((dArr6[1] * cbrt) * d15) / 100.0d, 0.42d), Math.pow(((dArr6[2] * cbrt) * d16) / 100.0d, 0.42d)};
        double d23 = dArr7[0];
        double d24 = (d23 * 400.0d) / (d23 + 27.13d);
        double d25 = dArr7[1];
        double d26 = (d25 * 400.0d) / (d25 + 27.13d);
        double d27 = dArr7[2];
        double[] dArr8 = {d24, d26, (400.0d * d27) / (d27 + 27.13d)};
        return new ViewingConditions(yFromLstar, ((dArr8[0] * 2.0d) + dArr8[1] + (dArr8[2] * 0.05d)) * pow, pow, pow, d18, d17, dArr6, cbrt, Math.pow(cbrt, 0.25d), sqrt);
    }

    public double getAw() {
        return this.aw;
    }

    /* access modifiers changed from: package-private */
    public double getC() {
        return this.f7000c;
    }

    /* access modifiers changed from: package-private */
    public double getFl() {
        return this.fl;
    }

    public double getFlRoot() {
        return this.flRoot;
    }

    public double getN() {
        return this.f7001n;
    }

    public double getNbb() {
        return this.nbb;
    }

    /* access modifiers changed from: package-private */
    public double getNc() {
        return this.nc;
    }

    /* access modifiers changed from: package-private */
    public double getNcb() {
        return this.ncb;
    }

    public double[] getRgbD() {
        return this.rgbD;
    }

    /* access modifiers changed from: package-private */
    public double getZ() {
        return this.f7002z;
    }
}
