package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.j3  reason: case insensitive filesystem */
final class C1353j3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6502a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6503b;

    C1353j3(C1465z3 z3Var, B6 b6) {
        this.f6502a = b6;
        Objects.requireNonNull(z3Var);
        this.f6503b = z3Var;
    }

    public final void run() {
        C1465z3 z3Var = this.f6503b;
        z3Var.v0().E();
        z3Var.v0().b0(this.f6502a);
    }
}
