package com.mbridge.msdk.newreward.function.e;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel;
import com.mbridge.msdk.newreward.function.d.c;
import java.io.IOException;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private b f10922a;

    /* renamed from: b  reason: collision with root package name */
    private e f10923b;

    /* renamed from: com.mbridge.msdk.newreward.function.e.a$a  reason: collision with other inner class name */
    private static final class C0103a implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: a  reason: collision with root package name */
        private final e f10925a;

        /* renamed from: b  reason: collision with root package name */
        private final a f10926b;

        /* renamed from: c  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f10927c;

        public C0103a(e eVar, a aVar, com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f10925a = eVar;
            this.f10926b = aVar;
            this.f10927c = bVar;
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f10927c;
            if (bVar2 != null) {
                try {
                    bVar2.reqFailed(bVar);
                } catch (Exception e5) {
                    af.b("CampaignModel", "reqFailed: ", e5);
                }
            }
        }

        public final void reqSuccessful(Object obj) {
            try {
                b bVar = (b) obj;
                bVar.b(this.f10925a.G());
                int Q4 = (int) (((double) this.f10925a.Q()) * 1.2d);
                bVar.f(Q4);
                bVar.g(Q4);
                bVar.b(Math.max(this.f10925a.T(), bVar.p()));
                if (bVar.b() == 0) {
                    this.f10926b.a(bVar);
                    c.a().b().a(bVar);
                }
                if (!TextUtils.isEmpty(bVar.k())) {
                    MBridgeGlobalCommon.SESSION_ID = bVar.k();
                }
                MBridgeSharedPreferenceModel.getInstance().putInteger(String.format(MBridgeCommon.SharedPreference.KEY_VCN, new Object[]{bVar.e()}), bVar.F());
                com.mbridge.msdk.newreward.a.b.b bVar2 = this.f10927c;
                if (bVar2 != null) {
                    bVar2.reqSuccessful(obj);
                }
            } catch (Exception e5) {
                af.b("CampaignModel", "reqSuccessful: ", e5);
                com.mbridge.msdk.newreward.a.b.b bVar3 = this.f10927c;
                if (bVar3 != null) {
                    bVar3.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e5.getMessage()));
                }
            }
        }
    }

    private boolean a(com.mbridge.msdk.newreward.function.c.a.a aVar) {
        CampaignEx h5;
        if (!(aVar == null || (h5 = aVar.h()) == null)) {
            try {
                if (h5.getPlayable_ads_without_video() == 2) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public final b b() {
        return this.f10922a;
    }

    public final boolean c() {
        b bVar = this.f10922a;
        if (bVar == null || !bVar.z()) {
            return false;
        }
        return true;
    }

    public final void b(b bVar) {
        if (bVar != null && bVar.u() != null) {
            Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
            j a5 = j.a((f) g.a(c5));
            for (com.mbridge.msdk.newreward.function.c.a.a h5 : bVar.u()) {
                CampaignEx h6 = h5.h();
                if (h6 != null) {
                    if (!com.mbridge.msdk.e.b.a()) {
                        a(a5, h6);
                    } else if (!ak.c(c5, h6.getPackageName())) {
                        a(a5, h6);
                    }
                }
            }
        }
    }

    public final List<CampaignEx> a() {
        b bVar = this.f10922a;
        if (bVar == null) {
            return null;
        }
        return bVar.E();
    }

    public final void a(b bVar) {
        this.f10922a = bVar;
    }

    public final void a(e eVar, com.mbridge.msdk.newreward.function.f.a aVar, com.mbridge.msdk.newreward.a.b.b bVar) {
        this.f10923b = eVar;
        try {
            new com.mbridge.msdk.newreward.a.b.c(eVar).a(aVar, new C0103a(eVar, this, bVar));
        } catch (IOException e5) {
            if (bVar != null) {
                bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e5.getMessage()));
            }
        }
    }

    public final void a(b bVar, boolean z4) throws MBridgeError {
        boolean z5;
        if (bVar == null || bVar.u() == null) {
            throw new MBridgeError(880003, "Need show campaign list is NULL!");
        }
        for (com.mbridge.msdk.newreward.function.c.a.a next : bVar.u()) {
            CampaignEx h5 = next.h();
            if (!(h5 == null || h5.getOfferType() == 99)) {
                if (a(next)) {
                    z5 = !ap.a(h5.getendcard_url()) || !TextUtils.isEmpty(h5.getMraid());
                    if (next.f() == null && next.e() == null) {
                        throw new MBridgeError(880003, "playable offer endcard or mraid is null");
                    }
                } else {
                    z5 = !ap.a(h5.getVideoUrlEncode());
                    if (next.d() == null) {
                        throw new MBridgeError(880003, "No video campaign");
                    }
                }
                if (z5) {
                    Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
                    if (com.mbridge.msdk.e.b.a() && ak.c(h5)) {
                        h5.setRtinsType(ak.c(c5, h5.getPackageName()) ? 1 : 2);
                    }
                    try {
                        e eVar = this.f10923b;
                        String str = "";
                        if (eVar != null) {
                            if (!(eVar.D() == null || this.f10923b.D().f10922a == null)) {
                                str = this.f10923b.D().f10922a.a() + str;
                            }
                        }
                        com.mbridge.msdk.foundation.same.report.d.c a5 = d.a().a(h5.getLocalRequestId(), str);
                        if (a5 == null) {
                            a5 = new com.mbridge.msdk.foundation.same.report.d.c();
                            a5.c(h5.getLocalRequestId());
                            a5.b(h5.getAdType());
                            a5.d(h5.getCampaignUnitId());
                            a5.i(h5.isBidCampaign() ? "1" : "0");
                        }
                        a5.a(h5);
                        e eVar2 = this.f10923b;
                        if (!(eVar2 == null || eVar2.x() == null)) {
                            com.mbridge.msdk.videocommon.d.a a6 = this.f10923b.x().a();
                            if (a6 != null) {
                                a5.h(a6.b());
                                a5.f(a6.c());
                            }
                            com.mbridge.msdk.videocommon.d.c b5 = this.f10923b.x().b();
                            if (b5 != null) {
                                a5.g(b5.l());
                                a5.n(b5.k());
                            }
                        }
                        com.mbridge.msdk.foundation.same.c.a(h5, com.mbridge.msdk.foundation.controller.c.m().c(), a5, new c.a() {
                            public final void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
                                d.a().a(str, cVar);
                            }
                        });
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                    if (z4) {
                        continue;
                    } else if (com.mbridge.msdk.foundation.same.c.b(c5, h5) == 0) {
                        next.b(true);
                        ak.a(bVar.e(), h5, com.mbridge.msdk.foundation.same.a.f9205x);
                        this.f10923b.a(h5.getId());
                        throw new MBridgeError(880021, "APP ALREADY INSTALLED");
                    } else if (com.mbridge.msdk.foundation.same.c.b(c5, h5) == 1) {
                        next.b(false);
                        if (bVar.a() > 0) {
                            ak.a(bVar.e(), h5, com.mbridge.msdk.foundation.same.a.f9205x);
                            this.f10923b.a(h5.getId());
                            throw new MBridgeError(880021, "FILTER BUT CALLBACK SUCCEED");
                        }
                    } else if (com.mbridge.msdk.foundation.same.c.b(c5, h5) == 2) {
                        next.b(false);
                        ak.a(bVar.e(), h5, com.mbridge.msdk.foundation.same.a.f9205x);
                        throw new MBridgeError(880003, "campaign is exception");
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private void a(j jVar, CampaignEx campaignEx) {
        if (jVar != null && !jVar.b(campaignEx.getId())) {
            com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
            gVar.a(campaignEx.getId());
            gVar.b(campaignEx.getFca());
            gVar.c(campaignEx.getFcb());
            gVar.a(0);
            gVar.d(0);
            gVar.a(System.currentTimeMillis());
            jVar.a(gVar);
        }
    }
}
