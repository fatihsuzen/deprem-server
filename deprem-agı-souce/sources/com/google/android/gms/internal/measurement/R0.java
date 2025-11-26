package com.google.android.gms.internal.measurement;

import N.C0722p;
import j$.util.Objects;

final class R0 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ L0 f5156e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f5157f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ String f5158g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5159h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    R0(C1237v1 v1Var, L0 l02, String str, String str2) {
        super(v1Var, true);
        this.f5156e = l02;
        this.f5157f = str;
        this.f5158g = str2;
        Objects.requireNonNull(v1Var);
        this.f5159h = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5159h.j())).setCurrentScreenByScionActivityInfo(this.f5156e, this.f5157f, this.f5158g, this.f5407a);
    }
}
