package com.google.android.gms.measurement.internal;

import R.b;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.V;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import j$.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class F2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ V f5871a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ServiceConnection f5872b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ G2 f5873c;

    F2(G2 g22, V v5, ServiceConnection serviceConnection) {
        this.f5871a = v5;
        this.f5872b = serviceConnection;
        Objects.requireNonNull(g22);
        this.f5873c = g22;
    }

    public final void run() {
        Bundle bundle;
        G2 g22 = this.f5873c;
        H2 h22 = g22.f5890b;
        X2 x22 = h22.f5907a;
        x22.b().h();
        Bundle bundle2 = new Bundle();
        String a5 = g22.a();
        bundle2.putString(CampaignEx.JSON_KEY_PACKAGE_NAME, a5);
        try {
            bundle = this.f5871a.D(bundle2);
            if (bundle == null) {
                x22.a().o().a("Install Referrer Service returned a null response");
                bundle = null;
            }
        } catch (Exception e5) {
            h22.f5907a.a().o().b("Exception occurred while retrieving the Install Referrer", e5.getMessage());
        }
        X2 x23 = h22.f5907a;
        x23.b().h();
        X2.q();
        if (bundle != null) {
            long j5 = bundle.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j5 == 0) {
                x23.a().r().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    x23.a().o().a("No referrer defined in Install Referrer response");
                } else {
                    x23.a().w().b("InstallReferrer API result", string);
                    Bundle s02 = x23.C().s0(Uri.parse("?".concat(string)));
                    if (s02 == null) {
                        x23.a().o().a("No campaign params defined in Install Referrer result");
                    } else {
                        List asList = Arrays.asList(((String) C1304d2.f6335h1.b((Object) null)).split(","));
                        Iterator<String> it = s02.keySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (asList.contains(it.next())) {
                                long j6 = bundle.getLong("referrer_click_timestamp_server_seconds", 0) * 1000;
                                if (j6 > 0) {
                                    s02.putLong("click_timestamp", j6);
                                }
                            }
                        }
                        if (j5 == x23.x().f5837g.a()) {
                            x23.a().w().a("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (x23.g()) {
                            x23.x().f5837g.b(j5);
                            x23.a().w().b("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            s02.putString("_cis", "referrer API v2");
                            x23.B().w("auto", "_cmp", s02, a5);
                        }
                    }
                }
            }
        }
        b.b().c(x23.e(), this.f5872b);
    }
}
