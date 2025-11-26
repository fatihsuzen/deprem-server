package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {
    static final float DEFAULT_OPACITY = 0.2f;
    static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_ProgressIndicator;
    public static final int HIDE_ESCAPE = 3;
    public static final int HIDE_INWARD = 2;
    public static final int HIDE_NONE = 0;
    public static final int HIDE_OUTWARD = 1;
    static final int MAX_ALPHA = 255;
    static final int MAX_HIDE_DELAY = 1000;
    public static final int SHOW_INWARD = 2;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OUTWARD = 1;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    private final Runnable delayedHide = new Runnable() {
        public void run() {
            BaseProgressIndicator.this.internalHide();
            long unused = BaseProgressIndicator.this.lastShowStartTime = -1;
        }
    };
    private final Runnable delayedShow = new Runnable() {
        public void run() {
            BaseProgressIndicator.this.internalShow();
        }
    };
    private final Animatable2Compat.AnimationCallback hideAnimationCallback = new Animatable2Compat.AnimationCallback() {
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            if (!BaseProgressIndicator.this.isIndeterminateModeChangeRequested) {
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.setVisibility(baseProgressIndicator.visibilityAfterHide);
            }
        }
    };
    boolean initialized;
    /* access modifiers changed from: private */
    public boolean isIndeterminateModeChangeRequested = false;
    private boolean isParentDoneInitializing;
    /* access modifiers changed from: private */
    public long lastShowStartTime = -1;
    private final int minHideDelay;
    private final int showDelay;
    S spec;
    /* access modifiers changed from: private */
    public int storedProgress;
    /* access modifiers changed from: private */
    public boolean storedProgressAnimated;
    private final Animatable2Compat.AnimationCallback switchIndeterminateModeCallback = new Animatable2Compat.AnimationCallback() {
        public void onAnimationEnd(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setProgressCompat(baseProgressIndicator.storedProgress, BaseProgressIndicator.this.storedProgressAnimated);
        }
    };
    /* access modifiers changed from: private */
    public int visibilityAfterHide = 4;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HideAnimationBehavior {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowAnimationBehavior {
    }

    protected BaseProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5, @StyleRes int i6) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i5, DEF_STYLE_RES), attributeSet, i5);
        Context context2 = getContext();
        this.spec = createSpec(context2, attributeSet);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.BaseProgressIndicator, i5, i6, new int[0]);
        this.showDelay = obtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.minHideDelay = Math.min(obtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        obtainStyledAttributes.recycle();
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        this.isParentDoneInitializing = true;
    }

    @Nullable
    private DrawingDelegate<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().getDrawingDelegate();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().getDrawingDelegate();
        }
    }

    /* access modifiers changed from: private */
    public void internalHide() {
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(false, false, true);
        if (isNoLongerNeedToBeVisible()) {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public void internalShow() {
        if (this.minHideDelay > 0) {
            this.lastShowStartTime = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean isNoLongerNeedToBeVisible() {
        if (getProgressDrawable() != null && getProgressDrawable().isVisible()) {
            return false;
        }
        if (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible()) {
            return true;
        }
        return false;
    }

    private void registerAnimationCallbacks() {
        registerSwitchIndeterminateModeCallback();
        if (getProgressDrawable() != null) {
            getProgressDrawable().registerAnimationCallback(this.hideAnimationCallback);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().registerAnimationCallback(this.hideAnimationCallback);
        }
    }

    private void unregisterAnimationCallbacks() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
            getIndeterminateDrawable().getAnimatorDelegate().unregisterAnimatorsCompleteCallback();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void applyNewVisibility(boolean z4) {
        if (this.isParentDoneInitializing) {
            ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(visibleToUser(), false, z4);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract S createSpec(@NonNull Context context, @NonNull AttributeSet attributeSet);

    @Nullable
    public Drawable getCurrentDrawable() {
        if (isIndeterminate()) {
            return getIndeterminateDrawable();
        }
        return getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.spec.hideAnimationBehavior;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.spec.indicatorColors;
    }

    @Px
    public int getIndicatorTrackGapSize() {
        return this.spec.indicatorTrackGapSize;
    }

    public int getShowAnimationBehavior() {
        return this.spec.showAnimationBehavior;
    }

    @ColorInt
    public int getTrackColor() {
        return this.spec.trackColor;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.spec.trackCornerRadius;
    }

    public float getTrackCornerRadiusFraction() {
        return this.spec.trackCornerRadiusFraction;
    }

    @Px
    public int getTrackThickness() {
        return this.spec.trackThickness;
    }

    @Px
    public int getWaveAmplitude() {
        return this.spec.waveAmplitude;
    }

    @Px
    public int getWaveSpeed() {
        return this.spec.waveSpeed;
    }

    @Px
    public int getWavelengthDeterminate() {
        return this.spec.wavelengthDeterminate;
    }

    @Px
    public int getWavelengthIndeterminate() {
        return this.spec.wavelengthIndeterminate;
    }

    public void hide() {
        if (getVisibility() != 0) {
            removeCallbacks(this.delayedShow);
            return;
        }
        removeCallbacks(this.delayedHide);
        long uptimeMillis = SystemClock.uptimeMillis() - this.lastShowStartTime;
        int i5 = this.minHideDelay;
        if (uptimeMillis >= ((long) i5)) {
            this.delayedHide.run();
        } else {
            postDelayed(this.delayedHide, ((long) i5) - uptimeMillis);
        }
    }

    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isEffectivelyVisible() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() == 0) {
                    return true;
                }
                return false;
            } else if (!(parent instanceof View)) {
                return true;
            } else {
                view = (View) parent;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerAnimationCallbacks();
        if (visibleToUser()) {
            internalShow();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.delayedHide);
        removeCallbacks(this.delayedShow);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).hideNow();
        unregisterAnimationCallbacks();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(@NonNull Canvas canvas) {
        try {
            int save = canvas.save();
            if (getPaddingLeft() == 0) {
                if (getPaddingTop() != 0) {
                }
                if (!(getPaddingRight() == 0 && getPaddingBottom() == 0)) {
                    canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
                }
                getCurrentDrawable().draw(canvas);
                canvas.restoreToCount(save);
            }
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(save);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        getCurrentDrawingDelegate().invalidateCachedPaths();
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i5, int i6) {
        int i7;
        int i8;
        try {
            DrawingDelegate currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate != null) {
                if (currentDrawingDelegate.getPreferredWidth() < 0) {
                    i7 = View.getDefaultSize(getSuggestedMinimumWidth(), i5);
                } else {
                    i7 = currentDrawingDelegate.getPreferredWidth() + getPaddingLeft() + getPaddingRight();
                }
                if (currentDrawingDelegate.getPreferredHeight() < 0) {
                    i8 = View.getDefaultSize(getSuggestedMinimumHeight(), i6);
                } else {
                    i8 = currentDrawingDelegate.getPreferredHeight() + getPaddingTop() + getPaddingBottom();
                }
                setMeasuredDimension(i7, i8);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i5) {
        boolean z4;
        super.onVisibilityChanged(view, i5);
        if (i5 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        applyNewVisibility(z4);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i5) {
        super.onWindowVisibilityChanged(i5);
        applyNewVisibility(false);
    }

    /* access modifiers changed from: package-private */
    public void registerSwitchIndeterminateModeCallback() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().getAnimatorDelegate().registerAnimatorsCompleteCallback(this.switchIndeterminateModeCallback);
        }
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider animatorDurationScaleProvider2) {
        this.animatorDurationScaleProvider = animatorDurationScaleProvider2;
        if (getProgressDrawable() != null) {
            getProgressDrawable().animatorDurationScaleProvider = animatorDurationScaleProvider2;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().animatorDurationScaleProvider = animatorDurationScaleProvider2;
        }
    }

    public void setHideAnimationBehavior(int i5) {
        this.spec.hideAnimationBehavior = i5;
        invalidate();
    }

    public synchronized void setIndeterminate(boolean z4) {
        try {
            if (z4 != isIndeterminate()) {
                DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
                if (drawableWithAnimatedVisibilityChange != null) {
                    drawableWithAnimatedVisibilityChange.hideNow();
                }
                super.setIndeterminate(z4);
                DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
                if (drawableWithAnimatedVisibilityChange2 != null) {
                    drawableWithAnimatedVisibilityChange2.setVisible(visibleToUser(), false, false);
                }
                if ((drawableWithAnimatedVisibilityChange2 instanceof IndeterminateDrawable) && visibleToUser()) {
                    ((IndeterminateDrawable) drawableWithAnimatedVisibilityChange2).getAnimatorDelegate().startAnimator();
                }
                this.isIndeterminateModeChangeRequested = false;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public void setIndeterminateAnimatorDurationScale(@FloatRange(from = 0.10000000149011612d, to = 10.0d) float f5) {
        S s5 = this.spec;
        if (s5.indeterminateAnimatorDurationScale != f5) {
            s5.indeterminateAnimatorDurationScale = f5;
            getIndeterminateDrawable().getAnimatorDelegate().invalidateSpecValues();
        }
    }

    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable instanceof IndeterminateDrawable) {
            ((DrawableWithAnimatedVisibilityChange) drawable).hideNow();
            super.setIndeterminateDrawable(drawable);
        } else if (!this.initialized) {
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.getColor(getContext(), androidx.appcompat.R.attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.spec.indicatorColors = iArr;
            getIndeterminateDrawable().getAnimatorDelegate().invalidateSpecValues();
            invalidate();
        }
    }

    public void setIndicatorTrackGapSize(@Px int i5) {
        S s5 = this.spec;
        if (s5.indicatorTrackGapSize != i5) {
            s5.indicatorTrackGapSize = i5;
            s5.validateSpec();
            invalidate();
        }
    }

    public synchronized void setProgress(int i5) {
        if (!isIndeterminate()) {
            setProgressCompat(i5, false);
        }
    }

    public void setProgressCompat(int i5, boolean z4) {
        if (!isIndeterminate()) {
            super.setProgress(i5);
            if (getProgressDrawable() != null && !z4) {
                getProgressDrawable().jumpToCurrentState();
            }
        } else if (getProgressDrawable() != null) {
            this.storedProgress = i5;
            this.storedProgressAnimated = z4;
            this.isIndeterminateModeChangeRequested = true;
            if (!getIndeterminateDrawable().isVisible() || this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(getContext().getContentResolver()) == 0.0f) {
                this.switchIndeterminateModeCallback.onAnimationEnd(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().getAnimatorDelegate().requestCancelAnimatorAfterCurrentCycle();
            }
        }
    }

    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable instanceof DeterminateDrawable) {
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
            determinateDrawable.hideNow();
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.setLevelByFraction(((float) getProgress()) / ((float) getMax()));
        } else if (!this.initialized) {
            super.setProgressDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i5) {
        this.spec.showAnimationBehavior = i5;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i5) {
        S s5 = this.spec;
        if (s5.trackColor != i5) {
            s5.trackColor = i5;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i5) {
        S s5 = this.spec;
        if (s5.trackCornerRadius != i5) {
            s5.trackCornerRadius = Math.min(i5, s5.trackThickness / 2);
            this.spec.useRelativeTrackCornerRadius = false;
            invalidate();
        }
    }

    public void setTrackCornerRadiusFraction(@FloatRange(from = 0.0d, to = 0.5d) float f5) {
        S s5 = this.spec;
        if (s5.trackCornerRadiusFraction != f5) {
            s5.trackCornerRadiusFraction = Math.min(f5, 0.5f);
            this.spec.useRelativeTrackCornerRadius = true;
            invalidate();
        }
    }

    public void setTrackThickness(@Px int i5) {
        S s5 = this.spec;
        if (s5.trackThickness != i5) {
            s5.trackThickness = i5;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i5) {
        if (i5 == 0 || i5 == 4 || i5 == 8) {
            this.visibilityAfterHide = i5;
            return;
        }
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }

    public void setWaveAmplitude(@Px int i5) {
        S s5 = this.spec;
        if (s5.waveAmplitude != i5) {
            s5.waveAmplitude = Math.abs(i5);
            requestLayout();
        }
    }

    public void setWaveSpeed(@Px int i5) {
        boolean z4;
        this.spec.waveSpeed = i5;
        DeterminateDrawable progressDrawable = getProgressDrawable();
        if (this.spec.waveSpeed != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        progressDrawable.setEnforcedDrawing(z4);
    }

    public void setWavelength(@Px int i5) {
        setWavelengthDeterminate(i5);
        setWavelengthIndeterminate(i5);
    }

    public void setWavelengthDeterminate(@Px int i5) {
        S s5 = this.spec;
        if (s5.wavelengthDeterminate != i5) {
            s5.wavelengthDeterminate = Math.abs(i5);
            if (!isIndeterminate()) {
                requestLayout();
            }
        }
    }

    public void setWavelengthIndeterminate(@Px int i5) {
        S s5 = this.spec;
        if (s5.wavelengthIndeterminate != i5) {
            s5.wavelengthIndeterminate = Math.abs(i5);
            if (isIndeterminate()) {
                requestLayout();
            }
        }
    }

    public void show() {
        if (this.showDelay > 0) {
            removeCallbacks(this.delayedShow);
            postDelayed(this.delayedShow, (long) this.showDelay);
            return;
        }
        this.delayedShow.run();
    }

    /* access modifiers changed from: package-private */
    public boolean visibleToUser() {
        if (!isAttachedToWindow() || getWindowVisibility() != 0 || !isEffectivelyVisible()) {
            return false;
        }
        return true;
    }

    @Nullable
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Nullable
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}
