package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Pair;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.ArrayList;

final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private static final float QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH = 0.5522848f;
    private static final float ROUND_CAP_RAMP_DOWN_THRESHHOLD = 0.01f;
    private float adjustedRadius;
    private float adjustedWavelength;
    private final RectF arcBounds = new RectF();
    private float cachedAmplitude;
    private float cachedRadius;
    private int cachedWavelength;
    private float displayedAmplitude;
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private boolean drawingDeterminateIndicator;
    private final Pair<DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint> endPoints = new Pair<>(new DrawingDelegate.PathPoint(), new DrawingDelegate.PathPoint());
    @FloatRange(from = 0.0d, to = 1.0d)
    private float totalTrackLengthFraction;

    CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    private void appendCubicPerHalfCycle(@NonNull Path path, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint2) {
        float f5 = (this.adjustedWavelength / 2.0f) * 0.48f;
        DrawingDelegate.PathPoint pathPoint3 = new DrawingDelegate.PathPoint(this, pathPoint);
        DrawingDelegate.PathPoint pathPoint4 = new DrawingDelegate.PathPoint(this, pathPoint2);
        pathPoint3.moveAlong(f5);
        pathPoint4.moveAlong(-f5);
        float[] fArr = pathPoint3.posVec;
        float f6 = fArr[0];
        float f7 = fArr[1];
        float[] fArr2 = pathPoint4.posVec;
        float f8 = fArr2[0];
        float f9 = fArr2[1];
        float[] fArr3 = pathPoint2.posVec;
        path.cubicTo(f6, f7, f8, f9, fArr3[0], fArr3[1]);
    }

    private void calculateDisplayedPath(@NonNull PathMeasure pathMeasure, @NonNull Path path, @NonNull Pair<DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint> pair, float f5, float f6, float f7, float f8) {
        int i5;
        float f9 = this.displayedAmplitude * f7;
        if (this.drawingDeterminateIndicator) {
            i5 = ((CircularProgressIndicatorSpec) this.spec).wavelengthDeterminate;
        } else {
            i5 = ((CircularProgressIndicatorSpec) this.spec).wavelengthIndeterminate;
        }
        float f10 = this.adjustedRadius;
        if (f10 != this.cachedRadius || (pathMeasure == this.activePathMeasure && !(f9 == this.cachedAmplitude && i5 == this.cachedWavelength))) {
            this.cachedAmplitude = f9;
            this.cachedWavelength = i5;
            this.cachedRadius = f10;
            invalidateCachedPaths();
        }
        path.rewind();
        float f11 = 0.0f;
        float clamp = MathUtils.clamp(f6, 0.0f, 1.0f);
        if (((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            float f12 = f8 / ((float) ((((double) this.adjustedRadius) * 6.283185307179586d) / ((double) this.adjustedWavelength)));
            f5 += f12;
            f11 = 0.0f - (f12 * 360.0f);
        }
        float f13 = f5 % 1.0f;
        float length = (pathMeasure.getLength() * f13) / 2.0f;
        float length2 = ((f13 + clamp) * pathMeasure.getLength()) / 2.0f;
        pathMeasure.getSegment(length, length2, path, true);
        DrawingDelegate.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
        pathPoint.reset();
        pathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
        DrawingDelegate.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair.second;
        pathPoint2.reset();
        pathMeasure.getPosTan(length2, pathPoint2.posVec, pathPoint2.tanVec);
        this.transform.reset();
        this.transform.setRotate(f11);
        pathPoint.rotate(f11);
        pathPoint2.rotate(f11);
        path.transform(this.transform);
    }

    private void createWavyPath(@NonNull PathMeasure pathMeasure, @NonNull Path path, float f5) {
        int i5;
        path.rewind();
        float length = pathMeasure.getLength();
        if (this.drawingDeterminateIndicator) {
            i5 = ((CircularProgressIndicatorSpec) this.spec).wavelengthDeterminate;
        } else {
            i5 = ((CircularProgressIndicatorSpec) this.spec).wavelengthIndeterminate;
        }
        int max = Math.max(3, (int) ((length / ((float) i5)) / 2.0f)) * 2;
        this.adjustedWavelength = length / ((float) max);
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < max; i6++) {
            DrawingDelegate.PathPoint pathPoint = new DrawingDelegate.PathPoint();
            float f6 = (float) i6;
            pathMeasure.getPosTan(this.adjustedWavelength * f6, pathPoint.posVec, pathPoint.tanVec);
            DrawingDelegate.PathPoint pathPoint2 = new DrawingDelegate.PathPoint();
            float f7 = this.adjustedWavelength;
            pathMeasure.getPosTan((f6 * f7) + (f7 / 2.0f), pathPoint2.posVec, pathPoint2.tanVec);
            arrayList.add(pathPoint);
            pathPoint2.moveAcross(f5 * 2.0f);
            arrayList.add(pathPoint2);
        }
        arrayList.add((DrawingDelegate.PathPoint) arrayList.get(0));
        DrawingDelegate.PathPoint pathPoint3 = (DrawingDelegate.PathPoint) arrayList.get(0);
        float[] fArr = pathPoint3.posVec;
        int i7 = 1;
        path.moveTo(fArr[0], fArr[1]);
        while (i7 < arrayList.size()) {
            DrawingDelegate.PathPoint pathPoint4 = (DrawingDelegate.PathPoint) arrayList.get(i7);
            appendCubicPerHalfCycle(path, pathPoint3, pathPoint4);
            i7++;
            pathPoint3 = pathPoint4;
        }
    }

    private void drawArc(@NonNull Canvas canvas, @NonNull Paint paint, float f5, float f6, @ColorInt int i5, @Px int i6, @Px int i7, float f7, float f8, boolean z4) {
        float f9;
        boolean z5;
        Paint.Cap cap;
        if (f6 >= f5) {
            f9 = f6 - f5;
        } else {
            f9 = (f6 + 1.0f) - f5;
        }
        float f10 = f5 % 1.0f;
        if (f10 < 0.0f) {
            f10 += 1.0f;
        }
        if (this.totalTrackLengthFraction < 1.0f) {
            float f11 = f10 + f9;
            if (f11 > 1.0f) {
                Canvas canvas2 = canvas;
                Paint paint2 = paint;
                int i8 = i5;
                float f12 = f7;
                float f13 = f8;
                boolean z6 = z4;
                drawArc(canvas2, paint2, f10, 1.0f, i8, i6, 0, f12, f13, z6);
                drawArc(canvas2, paint2, 1.0f, f11, i8, 0, i7, f12, f13, z6);
                return;
            }
        }
        float degrees = (float) Math.toDegrees((double) (this.displayedCornerRadius / this.adjustedRadius));
        float f14 = f9 - 0.99f;
        if (f14 >= 0.0f) {
            float f15 = ((f14 * degrees) / 180.0f) / ROUND_CAP_RAMP_DOWN_THRESHHOLD;
            f9 += f15;
            if (!z4) {
                f10 -= f15 / 2.0f;
            }
        }
        float lerp = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, f10);
        float lerp2 = com.google.android.material.math.MathUtils.lerp(0.0f, this.totalTrackLengthFraction, f9);
        float degrees2 = (float) Math.toDegrees((double) (((float) i6) / this.adjustedRadius));
        float degrees3 = ((lerp2 * 360.0f) - degrees2) - ((float) Math.toDegrees((double) (((float) i7) / this.adjustedRadius)));
        float f16 = (lerp * 360.0f) + degrees2;
        if (degrees3 > 0.0f) {
            if (!((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator) || !z4 || f7 <= 0.0f) {
                z5 = false;
            } else {
                z5 = true;
            }
            paint.setAntiAlias(true);
            paint.setColor(i5);
            paint.setStrokeWidth(this.displayedTrackThickness);
            float f17 = this.displayedCornerRadius * 2.0f;
            float f18 = degrees * 2.0f;
            if (degrees3 < f18) {
                float f19 = degrees3 / f18;
                float f20 = f16 + (degrees * f19);
                DrawingDelegate.PathPoint pathPoint = new DrawingDelegate.PathPoint();
                if (!z5) {
                    pathPoint.rotate(f20 + 90.0f);
                    pathPoint.moveAcross(-this.adjustedRadius);
                } else {
                    float length = ((f20 / 360.0f) * this.activePathMeasure.getLength()) / 2.0f;
                    float f21 = this.displayedAmplitude * f7;
                    float f22 = this.adjustedRadius;
                    if (!(f22 == this.cachedRadius && f21 == this.cachedAmplitude)) {
                        this.cachedAmplitude = f21;
                        this.cachedRadius = f22;
                        invalidateCachedPaths();
                    }
                    this.activePathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
                }
                paint.setStyle(Paint.Style.FILL);
                drawRoundedBlock(canvas, paint, pathPoint, f17, this.displayedTrackThickness, f19);
                return;
            }
            float f23 = f17;
            paint.setStyle(Paint.Style.STROKE);
            if (((CircularProgressIndicatorSpec) this.spec).useStrokeCap()) {
                cap = Paint.Cap.ROUND;
            } else {
                cap = Paint.Cap.BUTT;
            }
            paint.setStrokeCap(cap);
            float f24 = f16 + degrees;
            float f25 = degrees3 - f18;
            ((DrawingDelegate.PathPoint) this.endPoints.first).reset();
            ((DrawingDelegate.PathPoint) this.endPoints.second).reset();
            if (!z5) {
                ((DrawingDelegate.PathPoint) this.endPoints.first).rotate(f24 + 90.0f);
                ((DrawingDelegate.PathPoint) this.endPoints.first).moveAcross(-this.adjustedRadius);
                ((DrawingDelegate.PathPoint) this.endPoints.second).rotate(f24 + f25 + 90.0f);
                ((DrawingDelegate.PathPoint) this.endPoints.second).moveAcross(-this.adjustedRadius);
                RectF rectF = this.arcBounds;
                float f26 = this.adjustedRadius;
                rectF.set(-f26, -f26, f26, f26);
                RectF rectF2 = this.arcBounds;
                canvas.drawArc(rectF2, f24, f25, false, paint);
            } else {
                float f27 = f25;
                calculateDisplayedPath(this.activePathMeasure, this.displayedActivePath, this.endPoints, f24 / 360.0f, f27 / 360.0f, f7, f8);
                canvas.drawPath(this.displayedActivePath, paint);
            }
            if (!((CircularProgressIndicatorSpec) this.spec).useStrokeCap() && this.displayedCornerRadius > 0.0f) {
                paint.setStyle(Paint.Style.FILL);
                Canvas canvas3 = canvas;
                Paint paint3 = paint;
                float f28 = f23;
                drawRoundedBlock(canvas3, paint3, (DrawingDelegate.PathPoint) this.endPoints.first, f28, this.displayedTrackThickness);
                drawRoundedBlock(canvas3, paint3, (DrawingDelegate.PathPoint) this.endPoints.second, f28, this.displayedTrackThickness);
            }
        }
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, float f5, float f6) {
        drawRoundedBlock(canvas, paint, pathPoint, f5, f6, 1.0f);
    }

    private int getSize() {
        S s5 = this.spec;
        return ((CircularProgressIndicatorSpec) s5).indicatorSize + (((CircularProgressIndicatorSpec) s5).indicatorInset * 2);
    }

    /* access modifiers changed from: package-private */
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f5, boolean z4, boolean z5) {
        float width = ((float) rect.width()) / ((float) getPreferredWidth());
        float height = ((float) rect.height()) / ((float) getPreferredHeight());
        S s5 = this.spec;
        float f6 = (((float) ((CircularProgressIndicatorSpec) s5).indicatorSize) / 2.0f) + ((float) ((CircularProgressIndicatorSpec) s5).indicatorInset);
        canvas.translate((f6 * width) + ((float) rect.left), (f6 * height) + ((float) rect.top));
        canvas.rotate(-90.0f);
        canvas.scale(width, height);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) {
            canvas.scale(1.0f, -1.0f);
            if (Build.VERSION.SDK_INT == 29) {
                canvas.rotate(0.1f);
            }
        }
        float f7 = -f6;
        canvas.clipRect(f7, f7, f6, f6);
        S s6 = this.spec;
        this.displayedTrackThickness = ((float) ((CircularProgressIndicatorSpec) s6).trackThickness) * f5;
        this.displayedCornerRadius = ((float) Math.min(((CircularProgressIndicatorSpec) s6).trackThickness / 2, ((CircularProgressIndicatorSpec) s6).getTrackCornerRadiusInPx())) * f5;
        S s7 = this.spec;
        this.displayedAmplitude = ((float) ((CircularProgressIndicatorSpec) s7).waveAmplitude) * f5;
        float f8 = ((float) (((CircularProgressIndicatorSpec) s7).indicatorSize - ((CircularProgressIndicatorSpec) s7).trackThickness)) / 2.0f;
        this.adjustedRadius = f8;
        if (z4 || z5) {
            float f9 = ((1.0f - f5) * ((float) ((CircularProgressIndicatorSpec) s7).trackThickness)) / 2.0f;
            if ((z4 && ((CircularProgressIndicatorSpec) s7).showAnimationBehavior == 2) || (z5 && ((CircularProgressIndicatorSpec) s7).hideAnimationBehavior == 1)) {
                this.adjustedRadius = f8 + f9;
            } else if ((z4 && ((CircularProgressIndicatorSpec) s7).showAnimationBehavior == 1) || (z5 && ((CircularProgressIndicatorSpec) s7).hideAnimationBehavior == 2)) {
                this.adjustedRadius = f8 - f9;
            }
        }
        if (!z5 || ((CircularProgressIndicatorSpec) s7).hideAnimationBehavior != 3) {
            this.totalTrackLengthFraction = 1.0f;
        } else {
            this.totalTrackLengthFraction = f5;
        }
    }

    /* access modifiers changed from: package-private */
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i5, @IntRange(from = 0, to = 255) int i6) {
    }

    /* access modifiers changed from: package-private */
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, @IntRange(from = 0, to = 255) int i5) {
        DrawingDelegate.ActiveIndicator activeIndicator2 = activeIndicator;
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator2.color, i5);
        canvas.save();
        canvas.rotate(activeIndicator2.rotationDegree);
        this.drawingDeterminateIndicator = activeIndicator2.isDeterminate;
        float f5 = activeIndicator2.startFraction;
        float f6 = activeIndicator2.endFraction;
        int i6 = activeIndicator2.gapSize;
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        drawArc(canvas2, paint2, f5, f6, compositeARGBWithAlpha, i6, i6, activeIndicator2.amplitudeFraction, activeIndicator2.phaseFraction, true);
        canvas.restore();
    }

    /* access modifiers changed from: package-private */
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f5, float f6, @ColorInt int i5, @IntRange(from = 0, to = 255) int i6, int i7) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i5, i6);
        this.drawingDeterminateIndicator = false;
        drawArc(canvas, paint, f5, f6, compositeARGBWithAlpha, i7, i7, 0.0f, 0.0f, false);
    }

    /* access modifiers changed from: package-private */
    public int getPreferredHeight() {
        return getSize();
    }

    /* access modifiers changed from: package-private */
    public int getPreferredWidth() {
        return getSize();
    }

    /* access modifiers changed from: package-private */
    public void invalidateCachedPaths() {
        this.cachedActivePath.rewind();
        this.cachedActivePath.moveTo(1.0f, 0.0f);
        for (int i5 = 0; i5 < 2; i5++) {
            this.cachedActivePath.cubicTo(1.0f, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, 1.0f, 0.0f, 1.0f);
            this.cachedActivePath.cubicTo(-0.5522848f, 1.0f, -1.0f, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, -1.0f, 0.0f);
            this.cachedActivePath.cubicTo(-1.0f, -0.5522848f, -0.5522848f, -1.0f, 0.0f, -1.0f);
            this.cachedActivePath.cubicTo(QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, -1.0f, 1.0f, -0.5522848f, 1.0f, 0.0f);
        }
        this.transform.reset();
        Matrix matrix = this.transform;
        float f5 = this.adjustedRadius;
        matrix.setScale(f5, f5);
        this.cachedActivePath.transform(this.transform);
        if (((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            this.activePathMeasure.setPath(this.cachedActivePath, false);
            createWavyPath(this.activePathMeasure, this.cachedActivePath, this.cachedAmplitude);
        }
        this.activePathMeasure.setPath(this.cachedActivePath, false);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, float f5, float f6, float f7) {
        float min = Math.min(f6, this.displayedTrackThickness);
        float f8 = f5 / 2.0f;
        float min2 = Math.min(f8, (this.displayedCornerRadius * min) / this.displayedTrackThickness);
        RectF rectF = new RectF((-f5) / 2.0f, (-min) / 2.0f, f8, min / 2.0f);
        canvas.save();
        float[] fArr = pathPoint.posVec;
        canvas.translate(fArr[0], fArr[1]);
        canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
        canvas.scale(f7, f7);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }
}
