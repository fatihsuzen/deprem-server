package com.mbridge.msdk.video.module.b;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.aq;

public final class a {
    public static void a(String str, CampaignEx campaignEx, e eVar) {
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str) && campaignEx != null && eVar != null) {
            try {
                String mof_template_url = campaignEx.getMof_template_url();
                String str4 = "";
                if (!TextUtils.isEmpty(mof_template_url)) {
                    str2 = aq.a(mof_template_url, "cltp");
                    str3 = aq.a(mof_template_url, "xt");
                } else {
                    str3 = str4;
                    str2 = str3;
                }
                if (!TextUtils.isEmpty(str2)) {
                    eVar.a("cltp", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    eVar.a("xt", str3);
                }
                CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                if (rewardTemplateMode != null) {
                    String e5 = rewardTemplateMode.e();
                    if (!TextUtils.isEmpty(e5)) {
                        str4 = aq.a(e5, "alecfc");
                    }
                }
                if (!TextUtils.isEmpty(str4)) {
                    eVar.a("alecfc", str4);
                }
                d.a().a(str, campaignEx, eVar);
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    e6.printStackTrace();
                }
            }
        }
    }
}
