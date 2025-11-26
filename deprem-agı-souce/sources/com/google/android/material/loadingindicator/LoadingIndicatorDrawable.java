package com.google.android.material.loadingindicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.google.android.material.R;
import com.google.android.material.progressindicator.AnimatorDurationScaleProvider;

public final class LoadingIndicatorDrawable extends Drawable implements Drawable.Callback {
    @IntRange(from = 0, to = 255)
    int alpha;
    @NonNull
    private LoadingIndicatorAnimatorDelegate animatorDelegate;
    AnimatorDurationScaleProvider animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
    @NonNull
    private final Context context;
    @NonNull
    private LoadingIndicatorDrawingDelegate drawingDelegate;
    @NonNull
    Paint paint = new Paint();
    @NonNull
    private final LoadingIndicatorSpec specs;
    private Drawable staticDummyDrawable;

    LoadingIndicatorDrawable(@NonNull Context context2, @NonNull LoadingIndicatorSpec loadingIndicatorSpec, @NonNull LoadingIndicatorDrawingDelegate loadingIndicatorDrawingDelegate, @NonNull LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
        this.context = context2;
        this.specs = loadingIndicatorSpec;
        this.drawingDelegate = loadingIndicatorDrawingDelegate;
        this.animatorDelegate = loadingIndicatorAnimatorDelegate;
        loadingIndicatorAnimatorDelegate.registerDrawable(this);
        setAlpha(255);
    }

    @NonNull
    public static LoadingIndicatorDrawable create(@NonNull Context context2, @NonNull LoadingIndicatorSpec loadingIndicatorSpec) {
        LoadingIndicatorDrawable loadingIndicatorDrawable = new LoadingIndicatorDrawable(context2, loadingIndicatorSpec, new LoadingIndicatorDrawingDelegate(loadingIndicatorSpec), new LoadingIndicatorAnimatorDelegate(loadingIndicatorSpec));
        loadingIndicatorDrawable.setStaticDummyDrawable(VectorDrawableCompat.create(context2.getResources(), R.drawable.ic_mtrl_arrow_circle, (Resources.Theme) null));
        return loadingIndicatorDrawable;
    }

    private boolean isSystemAnimatorDisabled() {
        AnimatorDurationScaleProvider animatorDurationScaleProvider2 = this.animatorDurationScaleProvider;
        if (animatorDurationScaleProvider2 == null || animatorDurationScaleProvider2.getSystemAnimatorDurationScale(this.context.getContentResolver()) != 0.0f) {
            return false;
        }
        return true;
    }

    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        Rect rect = new Rect();
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            if (!isSystemAnimatorDisabled() || (drawable = this.staticDummyDrawable) == null) {
                canvas.save();
                this.drawingDelegate.adjustCanvas(canvas, bounds);
                this.drawingDelegate.drawContainer(canvas, this.paint, this.specs.containerColor, getAlpha());
                this.drawingDelegate.drawIndicator(canvas, this.paint, this.animatorDelegate.indicatorState, getAlpha());
                canvas.restore();
                return;
            }
            drawable.setBounds(bounds);
            this.staticDummyDrawable.setTint(this.specs.indicatorColors[0]);
            this.staticDummyDrawable.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.alpha;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LoadingIndicatorAnimatorDelegate getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LoadingIndicatorDrawingDelegate getDrawingDelegate() {
        return this.drawingDelegate;
    }

    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    public int getOpacity() {
        return -3;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Drawable getStaticDummyDrawable() {
        return this.staticDummyDrawable;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j5) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j5);
        }
    }

    public void setAlpha(int i5) {
        if (this.alpha != i5) {
            this.alpha = i5;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void setAnimatorDelegate(@NonNull LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
        this.animatorDelegate = loadingIndicatorAnimatorDelegate;
        loadingIndicatorAnimatorDelegate.registerDrawable(this);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void setDrawingDelegate(@NonNull LoadingIndicatorDrawingDelegate loadingIndicatorDrawingDelegate) {
        this.drawingDelegate = loadingIndicatorDrawingDelegate;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStaticDummyDrawable(@Nullable Drawable drawable) {
        this.staticDummyDrawable = drawable;
    }

    public boolean setVisible(boolean z4, boolean z5) {
        return setVisible(z4, z5, z4);
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public boolean setVisible(boolean z4, boolean z5, boolean z6) {
        boolean visible = super.setVisible(z4, z5);
        this.animatorDelegate.cancelAnimatorImmediately();
        if (z4 && z6 && !isSystemAnimatorDisabled()) {
            this.animatorDelegate.startAnimator();
        }
        return visible;
    }
}
