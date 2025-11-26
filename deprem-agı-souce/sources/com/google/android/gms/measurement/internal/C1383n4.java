package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.n4  reason: case insensitive filesystem */
final class C1383n4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1356j6 f6583a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f6584b;

    C1383n4(AppMeasurementDynamiteService appMeasurementDynamiteService, C1356j6 j6Var) {
        this.f6583a = j6Var;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f6584b = appMeasurementDynamiteService;
    }

    public final void run() {
        this.f6584b.f5742a.B().I(this.f6583a);
    }
}
