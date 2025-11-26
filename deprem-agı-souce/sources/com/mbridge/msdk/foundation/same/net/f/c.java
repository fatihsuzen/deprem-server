package com.mbridge.msdk.foundation.same.net.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.same.net.a;
import com.mbridge.msdk.foundation.same.net.b;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.CustomInfoManager;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.i;
import com.mbridge.msdk.tracker.network.j;
import com.mbridge.msdk.tracker.network.l;
import com.mbridge.msdk.tracker.network.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    private static final String TAG = "c";
    protected Context mContext;

    public c(Context context) {
        if (context == null) {
            this.mContext = com.mbridge.msdk.foundation.controller.c.m().c();
        } else {
            this.mContext = context.getApplicationContext();
        }
    }

    private String asUrlParams(Map<String, String> map) {
        if (!(map == null || map.size() == 0)) {
            StringBuilder sb = new StringBuilder();
            try {
                for (String next : map.keySet()) {
                    if (!TextUtils.isEmpty(next)) {
                        String str = map.get(next);
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        sb.append("&");
                        sb.append(next);
                        sb.append("=");
                        sb.append(str);
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b(TAG, e5.getMessage());
                }
                sb = null;
            }
            if (sb != null && sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    private static i<?> createRequest(int i5, int i6, String str, b bVar, String str2, long j5) {
        if (i5 == 0) {
            i iVar = new i(bVar);
            return new l(i6, str, str2, j5, iVar);
        } else if (i5 != 1) {
            return null;
        } else {
            return new j(i6, str, str2, j5, new i(bVar));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a2 A[SYNTHETIC, Splitter:B:30:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f1 A[Catch:{ Exception -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01a6 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void post(int r11, java.lang.String r12, com.mbridge.msdk.foundation.same.net.f.e r13, com.mbridge.msdk.foundation.same.net.b r14, boolean r15, boolean r16, java.lang.String r17, long r18) {
        /*
            r10 = this;
            if (r13 != 0) goto L_0x000b
            com.mbridge.msdk.foundation.same.net.f.e r0 = new com.mbridge.msdk.foundation.same.net.f.e     // Catch:{ Exception -> 0x0009 }
            r0.<init>()     // Catch:{ Exception -> 0x0009 }
            r13 = r0
            goto L_0x000b
        L_0x0009:
            r0 = move-exception
            goto L_0x0021
        L_0x000b:
            r10.addExtraParams(r12, r13)     // Catch:{ Exception -> 0x0009 }
            com.mbridge.msdk.foundation.same.net.f.f.f(r13)     // Catch:{ Exception -> 0x0009 }
            com.mbridge.msdk.foundation.same.net.e.c r0 = com.mbridge.msdk.foundation.same.net.e.c.a()     // Catch:{ Exception -> 0x0009 }
            com.mbridge.msdk.foundation.same.net.d r0 = r0.a((com.mbridge.msdk.foundation.same.net.f.e) r13)     // Catch:{ Exception -> 0x0009 }
            if (r0 == 0) goto L_0x002a
            if (r14 == 0) goto L_0x002a
            r14.onSuccess(r0)     // Catch:{ Exception -> 0x0009 }
            return
        L_0x0021:
            java.lang.String r1 = TAG
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r0)
        L_0x002a:
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "post url = "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            com.mbridge.msdk.foundation.tools.af.c(r0, r1)
            com.mbridge.msdk.foundation.same.net.e.d r0 = com.mbridge.msdk.foundation.same.net.e.d.f()
            java.lang.String r0 = r0.f9368c
            boolean r0 = r12.contains(r0)
            java.lang.String r8 = ""
            r1 = 1
            if (r0 == 0) goto L_0x0113
            com.mbridge.msdk.c.h r0 = com.mbridge.msdk.c.h.a()
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r2 = r2.k()
            com.mbridge.msdk.c.g r2 = r0.b(r2)
            if (r2 == 0) goto L_0x0095
            int r3 = r2.Q()
            java.util.Map r0 = r13.a()     // Catch:{ Exception -> 0x007e }
            java.lang.String r4 = "data"
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x007e }
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x007e }
            if (r16 != 0) goto L_0x0083
            boolean r0 = com.mbridge.msdk.foundation.same.report.b.a(r2, r4)     // Catch:{ Exception -> 0x007c }
            if (r0 != 0) goto L_0x0083
            goto L_0x01fd
        L_0x007c:
            r0 = move-exception
            goto L_0x0080
        L_0x007e:
            r0 = move-exception
            r4 = r8
        L_0x0080:
            r0.printStackTrace()
        L_0x0083:
            java.lang.String r0 = r2.r()
            int r6 = r2.aB()
            java.lang.String r7 = "a_stid"
            java.lang.String r9 = r2.d()
            r13.a(r7, r9)
            goto L_0x009a
        L_0x0095:
            r6 = 0
            java.lang.String r0 = "UNKNOWN"
            r3 = r1
            r4 = r8
        L_0x009a:
            java.lang.String r7 = "country_code"
            r13.a(r7, r0)
            r0 = 2
            if (r3 != r0) goto L_0x00f1
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x01fd
            boolean r0 = com.mbridge.msdk.foundation.same.report.b.a(r2, r4)     // Catch:{ Exception -> 0x00ce }
            r2 = 3
            if (r0 == 0) goto L_0x00d0
            if (r6 == r1) goto L_0x00b3
            if (r6 != r2) goto L_0x0198
        L_0x00b3:
            com.mbridge.msdk.foundation.same.net.e r0 = com.mbridge.msdk.foundation.same.net.e.a()     // Catch:{ Exception -> 0x00ce }
            com.mbridge.msdk.foundation.same.net.e.d r1 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x00ce }
            java.lang.String r1 = r1.f9374i     // Catch:{ Exception -> 0x00ce }
            com.mbridge.msdk.foundation.same.net.e.d r2 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x00ce }
            int r2 = r2.f9378m     // Catch:{ Exception -> 0x00ce }
            java.lang.String r3 = r13.toString()     // Catch:{ Exception -> 0x00ce }
            r4 = 0
            r5 = r14
            r0.a(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x00ce }
            goto L_0x01fd
        L_0x00ce:
            r0 = move-exception
            goto L_0x010e
        L_0x00d0:
            if (r16 == 0) goto L_0x0198
            if (r6 == r1) goto L_0x00d6
            if (r6 != r2) goto L_0x01fd
        L_0x00d6:
            com.mbridge.msdk.foundation.same.net.e r0 = com.mbridge.msdk.foundation.same.net.e.a()     // Catch:{ Exception -> 0x00ce }
            com.mbridge.msdk.foundation.same.net.e.d r1 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x00ce }
            java.lang.String r1 = r1.f9374i     // Catch:{ Exception -> 0x00ce }
            com.mbridge.msdk.foundation.same.net.e.d r2 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x00ce }
            int r2 = r2.f9378m     // Catch:{ Exception -> 0x00ce }
            java.lang.String r3 = r13.toString()     // Catch:{ Exception -> 0x00ce }
            r4 = 0
            r5 = r14
            r0.a(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x00ce }
            goto L_0x01fd
        L_0x00f1:
            if (r3 != r1) goto L_0x0198
            com.mbridge.msdk.foundation.same.net.e r0 = com.mbridge.msdk.foundation.same.net.e.a()     // Catch:{ Exception -> 0x00ce }
            com.mbridge.msdk.foundation.same.net.e.d r1 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x00ce }
            java.lang.String r1 = r1.f9374i     // Catch:{ Exception -> 0x00ce }
            com.mbridge.msdk.foundation.same.net.e.d r2 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x00ce }
            int r2 = r2.f9378m     // Catch:{ Exception -> 0x00ce }
            java.lang.String r3 = r13.toString()     // Catch:{ Exception -> 0x00ce }
            r4 = 0
            r5 = r14
            r0.a(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x00ce }
            goto L_0x01fd
        L_0x010e:
            r0.printStackTrace()
            goto L_0x0198
        L_0x0113:
            com.mbridge.msdk.foundation.same.net.e.d r0 = com.mbridge.msdk.foundation.same.net.e.d.f()
            java.lang.String r0 = r0.f9372g
            boolean r0 = r12.contains(r0)
            if (r0 == 0) goto L_0x0157
            com.mbridge.msdk.c.h r0 = com.mbridge.msdk.c.h.a()
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r2 = r2.k()
            com.mbridge.msdk.c.g r0 = r0.b(r2)
            if (r0 == 0) goto L_0x0198
            com.mbridge.msdk.c.a r0 = r0.q()
            if (r0 == 0) goto L_0x0198
            int r0 = r0.h()
            if (r0 != r1) goto L_0x0198
            com.mbridge.msdk.foundation.same.net.e r0 = com.mbridge.msdk.foundation.same.net.e.a()
            com.mbridge.msdk.foundation.same.net.e.d r11 = com.mbridge.msdk.foundation.same.net.e.d.f()
            java.lang.String r1 = r11.f9376k
            com.mbridge.msdk.foundation.same.net.e.d r11 = com.mbridge.msdk.foundation.same.net.e.d.f()
            int r2 = r11.f9380o
            java.lang.String r3 = r13.toString()
            r4 = 0
            r5 = r14
            r0.a(r1, r2, r3, r4, r5)
            return
        L_0x0157:
            com.mbridge.msdk.foundation.same.net.e.d r0 = com.mbridge.msdk.foundation.same.net.e.d.f()
            java.lang.String r0 = r0.f9354O
            boolean r0 = r12.contains(r0)
            if (r0 == 0) goto L_0x0198
            if (r13 == 0) goto L_0x017d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            java.lang.String r12 = "?"
            r0.append(r12)
            java.lang.String r12 = r13.toString()
            r0.append(r12)
            java.lang.String r12 = r0.toString()
        L_0x017d:
            com.mbridge.msdk.foundation.db.a.b r0 = com.mbridge.msdk.foundation.db.a.b.a()
            org.json.JSONArray r0 = r0.b()
            if (r0 == 0) goto L_0x0198
            java.lang.String r13 = r0.toString()
            com.mbridge.msdk.foundation.same.net.f.e r0 = new com.mbridge.msdk.foundation.same.net.f.e
            r0.<init>()
            java.lang.String r1 = com.mbridge.msdk.foundation.same.net.f.e.f9401h
            r0.a(r1, r13)
            r3 = r12
            r13 = r0
            goto L_0x0199
        L_0x0198:
            r3 = r12
        L_0x0199:
            r2 = 1
            r1 = r11
            r4 = r14
            r5 = r17
            r6 = r18
            com.mbridge.msdk.tracker.network.i r11 = createRequest(r1, r2, r3, r4, r5, r6)
            if (r11 == 0) goto L_0x01fd
            if (r13 == 0) goto L_0x01e4
            java.util.Map r12 = r13.a()
            if (r12 == 0) goto L_0x01e4
            java.util.Map r12 = r13.a()
            java.lang.String r0 = "local_rid"
            java.lang.Object r12 = r12.get(r0)
            java.lang.String r12 = (java.lang.String) r12
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x01c1
            r12 = r8
        L_0x01c1:
            java.lang.String r0 = "local_id"
            r11.c(r0, r12)
            java.util.Map r12 = r13.a()
            java.lang.String r0 = "ad_type"
            java.lang.Object r12 = r12.get(r0)
            java.lang.String r12 = (java.lang.String) r12
            boolean r1 = android.text.TextUtils.isEmpty(r12)
            if (r1 == 0) goto L_0x01d9
            goto L_0x01da
        L_0x01d9:
            r8 = r12
        L_0x01da:
            r11.c(r0, r8)
            java.util.Map r12 = r13.a()
            r11.a((java.util.Map<java.lang.String, java.lang.String>) r12)
        L_0x01e4:
            boolean r12 = r10.canTrack()
            r11.a((boolean) r12)
            java.lang.String r12 = "Content-Type"
            java.lang.String r13 = "application/x-www-form-urlencoded"
            r11.a(r12, r13)
            com.mbridge.msdk.tracker.network.m r12 = com.mbridge.msdk.tracker.network.m.a()
            com.mbridge.msdk.tracker.network.v r12 = r12.b()
            r12.a(r11)
        L_0x01fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.f.c.post(int, java.lang.String, com.mbridge.msdk.foundation.same.net.f.e, com.mbridge.msdk.foundation.same.net.b, boolean, boolean, java.lang.String, long):void");
    }

    public void addExtraParams(String str, e eVar) {
        if (eVar != null) {
            String a5 = Aa.a();
            if (a5 == null) {
                a5 = "";
            }
            eVar.a("channel", a5);
            eVar.a("band_width", a.a().b() + "");
            eVar.a("open", com.mbridge.msdk.foundation.same.a.f9176S);
            if (com.mbridge.msdk.e.b.a() && !TextUtils.isEmpty(str) && str.contains("setting")) {
                String b5 = Aa.b();
                if (!TextUtils.isEmpty(b5)) {
                    eVar.a("keyword", b5);
                }
            }
            String str2 = eVar.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
            if (str2 != null) {
                String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str2, str);
                if (!TextUtils.isEmpty(customInfoByUnitId)) {
                    eVar.a("ch_info", customInfoByUnitId);
                }
                k d5 = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), str2);
                if (d5 != null && !TextUtils.isEmpty(d5.a())) {
                    eVar.a("u_stid", d5.a());
                }
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
                eVar.a("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                eVar.a("re_domain", "1");
                return;
            }
            return;
        }
        af.b(TAG, "addExtraParams error, params is null,frame work error");
    }

    /* access modifiers changed from: protected */
    public boolean canTrack() {
        return true;
    }

    public void choiceV3OrV5BySetting(int i5, e eVar, b bVar, String str, long j5) {
        int i6;
        e eVar2;
        g a5 = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        if (TextUtils.isEmpty(str)) {
            i6 = a5.as();
        } else {
            i6 = a5.I();
        }
        String a6 = d.f().a(str, i6);
        if (i6 < 2) {
            postV5(i5, a6, eVar, bVar, "campaign", j5);
            return;
        }
        if (i6 % 2 == 0) {
            if (eVar == null) {
                eVar = new e();
            }
            eVar2 = eVar;
            JSONArray b5 = com.mbridge.msdk.foundation.db.a.b.a().b();
            if (b5 != null) {
                String jSONArray = b5.toString();
                int d5 = d.f().d();
                if (d5 <= 0 || jSONArray.length() <= d5) {
                    eVar2.a(e.f9401h, jSONArray);
                } else {
                    post(i5, a6, eVar2, bVar, "campaign", j5);
                    return;
                }
            }
        } else {
            eVar2 = eVar;
        }
        getLoadOrSetting(i5, a6, eVar2, bVar, "campaign", j5);
    }

    public void get(int i5, String str, e eVar, b bVar, String str2, long j5) {
        get(i5, str, eVar, bVar, false, false, str2, j5);
    }

    public void getCampaign(int i5, String str, e eVar, b bVar, long j5) {
        int i6;
        e eVar2;
        try {
            g a5 = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
            if (TextUtils.isEmpty(str)) {
                i6 = a5.as();
            } else {
                i6 = a5.I();
            }
            String a6 = d.f().a(str, i6);
            if (i6 < 2) {
                postV5(i5, a6, eVar, bVar, true, "campaign", j5);
                return;
            }
            if (i6 % 2 == 0) {
                if (eVar == null) {
                    eVar = new e();
                }
                eVar2 = eVar;
                JSONArray b5 = com.mbridge.msdk.foundation.db.a.b.a().b();
                if (b5 != null) {
                    String jSONArray = b5.toString();
                    int d5 = d.f().d();
                    if (d5 <= 0 || jSONArray.length() <= d5) {
                        eVar2.a(e.f9401h, jSONArray);
                    } else {
                        post(i5, a6, eVar2, bVar, true, false, "campaign", j5);
                        return;
                    }
                }
            } else {
                eVar2 = eVar;
            }
            get(i5, a6, eVar2, bVar, true, true, "campaign", j5);
        } catch (Exception e5) {
            Exception exc = e5;
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, exc.getMessage());
            }
        }
    }

    public void getLoadOrSetting(int i5, String str, e eVar, b bVar, String str2, long j5) {
        getLoadOrSetting(i5, str, eVar, bVar, true, str2, j5);
    }

    public void postFocusReport(int i5, String str, e eVar, b bVar, String str2, long j5) {
        post(i5, str, eVar, bVar, false, true, str2, j5);
    }

    public void postV5(int i5, String str, e eVar, b bVar, String str2, long j5) {
        String str3 = eVar.a().get("sign");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        eVar.a(CampaignEx.JSON_KEY_ST_TS, currentTimeMillis + "");
        eVar.a("st", SameMD5.getMD5(currentTimeMillis + str3));
        post(i5, str, eVar, bVar, false, false, str2, j5);
    }

    public void get(int i5, String str, e eVar, b bVar, boolean z4, boolean z5, String str2, long j5) {
        JSONObject jSONObject;
        b bVar2 = bVar;
        String str3 = "";
        if (eVar == null) {
            try {
                eVar = new e();
            } catch (Exception e5) {
                af.a(TAG, e5.getMessage());
            }
        }
        addExtraParams(str, eVar);
        f.f(eVar);
        String str4 = eVar.a().get("sign");
        if (TextUtils.isEmpty(str4)) {
            str4 = str3;
        }
        long currentTimeMillis = System.currentTimeMillis();
        eVar.a(CampaignEx.JSON_KEY_ST_TS, currentTimeMillis + str3);
        if (com.mbridge.msdk.e.b.a()) {
            eVar.a("st", SameMD5.getMD5(str4 + currentTimeMillis));
        } else {
            eVar.a("st", SameMD5.getMD5(currentTimeMillis + str4));
        }
        com.mbridge.msdk.foundation.same.net.d a5 = com.mbridge.msdk.foundation.same.net.e.c.a().a(eVar);
        if (!(a5 == null || bVar2 == null)) {
            bVar2.onSuccess(a5);
            return;
        }
        if (str.contains(d.f().f9373h) && d.f().f9383r) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put("uri", d.f().f9377l + Uri.parse(str).getPath());
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, eVar.b());
            } catch (Throwable th) {
                af.b(TAG, th.getMessage());
            }
            e.a().a(d.f().f9377l, d.f().f9381p, jSONObject.toString(), true, bVar2);
            return;
        }
        String str5 = str + "?" + eVar.toString();
        g a6 = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        if (str5.length() < a6.ap() || !str5.contains(d.f().f9373h)) {
            e eVar2 = eVar;
            if (str5.length() < a6.R() || !z4) {
                e eVar3 = eVar2;
                i<?> createRequest = createRequest(i5, 0, str, bVar, str2, j5);
                if (createRequest != null) {
                    if (eVar3.a() != null) {
                        String str6 = eVar3.a().get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                        if (TextUtils.isEmpty(str6)) {
                            str6 = str3;
                        }
                        createRequest.c("local_id", str6);
                        String str7 = eVar3.a().get("ad_type");
                        if (!TextUtils.isEmpty(str7)) {
                            str3 = str7;
                        }
                        createRequest.c("ad_type", str3);
                        createRequest.a(eVar3.a());
                    }
                    createRequest.a(canTrack());
                    m.a().b().a(createRequest);
                    return;
                }
                return;
            }
            post(i5, str, eVar2, bVar, z5, false, str2, j5);
            return;
        }
        post(i5, str, eVar, bVar, z5, false, str2, j5);
    }

    public void getLoadOrSetting(int i5, String str, e eVar, b bVar, boolean z4, String str2, long j5) {
        get(i5, str, eVar, bVar, z4, false, str2, j5);
    }

    public void postV5(int i5, String str, e eVar, b bVar, boolean z4, String str2, long j5) {
        String str3 = eVar.a().get("sign");
        if (str3 == null) {
            str3 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        eVar.a(CampaignEx.JSON_KEY_ST_TS, currentTimeMillis + "");
        eVar.a("st", SameMD5.getMD5(currentTimeMillis + str3));
        post(i5, str, eVar, bVar, z4, false, str2, j5);
    }

    public void get(int i5, String str, Map<String, String> map, b bVar, String str2, long j5) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(MBridgeConstans.APP_ID, com.mbridge.msdk.foundation.controller.c.m().k());
        map.put("sdk_version", MBConfiguration.SDK_VERSION);
        map.put("platform", "1");
        String asUrlParams = asUrlParams(map);
        if (!TextUtils.isEmpty(asUrlParams)) {
            str = str + "?" + asUrlParams;
        }
        String str3 = str;
        if (MBridgeConstans.DEBUG) {
            af.a("AppletsModel", "get wx scheme url = " + str3);
        }
        i<?> createRequest = createRequest(i5, 0, str3, bVar, str2, j5);
        if (createRequest != null) {
            String str4 = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str4 = str5;
            }
            createRequest.c("local_id", str4);
            String str6 = map.get("ad_type");
            if (!TextUtils.isEmpty(str6)) {
                str5 = str6;
            }
            createRequest.c("ad_type", str5);
            createRequest.a(map);
            createRequest.a(canTrack());
            m.a().b().a(createRequest);
        }
    }

    public void post(int i5, String str, e eVar, b bVar, String str2, long j5) {
        post(i5, str, eVar, bVar, false, false, str2, j5);
    }
}
