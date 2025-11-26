package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C1270z0;
import j$.util.Objects;

final class U2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1270z0 f6104a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f6105b;

    U2(AppMeasurementDynamiteService appMeasurementDynamiteService, C1270z0 z0Var) {
        this.f6104a = z0Var;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f6105b = appMeasurementDynamiteService;
    }

    public final void run() {
        this.f6105b.f5742a.J().r(this.f6104a);
    }
}
