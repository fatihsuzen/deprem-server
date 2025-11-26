package com.google.android.gms.measurement.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.concurrent.Callable;

final /* synthetic */ class N2 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ P2 f5987a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f5988b;

    /* synthetic */ N2(P2 p22, String str) {
        this.f5987a = p22;
        this.f5988b = str;
    }

    public final /* synthetic */ Object call() {
        P2 p22 = this.f5987a;
        C1426u F02 = p22.f6129b.F0();
        String str = this.f5988b;
        C1443w2 J02 = F02.J0(str);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put(CampaignEx.JSON_KEY_PACKAGE_NAME, str);
        p22.f5730a.w().A();
        hashMap.put("gmp_version", 133005L);
        if (J02 != null) {
            String D02 = J02.D0();
            if (D02 != null) {
                hashMap.put("app_version", D02);
            }
            hashMap.put("app_version_int", Long.valueOf(J02.F0()));
            hashMap.put("dynamite_version", Long.valueOf(J02.b()));
        }
        return hashMap;
    }
}
