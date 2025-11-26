package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class Z3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6194a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6195b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f6196c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f6197d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6198e;

    Z3(C1452x4 x4Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z4) {
        this.f6194a = atomicReference;
        this.f6195b = str2;
        this.f6196c = str3;
        this.f6197d = z4;
        Objects.requireNonNull(x4Var);
        this.f6198e = x4Var;
    }

    public final void run() {
        this.f6198e.f5730a.J().g0(this.f6194a, (String) null, this.f6195b, this.f6196c, this.f6197d);
    }
}
