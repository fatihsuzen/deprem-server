package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.RemoteException;
import f0.C1650e;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.b5  reason: case insensitive filesystem */
final class C1291b5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6227a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6228b;

    C1291b5(C1446w5 w5Var, B6 b6) {
        this.f6227a = b6;
        Objects.requireNonNull(w5Var);
        this.f6228b = w5Var;
    }

    public final void run() {
        C1446w5 w5Var = this.f6228b;
        C1650e N4 = w5Var.N();
        if (N4 == null) {
            w5Var.f5730a.a().o().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            B6 b6 = this.f6227a;
            C0722p.k(b6);
            N4.J(b6);
            w5Var.J();
        } catch (RemoteException e5) {
            this.f6228b.f5730a.a().o().b("Failed to send measurementEnabled to the service", e5);
        }
    }
}
