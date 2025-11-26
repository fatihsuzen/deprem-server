package com.mbridge.msdk.reward.a;

import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.mbridge.msdk.foundation.b.a;
import com.mbridge.msdk.foundation.b.d;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f11018a = "RewardCandidateController";

    /* renamed from: b  reason: collision with root package name */
    private d f11019b;

    public a(String str, boolean z4) {
        try {
            this.f11019b = b.a().a(str, com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), str, z4).G());
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(List<CampaignEx> list, String str, com.mbridge.msdk.reward.adapter.c cVar, String str2) {
        String str3 = str;
        try {
            if (this.f11019b != null && !TextUtils.isEmpty(str3)) {
                List<CampaignEx> list2 = list;
                this.f11019b.a(com.mbridge.msdk.foundation.b.a.f8771b, 2, list2, this.f11019b.a(list2, str3) > 0, "", "", -1, str2);
                d dVar = this.f11019b;
                JSONObject a5 = dVar.a(dVar.b(str3));
                if (a5 != null && this.f11019b.d(str3) > 0.0d) {
                    int optInt = a5.optInt("max_usage_limit", 10);
                    int optInt2 = a5.optInt("max_cache_num", 20);
                    a(this.f11019b.a(optInt, 0), a5, optInt2, -1.0d, cVar, new com.mbridge.msdk.foundation.same.report.d.c(), str3, false, 0);
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final com.mbridge.msdk.foundation.b.c a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar, CampaignEx campaignEx, com.mbridge.msdk.foundation.c.b bVar, int i5, com.mbridge.msdk.reward.adapter.c cVar2) {
        String str2;
        String str3;
        int i6;
        String str4 = str;
        com.mbridge.msdk.foundation.b.c cVar3 = new com.mbridge.msdk.foundation.b.c();
        String str5 = "";
        if (campaignEx == null) {
            str2 = str5;
        } else {
            try {
                str2 = campaignEx.getRequestId();
            } catch (Exception unused) {
                try {
                    cVar3.d("getRewardCandidateCampaignList result exception");
                    cVar3.a(com.mbridge.msdk.foundation.b.c.f8792c);
                    return cVar3;
                } catch (Exception unused2) {
                    cVar3.d("getCandidateCampaignList result exception");
                    cVar3.a(com.mbridge.msdk.foundation.b.c.f8792c);
                    return cVar3;
                }
            }
        }
        if (bVar != null) {
            int e5 = bVar.e();
            str3 = bVar.b();
            i6 = e5;
        } else {
            str3 = null;
            i6 = 0;
        }
        String str6 = str3;
        d dVar = this.f11019b;
        if (dVar == null) {
            com.mbridge.msdk.foundation.b.c cVar4 = new com.mbridge.msdk.foundation.b.c();
            cVar4.d("can not get manager");
            cVar4.a(com.mbridge.msdk.foundation.b.c.f8792c);
            return cVar4;
        }
        com.mbridge.msdk.foundation.b.c c5 = dVar.c(str4);
        if (c5.g() <= com.mbridge.msdk.foundation.b.c.f8791b) {
            String[] split = z.a(str4.split("_")[3]).split("\\|");
            double parseDouble = Double.parseDouble(split[0]);
            if (split.length > 1) {
                str5 = split[1];
            }
            String str7 = str5;
            double d5 = parseDouble;
            c5 = a(d5, str7, cVar2, cVar, str4, i5);
            this.f11019b.a(c5.a(), cVar, str2, i6, str6, i5, d5);
        }
        return c5;
    }

    private com.mbridge.msdk.foundation.b.c a(double d5, String str, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.same.report.d.c cVar2, String str2, int i5) {
        com.mbridge.msdk.foundation.b.c cVar3;
        com.mbridge.msdk.foundation.b.c a5 = this.f11019b.a();
        try {
            if (a5.g() > 0) {
                return a5;
            }
            JSONObject a6 = this.f11019b.a(str);
            if (a6 != null) {
                int optInt = a6.optInt("max_usage_limit", 10);
                int optInt2 = a6.optInt("max_cache_num", 20);
                if (optInt2 > 0) {
                    long j5 = 8640000;
                    long optLong = a6.optLong("show_interval_time", 8640000);
                    if (optLong != 0) {
                        j5 = optLong;
                    }
                    List<com.mbridge.msdk.foundation.b.b> a7 = this.f11019b.a(optInt, System.currentTimeMillis() - (j5 * 1000));
                    if (a7 != null && a7.size() > 0) {
                        return a(a7, a6, optInt2, d5, cVar, cVar2, str2, true, i5);
                    }
                    a5.d("no cache");
                    a5.a(com.mbridge.msdk.foundation.b.c.f8792c);
                    cVar3 = a5;
                    try {
                        a(cVar2, str2, cVar3, (List<a.C0084a>) null, a6, 2);
                        return cVar3;
                    } catch (Exception unused) {
                        cVar3.d("getHighestCampaigns exception");
                        cVar3.a(com.mbridge.msdk.foundation.b.c.f8792c);
                        return cVar3;
                    }
                } else {
                    com.mbridge.msdk.foundation.b.c cVar4 = a5;
                    cVar4.d("max cache num error");
                    cVar4.a(com.mbridge.msdk.foundation.b.c.f8792c);
                    return cVar4;
                }
            } else {
                com.mbridge.msdk.foundation.b.c cVar5 = a5;
                cVar5.d("setting config not mapping");
                cVar5.a(com.mbridge.msdk.foundation.b.c.f8792c);
                return cVar5;
            }
        } catch (Exception unused2) {
            cVar3 = a5;
            cVar3.d("getHighestCampaigns exception");
            cVar3.a(com.mbridge.msdk.foundation.b.c.f8792c);
            return cVar3;
        }
    }

    private com.mbridge.msdk.foundation.b.c a(List<com.mbridge.msdk.foundation.b.b> list, JSONObject jSONObject, int i5, double d5, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.same.report.d.c cVar2, String str, boolean z4, int i6) {
        List<com.mbridge.msdk.foundation.b.b> list2;
        int i7;
        List<com.mbridge.msdk.foundation.b.b> list3 = list;
        JSONObject jSONObject2 = jSONObject;
        com.mbridge.msdk.foundation.b.c cVar3 = new com.mbridge.msdk.foundation.b.c();
        if (jSONObject2 == null) {
            cVar3.d("config is null");
            cVar3.a(com.mbridge.msdk.foundation.b.c.f8792c);
            return cVar3;
        } else if (list3 == null || list3.size() == 0) {
            cVar3.d("candidate is null");
            cVar3.a(com.mbridge.msdk.foundation.b.c.f8792c);
            return cVar3;
        } else {
            for (int i8 = 0; i8 < list3.size(); i8++) {
                com.mbridge.msdk.foundation.b.b bVar = list3.get(i8);
                if (bVar != null) {
                    cVar3.a(bVar.e());
                }
            }
            if (list3.size() > 0 && ((list3 = a(list3, cVar3)) == null || list3.size() == 0)) {
                cVar3.d("existed");
                cVar3.a(com.mbridge.msdk.foundation.b.c.f8792c);
            }
            if (list3.size() > 0 && ((list3 = a(list3, cVar, cVar3)) == null || list3.size() == 0)) {
                cVar3.d("not ready");
                cVar3.a(com.mbridge.msdk.foundation.b.c.f8792c);
            }
            ArrayList arrayList = null;
            if (list3 != null && list3.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                double optDouble = jSONObject2.optDouble("t_disc", 0.8d);
                double optDouble2 = jSONObject2.optDouble("u_disc", 0.95d);
                double optDouble3 = jSONObject2.optDouble("max_ecppv_diff", 0.0d);
                int optInt = jSONObject2.optInt("time_interval", 1800);
                int size = list3.size();
                double d6 = 0.0d;
                com.mbridge.msdk.foundation.b.b bVar2 = null;
                int i9 = 0;
                while (i9 < size) {
                    com.mbridge.msdk.foundation.b.b bVar3 = list3.get(i9);
                    if (bVar3 != null) {
                        i7 = i9;
                        double pow = Math.pow(optDouble2, (double) bVar3.f()) * bVar3.c() * Math.pow(optDouble, ((double) (System.currentTimeMillis() - bVar3.h())) / (((double) optInt) * 1000.0d));
                        list2 = list3;
                        arrayList2.add(new a.C0084a(pow, bVar3));
                        if (pow >= d5 - optDouble3 && pow > d6) {
                            d6 = pow;
                            bVar2 = bVar3;
                        }
                    } else {
                        list2 = list3;
                        i7 = i9;
                    }
                    i9 = i7 + 1;
                    JSONObject jSONObject3 = jSONObject;
                    list3 = list2;
                }
                d dVar = this.f11019b;
                if (dVar != null) {
                    dVar.a((List<a.C0084a>) arrayList2, i5);
                }
                if (bVar2 != null) {
                    cVar3.a(bVar2.b());
                    cVar3.a(com.mbridge.msdk.foundation.b.c.f8793d);
                } else {
                    cVar3.d("no match campaign");
                    cVar3.a(com.mbridge.msdk.foundation.b.c.f8792c);
                }
                arrayList = arrayList2;
            }
            if (z4) {
                a(cVar2, str, cVar3, (List<a.C0084a>) arrayList, jSONObject, 2);
            }
            return cVar3;
        }
    }

    private List<com.mbridge.msdk.foundation.b.b> a(List<com.mbridge.msdk.foundation.b.b> list, com.mbridge.msdk.foundation.b.c cVar) {
        CopyOnWriteArrayList<CampaignEx> b5;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            com.mbridge.msdk.foundation.b.b bVar = list.get(i5);
            if (!(bVar == null || (b5 = bVar.b()) == null || b5.size() == 0)) {
                int i6 = 0;
                boolean z4 = false;
                while (true) {
                    if (i6 >= b5.size()) {
                        break;
                    }
                    CampaignEx campaignEx = b5.get(i6);
                    boolean c5 = ak.c(c.m().c(), campaignEx.getPackageName());
                    if (c5) {
                        cVar.c(bVar.e());
                        d dVar = this.f11019b;
                        if (dVar != null) {
                            dVar.a(bVar.d(), bVar.e(), 2, campaignEx.getEcppv());
                        }
                        z4 = c5;
                    } else {
                        i6++;
                        z4 = c5;
                    }
                }
                if (!z4) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        r6 = r12.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r4, !android.text.TextUtils.isEmpty(r7.getCMPTEntryUrl()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.mbridge.msdk.foundation.b.b> a(java.util.List<com.mbridge.msdk.foundation.b.b> r11, com.mbridge.msdk.reward.adapter.c r12, com.mbridge.msdk.foundation.b.c r13) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0075
            int r0 = r11.size()
            if (r0 != 0) goto L_0x000a
            goto L_0x0075
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r1
        L_0x0011:
            int r3 = r11.size()
            if (r2 >= r3) goto L_0x0074
            java.lang.Object r3 = r11.get(r2)
            com.mbridge.msdk.foundation.b.b r3 = (com.mbridge.msdk.foundation.b.b) r3
            if (r3 != 0) goto L_0x0020
            goto L_0x0071
        L_0x0020:
            java.util.concurrent.CopyOnWriteArrayList r4 = r3.b()
            if (r4 == 0) goto L_0x0071
            int r5 = r4.size()
            if (r5 != 0) goto L_0x002d
            goto L_0x0071
        L_0x002d:
            r5 = r1
            r6 = r5
        L_0x002f:
            int r7 = r4.size()
            if (r5 >= r7) goto L_0x006c
            java.lang.Object r7 = r4.get(r5)
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7
            if (r12 == 0) goto L_0x0069
            java.lang.String r6 = r7.getCMPTEntryUrl()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            r6 = r6 ^ 1
            boolean r6 = r12.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r4, (boolean) r6)
            if (r6 != 0) goto L_0x0069
            java.lang.String r4 = r3.e()
            r13.b(r4)
            com.mbridge.msdk.foundation.b.d r4 = r10.f11019b
            if (r4 == 0) goto L_0x006c
            java.lang.String r5 = r3.d()
            java.lang.String r8 = r3.e()
            r9 = 2
            java.lang.String r7 = r7.getEcppv()
            r4.a((java.lang.String) r5, (java.lang.String) r8, (int) r9, (java.lang.String) r7)
            goto L_0x006c
        L_0x0069:
            int r5 = r5 + 1
            goto L_0x002f
        L_0x006c:
            if (r6 == 0) goto L_0x0071
            r0.add(r3)
        L_0x0071:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x0074:
            return r0
        L_0x0075:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.a.a.a(java.util.List, com.mbridge.msdk.reward.adapter.c, com.mbridge.msdk.foundation.b.c):java.util.List");
    }

    public final boolean a(String str) {
        JSONObject a5;
        try {
            d dVar = this.f11019b;
            if (dVar == null || (a5 = dVar.a(dVar.b(str))) == null || a5.optInt("c_cb", 0) != 1) {
                return false;
            }
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return false;
    }

    public final void a(String str, String str2, int i5, String str3) {
        d dVar = this.f11019b;
        if (dVar != null) {
            dVar.a(str, str2, i5, str3);
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, com.mbridge.msdk.foundation.b.c cVar2, List<a.C0084a> list, JSONObject jSONObject, int i5) {
        String str2;
        try {
            e eVar = new e();
            if (i5 == 1) {
                str2 = "cb";
            } else if (i5 == 2) {
                str2 = "candidate";
            } else if (i5 != 3) {
                str2 = EnvironmentCompat.MEDIA_UNKNOWN;
            } else {
                str2 = "track";
            }
            eVar.a("scene", str2);
            d dVar = this.f11019b;
            if (dVar != null) {
                double d5 = dVar.d(str);
                if (d5 >= 0.0d) {
                    eVar.a("bp", z.b(d5 + ""));
                }
                eVar.a("cb_state", a(str) ? "open" : CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
                try {
                    d dVar2 = this.f11019b;
                    JSONObject a5 = dVar2.a(dVar2.b(str));
                    if (a5 != null) {
                        eVar.a("config", a5.toString());
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if (cVar2 != null) {
                if (cVar2.g() == com.mbridge.msdk.foundation.b.c.f8793d) {
                    eVar.a("result", 1);
                } else {
                    eVar.a("result", 2);
                    eVar.a("reason", cVar2.b());
                }
                eVar.a("acr", cVar2.c());
                eVar.a("her", cVar2.e());
                eVar.a("nrr", cVar2.d());
                eVar.a("cer", cVar2.f());
            } else {
                eVar.a("result", 2);
                eVar.a("reason", "candidate result is null");
            }
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i6 = 0; i6 < list.size(); i6++) {
                    com.mbridge.msdk.foundation.b.b a6 = list.get(i6).a();
                    if (a6 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ecppv", z.b(a6.c() + ""));
                        jSONObject2.put("showCount", a6.f());
                        jSONObject2.put("intervalTime", System.currentTimeMillis() - a6.h());
                        jSONArray.put(jSONObject2);
                    }
                }
                eVar.a(DataSchemeDataSource.SCHEME_DATA, jSONArray.toString());
            }
            if (cVar != null) {
                cVar.a("m_candidate_data");
                cVar.k("m_candidate_data");
                cVar.a("m_candidate_data", eVar);
                if (!(cVar2 == null || cVar2.a() == null)) {
                    cVar.b((List<CampaignEx>) cVar2.a());
                }
            }
            com.mbridge.msdk.foundation.same.report.d.d.a().a("m_candidate_data", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
