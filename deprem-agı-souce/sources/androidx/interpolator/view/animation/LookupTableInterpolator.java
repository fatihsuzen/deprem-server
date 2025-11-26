package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    protected LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f5) {
        if (f5 >= 1.0f) {
            return 1.0f;
        }
        if (f5 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f5), fArr.length - 2);
        float f6 = this.mStepSize;
        float f7 = (f5 - (((float) min) * f6)) / f6;
        float[] fArr2 = this.mValues;
        float f8 = fArr2[min];
        return f8 + (f7 * (fArr2[min + 1] - f8));
    }
}
