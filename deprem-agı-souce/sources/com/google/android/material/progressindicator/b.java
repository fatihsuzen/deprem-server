package com.google.android.material.progressindicator;

import android.animation.ValueAnimator;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeterminateDrawable f7062a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseProgressIndicatorSpec f7063b;

    public /* synthetic */ b(DeterminateDrawable determinateDrawable, BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.f7062a = determinateDrawable;
        this.f7063b = baseProgressIndicatorSpec;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        DeterminateDrawable.a(this.f7062a, this.f7063b, valueAnimator);
    }
}
