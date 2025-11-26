package com.google.android.material.shape;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.math.MathUtils;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    private static final SpringAnimatedCornerSizeProperty[] CORNER_SIZES_IN_PX = new SpringAnimatedCornerSizeProperty[4];
    static final ShapeAppearanceModel DEFAULT_INTERPOLATION_START_SHAPE_APPEARANCE_MODEL = ShapeAppearanceModel.builder().setAllCorners(0, 0.0f).build();
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = "MaterialShapeDrawable";
    private static final Paint clearPaint;
    private boolean boundsIsEmpty;
    /* access modifiers changed from: private */
    public final BitSet containsIncompatibleShadowOp;
    /* access modifiers changed from: private */
    public final ShapePath.ShadowCompatOperation[] cornerShadowOperation;
    @NonNull
    SpringAnimation[] cornerSpringAnimations;
    @Nullable
    private SpringForce cornerSpringForce;
    private MaterialShapeDrawableState drawableState;
    /* access modifiers changed from: private */
    public final ShapePath.ShadowCompatOperation[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    /* access modifiers changed from: private */
    @Nullable
    public OnCornerSizeChangeListener onCornerSizeChangeListener;
    private final Path path;
    @NonNull
    private final RectF pathBounds;
    /* access modifiers changed from: private */
    public boolean pathDirty;
    private final Path pathInsetByStroke;
    private final ShapeAppearancePathProvider pathProvider;
    @NonNull
    private final ShapeAppearancePathProvider.PathListener pathShadowListener;
    private final RectF rectF;
    private int resolvedTintColor;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final ShadowRenderer shadowRenderer;
    /* access modifiers changed from: private */
    @Nullable
    public float[] springAnimatedCornerSizes;
    @Nullable
    private float[] springAnimatedStrokeCornerSizes;
    private final ShapeAppearanceModel.CornerSizeUnaryOperator strokeInsetCornerSizeUnaryOperator;
    private final Paint strokePaint;
    /* access modifiers changed from: private */
    public boolean strokePathDirty;
    @NonNull
    private ShapeAppearanceModel strokeShapeAppearanceModel;
    @Nullable
    private PorterDuffColorFilter strokeTintFilter;
    @Nullable
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnCornerSizeChangeListener {
        void onCornerSizeChange(float f5);
    }

    private static class SpringAnimatedCornerSizeProperty extends FloatPropertyCompat<MaterialShapeDrawable> {
        private final int index;

        SpringAnimatedCornerSizeProperty(int i5) {
            super("cornerSizeAtIndex" + i5);
            this.index = i5;
        }

        public float getValue(@NonNull MaterialShapeDrawable materialShapeDrawable) {
            if (materialShapeDrawable.springAnimatedCornerSizes != null) {
                return materialShapeDrawable.springAnimatedCornerSizes[this.index];
            }
            return 0.0f;
        }

        public void setValue(@NonNull MaterialShapeDrawable materialShapeDrawable, float f5) {
            if (materialShapeDrawable.springAnimatedCornerSizes != null && materialShapeDrawable.springAnimatedCornerSizes[this.index] != f5) {
                materialShapeDrawable.springAnimatedCornerSizes[this.index] = f5;
                if (materialShapeDrawable.onCornerSizeChangeListener != null) {
                    materialShapeDrawable.onCornerSizeChangeListener.onCornerSizeChange(materialShapeDrawable.getCornerSizeDiffX());
                }
                materialShapeDrawable.invalidateSelf();
            }
        }
    }

    static {
        int i5 = 0;
        Paint paint = new Paint(1);
        clearPaint = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        while (true) {
            SpringAnimatedCornerSizeProperty[] springAnimatedCornerSizePropertyArr = CORNER_SIZES_IN_PX;
            if (i5 < springAnimatedCornerSizePropertyArr.length) {
                springAnimatedCornerSizePropertyArr[i5] = new SpringAnimatedCornerSizeProperty(i5);
                i5++;
            } else {
                return;
            }
        }
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    @Nullable
    private PorterDuffColorFilter calculatePaintColorTintFilter(@NonNull Paint paint, boolean z4) {
        if (!z4) {
            return null;
        }
        int color = paint.getColor();
        int compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(color);
        this.resolvedTintColor = compositeElevationOverlayIfNeeded;
        if (compositeElevationOverlayIfNeeded != color) {
            return new PorterDuffColorFilter(compositeElevationOverlayIfNeeded, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void calculatePath(@NonNull RectF rectF2, @NonNull Path path2) {
        calculatePathForSize(rectF2, path2);
        if (this.drawableState.scale != 1.0f) {
            this.matrix.reset();
            Matrix matrix2 = this.matrix;
            float f5 = this.drawableState.scale;
            matrix2.setScale(f5, f5, rectF2.width() / 2.0f, rectF2.height() / 2.0f);
            path2.transform(this.matrix);
        }
        path2.computeBounds(this.pathBounds, true);
    }

    private float calculateRoundRectCornerSize(@NonNull RectF rectF2, @NonNull ShapeAppearanceModel shapeAppearanceModel, @Nullable float[] fArr) {
        if (fArr == null) {
            if (shapeAppearanceModel.isRoundRect(rectF2)) {
                return shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF2);
            }
            return -1.0f;
        } else if (!MathUtils.areAllElementsEqual(fArr) || !shapeAppearanceModel.hasRoundedCorners()) {
            return -1.0f;
        } else {
            return fArr[0];
        }
    }

    private void calculateStrokePath() {
        updateStrokeShapeAppearanceModels();
        this.pathProvider.calculatePath(this.strokeShapeAppearanceModel, this.springAnimatedStrokeCornerSizes, this.drawableState.interpolation, getBoundsInsetByStroke(), (ShapeAppearancePathProvider.PathListener) null, this.pathInsetByStroke);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintColorTintFilter(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z4) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z4) {
            colorForState = compositeElevationOverlayIfNeeded(colorForState);
        }
        this.resolvedTintColor = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintFilter(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z4) {
        if (colorStateList == null || mode == null) {
            return calculatePaintColorTintFilter(paint, z4);
        }
        return calculateTintColorTintFilter(colorStateList, mode, z4);
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context) {
        return createWithElevationOverlay(context, 0.0f);
    }

    private void drawCompatShadow(@NonNull Canvas canvas) {
        if (this.containsIncompatibleShadowOp.cardinality() > 0) {
            Log.w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.drawableState.shadowCompatOffset != 0) {
            canvas.drawPath(this.path, this.shadowRenderer.getShadowPaint());
        }
        for (int i5 = 0; i5 < 4; i5++) {
            this.cornerShadowOperation[i5].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
            this.edgeShadowOperation[i5].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate((float) (-shadowOffsetX), (float) (-shadowOffsetY));
            canvas.drawPath(this.path, clearPaint);
            canvas.translate((float) shadowOffsetX, (float) shadowOffsetY);
        }
    }

    private void drawFillShape(@NonNull Canvas canvas) {
        drawShape(canvas, this.fillPaint, this.path, this.drawableState.shapeAppearanceModel, this.springAnimatedCornerSizes, getBoundsAsRectF());
    }

    @NonNull
    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float strokeInsetLength = getStrokeInsetLength();
        this.insetRectF.inset(strokeInsetLength, strokeInsetLength);
        return this.insetRectF;
    }

    /* access modifiers changed from: private */
    public float getStrokeInsetLength() {
        if (hasStroke()) {
            return this.strokePaint.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean hasCompatShadow() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        int i5 = materialShapeDrawableState.shadowCompatMode;
        if (i5 == 1 || materialShapeDrawableState.shadowCompatRadius <= 0) {
            return false;
        }
        if (i5 == 2 || requiresCompatShadow()) {
            return true;
        }
        return false;
    }

    private boolean hasFill() {
        Paint.Style style = this.drawableState.paintStyle;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            return true;
        }
        return false;
    }

    private boolean hasStroke() {
        Paint.Style style = this.drawableState.paintStyle;
        if ((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f) {
            return true;
        }
        return false;
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    private void maybeDrawCompatShadow(@NonNull Canvas canvas) {
        if (hasCompatShadow()) {
            canvas.save();
            prepareCanvasForShadow(canvas);
            if (!this.shadowBitmapDrawingEnable) {
                drawCompatShadow(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.pathBounds.width() - ((float) getBounds().width()));
            int height = (int) (this.pathBounds.height() - ((float) getBounds().height()));
            if (width < 0 || height < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.pathBounds.width()) + (this.drawableState.shadowCompatRadius * 2) + width, ((int) this.pathBounds.height()) + (this.drawableState.shadowCompatRadius * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f5 = (float) ((getBounds().left - this.drawableState.shadowCompatRadius) - width);
            float f6 = (float) ((getBounds().top - this.drawableState.shadowCompatRadius) - height);
            canvas2.translate(-f5, -f6);
            drawCompatShadow(canvas2);
            canvas.drawBitmap(createBitmap, f5, f6, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
    }

    private static int modulateAlpha(int i5, int i6) {
        return (i5 * (i6 + (i6 >>> 7))) >>> 8;
    }

    private void prepareCanvasForShadow(@NonNull Canvas canvas) {
        canvas.translate((float) getShadowOffsetX(), (float) getShadowOffsetY());
    }

    private boolean updateColorsForState(int[] iArr) {
        boolean z4;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.drawableState.fillColor == null || (color2 = this.fillPaint.getColor()) == (colorForState2 = this.drawableState.fillColor.getColorForState(iArr, color2))) {
            z4 = false;
        } else {
            this.fillPaint.setColor(colorForState2);
            z4 = true;
        }
        if (this.drawableState.strokeColor == null || (color = this.strokePaint.getColor()) == (colorForState = this.drawableState.strokeColor.getColorForState(iArr, color))) {
            return z4;
        }
        this.strokePaint.setColor(colorForState);
        return true;
    }

    private void updateShape(int[] iArr) {
        updateShape(iArr, false);
    }

    private void updateStrokeShapeAppearanceModels() {
        this.strokeShapeAppearanceModel = getShapeAppearanceModel().withTransformedCornerSizes(this.strokeInsetCornerSizeUnaryOperator);
        float[] fArr = this.springAnimatedCornerSizes;
        if (fArr == null) {
            this.springAnimatedStrokeCornerSizes = null;
            return;
        }
        if (this.springAnimatedStrokeCornerSizes == null) {
            this.springAnimatedStrokeCornerSizes = new float[fArr.length];
        }
        float strokeInsetLength = getStrokeInsetLength();
        int i5 = 0;
        while (true) {
            float[] fArr2 = this.springAnimatedCornerSizes;
            if (i5 < fArr2.length) {
                this.springAnimatedStrokeCornerSizes[i5] = Math.max(0.0f, fArr2[i5] - strokeInsetLength);
                i5++;
            } else {
                return;
            }
        }
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        this.tintFilter = calculateTintFilter(materialShapeDrawableState.tintList, materialShapeDrawableState.tintMode, this.fillPaint, true);
        MaterialShapeDrawableState materialShapeDrawableState2 = this.drawableState;
        this.strokeTintFilter = calculateTintFilter(materialShapeDrawableState2.strokeTintList, materialShapeDrawableState2.tintMode, this.strokePaint, false);
        MaterialShapeDrawableState materialShapeDrawableState3 = this.drawableState;
        if (materialShapeDrawableState3.useTintColorForShadow) {
            this.shadowRenderer.setShadowColor(materialShapeDrawableState3.tintList.getColorForState(getState(), 0));
        }
        if (!ObjectsCompat.equals(porterDuffColorFilter, this.tintFilter) || !ObjectsCompat.equals(porterDuffColorFilter2, this.strokeTintFilter)) {
            return true;
        }
        return false;
    }

    private void updateZ() {
        float z4 = getZ();
        this.drawableState.shadowCompatRadius = (int) Math.ceil((double) (0.75f * z4));
        this.drawableState.shadowCompatOffset = (int) Math.ceil((double) (z4 * SHADOW_OFFSET_MULTIPLIER));
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void calculatePathForSize(@NonNull RectF rectF2, @NonNull Path path2) {
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.pathProvider;
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        RectF rectF3 = rectF2;
        shapeAppearancePathProvider.calculatePath(materialShapeDrawableState.shapeAppearanceModel, this.springAnimatedCornerSizes, materialShapeDrawableState.interpolation, rectF3, this.pathShadowListener, path2);
    }

    /* access modifiers changed from: protected */
    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int compositeElevationOverlayIfNeeded(@ColorInt int i5) {
        float z4 = getZ() + getParentAbsoluteElevation();
        ElevationOverlayProvider elevationOverlayProvider = this.drawableState.elevationOverlayProvider;
        if (elevationOverlayProvider != null) {
            return elevationOverlayProvider.compositeOverlayIfNeeded(i5, z4);
        }
        return i5;
    }

    public void draw(@NonNull Canvas canvas) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int alpha = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(alpha, this.drawableState.alpha));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.strokeWidth);
        int alpha2 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(alpha2, this.drawableState.alpha));
        if (hasFill()) {
            if (this.pathDirty) {
                calculatePath(getBoundsAsRectF(), this.path);
                this.pathDirty = false;
            }
            maybeDrawCompatShadow(canvas);
            drawFillShape(canvas);
        }
        if (hasStroke()) {
            if (this.strokePathDirty) {
                calculateStrokePath();
                this.strokePathDirty = false;
            }
            drawStrokeShape(canvas);
        }
        this.fillPaint.setAlpha(alpha);
        this.strokePaint.setAlpha(alpha2);
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void drawShape(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path2, @NonNull RectF rectF2) {
        drawShape(canvas, paint, path2, this.drawableState.shapeAppearanceModel, this.springAnimatedCornerSizes, rectF2);
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void drawStrokeShape(@NonNull Canvas canvas) {
        drawShape(canvas, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearanceModel, this.springAnimatedStrokeCornerSizes, getBoundsInsetByStroke());
    }

    public int getAlpha() {
        return this.drawableState.alpha;
    }

    public float getBottomLeftCornerResolvedSize() {
        float[] fArr = this.springAnimatedCornerSizes;
        if (fArr != null) {
            return fArr[2];
        }
        return this.drawableState.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        float[] fArr = this.springAnimatedCornerSizes;
        if (fArr != null) {
            return fArr[1];
        }
        return this.drawableState.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    /* access modifiers changed from: protected */
    @NonNull
    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getCornerSizeDiffX() {
        float cornerSize;
        float cornerSize2;
        float[] fArr = this.springAnimatedCornerSizes;
        if (fArr != null) {
            cornerSize = (fArr[3] + fArr[2]) - fArr[1];
            cornerSize2 = fArr[0];
        } else {
            RectF boundsAsRectF = getBoundsAsRectF();
            cornerSize = (this.pathProvider.getCornerSizeForIndex(3, getShapeAppearanceModel()).getCornerSize(boundsAsRectF) + this.pathProvider.getCornerSizeForIndex(2, getShapeAppearanceModel()).getCornerSize(boundsAsRectF)) - this.pathProvider.getCornerSizeForIndex(1, getShapeAppearanceModel()).getCornerSize(boundsAsRectF);
            cornerSize2 = this.pathProvider.getCornerSizeForIndex(0, getShapeAppearanceModel()).getCornerSize(boundsAsRectF);
        }
        return (cornerSize - cornerSize2) / 2.0f;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SpringForce getCornerSpringForce() {
        return this.cornerSpringForce;
    }

    public float getElevation() {
        return this.drawableState.elevation;
    }

    @Nullable
    public ColorStateList getFillColor() {
        return this.drawableState.fillColor;
    }

    public float getInterpolation() {
        return this.drawableState.interpolation;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(@NonNull Outline outline) {
        if (this.drawableState.shadowCompatMode != 2) {
            RectF boundsAsRectF = getBoundsAsRectF();
            if (!boundsAsRectF.isEmpty()) {
                float calculateRoundRectCornerSize = calculateRoundRectCornerSize(boundsAsRectF, this.drawableState.shapeAppearanceModel, this.springAnimatedCornerSizes);
                if (calculateRoundRectCornerSize >= 0.0f) {
                    outline.setRoundRect(getBounds(), calculateRoundRectCornerSize * this.drawableState.interpolation);
                    return;
                }
                if (this.pathDirty) {
                    calculatePath(boundsAsRectF, this.path);
                    this.pathDirty = false;
                }
                DrawableUtils.setOutlineToPath(outline, this.path);
            }
        }
    }

    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.drawableState.padding;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.paintStyle;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.parentAbsoluteElevation;
    }

    @Deprecated
    public void getPathForSize(int i5, int i6, @NonNull Path path2) {
        calculatePathForSize(new RectF(0.0f, 0.0f, (float) i5, (float) i6), path2);
    }

    @ColorInt
    public int getResolvedTintColor() {
        return this.resolvedTintColor;
    }

    public float getScale() {
        return this.drawableState.scale;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.shadowCompatRotation;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.shadowCompatMode;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        return (int) (((double) materialShapeDrawableState.shadowCompatOffset) * Math.sin(Math.toRadians((double) materialShapeDrawableState.shadowCompatRotation)));
    }

    public int getShadowOffsetY() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        return (int) (((double) materialShapeDrawableState.shadowCompatOffset) * Math.cos(Math.toRadians((double) materialShapeDrawableState.shadowCompatRotation)));
    }

    public int getShadowRadius() {
        return this.drawableState.shadowCompatRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getShadowVerticalOffset() {
        return this.drawableState.shadowCompatOffset;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.shapeAppearanceModel;
    }

    @Deprecated
    @Nullable
    public ShapePathModel getShapedViewModel() {
        ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof ShapePathModel) {
            return (ShapePathModel) shapeAppearanceModel;
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StateListShapeAppearanceModel getStateListShapeAppearanceModel() {
        return this.drawableState.stateListShapeAppearanceModel;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.drawableState.strokeColor;
    }

    @Nullable
    public ColorStateList getStrokeTintList() {
        return this.drawableState.strokeTintList;
    }

    public float getStrokeWidth() {
        return this.drawableState.strokeWidth;
    }

    @Nullable
    public ColorStateList getTintList() {
        return this.drawableState.tintList;
    }

    public float getTopLeftCornerResolvedSize() {
        float[] fArr = this.springAnimatedCornerSizes;
        if (fArr != null) {
            return fArr[3];
        }
        return this.drawableState.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        float[] fArr = this.springAnimatedCornerSizes;
        if (fArr != null) {
            return fArr[0];
        }
        return this.drawableState.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.translationZ;
    }

    public Region getTransparentRegion() {
        this.transparentRegion.set(getBounds());
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void initializeElevationOverlay(Context context) {
        this.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context);
        updateZ();
    }

    public void invalidateSelf() {
        this.pathDirty = true;
        this.strokePathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        ElevationOverlayProvider elevationOverlayProvider = this.drawableState.elevationOverlayProvider;
        if (elevationOverlayProvider == null || !elevationOverlayProvider.isThemeElevationOverlayEnabled()) {
            return false;
        }
        return true;
    }

    public boolean isElevationOverlayInitialized() {
        if (this.drawableState.elevationOverlayProvider != null) {
            return true;
        }
        return false;
    }

    public boolean isPointInTransparentRegion(int i5, int i6) {
        return getTransparentRegion().contains(i5, i6);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect() {
        if (this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF())) {
            return true;
        }
        float[] fArr = this.springAnimatedCornerSizes;
        if (fArr == null || !MathUtils.areAllElementsEqual(fArr) || !this.drawableState.shapeAppearanceModel.hasRoundedCorners()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public boolean isShadowEnabled() {
        int i5 = this.drawableState.shadowCompatMode;
        if (i5 == 0 || i5 == 2) {
            return true;
        }
        return false;
    }

    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.drawableState.tintList;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.drawableState.strokeTintList;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.drawableState.strokeColor;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        ColorStateList colorStateList4 = this.drawableState.fillColor;
        if (colorStateList4 != null && colorStateList4.isStateful()) {
            return true;
        }
        StateListShapeAppearanceModel stateListShapeAppearanceModel = this.drawableState.stateListShapeAppearanceModel;
        if (stateListShapeAppearanceModel == null || !stateListShapeAppearanceModel.isStateful()) {
            return false;
        }
        return true;
    }

    @NonNull
    public Drawable mutate() {
        this.drawableState = new MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.pathDirty = true;
        this.strokePathDirty = true;
        super.onBoundsChange(rect);
        if (this.drawableState.stateListShapeAppearanceModel != null && !rect.isEmpty()) {
            updateShape(getState(), this.boundsIsEmpty);
        }
        this.boundsIsEmpty = rect.isEmpty();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z4;
        if (this.drawableState.stateListShapeAppearanceModel != null) {
            updateShape(iArr);
        }
        boolean updateColorsForState = updateColorsForState(iArr);
        boolean updateTintFilter = updateTintFilter();
        if (updateColorsForState || updateTintFilter) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            invalidateSelf();
        }
        return z4;
    }

    public boolean requiresCompatShadow() {
        if (isRoundRect() || this.path.isConvex() || Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return true;
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i5) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.alpha != i5) {
            materialShapeDrawableState.alpha = i5;
            invalidateSelfIgnoreShape();
        }
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.drawableState.colorFilter = colorFilter;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float f5) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(f5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setCornerSpringForce(@NonNull SpringForce springForce) {
        if (this.cornerSpringForce != springForce) {
            this.cornerSpringForce = springForce;
            int i5 = 0;
            while (true) {
                SpringAnimation[] springAnimationArr = this.cornerSpringAnimations;
                if (i5 < springAnimationArr.length) {
                    if (springAnimationArr[i5] == null) {
                        springAnimationArr[i5] = new SpringAnimation(this, CORNER_SIZES_IN_PX[i5]);
                    }
                    this.cornerSpringAnimations[i5].setSpring(new SpringForce().setDampingRatio(springForce.getDampingRatio()).setStiffness(springForce.getStiffness()));
                    i5++;
                } else {
                    updateShape(getState(), true);
                    invalidateSelf();
                    return;
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeIntersectionCheckEnable(boolean z4) {
        this.pathProvider.setEdgeIntersectionCheckEnable(z4);
    }

    public void setElevation(float f5) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.elevation != f5) {
            materialShapeDrawableState.elevation = f5;
            updateZ();
        }
    }

    public void setFillColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.fillColor != colorStateList) {
            materialShapeDrawableState.fillColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setInterpolation(float f5) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.interpolation != f5) {
            materialShapeDrawableState.interpolation = f5;
            this.pathDirty = true;
            this.strokePathDirty = true;
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setOnCornerSizeChangeListener(@Nullable OnCornerSizeChangeListener onCornerSizeChangeListener2) {
        this.onCornerSizeChangeListener = onCornerSizeChangeListener2;
    }

    public void setPadding(int i5, int i6, int i7, int i8) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.padding == null) {
            materialShapeDrawableState.padding = new Rect();
        }
        this.drawableState.padding.set(i5, i6, i7, i8);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style style) {
        this.drawableState.paintStyle = style;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float f5) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.parentAbsoluteElevation != f5) {
            materialShapeDrawableState.parentAbsoluteElevation = f5;
            updateZ();
        }
    }

    public void setScale(float f5) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.scale != f5) {
            materialShapeDrawableState.scale = f5;
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowBitmapDrawingEnable(boolean z4) {
        this.shadowBitmapDrawingEnable = z4;
    }

    public void setShadowColor(int i5) {
        this.shadowRenderer.setShadowColor(i5);
        this.drawableState.useTintColorForShadow = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int i5) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatRotation != i5) {
            materialShapeDrawableState.shadowCompatRotation = i5;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShadowCompatibilityMode(int i5) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatMode != i5) {
            materialShapeDrawableState.shadowCompatMode = i5;
            invalidateSelfIgnoreShape();
        }
    }

    @Deprecated
    public void setShadowElevation(int i5) {
        setElevation((float) i5);
    }

    @Deprecated
    public void setShadowEnabled(boolean z4) {
        setShadowCompatibilityMode(z4 ^ true ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int i5) {
        this.drawableState.shadowCompatRadius = i5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowVerticalOffset(int i5) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatOffset != i5) {
            materialShapeDrawableState.shadowCompatOffset = i5;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        materialShapeDrawableState.shapeAppearanceModel = shapeAppearanceModel;
        materialShapeDrawableState.stateListShapeAppearanceModel = null;
        this.springAnimatedCornerSizes = null;
        this.springAnimatedStrokeCornerSizes = null;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(@NonNull ShapePathModel shapePathModel) {
        setShapeAppearanceModel(shapePathModel);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStateListShapeAppearanceModel(@NonNull StateListShapeAppearanceModel stateListShapeAppearanceModel) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.stateListShapeAppearanceModel != stateListShapeAppearanceModel) {
            materialShapeDrawableState.stateListShapeAppearanceModel = stateListShapeAppearanceModel;
            updateShape(getState(), true);
            invalidateSelf();
        }
    }

    public void setStroke(float f5, @ColorInt int i5) {
        setStrokeWidth(f5);
        setStrokeColor(ColorStateList.valueOf(i5));
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.strokeColor != colorStateList) {
            materialShapeDrawableState.strokeColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setStrokeTint(ColorStateList colorStateList) {
        this.drawableState.strokeTintList = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float f5) {
        this.drawableState.strokeWidth = f5;
        invalidateSelf();
    }

    public void setTint(@ColorInt int i5) {
        setTintList(ColorStateList.valueOf(i5));
    }

    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.drawableState.tintList = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.tintMode != mode) {
            materialShapeDrawableState.tintMode = mode;
            updateTintFilter();
            invalidateSelfIgnoreShape();
        }
    }

    public void setTranslationZ(float f5) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.translationZ != f5) {
            materialShapeDrawableState.translationZ = f5;
            updateZ();
        }
    }

    public void setUseTintColorForShadow(boolean z4) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.useTintColorForShadow != z4) {
            materialShapeDrawableState.useTintColorForShadow = z4;
            invalidateSelf();
        }
    }

    public void setZ(float f5) {
        setTranslationZ(f5 - getElevation());
    }

    public MaterialShapeDrawable(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5, @StyleRes int i6) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i5, i6).build());
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(@NonNull Context context, float f5) {
        return createWithElevationOverlay(context, f5, (ColorStateList) null);
    }

    private void drawShape(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path2, @NonNull ShapeAppearanceModel shapeAppearanceModel, @Nullable float[] fArr, @NonNull RectF rectF2) {
        float calculateRoundRectCornerSize = calculateRoundRectCornerSize(rectF2, shapeAppearanceModel, fArr);
        if (calculateRoundRectCornerSize >= 0.0f) {
            float f5 = calculateRoundRectCornerSize * this.drawableState.interpolation;
            canvas.drawRoundRect(rectF2, f5, f5, paint);
            return;
        }
        canvas.drawPath(path2, paint);
    }

    private void updateShape(int[] iArr, boolean z4) {
        RectF boundsAsRectF = getBoundsAsRectF();
        if (this.drawableState.stateListShapeAppearanceModel != null && !boundsAsRectF.isEmpty()) {
            boolean z5 = z4 | (this.cornerSpringForce == null);
            if (this.springAnimatedCornerSizes == null) {
                this.springAnimatedCornerSizes = new float[4];
            }
            ShapeAppearanceModel shapeForState = this.drawableState.stateListShapeAppearanceModel.getShapeForState(iArr);
            for (int i5 = 0; i5 < 4; i5++) {
                float cornerSize = this.pathProvider.getCornerSizeForIndex(i5, shapeForState).getCornerSize(boundsAsRectF);
                if (z5) {
                    this.springAnimatedCornerSizes[i5] = cornerSize;
                }
                SpringAnimation springAnimation = this.cornerSpringAnimations[i5];
                if (springAnimation != null) {
                    springAnimation.animateToFinalPosition(cornerSize);
                    if (z5) {
                        this.cornerSpringAnimations[i5].skipToEnd();
                    }
                }
            }
            if (z5) {
                invalidateSelf();
            }
        }
    }

    public void setCornerSize(@NonNull CornerSize cornerSize) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(cornerSize));
    }

    @Deprecated
    public MaterialShapeDrawable(@NonNull ShapePathModel shapePathModel) {
        this((ShapeAppearanceModel) shapePathModel);
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(@NonNull Context context, float f5, @Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(MaterialColors.getColor(context, R.attr.colorSurface, MaterialShapeDrawable.class.getSimpleName()));
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(colorStateList);
        materialShapeDrawable.setElevation(f5);
        return materialShapeDrawable;
    }

    public void setStroke(float f5, @Nullable ColorStateList colorStateList) {
        setStrokeWidth(f5);
        setStrokeColor(colorStateList);
    }

    public MaterialShapeDrawable(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this(new MaterialShapeDrawableState(shapeAppearanceModel, (ElevationOverlayProvider) null));
    }

    public void setStrokeTint(@ColorInt int i5) {
        setStrokeTint(ColorStateList.valueOf(i5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected MaterialShapeDrawable(@NonNull MaterialShapeDrawableState materialShapeDrawableState) {
        ShapeAppearancePathProvider shapeAppearancePathProvider;
        this.strokeInsetCornerSizeUnaryOperator = new ShapeAppearanceModel.CornerSizeUnaryOperator() {
            @NonNull
            public CornerSize apply(@NonNull CornerSize cornerSize) {
                if (cornerSize instanceof RelativeCornerSize) {
                    return cornerSize;
                }
                return new AdjustedCornerSize(-MaterialShapeDrawable.this.getStrokeInsetLength(), cornerSize);
            }
        };
        this.cornerShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.edgeShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint paint = new Paint(1);
        this.fillPaint = paint;
        Paint paint2 = new Paint(1);
        this.strokePaint = paint2;
        this.shadowRenderer = new ShadowRenderer();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            shapeAppearancePathProvider = ShapeAppearancePathProvider.getInstance();
        } else {
            shapeAppearancePathProvider = new ShapeAppearancePathProvider();
        }
        this.pathProvider = shapeAppearancePathProvider;
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.boundsIsEmpty = true;
        this.cornerSpringAnimations = new SpringAnimation[4];
        this.drawableState = materialShapeDrawableState;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new ShapeAppearancePathProvider.PathListener() {
            public void onCornerPathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i5) {
                MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i5, shapePath.containsIncompatibleShadowOp());
                MaterialShapeDrawable.this.cornerShadowOperation[i5] = shapePath.createShadowCompatOperation(matrix);
            }

            public void onEdgePathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i5) {
                MaterialShapeDrawable.this.containsIncompatibleShadowOp.set(i5 + 4, shapePath.containsIncompatibleShadowOp());
                MaterialShapeDrawable.this.edgeShadowOperation[i5] = shapePath.createShadowCompatOperation(matrix);
            }
        };
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected static class MaterialShapeDrawableState extends Drawable.ConstantState {
        int alpha = 255;
        @Nullable
        ColorFilter colorFilter;
        float elevation = 0.0f;
        @Nullable
        ElevationOverlayProvider elevationOverlayProvider;
        @Nullable
        ColorStateList fillColor = null;
        float interpolation = 1.0f;
        @Nullable
        Rect padding = null;
        Paint.Style paintStyle = Paint.Style.FILL_AND_STROKE;
        float parentAbsoluteElevation = 0.0f;
        float scale = 1.0f;
        int shadowCompatMode = 0;
        int shadowCompatOffset = 0;
        int shadowCompatRadius = 0;
        int shadowCompatRotation = 0;
        @NonNull
        ShapeAppearanceModel shapeAppearanceModel;
        @Nullable
        StateListShapeAppearanceModel stateListShapeAppearanceModel;
        @Nullable
        ColorStateList strokeColor = null;
        @Nullable
        ColorStateList strokeTintList = null;
        float strokeWidth;
        @Nullable
        ColorStateList tintList = null;
        @Nullable
        PorterDuff.Mode tintMode = PorterDuff.Mode.SRC_IN;
        float translationZ = 0.0f;
        boolean useTintColorForShadow = false;

        public MaterialShapeDrawableState(@NonNull ShapeAppearanceModel shapeAppearanceModel2, @Nullable ElevationOverlayProvider elevationOverlayProvider2) {
            this.shapeAppearanceModel = shapeAppearanceModel2;
            this.elevationOverlayProvider = elevationOverlayProvider2;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            boolean unused = materialShapeDrawable.pathDirty = true;
            boolean unused2 = materialShapeDrawable.strokePathDirty = true;
            return materialShapeDrawable;
        }

        public MaterialShapeDrawableState(@NonNull MaterialShapeDrawableState materialShapeDrawableState) {
            this.shapeAppearanceModel = materialShapeDrawableState.shapeAppearanceModel;
            this.stateListShapeAppearanceModel = materialShapeDrawableState.stateListShapeAppearanceModel;
            this.elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
            this.strokeWidth = materialShapeDrawableState.strokeWidth;
            this.colorFilter = materialShapeDrawableState.colorFilter;
            this.fillColor = materialShapeDrawableState.fillColor;
            this.strokeColor = materialShapeDrawableState.strokeColor;
            this.tintMode = materialShapeDrawableState.tintMode;
            this.tintList = materialShapeDrawableState.tintList;
            this.alpha = materialShapeDrawableState.alpha;
            this.scale = materialShapeDrawableState.scale;
            this.shadowCompatOffset = materialShapeDrawableState.shadowCompatOffset;
            this.shadowCompatMode = materialShapeDrawableState.shadowCompatMode;
            this.useTintColorForShadow = materialShapeDrawableState.useTintColorForShadow;
            this.interpolation = materialShapeDrawableState.interpolation;
            this.parentAbsoluteElevation = materialShapeDrawableState.parentAbsoluteElevation;
            this.elevation = materialShapeDrawableState.elevation;
            this.translationZ = materialShapeDrawableState.translationZ;
            this.shadowCompatRadius = materialShapeDrawableState.shadowCompatRadius;
            this.shadowCompatRotation = materialShapeDrawableState.shadowCompatRotation;
            this.strokeTintList = materialShapeDrawableState.strokeTintList;
            this.paintStyle = materialShapeDrawableState.paintStyle;
            if (materialShapeDrawableState.padding != null) {
                this.padding = new Rect(materialShapeDrawableState.padding);
            }
        }
    }
}
