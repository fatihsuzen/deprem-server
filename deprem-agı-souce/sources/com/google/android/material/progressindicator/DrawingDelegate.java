package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import java.util.Arrays;

abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    static final float WAVE_SMOOTHNESS = 0.48f;
    final PathMeasure activePathMeasure;
    final Path cachedActivePath;
    final Path displayedActivePath = new Path();
    S spec;
    final Matrix transform;

    protected static class ActiveIndicator {
        /* access modifiers changed from: package-private */
        @FloatRange(from = 0.0d, to = 1.0d)
        public float amplitudeFraction = 1.0f;
        @ColorInt
        int color;
        @FloatRange(from = 0.0d, to = 1.0d)
        float endFraction;
        @Px
        int gapSize;
        boolean isDeterminate;
        @FloatRange(from = 0.0d, to = 1.0d)
        float phaseFraction;
        float rotationDegree;
        @FloatRange(from = 0.0d, to = 1.0d)
        float startFraction;

        protected ActiveIndicator() {
        }
    }

    public DrawingDelegate(S s5) {
        Path path = new Path();
        this.cachedActivePath = path;
        this.activePathMeasure = new PathMeasure(path, false);
        this.spec = s5;
        this.transform = new Matrix();
    }

    /* access modifiers changed from: package-private */
    public abstract void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = -1.0d, to = 1.0d) float f5, boolean z4, boolean z5);

    /* access modifiers changed from: package-private */
    public abstract void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i5, @IntRange(from = 0, to = 255) int i6);

    /* access modifiers changed from: package-private */
    public abstract void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull ActiveIndicator activeIndicator, @IntRange(from = 0, to = 255) int i5);

    /* access modifiers changed from: package-private */
    public abstract void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6, @ColorInt int i5, @IntRange(from = 0, to = 255) int i6, @Px int i7);

    /* access modifiers changed from: package-private */
    public abstract int getPreferredHeight();

    /* access modifiers changed from: package-private */
    public abstract int getPreferredWidth();

    /* access modifiers changed from: package-private */
    public abstract void invalidateCachedPaths();

    /* access modifiers changed from: package-private */
    public void validateSpecAndAdjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f5, boolean z4, boolean z5) {
        this.spec.validateSpec();
        adjustCanvas(canvas, rect, f5, z4, z5);
    }

    /* access modifiers changed from: package-private */
    public float vectorToCanvasRotation(float[] fArr) {
        return (float) Math.toDegrees(Math.atan2((double) fArr[1], (double) fArr[0]));
    }

    protected class PathPoint {
        float[] posVec;
        float[] tanVec;
        final Matrix transform;

        public PathPoint() {
            this.posVec = new float[2];
            float[] fArr = new float[2];
            this.tanVec = fArr;
            fArr[0] = 1.0f;
            this.transform = new Matrix();
        }

        /* access modifiers changed from: package-private */
        public float distance(DrawingDelegate<S>.PathPoint pathPoint) {
            float[] fArr = pathPoint.posVec;
            float f5 = fArr[0];
            float[] fArr2 = this.posVec;
            return (float) Math.hypot((double) (f5 - fArr2[0]), (double) (fArr[1] - fArr2[1]));
        }

        /* access modifiers changed from: package-private */
        public void moveAcross(float f5) {
            float[] fArr = this.tanVec;
            float atan2 = (float) (Math.atan2((double) fArr[1], (double) fArr[0]) + 1.5707963267948966d);
            float[] fArr2 = this.posVec;
            double d5 = (double) f5;
            double d6 = (double) atan2;
            fArr2[0] = (float) (((double) fArr2[0]) + (Math.cos(d6) * d5));
            float[] fArr3 = this.posVec;
            fArr3[1] = (float) (((double) fArr3[1]) + (d5 * Math.sin(d6)));
        }

        /* access modifiers changed from: package-private */
        public void moveAlong(float f5) {
            float[] fArr = this.tanVec;
            float atan2 = (float) Math.atan2((double) fArr[1], (double) fArr[0]);
            float[] fArr2 = this.posVec;
            double d5 = (double) f5;
            double d6 = (double) atan2;
            fArr2[0] = (float) (((double) fArr2[0]) + (Math.cos(d6) * d5));
            float[] fArr3 = this.posVec;
            fArr3[1] = (float) (((double) fArr3[1]) + (d5 * Math.sin(d6)));
        }

        public void reset() {
            Arrays.fill(this.posVec, 0.0f);
            Arrays.fill(this.tanVec, 0.0f);
            this.tanVec[0] = 1.0f;
            this.transform.reset();
        }

        public void rotate(float f5) {
            this.transform.reset();
            this.transform.setRotate(f5);
            this.transform.mapPoints(this.posVec);
            this.transform.mapPoints(this.tanVec);
        }

        /* access modifiers changed from: package-private */
        public void scale(float f5, float f6) {
            float[] fArr = this.posVec;
            fArr[0] = fArr[0] * f5;
            fArr[1] = fArr[1] * f6;
            float[] fArr2 = this.tanVec;
            fArr2[0] = fArr2[0] * f5;
            fArr2[1] = fArr2[1] * f6;
        }

        /* access modifiers changed from: package-private */
        public void translate(float f5, float f6) {
            float[] fArr = this.posVec;
            fArr[0] = fArr[0] + f5;
            fArr[1] = fArr[1] + f6;
        }

        public PathPoint(DrawingDelegate drawingDelegate, DrawingDelegate<S>.PathPoint pathPoint) {
            this(pathPoint.posVec, pathPoint.tanVec);
        }

        public PathPoint(float[] fArr, float[] fArr2) {
            float[] fArr3 = new float[2];
            this.posVec = fArr3;
            this.tanVec = new float[2];
            System.arraycopy(fArr, 0, fArr3, 0, 2);
            System.arraycopy(fArr2, 0, this.tanVec, 0, 2);
            this.transform = new Matrix();
        }
    }
}
