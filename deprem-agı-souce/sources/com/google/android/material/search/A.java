package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.graphics.Rect;

public final /* synthetic */ class A implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchViewAnimationHelper f7064a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f7065b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float[] f7066c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Rect f7067d;

    public /* synthetic */ A(SearchViewAnimationHelper searchViewAnimationHelper, float f5, float[] fArr, Rect rect) {
        this.f7064a = searchViewAnimationHelper;
        this.f7065b = f5;
        this.f7066c = fArr;
        this.f7067d = rect;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchViewAnimationHelper.g(this.f7064a, this.f7065b, this.f7066c, this.f7067d, valueAnimator);
    }
}
