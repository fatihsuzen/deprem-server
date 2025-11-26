package com.mbridge.msdk.newreward.function.e;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.b.i;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public List<Integer> f10954a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private b f10955b;

    /* renamed from: c  reason: collision with root package name */
    private b f10956c;

    private static final class a implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: a  reason: collision with root package name */
        private e f10957a;

        /* renamed from: b  reason: collision with root package name */
        private d f10958b;

        /* renamed from: c  reason: collision with root package name */
        private com.mbridge.msdk.newreward.a.b.b f10959c;

        /* renamed from: d  reason: collision with root package name */
        private int f10960d;

        public a(e eVar, d dVar, com.mbridge.msdk.newreward.a.b.b bVar, int i5) {
            this.f10957a = eVar;
            this.f10958b = dVar;
            this.f10959c = bVar;
            this.f10960d = i5;
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f10959c;
            if (bVar2 != null) {
                try {
                    bVar2.reqFailed(bVar);
                } catch (Exception e5) {
                    af.b("MoreOfferCampaignModel", "reqFailed: ", e5);
                }
            }
        }

        public final void reqSuccessful(Object obj) {
            try {
                b bVar = (b) obj;
                bVar.b(this.f10957a.G());
                int Q4 = (int) (((double) this.f10957a.Q()) * 1.2d);
                bVar.f(Q4);
                bVar.g(Q4);
                bVar.b(Math.max(this.f10957a.T(), bVar.p()));
                int i5 = this.f10960d;
                if (i5 == 1) {
                    this.f10958b.a(bVar);
                } else if (i5 == 2) {
                    this.f10958b.b(bVar);
                }
                if (!TextUtils.isEmpty(bVar.k())) {
                    MBridgeGlobalCommon.SESSION_ID = bVar.k();
                }
                com.mbridge.msdk.newreward.a.b.b bVar2 = this.f10959c;
                if (bVar2 != null) {
                    bVar2.reqSuccessful(obj);
                }
            } catch (Exception e5) {
                af.b("MoreOfferCampaignModel", "reqSuccessful: ", e5);
                com.mbridge.msdk.newreward.a.b.b bVar3 = this.f10959c;
                if (bVar3 != null) {
                    bVar3.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e5.getMessage()));
                }
            }
        }
    }

    public final void a(b bVar) {
        this.f10955b = bVar;
    }

    public final void b(b bVar) {
        this.f10956c = bVar;
    }

    public final void a(int i5, e eVar, CampaignEx campaignEx, com.mbridge.msdk.newreward.function.f.a aVar, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (campaignEx != null) {
            try {
                try {
                    new i(eVar).a(aVar, new a(eVar, this, bVar, i5));
                } catch (IOException e5) {
                    if (bVar != null) {
                        bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e5.getMessage()));
                    }
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    e6.printStackTrace();
                }
            }
        } else if (bVar != null) {
            bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, "more_offer MainCampaign is null"));
        }
    }

    public final b b() {
        return this.f10956c;
    }

    public final b a() {
        return this.f10955b;
    }
}
