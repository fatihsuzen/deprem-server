package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import j$.util.Objects;
import n0.C1719a;

final class K3 implements C1719a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ S5 f5949a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f5950b;

    K3(C1452x4 x4Var, S5 s5) {
        this.f5949a = s5;
        Objects.requireNonNull(x4Var);
        this.f5950b = x4Var;
    }

    private final void c() {
        X2 x22 = this.f5950b.f5730a;
        SparseArray r5 = x22.x().r();
        S5 s5 = this.f5949a;
        r5.put(s5.f6083c, Long.valueOf(s5.f6082b));
        E2 x4 = x22.x();
        int[] iArr = new int[r5.size()];
        long[] jArr = new long[r5.size()];
        for (int i5 = 0; i5 < r5.size(); i5++) {
            iArr[i5] = r5.keyAt(i5);
            jArr[i5] = ((Long) r5.valueAt(i5)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        x4.f5845o.b(bundle);
    }

    public final void a(Object obj) {
        C1452x4 x4Var = this.f5950b;
        x4Var.h();
        c();
        x4Var.Z(false);
        x4Var.b0(1);
        x4Var.f5730a.a().v().b("Successfully registered trigger URI", this.f5949a.f6081a);
        x4Var.x0();
    }

    public final void b(Throwable th) {
        int i5;
        C1452x4 x4Var = this.f5950b;
        x4Var.h();
        x4Var.Z(false);
        X2 x22 = x4Var.f5730a;
        if (x22.w().H((String) null, C1304d2.f6301U0)) {
            i5 = x4Var.d0(th);
        } else {
            i5 = 2;
        }
        int i6 = i5 - 1;
        if (i6 == 0) {
            x22.a().r().c("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", C1402q2.x(x4Var.f5730a.L().q()), C1402q2.x(th.toString()));
            x4Var.b0(1);
            x4Var.w0().add(this.f5949a);
        } else if (i6 != 1) {
            x22.a().o().c("registerTriggerAsync failed. Dropping URI. App ID, Throwable", C1402q2.x(x4Var.f5730a.L().q()), th);
            c();
            x4Var.b0(1);
            x4Var.x0();
        } else {
            x4Var.w0().add(this.f5949a);
            if (x4Var.a0() > ((Integer) C1304d2.f6371x0.b((Object) null)).intValue()) {
                x4Var.b0(1);
                x22.a().r().c("registerTriggerAsync failed. May try later. App ID, throwable", C1402q2.x(x4Var.f5730a.L().q()), C1402q2.x(th.toString()));
                return;
            }
            x22.a().r().d("registerTriggerAsync failed. App ID, delay in seconds, throwable", C1402q2.x(x4Var.f5730a.L().q()), C1402q2.x(String.valueOf(x4Var.a0())), C1402q2.x(th.toString()));
            x4Var.V(x4Var.a0());
            int a02 = x4Var.a0();
            x4Var.b0(a02 + a02);
        }
    }
}
