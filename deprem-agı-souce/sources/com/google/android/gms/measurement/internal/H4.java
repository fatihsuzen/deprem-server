package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class H4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ M4 f5909a;

    H4(M4 m42) {
        Objects.requireNonNull(m42);
        this.f5909a = m42;
    }

    public final void run() {
        M4 m42 = this.f5909a;
        m42.f5976e = m42.D();
    }
}
