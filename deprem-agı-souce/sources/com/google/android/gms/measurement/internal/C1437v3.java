package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C1270z0;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.v3  reason: case insensitive filesystem */
final class C1437v3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1270z0 f6781a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ G f6782b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f6783c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f6784d;

    C1437v3(AppMeasurementDynamiteService appMeasurementDynamiteService, C1270z0 z0Var, G g5, String str) {
        this.f6781a = z0Var;
        this.f6782b = g5;
        this.f6783c = str;
        Objects.requireNonNull(appMeasurementDynamiteService);
        this.f6784d = appMeasurementDynamiteService;
    }

    public final void run() {
        this.f6784d.f5742a.J().B(this.f6781a, this.f6782b, this.f6783c);
    }
}
