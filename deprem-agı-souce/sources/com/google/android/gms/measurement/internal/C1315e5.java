package com.google.android.gms.measurement.internal;

import N.C0722p;
import f0.C1650e;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.e5  reason: case insensitive filesystem */
final class C1315e5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6397a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f6398b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1341i f6399c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6400d;

    C1315e5(C1446w5 w5Var, boolean z4, B6 b6, boolean z5, C1341i iVar, C1341i iVar2) {
        this.f6397a = b6;
        this.f6398b = z5;
        this.f6399c = iVar;
        Objects.requireNonNull(w5Var);
        this.f6400d = w5Var;
    }

    public final void run() {
        C1341i iVar;
        C1446w5 w5Var = this.f6400d;
        C1650e N4 = w5Var.N();
        if (N4 == null) {
            w5Var.f5730a.a().o().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        B6 b6 = this.f6397a;
        C0722p.k(b6);
        if (this.f6398b) {
            iVar = null;
        } else {
            iVar = this.f6399c;
        }
        w5Var.b0(N4, iVar, b6);
        w5Var.J();
    }
}
