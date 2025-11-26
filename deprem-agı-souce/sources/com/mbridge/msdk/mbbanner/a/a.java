package com.mbridge.msdk.mbbanner.a;

import android.text.TextUtils;
import android.view.View;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.as;
import com.mbridge.msdk.mbbanner.common.b.b;
import com.mbridge.msdk.mbbanner.common.c.c;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.List;

public final class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f9887a = "BannerController";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f9888b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f9889c;

    /* renamed from: d  reason: collision with root package name */
    private String f9890d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public MBridgeIds f9891e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9892f;

    /* renamed from: g  reason: collision with root package name */
    private int f9893g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public MBBannerView f9894h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f9895i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f9896j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f9897k;

    /* renamed from: l  reason: collision with root package name */
    private int f9898l = -1;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public BannerAdListener f9899m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public CampaignUnit f9900n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public c f9901o;

    /* renamed from: p  reason: collision with root package name */
    private k f9902p;

    /* renamed from: q  reason: collision with root package name */
    private j f9903q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f9904r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f9905s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f9906t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public boolean f9907u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f9908v;

    /* renamed from: w  reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.c f9909w = new com.mbridge.msdk.mbbanner.common.b.c() {
        public final void a(List<CampaignEx> list) {
            af.b(a.f9887a, "onShowSuccessed:");
            if (a.this.f9899m != null) {
                a.this.f9899m.onLoadSuccessed(a.this.f9891e);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(a.this.f9888b, list.get(0).getLocalRequestId());
                a5.b(list);
                int i5 = 1;
                a5.g(1);
                if (TextUtils.isEmpty(list.get(0).getBannerUrl())) {
                    i5 = 2;
                }
                a5.f(i5);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000048", a5, (e) null);
            } catch (Exception e5) {
                af.b(a.f9887a, e5.getMessage());
            }
        }

        public final void b() {
            if (a.this.f9899m != null) {
                a.this.f9899m.onLeaveApp(a.this.f9891e);
            }
        }

        public final void c() {
            if (a.this.f9899m != null) {
                a.this.f9899m.showFullScreen(a.this.f9891e);
                boolean unused = a.this.f9908v = true;
                com.mbridge.msdk.mbbanner.common.c.a.a().a(2, a.this.f9889c, a.this.f9888b, (com.mbridge.msdk.mbbanner.common.a.a) null, (b) null);
            }
        }

        public final void d() {
            if (a.this.f9899m != null) {
                a.this.f9899m.closeFullScreen(a.this.f9891e);
                boolean unused = a.this.f9908v = false;
                com.mbridge.msdk.mbbanner.common.c.a a5 = com.mbridge.msdk.mbbanner.common.c.a.a();
                String f5 = a.this.f9889c;
                String c5 = a.this.f9888b;
                a5.a(3, f5, c5, new com.mbridge.msdk.mbbanner.common.a.a(a.this.f9896j + "x" + a.this.f9895i, a.this.f9897k * 1000), a.this.f9910x);
            }
        }

        public final void e() {
            if (a.this.f9899m != null) {
                a.this.f9899m.onCloseBanner(a.this.f9891e);
            }
        }

        public final void a(CampaignEx campaignEx) {
            a.this.d();
            if (a.this.f9899m != null) {
                a.this.f9899m.onLogImpression(a.this.f9891e);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(a.this.f9888b, campaignEx.getLocalRequestId());
                a5.a(campaignEx);
                a5.i(campaignEx.isBidCampaign() ? "1" : "2");
                int i5 = 1;
                a5.g(a.this.f9901o != null ? a.this.f9901o.b() : 1);
                if (a.this.f9897k != 0) {
                    i5 = 2;
                }
                a5.d(i5);
                a5.e(a.this.f9897k);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000128", a5, (e) null);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000130", a5, (e) null);
            } catch (Exception e5) {
                af.b(a.f9887a, e5.getMessage());
            }
        }

        public final void a(com.mbridge.msdk.foundation.c.b bVar) {
            a.this.a(bVar);
        }

        public final void a() {
            if (a.this.f9899m != null) {
                a.this.f9899m.onClick(a.this.f9891e);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public b f9910x = new b() {
        public final void a(String str, CampaignUnit campaignUnit, boolean z4) {
            CampaignUnit unused = a.this.f9900n = campaignUnit;
            a.a(a.this, 1, (com.mbridge.msdk.foundation.c.b) null);
        }

        public final void b(com.mbridge.msdk.foundation.c.b bVar) {
            a.this.a(bVar.f(), bVar);
            a.this.d();
        }

        public final void a(com.mbridge.msdk.foundation.c.b bVar) {
            a.a(a.this, 2, bVar);
            a.this.a(bVar.f(), bVar);
            a.this.d();
        }

        public final void a(String str, int i5, boolean z4) {
            if (a.this.f9894h != null) {
                boolean unused = a.this.f9907u = true;
                a.this.i();
            }
        }
    };

    public a(MBBannerView mBBannerView, BannerSize bannerSize, String str, String str2) {
        this.f9894h = mBBannerView;
        if (bannerSize != null) {
            this.f9895i = bannerSize.getHeight();
            this.f9896j = bannerSize.getWidth();
        }
        this.f9888b = str2;
        str = TextUtils.isEmpty(str) ? "" : str;
        this.f9889c = str;
        this.f9891e = new MBridgeIds(str, this.f9888b);
        String k5 = com.mbridge.msdk.foundation.controller.c.m().k();
        String b5 = com.mbridge.msdk.foundation.controller.c.m().b();
        if (this.f9903q == null) {
            this.f9903q = new j();
        }
        this.f9903q.a(com.mbridge.msdk.foundation.controller.c.m().c(), k5, b5, this.f9888b);
        h();
    }

    private int b(int i5) {
        if (i5 > 0) {
            if (i5 < 10) {
                return 10;
            }
            if (i5 > 180) {
                return SubsamplingScaleImageView.ORIENTATION_180;
            }
        }
        return i5;
    }

    private void h() {
        k d5 = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f9888b);
        this.f9902p = d5;
        if (d5 == null) {
            this.f9902p = k.d(this.f9888b);
        }
        if (this.f9898l == -1) {
            this.f9897k = b(this.f9902p.q());
        }
        if (this.f9893g == 0) {
            boolean z4 = true;
            if (this.f9902p.f() != 1) {
                z4 = false;
            }
            this.f9892f = z4;
            c cVar = this.f9901o;
            if (cVar != null) {
                cVar.a(z4);
            }
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        if (!this.f9906t && this.f9907u) {
            MBBannerView mBBannerView = this.f9894h;
            if (this.f9900n != null) {
                if (this.f9901o == null) {
                    this.f9901o = new c(mBBannerView, this.f9909w, this.f9889c, this.f9888b, this.f9892f, this.f9902p);
                }
                this.f9901o.a(this.f9890d);
                this.f9901o.b(this.f9904r);
                this.f9901o.c(this.f9905s);
                this.f9901o.a(this.f9892f, this.f9893g);
                this.f9901o.a(this.f9900n);
            } else {
                a(new com.mbridge.msdk.foundation.c.b(880043));
            }
            this.f9907u = false;
        }
    }

    private void j() {
        MBBannerView mBBannerView = this.f9894h;
        if (mBBannerView != null) {
            if (!this.f9904r || !this.f9905s || this.f9908v || as.a((View) mBBannerView, 1)) {
                com.mbridge.msdk.mbbanner.common.c.a.a().a(2, this.f9889c, this.f9888b, (com.mbridge.msdk.mbbanner.common.a.a) null, (b) null);
            } else {
                com.mbridge.msdk.mbbanner.common.c.a a5 = com.mbridge.msdk.mbbanner.common.c.a.a();
                String str = this.f9889c;
                String str2 = this.f9888b;
                a5.a(3, str, str2, new com.mbridge.msdk.mbbanner.common.a.a(this.f9896j + "x" + this.f9895i, this.f9897k * 1000), this.f9910x);
            }
            if (!this.f9904r) {
                com.mbridge.msdk.mbbanner.common.c.a.a().a(4, this.f9889c, this.f9888b, (com.mbridge.msdk.mbbanner.common.a.a) null, (b) null);
                com.mbridge.msdk.mbbanner.common.c.a.a().a(this.f9888b);
            }
        }
    }

    private void k() {
        j();
        c cVar = this.f9901o;
        if (cVar != null) {
            cVar.b(this.f9904r);
            this.f9901o.c(this.f9905s);
        }
    }

    public final void c() {
        this.f9906t = true;
        if (this.f9899m != null) {
            this.f9899m = null;
        }
        if (this.f9910x != null) {
            this.f9910x = null;
        }
        if (this.f9909w != null) {
            this.f9909w = null;
        }
        if (this.f9894h != null) {
            this.f9894h = null;
        }
        com.mbridge.msdk.mbbanner.common.c.a.a().a(4, this.f9889c, this.f9888b, (com.mbridge.msdk.mbbanner.common.a.a) null, (b) null);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(this.f9888b);
        com.mbridge.msdk.mbbanner.common.c.a.a().b();
        c cVar = this.f9901o;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void d() {
        if (!this.f9906t) {
            j();
            h();
            com.mbridge.msdk.mbbanner.common.a.a aVar = new com.mbridge.msdk.mbbanner.common.a.a(this.f9896j + "x" + this.f9895i, this.f9897k * 1000);
            aVar.b(this.f9889c);
            aVar.a(true);
            aVar.c(com.mbridge.msdk.mbbanner.common.d.a.a(""));
            com.mbridge.msdk.mbbanner.common.c.a.a().b(this.f9889c, this.f9888b, aVar, this.f9910x);
        }
    }

    public final void e() {
        com.mbridge.msdk.mbbanner.common.c.a a5 = com.mbridge.msdk.mbbanner.common.c.a.a();
        String str = this.f9889c;
        String str2 = this.f9888b;
        a5.a(4, str, str2, new com.mbridge.msdk.mbbanner.common.a.a(this.f9896j + "x" + this.f9895i, this.f9897k * 1000), this.f9910x);
    }

    public final void f() {
        com.mbridge.msdk.mbbanner.common.c.a a5 = com.mbridge.msdk.mbbanner.common.c.a.a();
        String str = this.f9889c;
        String str2 = this.f9888b;
        a5.a(3, str, str2, new com.mbridge.msdk.mbbanner.common.a.a(this.f9896j + "x" + this.f9895i, this.f9897k * 1000), this.f9910x);
    }

    public final String b() {
        CampaignUnit campaignUnit = this.f9900n;
        if (campaignUnit != null) {
            return com.mbridge.msdk.foundation.same.c.a((List<CampaignEx>) campaignUnit.getAds());
        }
        return "";
    }

    public final String a() {
        CampaignUnit campaignUnit = this.f9900n;
        if (campaignUnit == null || campaignUnit.getRequestId() == null) {
            return "";
        }
        return this.f9900n.getRequestId();
    }

    public final void b(boolean z4) {
        this.f9904r = z4;
        k();
        i();
    }

    /* access modifiers changed from: private */
    public void a(String str, com.mbridge.msdk.foundation.c.b bVar) {
        CampaignUnit campaignUnit;
        String str2 = "";
        if (bVar != null) {
            try {
                str2 = bVar.b();
                if (TextUtils.isEmpty(str)) {
                    str = bVar.f();
                }
            } catch (Throwable th) {
                af.b(f9887a, th.getMessage());
            }
        }
        if (TextUtils.isEmpty(str) && (campaignUnit = this.f9900n) != null) {
            str = campaignUnit.getLocalRequestId();
        }
        com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(this.f9888b, str);
        CampaignUnit campaignUnit2 = this.f9900n;
        a5.b((List<CampaignEx>) campaignUnit2 != null ? campaignUnit2.getAds() : null);
        a5.a(bVar);
        CampaignUnit campaignUnit3 = this.f9900n;
        if (campaignUnit3 != null && !campaignUnit3.getAds().isEmpty()) {
            a5.f(TextUtils.isEmpty(this.f9900n.getAds().get(0).getBannerUrl()) ? 1 : 2);
        }
        a5.c(true);
        com.mbridge.msdk.mbbanner.common.d.a.a("2000047", a5, (e) null);
        BannerAdListener bannerAdListener = this.f9899m;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.f9891e, str2);
        }
    }

    public final void c(boolean z4) {
        this.f9905s = z4;
        k();
    }

    public final void a(BannerSize bannerSize) {
        if (bannerSize != null) {
            this.f9895i = bannerSize.getHeight();
            this.f9896j = bannerSize.getWidth();
        }
    }

    public final void a(int i5) {
        int b5 = b(i5);
        this.f9898l = b5;
        this.f9897k = b5;
    }

    public final void a(boolean z4) {
        this.f9892f = z4;
        this.f9893g = z4 ? 1 : 2;
    }

    public final void a(String str, String str2) {
        boolean z4;
        if (this.f9895i < 1 || this.f9896j < 1) {
            a(str2, new com.mbridge.msdk.foundation.c.b(880037));
            return;
        }
        try {
            z4 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(com.mbridge.msdk.foundation.controller.c.m().c());
        } catch (Exception e5) {
            af.b(f9887a, e5.getMessage());
            z4 = false;
        }
        if (!z4) {
            a(str2, new com.mbridge.msdk.foundation.c.b(880029));
            return;
        }
        this.f9890d = str2;
        com.mbridge.msdk.mbbanner.common.a.a aVar = new com.mbridge.msdk.mbbanner.common.a.a(this.f9896j + "x" + this.f9895i, this.f9897k * 1000);
        aVar.a(str);
        aVar.b(this.f9889c);
        aVar.c(str2);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(this.f9889c, this.f9888b, aVar, this.f9910x);
        com.mbridge.msdk.mbbanner.common.c.a.a().a(1, this.f9889c, this.f9888b, aVar, this.f9910x);
    }

    public final void a(BannerAdListener bannerAdListener) {
        this.f9899m = bannerAdListener;
    }

    /* access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.c.b bVar) {
        a(this.f9890d, bVar);
        d();
    }

    public final void a(int i5, int i6, int i7, int i8) {
        c cVar = this.f9901o;
        if (cVar != null) {
            cVar.a(i5, i6, i7, i8);
        }
    }

    static /* synthetic */ void a(a aVar, int i5, com.mbridge.msdk.foundation.c.b bVar) {
        try {
            com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(aVar.f9888b, bVar == null ? aVar.f9900n.getLocalRequestId() : bVar.f());
            e eVar = new e();
            eVar.a("result", Integer.valueOf(i5));
            CampaignUnit campaignUnit = aVar.f9900n;
            if (campaignUnit != null && !campaignUnit.getAds().isEmpty()) {
                CampaignEx campaignEx = aVar.f9900n.getAds().get(0);
                if (campaignEx != null) {
                    a5.f(TextUtils.isEmpty(campaignEx.getBannerUrl()) ? 2 : 1);
                }
                a5.b((List<CampaignEx>) aVar.f9900n.getAds());
            }
            if (bVar != null) {
                a5.a(bVar);
            }
            com.mbridge.msdk.mbbanner.common.d.a.a("2000126", a5, eVar);
        } catch (Exception e5) {
            af.b(f9887a, e5.getMessage());
        }
    }
}
