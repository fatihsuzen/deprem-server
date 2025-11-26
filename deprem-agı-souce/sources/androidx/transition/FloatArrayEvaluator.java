package androidx.transition;

import android.animation.TypeEvaluator;

class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    public float[] evaluate(float f5, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i5 = 0; i5 < fArr3.length; i5++) {
            float f6 = fArr[i5];
            fArr3[i5] = f6 + ((fArr2[i5] - f6) * f5);
        }
        return fArr3;
    }
}
