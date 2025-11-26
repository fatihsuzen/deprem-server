package com.google.android.gms.internal.measurement;

import N.C0722p;
import j$.util.Objects;

final class X0 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Runnable f5209e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5210f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    X0(C1237v1 v1Var, Runnable runnable) {
        super(v1Var, true);
        this.f5209e = runnable;
        Objects.requireNonNull(v1Var);
        this.f5210f = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5210f.j())).retrieveAndUploadBatches(new W0(this, this.f5209e));
    }
}
