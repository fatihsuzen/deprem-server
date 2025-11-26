package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.os.Bundle;
import j$.util.Objects;

final class O0 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Bundle f5110e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5111f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    O0(C1237v1 v1Var, Bundle bundle) {
        super(v1Var, true);
        this.f5110e = bundle;
        Objects.requireNonNull(v1Var);
        this.f5111f = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5111f.j())).setConditionalUserProperty(this.f5110e, this.f5407a);
    }
}
