package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class V2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ G3 f6113a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ X2 f6114b;

    V2(X2 x22, G3 g32) {
        this.f6113a = g32;
        Objects.requireNonNull(x22);
        this.f6114b = x22;
    }

    public final void run() {
        X2 x22 = this.f6114b;
        G3 g32 = this.f6113a;
        x22.p(g32);
        x22.v(g32.f5894d);
    }
}
