package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class U5 extends C1447x {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ V5 f6109e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    U5(V5 v5, C3 c32) {
        super(c32);
        Objects.requireNonNull(v5);
        this.f6109e = v5;
    }

    public final void a() {
        V5 v5 = this.f6109e;
        v5.n();
        v5.f5730a.a().w().a("Starting upload from DelayedRunnable");
        v5.f6129b.r();
    }
}
