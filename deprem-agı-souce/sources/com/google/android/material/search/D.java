package com.google.android.material.search;

import android.animation.ValueAnimator;
import com.google.android.material.internal.FadeThroughDrawable;

public final /* synthetic */ class D implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FadeThroughDrawable f7070a;

    public /* synthetic */ D(FadeThroughDrawable fadeThroughDrawable) {
        this.f7070a = fadeThroughDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f7070a.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
