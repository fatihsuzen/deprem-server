package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.a3  reason: case insensitive filesystem */
final class C1281a3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6210a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6211b;

    C1281a3(C1465z3 z3Var, B6 b6) {
        this.f6210a = b6;
        Objects.requireNonNull(z3Var);
        this.f6211b = z3Var;
    }

    public final void run() {
        C1465z3 z3Var = this.f6211b;
        z3Var.v0().E();
        z3Var.v0().i0(this.f6210a);
    }
}
