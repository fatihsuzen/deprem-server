package com.mbridge.msdk.c.a;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.f;

public final class d {
    public static void a(Context context, e eVar) {
        if (eVar != null) {
            try {
                eVar.a("gaid", f.c());
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("SettingRequestDiff", e5.getMessage());
                }
            }
        }
    }
}
