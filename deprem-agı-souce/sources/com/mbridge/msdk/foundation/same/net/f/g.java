package com.mbridge.msdk.foundation.same.net.f;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.b;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.z;
import org.json.JSONObject;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f9405a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f9406b = "";

    public static void a(e eVar) {
    }

    public static void b(e eVar) {
    }

    public static void c(e eVar) {
    }

    public static void a(e eVar, Context context) {
    }

    public static void a(e eVar, Context context, boolean z4, com.mbridge.msdk.c.g gVar) {
        if (eVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("dmt", ab.o() + "");
                    jSONObject.put("dmf", ab.f());
                    jSONObject.put("adid_limit", f.a() + "");
                    jSONObject.put("adid_limit_dev", b.b() ? "1" : "0");
                }
                if (gVar.av() == 1 && !TextUtils.isEmpty(f.d()) && c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    jSONObject.put("az_aid_info", f.d());
                }
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    if (!jSONObject.equals(f9406b)) {
                        f9405a = z.b(jSONObject.toString());
                    }
                    if (!TextUtils.isEmpty(f9405a)) {
                        eVar.a("dvi", f9405a);
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonRequestParamsForAddDiff", e5.getMessage());
                }
            }
        }
    }
}
