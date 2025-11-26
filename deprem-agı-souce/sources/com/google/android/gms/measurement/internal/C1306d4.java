package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.d4  reason: case insensitive filesystem */
final class C1306d4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6378a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6379b;

    C1306d4(C1452x4 x4Var, AtomicReference atomicReference) {
        this.f6378a = atomicReference;
        Objects.requireNonNull(x4Var);
        this.f6379b = x4Var;
    }

    public final void run() {
        AtomicReference atomicReference = this.f6378a;
        synchronized (atomicReference) {
            try {
                C1452x4 x4Var = this.f6379b;
                atomicReference.set(Long.valueOf(x4Var.f5730a.w().D(x4Var.f5730a.L().q(), C1304d2.f6322d0)));
                this.f6378a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
