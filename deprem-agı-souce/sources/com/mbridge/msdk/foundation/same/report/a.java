package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.authoritycontroller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.z;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static JSONObject a() {
        JSONObject jSONObject;
        Context c5 = c.m().c();
        try {
            jSONObject = i.a(c5).c();
        } catch (Exception e5) {
            af.b("CommonDeviceInfo", "getCommonProperty error", e5);
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9179V)) {
                com.mbridge.msdk.foundation.same.a.f9179V = com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9179V)) {
                jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.f9179V);
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9188g)) {
                com.mbridge.msdk.foundation.same.a.f9188g = com.mbridge.msdk.foundation.a.a.a.a().a("c");
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9188g)) {
                jSONObject.put("c", com.mbridge.msdk.foundation.same.a.f9188g);
            }
            jSONObject.put("open", com.mbridge.msdk.foundation.same.a.f9176S);
            String a5 = Aa.a();
            if (a5 == null) {
                a5 = "";
            }
            jSONObject.put("channel", a5);
            jSONObject.put("band_width", com.mbridge.msdk.foundation.same.net.a.a().b());
            if (!b.a()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
            g b5 = h.a().b(c.m().k());
            if (b5 == null) {
                h.a();
                b5 = i.a();
            }
            JSONObject a6 = a(b5);
            if (a6 != null) {
                String jSONObject2 = a6.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    String b6 = z.b(jSONObject2);
                    if (!TextUtils.isEmpty(b6)) {
                        jSONObject.put("dvi", b6);
                    }
                }
            }
            jSONObject.put(MBridgeConstans.APP_ID, c.m().k());
            jSONObject.put("m_sdk", "msdk");
            jSONObject.put("lqswt", String.valueOf(1));
            jSONObject.put("network_available", String.valueOf(ak.m(c5)));
            String str = "UNKNOWN";
            if (b5 != null) {
                str = b5.r();
                jSONObject.put("a_stid", b5.d());
            }
            jSONObject.put("country_code", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static JSONObject a(g gVar) {
        try {
            return i.a(c.m().c(), gVar);
        } catch (Exception unused) {
            return null;
        }
    }
}
