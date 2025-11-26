package com.google.android.material.search;

import android.animation.ValueAnimator;

public final /* synthetic */ class E implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchViewAnimationHelper f7071a;

    public /* synthetic */ E(SearchViewAnimationHelper searchViewAnimationHelper) {
        this.f7071a = searchViewAnimationHelper;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchViewAnimationHelper.b(this.f7071a, valueAnimator);
    }
}
