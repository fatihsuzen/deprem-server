package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ContrastCurve {
    private final double high;
    private final double low;
    private final double medium;
    private final double normal;

    public ContrastCurve(double d5, double d6, double d7, double d8) {
        this.low = d5;
        this.normal = d6;
        this.medium = d7;
        this.high = d8;
    }

    public double get(double d5) {
        if (d5 <= -1.0d) {
            return this.low;
        }
        if (d5 < 0.0d) {
            return MathUtils.lerp(this.low, this.normal, (d5 - -1.0d) / 1.0d);
        }
        if (d5 < 0.5d) {
            return MathUtils.lerp(this.normal, this.medium, (d5 - 0.0d) / 0.5d);
        }
        if (d5 < 1.0d) {
            return MathUtils.lerp(this.medium, this.high, (d5 - 0.5d) / 0.5d);
        }
        return this.high;
    }
}
