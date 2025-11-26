package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.app.Activity;
import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.q1  reason: case insensitive filesystem */
final class C1193q1 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Activity f5542e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1228u1 f5543f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1193q1(C1228u1 u1Var, Activity activity) {
        super(u1Var.f5594a, true);
        this.f5542e = activity;
        Objects.requireNonNull(u1Var);
        this.f5543f = u1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5543f.f5594a.j())).onActivityStoppedByScionActivityInfo(L0.c(this.f5542e), this.f5408b);
    }
}
