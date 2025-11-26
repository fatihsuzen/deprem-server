package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ReversableAnimatedValueInterpolator implements TimeInterpolator {
    private final TimeInterpolator sourceInterpolator;

    public ReversableAnimatedValueInterpolator(@NonNull TimeInterpolator timeInterpolator) {
        this.sourceInterpolator = timeInterpolator;
    }

    @NonNull
    public static TimeInterpolator of(boolean z4, @NonNull TimeInterpolator timeInterpolator) {
        if (z4) {
            return timeInterpolator;
        }
        return new ReversableAnimatedValueInterpolator(timeInterpolator);
    }

    public float getInterpolation(float f5) {
        return 1.0f - this.sourceInterpolator.getInterpolation(f5);
    }
}
