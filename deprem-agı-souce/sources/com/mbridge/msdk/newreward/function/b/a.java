package com.mbridge.msdk.newreward.function.b;

import androidx.core.os.EnvironmentCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.a.a;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.videocommon.d.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f10530a = "RewardCandidateController";

    /* renamed from: b  reason: collision with root package name */
    private final c f10531b;

    /* renamed from: c  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.a.c f10532c;

    public a(String str, boolean z4, c cVar) {
        this.f10531b = cVar;
        try {
            com.mbridge.msdk.newreward.function.a.c a5 = com.mbridge.msdk.newreward.function.a.a.a.a().a(str, b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), str, z4).G());
            this.f10532c = a5;
            a5.a(cVar);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private List<com.mbridge.msdk.newreward.function.c.a.b> b(List<com.mbridge.msdk.newreward.function.c.a.b> list, com.mbridge.msdk.newreward.function.a.b bVar) {
        List<com.mbridge.msdk.newreward.function.c.a.a> u5;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            com.mbridge.msdk.newreward.function.c.a.b bVar2 = list.get(i5);
            if (!(bVar2 == null || (u5 = bVar2.u()) == null || u5.size() == 0)) {
                arrayList.add(bVar2);
            }
        }
        return arrayList;
    }

    public final com.mbridge.msdk.newreward.function.a.b a(com.mbridge.msdk.foundation.same.report.d.c cVar, com.mbridge.msdk.foundation.c.b bVar, e eVar, int i5) {
        String str;
        String str2;
        CampaignEx campaignEx;
        String str3;
        String str4;
        int i6;
        e eVar2 = eVar;
        com.mbridge.msdk.newreward.function.a.b bVar2 = new com.mbridge.msdk.newreward.function.a.b();
        String str5 = "";
        int i7 = 94;
        if (eVar2 != null) {
            try {
                str2 = eVar2.J();
                campaignEx = (eVar2.D() == null || eVar2.D().b() == null || eVar2.D().b().E() == null || eVar2.D().b().E().size() <= 0) ? null : eVar2.D().b().E().get(0);
                if (this.f10532c != null) {
                    i7 = eVar2.h();
                    String C4 = eVar2.C();
                    this.f10532c.a(i7);
                    this.f10532c.f(C4);
                    this.f10532c.a(eVar2);
                    str = C4;
                } else {
                    str = str5;
                }
            } catch (Exception unused) {
                bVar2.d("getCandidateCampaignList result exception");
                bVar2.a(com.mbridge.msdk.foundation.b.c.f8792c);
                return bVar2;
            }
        } else {
            str = str5;
            str2 = null;
            campaignEx = null;
        }
        int i8 = i7;
        if (campaignEx == null) {
            str3 = str5;
        } else {
            try {
                str3 = campaignEx.getRequestId();
            } catch (Exception unused2) {
                bVar2.d("getRewardCandidateCampaignList result exception");
                bVar2.a(com.mbridge.msdk.foundation.b.c.f8792c);
                return bVar2;
            }
        }
        if (bVar != null) {
            i6 = bVar.e();
            str4 = bVar.b();
        } else {
            i6 = 0;
            str4 = null;
        }
        com.mbridge.msdk.newreward.function.a.c cVar2 = this.f10532c;
        if (cVar2 == null) {
            com.mbridge.msdk.newreward.function.a.b bVar3 = new com.mbridge.msdk.newreward.function.a.b();
            bVar3.d("can not get manager");
            bVar3.a(com.mbridge.msdk.foundation.b.c.f8792c);
            return bVar3;
        }
        com.mbridge.msdk.newreward.function.a.b c5 = cVar2.c(str2);
        if (c5.h() <= com.mbridge.msdk.foundation.b.c.f8791b) {
            String[] split = z.a(str2.split("_")[3]).split("\\|");
            double parseDouble = Double.parseDouble(split[0]);
            if (split.length > 1) {
                str5 = split[1];
            }
            double d5 = parseDouble;
            c5 = a(d5, str5, cVar, str2, eVar2, i5, i8, str);
            if (!(c5 == null || c5.a() == null)) {
                this.f10532c.a(c5.a().u(), cVar, str3, i6, str4, i5, d5);
            }
        }
        return c5;
    }

    private com.mbridge.msdk.newreward.function.a.b a(double d5, String str, com.mbridge.msdk.foundation.same.report.d.c cVar, String str2, e eVar, int i5, int i6, String str3) {
        com.mbridge.msdk.newreward.function.a.b bVar;
        int i7;
        e eVar2;
        String str4;
        com.mbridge.msdk.foundation.same.report.d.c cVar2;
        a aVar;
        int i8;
        List<com.mbridge.msdk.newreward.function.c.a.b> list;
        com.mbridge.msdk.newreward.function.a.b a5 = this.f10532c.a();
        try {
            if (a5.h() > 0) {
                return a5;
            }
            JSONObject a6 = this.f10532c.a(str);
            if (a6 != null) {
                int optInt = a6.optInt("max_usage_limit", 10);
                if (a6.optInt("max_cache_num", 20) > 0) {
                    List<com.mbridge.msdk.newreward.function.c.a.b> a7 = this.f10532c.a(optInt, i6, str3);
                    if (a7 == null || a7.size() <= 0) {
                        a5.d("no cache");
                        a5.a(com.mbridge.msdk.foundation.b.c.f8792c);
                        bVar = a5;
                        try {
                            a(cVar, str2, bVar, (List<a.C0099a>) null, a6, eVar, 2);
                            return bVar;
                        } catch (Exception unused) {
                            bVar.d("getHighestCampaigns exception");
                            bVar.a(com.mbridge.msdk.foundation.b.c.f8792c);
                            return bVar;
                        }
                    } else {
                        com.mbridge.msdk.newreward.function.a.b bVar2 = new com.mbridge.msdk.newreward.function.a.b();
                        if (a7.size() == 0) {
                            bVar2.d("candidate is null");
                            bVar2.a(com.mbridge.msdk.foundation.b.c.f8792c);
                            return bVar2;
                        }
                        for (int i9 = 0; i9 < a7.size(); i9++) {
                            com.mbridge.msdk.newreward.function.c.a.b bVar3 = a7.get(i9);
                            if (bVar3 != null) {
                                bVar2.a(bVar3.f());
                            }
                        }
                        if (a7.size() > 0) {
                            if (a7.size() != 0) {
                                ArrayList arrayList = new ArrayList();
                                for (int i10 = 0; i10 < a7.size(); i10++) {
                                    com.mbridge.msdk.newreward.function.c.a.b bVar4 = a7.get(i10);
                                    if (bVar4 != null) {
                                        List<com.mbridge.msdk.newreward.function.c.a.a> u5 = bVar4.u();
                                        if (u5 != null) {
                                            if (u5.size() != 0) {
                                                int i11 = 0;
                                                boolean z4 = false;
                                                while (true) {
                                                    if (i11 >= u5.size()) {
                                                        break;
                                                    }
                                                    com.mbridge.msdk.newreward.function.c.a.a aVar2 = u5.get(i11);
                                                    boolean c5 = ak.c(com.mbridge.msdk.foundation.controller.c.m().c(), aVar2.h().getPackageName());
                                                    if (c5) {
                                                        bVar2.c(bVar4.f());
                                                        com.mbridge.msdk.newreward.function.a.c cVar3 = this.f10532c;
                                                        if (cVar3 != null) {
                                                            cVar3.a(bVar4.g(), bVar4.f(), 2, aVar2.i().s());
                                                        }
                                                        z4 = c5;
                                                    } else {
                                                        i11++;
                                                        z4 = c5;
                                                    }
                                                }
                                                if (!z4) {
                                                    arrayList.add(bVar4);
                                                }
                                            }
                                        }
                                    }
                                }
                                a7 = arrayList;
                            }
                            if (a7.size() == 0) {
                                bVar2.d("existed");
                                bVar2.a(com.mbridge.msdk.foundation.b.c.f8792c);
                            }
                        }
                        if (a7.size() > 0 && ((a7 = a(a7, bVar2)) == null || a7.size() == 0)) {
                            bVar2.d("not ready");
                            bVar2.a(com.mbridge.msdk.foundation.b.c.f8792c);
                        }
                        if (a7.size() > 0 && ((a7 = b(a7, bVar2)) == null || a7.size() == 0)) {
                            bVar2.d("had in cache");
                            bVar2.a(com.mbridge.msdk.foundation.b.c.f8792c);
                        }
                        ArrayList arrayList2 = null;
                        if (a7 == null || a7.size() <= 0) {
                            aVar = this;
                            cVar2 = cVar;
                            str4 = str2;
                            eVar2 = eVar;
                            i7 = i5;
                        } else {
                            ArrayList arrayList3 = new ArrayList();
                            double optDouble = a6.optDouble("t_disc", 0.8d);
                            double optDouble2 = a6.optDouble("u_disc", 0.95d);
                            double optDouble3 = a6.optDouble("max_ecppv_diff", 0.0d);
                            int optInt2 = a6.optInt("time_interval", 1800);
                            int size = a7.size();
                            double d6 = 0.0d;
                            com.mbridge.msdk.newreward.function.c.a.b bVar5 = null;
                            int i12 = 0;
                            while (i12 < size) {
                                com.mbridge.msdk.newreward.function.c.a.b bVar6 = a7.get(i12);
                                if (bVar6 != null) {
                                    list = a7;
                                    double pow = Math.pow(optDouble2, (double) bVar6.t()) * bVar6.s() * Math.pow(optDouble, ((double) (System.currentTimeMillis() - bVar6.I())) / (((double) optInt2) * 1000.0d));
                                    i8 = optInt2;
                                    arrayList3.add(new a.C0099a(pow, bVar6));
                                    if (pow >= d5 - optDouble3 && pow > d6) {
                                        d6 = pow;
                                        bVar5 = bVar6;
                                    }
                                } else {
                                    list = a7;
                                    i8 = optInt2;
                                }
                                i12++;
                                a7 = list;
                                optInt2 = i8;
                            }
                            if (bVar5 != null) {
                                bVar2.a(bVar5);
                                bVar2.a(com.mbridge.msdk.foundation.b.c.f8793d);
                            } else {
                                bVar2.d("no match campaign");
                                bVar2.a(com.mbridge.msdk.foundation.b.c.f8792c);
                            }
                            arrayList2 = arrayList3;
                            aVar = this;
                            cVar2 = cVar;
                            str4 = str2;
                            i7 = i5;
                            eVar2 = eVar;
                        }
                        aVar.a(cVar2, str4, bVar2, arrayList2, a6, eVar2, i7);
                        return bVar2;
                    }
                } else {
                    com.mbridge.msdk.newreward.function.a.b bVar7 = a5;
                    bVar7.d("max cache num error");
                    bVar7.a(com.mbridge.msdk.foundation.b.c.f8792c);
                    return bVar7;
                }
            } else {
                com.mbridge.msdk.newreward.function.a.b bVar8 = a5;
                bVar8.d("setting config not mapping");
                bVar8.a(com.mbridge.msdk.foundation.b.c.f8792c);
                return bVar8;
            }
        } catch (Exception unused2) {
            bVar = a5;
            bVar.d("getHighestCampaigns exception");
            bVar.a(com.mbridge.msdk.foundation.b.c.f8792c);
            return bVar;
        }
    }

    private List<com.mbridge.msdk.newreward.function.c.a.b> a(List<com.mbridge.msdk.newreward.function.c.a.b> list, com.mbridge.msdk.newreward.function.a.b bVar) {
        List<com.mbridge.msdk.newreward.function.c.a.a> u5;
        List<com.mbridge.msdk.newreward.function.c.a.b> list2 = list;
        if (list2 == null || list2.size() == 0) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < list2.size(); i5++) {
            com.mbridge.msdk.newreward.function.c.a.b bVar2 = list2.get(i5);
            if (bVar2 == null || (u5 = bVar2.u()) == null || u5.size() == 0) {
                com.mbridge.msdk.newreward.function.a.b bVar3 = bVar;
            } else {
                int i6 = 0;
                boolean z4 = false;
                while (true) {
                    if (i6 >= u5.size()) {
                        com.mbridge.msdk.newreward.function.a.b bVar4 = bVar;
                        break;
                    }
                    com.mbridge.msdk.newreward.function.c.a.a aVar = u5.get(i6);
                    boolean z5 = aVar.i().z();
                    if (!z5) {
                        bVar.b(bVar2.f());
                        com.mbridge.msdk.newreward.function.a.c cVar = this.f10532c;
                        if (cVar != null) {
                            cVar.a(bVar2.g(), bVar2.f(), 2, aVar.i().s());
                        }
                        z4 = z5;
                    } else {
                        com.mbridge.msdk.newreward.function.a.b bVar5 = bVar;
                        i6++;
                        z4 = z5;
                    }
                }
                if (z4) {
                    arrayList.add(bVar2);
                }
            }
        }
        return arrayList;
    }

    public final boolean a(String str) {
        JSONObject a5;
        try {
            com.mbridge.msdk.newreward.function.a.c cVar = this.f10532c;
            if (cVar == null || (a5 = cVar.a(cVar.b(str))) == null || a5.optInt("c_cb", 0) != 1) {
                return false;
            }
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return false;
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, com.mbridge.msdk.newreward.function.a.b bVar, List<a.C0099a> list, JSONObject jSONObject, e eVar, int i5) {
        String str2;
        int i6;
        com.mbridge.msdk.foundation.same.report.d.c cVar2 = cVar;
        String str3 = str;
        List<a.C0099a> list2 = list;
        e eVar2 = eVar;
        int i7 = i5;
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar3 = new com.mbridge.msdk.foundation.same.report.d.e();
            if (i7 == 1) {
                str2 = "cb";
            } else if (i7 == 2) {
                str2 = "candidate";
            } else if (i7 != 3) {
                str2 = EnvironmentCompat.MEDIA_UNKNOWN;
            } else {
                str2 = "track";
            }
            eVar3.a("scene", str2);
            com.mbridge.msdk.newreward.function.a.c cVar3 = this.f10532c;
            if (cVar3 != null) {
                double d5 = cVar3.d(str3);
                if (d5 >= 0.0d) {
                    eVar3.a("bp", z.b(d5 + ""));
                }
                eVar3.a("cb_state", a(str3) ? "open" : CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
                try {
                    com.mbridge.msdk.newreward.function.a.c cVar4 = this.f10532c;
                    JSONObject a5 = cVar4.a(cVar4.b(str3));
                    if (a5 != null) {
                        eVar3.a("config", a5.toString());
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if (bVar != null) {
                if (bVar.h() == com.mbridge.msdk.foundation.b.c.f8793d) {
                    eVar3.a("result", 1);
                } else {
                    eVar3.a("result", 2);
                    eVar3.a("reason", bVar.b());
                }
                eVar3.a("acr", bVar.c());
                eVar3.a("her", bVar.e());
                eVar3.a("nrr", bVar.d());
                eVar3.a("cer", bVar.f());
            } else {
                eVar3.a("result", 2);
                eVar3.a("reason", "candidate result is null");
            }
            if (list2 != null && list2.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                int i8 = 0;
                while (i8 < list2.size()) {
                    com.mbridge.msdk.newreward.function.c.a.b a6 = list2.get(i8).a();
                    if (a6 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        StringBuilder sb = new StringBuilder();
                        i6 = i8;
                        sb.append(a6.s());
                        sb.append("");
                        jSONObject2.put("ecppv", z.b(sb.toString()));
                        jSONObject2.put("showCount", a6.t());
                        jSONObject2.put("intervalTime", System.currentTimeMillis() - a6.I());
                        jSONArray.put(jSONObject2);
                    } else {
                        i6 = i8;
                    }
                    i8 = i6 + 1;
                }
                eVar3.a(DataSchemeDataSource.SCHEME_DATA, jSONArray.toString());
            }
            if (cVar2 != null) {
                cVar2.a("m_candidate_data");
                cVar2.k("m_candidate_data");
                cVar2.a("m_candidate_data", eVar3);
                if (!(bVar == null || bVar.a() == null || eVar2 == null)) {
                    cVar2.b(eVar2.D().a());
                }
            }
            c cVar5 = this.f10531b;
            cVar5.a((Object) eVar2, f.METRICS_KEY_M_CANDIDATE_DATE, (Object) cVar5.a("metrics_data", eVar3));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
