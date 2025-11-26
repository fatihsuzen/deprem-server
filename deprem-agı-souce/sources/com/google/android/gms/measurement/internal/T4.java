package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.C1270z0;
import f0.C1650e;
import f0.w;
import j$.util.Objects;

final class T4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6098a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1270z0 f6099b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6100c;

    T4(C1446w5 w5Var, B6 b6, C1270z0 z0Var) {
        this.f6098a = b6;
        this.f6099b = z0Var;
        Objects.requireNonNull(w5Var);
        this.f6100c = w5Var;
    }

    public final void run() {
        C1270z0 z0Var;
        z6 C4;
        String str = null;
        try {
            C1446w5 w5Var = this.f6100c;
            X2 x22 = w5Var.f5730a;
            if (!x22.x().w().o(w.ANALYTICS_STORAGE)) {
                x22.a().t().a("Analytics storage consent denied; will not get app instance id");
                w5Var.f5730a.B().E((String) null);
                x22.x().f5838h.b((String) null);
            } else {
                C1650e N4 = w5Var.N();
                if (N4 == null) {
                    x22.a().o().a("Failed to get app instance id");
                } else {
                    B6 b6 = this.f6098a;
                    C0722p.k(b6);
                    str = N4.j0(b6);
                    if (str != null) {
                        w5Var.f5730a.B().E(str);
                        x22.x().f5838h.b(str);
                    }
                    w5Var.J();
                    C1446w5 w5Var2 = this.f6100c;
                    z0Var = this.f6099b;
                    C4 = w5Var2.f5730a.C();
                    C4.a0(z0Var, str);
                }
            }
            C4 = x22.C();
            z0Var = this.f6099b;
        } catch (RemoteException e5) {
            this.f6100c.f5730a.a().o().b("Failed to get app instance id", e5);
        } catch (Throwable th) {
            C1446w5 w5Var3 = this.f6100c;
            w5Var3.f5730a.C().a0(this.f6099b, (String) null);
            throw th;
        }
        C4.a0(z0Var, str);
    }
}
