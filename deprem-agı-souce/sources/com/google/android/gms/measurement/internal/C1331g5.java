package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.C1270z0;
import f0.C1650e;
import j$.util.Objects;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.measurement.internal.g5  reason: case insensitive filesystem */
final class C1331g5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6446a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6447b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ B6 f6448c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1270z0 f6449d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6450e;

    C1331g5(C1446w5 w5Var, String str, String str2, B6 b6, C1270z0 z0Var) {
        this.f6446a = str;
        this.f6447b = str2;
        this.f6448c = b6;
        this.f6449d = z0Var;
        Objects.requireNonNull(w5Var);
        this.f6450e = w5Var;
    }

    public final void run() {
        C1270z0 z0Var;
        z6 C4;
        ArrayList arrayList = new ArrayList();
        try {
            C1446w5 w5Var = this.f6450e;
            C1650e N4 = w5Var.N();
            if (N4 == null) {
                X2 x22 = w5Var.f5730a;
                x22.a().o().c("Failed to get conditional properties; not connected to service", this.f6446a, this.f6447b);
                C4 = x22.C();
                z0Var = this.f6449d;
                C4.g0(z0Var, arrayList);
            }
            B6 b6 = this.f6448c;
            C0722p.k(b6);
            arrayList = z6.h0(N4.k0(this.f6446a, this.f6447b, b6));
            w5Var.J();
            C1446w5 w5Var2 = this.f6450e;
            z0Var = this.f6449d;
            C4 = w5Var2.f5730a.C();
            C4.g0(z0Var, arrayList);
        } catch (RemoteException e5) {
            this.f6450e.f5730a.a().o().d("Failed to get conditional properties; remote exception", this.f6446a, this.f6447b, e5);
        } catch (Throwable th) {
            C1446w5 w5Var3 = this.f6450e;
            w5Var3.f5730a.C().g0(this.f6449d, arrayList);
            throw th;
        }
    }
}
