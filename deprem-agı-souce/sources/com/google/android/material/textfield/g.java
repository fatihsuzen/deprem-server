package com.google.android.material.textfield;

import android.animation.ValueAnimator;

public final /* synthetic */ class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f7123a;

    public /* synthetic */ g(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f7123a = dropdownMenuEndIconDelegate;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        DropdownMenuEndIconDelegate.c(this.f7123a, valueAnimator);
    }
}
