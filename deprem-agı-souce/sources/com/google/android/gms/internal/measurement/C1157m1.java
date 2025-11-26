package com.google.android.gms.internal.measurement;

import N.C0722p;
import android.app.Activity;
import android.os.Bundle;
import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.m1  reason: case insensitive filesystem */
final class C1157m1 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Bundle f5437e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Activity f5438f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ C1228u1 f5439g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1157m1(C1228u1 u1Var, Bundle bundle, Activity activity) {
        super(u1Var.f5594a, true);
        this.f5437e = bundle;
        this.f5438f = activity;
        Objects.requireNonNull(u1Var);
        this.f5439g = u1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Bundle bundle;
        Bundle bundle2 = this.f5437e;
        if (bundle2 != null) {
            bundle = new Bundle();
            if (bundle2.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = bundle2.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        Activity activity = this.f5438f;
        ((C1245w0) C0722p.k(this.f5439g.f5594a.j())).onActivityCreatedByScionActivityInfo(L0.c(activity), bundle, this.f5408b);
    }
}
