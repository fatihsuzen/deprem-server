package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtils {
    public static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    public static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();

    public static float lerp(float f5, float f6, float f7) {
        return f5 + (f7 * (f6 - f5));
    }

    public static int lerp(int i5, int i6, float f5) {
        return i5 + Math.round(f5 * ((float) (i6 - i5)));
    }

    public static float lerp(float f5, float f6, float f7, float f8, float f9) {
        if (f9 <= f7) {
            return f5;
        }
        return f9 >= f8 ? f6 : lerp(f5, f6, (f9 - f7) / (f8 - f7));
    }
}
