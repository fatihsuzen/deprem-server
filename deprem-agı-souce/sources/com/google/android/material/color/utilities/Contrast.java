package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Contrast {
    private static final double CONTRAST_RATIO_EPSILON = 0.04d;
    private static final double LUMINANCE_GAMUT_MAP_TOLERANCE = 0.4d;
    public static final double RATIO_30 = 3.0d;
    public static final double RATIO_45 = 4.5d;
    public static final double RATIO_70 = 7.0d;
    public static final double RATIO_MAX = 21.0d;
    public static final double RATIO_MIN = 1.0d;

    private Contrast() {
    }

    public static double darker(double d5, double d6) {
        if (d5 >= 0.0d && d5 <= 100.0d) {
            double yFromLstar = ColorUtils.yFromLstar(d5);
            double d7 = ((yFromLstar + 5.0d) / d6) - 5.0d;
            if (d7 >= 0.0d && d7 <= 100.0d) {
                double ratioOfYs = ratioOfYs(yFromLstar, d7);
                double abs = Math.abs(ratioOfYs - d6);
                if (ratioOfYs < d6 && abs > CONTRAST_RATIO_EPSILON) {
                    return -1.0d;
                }
                double lstarFromY = ColorUtils.lstarFromY(d7) - LUMINANCE_GAMUT_MAP_TOLERANCE;
                if (lstarFromY < 0.0d || lstarFromY > 100.0d) {
                    return -1.0d;
                }
                return lstarFromY;
            }
        }
        return -1.0d;
    }

    public static double darkerUnsafe(double d5, double d6) {
        return Math.max(0.0d, darker(d5, d6));
    }

    public static double lighter(double d5, double d6) {
        if (d5 >= 0.0d && d5 <= 100.0d) {
            double yFromLstar = ColorUtils.yFromLstar(d5);
            double d7 = ((yFromLstar + 5.0d) * d6) - 5.0d;
            if (d7 >= 0.0d && d7 <= 100.0d) {
                double ratioOfYs = ratioOfYs(d7, yFromLstar);
                double abs = Math.abs(ratioOfYs - d6);
                if (ratioOfYs < d6 && abs > CONTRAST_RATIO_EPSILON) {
                    return -1.0d;
                }
                double lstarFromY = ColorUtils.lstarFromY(d7) + LUMINANCE_GAMUT_MAP_TOLERANCE;
                if (lstarFromY < 0.0d || lstarFromY > 100.0d) {
                    return -1.0d;
                }
                return lstarFromY;
            }
        }
        return -1.0d;
    }

    public static double lighterUnsafe(double d5, double d6) {
        double lighter = lighter(d5, d6);
        if (lighter < 0.0d) {
            return 100.0d;
        }
        return lighter;
    }

    public static double ratioOfTones(double d5, double d6) {
        return ratioOfYs(ColorUtils.yFromLstar(d5), ColorUtils.yFromLstar(d6));
    }

    public static double ratioOfYs(double d5, double d6) {
        double max = Math.max(d5, d6);
        if (max != d6) {
            d5 = d6;
        }
        return (max + 5.0d) / (d5 + 5.0d);
    }
}
