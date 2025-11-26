package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Bundle;
import android.os.RemoteException;
import f0.C1650e;
import j$.util.Objects;

final class Y4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6184a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f6185b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ E f6186c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Bundle f6187d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6188e;

    Y4(C1446w5 w5Var, boolean z4, B6 b6, boolean z5, E e5, Bundle bundle) {
        this.f6184a = b6;
        this.f6185b = z5;
        this.f6186c = e5;
        this.f6187d = bundle;
        Objects.requireNonNull(w5Var);
        this.f6188e = w5Var;
    }

    public final void run() {
        C1446w5 w5Var = this.f6188e;
        C1650e N4 = w5Var.N();
        if (N4 == null) {
            w5Var.f5730a.a().o().a("Failed to send default event parameters to service");
            return;
        }
        E e5 = null;
        if (w5Var.f5730a.w().H((String) null, C1304d2.f6320c1)) {
            B6 b6 = this.f6184a;
            C0722p.k(b6);
            C1446w5 w5Var2 = this.f6188e;
            if (!this.f6185b) {
                e5 = this.f6186c;
            }
            w5Var2.b0(N4, e5, b6);
            return;
        }
        try {
            B6 b62 = this.f6184a;
            C0722p.k(b62);
            N4.U(this.f6187d, b62);
            w5Var.J();
        } catch (RemoteException e6) {
            this.f6188e.f5730a.a().o().b("Failed to send default event parameters to service", e6);
        }
    }
}
