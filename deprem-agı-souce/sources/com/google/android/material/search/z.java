package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.graphics.Rect;

public final /* synthetic */ class z implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchViewAnimationHelper f7098a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Rect f7099b;

    public /* synthetic */ z(SearchViewAnimationHelper searchViewAnimationHelper, Rect rect) {
        this.f7098a = searchViewAnimationHelper;
        this.f7099b = rect;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchViewAnimationHelper.c(this.f7098a, this.f7099b, valueAnimator);
    }
}
