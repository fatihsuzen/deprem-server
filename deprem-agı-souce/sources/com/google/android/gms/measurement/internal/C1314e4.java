package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.e4  reason: case insensitive filesystem */
final class C1314e4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6395a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6396b;

    C1314e4(C1452x4 x4Var, AtomicReference atomicReference) {
        this.f6395a = atomicReference;
        Objects.requireNonNull(x4Var);
        this.f6396b = x4Var;
    }

    public final void run() {
        AtomicReference atomicReference = this.f6395a;
        synchronized (atomicReference) {
            try {
                C1452x4 x4Var = this.f6396b;
                atomicReference.set(Integer.valueOf(x4Var.f5730a.w().E(x4Var.f5730a.L().q(), C1304d2.f6325e0)));
                this.f6395a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
