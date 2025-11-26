package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
class FadeModeEvaluators {
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f5, float f6, float f7, float f8) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f6, f7, f5), TransitionUtils.lerp(0, 255, f6, f7, f5));
        }
    };
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f5, float f6, float f7, float f8) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f6, f7, f5));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f5, float f6, float f7, float f8) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f6, f7, f5), 255);
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f5, float f6, float f7, float f8) {
            float f9 = ((f7 - f6) * f8) + f6;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f6, f9, f5), TransitionUtils.lerp(0, 255, f9, f7, f5));
        }
    };

    private FadeModeEvaluators() {
    }

    static FadeModeEvaluator get(int i5, boolean z4) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    return CROSS;
                }
                if (i5 == 3) {
                    return THROUGH;
                }
                throw new IllegalArgumentException("Invalid fade mode: " + i5);
            } else if (z4) {
                return OUT;
            } else {
                return IN;
            }
        } else if (z4) {
            return IN;
        } else {
            return OUT;
        }
    }
}
