package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.C1270z0;
import f0.C1650e;
import j$.util.Objects;
import java.util.List;

final class N4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5990a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5991b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ B6 f5992c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f5993d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1270z0 f5994e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1446w5 f5995f;

    N4(C1446w5 w5Var, String str, String str2, B6 b6, boolean z4, C1270z0 z0Var) {
        this.f5990a = str;
        this.f5991b = str2;
        this.f5992c = b6;
        this.f5993d = z4;
        this.f5994e = z0Var;
        Objects.requireNonNull(w5Var);
        this.f5995f = w5Var;
    }

    public final void run() {
        Throwable th;
        Bundle bundle;
        RemoteException e5;
        Bundle bundle2 = new Bundle();
        try {
            C1446w5 w5Var = this.f5995f;
            C1650e N4 = w5Var.N();
            if (N4 == null) {
                X2 x22 = w5Var.f5730a;
                x22.a().o().c("Failed to get user properties; not connected to service", this.f5990a, this.f5991b);
                x22.C().f0(this.f5994e, bundle2);
                return;
            }
            B6 b6 = this.f5992c;
            C0722p.k(b6);
            List<v6> h02 = N4.h0(this.f5990a, this.f5991b, this.f5993d, b6);
            int i5 = z6.f6939k;
            bundle = new Bundle();
            if (h02 != null) {
                for (v6 v6Var : h02) {
                    String str = v6Var.f6791e;
                    if (str != null) {
                        bundle.putString(v6Var.f6788b, str);
                    } else {
                        Long l5 = v6Var.f6790d;
                        if (l5 != null) {
                            bundle.putLong(v6Var.f6788b, l5.longValue());
                        } else {
                            Double d5 = v6Var.f6793g;
                            if (d5 != null) {
                                bundle.putDouble(v6Var.f6788b, d5.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                w5Var.J();
                X2 x23 = w5Var.f5730a;
                x23.C().f0(this.f5994e, bundle);
            } catch (RemoteException e6) {
                e5 = e6;
                try {
                    this.f5995f.f5730a.a().o().c("Failed to get user properties; remote exception", this.f5990a, e5);
                    C1446w5 w5Var2 = this.f5995f;
                    w5Var2.f5730a.C().f0(this.f5994e, bundle);
                } catch (Throwable th2) {
                    th = th2;
                    bundle2 = bundle;
                    C1446w5 w5Var3 = this.f5995f;
                    w5Var3.f5730a.C().f0(this.f5994e, bundle2);
                    throw th;
                }
            }
        } catch (RemoteException e7) {
            bundle = bundle2;
            e5 = e7;
            this.f5995f.f5730a.a().o().c("Failed to get user properties; remote exception", this.f5990a, e5);
            C1446w5 w5Var22 = this.f5995f;
            w5Var22.f5730a.C().f0(this.f5994e, bundle);
        } catch (Throwable th3) {
            th = th3;
            C1446w5 w5Var32 = this.f5995f;
            w5Var32.f5730a.C().f0(this.f5994e, bundle2);
            throw th;
        }
    }
}
