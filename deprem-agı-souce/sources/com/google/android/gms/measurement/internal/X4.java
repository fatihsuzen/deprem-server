package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import f0.C1650e;
import j$.util.Objects;

final class X4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ E4 f6166a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6167b;

    X4(C1446w5 w5Var, E4 e42) {
        this.f6166a = e42;
        Objects.requireNonNull(w5Var);
        this.f6167b = w5Var;
    }

    public final void run() {
        C1446w5 w5Var = this.f6167b;
        C1650e N4 = w5Var.N();
        if (N4 == null) {
            w5Var.f5730a.a().o().a("Failed to send current screen to service");
            return;
        }
        try {
            E4 e42 = this.f6166a;
            if (e42 == null) {
                N4.t(0, (String) null, (String) null, w5Var.f5730a.e().getPackageName());
            } else {
                E4 e43 = e42;
                E4 e44 = e43;
                N4.t(e43.f5862c, e44.f5860a, e44.f5861b, w5Var.f5730a.e().getPackageName());
            }
            w5Var.J();
        } catch (RemoteException e5) {
            this.f6167b.f5730a.a().o().b("Failed to send current screen to the service", e5);
        }
    }
}
