package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.b0  reason: case insensitive filesystem */
final class C1286b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f6217a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0 f6218b;

    C1286b0(C0 c02, long j5) {
        this.f6217a = j5;
        Objects.requireNonNull(c02);
        this.f6218b = c02;
    }

    public final void run() {
        this.f6218b.n(this.f6217a);
    }
}
