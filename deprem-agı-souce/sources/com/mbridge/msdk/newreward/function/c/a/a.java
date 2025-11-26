package com.mbridge.msdk.newreward.function.c.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.function.c.c.d;
import com.mbridge.msdk.newreward.function.c.c.f;
import com.mbridge.msdk.newreward.function.c.c.g;
import com.mbridge.msdk.newreward.function.c.c.h;
import com.mbridge.msdk.newreward.function.c.c.j;
import com.mbridge.msdk.newreward.function.c.c.k;
import com.mbridge.msdk.newreward.function.c.c.l;
import com.mbridge.msdk.newreward.function.c.c.m;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.newreward.function.h.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f10533a;

    /* renamed from: b  reason: collision with root package name */
    private CampaignEx f10534b;

    /* renamed from: c  reason: collision with root package name */
    private String f10535c;

    /* renamed from: d  reason: collision with root package name */
    private String f10536d;

    /* renamed from: e  reason: collision with root package name */
    private String f10537e;

    /* renamed from: f  reason: collision with root package name */
    private d<?> f10538f;

    /* renamed from: g  reason: collision with root package name */
    private n f10539g;

    /* renamed from: h  reason: collision with root package name */
    private d<?> f10540h;

    /* renamed from: i  reason: collision with root package name */
    private l f10541i;

    /* renamed from: j  reason: collision with root package name */
    private h f10542j;

    /* renamed from: k  reason: collision with root package name */
    private m f10543k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10544l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10545m = false;

    public a(b bVar) {
        this.f10533a = bVar;
    }

    public final m a() {
        CampaignEx.c rewardTemplateMode;
        m mVar = this.f10543k;
        if (mVar != null) {
            return mVar;
        }
        CampaignEx campaignEx = this.f10534b;
        if (campaignEx == null || (rewardTemplateMode = campaignEx.getRewardTemplateMode()) == null) {
            return null;
        }
        String c5 = rewardTemplateMode.c();
        if (TextUtils.isEmpty(c5)) {
            return null;
        }
        if (this.f10543k == null) {
            this.f10543k = new m(this.f10533a, this, c5);
        }
        return this.f10543k;
    }

    public final h b() {
        h hVar = this.f10542j;
        if (hVar != null) {
            return hVar;
        }
        CampaignEx campaignEx = this.f10534b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getEndScreenUrl())) {
            return null;
        }
        if (this.f10542j == null) {
            this.f10542j = new h(this.f10533a, this);
        }
        return this.f10542j;
    }

    public final d<?> c() {
        d<?> dVar = this.f10538f;
        if (dVar != null) {
            return dVar;
        }
        CampaignEx campaignEx = this.f10534b;
        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
            return null;
        }
        String e5 = campaignEx.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(e5)) {
            return null;
        }
        if (this.f10538f == null) {
            if (c.b(e5)) {
                this.f10538f = new g(this.f10533a, this);
            } else {
                this.f10538f = new k(this.f10533a, this);
            }
        }
        return this.f10538f;
    }

    public final n d() {
        n nVar = this.f10539g;
        if (nVar != null) {
            return nVar;
        }
        CampaignEx campaignEx = this.f10534b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            return null;
        }
        if (this.f10539g == null) {
            this.f10539g = new n(this.f10533a, this);
        }
        return this.f10539g;
    }

    public final l e() {
        l lVar = this.f10541i;
        if (lVar != null) {
            return lVar;
        }
        CampaignEx campaignEx = this.f10534b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getMraid())) {
            return null;
        }
        if (this.f10541i == null) {
            this.f10541i = new l(this.f10533a, this);
        }
        return this.f10541i;
    }

    public final d<?> f() {
        d<?> dVar = this.f10540h;
        if (dVar != null) {
            return dVar;
        }
        CampaignEx campaignEx = this.f10534b;
        if (campaignEx == null) {
            return null;
        }
        String str = campaignEx.getendcard_url();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f10540h == null) {
            if (!c.b(str)) {
                this.f10540h = new j(this.f10533a, this);
            } else if (ak.l(str)) {
                this.f10540h = new j(this.f10533a, this);
            } else {
                this.f10540h = new f(this.f10533a, this);
            }
        }
        return this.f10540h;
    }

    public final String g() {
        return this.f10537e;
    }

    public final CampaignEx h() {
        return this.f10534b;
    }

    public final b i() {
        return this.f10533a;
    }

    public final boolean j() {
        CampaignEx campaignEx = this.f10534b;
        if (campaignEx != null) {
            return campaignEx.isMraid();
        }
        return false;
    }

    public final boolean k() {
        return this.f10544l;
    }

    public final boolean l() {
        return this.f10545m;
    }

    public final void b(String str) {
        this.f10536d = str;
    }

    public final void a(String str) {
        this.f10535c = str;
    }

    public final void b(boolean z4) {
        this.f10545m = z4;
    }

    public final void a(CampaignEx campaignEx) {
        this.f10534b = campaignEx;
    }

    public final void a(boolean z4) {
        this.f10544l = z4;
    }

    public final void c(String str) {
        this.f10537e = str;
    }
}
