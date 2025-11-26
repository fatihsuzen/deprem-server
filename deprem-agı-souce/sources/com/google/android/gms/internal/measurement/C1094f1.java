package com.google.android.gms.internal.measurement;

import N.C0722p;
import U.b;
import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.f1  reason: case insensitive filesystem */
final class C1094f1 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f5346e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Object f5347f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5348g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1094f1(C1237v1 v1Var, boolean z4, int i5, String str, Object obj, Object obj2, Object obj3) {
        super(v1Var, false);
        this.f5346e = str;
        this.f5347f = obj;
        Objects.requireNonNull(v1Var);
        this.f5348g = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((C1245w0) C0722p.k(this.f5348g.j())).logHealthData(5, this.f5346e, b.q0(this.f5347f), b.q0((Object) null), b.q0((Object) null));
    }
}
