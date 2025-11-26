package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.ArrayList;
import java.util.List;

abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    protected final List<DrawingDelegate.ActiveIndicator> activeIndicators = new ArrayList();
    protected IndeterminateDrawable drawable;

    protected IndeterminateAnimatorDelegate(int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            this.activeIndicators.add(new DrawingDelegate.ActiveIndicator());
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void cancelAnimatorImmediately();

    /* access modifiers changed from: protected */
    public float getFractionInRange(int i5, int i6, int i7) {
        return MathUtils.clamp(((float) (i5 - i6)) / ((float) i7), 0.0f, 1.0f);
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    /* access modifiers changed from: protected */
    public void registerDrawable(@NonNull IndeterminateDrawable indeterminateDrawable) {
        this.drawable = indeterminateDrawable;
    }

    /* access modifiers changed from: package-private */
    public abstract void requestCancelAnimatorAfterCurrentCycle();

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public abstract void resetPropertiesForNewStart();

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public abstract void setAnimationFraction(float f5);

    /* access modifiers changed from: package-private */
    public abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();
}
