package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.os.Bundle;
import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.h1  reason: case insensitive filesystem */
final class C1112h1 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f5366e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1218t0 f5367f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5368g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1112h1(C1237v1 v1Var, String str, C1218t0 t0Var) {
        super(v1Var, true);
        this.f5366e = str;
        this.f5367f = t0Var;
        Objects.requireNonNull(v1Var);
        this.f5368g = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5368g.j())).getMaxUserProperties(this.f5366e, this.f5367f);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5367f.W((Bundle) null);
    }
}
