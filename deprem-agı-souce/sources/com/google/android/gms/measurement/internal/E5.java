package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class E5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f5866a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ N5 f5867b;

    E5(N5 n5, long j5) {
        this.f5866a = j5;
        Objects.requireNonNull(n5);
        this.f5867b = n5;
    }

    public final void run() {
        this.f5867b.r(this.f5866a);
    }
}
