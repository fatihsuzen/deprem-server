package com.google.android.material.slider;

import android.view.ViewTreeObserver;

public final /* synthetic */ class c implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseSlider f7113a;

    public /* synthetic */ c(BaseSlider baseSlider) {
        this.f7113a = baseSlider;
    }

    public final void onScrollChanged() {
        this.f7113a.updateLabels();
    }
}
