package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import j$.util.Objects;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.r3  reason: case insensitive filesystem */
final class C1409r3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6693a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Bundle f6694b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6695c;

    C1409r3(C1465z3 z3Var, B6 b6, Bundle bundle) {
        this.f6693a = b6;
        this.f6694b = bundle;
        Objects.requireNonNull(z3Var);
        this.f6695c = z3Var;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        C1465z3 z3Var = this.f6695c;
        z3Var.v0().E();
        return z3Var.v0().q0(this.f6693a, this.f6694b);
    }
}
