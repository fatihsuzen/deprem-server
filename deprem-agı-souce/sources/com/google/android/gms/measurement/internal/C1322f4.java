package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.f4  reason: case insensitive filesystem */
final class C1322f4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6410a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6411b;

    C1322f4(C1452x4 x4Var, AtomicReference atomicReference) {
        this.f6410a = atomicReference;
        Objects.requireNonNull(x4Var);
        this.f6411b = x4Var;
    }

    public final void run() {
        AtomicReference atomicReference = this.f6410a;
        synchronized (atomicReference) {
            try {
                C1452x4 x4Var = this.f6411b;
                atomicReference.set(Double.valueOf(x4Var.f5730a.w().G(x4Var.f5730a.L().q(), C1304d2.f6328f0)));
                this.f6410a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
