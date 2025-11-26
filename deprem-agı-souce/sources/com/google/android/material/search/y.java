package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.widget.ImageButton;

public final /* synthetic */ class y implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageButton f7097a;

    public /* synthetic */ y(ImageButton imageButton) {
        this.f7097a = imageButton;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f7097a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
