package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.app.Activity;
import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.s1  reason: case insensitive filesystem */
final class C1210s1 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Activity f5571e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1228u1 f5572f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1210s1(C1228u1 u1Var, Activity activity) {
        super(u1Var.f5594a, true);
        this.f5571e = activity;
        Objects.requireNonNull(u1Var);
        this.f5572f = u1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5572f.f5594a.j())).onActivityDestroyedByScionActivityInfo(L0.c(this.f5571e), this.f5408b);
    }
}
