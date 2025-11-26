package com.google.android.material.progressindicator;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.math.MathUtils;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DrawingDelegate;

public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private static final int AMPLITUDE_ANIMATION_DURATION_MS = 500;
    private static final float FULL_AMPLITUDE_FRACTION_MAX = 0.9f;
    private static final float FULL_AMPLITUDE_FRACTION_MIN = 0.1f;
    static final float GAP_RAMP_DOWN_THRESHOLD = 0.01f;
    private static final FloatPropertyCompat<DeterminateDrawable<?>> INDICATOR_LENGTH_IN_LEVEL = new FloatPropertyCompat<DeterminateDrawable<?>>("indicatorLevel") {
        public float getValue(DeterminateDrawable<?> determinateDrawable) {
            return determinateDrawable.getIndicatorFraction() * 10000.0f;
        }

        public void setValue(DeterminateDrawable<?> determinateDrawable, float f5) {
            determinateDrawable.setIndicatorFraction(f5 / 10000.0f);
            determinateDrawable.maybeStartAmplitudeAnimator((int) f5);
        }
    };
    private static final int MAX_DRAWABLE_LEVEL = 10000;
    private static final int PHASE_ANIMATION_DURATION_MS = 1000;
    private static final float SPRING_FORCE_STIFFNESS = 50.0f;
    private final DrawingDelegate.ActiveIndicator activeIndicator;
    @NonNull
    private ValueAnimator amplitudeAnimator;
    private TimeInterpolator amplitudeInterpolator;
    @NonNull
    private TimeInterpolator amplitudeOffInterpolator;
    @NonNull
    private TimeInterpolator amplitudeOnInterpolator;
    private DrawingDelegate<S> drawingDelegate;
    @NonNull
    private final ValueAnimator phaseAnimator;
    private boolean skipAnimationOnLevelChange = false;
    private final SpringAnimation springAnimation;
    private final SpringForce springForce;
    private float targetAmplitudeFraction;

    DeterminateDrawable(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec, @NonNull DrawingDelegate<S> drawingDelegate2) {
        super(context, baseProgressIndicatorSpec);
        setDrawingDelegate(drawingDelegate2);
        DrawingDelegate.ActiveIndicator activeIndicator2 = new DrawingDelegate.ActiveIndicator();
        this.activeIndicator = activeIndicator2;
        activeIndicator2.isDeterminate = true;
        SpringForce springForce2 = new SpringForce();
        this.springForce = springForce2;
        springForce2.setDampingRatio(1.0f);
        springForce2.setStiffness(50.0f);
        SpringAnimation springAnimation2 = new SpringAnimation(this, INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimation = springAnimation2;
        springAnimation2.setSpring(springForce2);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.phaseAnimator = valueAnimator;
        valueAnimator.setDuration(1000);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        valueAnimator.setRepeatCount(-1);
        valueAnimator.addUpdateListener(new b(this, baseProgressIndicatorSpec));
        if (baseProgressIndicatorSpec.hasWavyEffect(true) && baseProgressIndicatorSpec.waveSpeed != 0) {
            valueAnimator.start();
        }
        setGrowFraction(1.0f);
    }

    public static /* synthetic */ void a(DeterminateDrawable determinateDrawable, BaseProgressIndicatorSpec baseProgressIndicatorSpec, ValueAnimator valueAnimator) {
        determinateDrawable.getClass();
        if (baseProgressIndicatorSpec.hasWavyEffect(true) && baseProgressIndicatorSpec.waveSpeed != 0 && determinateDrawable.isVisible()) {
            determinateDrawable.invalidateSelf();
        }
    }

    @NonNull
    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return createCircularDrawable(context, circularProgressIndicatorSpec, new CircularDrawingDelegate(circularProgressIndicatorSpec));
    }

    @NonNull
    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return createLinearDrawable(context, linearProgressIndicatorSpec, new LinearDrawingDelegate(linearProgressIndicatorSpec));
    }

    private float getAmplitudeFractionFromLevel(int i5) {
        float f5 = (float) i5;
        return (f5 < 1000.0f || f5 > 9000.0f) ? 0.0f : 1.0f;
    }

    /* access modifiers changed from: private */
    public float getIndicatorFraction() {
        return this.activeIndicator.endFraction;
    }

    private void maybeInitializeAmplitudeAnimator() {
        if (this.amplitudeAnimator == null) {
            Context context = this.context;
            int i5 = R.attr.motionEasingStandardInterpolator;
            TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
            this.amplitudeOnInterpolator = MotionUtils.resolveThemeInterpolator(context, i5, timeInterpolator);
            this.amplitudeOffInterpolator = MotionUtils.resolveThemeInterpolator(this.context, R.attr.motionEasingEmphasizedAccelerateInterpolator, timeInterpolator);
            ValueAnimator valueAnimator = new ValueAnimator();
            this.amplitudeAnimator = valueAnimator;
            valueAnimator.setDuration(500);
            this.amplitudeAnimator.setFloatValues(new float[]{0.0f, 1.0f});
            this.amplitudeAnimator.setInterpolator((TimeInterpolator) null);
            this.amplitudeAnimator.addUpdateListener(new a(this));
        }
    }

    /* access modifiers changed from: private */
    public void maybeStartAmplitudeAnimator(int i5) {
        if (this.baseSpec.hasWavyEffect(true)) {
            maybeInitializeAmplitudeAnimator();
            float amplitudeFractionFromLevel = getAmplitudeFractionFromLevel(i5);
            if (amplitudeFractionFromLevel != this.targetAmplitudeFraction) {
                if (this.amplitudeAnimator.isRunning()) {
                    this.amplitudeAnimator.cancel();
                }
                this.targetAmplitudeFraction = amplitudeFractionFromLevel;
                if (amplitudeFractionFromLevel == 1.0f) {
                    this.amplitudeInterpolator = this.amplitudeOnInterpolator;
                    this.amplitudeAnimator.start();
                    return;
                }
                this.amplitudeInterpolator = this.amplitudeOffInterpolator;
                this.amplitudeAnimator.reverse();
            } else if (!this.amplitudeAnimator.isRunning()) {
                setAmplitudeFraction(amplitudeFractionFromLevel);
            }
        }
    }

    private void setAmplitudeFraction(float f5) {
        this.activeIndicator.amplitudeFraction = f5;
        invalidateSelf();
    }

    /* access modifiers changed from: private */
    public void setIndicatorFraction(float f5) {
        this.activeIndicator.endFraction = f5;
        invalidateSelf();
    }

    public void addSpringAnimationEndListener(@NonNull DynamicAnimation.OnAnimationEndListener onAnimationEndListener) {
        this.springAnimation.addEndListener(onAnimationEndListener);
    }

    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(this.clipBounds)) {
            canvas.save();
            this.drawingDelegate.validateSpecAndAdjustCanvas(canvas, getBounds(), getGrowFraction(), isShowing(), isHiding());
            this.activeIndicator.phaseFraction = getPhaseFraction();
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setAntiAlias(true);
            DrawingDelegate.ActiveIndicator activeIndicator2 = this.activeIndicator;
            BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.baseSpec;
            activeIndicator2.color = baseProgressIndicatorSpec.indicatorColors[0];
            int i5 = baseProgressIndicatorSpec.indicatorTrackGapSize;
            if (i5 > 0) {
                if (!(this.drawingDelegate instanceof LinearDrawingDelegate)) {
                    i5 = (int) ((((float) i5) * MathUtils.clamp(getIndicatorFraction(), 0.0f, (float) GAP_RAMP_DOWN_THRESHOLD)) / GAP_RAMP_DOWN_THRESHOLD);
                }
                this.drawingDelegate.fillTrack(canvas, this.paint, getIndicatorFraction(), 1.0f, this.baseSpec.trackColor, getAlpha(), i5);
            } else {
                this.drawingDelegate.fillTrack(canvas, this.paint, 0.0f, 1.0f, baseProgressIndicatorSpec.trackColor, getAlpha(), 0);
            }
            this.drawingDelegate.fillIndicator(canvas, this.paint, this.activeIndicator, getAlpha());
            this.drawingDelegate.drawStopIndicator(canvas, this.paint, this.baseSpec.indicatorColors[0], getAlpha());
            canvas.restore();
        }
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public DrawingDelegate<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    public void jumpToCurrentState() {
        this.springAnimation.skipToEnd();
        setIndicatorFraction(((float) getLevel()) / 10000.0f);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i5) {
        float amplitudeFractionFromLevel = getAmplitudeFractionFromLevel(i5);
        if (this.skipAnimationOnLevelChange) {
            this.springAnimation.skipToEnd();
            setIndicatorFraction(((float) i5) / 10000.0f);
            setAmplitudeFraction(amplitudeFractionFromLevel);
            return true;
        }
        this.springAnimation.setStartValue(getIndicatorFraction() * 10000.0f);
        this.springAnimation.animateToFinalPosition((float) i5);
        return true;
    }

    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        super.registerAnimationCallback(animationCallback);
    }

    public void removeSpringAnimationEndListener(@NonNull DynamicAnimation.OnAnimationEndListener onAnimationEndListener) {
        this.springAnimation.removeEndListener(onAnimationEndListener);
    }

    public /* bridge */ /* synthetic */ void setAlpha(@IntRange(from = 0, to = 255) int i5) {
        super.setAlpha(i5);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: package-private */
    public void setDrawingDelegate(@NonNull DrawingDelegate<S> drawingDelegate2) {
        this.drawingDelegate = drawingDelegate2;
    }

    /* access modifiers changed from: package-private */
    public void setEnforcedDrawing(boolean z4) {
        if (z4 && !this.phaseAnimator.isRunning()) {
            this.phaseAnimator.start();
        } else if (!z4 && this.phaseAnimator.isRunning()) {
            this.phaseAnimator.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void setLevelByFraction(float f5) {
        setLevel((int) (f5 * 10000.0f));
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z4, boolean z5) {
        return super.setVisible(z4, z5);
    }

    /* access modifiers changed from: package-private */
    public boolean setVisibleInternal(boolean z4, boolean z5, boolean z6) {
        boolean visibleInternal = super.setVisibleInternal(z4, z5, z6);
        float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (systemAnimatorDurationScale == 0.0f) {
            this.skipAnimationOnLevelChange = true;
            return visibleInternal;
        }
        this.skipAnimationOnLevelChange = false;
        this.springForce.setStiffness(50.0f / systemAnimatorDurationScale);
        return visibleInternal;
    }

    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return super.unregisterAnimationCallback(animationCallback);
    }

    @NonNull
    static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec, @NonNull CircularDrawingDelegate circularDrawingDelegate) {
        return new DeterminateDrawable<>(context, circularProgressIndicatorSpec, circularDrawingDelegate);
    }

    @NonNull
    static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec, @NonNull LinearDrawingDelegate linearDrawingDelegate) {
        return new DeterminateDrawable<>(context, linearProgressIndicatorSpec, linearDrawingDelegate);
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z4, boolean z5, boolean z6) {
        return super.setVisible(z4, z5, z6);
    }
}
