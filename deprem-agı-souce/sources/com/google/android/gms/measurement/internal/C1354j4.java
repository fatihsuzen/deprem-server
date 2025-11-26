package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.j4  reason: case insensitive filesystem */
final class C1354j4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ E3 f6504a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f6505b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f6506c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6507d;

    C1354j4(C1452x4 x4Var, E3 e32, long j5, boolean z4) {
        this.f6504a = e32;
        this.f6505b = j5;
        this.f6506c = z4;
        Objects.requireNonNull(x4Var);
        this.f6507d = x4Var;
    }

    public final void run() {
        C1452x4 x4Var = this.f6507d;
        E3 e32 = this.f6504a;
        x4Var.o(e32);
        x4Var.X(e32, this.f6505b, false, this.f6506c);
    }
}
