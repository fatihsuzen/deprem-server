package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class I3 extends C1447x {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1452x4 f5918e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    I3(C1452x4 x4Var, C3 c32) {
        super(c32);
        Objects.requireNonNull(x4Var);
        this.f5918e = x4Var;
    }

    public final void a() {
        C1452x4 B4 = this.f5918e.f5730a.B();
        Objects.requireNonNull(B4);
        new Thread(new H3(B4)).start();
    }
}
