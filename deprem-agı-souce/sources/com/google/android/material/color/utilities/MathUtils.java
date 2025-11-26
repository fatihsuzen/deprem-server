package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MathUtils {
    private MathUtils() {
    }

    public static double clampDouble(double d5, double d6, double d7) {
        return d7 < d5 ? d5 : d7 > d6 ? d6 : d7;
    }

    public static int clampInt(int i5, int i6, int i7) {
        return i7 < i5 ? i5 : i7 > i6 ? i6 : i7;
    }

    public static double differenceDegrees(double d5, double d6) {
        return 180.0d - Math.abs(Math.abs(d5 - d6) - 180.0d);
    }

    public static double lerp(double d5, double d6, double d7) {
        return ((1.0d - d7) * d5) + (d7 * d6);
    }

    public static double[] matrixMultiply(double[] dArr, double[][] dArr2) {
        double d5 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d6 = dArr[1];
        double d7 = dArr[2];
        double d8 = (dArr3[0] * d5) + (dArr3[1] * d6) + (dArr3[2] * d7);
        double[] dArr4 = dArr2[1];
        double d9 = (dArr4[0] * d5) + (dArr4[1] * d6) + (dArr4[2] * d7);
        double[] dArr5 = dArr2[2];
        return new double[]{d8, d9, (d5 * dArr5[0]) + (d6 * dArr5[1]) + (d7 * dArr5[2])};
    }

    public static double rotationDirection(double d5, double d6) {
        if (sanitizeDegreesDouble(d6 - d5) <= 180.0d) {
            return 1.0d;
        }
        return -1.0d;
    }

    public static double sanitizeDegreesDouble(double d5) {
        double d6 = d5 % 360.0d;
        return d6 < 0.0d ? d6 + 360.0d : d6;
    }

    public static int sanitizeDegreesInt(int i5) {
        int i6 = i5 % 360;
        if (i6 < 0) {
            return i6 + 360;
        }
        return i6;
    }

    public static int signum(double d5) {
        if (d5 < 0.0d) {
            return -1;
        }
        return d5 == 0.0d ? 0 : 1;
    }
}
