package com.google.android.gms.measurement.internal;

import f0.C1643K;
import f0.N;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.w4  reason: case insensitive filesystem */
final /* synthetic */ class C1445w4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C1452x4 f6846a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6847b;

    /* synthetic */ C1445w4(C1452x4 x4Var, AtomicReference atomicReference) {
        this.f6846a = x4Var;
        this.f6847b = atomicReference;
    }

    public final /* synthetic */ void run() {
        this.f6846a.f5730a.J().j0(this.f6847b, N.c(C1643K.SGTM_CLIENT));
    }
}
