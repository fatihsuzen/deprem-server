package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class N3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1452x4 f5989a;

    N3(C1452x4 x4Var) {
        Objects.requireNonNull(x4Var);
        this.f5989a = x4Var;
    }

    public final void run() {
        this.f5989a.f6883r.a();
    }
}
