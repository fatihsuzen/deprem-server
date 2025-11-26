package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.C1270z0;
import f0.C1650e;
import j$.util.Objects;

final class Z4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ G f6199a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6200b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1270z0 f6201c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6202d;

    Z4(C1446w5 w5Var, G g5, String str, C1270z0 z0Var) {
        this.f6199a = g5;
        this.f6200b = str;
        this.f6201c = z0Var;
        Objects.requireNonNull(w5Var);
        this.f6202d = w5Var;
    }

    public final void run() {
        C1270z0 z0Var;
        z6 C4;
        byte[] bArr = null;
        try {
            C1446w5 w5Var = this.f6202d;
            C1650e N4 = w5Var.N();
            if (N4 == null) {
                X2 x22 = w5Var.f5730a;
                x22.a().o().a("Discarding data. Failed to send event to service to bundle");
                C4 = x22.C();
                z0Var = this.f6201c;
                C4.d0(z0Var, bArr);
            }
            bArr = N4.O(this.f6199a, this.f6200b);
            w5Var.J();
            C1446w5 w5Var2 = this.f6202d;
            z0Var = this.f6201c;
            C4 = w5Var2.f5730a.C();
            C4.d0(z0Var, bArr);
        } catch (RemoteException e5) {
            this.f6202d.f5730a.a().o().b("Failed to send event to the service to bundle", e5);
        } catch (Throwable th) {
            C1446w5 w5Var3 = this.f6202d;
            w5Var3.f5730a.C().d0(this.f6201c, bArr);
            throw th;
        }
    }
}
