package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class I4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f5919a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ M4 f5920b;

    I4(M4 m42, long j5) {
        this.f5919a = j5;
        Objects.requireNonNull(m42);
        this.f5920b = m42;
    }

    public final void run() {
        M4 m42 = this.f5920b;
        m42.f5730a.M().k(this.f5919a);
        m42.f5976e = null;
    }
}
