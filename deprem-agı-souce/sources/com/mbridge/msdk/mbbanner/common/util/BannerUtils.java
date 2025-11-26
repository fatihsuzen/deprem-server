package com.mbridge.msdk.mbbanner.common.util;

import android.content.Context;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.same.d.a;
import com.mbridge.msdk.foundation.tools.ap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class BannerUtils {
    private static final String TAG = "BannerUtils";

    private static synchronized List<a> fillIdInList(List<a> list, List<CampaignEx> list2) {
        synchronized (BannerUtils.class) {
            if (list2 != null) {
                try {
                    if (list2.size() > 0) {
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        for (CampaignEx next : list2) {
                            if (next != null) {
                                a aVar = new a(next.getId(), next.getCreativeId());
                                if (list.size() >= 20) {
                                    list.remove(0);
                                }
                                list.add(aVar);
                            }
                        }
                    }
                } finally {
                }
            }
        }
        return list;
    }

    public static String getCloseIds(String str) {
        List list;
        try {
            Map<String, List<a>> map = b.f9211a;
            if (map == null || !ap.b(str) || !map.containsKey(str) || (list = map.get(str)) == null || list.size() <= 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (int i5 = 0; i5 < list.size(); i5++) {
                JSONObject jSONObject = new JSONObject();
                a aVar = (a) list.get(i5);
                jSONObject.put("cid", aVar.a());
                jSONObject.put("crid", aVar.b());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Exception e5) {
            e5.printStackTrace();
            return "";
        }
    }

    public static void inserCloseId(String str, List<CampaignEx> list) {
        Map<String, List<a>> map = b.f9211a;
        if (map != null && list != null && list.size() > 0) {
            if (ap.b(str)) {
                if (map.containsKey(str)) {
                    map.put(str, fillIdInList(map.get(str), list));
                } else {
                    map.put(str, fillIdInList(new ArrayList(), list));
                }
            }
            b.f9211a = map;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:45|43|42) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x011a */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0120 A[Catch:{ JSONException -> 0x012e }, LOOP:1: B:42:0x011a->B:45:0x0120, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.foundation.entity.CampaignEx managerCampaignEX(java.lang.String r7, com.mbridge.msdk.foundation.entity.CampaignEx r8) {
        /*
            java.lang.String r0 = "deep_link"
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 == 0) goto L_0x0009
            return r8
        L_0x0009:
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 == 0) goto L_0x0014
            if (r8 == 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r7 = 0
            return r7
        L_0x0014:
            java.lang.String r1 = "notice"
            boolean r1 = r7.contains(r1)
            java.lang.String r2 = "unitId"
            if (r1 != 0) goto L_0x0102
            org.json.JSONObject r0 = com.mbridge.msdk.foundation.entity.CampaignEx.campaignToJsonObject(r8)     // Catch:{ JSONException -> 0x0146 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r0)     // Catch:{ JSONException -> 0x0146 }
            if (r1 != 0) goto L_0x0029
            r1 = r8
        L_0x0029:
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0146 }
            if (r3 != 0) goto L_0x0101
            java.lang.String r0 = r0.optString(r2)     // Catch:{ JSONException -> 0x0146 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0146 }
            if (r2 != 0) goto L_0x003c
            r1.setCampaignUnitId(r0)     // Catch:{ JSONException -> 0x0146 }
        L_0x003c:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0146 }
            r0.<init>(r7)     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r7 = com.mbridge.msdk.foundation.same.a.f9191j     // Catch:{ JSONException -> 0x0146 }
            org.json.JSONObject r7 = r0.optJSONObject(r7)     // Catch:{ JSONException -> 0x0146 }
            if (r7 == 0) goto L_0x0088
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ JSONException -> 0x0146 }
            android.content.Context r0 = r0.c()     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.f9189h     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ JSONException -> 0x0146 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ JSONException -> 0x0146 }
            int r2 = r2.intValue()     // Catch:{ JSONException -> 0x0146 }
            float r2 = (float) r2     // Catch:{ JSONException -> 0x0146 }
            int r0 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r0, (float) r2)     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ JSONException -> 0x0146 }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ JSONException -> 0x0146 }
            android.content.Context r2 = r2.c()     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.f9190i     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r3 = r7.getString(r3)     // Catch:{ JSONException -> 0x0146 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ JSONException -> 0x0146 }
            int r3 = r3.intValue()     // Catch:{ JSONException -> 0x0146 }
            float r3 = (float) r3     // Catch:{ JSONException -> 0x0146 }
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r2, (float) r3)     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ JSONException -> 0x0146 }
            goto L_0x008b
        L_0x0088:
            java.lang.String r0 = "-999"
            r2 = r0
        L_0x008b:
            java.lang.String r3 = r1.getClickURL()     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r0 = com.mbridge.msdk.click.c.a((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x0146 }
            r1.setClickURL(r0)     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r0 = r1.getNoticeUrl()     // Catch:{ JSONException -> 0x0146 }
            if (r7 == 0) goto L_0x0101
            java.util.Iterator r2 = r7.keys()     // Catch:{ JSONException -> 0x0146 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0146 }
            r3.<init>()     // Catch:{ JSONException -> 0x0146 }
        L_0x00a5:
            boolean r4 = r2.hasNext()     // Catch:{ JSONException -> 0x0146 }
            if (r4 == 0) goto L_0x00ef
            java.lang.String r4 = "&"
            r3.append(r4)     // Catch:{ JSONException -> 0x0146 }
            java.lang.Object r4 = r2.next()     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r5 = r7.optString(r4)     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f9189h     // Catch:{ JSONException -> 0x0146 }
            boolean r6 = r6.equals(r4)     // Catch:{ JSONException -> 0x0146 }
            if (r6 != 0) goto L_0x00ca
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f9190i     // Catch:{ JSONException -> 0x0146 }
            boolean r6 = r6.equals(r4)     // Catch:{ JSONException -> 0x0146 }
            if (r6 == 0) goto L_0x00e3
        L_0x00ca:
            com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ JSONException -> 0x0146 }
            android.content.Context r6 = r6.c()     // Catch:{ JSONException -> 0x0146 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ JSONException -> 0x0146 }
            int r5 = r5.intValue()     // Catch:{ JSONException -> 0x0146 }
            float r5 = (float) r5     // Catch:{ JSONException -> 0x0146 }
            int r5 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r6, (float) r5)     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ JSONException -> 0x0146 }
        L_0x00e3:
            r3.append(r4)     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r4 = "="
            r3.append(r4)     // Catch:{ JSONException -> 0x0146 }
            r3.append(r5)     // Catch:{ JSONException -> 0x0146 }
            goto L_0x00a5
        L_0x00ef:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0146 }
            r7.<init>()     // Catch:{ JSONException -> 0x0146 }
            r7.append(r0)     // Catch:{ JSONException -> 0x0146 }
            r7.append(r3)     // Catch:{ JSONException -> 0x0146 }
            java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x0146 }
            r1.setNoticeUrl(r7)     // Catch:{ JSONException -> 0x0146 }
        L_0x0101:
            return r1
        L_0x0102:
            org.json.JSONObject r1 = com.mbridge.msdk.foundation.entity.CampaignEx.campaignToJsonObject(r8)     // Catch:{ JSONException -> 0x012e }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x012e }
            r3.<init>(r7)     // Catch:{ JSONException -> 0x012e }
            java.util.Iterator r7 = r3.keys()     // Catch:{ JSONException -> 0x012e }
            boolean r4 = r3.has(r0)     // Catch:{ Exception -> 0x011a }
            if (r4 != 0) goto L_0x011a
            java.lang.String r4 = ""
            r1.put(r0, r4)     // Catch:{ Exception -> 0x011a }
        L_0x011a:
            boolean r0 = r7.hasNext()     // Catch:{ JSONException -> 0x012e }
            if (r0 == 0) goto L_0x0130
            java.lang.Object r0 = r7.next()     // Catch:{ JSONException -> 0x012e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x012e }
            java.lang.String r4 = r3.getString(r0)     // Catch:{ JSONException -> 0x012e }
            r1.put(r0, r4)     // Catch:{ JSONException -> 0x012e }
            goto L_0x011a
        L_0x012e:
            r7 = move-exception
            goto L_0x0143
        L_0x0130:
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r1)     // Catch:{ JSONException -> 0x012e }
            java.lang.String r0 = r1.optString(r2)     // Catch:{ JSONException -> 0x012e }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x012e }
            if (r1 != 0) goto L_0x0141
            r7.setCampaignUnitId(r0)     // Catch:{ JSONException -> 0x012e }
        L_0x0141:
            r8 = r7
            goto L_0x0146
        L_0x0143:
            r7.printStackTrace()
        L_0x0146:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbbanner.common.util.BannerUtils.managerCampaignEX(java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx):com.mbridge.msdk.foundation.entity.CampaignEx");
    }

    public static void uisList(Context context, List<CampaignEx> list) {
        if (context != null && list != null && list.size() != 0) {
            j a5 = j.a((f) g.a(context));
            for (int i5 = 0; i5 < list.size(); i5++) {
                CampaignEx campaignEx = list.get(i5);
                if (a5 != null && !a5.b(campaignEx.getId())) {
                    com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                    gVar.a(campaignEx.getId());
                    gVar.b(campaignEx.getFca());
                    gVar.c(campaignEx.getFcb());
                    gVar.a(0);
                    gVar.d(0);
                    gVar.a(System.currentTimeMillis());
                    a5.a(gVar);
                }
            }
        }
    }
}
