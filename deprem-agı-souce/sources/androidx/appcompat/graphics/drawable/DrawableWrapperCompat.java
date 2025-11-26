package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableWrapperCompat extends Drawable implements Drawable.Callback {
    private Drawable mDrawable;

    public DrawableWrapperCompat(Drawable drawable) {
        setDrawable(drawable);
    }

    public void draw(@NonNull Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    @Nullable
    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.mDrawable.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i5) {
        return this.mDrawable.setLevel(i5);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        scheduleSelf(runnable, j5);
    }

    public void setAlpha(int i5) {
        this.mDrawable.setAlpha(i5);
    }

    public void setAutoMirrored(boolean z4) {
        DrawableCompat.setAutoMirrored(this.mDrawable, z4);
    }

    public void setChangingConfigurations(int i5) {
        this.mDrawable.setChangingConfigurations(i5);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public void setDither(boolean z4) {
        this.mDrawable.setDither(z4);
    }

    public void setDrawable(@Nullable Drawable drawable) {
        Drawable drawable2 = this.mDrawable;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void setFilterBitmap(boolean z4) {
        this.mDrawable.setFilterBitmap(z4);
    }

    public void setHotspot(float f5, float f6) {
        DrawableCompat.setHotspot(this.mDrawable, f5, f6);
    }

    public void setHotspotBounds(int i5, int i6, int i7, int i8) {
        DrawableCompat.setHotspotBounds(this.mDrawable, i5, i6, i7, i8);
    }

    public boolean setState(int[] iArr) {
        return this.mDrawable.setState(iArr);
    }

    public void setTint(int i5) {
        DrawableCompat.setTint(this.mDrawable, i5);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.mDrawable, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        DrawableCompat.setTintMode(this.mDrawable, mode);
    }

    public boolean setVisible(boolean z4, boolean z5) {
        if (super.setVisible(z4, z5) || this.mDrawable.setVisible(z4, z5)) {
            return true;
        }
        return false;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
