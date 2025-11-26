package com.mbridge.msdk.newreward.function.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.command.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f10503a = 4;

    /* renamed from: b  reason: collision with root package name */
    public static int f10504b = 5;

    /* renamed from: c  reason: collision with root package name */
    private static String f10505c = "BaseCandidateCache";

    /* renamed from: d  reason: collision with root package name */
    private JSONArray f10506d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f10507e;

    /* renamed from: f  reason: collision with root package name */
    private String f10508f;

    /* renamed from: g  reason: collision with root package name */
    private int f10509g;

    /* renamed from: h  reason: collision with root package name */
    private String f10510h;

    /* renamed from: i  reason: collision with root package name */
    private e f10511i;

    /* renamed from: j  reason: collision with root package name */
    private c f10512j;

    /* renamed from: com.mbridge.msdk.newreward.function.a.a$a  reason: collision with other inner class name */
    public static class C0099a {

        /* renamed from: a  reason: collision with root package name */
        private b f10513a;

        /* renamed from: b  reason: collision with root package name */
        private double f10514b;

        public C0099a(double d5, b bVar) {
            this.f10514b = d5;
            this.f10513a = bVar;
        }

        public final b a() {
            return this.f10513a;
        }
    }

    public final JSONObject a(String str) {
        JSONArray jSONArray = this.f10506d;
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() <= 1) {
            return this.f10506d.optJSONObject(0);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i5 = 0; i5 < this.f10506d.length(); i5++) {
            try {
                JSONObject optJSONObject = this.f10506d.optJSONObject(i5);
                if (optJSONObject != null && str.equals(optJSONObject.getString("g"))) {
                    this.f10507e = optJSONObject;
                    return optJSONObject;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }

    public final String b(String str) {
        b c5 = c(str);
        if (!(c5 == null || c5.h() == com.mbridge.msdk.foundation.b.c.f8792c || c5.h() == com.mbridge.msdk.foundation.b.c.f8790a)) {
            String[] split = z.a(str.split("_")[3]).split("\\|");
            if (split.length > 1) {
                return split[1];
            }
        }
        return "";
    }

    public final b c(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str) || str.split("_").length <= 3 || TextUtils.isEmpty(str.split("_")[3])) {
            bVar.d("bid token exception");
            bVar.a(com.mbridge.msdk.foundation.b.c.f8790a);
            return bVar;
        }
        JSONArray jSONArray = this.f10506d;
        if (jSONArray == null || jSONArray.length() == 0) {
            bVar.d("config is empty");
            bVar.a(com.mbridge.msdk.foundation.b.c.f8790a);
            return bVar;
        }
        String a5 = z.a(str.split("_")[3]);
        if (TextUtils.isEmpty(a5)) {
            bVar.d("bid token exception:decode error");
            bVar.a(com.mbridge.msdk.foundation.b.c.f8790a);
            return bVar;
        }
        String[] split = a5.split("\\|");
        if (split.length == 0) {
            bVar.d("bid token can not get bid price");
            bVar.a(com.mbridge.msdk.foundation.b.c.f8790a);
            return bVar;
        }
        if (split.length > 0) {
            try {
                Double.parseDouble(split[0]);
            } catch (Exception unused) {
                bVar.d("bid token can not cast bid price");
                bVar.a(com.mbridge.msdk.foundation.b.c.f8790a);
                return bVar;
            }
        }
        if (TextUtils.isEmpty(this.f10508f)) {
            bVar.d("unitId is empty");
            bVar.a(com.mbridge.msdk.foundation.b.c.f8792c);
        }
        return bVar;
    }

    public final double d(String str) {
        b c5 = c(str);
        if (!(c5 == null || c5.h() == com.mbridge.msdk.foundation.b.c.f8792c || c5.h() == com.mbridge.msdk.foundation.b.c.f8790a)) {
            try {
                String[] split = z.a(str.split("_")[3]).split("\\|");
                if (split.length > 0) {
                    return Double.parseDouble(split[0]);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return -1.0d;
    }

    public final void e(String str) {
        this.f10508f = str;
    }

    public final void f(String str) {
        this.f10510h = str;
    }

    private List<String> b(List<String> list, int i5, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            arrayList.add(a(list.get(i6), i5, str, str2));
        }
        return arrayList;
    }

    public final void a(JSONArray jSONArray) {
        this.f10506d = jSONArray;
    }

    public final void a(List<com.mbridge.msdk.newreward.function.c.a.a> list, com.mbridge.msdk.foundation.same.report.d.c cVar, String str, int i5, String str2, int i6, double d5) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i7 = 0; i7 < list.size(); i7++) {
                        CampaignEx h5 = list.get(i7).h();
                        h5.setReadyState(0);
                        if (cVar != null) {
                            h5.setNLRid(cVar.f());
                        }
                        h5.setNRid(str);
                        h5.setReasond(str2);
                        h5.setTyped(i5);
                        String b5 = z.b(d5 + "");
                        h5.setNoticeUrl(a(h5.getNoticeUrl(), i6, str, b5));
                        h5.setClickURL(a(h5.getClickURL(), i6, str, b5));
                        h5.setImpressionURL(a(h5.getImpressionURL(), i6, str, b5));
                        h5.setOnlyImpressionURL(a(h5.getOnlyImpressionURL(), i6, str, b5));
                        h5.setAdvImp(a(h5.getAdvImpList(), i6, str, b5));
                        j nativeVideoTracking = h5.getNativeVideoTracking();
                        if (nativeVideoTracking != null) {
                            nativeVideoTracking.k(a(nativeVideoTracking.l(), i6, str, b5));
                            nativeVideoTracking.c(a(nativeVideoTracking.c(), i6, str, b5));
                            nativeVideoTracking.o(a(nativeVideoTracking.p(), i6, str, b5));
                            nativeVideoTracking.s(a(nativeVideoTracking.t(), i6, str, b5));
                            nativeVideoTracking.a(a(nativeVideoTracking.a(), i6, str, b5));
                            nativeVideoTracking.b(a(nativeVideoTracking.b(), i6, str, b5));
                            nativeVideoTracking.r(a(nativeVideoTracking.s(), i6, str, b5));
                            nativeVideoTracking.u(a(nativeVideoTracking.v(), i6, str, b5));
                            nativeVideoTracking.t(a(nativeVideoTracking.v(), i6, str, b5));
                            nativeVideoTracking.v(a(nativeVideoTracking.w(), i6, str, b5));
                            nativeVideoTracking.h(a(nativeVideoTracking.h(), i6, str, b5));
                            nativeVideoTracking.p(a(nativeVideoTracking.q(), i6, str, b5));
                            nativeVideoTracking.q(a(nativeVideoTracking.r(), i6, str, b5));
                            nativeVideoTracking.n(a(nativeVideoTracking.o(), i6, str, b5));
                            nativeVideoTracking.e(a(nativeVideoTracking.e(), i6, str, b5));
                            nativeVideoTracking.f(a(nativeVideoTracking.f(), i6, str, b5));
                            nativeVideoTracking.g(a(nativeVideoTracking.g(), i6, str, b5));
                            nativeVideoTracking.i(a(nativeVideoTracking.j(), i6, str, b5));
                            nativeVideoTracking.j(a(nativeVideoTracking.k(), i6, str, b5));
                            nativeVideoTracking.l(a(nativeVideoTracking.m(), i6, str, b5));
                            nativeVideoTracking.a(a(nativeVideoTracking.i(), i6, str, b5));
                            nativeVideoTracking.d(a(nativeVideoTracking.d(), i6, str, b5));
                            nativeVideoTracking.m(a(nativeVideoTracking.n(), i6, str, b5));
                            h5.setNativeVideoTracking(nativeVideoTracking);
                            h5.setNativeVideoTrackingString(CampaignEx.object2TrackingStr(nativeVideoTracking));
                        }
                        h5.setPv_urls(b(h5.getPv_urls(), i6, str, b5));
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final b a() {
        b bVar = new b();
        try {
            JSONArray jSONArray = this.f10506d;
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    return bVar;
                }
            }
            bVar.d("setting config is null");
            bVar.a(com.mbridge.msdk.foundation.b.c.f8790a);
            return bVar;
        } catch (Exception unused) {
            bVar.d("checkConfigAndDB exception");
            bVar.a(com.mbridge.msdk.foundation.b.c.f8792c);
            return bVar;
        }
    }

    public final List<b> a(int i5, int i6, String str) {
        return com.mbridge.msdk.newreward.function.d.c.a().b().a(i6, str, this.f10508f, true, 0, "");
    }

    private String a(String str, int i5, String str2, String str3) {
        if (TextUtils.isEmpty(str) || str.contains("ca_sce") || str.contains("real_rid") || str.contains("real_bp")) {
            return str;
        }
        if (aq.c(str) > 0) {
            return str + "&ca_sce=" + i5 + "&real_rid=" + str2 + "&real_bp=" + str3;
        }
        return str + "?ca_sce=" + i5 + "&real_rid=" + str2 + "&real_bp=" + str3;
    }

    private String a(Map<Integer, String> map, int i5, String str, String str2) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry next : map.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_AD_IMP_KEY, next.getKey());
                jSONObject.put("url", a((String) next.getValue(), i5, str, str2));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray.toString();
    }

    private String[] a(String[] strArr, int i5, String str, String str2) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i6 = 0; i6 < strArr.length; i6++) {
            strArr2[i6] = a(strArr[i6], i5, str, str2);
        }
        return strArr2;
    }

    private List<Map<Integer, String>> a(List<Map<Integer, String>> list, int i5, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            Map map = list.get(i6);
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    map.put(entry.getKey(), a((String) entry.getValue(), i5, str, str2));
                }
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    public final void a(int i5) {
        this.f10509g = i5;
    }

    public final void a(e eVar) {
        this.f10511i = eVar;
    }

    public final void a(c cVar) {
        this.f10512j = cVar;
    }

    public final void a(String str, String str2, int i5, double d5) {
        if (d5 != 0.0d) {
            if (i5 == 1) {
                String str3 = str2;
                a(f10503a, 3, (List<CampaignEx>) null, true, str3, str, -1, this.f10508f);
            } else if (i5 == 2) {
                String str4 = str2;
                a(f10503a, 1, (List<CampaignEx>) null, true, str4, str, -1, this.f10508f);
            } else if (i5 == 3) {
                try {
                    String str5 = str2;
                    a(f10503a, 4, (List<CampaignEx>) null, true, str5, str, -1, this.f10508f);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x012e A[SYNTHETIC, Splitter:B:44:0x012e] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x018b A[Catch:{ Exception -> 0x0028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0197 A[Catch:{ Exception -> 0x0028 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r17, int r18, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r19, boolean r20, java.lang.String r21, java.lang.String r22, int r23, java.lang.String r24) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            r2 = r19
            java.lang.String r3 = ""
            com.mbridge.msdk.foundation.same.report.d.e r4 = new com.mbridge.msdk.foundation.same.report.d.e
            r4.<init>()
            java.lang.String r5 = "type"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0028 }
            r6.<init>()     // Catch:{ Exception -> 0x0028 }
            r6.append(r0)     // Catch:{ Exception -> 0x0028 }
            r6.append(r3)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0028 }
            r4.a(r5, r6)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r5 = "result"
            if (r20 == 0) goto L_0x002b
            java.lang.String r6 = "1"
            goto L_0x002d
        L_0x0028:
            r0 = move-exception
            goto L_0x01b4
        L_0x002b:
            java.lang.String r6 = "2"
        L_0x002d:
            r4.a(r5, r6)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r5 = "max_usage_limit"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0028 }
            r6.<init>()     // Catch:{ Exception -> 0x0028 }
            r7 = r23
            r6.append(r7)     // Catch:{ Exception -> 0x0028 }
            r6.append(r3)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0028 }
            r4.a(r5, r6)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r5 = "unit_id"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0028 }
            r6.<init>()     // Catch:{ Exception -> 0x0028 }
            r10 = r24
            r6.append(r10)     // Catch:{ Exception -> 0x0028 }
            r6.append(r3)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0028 }
            r4.a(r5, r6)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r5 = "scene"
            java.lang.String r6 = "db"
            r4.a(r5, r6)     // Catch:{ Exception -> 0x0028 }
            org.json.JSONObject r5 = r1.f10507e     // Catch:{ Exception -> 0x0028 }
            if (r5 == 0) goto L_0x0070
            java.lang.String r6 = "config"
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0028 }
            r4.a(r6, r5)     // Catch:{ Exception -> 0x0028 }
        L_0x0070:
            java.lang.String r5 = "lrid"
            java.lang.String r6 = "rid"
            r15 = 1
            if (r0 != r15) goto L_0x0123
            boolean r0 = android.text.TextUtils.isEmpty(r22)     // Catch:{ Exception -> 0x0028 }
            if (r0 == 0) goto L_0x0123
            com.mbridge.msdk.newreward.function.d.c r0 = com.mbridge.msdk.newreward.function.d.c.a()     // Catch:{ JSONException -> 0x0108 }
            com.mbridge.msdk.newreward.function.d.a r7 = r0.b()     // Catch:{ JSONException -> 0x0108 }
            int r8 = r1.f10509g     // Catch:{ JSONException -> 0x0108 }
            java.lang.String r9 = r1.f10510h     // Catch:{ JSONException -> 0x0108 }
            java.lang.String r13 = ""
            r11 = 1
            r12 = 0
            java.util.List r0 = r7.a((int) r8, (java.lang.String) r9, (java.lang.String) r10, (boolean) r11, (int) r12, (java.lang.String) r13)     // Catch:{ JSONException -> 0x0108 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0108 }
            r7.<init>()     // Catch:{ JSONException -> 0x0108 }
            if (r0 == 0) goto L_0x0113
            int r8 = r0.size()     // Catch:{ JSONException -> 0x0108 }
            if (r8 <= 0) goto L_0x0113
            r8 = 0
        L_0x009f:
            int r9 = r0.size()     // Catch:{ JSONException -> 0x0108 }
            if (r8 >= r9) goto L_0x0113
            java.lang.Object r9 = r0.get(r8)     // Catch:{ JSONException -> 0x0108 }
            com.mbridge.msdk.newreward.function.c.a.b r9 = (com.mbridge.msdk.newreward.function.c.a.b) r9     // Catch:{ JSONException -> 0x0108 }
            if (r9 == 0) goto L_0x010c
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0108 }
            r10.<init>()     // Catch:{ JSONException -> 0x0108 }
            java.lang.String r11 = r9.f()     // Catch:{ JSONException -> 0x0108 }
            r10.put(r6, r11)     // Catch:{ JSONException -> 0x0108 }
            java.lang.String r11 = "ts"
            long r12 = r9.I()     // Catch:{ JSONException -> 0x0108 }
            r10.put(r11, r12)     // Catch:{ JSONException -> 0x0108 }
            java.lang.String r11 = r9.g()     // Catch:{ JSONException -> 0x0108 }
            r10.put(r5, r11)     // Catch:{ JSONException -> 0x0108 }
            java.lang.String r11 = "ecppv"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0108 }
            r12.<init>()     // Catch:{ JSONException -> 0x0108 }
            r20 = r15
            double r14 = r9.s()     // Catch:{ JSONException -> 0x0106 }
            r12.append(r14)     // Catch:{ JSONException -> 0x0106 }
            r12.append(r3)     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r12 = r12.toString()     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r12 = com.mbridge.msdk.foundation.tools.z.b(r12)     // Catch:{ JSONException -> 0x0106 }
            r10.put(r11, r12)     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r11 = "state"
            int r12 = r9.j()     // Catch:{ JSONException -> 0x0106 }
            r10.put(r11, r12)     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r11 = "showCount"
            int r12 = r9.t()     // Catch:{ JSONException -> 0x0106 }
            r10.put(r11, r12)     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r11 = "interval_ts"
            long r12 = r9.q()     // Catch:{ JSONException -> 0x0106 }
            r10.put(r11, r12)     // Catch:{ JSONException -> 0x0106 }
            r7.put(r10)     // Catch:{ JSONException -> 0x0106 }
            goto L_0x010e
        L_0x0106:
            r0 = move-exception
            goto L_0x011f
        L_0x0108:
            r0 = move-exception
            r20 = r15
            goto L_0x011f
        L_0x010c:
            r20 = r15
        L_0x010e:
            int r8 = r8 + 1
            r15 = r20
            goto L_0x009f
        L_0x0113:
            r20 = r15
            java.lang.String r0 = "cache"
            java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x0106 }
            r4.a(r0, r7)     // Catch:{ JSONException -> 0x0106 }
            goto L_0x0125
        L_0x011f:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0028 }
            goto L_0x0125
        L_0x0123:
            r20 = r15
        L_0x0125:
            r7 = 0
            if (r2 == 0) goto L_0x018b
            int r0 = r2.size()     // Catch:{ Exception -> 0x0028 }
            if (r0 <= 0) goto L_0x018b
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x014b }
            r0.<init>()     // Catch:{ JSONException -> 0x014b }
            r8 = 0
            java.lang.Object r9 = r2.get(r8)     // Catch:{ JSONException -> 0x014b }
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = (com.mbridge.msdk.foundation.entity.CampaignEx) r9     // Catch:{ JSONException -> 0x014b }
            if (r9 == 0) goto L_0x014f
            java.lang.String r8 = r9.getCurrentLocalRid()     // Catch:{ JSONException -> 0x014b }
            com.mbridge.msdk.foundation.same.report.d.d r9 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ JSONException -> 0x0149 }
            com.mbridge.msdk.foundation.same.report.d.c r7 = r9.a((java.lang.String) r8, (java.lang.String) r3)     // Catch:{ JSONException -> 0x0149 }
            goto L_0x0151
        L_0x0149:
            r0 = move-exception
            goto L_0x0187
        L_0x014b:
            r0 = move-exception
            r8 = r22
            goto L_0x0187
        L_0x014f:
            r8 = r22
        L_0x0151:
            r3 = 0
        L_0x0152:
            int r9 = r2.size()     // Catch:{ JSONException -> 0x0149 }
            if (r3 >= r9) goto L_0x017b
            java.lang.Object r9 = r2.get(r3)     // Catch:{ JSONException -> 0x0149 }
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = (com.mbridge.msdk.foundation.entity.CampaignEx) r9     // Catch:{ JSONException -> 0x0149 }
            if (r9 == 0) goto L_0x0178
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0149 }
            r10.<init>()     // Catch:{ JSONException -> 0x0149 }
            java.lang.String r11 = r9.getRequestId()     // Catch:{ JSONException -> 0x0149 }
            r10.put(r6, r11)     // Catch:{ JSONException -> 0x0149 }
            java.lang.String r11 = "rid_n"
            java.lang.String r9 = r9.getRequestIdNotice()     // Catch:{ JSONException -> 0x0149 }
            r10.put(r11, r9)     // Catch:{ JSONException -> 0x0149 }
            r0.put(r10)     // Catch:{ JSONException -> 0x0149 }
        L_0x0178:
            int r3 = r3 + 1
            goto L_0x0152
        L_0x017b:
            java.lang.String r2 = "c_info"
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0149 }
            r4.a(r2, r0)     // Catch:{ JSONException -> 0x0149 }
        L_0x0184:
            r2 = r21
            goto L_0x018f
        L_0x0187:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0028 }
            goto L_0x0184
        L_0x018b:
            r2 = r21
            r8 = r22
        L_0x018f:
            r4.a(r6, r2)     // Catch:{ Exception -> 0x0028 }
            r4.a(r5, r8)     // Catch:{ Exception -> 0x0028 }
            if (r7 != 0) goto L_0x019c
            com.mbridge.msdk.foundation.same.report.d.c r0 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x0028 }
            r0.<init>()     // Catch:{ Exception -> 0x0028 }
        L_0x019c:
            com.mbridge.msdk.newreward.function.command.c r0 = r1.f10512j     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.newreward.a.e r2 = r1.f10511i     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.newreward.function.command.f r3 = com.mbridge.msdk.newreward.function.command.f.METRICS_KEY_M_CANDIDATE_DB     // Catch:{ Exception -> 0x0028 }
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0028 }
            java.lang.String r6 = "metrics_data"
            r8 = 0
            r5[r8] = r6     // Catch:{ Exception -> 0x0028 }
            r5[r20] = r4     // Catch:{ Exception -> 0x0028 }
            java.util.Map r4 = r0.a((java.lang.Object[]) r5)     // Catch:{ Exception -> 0x0028 }
            r0.a((java.lang.Object) r2, (com.mbridge.msdk.newreward.function.command.f) r3, (java.lang.Object) r4)     // Catch:{ Exception -> 0x0028 }
            goto L_0x01b7
        L_0x01b4:
            r0.printStackTrace()
        L_0x01b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.a.a.a(int, int, java.util.List, boolean, java.lang.String, java.lang.String, int, java.lang.String):void");
    }
}
