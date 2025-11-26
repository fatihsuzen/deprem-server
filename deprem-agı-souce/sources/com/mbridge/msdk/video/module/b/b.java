package com.mbridge.msdk.video.module.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.a;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, ArrayList<String>> f12630a = new HashMap<>();

    public static void a(String str) {
        f12630a.remove(str);
    }

    public static void b(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().j() != null) {
            a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().j(), false, false);
        }
    }

    public static void c(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().k() != null) {
            a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().k(), false, false);
        }
    }

    public static void d(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().l() != null) {
            String campaignUnitId = campaignEx.getCampaignUnitId();
            ArrayList arrayList = f12630a.get(campaignUnitId);
            if (arrayList == null) {
                arrayList = new ArrayList();
                f12630a.put(campaignUnitId, arrayList);
            }
            if (!arrayList.contains(campaignEx.getId())) {
                try {
                    d.a().a("2000142", campaignEx);
                } catch (Exception unused) {
                }
                CampaignEx campaignEx2 = campaignEx;
                a.a(context, campaignEx2, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
                arrayList.add(campaignEx2.getId());
            }
        }
    }

    public static void e(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().s() != null) {
            d.a().a("2000143", campaignEx);
            a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().s(), false, false);
        }
    }

    public static void f(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().m() != null) {
            a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().m(), false, false);
        }
    }

    public static void a(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().p() != null) {
            d.a().a("2000141", campaignEx);
            a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().p(), false, false);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00bb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, com.mbridge.msdk.foundation.entity.CampaignEx r9, int r10, int r11) {
        /*
            com.mbridge.msdk.foundation.entity.j r0 = r9.getNativeVideoTracking()     // Catch:{ all -> 0x00c7 }
            java.lang.String[] r0 = r0.r()     // Catch:{ all -> 0x00c7 }
            com.mbridge.msdk.foundation.entity.j r1 = r9.getNativeVideoTracking()     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x00ce
            if (r0 == 0) goto L_0x00ce
            int r1 = r0.length     // Catch:{ all -> 0x00c7 }
            java.lang.String[] r5 = new java.lang.String[r1]     // Catch:{ all -> 0x00c7 }
            r1 = 0
        L_0x0014:
            int r2 = r0.length     // Catch:{ all -> 0x00c7 }
            if (r1 >= r2) goto L_0x009b
            r2 = r0[r1]     // Catch:{ all -> 0x00c7 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x00c7 }
            r3.<init>()     // Catch:{ all -> 0x00c7 }
            java.lang.String r4 = "endscreen_type"
            r3.put(r4, r10)     // Catch:{ all -> 0x00c7 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c7 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00c7 }
            if (r4 != 0) goto L_0x0031
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.z.b(r3)     // Catch:{ all -> 0x00c7 }
        L_0x0031:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00c7 }
            if (r4 != 0) goto L_0x004f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
            r4.<init>()     // Catch:{ all -> 0x00c7 }
            r4.append(r2)     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = "&value="
            r4.append(r2)     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = java.net.URLEncoder.encode(r3)     // Catch:{ all -> 0x00c7 }
            r4.append(r2)     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00c7 }
        L_0x004f:
            int r3 = r9.getSpareOfferFlag()     // Catch:{ all -> 0x00c7 }
            java.lang.String r4 = "&tmorl="
            r6 = 1
            if (r3 != r6) goto L_0x0077
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
            r3.<init>()     // Catch:{ all -> 0x00c7 }
            r3.append(r2)     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = "&to=1&cbt="
            r3.append(r2)     // Catch:{ all -> 0x00c7 }
            int r2 = r9.getCbt()     // Catch:{ all -> 0x00c7 }
            r3.append(r2)     // Catch:{ all -> 0x00c7 }
            r3.append(r4)     // Catch:{ all -> 0x00c7 }
            r3.append(r11)     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00c7 }
            goto L_0x0095
        L_0x0077:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
            r3.<init>()     // Catch:{ all -> 0x00c7 }
            r3.append(r2)     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = "&to=0&cbt="
            r3.append(r2)     // Catch:{ all -> 0x00c7 }
            int r2 = r9.getCbt()     // Catch:{ all -> 0x00c7 }
            r3.append(r2)     // Catch:{ all -> 0x00c7 }
            r3.append(r4)     // Catch:{ all -> 0x00c7 }
            r3.append(r11)     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00c7 }
        L_0x0095:
            r5[r1] = r2     // Catch:{ all -> 0x00c7 }
            int r1 = r1 + 1
            goto L_0x0014
        L_0x009b:
            com.mbridge.msdk.foundation.same.report.d.e r11 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x00bb }
            r11.<init>()     // Catch:{ Exception -> 0x00bb }
            java.lang.String r0 = "type"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x00bb }
            r11.a(r0, r10)     // Catch:{ Exception -> 0x00bb }
            com.mbridge.msdk.foundation.same.report.d.d r10 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x00bb }
            java.lang.String r0 = "2000144"
            r10.a((java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r9, (com.mbridge.msdk.foundation.same.report.d.e) r11)     // Catch:{ Exception -> 0x00bb }
            com.mbridge.msdk.foundation.same.report.d.d r10 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x00bb }
            java.lang.String r0 = "2000147"
            r10.a((java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r9, (com.mbridge.msdk.foundation.same.report.d.e) r11)     // Catch:{ Exception -> 0x00bb }
        L_0x00bb:
            java.lang.String r4 = r9.getCampaignUnitId()     // Catch:{ all -> 0x00c7 }
            r6 = 0
            r7 = 1
            r2 = r8
            r3 = r9
            com.mbridge.msdk.click.a.a((android.content.Context) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r3, (java.lang.String) r4, (java.lang.String[]) r5, (boolean) r6, (boolean) r7)     // Catch:{ all -> 0x00c7 }
            goto L_0x00ce
        L_0x00c7:
            java.lang.String r8 = "VideoViewReport"
            java.lang.String r9 = "reportEndcardshowData error"
            com.mbridge.msdk.foundation.tools.af.b(r8, r9)
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.b.b.a(android.content.Context, com.mbridge.msdk.foundation.entity.CampaignEx, int, int):void");
    }

    public static void a(Context context, CampaignEx campaignEx, int i5, int i6, int i7) {
        String str;
        int i8 = i7;
        if (i6 != 0 && context != null && campaignEx != null) {
            try {
                List<Map<Integer, String>> i9 = campaignEx.getNativeVideoTracking().i();
                int i10 = ((i5 + 1) * 100) / i6;
                if (i9 != null) {
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < i9.size()) {
                        Map map = i9.get(i11);
                        if (map != null && map.size() > 0) {
                            Iterator it = map.entrySet().iterator();
                            int i13 = i11;
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                Integer num = (Integer) entry.getKey();
                                int intValue = num.intValue();
                                String str2 = (String) entry.getValue();
                                if (campaignEx.getSpareOfferFlag() == 1) {
                                    str = str2 + "&to=1&cbt=" + campaignEx.getCbt() + "&tmorl=" + i8;
                                } else {
                                    str = str2 + "&to=0&cbt=" + campaignEx.getCbt() + "&tmorl=" + i8;
                                }
                                if (intValue <= i10 && !TextUtils.isEmpty(str)) {
                                    String[] strArr = {str};
                                    if (i12 < 1) {
                                        i12++;
                                        try {
                                            e eVar = new e();
                                            eVar.a("percent", num);
                                            d.a().a("2000140", campaignEx, eVar);
                                        } catch (Exception unused) {
                                        }
                                    }
                                    int i14 = i12;
                                    String[] strArr2 = strArr;
                                    a.a(context, campaignEx, campaignEx.getCampaignUnitId(), strArr2, false, true);
                                    it.remove();
                                    i9.remove(i13);
                                    i13--;
                                    i12 = i14;
                                }
                            }
                            i11 = i13;
                        }
                        i11++;
                    }
                }
            } catch (Throwable unused2) {
                af.b("VideoViewReport", "reportPlayPercentageData error");
            }
        }
    }

    public static void a(CampaignEx campaignEx, Map<Integer, String> map, String str, int i5) {
        String str2;
        CampaignEx campaignEx2;
        if (campaignEx != null && map != null) {
            try {
                if (map.size() > 0) {
                    Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        String str3 = (String) next.getValue();
                        if (i5 != ((Integer) next.getKey()).intValue() || TextUtils.isEmpty(str3)) {
                            campaignEx2 = campaignEx;
                            str2 = str;
                        } else {
                            campaignEx2 = campaignEx;
                            str2 = str;
                            a.a(c.m().c(), campaignEx2, str2, str3, false, false);
                            it.remove();
                        }
                        campaignEx = campaignEx2;
                        str = str2;
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, String str) {
        String str2;
        CampaignEx campaignEx2;
        if (campaignEx != null) {
            try {
                if (campaignEx.getAdUrlList() != null && campaignEx.getAdUrlList().size() > 0) {
                    for (String next : campaignEx.getAdUrlList()) {
                        if (!TextUtils.isEmpty(next)) {
                            campaignEx2 = campaignEx;
                            str2 = str;
                            a.a(c.m().c(), campaignEx2, str2, next, false, false);
                        } else {
                            campaignEx2 = campaignEx;
                            str2 = str;
                        }
                        campaignEx = campaignEx2;
                        str = str2;
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, String str, String str2, String str3) {
        String str4 = "&";
        String str5 = "";
        if (campaignEx != null && cVar != null) {
            try {
                com.mbridge.msdk.video.module.c.b bVar = new com.mbridge.msdk.video.module.c.b(c.m().c());
                com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e();
                eVar.a("user_id", z.b(str2));
                eVar.a("cb_type", "1");
                eVar.a(CampaignEx.JSON_KEY_REWARD_NAME, cVar.a());
                eVar.a(CampaignEx.JSON_KEY_REWARD_AMOUNT, cVar.b() + str5);
                eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                eVar.a("click_id", campaignEx.getRequestIdNotice());
                if (!TextUtils.isEmpty(str3)) {
                    eVar.a("extra", str3);
                }
                bVar.addExtraParams(str5, eVar);
                String str6 = campaignEx.getHost() + "/addReward?";
                String trim = eVar.b().trim();
                if (!TextUtils.isEmpty(trim)) {
                    if (!str6.endsWith("?") && !str6.endsWith(str4)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str6);
                        if (!str6.contains("?")) {
                            str4 = "?";
                        }
                        sb.append(str4);
                        str6 = sb.toString();
                    }
                    str5 = str6 + trim;
                }
                String str7 = str5;
                af.b("VideoViewReport", "rewardUrl:" + str7);
                a.a(c.m().c(), campaignEx, campaignEx.getCampaignUnitId(), str7, false, false);
            } catch (Throwable th) {
                Throwable th2 = th;
                af.b("VideoViewReport", th2.getMessage(), th2);
            }
        }
    }
}
