package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Cam16 {
    static final double[][] CAM16RGB_TO_XYZ = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};
    static final double[][] XYZ_TO_CAM16RGB = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;

    /* renamed from: j  reason: collision with root package name */
    private final double f6972j;
    private final double jstar;

    /* renamed from: m  reason: collision with root package name */
    private final double f6973m;

    /* renamed from: q  reason: collision with root package name */
    private final double f6974q;

    /* renamed from: s  reason: collision with root package name */
    private final double f6975s;
    private final double[] tempArray = {0.0d, 0.0d, 0.0d};

    private Cam16(double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
        this.hue = d5;
        this.chroma = d6;
        this.f6972j = d7;
        this.f6974q = d8;
        this.f6973m = d9;
        this.f6975s = d10;
        this.jstar = d11;
        this.astar = d12;
        this.bstar = d13;
    }

    public static Cam16 fromInt(int i5) {
        return fromIntInViewingConditions(i5, ViewingConditions.DEFAULT);
    }

    static Cam16 fromIntInViewingConditions(int i5, ViewingConditions viewingConditions) {
        int i6 = i5;
        double linearized = ColorUtils.linearized((16711680 & i6) >> 16);
        double linearized2 = ColorUtils.linearized((65280 & i6) >> 8);
        double linearized3 = ColorUtils.linearized(i6 & 255);
        return fromXyzInViewingConditions((0.41233895d * linearized) + (0.35762064d * linearized2) + (0.18051042d * linearized3), (0.2126d * linearized) + (0.7152d * linearized2) + (0.0722d * linearized3), (linearized * 0.01932141d) + (linearized2 * 0.11916382d) + (linearized3 * 0.95034478d), viewingConditions);
    }

    static Cam16 fromJch(double d5, double d6, double d7) {
        return fromJchInViewingConditions(d5, d6, d7, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(double d5, double d6, double d7, ViewingConditions viewingConditions) {
        double d8 = d5 / 100.0d;
        double c5 = (4.0d / viewingConditions.getC()) * Math.sqrt(d8) * (viewingConditions.getAw() + 4.0d) * viewingConditions.getFlRoot();
        double flRoot = d6 * viewingConditions.getFlRoot();
        double sqrt = Math.sqrt(((d6 / Math.sqrt(d8)) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double radians = Math.toRadians(d7);
        double d9 = (1.7000000000000002d * d5) / ((0.007d * d5) + 1.0d);
        double log1p = Math.log1p(0.0228d * flRoot) * 43.859649122807014d;
        return new Cam16(d7, d6, d5, c5, flRoot, sqrt, d9, log1p * Math.cos(radians), log1p * Math.sin(radians));
    }

    public static Cam16 fromUcs(double d5, double d6, double d7) {
        return fromUcsInViewingConditions(d5, d6, d7, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(double d5, double d6, double d7, ViewingConditions viewingConditions) {
        double expm1 = (Math.expm1(Math.hypot(d6, d7) * 0.0228d) / 0.0228d) / viewingConditions.getFlRoot();
        double atan2 = Math.atan2(d7, d6) * 57.29577951308232d;
        if (atan2 < 0.0d) {
            atan2 += 360.0d;
        }
        return fromJchInViewingConditions(d5 / (1.0d - ((d5 - 100.0d) * 0.007d)), expm1, atan2, viewingConditions);
    }

    static Cam16 fromXyzInViewingConditions(double d5, double d6, double d7, ViewingConditions viewingConditions) {
        double d8;
        double[][] dArr = XYZ_TO_CAM16RGB;
        double[] dArr2 = dArr[0];
        double d9 = (dArr2[0] * d5) + (dArr2[1] * d6) + (dArr2[2] * d7);
        double[] dArr3 = dArr[1];
        double d10 = (dArr3[0] * d5) + (dArr3[1] * d6) + (dArr3[2] * d7);
        double[] dArr4 = dArr[2];
        double d11 = viewingConditions.getRgbD()[0] * d9;
        double d12 = viewingConditions.getRgbD()[1] * d10;
        double d13 = viewingConditions.getRgbD()[2] * ((dArr4[0] * d5) + (dArr4[1] * d6) + (dArr4[2] * d7));
        double pow = Math.pow((viewingConditions.getFl() * Math.abs(d11)) / 100.0d, 0.42d);
        double pow2 = Math.pow((viewingConditions.getFl() * Math.abs(d12)) / 100.0d, 0.42d);
        double pow3 = Math.pow((viewingConditions.getFl() * Math.abs(d13)) / 100.0d, 0.42d);
        double signum = ((Math.signum(d11) * 400.0d) * pow) / (pow + 27.13d);
        double signum2 = ((Math.signum(d12) * 400.0d) * pow2) / (pow2 + 27.13d);
        double signum3 = ((Math.signum(d13) * 400.0d) * pow3) / (pow3 + 27.13d);
        double d14 = (((signum * 11.0d) + (-12.0d * signum2)) + signum3) / 11.0d;
        double d15 = ((signum + signum2) - (signum3 * 2.0d)) / 9.0d;
        double d16 = signum2 * 20.0d;
        double d17 = (((signum * 20.0d) + d16) + (21.0d * signum3)) / 20.0d;
        double d18 = (((signum * 40.0d) + d16) + signum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(d15, d14));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        } else if (degrees >= 360.0d) {
            degrees -= 360.0d;
        }
        double d19 = degrees;
        double radians = Math.toRadians(d19);
        double pow4 = Math.pow((d18 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ()) * 100.0d;
        double d20 = pow4 / 100.0d;
        double flRoot = viewingConditions.getFlRoot() * (4.0d / viewingConditions.getC()) * Math.sqrt(d20) * (viewingConditions.getAw() + 4.0d);
        if (d19 < 20.14d) {
            d8 = d19 + 360.0d;
        } else {
            d8 = d19;
        }
        double pow5 = Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d) * Math.pow(((((((Math.cos(Math.toRadians(d8) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * viewingConditions.getNc()) * viewingConditions.getNcb()) * Math.hypot(d14, d15)) / (d17 + 0.305d), 0.9d);
        double sqrt = pow5 * Math.sqrt(d20);
        double flRoot2 = sqrt * viewingConditions.getFlRoot();
        double sqrt2 = Math.sqrt((pow5 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double d21 = (1.7000000000000002d * pow4) / ((0.007d * pow4) + 1.0d);
        double log1p = Math.log1p(0.0228d * flRoot2) * 43.859649122807014d;
        return new Cam16(d19, sqrt, pow4, flRoot, flRoot2, sqrt2, d21, log1p * Math.cos(radians), log1p * Math.sin(radians));
    }

    public double distance(@NonNull Cam16 cam16) {
        double jstar2 = getJstar() - cam16.getJstar();
        double astar2 = getAstar() - cam16.getAstar();
        double bstar2 = getBstar() - cam16.getBstar();
        return Math.pow(Math.sqrt((jstar2 * jstar2) + (astar2 * astar2) + (bstar2 * bstar2)), 0.63d) * 1.41d;
    }

    public double getAstar() {
        return this.astar;
    }

    public double getBstar() {
        return this.bstar;
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getJ() {
        return this.f6972j;
    }

    public double getJstar() {
        return this.jstar;
    }

    public double getM() {
        return this.f6973m;
    }

    public double getQ() {
        return this.f6974q;
    }

    public double getS() {
        return this.f6975s;
    }

    public int toInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    /* access modifiers changed from: package-private */
    public int viewed(ViewingConditions viewingConditions) {
        double[] xyzInViewingConditions = xyzInViewingConditions(viewingConditions, this.tempArray);
        return ColorUtils.argbFromXyz(xyzInViewingConditions[0], xyzInViewingConditions[1], xyzInViewingConditions[2]);
    }

    /* access modifiers changed from: package-private */
    public double[] xyzInViewingConditions(ViewingConditions viewingConditions, double[] dArr) {
        double d5;
        if (getChroma() == 0.0d || getJ() == 0.0d) {
            d5 = 0.0d;
        } else {
            d5 = getChroma() / Math.sqrt(getJ() / 100.0d);
        }
        double pow = Math.pow(d5 / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double radians = Math.toRadians(getHue());
        double aw = viewingConditions.getAw() * Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ());
        double cos = (Math.cos(2.0d + radians) + 3.8d) * 0.25d * 3846.153846153846d * viewingConditions.getNc() * viewingConditions.getNcb();
        double nbb = aw / viewingConditions.getNbb();
        double sin = Math.sin(radians);
        double cos2 = Math.cos(radians);
        double d6 = (((0.305d + nbb) * 23.0d) * pow) / (((cos * 23.0d) + ((11.0d * pow) * cos2)) + ((pow * 108.0d) * sin));
        double d7 = cos2 * d6;
        double d8 = d6 * sin;
        double d9 = nbb * 460.0d;
        double d10 = (((451.0d * d7) + d9) + (288.0d * d8)) / 1403.0d;
        double d11 = ((d9 - (891.0d * d7)) - (261.0d * d8)) / 1403.0d;
        double d12 = ((d9 - (d7 * 220.0d)) - (d8 * 6300.0d)) / 1403.0d;
        double signum = Math.signum(d10) * (100.0d / viewingConditions.getFl()) * Math.pow(Math.max(0.0d, (Math.abs(d10) * 27.13d) / (400.0d - Math.abs(d10))), 2.380952380952381d);
        double signum2 = Math.signum(d11) * (100.0d / viewingConditions.getFl()) * Math.pow(Math.max(0.0d, (Math.abs(d11) * 27.13d) / (400.0d - Math.abs(d11))), 2.380952380952381d);
        double signum3 = Math.signum(d12) * (100.0d / viewingConditions.getFl()) * Math.pow(Math.max(0.0d, (Math.abs(d12) * 27.13d) / (400.0d - Math.abs(d12))), 2.380952380952381d);
        double d13 = signum / viewingConditions.getRgbD()[0];
        double d14 = signum2 / viewingConditions.getRgbD()[1];
        double d15 = signum3 / viewingConditions.getRgbD()[2];
        double[][] dArr2 = CAM16RGB_TO_XYZ;
        double[] dArr3 = dArr2[0];
        double d16 = (dArr3[0] * d13) + (dArr3[1] * d14) + (dArr3[2] * d15);
        double[] dArr4 = dArr2[1];
        double d17 = (dArr4[0] * d13) + (dArr4[1] * d14) + (dArr4[2] * d15);
        double[] dArr5 = dArr2[2];
        double d18 = (d13 * dArr5[0]) + (d14 * dArr5[1]) + (d15 * dArr5[2]);
        if (dArr != null) {
            dArr[0] = d16;
            dArr[1] = d17;
            dArr[2] = d18;
            return dArr;
        }
        return new double[]{d16, d17, d18};
    }
}
