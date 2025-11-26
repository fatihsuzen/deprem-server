package com.google.android.gms.measurement.internal;

import f0.C1646a;
import j$.util.Objects;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.l3  reason: case insensitive filesystem */
final class C1368l3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6532a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6533b;

    C1368l3(C1465z3 z3Var, B6 b6) {
        this.f6532a = b6;
        Objects.requireNonNull(z3Var);
        this.f6533b = z3Var;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        C1465z3 z3Var = this.f6533b;
        z3Var.v0().E();
        return new C1646a(z3Var.v0().S0(this.f6532a.f5765a));
    }
}
