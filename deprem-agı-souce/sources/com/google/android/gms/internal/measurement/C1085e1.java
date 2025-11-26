package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.os.Bundle;
import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.e1  reason: case insensitive filesystem */
final class C1085e1 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f5333e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f5334f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ boolean f5335g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ C1218t0 f5336h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5337i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1085e1(C1237v1 v1Var, String str, String str2, boolean z4, C1218t0 t0Var) {
        super(v1Var, true);
        this.f5333e = str;
        this.f5334f = str2;
        this.f5335g = z4;
        this.f5336h = t0Var;
        Objects.requireNonNull(v1Var);
        this.f5337i = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5337i.j())).getUserProperties(this.f5333e, this.f5334f, this.f5335g, this.f5336h);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5336h.W((Bundle) null);
    }
}
