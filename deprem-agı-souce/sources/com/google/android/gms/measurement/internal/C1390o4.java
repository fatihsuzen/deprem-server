package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.o4  reason: case insensitive filesystem */
final /* synthetic */ class C1390o4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C1452x4 f6598a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6599b;

    /* synthetic */ C1390o4(C1452x4 x4Var, AtomicReference atomicReference) {
        this.f6598a = x4Var;
        this.f6599b = atomicReference;
    }

    public final /* synthetic */ void run() {
        C1452x4 x4Var = this.f6598a;
        x4Var.f5730a.J().i0(this.f6599b, x4Var.f5730a.x().f5845o.a());
    }
}
