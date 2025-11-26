package com.google.android.gms.internal.measurement;

import j$.util.Objects;

final class W0 extends B0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f5196a;

    W0(X0 x02, Runnable runnable) {
        this.f5196a = runnable;
        Objects.requireNonNull(x02);
    }

    public final void d() {
        this.f5196a.run();
    }
}
