package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.g4  reason: case insensitive filesystem */
final class C1330g4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Boolean f6444a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6445b;

    C1330g4(C1452x4 x4Var, Boolean bool) {
        this.f6444a = bool;
        Objects.requireNonNull(x4Var);
        this.f6445b = x4Var;
    }

    public final void run() {
        this.f6445b.W(this.f6444a, true);
    }
}
