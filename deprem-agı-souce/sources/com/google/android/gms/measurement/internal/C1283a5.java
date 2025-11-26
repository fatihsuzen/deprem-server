package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.a5  reason: case insensitive filesystem */
final class C1283a5 extends C1447x {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6214e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1283a5(C1446w5 w5Var, C3 c32) {
        super(c32);
        Objects.requireNonNull(w5Var);
        this.f6214e = w5Var;
    }

    public final void a() {
        this.f6214e.f5730a.a().r().a("Tasks have been queued for a long time");
    }
}
