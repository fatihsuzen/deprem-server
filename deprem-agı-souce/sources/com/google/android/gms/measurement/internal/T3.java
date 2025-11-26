package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class T3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6096a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6097b;

    T3(C1452x4 x4Var, AtomicReference atomicReference) {
        this.f6096a = atomicReference;
        Objects.requireNonNull(x4Var);
        this.f6097b = x4Var;
    }

    public final void run() {
        AtomicReference atomicReference = this.f6096a;
        synchronized (atomicReference) {
            try {
                C1452x4 x4Var = this.f6097b;
                atomicReference.set(Boolean.valueOf(x4Var.f5730a.w().H(x4Var.f5730a.L().q(), C1304d2.f6316b0)));
                this.f6096a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
