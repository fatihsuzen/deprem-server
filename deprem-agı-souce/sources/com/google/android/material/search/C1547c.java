package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: com.google.android.material.search.c  reason: case insensitive filesystem */
public final /* synthetic */ class C1547c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f7075a;

    public /* synthetic */ C1547c(View view) {
        this.f7075a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f7075a.setAlpha(0.0f);
    }
}
