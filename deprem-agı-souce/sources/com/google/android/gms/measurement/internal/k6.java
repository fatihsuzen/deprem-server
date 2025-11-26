package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Bundle;
import j$.util.Objects;

final class k6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6524a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6525b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Bundle f6526c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ l6 f6527d;

    k6(l6 l6Var, String str, String str2, Bundle bundle) {
        this.f6524a = str;
        this.f6525b = str2;
        this.f6526c = bundle;
        Objects.requireNonNull(l6Var);
        this.f6527d = l6Var;
    }

    public final void run() {
        q6 q6Var = this.f6527d.f6537a;
        z6 N02 = q6Var.N0();
        long currentTimeMillis = q6Var.f().currentTimeMillis();
        String str = this.f6524a;
        q6Var.i((G) C0722p.k(N02.R(str, this.f6525b, this.f6526c, "auto", currentTimeMillis, false, true)), str);
    }
}
