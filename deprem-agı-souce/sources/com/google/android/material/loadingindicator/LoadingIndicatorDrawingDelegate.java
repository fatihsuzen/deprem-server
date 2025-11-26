package com.google.android.material.loadingindicator;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.graphics.shapes.Morph;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.graphics.shapes.Shapes_androidKt;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.math.MathUtils;
import com.google.android.material.shape.MaterialShapes;

class LoadingIndicatorDrawingDelegate {
    private static final Morph[] INDETERMINATE_MORPH_SEQUENCE;
    private static final RoundedPolygon[] INDETERMINATE_SHAPES;
    @NonNull
    final Path indicatorPath = new Path();
    @NonNull
    final Matrix indicatorPathTransform = new Matrix();
    @NonNull
    LoadingIndicatorSpec specs;

    protected static class IndicatorState {
        @ColorInt
        int color;
        float morphFraction;
        float rotationDegree;

        protected IndicatorState() {
        }
    }

    static {
        int i5 = 0;
        RoundedPolygon[] roundedPolygonArr = {MaterialShapes.normalize(MaterialShapes.SOFT_BURST, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.COOKIE_9, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.PENTAGON, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.PILL, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.SUNNY, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.COOKIE_4, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.OVAL, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f))};
        INDETERMINATE_SHAPES = roundedPolygonArr;
        INDETERMINATE_MORPH_SEQUENCE = new Morph[roundedPolygonArr.length];
        while (true) {
            RoundedPolygon[] roundedPolygonArr2 = INDETERMINATE_SHAPES;
            if (i5 < roundedPolygonArr2.length) {
                int i6 = i5 + 1;
                INDETERMINATE_MORPH_SEQUENCE[i5] = new Morph(roundedPolygonArr2[i5], roundedPolygonArr2[i6 % roundedPolygonArr2.length]);
                i5 = i6;
            } else {
                return;
            }
        }
    }

    public LoadingIndicatorDrawingDelegate(@NonNull LoadingIndicatorSpec loadingIndicatorSpec) {
        this.specs = loadingIndicatorSpec;
    }

    /* access modifiers changed from: package-private */
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect) {
        canvas.translate((float) rect.centerX(), (float) rect.centerY());
        if (this.specs.scaleToFit) {
            float min = Math.min(((float) rect.width()) / ((float) getPreferredWidth()), ((float) rect.height()) / ((float) getPreferredHeight()));
            canvas.scale(min, min);
        }
        canvas.clipRect(((float) (-getPreferredWidth())) / 2.0f, ((float) (-getPreferredHeight())) / 2.0f, ((float) getPreferredWidth()) / 2.0f, ((float) getPreferredHeight()) / 2.0f);
        canvas.rotate(-90.0f);
    }

    /* access modifiers changed from: package-private */
    public void drawContainer(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i5, @IntRange(from = 0, to = 255) int i6) {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        float min = ((float) Math.min(loadingIndicatorSpec.containerWidth, loadingIndicatorSpec.containerHeight)) / 2.0f;
        paint.setColor(MaterialColors.compositeARGBWithAlpha(i5, i6));
        paint.setStyle(Paint.Style.FILL);
        LoadingIndicatorSpec loadingIndicatorSpec2 = this.specs;
        int i7 = loadingIndicatorSpec2.containerWidth;
        int i8 = loadingIndicatorSpec2.containerHeight;
        canvas.drawRoundRect(new RectF(((float) (-i7)) / 2.0f, ((float) (-i8)) / 2.0f, ((float) i7) / 2.0f, ((float) i8) / 2.0f), min, min, paint);
    }

    /* access modifiers changed from: package-private */
    public void drawIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull IndicatorState indicatorState, @IntRange(from = 0, to = 255) int i5) {
        paint.setColor(MaterialColors.compositeARGBWithAlpha(indicatorState.color, i5));
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        canvas.rotate(indicatorState.rotationDegree);
        this.indicatorPath.rewind();
        int floor = (int) Math.floor((double) indicatorState.morphFraction);
        Morph[] morphArr = INDETERMINATE_MORPH_SEQUENCE;
        int floorMod = MathUtils.floorMod(floor, morphArr.length);
        Shapes_androidKt.toPath(morphArr[floorMod], indicatorState.morphFraction - ((float) floor), this.indicatorPath);
        Matrix matrix = this.indicatorPathTransform;
        int i6 = this.specs.indicatorSize;
        matrix.setScale(((float) i6) / 2.0f, ((float) i6) / 2.0f);
        this.indicatorPath.transform(this.indicatorPathTransform);
        canvas.drawPath(this.indicatorPath, paint);
        canvas.restore();
    }

    /* access modifiers changed from: package-private */
    public int getPreferredHeight() {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        return Math.max(loadingIndicatorSpec.containerWidth, loadingIndicatorSpec.indicatorSize);
    }

    /* access modifiers changed from: package-private */
    public int getPreferredWidth() {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        return Math.max(loadingIndicatorSpec.containerHeight, loadingIndicatorSpec.indicatorSize);
    }
}
