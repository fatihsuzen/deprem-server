package com.google.android.material.carousel;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f6963a;

    public /* synthetic */ a(CarouselLayoutManager carouselLayoutManager) {
        this.f6963a = carouselLayoutManager;
    }

    public final void run() {
        this.f6963a.refreshKeylineState();
    }
}
