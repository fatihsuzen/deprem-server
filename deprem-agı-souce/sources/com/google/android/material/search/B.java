package com.google.android.material.search;

import android.animation.ValueAnimator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;

public final /* synthetic */ class B implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrawerArrowDrawable f7068a;

    public /* synthetic */ B(DrawerArrowDrawable drawerArrowDrawable) {
        this.f7068a = drawerArrowDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f7068a.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
