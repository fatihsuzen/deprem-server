package com.mbridge.msdk.newreward.function.h;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.i;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static CampaignEx a(String str, CampaignEx campaignEx) {
        JSONObject jSONObject;
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str)) {
            CampaignEx campaignEx2 = null;
            if (campaignEx != null) {
                try {
                    jSONObject = CampaignEx.campaignToJsonObject(campaignEx);
                } catch (Throwable th) {
                    af.b("HybridCommunicatorUtil", th.getMessage());
                    return campaignEx;
                }
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                JSONObject jSONObject2 = new JSONObject(str);
                String optString = jSONObject2.optString(CampaignEx.JSON_KEY_NOTICE_URL);
                if (TextUtils.isEmpty(optString)) {
                    optString = campaignEx.getNoticeUrl();
                }
                String optString2 = jSONObject2.optString(CampaignEx.JSON_KEY_CLICK_URL);
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = campaignEx.getClickURL();
                }
                if (!str.contains("notice")) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject(a.f9191j);
                    if (optJSONObject != null) {
                        str3 = String.valueOf(ak.a(c.m().c(), (float) Integer.parseInt(optJSONObject.getString(a.f9189h))));
                        str2 = String.valueOf(ak.a(c.m().c(), (float) Integer.parseInt(optJSONObject.getString(a.f9190i))));
                    } else {
                        str3 = "-999";
                        str2 = str3;
                    }
                    if (optJSONObject != null) {
                        if (optJSONObject.length() > 0) {
                            Iterator<String> keys = optJSONObject.keys();
                            StringBuilder sb = new StringBuilder();
                            while (keys.hasNext()) {
                                sb.append("&");
                                String next = keys.next();
                                String optString3 = optJSONObject.optString(next);
                                if (a.f9189h.equals(next) || a.f9190i.equals(next)) {
                                    optString3 = String.valueOf(ak.a(c.m().c(), (float) Integer.parseInt(optString3)));
                                }
                                sb.append(next);
                                sb.append("=");
                                sb.append(optString3);
                            }
                            optString = optString + sb;
                        }
                    }
                    optString2 = com.mbridge.msdk.click.c.a(campaignEx.getClickURL(), str3, str2);
                } else {
                    if (!jSONObject2.has(CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
                        jSONObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, "");
                    }
                    if (jSONObject2.opt("akdlui") == null) {
                        jSONObject.put("akdlui", "");
                    }
                }
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    jSONObject.put(next2, jSONObject2.getString(next2));
                }
                if (!TextUtils.isEmpty(campaignEx.getCampaignUnitId())) {
                    jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, campaignEx.getCampaignUnitId());
                }
                jSONObject.put(CampaignEx.JSON_KEY_CLICK_URL, optString2);
                jSONObject.put(CampaignEx.JSON_KEY_NOTICE_URL, optString);
                campaignEx2 = CampaignEx.parseCampaignWithBackData(jSONObject);
            }
            return campaignEx2 == null ? campaignEx : campaignEx2;
        }
    }

    public static String a(String str, List<CampaignEx> list, boolean z4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put("sdk_info", "MAL_16.8.61,3.0.1");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("isRootTemplateWebView", false);
            jSONObject2.put("playVideoMute", i5);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", new i(c.m().c()).a());
            JSONArray jSONArray = new JSONArray();
            if (list != null && !list.isEmpty()) {
                for (CampaignEx next : list) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(next, next.isReady(), a(next)));
                }
            }
            jSONObject.put("campaignList", jSONArray);
            String g5 = h.a().g(c.m().k());
            if (!TextUtils.isEmpty(g5)) {
                JSONObject jSONObject3 = new JSONObject(g5);
                String c5 = h.a().c(str);
                if (!TextUtils.isEmpty(c5)) {
                    jSONObject3.put("ivreward", new JSONObject(c5));
                }
                jSONObject.put("appSetting", jSONObject3);
            }
            jSONObject.put("rewardSetting", com.mbridge.msdk.videocommon.d.b.a().b().k());
            jSONObject.put("unitSetting", com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), str).E());
            jSONObject.put("rw_plus", z4 ? "1" : "0");
        } catch (Throwable th) {
            af.b("HybridCommunicatorUtil", th.getMessage());
        }
        return jSONObject.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r0 = com.mbridge.msdk.c.h.a().b(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.mbridge.msdk.foundation.entity.CampaignEx r6) {
        /*
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r0 = r0.k()     // Catch:{ Exception -> 0x0038 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0038 }
            r2 = 0
            if (r1 != 0) goto L_0x0022
            com.mbridge.msdk.c.h r1 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x0038 }
            com.mbridge.msdk.c.g r0 = r1.b(r0)     // Catch:{ Exception -> 0x0038 }
            if (r0 == 0) goto L_0x0022
            long r0 = r0.ad()     // Catch:{ Exception -> 0x0038 }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r4
            goto L_0x0023
        L_0x0022:
            r0 = r2
        L_0x0023:
            com.mbridge.msdk.videocommon.d.b r4 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x0038 }
            com.mbridge.msdk.videocommon.d.a r4 = r4.b()     // Catch:{ Exception -> 0x0038 }
            if (r4 == 0) goto L_0x0031
            long r2 = r4.f()     // Catch:{ Exception -> 0x0038 }
        L_0x0031:
            if (r6 == 0) goto L_0x0042
            boolean r6 = r6.isSpareOffer(r2, r0)     // Catch:{ Exception -> 0x0038 }
            return r6
        L_0x0038:
            r6 = move-exception
            java.lang.String r0 = "HybridCommunicatorUtil"
            java.lang.String r6 = r6.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r6)
        L_0x0042:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.h.b.a(com.mbridge.msdk.foundation.entity.CampaignEx):boolean");
    }

    public static String a(int i5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i5);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : jSONObject2;
        } catch (Throwable th) {
            af.b("HybridCommunicatorUtil", th.getMessage());
            return "";
        }
    }

    public static String a(float f5, float f6, int i5) {
        JSONObject jSONObject;
        int i6;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
            jSONObject.put(a.f9189h, ak.b(c.m().c(), f5));
            jSONObject.put(a.f9190i, ak.b(c.m().c(), f6));
            jSONObject.put(a.f9194m, i5);
            i6 = c.m().c().getResources().getConfiguration().orientation;
        } catch (Throwable th) {
            af.b("HybridCommunicatorUtil", th.getMessage());
        }
        jSONObject.put(a.f9192k, i6);
        jSONObject.put(a.f9193l, (double) ak.d(c.m().c()));
        jSONObject2.put(a.f9191j, jSONObject);
        return jSONObject2.toString();
    }
}
