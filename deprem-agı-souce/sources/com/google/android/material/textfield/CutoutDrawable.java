package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

class CutoutDrawable extends MaterialShapeDrawable {
    @NonNull
    CutoutDrawableState drawableState;

    private static class ImplApi18 extends CutoutDrawable {
        ImplApi18(@NonNull CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
        }

        /* access modifiers changed from: protected */
        public void drawStrokeShape(@NonNull Canvas canvas) {
            if (this.drawableState.cutoutBounds.isEmpty()) {
                super.drawStrokeShape(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                boolean unused = canvas.clipOutRect(this.drawableState.cutoutBounds);
            } else {
                canvas.clipRect(this.drawableState.cutoutBounds, Region.Op.DIFFERENCE);
            }
            super.drawStrokeShape(canvas);
            canvas.restore();
        }
    }

    static CutoutDrawable create(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel == null) {
            shapeAppearanceModel = new ShapeAppearanceModel();
        }
        return create(new CutoutDrawableState(shapeAppearanceModel, new RectF()));
    }

    /* access modifiers changed from: package-private */
    public boolean hasCutout() {
        return !this.drawableState.cutoutBounds.isEmpty();
    }

    @NonNull
    public Drawable mutate() {
        this.drawableState = new CutoutDrawableState(this.drawableState);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* access modifiers changed from: package-private */
    public void setCutout(float f5, float f6, float f7, float f8) {
        if (f5 != this.drawableState.cutoutBounds.left || f6 != this.drawableState.cutoutBounds.top || f7 != this.drawableState.cutoutBounds.right || f8 != this.drawableState.cutoutBounds.bottom) {
            this.drawableState.cutoutBounds.set(f5, f6, f7, f8);
            invalidateSelf();
        }
    }

    private static final class CutoutDrawableState extends MaterialShapeDrawable.MaterialShapeDrawableState {
        /* access modifiers changed from: private */
        @NonNull
        public final RectF cutoutBounds;

        @NonNull
        public Drawable newDrawable() {
            CutoutDrawable access$400 = CutoutDrawable.create(this);
            access$400.invalidateSelf();
            return access$400;
        }

        private CutoutDrawableState(@NonNull ShapeAppearanceModel shapeAppearanceModel, @NonNull RectF rectF) {
            super(shapeAppearanceModel, (ElevationOverlayProvider) null);
            this.cutoutBounds = rectF;
        }

        private CutoutDrawableState(@NonNull CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
            this.cutoutBounds = cutoutDrawableState.cutoutBounds;
        }
    }

    private CutoutDrawable(@NonNull CutoutDrawableState cutoutDrawableState) {
        super((MaterialShapeDrawable.MaterialShapeDrawableState) cutoutDrawableState);
        this.drawableState = cutoutDrawableState;
    }

    /* access modifiers changed from: private */
    public static CutoutDrawable create(@NonNull CutoutDrawableState cutoutDrawableState) {
        return new ImplApi18(cutoutDrawableState);
    }

    /* access modifiers changed from: package-private */
    public void setCutout(@NonNull RectF rectF) {
        setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
