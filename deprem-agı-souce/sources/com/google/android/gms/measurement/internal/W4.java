package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class W4 extends C1447x {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6128e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    W4(C1446w5 w5Var, C3 c32) {
        super(c32);
        Objects.requireNonNull(w5Var);
        this.f6128e = w5Var;
    }

    public final void a() {
        C1446w5 w5Var = this.f6128e;
        w5Var.h();
        if (w5Var.W()) {
            w5Var.f5730a.a().w().a("Inactivity, disconnecting from the service");
            w5Var.A();
        }
    }
}
