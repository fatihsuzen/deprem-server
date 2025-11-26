package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.tracker.e;
import com.mbridge.msdk.tracker.f;
import com.mbridge.msdk.tracker.h;
import org.json.JSONObject;

public class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f9441a = "c";

    public static JSONObject a() {
        return a.a();
    }

    public static f b() {
        return new f() {
            public final boolean a(e eVar) throws Exception {
                return c.a(eVar);
            }
        };
    }

    public static h c() {
        return new h() {
            public final JSONObject a(e eVar) {
                String str = "";
                if (eVar == null) {
                    return null;
                }
                JSONObject d5 = eVar.d();
                if (d5 == null) {
                    d5 = new JSONObject();
                }
                try {
                    d5.put("key", eVar.a());
                    Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
                    int m5 = ab.m(c5);
                    if (!d5.has("network_type")) {
                        d5.put("network_type", m5);
                        d5.put("network_str", ab.a(c5, m5));
                    }
                    if (!d5.has("st")) {
                        d5.put("st", System.currentTimeMillis());
                    }
                    String optString = d5.optString(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    if (!TextUtils.isEmpty(optString)) {
                        String str2 = a.f8822b.get(optString);
                        if (str2 != null) {
                            str = str2;
                        }
                        d5.put("u_stid", str);
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9179V) && !d5.has(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                        d5.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.f9179V);
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9188g) && !d5.has(c.f9441a)) {
                        d5.put(c.f9441a, com.mbridge.msdk.foundation.same.a.f9188g);
                    }
                    return d5;
                } catch (Exception e5) {
                    af.b(c.f9441a, e5.getMessage());
                    return d5;
                }
            }
        };
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.remove("model");
                jSONObject.remove("brand");
                jSONObject.remove("screen_size");
                jSONObject.remove("sub_ip");
                jSONObject.remove("network_type");
                jSONObject.remove("useragent");
                jSONObject.remove("ua");
                jSONObject.remove("language");
                jSONObject.remove("network_str");
                jSONObject.remove("mnc");
                jSONObject.remove("mcc");
                jSONObject.remove("os_version");
                jSONObject.remove("gp_version");
                jSONObject.remove("country_code");
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
                jSONObject.remove(com.mbridge.msdk.foundation.same.net.f.e.f9394a);
                jSONObject.remove(com.mbridge.msdk.foundation.same.net.f.e.f9395b);
                jSONObject.remove("power_rate");
                jSONObject.remove("charging");
                jSONObject.remove("timezone");
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.remove("gaid");
                jSONObject.remove("gaid2");
                jSONObject.remove("oaid");
                jSONObject.remove("az_aid_info");
            }
        }
    }

    static /* synthetic */ boolean a(e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.a())) {
            return false;
        }
        String a5 = eVar.a();
        if (TextUtils.isEmpty(a5)) {
            return false;
        }
        g b5 = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (b5 == null) {
            return true;
        }
        return b.a(b5, a5);
    }
}
