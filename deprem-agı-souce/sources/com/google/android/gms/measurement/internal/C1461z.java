package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.z  reason: case insensitive filesystem */
final class C1461z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6917a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f6918b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0 f6919c;

    C1461z(C0 c02, String str, long j5) {
        this.f6917a = str;
        this.f6918b = j5;
        Objects.requireNonNull(c02);
        this.f6919c = c02;
    }

    public final void run() {
        this.f6919c.m(this.f6917a, this.f6918b);
    }
}
