package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.x2  reason: case insensitive filesystem */
final class C1450x2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f6862a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1457y2 f6863b;

    C1450x2(C1457y2 y2Var, boolean z4) {
        this.f6862a = z4;
        Objects.requireNonNull(y2Var);
        this.f6863b = y2Var;
    }

    public final void run() {
        this.f6863b.c().s0(this.f6862a);
    }
}
