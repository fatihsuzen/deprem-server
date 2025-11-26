package com.google.android.gms.measurement.internal;

import N.C0722p;
import f0.C1650e;
import j$.util.Objects;

final class Q4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6042a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f6043b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ v6 f6044c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6045d;

    Q4(C1446w5 w5Var, B6 b6, boolean z4, v6 v6Var) {
        this.f6042a = b6;
        this.f6043b = z4;
        this.f6044c = v6Var;
        Objects.requireNonNull(w5Var);
        this.f6045d = w5Var;
    }

    public final void run() {
        v6 v6Var;
        C1446w5 w5Var = this.f6045d;
        C1650e N4 = w5Var.N();
        if (N4 == null) {
            w5Var.f5730a.a().o().a("Discarding data. Failed to set user property");
            return;
        }
        B6 b6 = this.f6042a;
        C0722p.k(b6);
        if (this.f6043b) {
            v6Var = null;
        } else {
            v6Var = this.f6044c;
        }
        w5Var.b0(N4, v6Var, b6);
        w5Var.J();
    }
}
