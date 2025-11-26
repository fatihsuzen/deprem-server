package com.google.android.material.card;

import android.animation.ValueAnimator;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialCardViewHelper f6962a;

    public /* synthetic */ a(MaterialCardViewHelper materialCardViewHelper) {
        this.f6962a = materialCardViewHelper;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        MaterialCardViewHelper.a(this.f6962a, valueAnimator);
    }
}
