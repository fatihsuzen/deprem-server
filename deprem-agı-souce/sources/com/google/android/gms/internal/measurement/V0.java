package com.google.android.gms.internal.measurement;

import N.C0722p;
import j$.util.Objects;

final class V0 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f5189e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5190f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    V0(C1237v1 v1Var, String str) {
        super(v1Var, true);
        this.f5189e = str;
        Objects.requireNonNull(v1Var);
        this.f5190f = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5190f.j())).endAdUnitExposure(this.f5189e, this.f5408b);
    }
}
