package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.progressindicator.DrawingDelegate;

final class CircularIndeterminateRetreatAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<CircularIndeterminateRetreatAnimatorDelegate, Float> ANIMATION_FRACTION;
    private static final Property<CircularIndeterminateRetreatAnimatorDelegate, Float> COMPLETE_END_FRACTION;
    private static final int CONSTANT_ROTATION_DEGREES = 1080;
    private static final TimeInterpolator DEFAULT_INTERPOLATOR = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    private static final int DELAY_GROW_ACTIVE_IN_MS = 0;
    private static final int DELAY_SHRINK_ACTIVE_IN_MS = 3000;
    /* access modifiers changed from: private */
    public static final int[] DELAY_SPINS_IN_MS = {0, 1500, 3000, 4500};
    private static final int DURATION_GROW_ACTIVE_IN_MS = 3000;
    private static final int DURATION_SHRINK_ACTIVE_IN_MS = 3000;
    private static final int DURATION_SPIN_IN_MS = 500;
    private static final int DURATION_TO_COMPLETE_END_IN_MS = 500;
    private static final int DURATION_TO_FADE_IN_MS = 100;
    private static final float[] END_FRACTION_RANGE = {0.1f, 0.87f};
    private static final int SPIN_ROTATION_DEGREES = 90;
    private static final float START_FRACTION = 0.0f;
    private static final int TOTAL_DURATION_IN_MS = 6000;
    private float animationFraction;
    private ObjectAnimator animator;
    Animatable2Compat.AnimationCallback animatorCompleteCallback = null;
    /* access modifiers changed from: private */
    public final BaseProgressIndicatorSpec baseSpec;
    private ObjectAnimator completeEndAnimator;
    private float completeEndFraction;
    /* access modifiers changed from: private */
    public int indicatorColorIndexOffset = 0;
    private final TimeInterpolator standardInterpolator;

    static {
        Class<Float> cls = Float.class;
        ANIMATION_FRACTION = new Property<CircularIndeterminateRetreatAnimatorDelegate, Float>(cls, "animationFraction") {
            public Float get(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate) {
                return Float.valueOf(circularIndeterminateRetreatAnimatorDelegate.getAnimationFraction());
            }

            public void set(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate, Float f5) {
                circularIndeterminateRetreatAnimatorDelegate.setAnimationFraction(f5.floatValue());
            }
        };
        COMPLETE_END_FRACTION = new Property<CircularIndeterminateRetreatAnimatorDelegate, Float>(cls, "completeEndFraction") {
            public Float get(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate) {
                return Float.valueOf(circularIndeterminateRetreatAnimatorDelegate.getCompleteEndFraction());
            }

            public void set(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate, Float f5) {
                circularIndeterminateRetreatAnimatorDelegate.setCompleteEndFraction(f5.floatValue());
            }
        };
    }

    public CircularIndeterminateRetreatAnimatorDelegate(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.baseSpec = circularProgressIndicatorSpec;
        this.standardInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingStandardInterpolator, DEFAULT_INTERPOLATOR);
    }

    /* access modifiers changed from: private */
    public float getAnimationFraction() {
        return this.animationFraction;
    }

    /* access modifiers changed from: private */
    public float getCompleteEndFraction() {
        return this.completeEndFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
            this.animator = ofFloat;
            ofFloat.setDuration((long) (this.baseSpec.indeterminateAnimatorDurationScale * 6000.0f));
            this.animator.setInterpolator((TimeInterpolator) null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate = CircularIndeterminateRetreatAnimatorDelegate.this;
                    int unused = circularIndeterminateRetreatAnimatorDelegate.indicatorColorIndexOffset = (circularIndeterminateRetreatAnimatorDelegate.indicatorColorIndexOffset + CircularIndeterminateRetreatAnimatorDelegate.DELAY_SPINS_IN_MS.length) % CircularIndeterminateRetreatAnimatorDelegate.this.baseSpec.indicatorColors.length;
                }
            });
        }
        if (this.completeEndAnimator == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, COMPLETE_END_FRACTION, new float[]{0.0f, 1.0f});
            this.completeEndAnimator = ofFloat2;
            ofFloat2.setDuration((long) (this.baseSpec.indeterminateAnimatorDurationScale * 500.0f));
            this.completeEndAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    CircularIndeterminateRetreatAnimatorDelegate.this.cancelAnimatorImmediately();
                    CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate = CircularIndeterminateRetreatAnimatorDelegate.this;
                    Animatable2Compat.AnimationCallback animationCallback = circularIndeterminateRetreatAnimatorDelegate.animatorCompleteCallback;
                    if (animationCallback != null) {
                        animationCallback.onAnimationEnd(circularIndeterminateRetreatAnimatorDelegate.drawable);
                    }
                }
            });
        }
    }

    private void maybeUpdateSegmentColors(int i5) {
        int i6 = 0;
        while (true) {
            int[] iArr = DELAY_SPINS_IN_MS;
            if (i6 < iArr.length) {
                float fractionInRange = getFractionInRange(i5, iArr[i6], 100);
                if (fractionInRange < 0.0f || fractionInRange > 1.0f) {
                    i6++;
                } else {
                    int i7 = i6 + this.indicatorColorIndexOffset;
                    int[] iArr2 = this.baseSpec.indicatorColors;
                    int length = i7 % iArr2.length;
                    this.activeIndicators.get(0).color = ArgbEvaluatorCompat.getInstance().evaluate(this.standardInterpolator.getInterpolation(fractionInRange), Integer.valueOf(iArr2[length]), Integer.valueOf(iArr2[(length + 1) % iArr2.length])).intValue();
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void setCompleteEndFraction(float f5) {
        this.completeEndFraction = f5;
    }

    private void updateAnimatorsDuration() {
        maybeInitializeAnimators();
        this.animator.setDuration((long) (this.baseSpec.indeterminateAnimatorDurationScale * 6000.0f));
        this.completeEndAnimator.setDuration((long) (this.baseSpec.indeterminateAnimatorDurationScale * 500.0f));
    }

    private void updateSegmentPositions(int i5) {
        DrawingDelegate.ActiveIndicator activeIndicator = this.activeIndicators.get(0);
        float f5 = this.animationFraction * 1080.0f;
        float f6 = 0.0f;
        for (int fractionInRange : DELAY_SPINS_IN_MS) {
            f6 += this.standardInterpolator.getInterpolation(getFractionInRange(i5, fractionInRange, 500)) * 90.0f;
        }
        activeIndicator.rotationDegree = f5 + f6;
        float interpolation = this.standardInterpolator.getInterpolation(getFractionInRange(i5, 0, 3000)) - this.standardInterpolator.getInterpolation(getFractionInRange(i5, 3000, 3000));
        activeIndicator.startFraction = 0.0f;
        float[] fArr = END_FRACTION_RANGE;
        float lerp = MathUtils.lerp(fArr[0], fArr[1], interpolation);
        activeIndicator.endFraction = lerp;
        float f7 = this.completeEndFraction;
        if (f7 > 0.0f) {
            activeIndicator.endFraction = lerp * (1.0f - f7);
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelAnimatorImmediately() {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void invalidateSpecValues() {
        updateAnimatorsDuration();
        resetPropertiesForNewStart();
    }

    public void registerAnimatorsCompleteCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.animatorCompleteCallback = animationCallback;
    }

    /* access modifiers changed from: package-private */
    public void requestCancelAnimatorAfterCurrentCycle() {
        ObjectAnimator objectAnimator = this.completeEndAnimator;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            if (this.drawable.isVisible()) {
                this.completeEndAnimator.start();
            } else {
                cancelAnimatorImmediately();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void resetPropertiesForNewStart() {
        this.indicatorColorIndexOffset = 0;
        this.activeIndicators.get(0).color = this.baseSpec.indicatorColors[0];
        this.completeEndFraction = 0.0f;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setAnimationFraction(float f5) {
        this.animationFraction = f5;
        int i5 = (int) (f5 * 6000.0f);
        updateSegmentPositions(i5);
        maybeUpdateSegmentColors(i5);
        this.drawable.invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    public void unregisterAnimatorsCompleteCallback() {
        this.animatorCompleteCallback = null;
    }
}
