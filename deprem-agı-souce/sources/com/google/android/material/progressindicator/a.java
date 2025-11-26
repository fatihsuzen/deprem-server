package com.google.android.material.progressindicator;

import android.animation.ValueAnimator;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeterminateDrawable f7061a;

    public /* synthetic */ a(DeterminateDrawable determinateDrawable) {
        this.f7061a = determinateDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f7061a.activeIndicator.amplitudeFraction = this.f7061a.amplitudeInterpolator.getInterpolation(this.f7061a.amplitudeAnimator.getAnimatedFraction());
    }
}
