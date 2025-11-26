package com.google.android.material.navigationrail;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f7060a;

    public /* synthetic */ a(View view) {
        this.f7060a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f7060a.setTranslationX((1.0f - valueAnimator.getAnimatedFraction()) * LabelMoveTransition.HORIZONTAL_DISTANCE);
    }
}
