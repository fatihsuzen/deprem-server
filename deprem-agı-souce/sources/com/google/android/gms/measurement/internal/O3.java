package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C1270z0;
import j$.util.Objects;

final class O3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1270z0 f6006a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6007b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f6008c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f6009d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f6010e;

    O3(AppMeasurementDynamiteService appMeasurementDynamiteService, C1270z0 z0Var, String str, String str2, boolean z4) {
        this.f6006a = z0Var;
        this.f6007b = str;
        this.f6008c = str2;
        this.f6009d = z4;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f6010e = appMeasurementDynamiteService;
    }

    public final void run() {
        this.f6010e.f5742a.J().h0(this.f6006a, this.f6007b, this.f6008c, this.f6009d);
    }
}
