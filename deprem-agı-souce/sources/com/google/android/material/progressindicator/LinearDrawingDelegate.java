package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.DrawingDelegate;

final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float adjustedWavelength;
    private int cachedWavelength;
    private float displayedAmplitude;
    private float displayedCornerRadius;
    private float displayedInnerCornerRadius;
    private float displayedTrackThickness;
    private boolean drawingDeterminateIndicator;
    Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> endPoints = new Pair<>(new DrawingDelegate.PathPoint(), new DrawingDelegate.PathPoint());
    @FloatRange(from = 0.0d, to = 1.0d)
    private float totalTrackLengthFraction;
    private float trackLength = 300.0f;

    LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
    }

    private void calculateDisplayedPath(@NonNull PathMeasure pathMeasure, @NonNull Path path, @NonNull Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair, float f5, float f6, float f7, float f8) {
        int i5;
        if (this.drawingDeterminateIndicator) {
            i5 = ((LinearProgressIndicatorSpec) this.spec).wavelengthDeterminate;
        } else {
            i5 = ((LinearProgressIndicatorSpec) this.spec).wavelengthIndeterminate;
        }
        if (pathMeasure == this.activePathMeasure && i5 != this.cachedWavelength) {
            this.cachedWavelength = i5;
            invalidateCachedPaths();
        }
        path.rewind();
        float f9 = (-this.trackLength) / 2.0f;
        boolean hasWavyEffect = ((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator);
        if (hasWavyEffect) {
            float f10 = this.trackLength;
            float f11 = this.adjustedWavelength;
            float f12 = f10 / f11;
            float f13 = f8 / f12;
            float f14 = f12 / (f12 + 1.0f);
            f5 = (f5 + f13) * f14;
            f6 = (f6 + f13) * f14;
            f9 -= f8 * f11;
        }
        float length = f5 * pathMeasure.getLength();
        float length2 = f6 * pathMeasure.getLength();
        pathMeasure.getSegment(length, length2, path, true);
        DrawingDelegate.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
        pathPoint.reset();
        pathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
        DrawingDelegate.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair.second;
        pathPoint2.reset();
        pathMeasure.getPosTan(length2, pathPoint2.posVec, pathPoint2.tanVec);
        this.transform.reset();
        this.transform.setTranslate(f9, 0.0f);
        pathPoint.translate(f9, 0.0f);
        pathPoint2.translate(f9, 0.0f);
        if (hasWavyEffect) {
            float f15 = this.displayedAmplitude * f7;
            this.transform.postScale(1.0f, f15);
            pathPoint.scale(1.0f, f15);
            pathPoint2.scale(1.0f, f15);
        }
        path.transform(this.transform);
    }

    private void drawLine(@NonNull Canvas canvas, @NonNull Paint paint, float f5, float f6, @ColorInt int i5, @Px int i6, @Px int i7, float f7, float f8, boolean z4) {
        float f9;
        float f10;
        boolean z5;
        Paint.Cap cap;
        Paint paint2;
        Canvas canvas2;
        Paint paint3 = paint;
        float clamp = MathUtils.clamp(f5, 0.0f, 1.0f);
        float clamp2 = MathUtils.clamp(f6, 0.0f, 1.0f);
        float lerp = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, clamp);
        float lerp2 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, clamp2);
        float f11 = this.trackLength;
        int clamp3 = (int) ((lerp * f11) + ((float) ((int) ((((float) i6) * MathUtils.clamp(lerp, 0.0f, 0.01f)) / 0.01f))));
        int clamp4 = (int) ((lerp2 * f11) - ((float) ((int) ((((float) i7) * (1.0f - MathUtils.clamp(lerp2, 0.99f, 1.0f))) / 0.01f))));
        float f12 = this.displayedCornerRadius;
        float f13 = this.displayedInnerCornerRadius;
        if (f12 != f13) {
            float max = Math.max(f12, f13);
            float f14 = this.trackLength;
            float f15 = max / f14;
            float lerp3 = com.google.android.material.math.MathUtils.lerp(this.displayedCornerRadius, this.displayedInnerCornerRadius, MathUtils.clamp(((float) clamp3) / f14, 0.0f, f15) / f15);
            float f16 = this.displayedCornerRadius;
            float f17 = this.displayedInnerCornerRadius;
            float f18 = this.trackLength;
            f9 = com.google.android.material.math.MathUtils.lerp(f16, f17, MathUtils.clamp((f18 - ((float) clamp4)) / f18, 0.0f, f15) / f15);
            f10 = lerp3;
        } else {
            f10 = f12;
            f9 = f10;
        }
        float f19 = (-this.trackLength) / 2.0f;
        if (!((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator) || !z4 || f7 <= 0.0f) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (clamp3 <= clamp4) {
            float f20 = ((float) clamp3) + f10;
            float f21 = ((float) clamp4) - f9;
            float f22 = f19;
            float f23 = f10 * 2.0f;
            float f24 = 2.0f * f9;
            paint3.setColor(i5);
            paint3.setAntiAlias(true);
            paint3.setStrokeWidth(this.displayedTrackThickness);
            ((DrawingDelegate.PathPoint) this.endPoints.first).reset();
            ((DrawingDelegate.PathPoint) this.endPoints.second).reset();
            ((DrawingDelegate.PathPoint) this.endPoints.first).translate(f20 + f22, 0.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.second).translate(f22 + f21, 0.0f);
            if (clamp3 != 0 || f21 + f9 >= f20 + f10) {
                float f25 = f24;
                if (f20 - f10 > f21 - f9) {
                    Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair = this.endPoints;
                    float f26 = this.displayedTrackThickness;
                    float f27 = f9;
                    float f28 = f10;
                    float f29 = f23;
                    float f30 = f25;
                    Canvas canvas3 = canvas;
                    drawRoundedBlock(canvas3, paint, (DrawingDelegate.PathPoint) pair.second, f30, f26, f27, (DrawingDelegate.PathPoint) pair.first, f29, f26, f28, false);
                    return;
                }
                Paint paint4 = paint;
                float f31 = f25;
                float f32 = f23;
                float f33 = f9;
                float f34 = f10;
                paint4.setStyle(Paint.Style.STROKE);
                if (((LinearProgressIndicatorSpec) this.spec).useStrokeCap()) {
                    cap = Paint.Cap.ROUND;
                } else {
                    cap = Paint.Cap.BUTT;
                }
                paint4.setStrokeCap(cap);
                if (!z5) {
                    Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair2 = this.endPoints;
                    Object obj = pair2.first;
                    float f35 = ((DrawingDelegate.PathPoint) obj).posVec[0];
                    float f36 = ((DrawingDelegate.PathPoint) obj).posVec[1];
                    Object obj2 = pair2.second;
                    Paint paint5 = paint4;
                    canvas.drawLine(f35, f36, ((DrawingDelegate.PathPoint) obj2).posVec[0], ((DrawingDelegate.PathPoint) obj2).posVec[1], paint5);
                    paint2 = paint5;
                    canvas2 = canvas;
                } else {
                    paint2 = paint4;
                    PathMeasure pathMeasure = this.activePathMeasure;
                    Path path = this.displayedActivePath;
                    Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair3 = this.endPoints;
                    float f37 = this.trackLength;
                    calculateDisplayedPath(pathMeasure, path, pair3, f20 / f37, f21 / f37, f7, f8);
                    canvas2 = canvas;
                    canvas2.drawPath(this.displayedActivePath, paint2);
                }
                if (!((LinearProgressIndicatorSpec) this.spec).useStrokeCap()) {
                    if (f20 > 0.0f && f34 > 0.0f) {
                        drawRoundedBlock(canvas2, paint2, (DrawingDelegate.PathPoint) this.endPoints.first, f32, this.displayedTrackThickness, f34);
                    }
                    if (f21 < this.trackLength && f33 > 0.0f) {
                        drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) this.endPoints.second, f31, this.displayedTrackThickness, f33);
                        return;
                    }
                    return;
                }
                return;
            }
            Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair4 = this.endPoints;
            float f38 = f24;
            float f39 = this.displayedTrackThickness;
            drawRoundedBlock(canvas, paint3, (DrawingDelegate.PathPoint) pair4.first, f23, f39, f10, (DrawingDelegate.PathPoint) pair4.second, f38, f39, f9, true);
        }
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint, float f5, float f6, float f7) {
        drawRoundedBlock(canvas, paint, pathPoint, f5, f6, f7, (DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint) null, 0.0f, 0.0f, 0.0f, false);
    }

    /* access modifiers changed from: package-private */
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f5, boolean z4, boolean z5) {
        if (this.trackLength != ((float) rect.width())) {
            this.trackLength = (float) rect.width();
            invalidateCachedPaths();
        }
        float preferredHeight = (float) getPreferredHeight();
        canvas.translate(((float) rect.left) + (((float) rect.width()) / 2.0f), ((float) rect.top) + (((float) rect.height()) / 2.0f) + Math.max(0.0f, (((float) rect.height()) - preferredHeight) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f6 = this.trackLength / 2.0f;
        float f7 = preferredHeight / 2.0f;
        canvas.clipRect(-f6, -f7, f6, f7);
        S s5 = this.spec;
        this.displayedTrackThickness = ((float) ((LinearProgressIndicatorSpec) s5).trackThickness) * f5;
        this.displayedCornerRadius = ((float) Math.min(((LinearProgressIndicatorSpec) s5).trackThickness / 2, ((LinearProgressIndicatorSpec) s5).getTrackCornerRadiusInPx())) * f5;
        S s6 = this.spec;
        this.displayedAmplitude = ((float) ((LinearProgressIndicatorSpec) s6).waveAmplitude) * f5;
        this.displayedInnerCornerRadius = Math.min(((float) ((LinearProgressIndicatorSpec) s6).trackThickness) / 2.0f, (float) ((LinearProgressIndicatorSpec) s6).getTrackInnerCornerRadiusInPx()) * f5;
        if (z4 || z5) {
            if ((z4 && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (z5 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z4 || (z5 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3)) {
                canvas.translate(0.0f, (((float) ((LinearProgressIndicatorSpec) this.spec).trackThickness) * (1.0f - f5)) / 2.0f);
            }
        }
        if (!z5 || ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3) {
            this.totalTrackLengthFraction = 1.0f;
        } else {
            this.totalTrackLengthFraction = f5;
        }
    }

    /* access modifiers changed from: package-private */
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i5, @IntRange(from = 0, to = 255) int i6) {
        float f5;
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i5, i6);
        this.drawingDeterminateIndicator = false;
        if (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize > 0 && compositeARGBWithAlpha != 0) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(compositeARGBWithAlpha);
            S s5 = this.spec;
            if (((LinearProgressIndicatorSpec) s5).trackStopIndicatorPadding != null) {
                f5 = ((LinearProgressIndicatorSpec) s5).trackStopIndicatorPadding.floatValue() + (((float) ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize) / 2.0f);
            } else {
                f5 = this.displayedTrackThickness / 2.0f;
            }
            DrawingDelegate.PathPoint pathPoint = new DrawingDelegate.PathPoint(new float[]{(this.trackLength / 2.0f) - f5, 0.0f}, new float[]{1.0f, 0.0f});
            S s6 = this.spec;
            drawRoundedBlock(canvas, paint, pathPoint, (float) ((LinearProgressIndicatorSpec) s6).trackStopIndicatorSize, (float) ((LinearProgressIndicatorSpec) s6).trackStopIndicatorSize, (this.displayedCornerRadius * ((float) ((LinearProgressIndicatorSpec) s6).trackStopIndicatorSize)) / this.displayedTrackThickness);
        }
    }

    /* access modifiers changed from: package-private */
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, int i5) {
        DrawingDelegate.ActiveIndicator activeIndicator2 = activeIndicator;
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator2.color, i5);
        this.drawingDeterminateIndicator = activeIndicator2.isDeterminate;
        float f5 = activeIndicator2.startFraction;
        float f6 = activeIndicator2.endFraction;
        int i6 = activeIndicator2.gapSize;
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        drawLine(canvas2, paint2, f5, f6, compositeARGBWithAlpha, i6, i6, activeIndicator2.amplitudeFraction, activeIndicator2.phaseFraction, true);
    }

    /* access modifiers changed from: package-private */
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f5, float f6, int i5, int i6, @Px int i7) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i5, i6);
        this.drawingDeterminateIndicator = false;
        drawLine(canvas, paint, f5, f6, compositeARGBWithAlpha, i7, i7, 0.0f, 0.0f, false);
    }

    /* access modifiers changed from: package-private */
    public int getPreferredHeight() {
        S s5 = this.spec;
        return ((LinearProgressIndicatorSpec) s5).trackThickness + (((LinearProgressIndicatorSpec) s5).waveAmplitude * 2);
    }

    /* access modifiers changed from: package-private */
    public int getPreferredWidth() {
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void invalidateCachedPaths() {
        int i5;
        this.cachedActivePath.rewind();
        if (((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            if (this.drawingDeterminateIndicator) {
                i5 = ((LinearProgressIndicatorSpec) this.spec).wavelengthDeterminate;
            } else {
                i5 = ((LinearProgressIndicatorSpec) this.spec).wavelengthIndeterminate;
            }
            float f5 = this.trackLength;
            int i6 = (int) (f5 / ((float) i5));
            this.adjustedWavelength = f5 / ((float) i6);
            for (int i7 = 0; i7 <= i6; i7++) {
                int i8 = i7 * 2;
                float f6 = (float) (i8 + 1);
                this.cachedActivePath.cubicTo(((float) i8) + 0.48f, 0.0f, f6 - 0.48f, 1.0f, f6, 1.0f);
                float f7 = (float) (i8 + 2);
                this.cachedActivePath.cubicTo(f6 + 0.48f, 1.0f, f7 - 0.48f, 0.0f, f7, 0.0f);
            }
            this.transform.reset();
            this.transform.setScale(this.adjustedWavelength / 2.0f, -2.0f);
            this.transform.postTranslate(0.0f, 1.0f);
            this.cachedActivePath.transform(this.transform);
        } else {
            this.cachedActivePath.lineTo(this.trackLength, 0.0f);
        }
        this.activePathMeasure.setPath(this.cachedActivePath, false);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint, float f5, float f6, float f7, @Nullable DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint2, float f8, float f9, float f10, boolean z4) {
        char c5;
        float f11;
        float f12;
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint3 = pathPoint;
        float f13 = f5;
        float f14 = f7;
        DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint4 = pathPoint2;
        float min = Math.min(f6, this.displayedTrackThickness);
        float f15 = (-f13) / 2.0f;
        float f16 = (-min) / 2.0f;
        float f17 = f13 / 2.0f;
        float f18 = min / 2.0f;
        RectF rectF = new RectF(f15, f16, f17, f18);
        paint2.setStyle(Paint.Style.FILL);
        canvas2.save();
        if (pathPoint4 != null) {
            float min2 = Math.min(f9, this.displayedTrackThickness);
            float min3 = Math.min(f8 / 2.0f, (f10 * min2) / this.displayedTrackThickness);
            RectF rectF2 = new RectF();
            if (z4) {
                c5 = 0;
                float f19 = (pathPoint4.posVec[0] - min3) - (pathPoint3.posVec[0] - f14);
                if (f19 > 0.0f) {
                    pathPoint4.translate((-f19) / 2.0f, 0.0f);
                    f11 = f8 + f19;
                } else {
                    f11 = f8;
                }
                rectF2.set(0.0f, f16, f17, f18);
            } else {
                c5 = 0;
                float f20 = (pathPoint4.posVec[0] + min3) - (pathPoint3.posVec[0] + f14);
                if (f20 < 0.0f) {
                    pathPoint4.translate((-f20) / 2.0f, 0.0f);
                    f12 = f8 - f20;
                } else {
                    f12 = f8;
                }
                rectF2.set(f15, f16, 0.0f, f18);
                f11 = f12;
            }
            RectF rectF3 = new RectF((-f11) / 2.0f, (-min2) / 2.0f, f11 / 2.0f, min2 / 2.0f);
            float[] fArr = pathPoint4.posVec;
            canvas2.translate(fArr[c5], fArr[1]);
            canvas2.rotate(vectorToCanvasRotation(pathPoint4.tanVec));
            Path path = new Path();
            path.addRoundRect(rectF3, min3, min3, Path.Direction.CCW);
            canvas2.clipPath(path);
            canvas2.rotate(-vectorToCanvasRotation(pathPoint4.tanVec));
            float[] fArr2 = pathPoint4.posVec;
            canvas2.translate(-fArr2[c5], -fArr2[1]);
            float[] fArr3 = pathPoint3.posVec;
            canvas2.translate(fArr3[c5], fArr3[1]);
            canvas2.rotate(vectorToCanvasRotation(pathPoint3.tanVec));
            canvas2.drawRect(rectF2, paint2);
            canvas2.drawRoundRect(rectF, f14, f14, paint2);
        } else {
            float[] fArr4 = pathPoint3.posVec;
            canvas2.translate(fArr4[0], fArr4[1]);
            canvas2.rotate(vectorToCanvasRotation(pathPoint3.tanVec));
            canvas2.drawRoundRect(rectF, f14, f14, paint2);
        }
        canvas2.restore();
    }
}
