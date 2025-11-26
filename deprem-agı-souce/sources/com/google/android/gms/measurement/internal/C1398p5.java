package com.google.android.gms.measurement.internal;

import K.C0655b;
import f0.C1650e;
import j$.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.measurement.internal.p5  reason: case insensitive filesystem */
final class C1398p5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0655b f6615a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1405q5 f6616b;

    C1398p5(C1405q5 q5Var, C0655b bVar) {
        this.f6615a = bVar;
        Objects.requireNonNull(q5Var);
        this.f6616b = q5Var;
    }

    public final void run() {
        C1446w5 w5Var = this.f6616b.f6645c;
        w5Var.O((C1650e) null);
        if (this.f6615a.c() == 7777) {
            if (w5Var.P() == null) {
                w5Var.Q(Executors.newScheduledThreadPool(1));
            }
            w5Var.P().schedule(new C1384n5(this), ((Long) C1304d2.f6313a0.b((Object) null)).longValue(), TimeUnit.MILLISECONDS);
            return;
        }
        w5Var.L();
    }
}
