package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.graphics.Rect;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExpandCollapseAnimationHelper f7050a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Rect f7051b;

    public /* synthetic */ a(ExpandCollapseAnimationHelper expandCollapseAnimationHelper, Rect rect) {
        this.f7050a = expandCollapseAnimationHelper;
        this.f7051b = rect;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ViewUtils.setBoundsFromRect(this.f7050a.expandedView, this.f7051b);
    }
}
