package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FadeThroughDrawable extends Drawable {
    private final float[] alphas;
    private final Drawable fadeInDrawable;
    private final Drawable fadeOutDrawable;
    private float progress;

    private static class EmptyDrawable extends Drawable {
        private EmptyDrawable() {
        }

        public void draw(@NonNull Canvas canvas) {
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int i5) {
        }

        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }
    }

    public FadeThroughDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        Drawable drawable3;
        Drawable drawable4;
        int i5;
        if (drawable != null) {
            drawable3 = drawable.getConstantState().newDrawable().mutate();
        } else {
            drawable3 = new EmptyDrawable();
        }
        this.fadeOutDrawable = drawable3;
        if (drawable2 != null) {
            drawable4 = drawable2.getConstantState().newDrawable().mutate();
        } else {
            drawable4 = new EmptyDrawable();
        }
        this.fadeInDrawable = drawable4;
        int i6 = 3;
        if (drawable != null) {
            i5 = DrawableCompat.getLayoutDirection(drawable);
        } else {
            i5 = 3;
        }
        i6 = drawable2 != null ? DrawableCompat.getLayoutDirection(drawable2) : i6;
        DrawableCompat.setLayoutDirection(drawable3, i5);
        DrawableCompat.setLayoutDirection(drawable4, i6);
        drawable4.setAlpha(0);
        this.alphas = new float[2];
    }

    public void draw(@NonNull Canvas canvas) {
        this.fadeOutDrawable.draw(canvas);
        this.fadeInDrawable.draw(canvas);
    }

    public int getIntrinsicHeight() {
        return Math.max(this.fadeOutDrawable.getIntrinsicHeight(), this.fadeInDrawable.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.fadeOutDrawable.getIntrinsicWidth(), this.fadeInDrawable.getIntrinsicWidth());
    }

    public int getMinimumHeight() {
        return Math.max(this.fadeOutDrawable.getMinimumHeight(), this.fadeInDrawable.getMinimumHeight());
    }

    public int getMinimumWidth() {
        return Math.max(this.fadeOutDrawable.getMinimumWidth(), this.fadeInDrawable.getMinimumWidth());
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        if (this.fadeOutDrawable.isStateful() || this.fadeInDrawable.isStateful()) {
            return true;
        }
        return false;
    }

    public void setAlpha(int i5) {
        if (this.progress <= 0.5f) {
            this.fadeOutDrawable.setAlpha(i5);
            this.fadeInDrawable.setAlpha(0);
        } else {
            this.fadeOutDrawable.setAlpha(0);
            this.fadeInDrawable.setAlpha(i5);
        }
        invalidateSelf();
    }

    public void setBounds(int i5, int i6, int i7, int i8) {
        super.setBounds(i5, i6, i7, i8);
        this.fadeOutDrawable.setBounds(i5, i6, i7, i8);
        this.fadeInDrawable.setBounds(i5, i6, i7, i8);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.fadeOutDrawable.setColorFilter(colorFilter);
        this.fadeInDrawable.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f5) {
        if (this.progress != f5) {
            this.progress = f5;
            FadeThroughUtils.calculateFadeOutAndInAlphas(f5, this.alphas);
            this.fadeOutDrawable.setAlpha((int) (this.alphas[0] * 255.0f));
            this.fadeInDrawable.setAlpha((int) (this.alphas[1] * 255.0f));
            invalidateSelf();
        }
    }

    public boolean setState(int[] iArr) {
        boolean state = this.fadeOutDrawable.setState(iArr);
        boolean state2 = this.fadeInDrawable.setState(iArr);
        if (state || state2) {
            return true;
        }
        return false;
    }
}
