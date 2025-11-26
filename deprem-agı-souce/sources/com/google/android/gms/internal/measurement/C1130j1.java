package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.os.Bundle;
import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.j1  reason: case insensitive filesystem */
final class C1130j1 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Long f5390e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f5391f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ String f5392g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ Bundle f5393h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ boolean f5394i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ boolean f5395j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5396k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1130j1(C1237v1 v1Var, Long l5, String str, String str2, Bundle bundle, boolean z4, boolean z5) {
        super(v1Var, true);
        this.f5390e = l5;
        this.f5391f = str;
        this.f5392g = str2;
        this.f5393h = bundle;
        this.f5394i = z4;
        this.f5395j = z5;
        Objects.requireNonNull(v1Var);
        this.f5396k = v1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        long longValue;
        Long l5 = this.f5390e;
        if (l5 == null) {
            longValue = this.f5407a;
        } else {
            longValue = l5.longValue();
        }
        ((C1245w0) C0722p.k(this.f5396k.j())).logEvent(this.f5391f, this.f5392g, this.f5393h, this.f5394i, this.f5395j, longValue);
    }
}
