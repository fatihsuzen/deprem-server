package com.google.android.gms.measurement.internal;

import f0.C1650e;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.i5  reason: case insensitive filesystem */
final class C1347i5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1650e f6492a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1405q5 f6493b;

    C1347i5(C1405q5 q5Var, C1650e eVar) {
        this.f6492a = eVar;
        Objects.requireNonNull(q5Var);
        this.f6493b = q5Var;
    }

    public final void run() {
        C1405q5 q5Var = this.f6493b;
        synchronized (q5Var) {
            try {
                q5Var.d(false);
                C1446w5 w5Var = q5Var.f6645c;
                if (!w5Var.W()) {
                    w5Var.f5730a.a().w().a("Connected to service");
                    w5Var.z(this.f6492a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
