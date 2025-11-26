package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.os.Bundle;
import j$.util.Objects;

final class Y0 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1218t0 f5276e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5277f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Y0(C1237v1 v1Var, C1218t0 t0Var) {
        super(v1Var, true);
        this.f5276e = t0Var;
        Objects.requireNonNull(v1Var);
        this.f5277f = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5277f.j())).getGmpAppId(this.f5276e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5276e.W((Bundle) null);
    }
}
