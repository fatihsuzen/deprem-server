package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.app.Activity;
import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.n1  reason: case insensitive filesystem */
final class C1166n1 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Activity f5481e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1228u1 f5482f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1166n1(C1228u1 u1Var, Activity activity) {
        super(u1Var.f5594a, true);
        this.f5481e = activity;
        Objects.requireNonNull(u1Var);
        this.f5482f = u1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5482f.f5594a.j())).onActivityStartedByScionActivityInfo(L0.c(this.f5481e), this.f5408b);
    }
}
