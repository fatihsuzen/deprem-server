package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.RemoteException;
import f0.C1650e;
import j$.util.Objects;

final class R4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6062a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6063b;

    R4(C1446w5 w5Var, B6 b6) {
        this.f6062a = b6;
        Objects.requireNonNull(w5Var);
        this.f6063b = w5Var;
    }

    public final void run() {
        C1446w5 w5Var = this.f6063b;
        C1650e N4 = w5Var.N();
        if (N4 == null) {
            w5Var.f5730a.a().o().a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            B6 b6 = this.f6062a;
            C0722p.k(b6);
            N4.v(b6);
        } catch (RemoteException e5) {
            this.f6063b.f5730a.a().o().b("Failed to reset data on the service: remote exception", e5);
        }
        this.f6063b.J();
    }
}
