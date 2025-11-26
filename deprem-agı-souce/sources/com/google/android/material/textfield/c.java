package com.google.android.material.textfield;

import android.animation.ValueAnimator;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClearTextEndIconDelegate f7120a;

    public /* synthetic */ c(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.f7120a = clearTextEndIconDelegate;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ClearTextEndIconDelegate.c(this.f7120a, valueAnimator);
    }
}
