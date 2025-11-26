package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.e6  reason: case insensitive filesystem */
final class C1316e6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r6 f6401a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ q6 f6402b;

    C1316e6(q6 q6Var, r6 r6Var) {
        this.f6401a = r6Var;
        Objects.requireNonNull(q6Var);
        this.f6402b = q6Var;
    }

    public final void run() {
        q6 q6Var = this.f6402b;
        q6Var.u0(this.f6401a);
        q6Var.A0();
    }
}
