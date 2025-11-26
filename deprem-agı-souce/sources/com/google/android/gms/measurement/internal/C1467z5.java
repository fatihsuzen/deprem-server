package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.z5  reason: case insensitive filesystem */
final class C1467z5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q6 f6935a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f6936b;

    C1467z5(D5 d5, q6 q6Var, Runnable runnable) {
        this.f6935a = q6Var;
        this.f6936b = runnable;
        Objects.requireNonNull(d5);
    }

    public final void run() {
        q6 q6Var = this.f6935a;
        q6Var.E();
        q6Var.D(this.f6936b);
        q6Var.r();
    }
}
