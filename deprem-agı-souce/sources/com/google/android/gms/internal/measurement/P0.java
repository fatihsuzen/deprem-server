package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.os.Bundle;
import j$.util.Objects;

final class P0 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f5122e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f5123f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Bundle f5124g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5125h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    P0(C1237v1 v1Var, String str, String str2, Bundle bundle) {
        super(v1Var, true);
        this.f5122e = str;
        this.f5123f = str2;
        this.f5124g = bundle;
        Objects.requireNonNull(v1Var);
        this.f5125h = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5125h.j())).clearConditionalUserProperty(this.f5122e, this.f5123f, this.f5124g);
    }
}
