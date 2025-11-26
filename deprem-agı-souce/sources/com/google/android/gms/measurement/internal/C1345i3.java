package com.google.android.gms.measurement.internal;

import N.C0722p;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.i3  reason: case insensitive filesystem */
final class C1345i3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6486a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6487b;

    C1345i3(C1465z3 z3Var, B6 b6) {
        this.f6486a = b6;
        Objects.requireNonNull(z3Var);
        this.f6487b = z3Var;
    }

    public final void run() {
        C1465z3 z3Var = this.f6487b;
        z3Var.v0().E();
        q6 v02 = z3Var.v0();
        v02.b().h();
        v02.O0();
        B6 b6 = this.f6486a;
        C0722p.e(b6.f5765a);
        v02.o0(b6);
    }
}
