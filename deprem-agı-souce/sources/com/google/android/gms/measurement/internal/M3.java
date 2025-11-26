package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class M3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f5972a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f5973b;

    M3(C1452x4 x4Var, boolean z4) {
        this.f5972a = z4;
        Objects.requireNonNull(x4Var);
        this.f5973b = x4Var;
    }

    public final void run() {
        C1452x4 x4Var = this.f5973b;
        X2 x22 = x4Var.f5730a;
        boolean g5 = x22.g();
        boolean d5 = x22.d();
        boolean z4 = this.f5972a;
        x22.P(z4);
        if (d5 == z4) {
            x22.a().w().b("Default data collection state already set to", Boolean.valueOf(z4));
        }
        if (x22.g() == g5 || x22.g() != x22.d()) {
            x22.a().t().c("Default data collection is different than actual status", Boolean.valueOf(z4), Boolean.valueOf(g5));
        }
        x4Var.Y();
    }
}
