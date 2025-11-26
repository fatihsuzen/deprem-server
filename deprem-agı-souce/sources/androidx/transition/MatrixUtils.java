package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

class MatrixUtils {
    static final Matrix IDENTITY_MATRIX = new Matrix() {
        /* access modifiers changed from: package-private */
        public void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        public boolean postRotate(float f5, float f6, float f7) {
            oops();
            return false;
        }

        public boolean postScale(float f5, float f6, float f7, float f8) {
            oops();
            return false;
        }

        public boolean postSkew(float f5, float f6, float f7, float f8) {
            oops();
            return false;
        }

        public boolean postTranslate(float f5, float f6) {
            oops();
            return false;
        }

        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        public boolean preRotate(float f5, float f6, float f7) {
            oops();
            return false;
        }

        public boolean preScale(float f5, float f6, float f7, float f8) {
            oops();
            return false;
        }

        public boolean preSkew(float f5, float f6, float f7, float f8) {
            oops();
            return false;
        }

        public boolean preTranslate(float f5, float f6) {
            oops();
            return false;
        }

        public void reset() {
            oops();
        }

        public void set(Matrix matrix) {
            oops();
        }

        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        public boolean setPolyToPoly(float[] fArr, int i5, float[] fArr2, int i6, int i7) {
            oops();
            return false;
        }

        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        public void setRotate(float f5, float f6, float f7) {
            oops();
        }

        public void setScale(float f5, float f6, float f7, float f8) {
            oops();
        }

        public void setSinCos(float f5, float f6, float f7, float f8) {
            oops();
        }

        public void setSkew(float f5, float f6, float f7, float f8) {
            oops();
        }

        public void setTranslate(float f5, float f6) {
            oops();
        }

        public void setValues(float[] fArr) {
            oops();
        }

        public boolean postRotate(float f5) {
            oops();
            return false;
        }

        public boolean postScale(float f5, float f6) {
            oops();
            return false;
        }

        public boolean postSkew(float f5, float f6) {
            oops();
            return false;
        }

        public boolean preRotate(float f5) {
            oops();
            return false;
        }

        public boolean preScale(float f5, float f6) {
            oops();
            return false;
        }

        public boolean preSkew(float f5, float f6) {
            oops();
            return false;
        }

        public void setRotate(float f5) {
            oops();
        }

        public void setScale(float f5, float f6) {
            oops();
        }

        public void setSinCos(float f5, float f6) {
            oops();
        }

        public void setSkew(float f5, float f6) {
            oops();
        }
    };

    private MatrixUtils() {
    }
}
