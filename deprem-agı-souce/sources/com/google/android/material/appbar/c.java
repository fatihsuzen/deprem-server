package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import com.google.android.material.shape.MaterialShapeDrawable;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f6950a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialShapeDrawable f6951b;

    public /* synthetic */ c(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable) {
        this.f6950a = appBarLayout;
        this.f6951b = materialShapeDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AppBarLayout.a(this.f6950a, this.f6951b, valueAnimator);
    }
}
