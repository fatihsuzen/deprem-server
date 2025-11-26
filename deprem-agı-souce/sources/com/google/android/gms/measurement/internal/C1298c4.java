package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.c4  reason: case insensitive filesystem */
final class C1298c4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6248a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6249b;

    C1298c4(C1452x4 x4Var, AtomicReference atomicReference) {
        this.f6248a = atomicReference;
        Objects.requireNonNull(x4Var);
        this.f6249b = x4Var;
    }

    public final void run() {
        AtomicReference atomicReference = this.f6248a;
        synchronized (atomicReference) {
            try {
                C1452x4 x4Var = this.f6249b;
                atomicReference.set(x4Var.f5730a.w().C(x4Var.f5730a.L().q(), C1304d2.f6319c0));
                this.f6248a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
