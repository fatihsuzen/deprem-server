package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.os.Bundle;
import j$.util.Objects;

final class Z0 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1218t0 f5291e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5292f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Z0(C1237v1 v1Var, C1218t0 t0Var) {
        super(v1Var, true);
        this.f5291e = t0Var;
        Objects.requireNonNull(v1Var);
        this.f5292f = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5292f.j())).getCachedAppInstanceId(this.f5291e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5291e.W((Bundle) null);
    }
}
