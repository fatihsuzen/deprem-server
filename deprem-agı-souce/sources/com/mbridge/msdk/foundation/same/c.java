package com.mbridge.msdk.foundation.same;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class c {

    public static abstract class a {
        public abstract void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar);
    }

    public static long a(long j5, long j6) {
        return j5 >= 0 ? j5 : j6;
    }

    public static int b(Context context, CampaignEx campaignEx) {
        if (context == null || campaignEx == null) {
            return 2;
        }
        boolean c5 = ak.c(context, campaignEx.getPackageName());
        boolean c6 = ak.c(campaignEx);
        if (campaignEx.getWtick() == 1) {
            return 3;
        }
        if (c6 && c5) {
            return 3;
        }
        if (c6 || c5) {
            return campaignEx.getFilterCallBackState();
        }
        return 3;
    }

    public static String a(List<CampaignEx> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (CampaignEx next : list) {
            if (!(next == null || next.getCreativeId() == 0)) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i5 = 0;
        while (i5 < arrayList.size()) {
            try {
                CampaignEx campaignEx = (CampaignEx) arrayList.get(i5);
                if (campaignEx != null) {
                    long creativeId = campaignEx.getCreativeId();
                    if (i5 == arrayList.size() - 1) {
                        sb.append(creativeId);
                    } else {
                        sb.append(creativeId);
                        sb.append(",");
                    }
                }
                i5++;
            } catch (Exception e5) {
                af.b("SameCommon", "getCreativeID", e5);
            }
        }
        return sb.toString();
    }

    public static boolean a(Context context, CampaignEx campaignEx) {
        if (context == null || campaignEx == null) {
            return false;
        }
        boolean c5 = ak.c(context, campaignEx.getPackageName());
        if (!ak.c(campaignEx) && campaignEx.getWtick() != 1 && c5) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093 A[Catch:{ Exception -> 0x00a3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.mbridge.msdk.foundation.entity.CampaignEx r9, android.content.Context r10, com.mbridge.msdk.foundation.same.report.d.c r11, com.mbridge.msdk.foundation.same.c.a r12) {
        /*
            java.lang.String r0 = "m_campaign_ind_unretarget"
            java.lang.String r1 = "m_campaign_ind_retarget"
            if (r9 == 0) goto L_0x00ab
            if (r12 == 0) goto L_0x00ab
            if (r11 != 0) goto L_0x000f
            com.mbridge.msdk.foundation.same.report.d.c r11 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x00a3 }
            r11.<init>()     // Catch:{ Exception -> 0x00a3 }
        L_0x000f:
            boolean r2 = com.mbridge.msdk.foundation.tools.ak.c((com.mbridge.msdk.foundation.entity.CampaignEx) r9)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r3 = r9.getPackageName()     // Catch:{ Exception -> 0x00a3 }
            int r3 = com.mbridge.msdk.foundation.tools.ak.d(r10, r3)     // Catch:{ Exception -> 0x00a3 }
            r4 = 0
            r5 = 1
            if (r10 == 0) goto L_0x0033
            boolean r10 = com.mbridge.msdk.foundation.tools.f.c(r10)     // Catch:{ Exception -> 0x0029 }
            if (r10 == 0) goto L_0x0027
            r10 = r5
            goto L_0x0034
        L_0x0027:
            r10 = 2
            goto L_0x0034
        L_0x0029:
            r10 = move-exception
            java.lang.String r6 = "SameCommon"
            java.lang.String r10 = r10.getMessage()     // Catch:{ Exception -> 0x00a3 }
            com.mbridge.msdk.foundation.tools.af.b(r6, r10)     // Catch:{ Exception -> 0x00a3 }
        L_0x0033:
            r10 = r4
        L_0x0034:
            com.mbridge.msdk.foundation.same.report.d.e r6 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x00a3 }
            r6.<init>()     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r7 = "cid"
            java.lang.String r8 = r9.getId()     // Catch:{ Exception -> 0x00a3 }
            r6.a(r7, r8)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r7 = "wtick"
            int r8 = r9.getWtick()     // Catch:{ Exception -> 0x00a3 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x00a3 }
            r6.a(r7, r8)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r7 = "retarget_offer"
            int r9 = r9.getRetarget_offer()     // Catch:{ Exception -> 0x00a3 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x00a3 }
            r6.a(r7, r9)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r9 = "ind"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x00a3 }
            r6.a(r9, r7)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r9 = "stage"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00a3 }
            r6.a(r9, r7)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r9 = "ac"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x00a3 }
            r6.a(r9, r4)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r9 = "per"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x00a3 }
            r6.a(r9, r10)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r9 = "m_campaign_filtered"
            if (r2 == 0) goto L_0x0093
            if (r3 == r5) goto L_0x008c
            r11.a(r9, r6)     // Catch:{ Exception -> 0x00a3 }
            r12.a(r9, r11)     // Catch:{ Exception -> 0x00a3 }
        L_0x008c:
            r11.a(r1, r6)     // Catch:{ Exception -> 0x00a3 }
            r12.a(r1, r11)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00ab
        L_0x0093:
            if (r3 == r5) goto L_0x0096
            goto L_0x009c
        L_0x0096:
            r11.a(r9, r6)     // Catch:{ Exception -> 0x00a3 }
            r12.a(r9, r11)     // Catch:{ Exception -> 0x00a3 }
        L_0x009c:
            r11.a(r0, r6)     // Catch:{ Exception -> 0x00a3 }
            r12.a(r0, r11)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00ab
        L_0x00a3:
            r9 = move-exception
            boolean r10 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r10 == 0) goto L_0x00ab
            r9.printStackTrace()
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.c.a(com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context, com.mbridge.msdk.foundation.same.report.d.c, com.mbridge.msdk.foundation.same.c$a):void");
    }

    public static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                String str2 = "";
                if (split2.length == 2) {
                    String str3 = split2[0];
                    if (!TextUtils.isEmpty(str3)) {
                        String str4 = split2[1];
                        if (str4 != null) {
                            str2 = str4;
                        }
                        jSONObject.put(str3, str2);
                    }
                } else if (split2.length == 1) {
                    String str5 = split2[0];
                    if (!TextUtils.isEmpty(str5)) {
                        jSONObject.put(str5, str2);
                    }
                }
            }
            return jSONObject;
        } catch (Exception e5) {
            af.a("SameCommon", "coverReportMessage", e5);
            return null;
        } catch (Throwable th) {
            af.a("SameCommon", "coverReportMessage", th);
            return null;
        }
    }
}
