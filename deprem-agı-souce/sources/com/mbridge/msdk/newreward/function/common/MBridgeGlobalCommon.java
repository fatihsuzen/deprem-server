package com.mbridge.msdk.newreward.function.common;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.c.c.d;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.video.bt.module.b.h;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MBridgeGlobalCommon {
    public static String SESSION_ID = "";
    public static Map<String, h> showRewardListenerMap = new HashMap();

    public static String addQueryParameter(String str, String str2, String str3) {
        if (str != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                String encode = URLEncoder.encode(str2, C.UTF8_NAME);
                String encode2 = URLEncoder.encode(str3, C.UTF8_NAME);
                StringBuilder sb = new StringBuilder(str);
                if (!str.contains("?")) {
                    sb.append("?");
                } else if (!str.endsWith("&") && !str.endsWith("?")) {
                    sb.append("&");
                }
                sb.append(encode);
                sb.append("=");
                sb.append(encode2);
                return sb.toString();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("MBridgeGlobalCommon", "addQueryParameter", e5);
                }
            }
        }
        return "";
    }

    public static String getIsReadyNotReadyReasonType(b bVar) {
        if (bVar == null) {
            return "8";
        }
        d<?> w4 = bVar.w();
        if (w4 != null && !w4.d()) {
            return "4";
        }
        if (!bVar.A()) {
            return "10";
        }
        List<a> u5 = bVar.u();
        if (u5 == null || u5.isEmpty()) {
            return "8";
        }
        for (a next : u5) {
            if (next != null) {
                n d5 = next.d();
                if (d5 != null && !d5.d()) {
                    return "1";
                }
                d<?> c5 = next.c();
                if (c5 != null && !c5.d()) {
                    return "2";
                }
                d<?> f5 = next.f();
                if (f5 != null && !f5.d()) {
                    return "6";
                }
            }
        }
        return "0";
    }

    public static void handlerCampaigns(String str, b bVar, List<CampaignEx> list, List<a> list2) {
        if (bVar != null && list != null && list2 != null) {
            for (CampaignEx next : list) {
                try {
                    next.setRequestId(bVar.f());
                    next.setLocalRequestId(str);
                    next.setCampaignUnitId(bVar.e());
                    a aVar = new a(bVar);
                    aVar.c(next.getRequestIdNotice());
                    aVar.b(next.getAppName());
                    aVar.a(next.getId());
                    aVar.a(next);
                    list2.add(aVar);
                    if (!com.mbridge.msdk.foundation.same.b.a().a("new_bridge_reward_show")) {
                        if (!TextUtils.isEmpty(next.getCMPTEntryUrl()) && next.getAdSpaceT() != 2) {
                            String cMPTEntryUrl = next.getCMPTEntryUrl();
                            boolean i5 = ak.i(cMPTEntryUrl);
                            bVar.b(!i5);
                            if (!i5) {
                                cMPTEntryUrl = addQueryParameter(cMPTEntryUrl, "dyview", MBridgeCommon.DYNAMIC_VIEW_TEMPLATE_VALUE);
                            }
                            next.setCMPTEntryUrl(cMPTEntryUrl);
                        }
                    }
                    if (TextUtils.isEmpty(bVar.B())) {
                        bVar.h(next.getCMPTEntryUrl());
                        bVar.h(next.getMof_tplid());
                    }
                    long candidateCacheTime = next.getCandidateCacheTime();
                    if (candidateCacheTime > 0) {
                        bVar.b((candidateCacheTime * 1000) + System.currentTimeMillis());
                    }
                    bVar.j(next.getVcn());
                    bVar.k(next.getTokenRule());
                    CampaignEx.c rewardTemplateMode = next.getRewardTemplateMode();
                    if (!com.mbridge.msdk.foundation.same.b.a().a("new_bridge_reward_show")) {
                        if (rewardTemplateMode != null) {
                            bVar.i(rewardTemplateMode.b());
                            String e5 = rewardTemplateMode.e();
                            if (!TextUtils.isEmpty(e5) && next.getAdSpaceT() != 2) {
                                boolean i6 = ak.i(e5);
                                aVar.a(!i6);
                                if (!i6) {
                                    e5 = addQueryParameter(e5, "dyview", MBridgeCommon.DYNAMIC_VIEW_TEMPLATE_VALUE);
                                }
                                rewardTemplateMode.b(e5);
                                next.setRewardTemplateMode(rewardTemplateMode);
                            }
                        }
                        String str2 = next.getendcard_url();
                        if (!TextUtils.isEmpty(str2)) {
                            boolean l5 = ak.l(str2);
                            boolean i7 = ak.i(str2);
                            if (!l5 && !i7) {
                                next.setendcard_url(addQueryParameter(str2, "isplayableec", "0"));
                            }
                        }
                    }
                } catch (Exception e6) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("MBridgeGlobalCommon", "handlerCampaigns", e6);
                    }
                }
            }
            bVar.b(list);
            bVar.a(list2);
        }
    }

    public static void setAlertDialogText(String str, String str2, String str3, String str4, String str5) {
        Context c5 = c.m().c();
        if (!TextUtils.isEmpty(str2)) {
            an.b(c5, "MBridge_ConfirmTitle" + str, str2.trim());
        }
        if (!TextUtils.isEmpty(str3)) {
            an.b(c5, "MBridge_ConfirmContent" + str, str3.trim());
        }
        if (!TextUtils.isEmpty(str5)) {
            an.b(c5, "MBridge_CancelText" + str, str5.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            an.b(c5, "MBridge_ConfirmText" + str, str4.trim());
        }
    }
}
