package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.i4  reason: case insensitive filesystem */
final class C1346i4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ E3 f6488a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f6489b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f6490c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6491d;

    C1346i4(C1452x4 x4Var, E3 e32, long j5, boolean z4) {
        this.f6488a = e32;
        this.f6489b = j5;
        this.f6490c = z4;
        Objects.requireNonNull(x4Var);
        this.f6491d = x4Var;
    }

    public final void run() {
        C1452x4 x4Var = this.f6491d;
        E3 e32 = this.f6488a;
        x4Var.o(e32);
        x4Var.X(e32, this.f6489b, true, this.f6490c);
    }
}
