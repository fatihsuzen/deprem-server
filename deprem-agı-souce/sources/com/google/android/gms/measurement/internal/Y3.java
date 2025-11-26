package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class Y3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6180a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6181b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f6182c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6183d;

    Y3(C1452x4 x4Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f6180a = atomicReference;
        this.f6181b = str2;
        this.f6182c = str3;
        Objects.requireNonNull(x4Var);
        this.f6183d = x4Var;
    }

    public final void run() {
        this.f6183d.f5730a.J().e0(this.f6180a, (String) null, this.f6181b, this.f6182c);
    }
}
