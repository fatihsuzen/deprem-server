package com.google.android.gms.measurement.internal;

import f0.w;

public enum D3 {
    STORAGE(w.AD_STORAGE, w.ANALYTICS_STORAGE),
    DMA(w.AD_USER_DATA);
    

    /* renamed from: a  reason: collision with root package name */
    private final w[] f5826a;

    private D3(w... wVarArr) {
        this.f5826a = wVarArr;
    }

    public final w[] a() {
        return this.f5826a;
    }
}
