package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C1270z0;
import j$.util.Objects;

final class K4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1270z0 f5951a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5952b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f5953c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f5954d;

    K4(AppMeasurementDynamiteService appMeasurementDynamiteService, C1270z0 z0Var, String str, String str2) {
        this.f5951a = z0Var;
        this.f5952b = str;
        this.f5953c = str2;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f5954d = appMeasurementDynamiteService;
    }

    public final void run() {
        this.f5954d.f5742a.J().f0(this.f5951a, this.f5952b, this.f5953c);
    }
}
