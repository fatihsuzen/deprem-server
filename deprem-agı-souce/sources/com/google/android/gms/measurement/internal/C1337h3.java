package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.h3  reason: case insensitive filesystem */
final class C1337h3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6457a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6458b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f6459c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6460d;

    C1337h3(C1465z3 z3Var, String str, String str2, String str3) {
        this.f6457a = str;
        this.f6458b = str2;
        this.f6459c = str3;
        Objects.requireNonNull(z3Var);
        this.f6460d = z3Var;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        C1465z3 z3Var = this.f6460d;
        z3Var.v0().E();
        return z3Var.v0().F0().H0(this.f6457a, this.f6458b, this.f6459c);
    }
}
