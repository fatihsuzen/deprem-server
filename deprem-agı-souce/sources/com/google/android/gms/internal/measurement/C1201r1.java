package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.app.Activity;
import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.r1  reason: case insensitive filesystem */
final class C1201r1 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Activity f5563e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1218t0 f5564f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ C1228u1 f5565g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1201r1(C1228u1 u1Var, Activity activity, C1218t0 t0Var) {
        super(u1Var.f5594a, true);
        this.f5563e = activity;
        this.f5564f = t0Var;
        Objects.requireNonNull(u1Var);
        this.f5565g = u1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5565g.f5594a.j())).onActivitySaveInstanceStateByScionActivityInfo(L0.c(this.f5563e), this.f5564f, this.f5408b);
    }
}
