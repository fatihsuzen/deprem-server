package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import com.google.android.material.shape.MaterialShapeDrawable;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f6946a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ColorStateList f6947b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MaterialShapeDrawable f6948c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Integer f6949d;

    public /* synthetic */ b(AppBarLayout appBarLayout, ColorStateList colorStateList, MaterialShapeDrawable materialShapeDrawable, Integer num) {
        this.f6946a = appBarLayout;
        this.f6947b = colorStateList;
        this.f6948c = materialShapeDrawable;
        this.f6949d = num;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AppBarLayout.b(this.f6946a, this.f6947b, this.f6948c, this.f6949d, valueAnimator);
    }
}
