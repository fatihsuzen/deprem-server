package com.google.android.material.transition;

import android.graphics.RectF;

class FitModeEvaluators {
    private static final FitModeEvaluator HEIGHT = new FitModeEvaluator() {
        public void applyMask(RectF rectF, float f5, FitModeResult fitModeResult) {
            float abs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f5;
            rectF.left += abs;
            rectF.right -= abs;
        }

        public FitModeResult evaluate(float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
            float f12 = f9;
            float f13 = f11;
            float lerp = TransitionUtils.lerp(f12, f13, f6, f7, f5, true);
            float f14 = lerp / f12;
            float f15 = lerp / f13;
            return new FitModeResult(f14, f15, f8 * f14, lerp, f10 * f15, lerp);
        }

        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            if (fitModeResult.currentStartWidth > fitModeResult.currentEndWidth) {
                return true;
            }
            return false;
        }
    };
    private static final FitModeEvaluator WIDTH = new FitModeEvaluator() {
        public void applyMask(RectF rectF, float f5, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f5;
        }

        public FitModeResult evaluate(float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
            float f12 = f8;
            float f13 = f10;
            float lerp = TransitionUtils.lerp(f12, f13, f6, f7, f5, true);
            float f14 = lerp / f12;
            float f15 = lerp / f13;
            return new FitModeResult(f14, f15, lerp, f9 * f14, lerp, f11 * f15);
        }

        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            if (fitModeResult.currentStartHeight > fitModeResult.currentEndHeight) {
                return true;
            }
            return false;
        }
    };

    private FitModeEvaluators() {
    }

    static FitModeEvaluator get(int i5, boolean z4, RectF rectF, RectF rectF2) {
        if (i5 != 0) {
            if (i5 == 1) {
                return WIDTH;
            }
            if (i5 == 2) {
                return HEIGHT;
            }
            throw new IllegalArgumentException("Invalid fit mode: " + i5);
        } else if (shouldAutoFitToWidth(z4, rectF, rectF2)) {
            return WIDTH;
        } else {
            return HEIGHT;
        }
    }

    private static boolean shouldAutoFitToWidth(boolean z4, RectF rectF, RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f5 = (height2 * width) / width2;
        float f6 = (width2 * height) / width;
        if (z4) {
            if (f5 >= height) {
                return true;
            }
            return false;
        } else if (f6 >= height2) {
            return true;
        } else {
            return false;
        }
    }
}
