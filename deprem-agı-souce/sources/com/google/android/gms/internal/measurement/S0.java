package com.google.android.gms.internal.measurement;

import N.C0722p;
import j$.util.Objects;

final class S0 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Boolean f5170e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5171f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    S0(C1237v1 v1Var, Boolean bool) {
        super(v1Var, true);
        this.f5170e = bool;
        Objects.requireNonNull(v1Var);
        this.f5171f = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5171f.j())).setMeasurementEnabled(this.f5170e.booleanValue(), this.f5407a);
    }
}
