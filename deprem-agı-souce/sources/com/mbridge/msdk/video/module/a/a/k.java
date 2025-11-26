package com.mbridge.msdk.video.module.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class k extends f {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f12581a;

    /* renamed from: b  reason: collision with root package name */
    protected CampaignEx f12582b;

    /* renamed from: c  reason: collision with root package name */
    protected List<CampaignEx> f12583c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f12584d = false;

    /* renamed from: e  reason: collision with root package name */
    protected a f12585e;

    /* renamed from: f  reason: collision with root package name */
    protected c f12586f;

    /* renamed from: g  reason: collision with root package name */
    protected String f12587g;

    /* renamed from: h  reason: collision with root package name */
    protected String f12588h;

    /* renamed from: i  reason: collision with root package name */
    protected com.mbridge.msdk.video.module.a.a f12589i = new f();

    /* renamed from: j  reason: collision with root package name */
    protected int f12590j = 1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12591k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12592l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f12593m = false;

    public k(CampaignEx campaignEx, a aVar, c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i5, boolean z4) {
        if (!z4 && campaignEx != null && ap.b(str2) && aVar != null && aVar2 != null) {
            this.f12582b = campaignEx;
            this.f12588h = str;
            this.f12587g = str2;
            this.f12585e = aVar;
            this.f12586f = cVar;
            this.f12589i = aVar2;
            this.f12581a = true;
            this.f12590j = i5;
            this.f12584d = false;
        } else if (z4 && campaignEx != null && ap.b(str2) && aVar2 != null) {
            this.f12582b = campaignEx;
            this.f12588h = str;
            this.f12587g = str2;
            this.f12585e = aVar;
            this.f12586f = cVar;
            this.f12589i = aVar2;
            this.f12581a = true;
            this.f12590j = i5;
            this.f12584d = true;
        }
    }

    public final void a(CampaignEx campaignEx) {
        this.f12582b = campaignEx;
    }

    public final void b(int i5) {
        CampaignEx campaignEx = this.f12582b;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (TextUtils.isEmpty(noticeUrl)) {
                return;
            }
            if (i5 == 1 || i5 == 2) {
                if (!noticeUrl.contains("endscreen_type")) {
                    StringBuilder sb = new StringBuilder(noticeUrl);
                    if (noticeUrl.contains("?")) {
                        sb.append("&endscreen_type=");
                        sb.append(i5);
                    } else {
                        sb.append("?endscreen_type=");
                        sb.append(i5);
                    }
                    noticeUrl = sb.toString();
                } else if (i5 == 2) {
                    if (noticeUrl.contains("endscreen_type=1")) {
                        noticeUrl = noticeUrl.replace("endscreen_type=1", "endscreen_type=2");
                    }
                } else if (noticeUrl.contains("endscreen_type=2")) {
                    noticeUrl = noticeUrl.replace("endscreen_type=2", "endscreen_type=1");
                }
                this.f12582b.setNoticeUrl(noticeUrl);
            }
        }
    }

    public final void c() {
        try {
            AnonymousClass2 r02 = new Runnable() {
                public final void run() {
                    try {
                        k kVar = k.this;
                        if (kVar.f12581a && kVar.f12582b != null && ap.b(kVar.f12587g)) {
                            com.mbridge.msdk.videocommon.a.a a5 = com.mbridge.msdk.videocommon.a.a.a();
                            k kVar2 = k.this;
                            a5.a(kVar2.f12582b, kVar2.f12587g);
                        }
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                    try {
                        com.mbridge.msdk.videocommon.a.a a6 = com.mbridge.msdk.videocommon.a.a.a();
                        k kVar3 = k.this;
                        a6.c(kVar3.f12588h, kVar3.f12582b.getAdType());
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            e6.printStackTrace();
                        }
                    } catch (Throwable th) {
                        af.a("NotifyListener", th.getMessage());
                    }
                }
            };
            d.a();
            com.mbridge.msdk.foundation.same.f.a.b().execute(r02);
        } catch (Throwable th) {
            af.b("NotifyListener", th.getMessage(), th);
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        a aVar = this.f12585e;
        if (aVar != null) {
            aVar.f(true);
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        CampaignEx campaignEx;
        Map<String, Long> map;
        String str;
        try {
            CampaignEx campaignEx2 = this.f12582b;
            if (campaignEx2 != null && campaignEx2.isDynamicView() && this.f12584d && !this.f12582b.isCampaignIsFiltered()) {
                this.f12592l = true;
            } else if (this.f12581a && (campaignEx = this.f12582b) != null && !TextUtils.isEmpty(campaignEx.getOnlyImpressionURL()) && (map = b.f9221k) != null && !map.containsKey(this.f12582b.getOnlyImpressionURL()) && !this.f12592l) {
                b.f9221k.put(this.f12582b.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
                String onlyImpressionURL = this.f12582b.getOnlyImpressionURL();
                if (this.f12582b.getSpareOfferFlag() == 1) {
                    str = onlyImpressionURL + "&to=1&cbt=" + this.f12582b.getCbt() + "&tmorl=" + this.f12590j;
                } else {
                    str = onlyImpressionURL + "&to=0&cbt=" + this.f12582b.getCbt() + "&tmorl=" + this.f12590j;
                }
                String str2 = str;
                if (!this.f12584d || this.f12582b.isCampaignIsFiltered()) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f12582b, this.f12587g, str2, false, true, com.mbridge.msdk.click.a.a.f8070h);
                    c();
                }
                this.f12592l = true;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void f() {
        String str;
        try {
            if (this.f12581a && !this.f12591k && !TextUtils.isEmpty(this.f12582b.getImpressionURL())) {
                this.f12591k = true;
                if (this.f12582b.isBidCampaign() && this.f12582b != null) {
                    HashMap hashMap = new HashMap();
                    List<com.mbridge.msdk.foundation.entity.d> a5 = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(this.f12582b.getCampaignUnitId(), this.f12582b.getRequestId());
                    if (!(a5 == null || a5.size() <= 0 || a5.get(0) == null)) {
                        if (a5.get(0).c() == 1) {
                            hashMap.put("encrypt_p=", "encrypt_p=" + a5.get(0).b());
                            hashMap.put("irlfa=", "irlfa=" + 1);
                            for (Map.Entry entry : hashMap.entrySet()) {
                                String str2 = (String) entry.getKey();
                                String str3 = (String) entry.getValue();
                                CampaignEx campaignEx = this.f12582b;
                                campaignEx.setImpressionURL(campaignEx.getImpressionURL().replaceAll(str2, str3));
                                CampaignEx campaignEx2 = this.f12582b;
                                campaignEx2.setOnlyImpressionURL(campaignEx2.getOnlyImpressionURL().replaceAll(str2, str3));
                            }
                        }
                        af.a("BidReplaceCampignDao", "removeReplace count " + com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(this.f12582b.getRequestId()));
                    }
                }
                String impressionURL = this.f12582b.getImpressionURL();
                if (this.f12582b.getSpareOfferFlag() == 1) {
                    str = impressionURL + "&to=1&cbt=" + this.f12582b.getCbt() + "&tmorl=" + this.f12590j;
                } else {
                    str = impressionURL + "&to=0&cbt=" + this.f12582b.getCbt() + "&tmorl=" + this.f12590j;
                }
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f12582b, this.f12587g, str, false, true, com.mbridge.msdk.click.a.a.f8069g);
                com.mbridge.msdk.video.module.b.b.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f12582b);
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            j.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(k.this.f12582b.getId());
                        } catch (Throwable th) {
                            af.b("NotifyListener", th.getMessage(), th);
                        }
                    }
                }).start();
                if (this.f12581a && b.f9220j != null && !TextUtils.isEmpty(this.f12582b.getId())) {
                    b.a(this.f12587g, this.f12582b, "reward");
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        } catch (Throwable th) {
            af.b("NotifyListener", th.getMessage(), th);
        }
    }

    /* access modifiers changed from: protected */
    public final void g() {
        CampaignEx campaignEx;
        try {
            if (this.f12581a && !this.f12593m && (campaignEx = this.f12582b) != null) {
                this.f12593m = true;
                if (!campaignEx.isDynamicView() || !this.f12584d || this.f12582b.isCampaignIsFiltered()) {
                    List<String> pv_urls = this.f12582b.getPv_urls();
                    if (pv_urls != null && pv_urls.size() > 0) {
                        for (String a5 : pv_urls) {
                            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f12582b, this.f12587g, a5, false, true);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            af.b("NotifyListener", th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void h() {
        CampaignEx campaignEx = this.f12582b;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCampaignUnitId()) && this.f12582b.getNativeVideoTracking() != null && this.f12582b.getNativeVideoTracking().o() != null) {
            Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
            CampaignEx campaignEx2 = this.f12582b;
            com.mbridge.msdk.click.a.a(c5, campaignEx2, campaignEx2.getCampaignUnitId(), this.f12582b.getNativeVideoTracking().o(), false, false);
        }
    }

    public final void a(List<CampaignEx> list) {
        this.f12583c = list;
    }

    public void a(int i5, Object obj) {
        super.a(i5, obj);
        this.f12589i.a(i5, obj);
    }

    public final void a(int i5) {
        if (this.f12582b == null) {
            return;
        }
        if (i5 == 1 || i5 == 2) {
            com.mbridge.msdk.video.module.b.b.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f12582b, i5, this.f12590j);
        }
    }

    public final void a() {
        if (this.f12581a && this.f12582b != null) {
            n nVar = new n("2000061", this.f12582b.getId(), this.f12582b.getRequestId(), this.f12582b.getRequestIdNotice(), this.f12587g, ab.m(com.mbridge.msdk.foundation.controller.c.m().c()));
            nVar.d(this.f12582b.isMraid() ? n.f9116a : n.f9117b);
            com.mbridge.msdk.foundation.same.report.g.b(nVar, com.mbridge.msdk.foundation.controller.c.m().c(), this.f12587g);
        }
    }

    public final void a(int i5, String str) {
        if (this.f12582b != null) {
            com.mbridge.msdk.foundation.same.report.g.c(new n("2000062", this.f12582b.getId(), this.f12582b.getRequestId(), this.f12582b.getRequestIdNotice(), this.f12587g, ab.m(com.mbridge.msdk.foundation.controller.c.m().c()), i5, str), com.mbridge.msdk.foundation.controller.c.m().c(), this.f12587g);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        try {
            if (this.f12582b != null) {
                e eVar = new e();
                eVar.a("url", this.f12582b.getVideoUrlEncode());
                eVar.a("reason", str);
                String noticeUrl = this.f12582b.getNoticeUrl();
                String clickURL = this.f12582b.getClickURL();
                if (!TextUtils.isEmpty(noticeUrl)) {
                    eVar.a("offer_url", noticeUrl);
                } else if (!TextUtils.isEmpty(clickURL)) {
                    eVar.a("offer_url", clickURL);
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000021", this.f12582b, eVar);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void b() {
        AnonymousClass1 r02 = new Runnable() {
            public final void run() {
                try {
                    k kVar = k.this;
                    if (kVar.f12581a && kVar.f12582b != null && ap.b(kVar.f12587g) && com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                        i a5 = i.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                        com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
                        fVar.a(System.currentTimeMillis());
                        fVar.b(k.this.f12587g);
                        fVar.a(k.this.f12582b.getId());
                        a5.a(fVar);
                    }
                } catch (Throwable th) {
                    af.b("NotifyListener", th.getMessage(), th);
                }
            }
        };
        d.a();
        com.mbridge.msdk.foundation.same.f.a.b().execute(r02);
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        List<CampaignEx> list;
        if (this.f12582b != null && (list = this.f12583c) != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("camp_position")) {
                    this.f12582b = this.f12583c.get(jSONObject.getInt("camp_position"));
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NotifyListener", e5.getMessage());
                }
            }
        }
    }
}
