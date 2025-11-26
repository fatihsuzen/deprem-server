package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class P3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f6027a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6028b;

    P3(C1452x4 x4Var, long j5) {
        this.f6027a = j5;
        Objects.requireNonNull(x4Var);
        this.f6028b = x4Var;
    }

    public final void run() {
        X2 x22 = this.f6028b.f5730a;
        B2 b22 = x22.x().f5842l;
        long j5 = this.f6027a;
        b22.b(j5);
        x22.a().v().b("Session timeout duration set", Long.valueOf(j5));
    }
}
