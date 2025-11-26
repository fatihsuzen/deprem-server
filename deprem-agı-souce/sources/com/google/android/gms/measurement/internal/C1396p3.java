package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.p3  reason: case insensitive filesystem */
final class C1396p3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v6 f6610a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ B6 f6611b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6612c;

    C1396p3(C1465z3 z3Var, v6 v6Var, B6 b6) {
        this.f6610a = v6Var;
        this.f6611b = b6;
        Objects.requireNonNull(z3Var);
        this.f6612c = z3Var;
    }

    public final void run() {
        C1465z3 z3Var = this.f6612c;
        z3Var.v0().E();
        v6 v6Var = this.f6610a;
        if (v6Var.c() == null) {
            B6 b6 = this.f6611b;
            z3Var.v0().d0(v6Var.f6788b, b6);
            return;
        }
        z3Var.v0().c0(v6Var, this.f6611b);
    }
}
