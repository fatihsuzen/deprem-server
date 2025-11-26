package com.google.android.material.floatingactionbutton;

import android.animation.ValueAnimator;
import android.graphics.Matrix;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FloatingActionButtonImpl f7041a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f7042b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f7043c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f7044d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ float f7045e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ float f7046f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f7047g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f7048h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Matrix f7049i;

    public /* synthetic */ a(FloatingActionButtonImpl floatingActionButtonImpl, float f5, float f6, float f7, float f8, float f9, float f10, float f11, Matrix matrix) {
        this.f7041a = floatingActionButtonImpl;
        this.f7042b = f5;
        this.f7043c = f6;
        this.f7044d = f7;
        this.f7045e = f8;
        this.f7046f = f9;
        this.f7047g = f10;
        this.f7048h = f11;
        this.f7049i = matrix;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        FloatingActionButtonImpl.a(this.f7041a, this.f7042b, this.f7043c, this.f7044d, this.f7045e, this.f7046f, this.f7047g, this.f7048h, this.f7049i, valueAnimator);
    }
}
