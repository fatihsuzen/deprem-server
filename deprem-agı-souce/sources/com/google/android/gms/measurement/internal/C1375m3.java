package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.m3  reason: case insensitive filesystem */
final class C1375m3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ G f6548a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ B6 f6549b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6550c;

    C1375m3(C1465z3 z3Var, G g5, B6 b6) {
        this.f6548a = g5;
        this.f6549b = b6;
        Objects.requireNonNull(z3Var);
        this.f6550c = z3Var;
    }

    public final void run() {
        G g5 = this.f6548a;
        B6 b6 = this.f6549b;
        C1465z3 z3Var = this.f6550c;
        z3Var.z0(z3Var.A0(g5, b6), b6);
    }
}
