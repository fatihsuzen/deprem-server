package com.google.android.material.slider;

import android.view.ViewTreeObserver;

public final /* synthetic */ class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseSlider f7114a;

    public /* synthetic */ d(BaseSlider baseSlider) {
        this.f7114a = baseSlider;
    }

    public final void onGlobalLayout() {
        this.f7114a.updateLabels();
    }
}
