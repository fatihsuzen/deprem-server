package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.b3  reason: case insensitive filesystem */
final class C1289b3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6221a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6222b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f6223c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f6224d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6225e;

    C1289b3(C1465z3 z3Var, String str, String str2, String str3, long j5) {
        this.f6221a = str;
        this.f6222b = str2;
        this.f6223c = str3;
        this.f6224d = j5;
        Objects.requireNonNull(z3Var);
        this.f6225e = z3Var;
    }

    public final void run() {
        String str = this.f6221a;
        if (str == null) {
            C1465z3 z3Var = this.f6225e;
            z3Var.v0().t0(this.f6222b, (E4) null);
            return;
        }
        E4 e42 = new E4(this.f6223c, str, this.f6224d);
        C1465z3 z3Var2 = this.f6225e;
        z3Var2.v0().t0(this.f6222b, e42);
    }
}
