package com.google.android.material.loadingindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.loadingindicator.LoadingIndicatorDrawingDelegate;

class LoadingIndicatorAnimatorDelegate {
    private static final Property<LoadingIndicatorAnimatorDelegate, Float> ANIMATION_FRACTION = new Property<LoadingIndicatorAnimatorDelegate, Float>(Float.class, "animationFraction") {
        public Float get(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
            return Float.valueOf(loadingIndicatorAnimatorDelegate.getAnimationFraction());
        }

        public void set(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate, Float f5) {
            loadingIndicatorAnimatorDelegate.setAnimationFraction(f5.floatValue());
        }
    };
    private static final int CONSTANT_ROTATION_PER_SHAPE_DEGREES = 50;
    private static final int DURATION_PER_SHAPE_IN_MS = 650;
    private static final int EXTRA_ROTATION_PER_SHAPE_DEGREES = 90;
    private static final FloatPropertyCompat<LoadingIndicatorAnimatorDelegate> MORPH_FACTOR = new FloatPropertyCompat<LoadingIndicatorAnimatorDelegate>("morphFactor") {
        public float getValue(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
            return loadingIndicatorAnimatorDelegate.getMorphFactor();
        }

        public void setValue(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate, float f5) {
            loadingIndicatorAnimatorDelegate.setMorphFactor(f5);
        }
    };
    private static final float SPRING_DAMPING_RATIO = 0.6f;
    private static final float SPRING_STIFFNESS = 200.0f;
    private float animationFraction;
    private ObjectAnimator animator;
    @Nullable
    LoadingIndicatorDrawable drawable;
    LoadingIndicatorDrawingDelegate.IndicatorState indicatorState = new LoadingIndicatorDrawingDelegate.IndicatorState();
    private float morphFactor;
    private int morphFactorTarget;
    @NonNull
    LoadingIndicatorSpec specs;
    /* access modifiers changed from: private */
    public SpringAnimation springAnimation;

    public LoadingIndicatorAnimatorDelegate(@NonNull LoadingIndicatorSpec loadingIndicatorSpec) {
        this.specs = loadingIndicatorSpec;
    }

    static /* synthetic */ int access$004(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
        int i5 = loadingIndicatorAnimatorDelegate.morphFactorTarget + 1;
        loadingIndicatorAnimatorDelegate.morphFactorTarget = i5;
        return i5;
    }

    /* access modifiers changed from: private */
    public float getAnimationFraction() {
        return this.animationFraction;
    }

    /* access modifiers changed from: private */
    public float getMorphFactor() {
        return this.morphFactor;
    }

    private void maybeInitializeAnimators() {
        if (this.springAnimation == null) {
            this.springAnimation = (SpringAnimation) new SpringAnimation(this, MORPH_FACTOR).setSpring(new SpringForce().setStiffness(200.0f).setDampingRatio(SPRING_DAMPING_RATIO)).setMinimumVisibleChange(0.01f);
        }
        if (this.animator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
            this.animator = ofFloat;
            ofFloat.setDuration(650);
            this.animator.setInterpolator((TimeInterpolator) null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LoadingIndicatorAnimatorDelegate.this.springAnimation.animateToFinalPosition((float) LoadingIndicatorAnimatorDelegate.access$004(LoadingIndicatorAnimatorDelegate.this));
                }
            });
        }
    }

    private void updateIndicatorRotation(int i5) {
        float f5 = (float) (this.morphFactorTarget - 1);
        float f6 = this.morphFactor - f5;
        float f7 = ((float) i5) / 650.0f;
        if (f7 == 1.0f) {
            f7 = 0.0f;
        }
        this.indicatorState.rotationDegree = (((f5 * 140.0f) + (f7 * 50.0f)) + (f6 * 90.0f)) % 360.0f;
    }

    private void updateIndicatorShapeAndColor() {
        LoadingIndicatorDrawingDelegate.IndicatorState indicatorState2 = this.indicatorState;
        indicatorState2.morphFraction = this.morphFactor;
        int[] iArr = this.specs.indicatorColors;
        int length = (this.morphFactorTarget - 1) % iArr.length;
        indicatorState2.color = ArgbEvaluatorCompat.getInstance().evaluate(MathUtils.clamp(this.morphFactor - ((float) (this.morphFactorTarget - 1)), 0.0f, 1.0f), Integer.valueOf(iArr[length]), Integer.valueOf(iArr[(length + 1) % iArr.length])).intValue();
    }

    /* access modifiers changed from: package-private */
    public void cancelAnimatorImmediately() {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        SpringAnimation springAnimation2 = this.springAnimation;
        if (springAnimation2 != null) {
            springAnimation2.skipToEnd();
        }
    }

    /* access modifiers changed from: package-private */
    public void invalidateSpecValues() {
        resetPropertiesForNewStart();
    }

    /* access modifiers changed from: protected */
    public void registerDrawable(@NonNull LoadingIndicatorDrawable loadingIndicatorDrawable) {
        this.drawable = loadingIndicatorDrawable;
    }

    /* access modifiers changed from: package-private */
    public void resetPropertiesForNewStart() {
        this.morphFactorTarget = 1;
        setMorphFactor(0.0f);
        this.indicatorState.color = this.specs.indicatorColors[0];
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setAnimationFraction(float f5) {
        this.animationFraction = f5;
        updateIndicatorRotation((int) (f5 * 650.0f));
        LoadingIndicatorDrawable loadingIndicatorDrawable = this.drawable;
        if (loadingIndicatorDrawable != null) {
            loadingIndicatorDrawable.invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setMorphFactor(float f5) {
        this.morphFactor = f5;
        updateIndicatorShapeAndColor();
        LoadingIndicatorDrawable loadingIndicatorDrawable = this.drawable;
        if (loadingIndicatorDrawable != null) {
            loadingIndicatorDrawable.invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setMorphFactorTarget(int i5) {
        this.morphFactorTarget = i5;
    }

    /* access modifiers changed from: package-private */
    public void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.springAnimation.animateToFinalPosition((float) this.morphFactorTarget);
        this.animator.start();
    }
}
