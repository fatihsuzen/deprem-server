package com.google.android.material.sidesheet;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f7107a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.MarginLayoutParams f7108b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7109c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f7110d;

    public /* synthetic */ d(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i5, View view) {
        this.f7107a = sideSheetBehavior;
        this.f7108b = marginLayoutParams;
        this.f7109c = i5;
        this.f7110d = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SideSheetBehavior.c(this.f7107a, this.f7108b, this.f7109c, this.f7110d, valueAnimator);
    }
}
