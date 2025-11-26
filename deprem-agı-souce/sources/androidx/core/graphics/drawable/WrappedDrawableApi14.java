package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private boolean mColorFilterSet;
    private int mCurrentColor;
    private PorterDuff.Mode mCurrentMode;
    Drawable mDrawable;
    private boolean mMutated;
    WrappedDrawableState mState;

    WrappedDrawableApi14(@NonNull WrappedDrawableState wrappedDrawableState, @Nullable Resources resources) {
        this.mState = wrappedDrawableState;
        updateLocalState(resources);
    }

    @NonNull
    private WrappedDrawableState mutateConstantState() {
        return new WrappedDrawableState(this.mState);
    }

    private void updateLocalState(@Nullable Resources resources) {
        Drawable.ConstantState constantState;
        WrappedDrawableState wrappedDrawableState = this.mState;
        if (wrappedDrawableState != null && (constantState = wrappedDrawableState.mDrawableState) != null) {
            setWrappedDrawable(constantState.newDrawable(resources));
        }
    }

    private boolean updateTint(int[] iArr) {
        if (!isCompatTintEnabled()) {
            return false;
        }
        WrappedDrawableState wrappedDrawableState = this.mState;
        ColorStateList colorStateList = wrappedDrawableState.mTint;
        PorterDuff.Mode mode = wrappedDrawableState.mTintMode;
        if (colorStateList == null || mode == null) {
            this.mColorFilterSet = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.mColorFilterSet && colorForState == this.mCurrentColor && mode == this.mCurrentMode)) {
                setColorFilter(colorForState, mode);
                this.mCurrentColor = colorForState;
                this.mCurrentMode = mode;
                this.mColorFilterSet = true;
                return true;
            }
        }
        return false;
    }

    public void draw(@NonNull Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    public int getChangingConfigurations() {
        int i5;
        int changingConfigurations = super.getChangingConfigurations();
        WrappedDrawableState wrappedDrawableState = this.mState;
        if (wrappedDrawableState != null) {
            i5 = wrappedDrawableState.getChangingConfigurations();
        } else {
            i5 = 0;
        }
        return changingConfigurations | i5 | this.mDrawable.getChangingConfigurations();
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState wrappedDrawableState = this.mState;
        if (wrappedDrawableState == null || !wrappedDrawableState.canConstantState()) {
            return null;
        }
        this.mState.mChangingConfigurations = getChangingConfigurations();
        return this.mState;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    @RequiresApi(23)
    public int getLayoutDirection() {
        return DrawableCompat.getLayoutDirection(this.mDrawable);
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

    public boolean getPadding(@NonNull Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    @NonNull
    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public final Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    /* access modifiers changed from: protected */
    public boolean isCompatTintEnabled() {
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        WrappedDrawableState wrappedDrawableState;
        if (!isCompatTintEnabled() || (wrappedDrawableState = this.mState) == null) {
            colorStateList = null;
        } else {
            colorStateList = wrappedDrawableState.mTint;
        }
        if ((colorStateList == null || !colorStateList.isStateful()) && !this.mDrawable.isStateful()) {
            return false;
        }
        return true;
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    @NonNull
    public Drawable mutate() {
        Drawable.ConstantState constantState;
        if (!this.mMutated && super.mutate() == this) {
            this.mState = mutateConstantState();
            Drawable drawable = this.mDrawable;
            if (drawable != null) {
                drawable.mutate();
            }
            WrappedDrawableState wrappedDrawableState = this.mState;
            if (wrappedDrawableState != null) {
                Drawable drawable2 = this.mDrawable;
                if (drawable2 != null) {
                    constantState = drawable2.getConstantState();
                } else {
                    constantState = null;
                }
                wrappedDrawableState.mDrawableState = constantState;
            }
            this.mMutated = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @RequiresApi(23)
    public boolean onLayoutDirectionChanged(int i5) {
        return DrawableCompat.setLayoutDirection(this.mDrawable, i5);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i5) {
        return this.mDrawable.setLevel(i5);
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j5) {
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

    public void setFilterBitmap(boolean z4) {
        this.mDrawable.setFilterBitmap(z4);
    }

    public boolean setState(@NonNull int[] iArr) {
        boolean state = this.mDrawable.setState(iArr);
        if (updateTint(iArr) || state) {
            return true;
        }
        return false;
    }

    public void setTint(int i5) {
        setTintList(ColorStateList.valueOf(i5));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.mState.mTint = colorStateList;
        updateTint(getState());
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        this.mState.mTintMode = mode;
        updateTint(getState());
    }

    public boolean setVisible(boolean z4, boolean z5) {
        if (super.setVisible(z4, z5) || this.mDrawable.setVisible(z4, z5)) {
            return true;
        }
        return false;
    }

    public final void setWrappedDrawable(Drawable drawable) {
        Drawable drawable2 = this.mDrawable;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            WrappedDrawableState wrappedDrawableState = this.mState;
            if (wrappedDrawableState != null) {
                wrappedDrawableState.mDrawableState = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        unscheduleSelf(runnable);
    }

    WrappedDrawableApi14(@Nullable Drawable drawable) {
        this.mState = mutateConstantState();
        setWrappedDrawable(drawable);
    }
}
