package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class J4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ E4 f5936a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f5937b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ M4 f5938c;

    J4(M4 m42, E4 e42, long j5) {
        this.f5936a = e42;
        this.f5937b = j5;
        Objects.requireNonNull(m42);
        this.f5938c = m42;
    }

    public final void run() {
        M4 m42 = this.f5938c;
        m42.C(this.f5936a, false, this.f5937b);
        m42.f5976e = null;
        m42.f5730a.J().u((E4) null);
    }
}
