package com.google.android.gms.internal.measurement;

import N.C0722p;
import U.b;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import f0.C1661p;
import j$.util.Objects;

final class T0 extends C1139k1 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Context f5175e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Bundle f5176f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5177g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    T0(C1237v1 v1Var, Context context, Bundle bundle) {
        super(v1Var, true);
        this.f5175e = context;
        this.f5176f = bundle;
        Objects.requireNonNull(v1Var);
        this.f5177g = v1Var;
    }

    public final void a() {
        boolean z4;
        boolean z5;
        try {
            Context context = this.f5175e;
            C0722p.k(context);
            String a5 = C1661p.a(context);
            C0722p.k(context);
            Resources resources = context.getResources();
            if (TextUtils.isEmpty(a5)) {
                a5 = C1661p.a(context);
            }
            Boolean c5 = C1661p.c("google_analytics_force_disable_updates", resources, a5);
            C1237v1 v1Var = this.f5177g;
            if (c5 == null || !c5.booleanValue()) {
                z4 = true;
            } else {
                z4 = false;
            }
            v1Var.k(v1Var.q(context, z4));
            if (v1Var.j() == null) {
                Log.w(v1Var.h(), "Failed to connect to measurement client.");
                return;
            }
            int a6 = DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
            int c6 = DynamiteModule.c(context, ModuleDescriptor.MODULE_ID);
            int max = Math.max(a6, c6);
            if (Boolean.TRUE.equals(c5) || c6 < a6) {
                z5 = true;
            } else {
                z5 = false;
            }
            ((C1245w0) C0722p.k(v1Var.j())).initialize(b.q0(context), new J0(133005, (long) max, z5, this.f5176f, C1661p.a(context)), this.f5407a);
        } catch (Exception e5) {
            this.f5177g.g(e5, true, false);
        }
    }
}
