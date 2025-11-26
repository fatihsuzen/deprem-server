package com.mbridge.msdk.c;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONObject;

public final class g extends b {
    public static g e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return b.a(new JSONObject(str));
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("Setting", "parseSetting", e5);
            }
            return null;
        }
    }

    public final String aM() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cc", r());
            jSONObject.put("cfc", t());
            jSONObject.put("cfb", aE());
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, ac());
            jSONObject.put("awct", p());
            jSONObject.put("rurl", aJ());
            jSONObject.put("ujds", aK());
            jSONObject.put(CampaignEx.JSON_KEY_PLCTB, ad());
            jSONObject.put("tcto", ar());
            jSONObject.put("mv_wildcard", V());
            jSONObject.put("is_startup_crashsystem", L());
            jSONObject.put("sfct", ao());
            jSONObject.put("pcrn", Z());
            jSONObject.put("adct", l());
            jSONObject.put("atrqt", o());
            jSONObject.put("omsdkjs_url", X());
            jSONObject.put("mcs", T());
            jSONObject.put("GDPR_area", aH());
            jSONObject.put("alrbs", m());
            jSONObject.put("ct", A());
            jSONObject.put("isDefault", K());
            jSONObject.put("st_net", aq());
            jSONObject.put("vtag", ay());
            return jSONObject.toString();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            af.b("Setting", "toJSON", th);
            return null;
        }
    }
}
