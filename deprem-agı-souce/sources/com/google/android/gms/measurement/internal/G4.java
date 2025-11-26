package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import j$.util.Objects;

final class G4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ E4 f5898a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ E4 f5899b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f5900c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f5901d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ M4 f5902e;

    G4(M4 m42, E4 e42, E4 e43, long j5, boolean z4) {
        this.f5898a = e42;
        this.f5899b = e43;
        this.f5900c = j5;
        this.f5901d = z4;
        Objects.requireNonNull(m42);
        this.f5902e = m42;
    }

    public final void run() {
        this.f5902e.B(this.f5898a, this.f5899b, this.f5900c, this.f5901d, (Bundle) null);
    }
}
