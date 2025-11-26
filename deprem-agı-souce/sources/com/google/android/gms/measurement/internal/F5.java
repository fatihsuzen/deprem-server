package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class F5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f5880a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ N5 f5881b;

    F5(N5 n5, long j5) {
        this.f5880a = j5;
        Objects.requireNonNull(n5);
        this.f5881b = n5;
    }

    public final void run() {
        this.f5881b.s(this.f5880a);
    }
}
