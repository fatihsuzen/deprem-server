package com.google.android.material.textfield;

import android.animation.ValueAnimator;

public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClearTextEndIconDelegate f7122a;

    public /* synthetic */ e(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.f7122a = clearTextEndIconDelegate;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ClearTextEndIconDelegate.d(this.f7122a, valueAnimator);
    }
}
