package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.app.Activity;
import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.o1  reason: case insensitive filesystem */
final class C1175o1 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Activity f5499e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1228u1 f5500f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1175o1(C1228u1 u1Var, Activity activity) {
        super(u1Var.f5594a, true);
        this.f5499e = activity;
        Objects.requireNonNull(u1Var);
        this.f5500f = u1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5500f.f5594a.j())).onActivityResumedByScionActivityInfo(L0.c(this.f5499e), this.f5408b);
    }
}
