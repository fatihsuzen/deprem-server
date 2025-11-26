package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ColorUtils {
    static final double[][] SRGB_TO_XYZ = {new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};
    static final double[] WHITE_POINT_D65 = {95.047d, 100.0d, 108.883d};
    static final double[][] XYZ_TO_SRGB = {new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};

    private ColorUtils() {
    }

    public static int alphaFromArgb(int i5) {
        return (i5 >> 24) & 255;
    }

    public static int argbFromLab(double d5, double d6, double d7) {
        double[] dArr = WHITE_POINT_D65;
        double d8 = (d5 + 16.0d) / 116.0d;
        double d9 = d8 - (d7 / 200.0d);
        return argbFromXyz(labInvf((d6 / 500.0d) + d8) * dArr[0], labInvf(d8) * dArr[1], labInvf(d9) * dArr[2]);
    }

    public static int argbFromLinrgb(double[] dArr) {
        return argbFromRgb(delinearized(dArr[0]), delinearized(dArr[1]), delinearized(dArr[2]));
    }

    public static int argbFromLstar(double d5) {
        int delinearized = delinearized(yFromLstar(d5));
        return argbFromRgb(delinearized, delinearized, delinearized);
    }

    public static int argbFromRgb(int i5, int i6, int i7) {
        return ((i5 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((i6 & 255) << 8) | (i7 & 255);
    }

    public static int argbFromXyz(double d5, double d6, double d7) {
        double[][] dArr = XYZ_TO_SRGB;
        double[] dArr2 = dArr[0];
        double d8 = (dArr2[0] * d5) + (dArr2[1] * d6) + (dArr2[2] * d7);
        double[] dArr3 = dArr[1];
        double[] dArr4 = dArr[2];
        return argbFromRgb(delinearized(d8), delinearized((dArr3[0] * d5) + (dArr3[1] * d6) + (dArr3[2] * d7)), delinearized((dArr4[0] * d5) + (dArr4[1] * d6) + (dArr4[2] * d7)));
    }

    public static int blueFromArgb(int i5) {
        return i5 & 255;
    }

    public static int delinearized(double d5) {
        double d6;
        double d7 = d5 / 100.0d;
        if (d7 <= 0.0031308d) {
            d6 = d7 * 12.92d;
        } else {
            d6 = (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d;
        }
        return MathUtils.clampInt(0, 255, (int) Math.round(d6 * 255.0d));
    }

    public static int greenFromArgb(int i5) {
        return (i5 >> 8) & 255;
    }

    public static boolean isOpaque(int i5) {
        if (alphaFromArgb(i5) >= 255) {
            return true;
        }
        return false;
    }

    static double labF(double d5) {
        if (d5 > 0.008856451679035631d) {
            return Math.pow(d5, 0.3333333333333333d);
        }
        return ((d5 * 903.2962962962963d) + 16.0d) / 116.0d;
    }

    public static double[] labFromArgb(int i5) {
        double linearized = linearized(redFromArgb(i5));
        double linearized2 = linearized(greenFromArgb(i5));
        double linearized3 = linearized(blueFromArgb(i5));
        double[][] dArr = SRGB_TO_XYZ;
        double[] dArr2 = dArr[0];
        double d5 = (dArr2[0] * linearized) + (dArr2[1] * linearized2) + (dArr2[2] * linearized3);
        double[] dArr3 = dArr[1];
        double d6 = (dArr3[0] * linearized) + (dArr3[1] * linearized2) + (dArr3[2] * linearized3);
        double[] dArr4 = dArr[2];
        double d7 = (dArr4[0] * linearized) + (dArr4[1] * linearized2) + (dArr4[2] * linearized3);
        double[] dArr5 = WHITE_POINT_D65;
        double d8 = d5 / dArr5[0];
        double d9 = d6 / dArr5[1];
        double labF = labF(d8);
        double labF2 = labF(d9);
        return new double[]{(116.0d * labF2) - 16.0d, (labF - labF2) * 500.0d, (labF2 - labF(d7 / dArr5[2])) * 200.0d};
    }

    static double labInvf(double d5) {
        double d6 = d5 * d5 * d5;
        return d6 > 0.008856451679035631d ? d6 : ((d5 * 116.0d) - 16.0d) / 903.2962962962963d;
    }

    public static double linearized(int i5) {
        double pow;
        double d5 = ((double) i5) / 255.0d;
        if (d5 <= 0.040449936d) {
            pow = d5 / 12.92d;
        } else {
            pow = Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
        }
        return pow * 100.0d;
    }

    public static double lstarFromArgb(int i5) {
        return (labF(xyzFromArgb(i5)[1] / 100.0d) * 116.0d) - 16.0d;
    }

    public static double lstarFromY(double d5) {
        return (labF(d5 / 100.0d) * 116.0d) - 16.0d;
    }

    public static int redFromArgb(int i5) {
        return (i5 >> 16) & 255;
    }

    public static double[] whitePointD65() {
        return WHITE_POINT_D65;
    }

    public static double[] xyzFromArgb(int i5) {
        return MathUtils.matrixMultiply(new double[]{linearized(redFromArgb(i5)), linearized(greenFromArgb(i5)), linearized(blueFromArgb(i5))}, SRGB_TO_XYZ);
    }

    public static double yFromLstar(double d5) {
        return labInvf((d5 + 16.0d) / 116.0d) * 100.0d;
    }
}
