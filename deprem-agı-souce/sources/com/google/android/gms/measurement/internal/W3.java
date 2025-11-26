package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Bundle;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import j$.util.Objects;

final class W3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f6126a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6127b;

    W3(C1452x4 x4Var, Bundle bundle) {
        this.f6126a = bundle;
        Objects.requireNonNull(x4Var);
        this.f6127b = x4Var;
    }

    public final void run() {
        C1452x4 x4Var = this.f6127b;
        x4Var.h();
        x4Var.j();
        Bundle bundle = this.f6126a;
        C0722p.k(bundle);
        String string = bundle.getString(RewardPlus.NAME);
        String string2 = bundle.getString(TtmlNode.ATTR_TTS_ORIGIN);
        C0722p.e(string);
        C0722p.e(string2);
        C0722p.k(bundle.get("value"));
        if (!x4Var.f5730a.g()) {
            x4Var.f5730a.a().w().a("Conditional property not set since app measurement is disabled");
            return;
        }
        v6 v6Var = new v6(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            X2 x22 = x4Var.f5730a;
            G R4 = x22.C().R(bundle.getString(MBridgeConstans.APP_ID), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0, true, true);
            G R5 = x22.C().R(bundle.getString(MBridgeConstans.APP_ID), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0, true, true);
            G R6 = x22.C().R(bundle.getString(MBridgeConstans.APP_ID), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0, true, true);
            String string3 = bundle.getString(MBridgeConstans.APP_ID);
            long j5 = bundle.getLong("creation_timestamp");
            v6 v6Var2 = v6Var;
            x4Var.f5730a.J().d0(new C1341i(string3, string2, v6Var2, j5, false, bundle.getString("trigger_event_name"), R5, bundle.getLong("trigger_timeout"), R4, bundle.getLong("time_to_live"), R6));
        } catch (IllegalArgumentException unused) {
        }
    }
}
