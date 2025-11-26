package com.google.android.material.slider;

import android.animation.ValueAnimator;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseSlider f7112a;

    public /* synthetic */ b(BaseSlider baseSlider) {
        this.f7112a = baseSlider;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        BaseSlider.b(this.f7112a, valueAnimator);
    }
}
