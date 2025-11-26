package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.f3  reason: case insensitive filesystem */
final class C1321f3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6406a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6407b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f6408c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6409d;

    C1321f3(C1465z3 z3Var, String str, String str2, String str3) {
        this.f6406a = str;
        this.f6407b = str2;
        this.f6408c = str3;
        Objects.requireNonNull(z3Var);
        this.f6409d = z3Var;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        C1465z3 z3Var = this.f6409d;
        z3Var.v0().E();
        return z3Var.v0().F0().D0(this.f6406a, this.f6407b, this.f6408c);
    }
}
