package com.google.android.gms.measurement.internal;

import N.C0722p;
import O.C0732a;
import android.os.RemoteException;
import f0.C1650e;
import j$.util.Objects;

final class U4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6107a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6108b;

    U4(C1446w5 w5Var, B6 b6, boolean z4) {
        this.f6107a = b6;
        Objects.requireNonNull(w5Var);
        this.f6108b = w5Var;
    }

    public final void run() {
        C1446w5 w5Var = this.f6108b;
        C1650e N4 = w5Var.N();
        if (N4 == null) {
            w5Var.f5730a.a().o().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            B6 b6 = this.f6107a;
            C0722p.k(b6);
            X2 x22 = w5Var.f5730a;
            C1371m w4 = x22.w();
            C1296c2 c2Var = C1304d2.f6320c1;
            if (w4.H((String) null, c2Var)) {
                w5Var.b0(N4, (C0732a) null, b6);
            }
            N4.a0(b6);
            w5Var.f5730a.E().v();
            x22.w().H((String) null, c2Var);
            w5Var.b0(N4, (C0732a) null, b6);
            w5Var.J();
        } catch (RemoteException e5) {
            this.f6108b.f5730a.a().o().b("Failed to send app launch to the service", e5);
        }
    }
}
