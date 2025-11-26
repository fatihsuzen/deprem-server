package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.List;

abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable2Compat {
    private static final boolean DEFAULT_DRAWABLE_RESTART = false;
    private static final float DEFAULT_MOCK_PHASE_FRACTION = -1.0f;
    private static final int GROW_DURATION = 500;
    private static final Property<DrawableWithAnimatedVisibilityChange, Float> GROW_FRACTION = new Property<DrawableWithAnimatedVisibilityChange, Float>(Float.class, "growFraction") {
        public Float get(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
            return Float.valueOf(drawableWithAnimatedVisibilityChange.getGrowFraction());
        }

        public void set(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange, Float f5) {
            drawableWithAnimatedVisibilityChange.setGrowFraction(f5.floatValue());
        }
    };
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    final BaseProgressIndicatorSpec baseSpec;
    @NonNull
    Rect clipBounds;
    final Context context;
    private float growFraction;
    private ValueAnimator hideAnimator;
    private boolean ignoreCallbacks;
    private Animatable2Compat.AnimationCallback internalAnimationCallback;
    private float mockGrowFraction;
    private boolean mockHideAnimationRunning;
    private float mockPhaseFraction = -1.0f;
    private boolean mockShowAnimationRunning;
    final Paint paint = new Paint();
    private ValueAnimator showAnimator;
    @IntRange(from = 0, to = 255)
    private int totalAlpha;

    DrawableWithAnimatedVisibilityChange(@NonNull Context context2, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.context = context2;
        this.baseSpec = baseProgressIndicatorSpec;
        this.clipBounds = new Rect();
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        setAlpha(255);
    }

    private void cancelAnimatorsWithoutCallbacks(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z4 = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        for (ValueAnimator cancel : valueAnimatorArr) {
            cancel.cancel();
        }
        this.ignoreCallbacks = z4;
    }

    /* access modifiers changed from: private */
    public void dispatchAnimationEnd() {
        Animatable2Compat.AnimationCallback animationCallback = this.internalAnimationCallback;
        if (animationCallback != null) {
            animationCallback.onAnimationEnd(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list != null && !this.ignoreCallbacks) {
            for (Animatable2Compat.AnimationCallback onAnimationEnd : list) {
                onAnimationEnd.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void dispatchAnimationStart() {
        Animatable2Compat.AnimationCallback animationCallback = this.internalAnimationCallback;
        if (animationCallback != null) {
            animationCallback.onAnimationStart(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list != null && !this.ignoreCallbacks) {
            for (Animatable2Compat.AnimationCallback onAnimationStart : list) {
                onAnimationStart.onAnimationStart(this);
            }
        }
    }

    private void endAnimatorsWithoutCallbacks(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z4 = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        for (ValueAnimator end : valueAnimatorArr) {
            end.end();
        }
        this.ignoreCallbacks = z4;
    }

    private boolean isDeterminateDrawable() {
        return this instanceof DeterminateDrawable;
    }

    private void maybeInitializeAnimators() {
        if (this.showAnimator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{0.0f, 1.0f});
            this.showAnimator = ofFloat;
            ofFloat.setDuration(500);
            this.showAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            setShowAnimator(this.showAnimator);
        }
        if (this.hideAnimator == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{1.0f, 0.0f});
            this.hideAnimator = ofFloat2;
            ofFloat2.setDuration(500);
            this.hideAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            setHideAnimator(this.hideAnimator);
        }
    }

    private void setHideAnimator(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.hideAnimator;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.hideAnimator = valueAnimator;
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = DrawableWithAnimatedVisibilityChange.super.setVisible(false, false);
                    DrawableWithAnimatedVisibilityChange.this.dispatchAnimationEnd();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }

    private void setShowAnimator(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.showAnimator;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.showAnimator = valueAnimator;
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    DrawableWithAnimatedVisibilityChange.this.dispatchAnimationStart();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }

    public void clearAnimationCallbacks() {
        this.animationCallbacks.clear();
        this.animationCallbacks = null;
    }

    public int getAlpha() {
        return this.totalAlpha;
    }

    /* access modifiers changed from: package-private */
    public float getGrowFraction() {
        if (!this.baseSpec.isShowAnimationEnabled() && !this.baseSpec.isHideAnimationEnabled()) {
            return 1.0f;
        }
        if (this.mockHideAnimationRunning || this.mockShowAnimationRunning) {
            return this.mockGrowFraction;
        }
        return this.growFraction;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ValueAnimator getHideAnimator() {
        return this.hideAnimator;
    }

    public int getOpacity() {
        return -3;
    }

    /* access modifiers changed from: package-private */
    public float getPhaseFraction() {
        int i5;
        float f5 = this.mockPhaseFraction;
        if (f5 > 0.0f) {
            return f5;
        }
        if (this.baseSpec.hasWavyEffect(isDeterminateDrawable()) && this.baseSpec.waveSpeed != 0) {
            float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
            if (systemAnimatorDurationScale > 0.0f) {
                if (isDeterminateDrawable()) {
                    i5 = this.baseSpec.wavelengthDeterminate;
                } else {
                    i5 = this.baseSpec.wavelengthIndeterminate;
                }
                int i6 = (int) (((((float) i5) * 1000.0f) / ((float) this.baseSpec.waveSpeed)) * systemAnimatorDurationScale);
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() % ((long) i6))) / ((float) i6);
                if (uptimeMillis < 0.0f) {
                    return (uptimeMillis % 1.0f) + 1.0f;
                }
                return uptimeMillis;
            }
        }
        return 0.0f;
    }

    public boolean hideNow() {
        return setVisible(false, false, false);
    }

    public boolean isHiding() {
        ValueAnimator valueAnimator = this.hideAnimator;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && !this.mockHideAnimationRunning) {
            return false;
        }
        return true;
    }

    public boolean isRunning() {
        if (isShowing() || isHiding()) {
            return true;
        }
        return false;
    }

    public boolean isShowing() {
        ValueAnimator valueAnimator = this.showAnimator;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && !this.mockShowAnimationRunning) {
            return false;
        }
        return true;
    }

    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (this.animationCallbacks == null) {
            this.animationCallbacks = new ArrayList();
        }
        if (!this.animationCallbacks.contains(animationCallback)) {
            this.animationCallbacks.add(animationCallback);
        }
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i5) {
        this.totalAlpha = i5;
        invalidateSelf();
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void setGrowFraction(@FloatRange(from = 0.0d, to = 1.0d) float f5) {
        if (this.growFraction != f5) {
            this.growFraction = f5;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void setInternalAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.internalAnimationCallback = animationCallback;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setMockHideAnimationRunning(boolean z4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
        this.mockHideAnimationRunning = z4;
        this.mockGrowFraction = f5;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setMockPhaseFraction(@FloatRange(from = 0.0d, to = 1.0d) float f5) {
        this.mockPhaseFraction = f5;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setMockShowAnimationRunning(boolean z4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
        this.mockShowAnimationRunning = z4;
        this.mockGrowFraction = f5;
    }

    public boolean setVisible(boolean z4, boolean z5) {
        return setVisible(z4, z5, true);
    }

    /* access modifiers changed from: package-private */
    public boolean setVisibleInternal(boolean z4, boolean z5, boolean z6) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        boolean z7;
        boolean z8;
        maybeInitializeAnimators();
        if (!isVisible() && !z4) {
            return false;
        }
        if (z4) {
            valueAnimator = this.showAnimator;
        } else {
            valueAnimator = this.hideAnimator;
        }
        if (z4) {
            valueAnimator2 = this.hideAnimator;
        } else {
            valueAnimator2 = this.showAnimator;
        }
        if (!z6) {
            if (valueAnimator2.isRunning()) {
                cancelAnimatorsWithoutCallbacks(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                endAnimatorsWithoutCallbacks(valueAnimator);
            }
            return super.setVisible(z4, false);
        } else if (valueAnimator.isRunning()) {
            return false;
        } else {
            if (!z4 || super.setVisible(z4, false)) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z4) {
                z8 = this.baseSpec.isShowAnimationEnabled();
            } else {
                z8 = this.baseSpec.isHideAnimationEnabled();
            }
            if (!z8) {
                endAnimatorsWithoutCallbacks(valueAnimator);
                return z7;
            } else if (z5 || !valueAnimator.isPaused()) {
                valueAnimator.start();
                return z7;
            } else {
                valueAnimator.resume();
                return z7;
            }
        }
    }

    public void start() {
        setVisibleInternal(true, true, false);
    }

    public void stop() {
        setVisibleInternal(false, true, false);
    }

    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list == null || !list.contains(animationCallback)) {
            return false;
        }
        this.animationCallbacks.remove(animationCallback);
        if (!this.animationCallbacks.isEmpty()) {
            return true;
        }
        this.animationCallbacks = null;
        return true;
    }

    public boolean setVisible(boolean z4, boolean z5, boolean z6) {
        return setVisibleInternal(z4, z5, z6 && this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver()) > 0.0f);
    }
}
