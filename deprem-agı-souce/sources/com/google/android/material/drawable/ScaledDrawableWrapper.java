package com.google.android.material.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ScaledDrawableWrapper extends DrawableWrapperCompat {
    private boolean mutated;
    private ScaledDrawableWrapperState state;

    public ScaledDrawableWrapper(@NonNull Drawable drawable, int i5, int i6) {
        super(drawable);
        this.state = new ScaledDrawableWrapperState(getConstantStateFrom(drawable), i5, i6);
    }

    @Nullable
    private Drawable.ConstantState getConstantStateFrom(@Nullable Drawable drawable) {
        if (drawable != null) {
            return drawable.getConstantState();
        }
        return null;
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        if (this.state.canConstantState()) {
            return this.state;
        }
        return null;
    }

    public int getIntrinsicHeight() {
        return this.state.height;
    }

    public int getIntrinsicWidth() {
        return this.state.width;
    }

    @NonNull
    public Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                drawable.mutate();
            }
            this.state = new ScaledDrawableWrapperState(getConstantStateFrom(drawable), this.state.width, this.state.height);
            this.mutated = true;
        }
        return this;
    }

    public void setDrawable(@Nullable Drawable drawable) {
        super.setDrawable(drawable);
        ScaledDrawableWrapperState scaledDrawableWrapperState = this.state;
        if (scaledDrawableWrapperState != null) {
            Drawable.ConstantState unused = scaledDrawableWrapperState.wrappedDrawableState = getConstantStateFrom(drawable);
            this.mutated = false;
        }
    }

    private static final class ScaledDrawableWrapperState extends Drawable.ConstantState {
        /* access modifiers changed from: private */
        public final int height;
        /* access modifiers changed from: private */
        public final int width;
        /* access modifiers changed from: private */
        public Drawable.ConstantState wrappedDrawableState;

        ScaledDrawableWrapperState(@Nullable Drawable.ConstantState constantState, int i5, int i6) {
            this.wrappedDrawableState = constantState;
            this.width = i5;
            this.height = i6;
        }

        /* access modifiers changed from: package-private */
        public boolean canConstantState() {
            if (this.wrappedDrawableState != null) {
                return true;
            }
            return false;
        }

        public int getChangingConfigurations() {
            Drawable.ConstantState constantState = this.wrappedDrawableState;
            if (constantState != null) {
                return constantState.getChangingConfigurations();
            }
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            return new ScaledDrawableWrapper(this.wrappedDrawableState.newDrawable(), this.width, this.height);
        }

        @NonNull
        public Drawable newDrawable(@Nullable Resources resources) {
            return new ScaledDrawableWrapper(this.wrappedDrawableState.newDrawable(resources), this.width, this.height);
        }

        @NonNull
        public Drawable newDrawable(@Nullable Resources resources, @Nullable Resources.Theme theme) {
            return new ScaledDrawableWrapper(this.wrappedDrawableState.newDrawable(resources, theme), this.width, this.height);
        }
    }
}
