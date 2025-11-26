package com.google.android.material.internal;

import androidx.annotation.FloatRange;

final class FadeThroughUtils {
    static final float THRESHOLD_ALPHA = 0.5f;

    private FadeThroughUtils() {
    }

    static void calculateFadeOutAndInAlphas(@FloatRange(from = 0.0d, to = 1.0d) float f5, float[] fArr) {
        if (f5 <= 0.5f) {
            fArr[0] = 1.0f - (f5 * 2.0f);
            fArr[1] = 0.0f;
            return;
        }
        fArr[0] = 0.0f;
        fArr[1] = (f5 * 2.0f) - 1.0f;
    }
}
