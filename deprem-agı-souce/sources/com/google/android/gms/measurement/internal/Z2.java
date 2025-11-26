package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class Z2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6192a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6193b;

    Z2(C1465z3 z3Var, B6 b6) {
        this.f6192a = b6;
        Objects.requireNonNull(z3Var);
        this.f6193b = z3Var;
    }

    public final void run() {
        C1465z3 z3Var = this.f6193b;
        z3Var.v0().E();
        z3Var.v0().h0(this.f6192a);
    }
}
