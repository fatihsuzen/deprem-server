package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class H5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final long f5910a;

    /* renamed from: b  reason: collision with root package name */
    final long f5911b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ I5 f5912c;

    H5(I5 i5, long j5, long j6) {
        Objects.requireNonNull(i5);
        this.f5912c = i5;
        this.f5910a = j5;
        this.f5911b = j6;
    }

    public final void run() {
        this.f5912c.f5922b.f5730a.b().t(new G5(this));
    }
}
