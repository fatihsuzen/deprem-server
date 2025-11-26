package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class J5 extends C1447x {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ L5 f5939e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    J5(L5 l5, C3 c32) {
        super(c32);
        Objects.requireNonNull(l5);
        this.f5939e = l5;
    }

    public final void a() {
        L5 l5 = this.f5939e;
        N5 n5 = l5.f5967d;
        n5.h();
        X2 x22 = n5.f5730a;
        l5.d(false, false, x22.f().elapsedRealtime());
        n5.f5730a.M().k(x22.f().elapsedRealtime());
    }
}
