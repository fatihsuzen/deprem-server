package com.mbridge.msdk.foundation.same.report.d;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.d.a.a;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.tracker.e;
import com.mbridge.msdk.tracker.m;
import com.mbridge.msdk.tracker.network.toolbox.h;
import com.mbridge.msdk.tracker.o;
import com.mbridge.msdk.tracker.v;
import com.mbridge.msdk.tracker.w;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f9500a;

    /* renamed from: b  reason: collision with root package name */
    private volatile m f9501b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, e> f9502c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private LinkedHashMap<String, c> f9503d = new LinkedHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private Map<String, e> f9504e = new HashMap();

    private d() {
        if (this.f9501b == null) {
            this.f9501b = m.a("metrics_sdk", c.m().c(), d());
        }
        JSONObject a5 = com.mbridge.msdk.foundation.same.report.c.a();
        if (this.f9501b != null) {
            this.f9501b.a(a5);
            this.f9501b.a();
        }
    }

    private w d() {
        o oVar;
        try {
            int a5 = ah.a().a("metrics", "t_m_e_t", ah.a().a("t_m_e_t", 604800000));
            int a6 = ah.a().a("metrics", "t_m_e_s", ah.a().a("t_m_e_s", 50));
            int a7 = ah.a().a("metrics", "t_m_r_c", ah.a().a("t_m_r_c", 50));
            int a8 = ah.a().a("metrics", "t_m_t", ah.a().a("t_m_t", (int) DefaultLoadControl.DEFAULT_MIN_BUFFER_MS));
            int a9 = ah.a().a("metrics", "t_m_r_t_s", ah.a().a("t_m_r_t_s", 2));
            int a10 = ah.a().a("metrics", "t_r_t", ah.a().a("t_r_t", 1));
            if (!(a10 == 0 || a10 == 1)) {
                a10 = 0;
            }
            w.a a11 = new w.a().e(a5).a(a6).d(a7).b(a8).c(a9).a((com.mbridge.msdk.tracker.d) new com.mbridge.msdk.foundation.same.report.d()).a(com.mbridge.msdk.foundation.same.report.c.b()).a((v) new com.mbridge.msdk.foundation.same.report.m());
            if (a10 == 1) {
                oVar = new o(new l((byte) 2), com.mbridge.msdk.foundation.same.net.e.d.f().f9374i, com.mbridge.msdk.foundation.same.net.e.d.f().f9378m);
            } else {
                oVar = new o(new h(), com.mbridge.msdk.foundation.same.net.e.d.f().f9368c, 0);
            }
            return a11.a(a10, oVar).a();
        } catch (Exception e5) {
            af.b("EventLibraryReport", "configTrackManager error: " + e5.getMessage());
            return null;
        }
    }

    public final void a(c cVar) {
        if (cVar != null) {
            try {
                if (this.f9502c != null) {
                    e eVar = new e();
                    eVar.a("rs_rid", cVar.k());
                    eVar.a("r_stid", cVar.m());
                    eVar.a("rus_rid", cVar.l());
                    eVar.a("u_stid", cVar.t());
                    this.f9502c.put(cVar.i(), eVar);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void b(String str, e eVar) {
        try {
            c cVar = new c();
            if (eVar.b(MBridgeConstans.PROPERTIES_UNIT_ID) != null) {
                cVar.d(String.valueOf(eVar.b(MBridgeConstans.PROPERTIES_UNIT_ID)));
            }
            if (eVar.b("lrid") != null && (eVar.b("lrid") instanceof String)) {
                cVar.c(String.valueOf(eVar.b("lrid")));
            }
            cVar.a(str, eVar);
            new f().b(str, c(), cVar, (a) null);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public final m c() {
        try {
            JSONObject a5 = com.mbridge.msdk.foundation.same.report.c.a();
            if (this.f9501b == null) {
                this.f9501b = m.a("metrics_sdk", c.m().c(), d());
                if (this.f9501b != null) {
                    this.f9501b.a(a5);
                    this.f9501b.a();
                }
            } else {
                this.f9501b.a(a5);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return this.f9501b;
    }

    public final e a(String str) {
        Map<String, e> map;
        e eVar = new e();
        try {
            if (!TextUtils.isEmpty(str) && (map = this.f9502c) != null && map.containsKey(str)) {
                return this.f9502c.get(str);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return eVar;
    }

    private void b(String str, c cVar, a aVar) {
        try {
            if (Arrays.asList(b.f9461c).contains(str)) {
                cVar.m(str);
            }
            Map<String, e> map = this.f9504e;
            if (map != null && map.containsKey(str)) {
                cVar.a(str, this.f9504e.get(str));
            }
            new f().a(str, c(), cVar, aVar);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public final void c(String str) {
        try {
            JSONObject a5 = com.mbridge.msdk.foundation.same.c.a(str);
            if (a5 == null) {
                return;
            }
            if (a5.length() != 0) {
                String optString = a5.optString("key");
                if (!TextUtils.isEmpty(optString)) {
                    e eVar = new e(optString);
                    eVar.b(0);
                    eVar.a(0);
                    eVar.a(com.mbridge.msdk.foundation.same.report.c.c());
                    eVar.a(a5);
                    m c5 = a().c();
                    if (c5 != null && c5.e()) {
                        c5.a(eVar);
                    }
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("EventLibraryReport", "reportByTrackManager error: " + e5.getMessage());
            }
        }
    }

    public final void a(String str, e eVar) {
        Map<String, e> map = this.f9504e;
        if (map != null) {
            map.put(str, eVar);
        }
    }

    public final e a(int i5, int i6, String str, boolean z4, int i7) {
        e eVar = new e();
        try {
            eVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(i5));
            eVar.a("adtp", Integer.valueOf(i6));
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            if (z4) {
                eVar.a("auto_load", Integer.valueOf(i7));
                return eVar;
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return eVar;
    }

    public final LinkedHashMap<String, c> b() {
        return this.f9503d;
    }

    public final void b(String str) {
        b(str, "");
    }

    public final void b(String str, String str2) {
        LinkedHashMap<String, c> linkedHashMap;
        try {
            String str3 = str + str2;
            if (!TextUtils.isEmpty(str3) && (linkedHashMap = this.f9503d) != null) {
                if (linkedHashMap.containsKey(str3)) {
                    this.f9503d.remove(str3);
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public static d a() {
        if (f9500a == null) {
            synchronized (d.class) {
                try {
                    if (f9500a == null) {
                        f9500a = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9500a;
    }

    public final c b(c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            return (c) cVar.clone();
        } catch (CloneNotSupportedException e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return null;
        }
    }

    public final void a(String str, CampaignEx campaignEx, e eVar) {
        c cVar;
        String str2 = "";
        if (campaignEx != null) {
            try {
                str2 = campaignEx.getLocalRequestId();
                cVar = this.f9503d.get(str2);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                    return;
                }
                return;
            }
        } else {
            cVar = null;
        }
        if (cVar == null) {
            cVar = new c();
        } else if (Arrays.asList(b.f9466h).contains(str)) {
            cVar = b(cVar);
        }
        cVar.a(campaignEx);
        cVar.c(str2);
        cVar.a(str, eVar);
        b(str, cVar, (a) null);
    }

    public final void a(String str, CampaignEx campaignEx) {
        String str2 = "";
        if (campaignEx != null) {
            try {
                str2 = campaignEx.getCurrentLocalRid();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                    return;
                }
                return;
            }
        }
        c cVar = this.f9503d.get(str2);
        if (cVar == null) {
            cVar = new c();
        }
        if (cVar.h() != null && !cVar.h().isEmpty() && campaignEx != null) {
            int i5 = 0;
            while (true) {
                if (i5 >= cVar.h().size()) {
                    break;
                } else if (cVar.h().get(i5).getId().equals(campaignEx.getId())) {
                    cVar.h().set(i5, campaignEx);
                    break;
                } else {
                    i5++;
                }
            }
        }
        cVar.a(campaignEx);
        cVar.c(str2);
        b(str, cVar, (a) null);
    }

    public final void a(String str, List<CampaignEx> list, e eVar) {
        CampaignEx campaignEx;
        String str2 = "";
        if (list != null) {
            try {
                if (list.size() > 0 && (campaignEx = list.get(0)) != null) {
                    str2 = campaignEx.getCurrentLocalRid();
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                    return;
                }
                return;
            }
        }
        c cVar = this.f9503d.get(str2);
        if (cVar == null) {
            cVar = new c();
        }
        cVar.b(list);
        if (list != null && list.size() > 0) {
            cVar.c(list.get(0).getCurrentLocalRid());
        }
        cVar.a(str, eVar);
        b(str, cVar, (a) null);
    }

    public final void a(String str, c cVar, a aVar) {
        b(str, cVar, aVar);
    }

    public final void a(n nVar, CampaignEx campaignEx) {
        e eVar = new e();
        eVar.a("result", Integer.valueOf(nVar.m()));
        eVar.a("scenes", nVar.b("scenes", ""));
        eVar.a("resource_type", Integer.valueOf(nVar.F()));
        eVar.a("url", nVar.b("url", ""));
        eVar.a("reason", nVar.h());
        eVar.a("mraid_type", Integer.valueOf(nVar.B()));
        a().a(nVar.a(), campaignEx, eVar);
    }

    public final void a(String str, c cVar) {
        try {
            Map<String, e> map = this.f9504e;
            if (!(map == null || !map.containsKey(str) || cVar == null)) {
                cVar.a(str, this.f9504e.get(str));
            }
            new f().a(str, c(), cVar, (a) null);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public final void a(String str, c cVar, CampaignEx campaignEx, Context context, a aVar) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (cVar == null) {
                    cVar = new c();
                }
                e eVar = new e();
                eVar.a("st", Long.valueOf(System.currentTimeMillis()));
                if (campaignEx != null) {
                    eVar.a("cid", campaignEx.getId());
                    eVar.a("lrid", campaignEx.getLocalRequestId());
                    eVar.a("rid", campaignEx.getRequestId());
                    eVar.a("rid_n", campaignEx.getRequestIdNotice());
                    eVar.a("adtp", Integer.valueOf(campaignEx.getAdType()));
                    if (!eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                        eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, campaignEx.getCampaignUnitId());
                    }
                    eVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(campaignEx.isBidCampaign() ? 1 : 0));
                    eVar.a("bid_tk", campaignEx.getBidToken());
                }
                if (context != null) {
                    eVar.a("network_type", Integer.valueOf(ab.m(context)));
                }
                cVar.a(str, eVar);
                b(str, cVar, aVar);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public final c a(String str, String str2) {
        LinkedHashMap<String, c> linkedHashMap;
        try {
            String str3 = str + str2;
            if (!TextUtils.isEmpty(str3) && (linkedHashMap = this.f9503d) != null) {
                if (linkedHashMap.containsKey(str3)) {
                    return this.f9503d.get(str3);
                }
            }
            return null;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return null;
        }
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    String optString = jSONObject.optString("key");
                    if (!TextUtils.isEmpty(optString)) {
                        e eVar = new e(optString);
                        eVar.b(0);
                        eVar.a(0);
                        eVar.a(com.mbridge.msdk.foundation.same.report.c.c());
                        eVar.a(jSONObject);
                        m c5 = a().c();
                        if (c5 != null && c5.e()) {
                            c5.a(eVar);
                        }
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("EventLibraryReport", "reportByTrackManager error: " + e5.getMessage());
                }
            }
        }
    }
}
