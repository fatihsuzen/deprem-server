package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.w  reason: case insensitive filesystem */
final class C1440w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C3 f6794a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1447x f6795b;

    C1440w(C1447x xVar, C3 c32) {
        this.f6794a = c32;
        Objects.requireNonNull(xVar);
        this.f6795b = xVar;
    }

    public final void run() {
        C3 c32 = this.f6794a;
        c32.c();
        if (C1317f.a()) {
            c32.b().t(this);
            return;
        }
        C1447x xVar = this.f6795b;
        boolean c5 = xVar.c();
        xVar.e(0);
        if (c5) {
            xVar.a();
        }
    }
}
