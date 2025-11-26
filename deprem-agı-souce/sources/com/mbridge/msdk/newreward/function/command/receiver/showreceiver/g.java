package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import com.mbridge.msdk.newreward.function.e.f;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class g implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f10855a = "RedirectReceiver";

    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.g$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10856a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.newreward.player.redirect.RedirectType[] r0 = com.mbridge.msdk.newreward.player.redirect.RedirectType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10856a = r0
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.NOTICE_URL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.CLICK_URL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.IMPRESSION_URL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.ONLY_IMPRESSION_URL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.PV_URL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.AD_TRACKING_CLICK_URL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.AD_TRACKING_EC_SHOW_URL     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.AD_TRACKING_CLOSE_URL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.AD_TRACKING_MUTE_URL     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.AD_TRACKING_UN_MUTE_URL     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.AD_TRACKING_IMPRESSION_URL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.AD_TRACKING_ERROR     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.AD_TRACKING_PLAY_PERCENTAGE     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.AD_TRACKING_PAUSE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.AD_TRACKING_RESUME     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.AD_URL_LIST     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.ADV_IMP_LIST     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f10856a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.ADD_REWARD     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.g.AnonymousClass1.<clinit>():void");
        }
    }

    public final void a(Object obj) {
        List<String> pv_urls;
        String[] l5;
        String[] r5;
        String[] s5;
        String[] j5;
        String[] k5;
        String[] p5;
        String[] o5;
        String[] m5;
        String[] n5;
        String str = "?";
        Map map = (Map) obj;
        RedirectModel redirectModel = (RedirectModel) map.get("campaign_redirect");
        if (redirectModel != null) {
            CampaignEx campaignEx = redirectModel.getCampaignEx();
            f settingModel = redirectModel.getSettingModel();
            switch (AnonymousClass1.f10856a[redirectModel.getRedirectType().ordinal()]) {
                case 1:
                    String noticeUrl = campaignEx.getNoticeUrl();
                    Object obj2 = map.get("click_scenario");
                    int intValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : 1;
                    try {
                        if (!TextUtils.isEmpty(noticeUrl)) {
                            if (!noticeUrl.contains(a.f9194m)) {
                                noticeUrl = noticeUrl + "&" + a.f9194m + "=" + intValue;
                            } else {
                                noticeUrl = noticeUrl.replace(a.f9194m + "=" + Uri.parse(noticeUrl).getQueryParameter(a.f9194m), a.f9194m + "=" + intValue);
                            }
                        }
                    } catch (Throwable th) {
                        af.b("RedirectReceiver", th.getMessage());
                    }
                    String str2 = noticeUrl;
                    if (!TextUtils.isEmpty(str2)) {
                        com.mbridge.msdk.click.a.a(redirectModel.getContext(), campaignEx, redirectModel.getUnitId(), str2, true, false, 3);
                        return;
                    }
                    return;
                case 2:
                    new com.mbridge.msdk.click.a(redirectModel.getContext(), redirectModel.getUnitId()).a(com.mbridge.msdk.newreward.function.h.b.a(a(redirectModel).toString(), campaignEx));
                    return;
                case 3:
                    com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), a(campaignEx.getImpressionURL(), campaignEx, settingModel), false, true, com.mbridge.msdk.click.a.a.f8069g);
                    return;
                case 4:
                    com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), a(campaignEx.getOnlyImpressionURL(), campaignEx, settingModel), false, true, com.mbridge.msdk.click.a.a.f8070h);
                    return;
                case 5:
                    if (campaignEx != null && campaignEx.getPv_urls() != null && (pv_urls = campaignEx.getPv_urls()) != null && !pv_urls.isEmpty()) {
                        for (String a5 : pv_urls) {
                            com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), a5, false, true);
                        }
                        return;
                    }
                    return;
                case 6:
                    if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (l5 = campaignEx.getNativeVideoTracking().l()) != null && l5.length > 0) {
                        com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), l5, true, false);
                        return;
                    }
                    return;
                case 7:
                    if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (r5 = campaignEx.getNativeVideoTracking().r()) != null && r5.length > 0) {
                        try {
                            String[] strArr = new String[r5.length];
                            for (int i5 = 0; i5 < r5.length; i5++) {
                                String a6 = a(r5[i5], campaignEx, settingModel);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("endscreen_type", redirectModel.getEndScreenType());
                                String jSONObject2 = jSONObject.toString();
                                if (!TextUtils.isEmpty(jSONObject2)) {
                                    jSONObject2 = z.b(jSONObject2);
                                }
                                if (!TextUtils.isEmpty(jSONObject2)) {
                                    a6 = a6 + "&value=" + URLEncoder.encode(jSONObject2);
                                }
                                strArr[i5] = a6;
                            }
                            com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), strArr, false, true);
                            return;
                        } catch (Exception e5) {
                            af.b("RedirectReceiver", e5.getMessage());
                            return;
                        }
                    } else {
                        return;
                    }
                case 8:
                    if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (s5 = campaignEx.getNativeVideoTracking().s()) != null && s5.length > 0) {
                        com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), s5, false, false);
                        return;
                    }
                    return;
                case 9:
                    if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (j5 = campaignEx.getNativeVideoTracking().j()) != null && j5.length > 0) {
                        com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), j5, false, false);
                        return;
                    }
                    return;
                case 10:
                    if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (k5 = campaignEx.getNativeVideoTracking().k()) != null && k5.length > 0) {
                        com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), k5, false, false);
                        return;
                    }
                    return;
                case 11:
                    if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (p5 = campaignEx.getNativeVideoTracking().p()) != null && p5.length > 0) {
                        com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), p5, false, true);
                        return;
                    }
                    return;
                case 12:
                    if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && (o5 = campaignEx.getNativeVideoTracking().o()) != null && o5.length > 0) {
                        com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), o5, false, true);
                        return;
                    }
                    return;
                case 13:
                    try {
                        int percentRate = redirectModel.getPercentRate();
                        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null) {
                            ArrayList arrayList = new ArrayList();
                            List<Map<Integer, String>> i6 = campaignEx.getNativeVideoTracking().i();
                            if (!i6.isEmpty()) {
                                for (Map<Integer, String> entrySet : i6) {
                                    for (Map.Entry entry : entrySet.entrySet()) {
                                        if (((Integer) entry.getKey()).intValue() == percentRate) {
                                            arrayList.add(a((String) entry.getValue(), campaignEx, settingModel));
                                        }
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                String[] strArr2 = (String[]) arrayList.toArray(new String[0]);
                                if (strArr2.length > 0) {
                                    com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), strArr2, false, false);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e6) {
                        af.b("RedirectReceiver", e6.getMessage());
                        return;
                    }
                case 14:
                    if (campaignEx != null) {
                        try {
                            if (campaignEx.getNativeVideoTracking() != null && (m5 = campaignEx.getNativeVideoTracking().m()) != null && m5.length > 0) {
                                com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), m5, false, false);
                                return;
                            }
                            return;
                        } catch (Exception e7) {
                            Exception exc = e7;
                            if (MBridgeConstans.DEBUG) {
                                exc.printStackTrace();
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                case 15:
                    if (campaignEx != null) {
                        try {
                            if (campaignEx.getNativeVideoTracking() != null && (n5 = campaignEx.getNativeVideoTracking().n()) != null && n5.length > 0) {
                                com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, redirectModel.getUnitId(), n5, false, false);
                                return;
                            }
                            return;
                        } catch (Exception e8) {
                            Exception exc2 = e8;
                            if (MBridgeConstans.DEBUG) {
                                exc2.printStackTrace();
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                case 16:
                    if (campaignEx != null) {
                        try {
                            if (campaignEx.getAdUrlList() != null && !campaignEx.getAdUrlList().isEmpty()) {
                                for (String next : campaignEx.getAdUrlList()) {
                                    if (!TextUtils.isEmpty(next)) {
                                        com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, campaignEx.getCampaignUnitId(), next, false, false);
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 17:
                    if (campaignEx != null) {
                        try {
                            if (campaignEx.getAdvImpList() != null && !campaignEx.getAdvImpList().isEmpty()) {
                                Iterator<Map.Entry<Integer, String>> it = campaignEx.getAdvImpList().entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry next2 = it.next();
                                    String str3 = (String) next2.getValue();
                                    if (redirectModel.getCurrPercentAge() == ((Integer) next2.getKey()).intValue() && !TextUtils.isEmpty(str3)) {
                                        com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, campaignEx.getCampaignUnitId(), str3, false, false);
                                        it.remove();
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 18:
                    if (campaignEx != null) {
                        try {
                            com.mbridge.msdk.videocommon.b.c reward = redirectModel.getReward();
                            if (reward != null) {
                                com.mbridge.msdk.video.module.c.b bVar = new com.mbridge.msdk.video.module.c.b(c.m().c());
                                e eVar = new e();
                                com.mbridge.msdk.newreward.a.f devExtraData = redirectModel.getDevExtraData();
                                String str4 = "";
                                if (devExtraData == null) {
                                    eVar.a("user_id", z.b(str4));
                                } else {
                                    if (!TextUtils.isEmpty(devExtraData.b())) {
                                        eVar.a("extra", devExtraData.b());
                                    }
                                    eVar.a("user_id", z.b(devExtraData.a()));
                                }
                                eVar.a("cb_type", "1");
                                eVar.a(CampaignEx.JSON_KEY_REWARD_NAME, reward.a());
                                eVar.a(CampaignEx.JSON_KEY_REWARD_AMOUNT, reward.b() + str4);
                                eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, redirectModel.getUnitId());
                                eVar.a("click_id", campaignEx.getRequestIdNotice());
                                bVar.addExtraParams(str4, eVar);
                                String str5 = campaignEx.getHost() + "/addReward?";
                                String trim = eVar.b().trim();
                                if (!TextUtils.isEmpty(trim)) {
                                    if (!str5.endsWith(str) && !str5.endsWith("&")) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(str5);
                                        if (str5.contains(str)) {
                                            str = "&";
                                        }
                                        sb.append(str);
                                        str5 = sb.toString();
                                    }
                                    str4 = str5 + trim;
                                }
                                com.mbridge.msdk.click.a.a(c.m().c(), campaignEx, campaignEx.getCampaignUnitId(), str4, false, false);
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            af.b("RedirectReceiver", th2.getMessage());
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001d A[SYNTHETIC, Splitter:B:12:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c A[Catch:{ Exception -> 0x0012 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r4, com.mbridge.msdk.foundation.entity.CampaignEx r5, com.mbridge.msdk.newreward.function.e.f r6) {
        /*
            r3 = this;
            r0 = 1
            if (r6 == 0) goto L_0x0014
            com.mbridge.msdk.videocommon.d.c r1 = r6.b()     // Catch:{ Exception -> 0x0012 }
            if (r1 == 0) goto L_0x0014
            com.mbridge.msdk.videocommon.d.c r6 = r6.b()     // Catch:{ Exception -> 0x0012 }
            int r6 = r6.y()     // Catch:{ Exception -> 0x0012 }
            goto L_0x0015
        L_0x0012:
            r5 = move-exception
            goto L_0x005b
        L_0x0014:
            r6 = r0
        L_0x0015:
            int r1 = r5.getSpareOfferFlag()     // Catch:{ Exception -> 0x0012 }
            java.lang.String r2 = "&tmorl="
            if (r1 != r0) goto L_0x003c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0012 }
            r0.<init>()     // Catch:{ Exception -> 0x0012 }
            r0.append(r4)     // Catch:{ Exception -> 0x0012 }
            java.lang.String r1 = "&to=1&cbt="
            r0.append(r1)     // Catch:{ Exception -> 0x0012 }
            int r5 = r5.getCbt()     // Catch:{ Exception -> 0x0012 }
            r0.append(r5)     // Catch:{ Exception -> 0x0012 }
            r0.append(r2)     // Catch:{ Exception -> 0x0012 }
            r0.append(r6)     // Catch:{ Exception -> 0x0012 }
            java.lang.String r4 = r0.toString()     // Catch:{ Exception -> 0x0012 }
            return r4
        L_0x003c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0012 }
            r0.<init>()     // Catch:{ Exception -> 0x0012 }
            r0.append(r4)     // Catch:{ Exception -> 0x0012 }
            java.lang.String r1 = "&to=0&cbt="
            r0.append(r1)     // Catch:{ Exception -> 0x0012 }
            int r5 = r5.getCbt()     // Catch:{ Exception -> 0x0012 }
            r0.append(r5)     // Catch:{ Exception -> 0x0012 }
            r0.append(r2)     // Catch:{ Exception -> 0x0012 }
            r0.append(r6)     // Catch:{ Exception -> 0x0012 }
            java.lang.String r4 = r0.toString()     // Catch:{ Exception -> 0x0012 }
            return r4
        L_0x005b:
            java.lang.String r6 = "RedirectReceiver"
            java.lang.String r5 = r5.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r6, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.g.a(java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.newreward.function.e.f):java.lang.String");
    }

    private JSONObject a(RedirectModel redirectModel) {
        int i5;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(a.f9189h, redirectModel.getxInScreen());
            jSONObject2.put(a.f9190i, redirectModel.getyInScreen());
            jSONObject2.put(a.f9194m, redirectModel.getClickSenario());
            try {
                i5 = c.m().c().getResources().getConfiguration().orientation;
            } catch (Exception e5) {
                e5.printStackTrace();
                i5 = 1;
            }
            jSONObject2.put(a.f9192k, i5);
            jSONObject2.put(a.f9193l, (double) ak.d(c.m().c()));
            jSONObject.put(a.f9191j, jSONObject2);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        return jSONObject;
    }
}
