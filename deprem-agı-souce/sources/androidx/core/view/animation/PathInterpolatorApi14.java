package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i5 = (int) (length / 0.002f);
        int i6 = i5 + 1;
        this.mX = new float[i6];
        this.mY = new float[i6];
        float[] fArr = new float[2];
        for (int i7 = 0; i7 < i6; i7++) {
            pathMeasure.getPosTan((((float) i7) * length) / ((float) i5), fArr, (float[]) null);
            this.mX[i7] = fArr[0];
            this.mY[i7] = fArr[1];
        }
    }

    private static Path createCubic(float f5, float f6, float f7, float f8) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f5, f6, f7, f8, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f5, float f6) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f5, f6, 1.0f, 1.0f);
        return path;
    }

    public float getInterpolation(float f5) {
        if (f5 <= 0.0f) {
            return 0.0f;
        }
        if (f5 >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i5 = 0;
        while (length - i5 > 1) {
            int i6 = (i5 + length) / 2;
            if (f5 < this.mX[i6]) {
                length = i6;
            } else {
                i5 = i6;
            }
        }
        float[] fArr = this.mX;
        float f6 = fArr[length];
        float f7 = fArr[i5];
        float f8 = f6 - f7;
        if (f8 == 0.0f) {
            return this.mY[i5];
        }
        float[] fArr2 = this.mY;
        float f9 = fArr2[i5];
        return f9 + (((f5 - f7) / f8) * (fArr2[length] - f9));
    }

    PathInterpolatorApi14(float f5, float f6) {
        this(createQuad(f5, f6));
    }

    PathInterpolatorApi14(float f5, float f6, float f7, float f8) {
        this(createCubic(f5, f6, f7, f8));
    }
}
