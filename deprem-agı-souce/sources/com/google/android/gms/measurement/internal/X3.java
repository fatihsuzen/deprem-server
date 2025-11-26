package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Bundle;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import j$.util.Objects;

final class X3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f6164a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6165b;

    X3(C1452x4 x4Var, Bundle bundle) {
        this.f6164a = bundle;
        Objects.requireNonNull(x4Var);
        this.f6165b = x4Var;
    }

    public final void run() {
        C1452x4 x4Var = this.f6165b;
        x4Var.h();
        x4Var.j();
        Bundle bundle = this.f6164a;
        C0722p.k(bundle);
        String e5 = C0722p.e(bundle.getString(RewardPlus.NAME));
        if (!x4Var.f5730a.g()) {
            x4Var.f5730a.a().w().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        v6 v6Var = new v6(e5, 0, (Object) null, "");
        try {
            G R4 = x4Var.f5730a.C().R(bundle.getString(MBridgeConstans.APP_ID), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true);
            String string = bundle.getString(MBridgeConstans.APP_ID);
            x4Var.f5730a.J().d0(new C1341i(string, "", v6Var, bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), (G) null, bundle.getLong("trigger_timeout"), (G) null, bundle.getLong("time_to_live"), R4));
        } catch (IllegalArgumentException unused) {
        }
    }
}
