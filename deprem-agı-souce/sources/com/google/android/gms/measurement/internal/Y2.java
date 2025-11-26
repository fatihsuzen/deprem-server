package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.Callable;

final class Y2 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6178a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6179b;

    Y2(C1465z3 z3Var, String str) {
        this.f6178a = str;
        Objects.requireNonNull(z3Var);
        this.f6179b = z3Var;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        C1465z3 z3Var = this.f6179b;
        z3Var.v0().E();
        return z3Var.v0().F0().C0(this.f6178a);
    }
}
