package com.google.android.gms.internal.measurement;

import N.C0722p;
import U.b;
import j$.util.Objects;

final class N0 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f5028e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f5029f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Object f5030g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ boolean f5031h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5032i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    N0(C1237v1 v1Var, String str, String str2, Object obj, boolean z4) {
        super(v1Var, true);
        this.f5028e = str;
        this.f5029f = str2;
        this.f5030g = obj;
        this.f5031h = z4;
        Objects.requireNonNull(v1Var);
        this.f5032i = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5032i.j())).setUserProperty(this.f5028e, this.f5029f, b.q0(this.f5030g), this.f5031h, this.f5407a);
    }
}
