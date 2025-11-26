package com.google.android.material.timepicker;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RadialViewGroup f7135a;

    public /* synthetic */ d(RadialViewGroup radialViewGroup) {
        this.f7135a = radialViewGroup;
    }

    public final void run() {
        this.f7135a.updateLayoutParams();
    }
}
