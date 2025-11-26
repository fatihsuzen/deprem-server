package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;

/* renamed from: com.google.android.material.search.g  reason: case insensitive filesystem */
public final /* synthetic */ class C1551g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialShapeDrawable f7082a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f7083b;

    public /* synthetic */ C1551g(MaterialShapeDrawable materialShapeDrawable, View view) {
        this.f7082a = materialShapeDrawable;
        this.f7083b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchBarAnimationHelper.c(this.f7082a, this.f7083b, valueAnimator);
    }
}
