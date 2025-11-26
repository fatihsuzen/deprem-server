package com.google.android.gms.measurement.internal;

import f0.C1650e;
import j$.util.Objects;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.measurement.internal.l5  reason: case insensitive filesystem */
final class C1370l5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1650e f6535a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1405q5 f6536b;

    C1370l5(C1405q5 q5Var, C1650e eVar) {
        this.f6535a = eVar;
        Objects.requireNonNull(q5Var);
        this.f6536b = q5Var;
    }

    public final void run() {
        C1405q5 q5Var = this.f6536b;
        synchronized (q5Var) {
            try {
                q5Var.d(false);
                C1446w5 w5Var = q5Var.f6645c;
                if (!w5Var.W()) {
                    w5Var.f5730a.a().v().a("Connected to remote service");
                    w5Var.z(this.f6535a);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        C1446w5 w5Var2 = this.f6536b.f6645c;
        if (w5Var2.P() != null) {
            w5Var2.P().shutdownNow();
            w5Var2.Q((ScheduledExecutorService) null);
        }
    }
}
