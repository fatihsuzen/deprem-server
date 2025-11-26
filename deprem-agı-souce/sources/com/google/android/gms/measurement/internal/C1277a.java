package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.a  reason: case insensitive filesystem */
final class C1277a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6204a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f6205b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0 f6206c;

    C1277a(C0 c02, String str, long j5) {
        this.f6204a = str;
        this.f6205b = j5;
        Objects.requireNonNull(c02);
        this.f6206c = c02;
    }

    public final void run() {
        this.f6206c.l(this.f6204a, this.f6205b);
    }
}
