package com.mbridge.msdk.video.bt.module.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12028a = "com.mbridge.msdk.video.bt.module.b.f";

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                o a5 = o.a((com.mbridge.msdk.foundation.db.f) g.a(context));
                if (!TextUtils.isEmpty(str) && a5 != null && a5.a() > 0) {
                    List<n> a6 = a5.a("m_download_end");
                    List<n> a7 = a5.a("2000021");
                    List<n> a8 = a5.a("2000039");
                    List<n> a9 = a5.a("m_download_end");
                    List<n> a10 = a5.a("m_download_end");
                    List<n> a11 = a5.a("2000044");
                    com.mbridge.msdk.foundation.same.report.n.e(a7);
                    com.mbridge.msdk.foundation.same.report.n.a(a6);
                    com.mbridge.msdk.foundation.same.report.n.c(a8);
                    com.mbridge.msdk.foundation.same.report.n.b(a9);
                    com.mbridge.msdk.foundation.same.report.n.f(a10);
                    com.mbridge.msdk.foundation.same.report.n.d(a11);
                }
            } catch (Exception e5) {
                af.b(f12028a, e5.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, int i5) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000054");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    jSONObject.put("cid", campaignEx.getId());
                    jSONObject.put("reason", "");
                    jSONObject.put("templateshowtype", i5 + " offer show success");
                    jSONObject.put("result", 2);
                    jSONObject.put("ad_type", campaignEx.getAdType() == 287 ? 3 : 1);
                    String str2 = campaignEx.getendcard_url();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("creative", URLEncoder.encode(str2, C.UTF8_NAME));
                    }
                    jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
                    jSONObject.put("rid", campaignEx.getRequestId());
                    jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                    jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f12028a, th.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i5) {
        if (context != null && campaignEx != null) {
            try {
                int i6 = 1;
                if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str2))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000054");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    jSONObject.put("cid", campaignEx.getId());
                    jSONObject.put("reason", str2);
                    jSONObject.put("templateshowtype", i5);
                    jSONObject.put("result", 1);
                    String str3 = campaignEx.getendcard_url();
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("creative", URLEncoder.encode(str3, C.UTF8_NAME));
                    }
                    jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
                    if (campaignEx.getAdType() == 287) {
                        i6 = 3;
                    }
                    jSONObject.put("ad_type", i6);
                    jSONObject.put("rid", campaignEx.getRequestId());
                    jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                    jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f12028a, th.getMessage());
            }
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str) {
        if (context != null && list != null) {
            try {
                if (!list.isEmpty() && !TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000054");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < list.size(); i5++) {
                        arrayList.add(list.get(i5).getId());
                    }
                    jSONObject.put("cid", arrayList);
                    jSONObject.put("result", 2);
                    if (list.get(0) != null) {
                        CampaignEx campaignEx = list.get(0);
                        jSONObject.put("reason", "");
                        jSONObject.put("templateshowtype", "two offer ec show success");
                        jSONObject.put("ad_type", campaignEx.getAdType());
                        jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
                        jSONObject.put("rid", campaignEx.getRequestId());
                        jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                        jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
                    }
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f12028a, th.getMessage());
            }
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str, String str2) {
        if (context != null && list != null) {
            try {
                if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str2))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000054");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < list.size(); i5++) {
                        arrayList.add(list.get(i5).getId());
                    }
                    jSONObject.put("cid", arrayList);
                    jSONObject.put("reason", str2);
                    jSONObject.put("result", 1);
                    jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
                    if (list.get(0) != null) {
                        CampaignEx campaignEx = list.get(0);
                        jSONObject.put("ad_type", campaignEx.getAdType());
                        jSONObject.put("rid", campaignEx.getRequestId());
                        jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                        jSONObject.put("templateshowtype", campaignEx.getMof_tplid());
                        jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
                    }
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f12028a, th.getMessage());
            }
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i5) {
        try {
            Context c5 = c.m().c();
            if (c5 != null && campaignEx != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000115");
                jSONObject.put("network_type", ab.m(c5));
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                jSONObject.put("cid", campaignEx.getId());
                jSONObject.put("play_cur_time", i5);
                jSONObject.put("reason", "close ad in advance " + campaignEx.getMof_tplid());
                jSONObject.put("result", 1);
                jSONObject.put("devid", com.mbridge.msdk.foundation.tools.f.c());
                jSONObject.put("ad_type", campaignEx.getAdType());
                jSONObject.put("rid", campaignEx.getRequestId());
                jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
                d.a().a(jSONObject);
            }
        } catch (Throwable th) {
            af.b(f12028a, th.getMessage());
        }
    }
}
