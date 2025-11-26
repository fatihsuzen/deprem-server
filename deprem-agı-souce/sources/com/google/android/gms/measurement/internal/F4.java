package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import j$.util.Objects;

final class F4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f5875a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ E4 f5876b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ E4 f5877c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f5878d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ M4 f5879e;

    F4(M4 m42, Bundle bundle, E4 e42, E4 e43, long j5) {
        this.f5875a = bundle;
        this.f5876b = e42;
        this.f5877c = e43;
        this.f5878d = j5;
        Objects.requireNonNull(m42);
        this.f5879e = m42;
    }

    public final void run() {
        this.f5879e.A(this.f5875a, this.f5876b, this.f5877c, this.f5878d);
    }
}
