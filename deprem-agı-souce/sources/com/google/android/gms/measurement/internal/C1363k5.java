package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C1270z0;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.k5  reason: case insensitive filesystem */
final class C1363k5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1270z0 f6522a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f6523b;

    C1363k5(AppMeasurementDynamiteService appMeasurementDynamiteService, C1270z0 z0Var) {
        this.f6522a = z0Var;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f6523b = appMeasurementDynamiteService;
    }

    public final void run() {
        AppMeasurementDynamiteService appMeasurementDynamiteService = this.f6523b;
        appMeasurementDynamiteService.f5742a.C().e0(this.f6522a, appMeasurementDynamiteService.f5742a.d());
    }
}
