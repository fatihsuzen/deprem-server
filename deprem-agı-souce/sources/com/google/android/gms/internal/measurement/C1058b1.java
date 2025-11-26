package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.os.Bundle;
import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.b1  reason: case insensitive filesystem */
final class C1058b1 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1218t0 f5306e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5307f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1058b1(C1237v1 v1Var, C1218t0 t0Var) {
        super(v1Var, true);
        this.f5306e = t0Var;
        Objects.requireNonNull(v1Var);
        this.f5307f = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5307f.j())).getCurrentScreenName(this.f5306e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f5306e.W((Bundle) null);
    }
}
