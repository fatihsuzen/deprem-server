package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.os.Bundle;
import j$.util.Objects;

final class Q0 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f5136e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f5137f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ C1218t0 f5138g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5139h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Q0(C1237v1 v1Var, String str, String str2, C1218t0 t0Var) {
        super(v1Var, true);
        this.f5136e = str;
        this.f5137f = str2;
        this.f5138g = t0Var;
        Objects.requireNonNull(v1Var);
        this.f5139h = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5139h.j())).getConditionalUserProperties(this.f5136e, this.f5137f, this.f5138g);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5138g.W((Bundle) null);
    }
}
