package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class S3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6073a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6074b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f6075c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f6076d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6077e;

    S3(C1452x4 x4Var, String str, String str2, Object obj, long j5) {
        this.f6073a = str;
        this.f6074b = str2;
        this.f6075c = obj;
        this.f6076d = j5;
        Objects.requireNonNull(x4Var);
        this.f6077e = x4Var;
    }

    public final void run() {
        this.f6077e.B(this.f6073a, this.f6074b, this.f6075c, this.f6076d);
    }
}
