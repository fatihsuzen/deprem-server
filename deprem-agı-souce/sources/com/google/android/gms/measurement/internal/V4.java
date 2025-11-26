package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.RemoteException;
import f0.C1650e;
import j$.util.Objects;

final class V4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6117a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6118b;

    V4(C1446w5 w5Var, B6 b6) {
        this.f6117a = b6;
        Objects.requireNonNull(w5Var);
        this.f6118b = w5Var;
    }

    public final void run() {
        C1446w5 w5Var = this.f6118b;
        C1650e N4 = w5Var.N();
        if (N4 == null) {
            w5Var.f5730a.a().r().a("Failed to send app backgrounded");
            return;
        }
        try {
            B6 b6 = this.f6117a;
            C0722p.k(b6);
            N4.e0(b6);
            w5Var.J();
        } catch (RemoteException e5) {
            this.f6118b.f5730a.a().o().b("Failed to send app backgrounded to the service", e5);
        }
    }
}
