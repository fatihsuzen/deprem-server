package androidx.core.graphics;

import android.graphics.Matrix;

public final class MatrixKt {
    public static final Matrix rotationMatrix(float f5, float f6, float f7) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f5, f6, f7);
        return matrix;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float f5, float f6, float f7, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            f6 = 0.0f;
        }
        if ((i5 & 4) != 0) {
            f7 = 0.0f;
        }
        return rotationMatrix(f5, f6, f7);
    }

    public static final Matrix scaleMatrix(float f5, float f6) {
        Matrix matrix = new Matrix();
        matrix.setScale(f5, f6);
        return matrix;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float f5, float f6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = 1.0f;
        }
        if ((i5 & 2) != 0) {
            f6 = 1.0f;
        }
        return scaleMatrix(f5, f6);
    }

    public static final Matrix times(Matrix matrix, Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.preConcat(matrix2);
        return matrix3;
    }

    public static final Matrix translationMatrix(float f5, float f6) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f5, f6);
        return matrix;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float f5, float f6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = 0.0f;
        }
        if ((i5 & 2) != 0) {
            f6 = 0.0f;
        }
        return translationMatrix(f5, f6);
    }

    public static final float[] values(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
