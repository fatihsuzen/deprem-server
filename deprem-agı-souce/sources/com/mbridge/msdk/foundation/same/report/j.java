package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.controller.authoritycontroller.b;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.f;
import org.json.JSONObject;

public final class j {
    public static JSONObject a(Context context, g gVar) throws Exception {
        String str;
        JSONObject jSONObject = new JSONObject();
        if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            String l5 = ab.l();
            if (!TextUtils.isEmpty(l5)) {
                jSONObject.put("manufacturer", l5);
            }
            int k5 = ab.k();
            if (k5 != -1) {
                jSONObject.put("sdkint", k5);
            }
            String n5 = ab.n(context);
            if (!TextUtils.isEmpty(n5)) {
                jSONObject.put("is24H", n5);
            }
            String p5 = ab.p();
            if (!TextUtils.isEmpty(p5)) {
                jSONObject.put("totalram", p5);
            }
            String o5 = ab.o(context);
            if (!TextUtils.isEmpty(o5)) {
                jSONObject.put("totalmemory", o5);
            }
            jSONObject.put("adid_limit", f.a() + "");
            if (b.b()) {
                str = "1";
            } else {
                str = "0";
            }
            jSONObject.put("adid_limit_dev", str);
        }
        if (gVar.av() == 1 && !TextUtils.isEmpty(f.d()) && c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            jSONObject.put("az_aid_info", f.d());
        }
        return jSONObject;
    }
}
