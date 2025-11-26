package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.c3  reason: case insensitive filesystem */
final class C1297c3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1341i f6245a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ B6 f6246b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6247c;

    C1297c3(C1465z3 z3Var, C1341i iVar, B6 b6) {
        this.f6245a = iVar;
        this.f6246b = b6;
        Objects.requireNonNull(z3Var);
        this.f6247c = z3Var;
    }

    public final void run() {
        C1465z3 z3Var = this.f6247c;
        z3Var.v0().E();
        C1341i iVar = this.f6245a;
        if (iVar.f6472c.c() == null) {
            z3Var.v0().m0(iVar, this.f6246b);
            return;
        }
        z3Var.v0().k0(iVar, this.f6246b);
    }
}
