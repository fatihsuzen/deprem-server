package com.mbridge.msdk.video.dynview.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.out.Campaign;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12085a = "com.mbridge.msdk.video.dynview.f.a";

    public static void a(CampaignEx campaignEx, Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000091");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9179V)) {
                        jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.f9179V);
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9188g)) {
                        jSONObject.put("c", com.mbridge.msdk.foundation.same.a.f9188g);
                    }
                    jSONObject.put(CampaignEx.JSON_KEY_HB, 0);
                    jSONObject.put("rid_n", str3);
                    jSONObject.put("reason", str);
                    if (!(campaignEx == null || campaignEx.getRewardTemplateMode() == null)) {
                        jSONObject.put("dyview", ak.b(campaignEx.getRewardTemplateMode().e()));
                    }
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f12085a, th.getMessage());
            }
        }
    }

    public static void a(CampaignUnit campaignUnit, int i5, int i6, String str) {
        int i7;
        String impressionURL;
        if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0 && campaignUnit.getAds().get(i5) != null) {
            if (i6 != 0 || !campaignUnit.getAds().get(i5).mMoreOfferImpShow) {
                String a5 = aq.a(campaignUnit.getAds().get(i5).getendcard_url(), "mof_testuid");
                if (TextUtils.isEmpty(a5)) {
                    a5 = aq.a(campaignUnit.getAds().get(i5).getendcard_url(), "mof_uid");
                }
                String str2 = TextUtils.isEmpty(a5) ? str : a5;
                if (i6 == 0) {
                    i7 = com.mbridge.msdk.click.a.a.f8069g;
                    impressionURL = campaignUnit.getAds().get(i5).getImpressionURL();
                } else if (i6 != 1) {
                    impressionURL = "";
                    i7 = 0;
                } else {
                    i7 = com.mbridge.msdk.click.a.a.f8070h;
                    impressionURL = campaignUnit.getAds().get(i5).getOnlyImpressionURL();
                }
                String str3 = impressionURL;
                int i8 = i7;
                if (!TextUtils.isEmpty(str3)) {
                    com.mbridge.msdk.click.a.a(c.m().c(), campaignUnit.getAds().get(i5), str2, str3, false, true, i8);
                }
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, View view) {
        CampaignEx campaignEx2;
        Context context2;
        if (context != null && campaignEx != null) {
            if (campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().l() == null) {
                context2 = context;
                campaignEx2 = campaignEx;
            } else {
                context2 = context;
                campaignEx2 = campaignEx;
                com.mbridge.msdk.click.a.a(context2, campaignEx2, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
            }
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(context2, str);
            if (view instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup) view;
                aVar.a((i) new i() {
                    public final void onFinishRedirection(Campaign campaign, String str) {
                        if (campaign != null) {
                            aj.a(campaign, viewGroup);
                        }
                    }

                    public final void onRedirectionFailed(Campaign campaign, String str) {
                        if (campaign != null) {
                            aj.a(campaign, viewGroup);
                        }
                    }

                    public final void onStartRedirection(Campaign campaign, String str) {
                        if (campaign != null) {
                            aj.b(campaign, viewGroup);
                        }
                    }
                });
            }
            aVar.a(campaignEx2);
        }
    }
}
