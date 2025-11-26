package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final /* synthetic */ class E6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ X2 f5868a;

    /* synthetic */ E6(X2 x22) {
        this.f5868a = x22;
    }

    public final /* synthetic */ void run() {
        X2 x22 = this.f5868a;
        if (!x22.C().G()) {
            x22.a().r().a("registerTrigger called but app not eligible");
            return;
        }
        x22.B().t0();
        C1452x4 B4 = x22.B();
        Objects.requireNonNull(B4);
        new Thread(new F6(B4)).start();
    }
}
