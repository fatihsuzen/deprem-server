package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.g3  reason: case insensitive filesystem */
final class C1329g3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6440a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6441b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f6442c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6443d;

    C1329g3(C1465z3 z3Var, String str, String str2, String str3) {
        this.f6440a = str;
        this.f6441b = str2;
        this.f6442c = str3;
        Objects.requireNonNull(z3Var);
        this.f6443d = z3Var;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        C1465z3 z3Var = this.f6443d;
        z3Var.v0().E();
        return z3Var.v0().F0().H0(this.f6440a, this.f6441b, this.f6442c);
    }
}
