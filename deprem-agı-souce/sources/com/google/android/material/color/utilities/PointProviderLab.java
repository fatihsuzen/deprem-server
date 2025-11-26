package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class PointProviderLab implements PointProvider {
    public double distance(double[] dArr, double[] dArr2) {
        double d5 = dArr[0] - dArr2[0];
        double d6 = dArr[1] - dArr2[1];
        double d7 = dArr[2] - dArr2[2];
        return (d5 * d5) + (d6 * d6) + (d7 * d7);
    }

    public double[] fromInt(int i5) {
        double[] labFromArgb = ColorUtils.labFromArgb(i5);
        return new double[]{labFromArgb[0], labFromArgb[1], labFromArgb[2]};
    }

    public int toInt(double[] dArr) {
        return ColorUtils.argbFromLab(dArr[0], dArr[1], dArr[2]);
    }
}
