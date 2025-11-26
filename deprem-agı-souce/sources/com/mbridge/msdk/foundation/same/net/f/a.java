package com.mbridge.msdk.foundation.same.net.f;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;

public class a extends c {
    public a(Context context) {
        super(context);
    }

    public void addExtraParams(String str, e eVar) {
        try {
            int a5 = ak.a();
            String c5 = ak.c();
            if (eVar != null) {
                eVar.a("misk_spt", String.valueOf(a5));
                if (!TextUtils.isEmpty(c5)) {
                    eVar.a("misk_spt_det", c5);
                }
            }
        } catch (Exception e5) {
            af.a("CampaignRequest", e5.getMessage());
        } finally {
            super.addExtraParams(str, eVar);
        }
    }
}
