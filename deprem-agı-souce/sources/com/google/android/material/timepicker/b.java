package com.google.android.material.timepicker;

import android.animation.ValueAnimator;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClockHandView f7133a;

    public /* synthetic */ b(ClockHandView clockHandView) {
        this.f7133a = clockHandView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ClockHandView.a(this.f7133a, valueAnimator);
    }
}
