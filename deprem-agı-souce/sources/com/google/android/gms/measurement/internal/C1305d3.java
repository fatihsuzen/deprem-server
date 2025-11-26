package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.d3  reason: case insensitive filesystem */
final class C1305d3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1341i f6376a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6377b;

    C1305d3(C1465z3 z3Var, C1341i iVar) {
        this.f6376a = iVar;
        Objects.requireNonNull(z3Var);
        this.f6377b = z3Var;
    }

    public final void run() {
        C1465z3 z3Var = this.f6377b;
        z3Var.v0().E();
        C1341i iVar = this.f6376a;
        if (iVar.f6472c.c() == null) {
            z3Var.v0().l0(iVar);
        } else {
            z3Var.v0().j0(iVar);
        }
    }
}
