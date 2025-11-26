package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.n3  reason: case insensitive filesystem */
final class C1382n3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ G f6580a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6581b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6582c;

    C1382n3(C1465z3 z3Var, G g5, String str) {
        this.f6580a = g5;
        this.f6581b = str;
        Objects.requireNonNull(z3Var);
        this.f6582c = z3Var;
    }

    public final void run() {
        C1465z3 z3Var = this.f6582c;
        z3Var.v0().E();
        z3Var.v0().i(this.f6580a, this.f6581b);
    }
}
