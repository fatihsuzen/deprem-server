package com.mbridge.msdk.foundation.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {

    /* renamed from: b  reason: collision with root package name */
    public static int f8771b = 4;

    /* renamed from: c  reason: collision with root package name */
    private static String f8772c = "BaseCandidateCache";

    /* renamed from: a  reason: collision with root package name */
    protected c f8773a;

    /* renamed from: d  reason: collision with root package name */
    private JSONArray f8774d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f8775e;

    /* renamed from: f  reason: collision with root package name */
    private String f8776f;

    /* renamed from: com.mbridge.msdk.foundation.b.a$a  reason: collision with other inner class name */
    public static class C0084a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public b f8778a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public double f8779b;

        public C0084a(double d5, b bVar) {
            this.f8779b = d5;
            this.f8778a = bVar;
        }

        public final b a() {
            return this.f8778a;
        }
    }

    public final JSONObject a(String str) {
        JSONArray jSONArray = this.f8774d;
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() <= 1) {
            return this.f8774d.optJSONObject(0);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i5 = 0; i5 < this.f8774d.length(); i5++) {
            try {
                JSONObject optJSONObject = this.f8774d.optJSONObject(i5);
                if (optJSONObject != null && str.equals(optJSONObject.getString("g"))) {
                    this.f8775e = optJSONObject;
                    return optJSONObject;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }

    public final String b(String str) {
        c c5 = c(str);
        if (!(c5 == null || c5.g() == c.f8792c || c5.g() == c.f8790a)) {
            String[] split = z.a(str.split("_")[3]).split("\\|");
            if (split.length > 1) {
                return split[1];
            }
        }
        return "";
    }

    public final c c(String str) {
        c cVar = new c();
        if (TextUtils.isEmpty(str) || str.split("_").length <= 3 || TextUtils.isEmpty(str.split("_")[3])) {
            cVar.d("bid token exception");
            cVar.a(c.f8790a);
            return cVar;
        }
        JSONArray jSONArray = this.f8774d;
        if (jSONArray == null || jSONArray.length() == 0) {
            cVar.d("config is empty");
            cVar.a(c.f8790a);
            return cVar;
        }
        String a5 = z.a(str.split("_")[3]);
        if (TextUtils.isEmpty(a5)) {
            cVar.d("bid token exception:decode error");
            cVar.a(c.f8790a);
            return cVar;
        }
        String[] split = a5.split("\\|");
        if (split.length == 0) {
            cVar.d("bid token can not get bid price");
            cVar.a(c.f8790a);
            return cVar;
        }
        if (split.length > 0) {
            try {
                Double.parseDouble(split[0]);
            } catch (Exception unused) {
                cVar.d("bid token can not cast bid price");
                cVar.a(c.f8790a);
                return cVar;
            }
        }
        if (TextUtils.isEmpty(this.f8776f)) {
            cVar.d("unitId is empty");
            cVar.a(c.f8792c);
        }
        return cVar;
    }

    public final double d(String str) {
        c c5 = c(str);
        if (!(c5 == null || c5.g() == c.f8792c || c5.g() == c.f8790a)) {
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
        this.f8776f = str;
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
        this.f8774d = jSONArray;
    }

    public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.d.c cVar, String str, int i5, String str2, int i6, double d5) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i7 = 0; i7 < list.size(); i7++) {
                        CampaignEx campaignEx = list.get(i7);
                        campaignEx.setReadyState(0);
                        if (cVar != null) {
                            campaignEx.setNLRid(cVar.f());
                        }
                        campaignEx.setNRid(str);
                        campaignEx.setReasond(str2);
                        campaignEx.setTyped(i5);
                        String b5 = z.b(d5 + "");
                        campaignEx.setNoticeUrl(a(campaignEx.getNoticeUrl(), i6, str, b5));
                        campaignEx.setClickURL(a(campaignEx.getClickURL(), i6, str, b5));
                        campaignEx.setImpressionURL(a(campaignEx.getImpressionURL(), i6, str, b5));
                        campaignEx.setOnlyImpressionURL(a(campaignEx.getOnlyImpressionURL(), i6, str, b5));
                        campaignEx.setAdvImp(a(campaignEx.getAdvImpList(), i6, str, b5));
                        j nativeVideoTracking = campaignEx.getNativeVideoTracking();
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
                            campaignEx.setNativeVideoTracking(nativeVideoTracking);
                            campaignEx.setNativeVideoTrackingString(CampaignEx.object2TrackingStr(nativeVideoTracking));
                        }
                        campaignEx.setPv_urls(b(campaignEx.getPv_urls(), i6, str, b5));
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final c a() {
        c cVar = new c();
        try {
            JSONArray jSONArray = this.f8774d;
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    if (this.f8773a == null) {
                        cVar.d("db error");
                        cVar.a(c.f8792c);
                    }
                    return cVar;
                }
            }
            cVar.d("setting config is null");
            cVar.a(c.f8790a);
            return cVar;
        } catch (Exception unused) {
            cVar.d("checkConfigAndDB exception");
            cVar.a(c.f8792c);
            return cVar;
        }
    }

    public final void a(List<C0084a> list, int i5) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collections.sort(list, new Comparator<C0084a>() {
                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                            return Double.compare(((C0084a) obj).f8779b, ((C0084a) obj2).f8779b);
                        }
                    });
                    int size = list.size() - i5;
                    if (size > 0) {
                        List<C0084a> subList = list.subList(0, size);
                        if (this.f8773a != null && subList.size() > 0) {
                            for (int i6 = 0; i6 < subList.size(); i6++) {
                                b b5 = subList.get(i6).f8778a;
                                this.f8773a.a(this.f8776f, b5.e(), b5.d());
                                b bVar = b5;
                                a(f8771b, 1, (List<CampaignEx>) null, true, bVar.e(), bVar.d(), -1, this.f8776f);
                            }
                        }
                    }
                }
            } catch (Exception e5) {
                af.a(f8772c, (Throwable) e5);
            }
        }
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

    public final long a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        String ecppv = list.get(0).getEcppv();
        if (TextUtils.isEmpty(ecppv)) {
            return 0;
        }
        String a5 = z.a(ecppv);
        if (TextUtils.isEmpty(a5)) {
            return 0;
        }
        try {
            if (Double.parseDouble(a5) <= 0.0d) {
                return 0;
            }
            JSONObject a6 = a(b(str));
            int i5 = 20;
            if (a6 != null) {
                i5 = a6.optInt("max_cache_num", 20);
            }
            c cVar = this.f8773a;
            if (cVar == null || i5 <= 0) {
                return -1;
            }
            return cVar.a(list, this.f8776f);
        } catch (Exception e5) {
            e5.printStackTrace();
            return -1;
        }
    }

    public final void a(String str, String str2, int i5, String str3) {
        try {
            if (this.f8773a != null) {
                if (!TextUtils.isEmpty(str3)) {
                    if (i5 == 1) {
                        this.f8773a.a(str2, str, this.f8776f, i5);
                        String str4 = str2;
                        a(f8771b, 3, (List<CampaignEx>) null, true, str4, str, -1, this.f8776f);
                    } else if (i5 == 2) {
                        this.f8773a.a(this.f8776f, str2, str);
                        String str5 = str2;
                        a(f8771b, 1, (List<CampaignEx>) null, true, str5, str, -1, this.f8776f);
                    } else if (i5 == 3) {
                        this.f8773a.b(str2, str, this.f8776f);
                        String str6 = str2;
                        a(f8771b, 4, (List<CampaignEx>) null, true, str6, str, -1, this.f8776f);
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v12 */
    /* JADX WARNING: type inference failed for: r11v13 */
    /* JADX WARNING: type inference failed for: r11v21 */
    /* JADX WARNING: type inference failed for: r11v22 */
    /* JADX WARNING: type inference failed for: r11v23 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0187 A[Catch:{ Exception -> 0x002c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r17, int r18, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r19, boolean r20, java.lang.String r21, java.lang.String r22, int r23, java.lang.String r24) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            r2 = r19
            r3 = r24
            java.lang.String r4 = "m_candidate_db"
            java.lang.String r5 = ""
            com.mbridge.msdk.foundation.same.report.d.e r6 = new com.mbridge.msdk.foundation.same.report.d.e
            r6.<init>()
            java.lang.String r7 = "type"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002c }
            r8.<init>()     // Catch:{ Exception -> 0x002c }
            r8.append(r0)     // Catch:{ Exception -> 0x002c }
            r8.append(r5)     // Catch:{ Exception -> 0x002c }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x002c }
            r6.a(r7, r8)     // Catch:{ Exception -> 0x002c }
            java.lang.String r7 = "result"
            if (r20 == 0) goto L_0x002f
            java.lang.String r8 = "1"
            goto L_0x0031
        L_0x002c:
            r0 = move-exception
            goto L_0x019a
        L_0x002f:
            java.lang.String r8 = "2"
        L_0x0031:
            r6.a(r7, r8)     // Catch:{ Exception -> 0x002c }
            java.lang.String r7 = "max_usage_limit"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002c }
            r8.<init>()     // Catch:{ Exception -> 0x002c }
            r9 = r23
            r8.append(r9)     // Catch:{ Exception -> 0x002c }
            r8.append(r5)     // Catch:{ Exception -> 0x002c }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x002c }
            r6.a(r7, r8)     // Catch:{ Exception -> 0x002c }
            java.lang.String r7 = "unit_id"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002c }
            r8.<init>()     // Catch:{ Exception -> 0x002c }
            r8.append(r3)     // Catch:{ Exception -> 0x002c }
            r8.append(r5)     // Catch:{ Exception -> 0x002c }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x002c }
            r6.a(r7, r8)     // Catch:{ Exception -> 0x002c }
            java.lang.String r7 = "scene"
            java.lang.String r8 = "db"
            r6.a(r7, r8)     // Catch:{ Exception -> 0x002c }
            org.json.JSONObject r7 = r1.f8775e     // Catch:{ Exception -> 0x002c }
            if (r7 == 0) goto L_0x0072
            java.lang.String r8 = "config"
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x002c }
            r6.a(r8, r7)     // Catch:{ Exception -> 0x002c }
        L_0x0072:
            java.lang.String r7 = "lrid"
            java.lang.String r8 = "rid"
            r10 = 1
            if (r0 != r10) goto L_0x0116
            boolean r0 = android.text.TextUtils.isEmpty(r22)     // Catch:{ Exception -> 0x002c }
            if (r0 == 0) goto L_0x0116
            com.mbridge.msdk.foundation.db.c r0 = r1.f8773a     // Catch:{ Exception -> 0x002c }
            if (r0 == 0) goto L_0x0116
            r10 = -1
            r11 = -1
            java.util.List r0 = r0.a((java.lang.String) r3, (int) r10, (long) r11)     // Catch:{ JSONException -> 0x0101 }
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0101 }
            r10.<init>()     // Catch:{ JSONException -> 0x0101 }
            if (r0 == 0) goto L_0x0108
            int r11 = r0.size()     // Catch:{ JSONException -> 0x0101 }
            if (r11 <= 0) goto L_0x0108
            r11 = 0
        L_0x0098:
            int r12 = r0.size()     // Catch:{ JSONException -> 0x0101 }
            if (r11 >= r12) goto L_0x0108
            java.lang.Object r12 = r0.get(r11)     // Catch:{ JSONException -> 0x0101 }
            com.mbridge.msdk.foundation.b.b r12 = (com.mbridge.msdk.foundation.b.b) r12     // Catch:{ JSONException -> 0x0101 }
            if (r12 == 0) goto L_0x0103
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0101 }
            r13.<init>()     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r14 = r12.e()     // Catch:{ JSONException -> 0x0101 }
            r13.put(r8, r14)     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r14 = "ts"
            r18 = r10
            long r9 = r12.h()     // Catch:{ JSONException -> 0x0101 }
            r13.put(r14, r9)     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r9 = r12.d()     // Catch:{ JSONException -> 0x0101 }
            r13.put(r7, r9)     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r9 = "ecppv"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0101 }
            r10.<init>()     // Catch:{ JSONException -> 0x0101 }
            double r14 = r12.c()     // Catch:{ JSONException -> 0x0101 }
            r10.append(r14)     // Catch:{ JSONException -> 0x0101 }
            r10.append(r5)     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r10 = r10.toString()     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r10 = com.mbridge.msdk.foundation.tools.z.b(r10)     // Catch:{ JSONException -> 0x0101 }
            r13.put(r9, r10)     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r9 = "state"
            int r10 = r12.g()     // Catch:{ JSONException -> 0x0101 }
            r13.put(r9, r10)     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r9 = "showCount"
            int r10 = r12.f()     // Catch:{ JSONException -> 0x0101 }
            r13.put(r9, r10)     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r9 = "interval_ts"
            long r14 = r12.a()     // Catch:{ JSONException -> 0x0101 }
            r13.put(r9, r14)     // Catch:{ JSONException -> 0x0101 }
            r9 = r18
            r9.put(r13)     // Catch:{ JSONException -> 0x0101 }
            goto L_0x0104
        L_0x0101:
            r0 = move-exception
            goto L_0x0113
        L_0x0103:
            r9 = r10
        L_0x0104:
            int r11 = r11 + 1
            r10 = r9
            goto L_0x0098
        L_0x0108:
            r9 = r10
            java.lang.String r0 = "cache"
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x0101 }
            r6.a(r0, r9)     // Catch:{ JSONException -> 0x0101 }
            goto L_0x0116
        L_0x0113:
            r0.printStackTrace()     // Catch:{ Exception -> 0x002c }
        L_0x0116:
            r9 = 0
            if (r2 == 0) goto L_0x017b
            int r0 = r2.size()     // Catch:{ Exception -> 0x002c }
            if (r0 <= 0) goto L_0x017b
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x013c }
            r0.<init>()     // Catch:{ JSONException -> 0x013c }
            r10 = 0
            java.lang.Object r11 = r2.get(r10)     // Catch:{ JSONException -> 0x013c }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = (com.mbridge.msdk.foundation.entity.CampaignEx) r11     // Catch:{ JSONException -> 0x013c }
            if (r11 == 0) goto L_0x0140
            java.lang.String r11 = r11.getCurrentLocalRid()     // Catch:{ JSONException -> 0x013c }
            com.mbridge.msdk.foundation.same.report.d.d r12 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ JSONException -> 0x013a }
            com.mbridge.msdk.foundation.same.report.d.c r9 = r12.a((java.lang.String) r11, (java.lang.String) r5)     // Catch:{ JSONException -> 0x013a }
            goto L_0x0142
        L_0x013a:
            r0 = move-exception
            goto L_0x0177
        L_0x013c:
            r0 = move-exception
            r11 = r22
            goto L_0x0177
        L_0x0140:
            r11 = r22
        L_0x0142:
            int r5 = r2.size()     // Catch:{ JSONException -> 0x013a }
            if (r10 >= r5) goto L_0x016b
            java.lang.Object r5 = r2.get(r10)     // Catch:{ JSONException -> 0x013a }
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5     // Catch:{ JSONException -> 0x013a }
            if (r5 == 0) goto L_0x0168
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x013a }
            r12.<init>()     // Catch:{ JSONException -> 0x013a }
            java.lang.String r13 = r5.getRequestId()     // Catch:{ JSONException -> 0x013a }
            r12.put(r8, r13)     // Catch:{ JSONException -> 0x013a }
            java.lang.String r13 = "rid_n"
            java.lang.String r5 = r5.getRequestIdNotice()     // Catch:{ JSONException -> 0x013a }
            r12.put(r13, r5)     // Catch:{ JSONException -> 0x013a }
            r0.put(r12)     // Catch:{ JSONException -> 0x013a }
        L_0x0168:
            int r10 = r10 + 1
            goto L_0x0142
        L_0x016b:
            java.lang.String r2 = "c_info"
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x013a }
            r6.a(r2, r0)     // Catch:{ JSONException -> 0x013a }
        L_0x0174:
            r2 = r21
            goto L_0x017f
        L_0x0177:
            r0.printStackTrace()     // Catch:{ Exception -> 0x002c }
            goto L_0x0174
        L_0x017b:
            r2 = r21
            r11 = r22
        L_0x017f:
            r6.a(r8, r2)     // Catch:{ Exception -> 0x002c }
            r6.a(r7, r11)     // Catch:{ Exception -> 0x002c }
            if (r9 != 0) goto L_0x018c
            com.mbridge.msdk.foundation.same.report.d.c r9 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x002c }
            r9.<init>()     // Catch:{ Exception -> 0x002c }
        L_0x018c:
            r9.d((java.lang.String) r3)     // Catch:{ Exception -> 0x002c }
            r9.a(r4, r6)     // Catch:{ Exception -> 0x002c }
            com.mbridge.msdk.foundation.same.report.d.d r0 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x002c }
            r0.a((java.lang.String) r4, (com.mbridge.msdk.foundation.same.report.d.c) r9)     // Catch:{ Exception -> 0x002c }
            goto L_0x019d
        L_0x019a:
            r0.printStackTrace()
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.b.a.a(int, int, java.util.List, boolean, java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    public final List<b> a(int i5, long j5) {
        a aVar;
        c cVar;
        if (i5 < 0 || (cVar = this.f8773a) == null) {
            aVar = this;
        } else {
            cVar.a(this.f8776f, i5);
            aVar = this;
            aVar.a(f8771b, 1, (List<CampaignEx>) null, true, "", "", i5, this.f8776f);
        }
        c cVar2 = aVar.f8773a;
        if (cVar2 != null) {
            return cVar2.a(aVar.f8776f, 0, j5);
        }
        return null;
    }
}
