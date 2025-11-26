package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.e.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.f.a;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBConfiguration;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class i extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9538a = "i";

    public static boolean a() {
        try {
            if (System.currentTimeMillis() - 86400000 > ((Long) an.a(c.m().c(), "privateAuthorityTimesTamp", 0L)).longValue()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000054");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    jSONObject.put("cid", campaignEx.getId());
                    jSONObject.put("reason", "");
                    jSONObject.put("result", 2);
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("insertStr", str2);
                    }
                    if (campaignEx.getAdType() == 287) {
                        jSONObject.put("creative", campaignEx.getendcard_url());
                        jSONObject.put("ad_type", 3);
                    } else if (campaignEx.getAdType() == 94) {
                        jSONObject.put("creative", campaignEx.getendcard_url());
                        jSONObject.put("ad_type", 1);
                    } else if (campaignEx.getAdType() == 296) {
                        jSONObject.put("ad_type", 5);
                        jSONObject.put("creative", campaignEx.getCreativeId());
                    } else if (campaignEx.getAdType() == 297) {
                        jSONObject.put("ad_type", 6);
                        jSONObject.put("creative", campaignEx.getCreativeId());
                    } else if (campaignEx.getAdType() == 298) {
                        jSONObject.put("ad_type", 7);
                        jSONObject.put("creative", campaignEx.getCreativeId());
                    } else {
                        jSONObject.put("creative", campaignEx.getendcard_url());
                        jSONObject.put("ad_type", 1);
                    }
                    jSONObject.put("devid", f.c());
                    if (campaignEx.isBidCampaign()) {
                        jSONObject.put(CampaignEx.JSON_KEY_HB, "1");
                    }
                    jSONObject.put("rid", campaignEx.getRequestId());
                    jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                    jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f9538a, th.getMessage());
            }
        }
    }

    public static void c() {
        try {
            a.e().execute(new Runnable() {
                public final void run() {
                    String[] list;
                    try {
                        String a5 = e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_CRASH_INFO);
                        if (!TextUtils.isEmpty(a5)) {
                            File file = new File(a5);
                            if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
                                for (String str : list) {
                                    File file2 = new File(a5 + "/" + str);
                                    if (file2.exists()) {
                                        String b5 = ad.b(file2);
                                        if (!TextUtils.isEmpty(b5)) {
                                            String[] split = b5.split("====");
                                            if (split.length > 0) {
                                                new h(c.m().c()).a(split[0], file2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        af.b(i.f9538a, th.getMessage());
                    }
                }
            });
        } catch (Throwable th) {
            af.b(f9538a, th.getMessage());
        }
    }

    public static JSONObject a(Campaign campaign, int i5, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", "adtrack");
            jSONObject.put("action", str);
            jSONObject.put("label", i5);
            if (campaign != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", campaign.getId());
                jSONObject2.put(CampaignEx.JSON_KEY_TITLE, campaign.getAppName());
                jSONObject.put("value", jSONObject2);
                return jSONObject;
            }
            jSONObject.put("value", "");
            return jSONObject;
        } catch (Exception e5) {
            af.b(f9538a, e5.getMessage());
            return jSONObject;
        }
    }

    public static com.mbridge.msdk.foundation.same.net.f.e a(Context context) {
        String str = "1";
        com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e();
        try {
            eVar.a("platform", str);
            eVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, URLEncoder.encode(ab.f(context)));
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                eVar.a("os_version", Build.VERSION.RELEASE);
                eVar.a("brand", URLEncoder.encode(ab.x()));
                eVar.a("model", URLEncoder.encode(ab.h()));
                if (b.a()) {
                    eVar.a("gaid", "");
                } else {
                    eVar.a("gaid", f.c());
                }
                eVar.a("mnc", ab.l(context));
                eVar.a("mcc", ab.k(context));
                int m5 = ab.m(context);
                eVar.a("network_type", m5 + "");
                eVar.a("network_str", ab.a(context, m5));
                eVar.a("language", URLEncoder.encode(ab.t(context)));
                eVar.a("timezone", URLEncoder.encode(ab.y()));
                eVar.a("ua", URLEncoder.encode(ab.g()));
                eVar.a("adid_limit", f.a() + "");
                if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.b()) {
                    str = "0";
                }
                eVar.a("adid_limit_dev", str);
            }
            eVar.a("sdk_version", MBConfiguration.SDK_VERSION);
            eVar.a("app_version_name", URLEncoder.encode(ab.q(context)));
            eVar.a("orientation", URLEncoder.encode(ab.s(context) + ""));
            eVar.a("screen_size", ab.j(context) + "x" + ab.h(context));
            if (b.a()) {
                com.mbridge.msdk.foundation.same.net.f.f.b(eVar);
            }
            g b5 = h.a().b(c.m().k());
            if (b5 == null) {
                h.a();
                b5 = com.mbridge.msdk.c.i.a();
            }
            if (b5 != null) {
                JSONObject a5 = j.a(context, b5);
                if (!TextUtils.isEmpty(a5.toString())) {
                    String b6 = z.b(a5.toString());
                    if (!TextUtils.isEmpty(b6)) {
                        eVar.a("dvi", b6);
                        return eVar;
                    }
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return eVar;
    }

    public static void b() {
        try {
            an.b(c.m().c(), "privateAuthorityTimesTamp", Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            af.b(f9538a, th.getMessage());
        }
    }

    public static void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000090");
            jSONObject.put("reason", TextUtils.isEmpty(str) ? "" : str);
            jSONObject.put("result", str);
            d.a().a(jSONObject);
        } catch (Exception e5) {
            af.b(f9538a, e5.getMessage());
        }
    }

    public static JSONObject a(Context context, g gVar) throws Exception {
        return j.a(context, gVar);
    }

    public static JSONObject a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", str);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            }
            return jSONObject;
        } catch (Throwable th) {
            af.b(f9538a, th.getMessage());
            return null;
        }
    }

    public static void a(Context context, String str, String str2, int i5, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000076");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    jSONObject.put("reason", str3);
                    jSONObject.put("result", i5);
                    jSONObject.put("url", str);
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f9538a, th.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i5, String str3, int i6) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000073");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    jSONObject.put("cid", campaignEx.getId());
                    jSONObject.put("reason", str3);
                    jSONObject.put("result", i5);
                    jSONObject.put("rid", campaignEx.getRequestId());
                    jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                    if (i6 != -1) {
                        jSONObject.put("d_t", i6);
                    }
                    jSONObject.put("url", str);
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f9538a, th.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i5, int i6, int i7) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000075");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    jSONObject.put("cid", campaignEx.getId());
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i5);
                    jSONObject.put("adtp", campaignEx.getAdType());
                    jSONObject.put("rid", campaignEx.getRequestId());
                    jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, i6);
                    if (i7 != -1) {
                        jSONObject.put("d_t", i7);
                    }
                    jSONObject.put("url", str);
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f9538a, th.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, int i5, int i6) {
        if (context != null && campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000074");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    jSONObject.put("cid", campaignEx.getId());
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i5);
                    jSONObject.put("adtp", campaignEx.getAdType());
                    jSONObject.put("rid", campaignEx.getRequestId());
                    jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                    if (i6 != -1) {
                        jSONObject.put("d_t", i6);
                    }
                    jSONObject.put("url", str);
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f9538a, th.getMessage());
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z4, CampaignEx campaignEx) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000047");
                    if (!TextUtils.isEmpty(str2)) {
                        String str3 = com.mbridge.msdk.foundation.controller.a.f8822b.get(str2);
                        if (str3 == null) {
                            str3 = "";
                        }
                        jSONObject.put("u_stid", str3);
                    }
                    if (campaignEx != null) {
                        jSONObject.put("cid", campaignEx.getId());
                        jSONObject.put("adtp", campaignEx.getAdType());
                        jSONObject.put("rid", campaignEx.getRequestId());
                        jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                    }
                    jSONObject.put("st", System.currentTimeMillis());
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    jSONObject.put(CampaignEx.JSON_KEY_HB, z4 ? 1 : 0);
                    jSONObject.put("reason", str);
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f9538a, th.getMessage());
            }
        }
    }

    public static void a(Context context, List<CampaignEx> list, String str, boolean z4) {
        if (context != null && list != null) {
            try {
                if (!list.isEmpty() && !TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000048");
                    jSONObject.put("st", System.currentTimeMillis());
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    jSONObject.put(CampaignEx.JSON_KEY_HB, z4 ? 1 : 0);
                    CampaignEx campaignEx = list.get(0);
                    if (campaignEx != null) {
                        jSONObject.put("cid", campaignEx.getId());
                        jSONObject.put("rid", campaignEx.getRequestId());
                        jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i5 = 0; i5 < list.size(); i5++) {
                        CampaignEx campaignEx2 = list.get(i5);
                        if (i5 < list.size() - 1) {
                            sb.append(campaignEx2.getRtinsType());
                            sb.append(",");
                        } else {
                            sb.append(campaignEx2.getRtinsType());
                        }
                    }
                    jSONObject.put(CampaignEx.JSON_KEY_RETARGET_TYPE, sb.toString());
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f9538a, th.getMessage());
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z4, String str3, String str4, String str5, String str6) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000104");
                    if (!TextUtils.isEmpty(str2)) {
                        String str7 = com.mbridge.msdk.foundation.controller.a.f8822b.get(str2);
                        if (str7 == null) {
                            str7 = "";
                        }
                        jSONObject.put("u_stid", str7);
                    }
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put("rid", str3);
                    jSONObject.put("rid_n", str4);
                    jSONObject.put("cid", str5);
                    jSONObject.put("template_id", str6);
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    jSONObject.put(CampaignEx.JSON_KEY_HB, z4 ? 1 : 0);
                    jSONObject.put("reason", str);
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f9538a, th.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2) {
        if (context != null) {
            try {
                if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str2))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000054");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                    jSONObject.put("reason", str2);
                    jSONObject.put("result", 1);
                    jSONObject.put("devid", f.c());
                    if (campaignEx != null) {
                        jSONObject.put("cid", campaignEx.getId());
                        if (campaignEx.getAdType() == 287) {
                            jSONObject.put("creative", campaignEx.getendcard_url());
                            jSONObject.put("ad_type", 3);
                        } else if (campaignEx.getAdType() == 94) {
                            jSONObject.put("creative", campaignEx.getendcard_url());
                            jSONObject.put("ad_type", 1);
                        } else if (campaignEx.getAdType() == 296) {
                            jSONObject.put("ad_type", 5);
                            jSONObject.put("creative", campaignEx.getCreativeId());
                        } else if (campaignEx.getAdType() == 297) {
                            jSONObject.put("ad_type", 6);
                            jSONObject.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getCreativeId());
                            jSONObject.put(CampaignEx.JSON_KEY_AD_ZIP, campaignEx.getAdZip());
                        } else if (campaignEx.getAdType() == 298) {
                            jSONObject.put("ad_type", 7);
                            jSONObject.put(CampaignEx.JSON_KEY_AD_HTML, campaignEx.getCreativeId());
                            jSONObject.put(CampaignEx.JSON_KEY_AD_ZIP, campaignEx.getAdZip());
                        } else {
                            jSONObject.put("creative", campaignEx.getendcard_url());
                            jSONObject.put("ad_type", 1);
                        }
                        jSONObject.put("devid", f.c());
                        if (campaignEx.isBidCampaign()) {
                            jSONObject.put(CampaignEx.JSON_KEY_HB, "1");
                        }
                        jSONObject.put("rid", campaignEx.getRequestId());
                        jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                        jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
                    }
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f9538a, th.getMessage());
            }
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i5, int i6, String str2, int i7, int i8, int i9, String str3) {
        com.mbridge.msdk.foundation.same.report.d.c cVar;
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("key", URLEncoder.encode("2000094", "utf-8"));
            if (campaignEx != null) {
                eVar.a("rid", URLEncoder.encode(campaignEx.getRequestId(), "utf-8"));
                eVar.a("rid_n", URLEncoder.encode(campaignEx.getRequestIdNotice(), "utf-8"));
                eVar.a("cid", URLEncoder.encode(campaignEx.getId(), "utf-8"));
                cVar = d.a().a(campaignEx.getCurrentLocalRid(), "");
            } else {
                cVar = null;
            }
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, URLEncoder.encode(str, "utf-8"));
            if (i5 == 0) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = "0";
                }
                eVar.a("video_prg", str3 + "");
            } else {
                eVar.a("video_prg", i5 + "");
            }
            eVar.a(TypedValues.CycleType.S_WAVE_PHASE, i6 + "");
            eVar.a("feedback_content", URLEncoder.encode(str2, "utf-8"));
            eVar.a("feedback_close", i7 + "");
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i9 + "");
            eVar.a("ad_type", i8 + "");
            eVar.a("network_type", URLEncoder.encode(String.valueOf(ab.m(c.m().c())), "utf-8"));
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            }
            cVar.d(str);
            cVar.b(i8);
            cVar.a("2000094", eVar);
            d.a().a("2000094", cVar);
        } catch (Exception e5) {
            af.b(f9538a, e5.getMessage());
        }
    }

    public static void a(String str) {
        try {
            if (c.m().c() != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000088");
                jSONObject.put(MRAIDCommunicatorUtil.KEY_STATE, str);
                g b5 = h.a().b(c.m().k());
                if (b5 == null || b.a(b5, jSONObject.toString())) {
                    d.a().a(jSONObject);
                }
            }
        } catch (Throwable th) {
            af.b(f9538a, th.getMessage());
        }
    }

    public static void a(Context context, CampaignEx campaignEx, int i5, String str, String str2) {
        String str3;
        if (context != null && campaignEx != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000114");
                jSONObject.put("network_type", ab.m(context));
                jSONObject.put(DomainCampaignEx.KEY_GH_ID, TextUtils.isEmpty(campaignEx.getGhId()) ? "" : campaignEx.getGhId());
                if (TextUtils.isEmpty(campaignEx.getGhPath())) {
                    str3 = "";
                } else {
                    str3 = campaignEx.getGhPath();
                }
                jSONObject.put(DomainCampaignEx.KEY_GH_PATH, str3);
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                jSONObject.put("rid", campaignEx.getRequestId());
                jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                jSONObject.put("result", i5);
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                jSONObject.put("reason", str);
                jSONObject.put("cid", campaignEx.getId());
                d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b(f9538a, th.getMessage());
            }
        }
    }

    public static void a(int i5, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000080");
            jSONObject.put("ad_type", i5);
            jSONObject.put("url", str);
            jSONObject.put("reason", str2);
            d.a().a(jSONObject);
        } catch (Exception e5) {
            af.b(f9538a, e5.getMessage());
        }
    }

    public static void a(CampaignEx campaignEx, String str, int i5, int i6, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000121");
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            jSONObject.put("cid", campaignEx.getId());
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i5);
            jSONObject.put("result", i6);
            jSONObject.put("reason", str2);
            d.a().a(jSONObject);
        } catch (Exception e5) {
            af.b(f9538a, e5.getMessage());
        }
    }

    public static void a(String str, int i5, int i6, String str2, int i7, String str3) {
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("key", URLEncoder.encode("m_water_mark_result", "utf-8"));
            eVar.a("water_mark_result", i6 + "");
            eVar.a("water_mark_error_msg", URLEncoder.encode(str2, "utf-8"));
            eVar.a("render_result", i7 + "");
            eVar.a("water_mark_str", URLEncoder.encode(str3, "utf-8"));
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            cVar.b(i5);
            cVar.d(str);
            cVar.a("m_water_mark_result", eVar);
            d.a().a("m_water_mark_result", cVar);
        } catch (Throwable th) {
            af.b(f9538a, th.getMessage());
        }
    }
}
