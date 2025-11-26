package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    private final float[] tempEndValues = new float[9];
    private final Matrix tempMatrix = new Matrix();
    private final float[] tempStartValues = new float[9];

    @NonNull
    public Matrix evaluate(float f5, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.tempStartValues);
        matrix2.getValues(this.tempEndValues);
        for (int i5 = 0; i5 < 9; i5++) {
            float[] fArr = this.tempEndValues;
            float f6 = fArr[i5];
            float f7 = this.tempStartValues[i5];
            fArr[i5] = f7 + ((f6 - f7) * f5);
        }
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }
}
