package com.mbridge.msdk.newreward.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.List;

public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    protected c f10333a;

    /* renamed from: b  reason: collision with root package name */
    protected MBridgeIds f10334b;

    /* renamed from: c  reason: collision with root package name */
    protected e f10335c;

    /* renamed from: d  reason: collision with root package name */
    private RewardVideoListener f10336d;

    public a(c cVar) {
        this.f10333a = cVar;
    }

    /* access modifiers changed from: protected */
    public final void a(final com.mbridge.msdk.foundation.c.b bVar) {
        c cVar = this.f10333a;
        cVar.b((Object) cVar.a("adapter_model", this.f10335c, "command_manager", cVar, "scene", 2, "reason", bVar), (b) new b() {
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                a aVar = a.this;
                aVar.a(aVar.f10334b, bVar);
            }

            public final void reqSuccessful(Object obj) {
                a.this.a(1, obj);
                a.this.a(2, obj);
            }
        });
    }

    public final void a(int i5, Object obj) {
        int i6;
        int i7;
        char c5;
        int i8;
        int i9;
        int i10;
        int i11 = i5;
        if (i11 != 1) {
            if (i11 == 2) {
                this.f10335c.c(2);
                if (!this.f10335c.s()) {
                    if (this.f10335c.D() == null || this.f10335c.D().b() == null) {
                        c5 = 2;
                        i8 = 0;
                        i9 = 0;
                        i10 = 0;
                    } else {
                        com.mbridge.msdk.newreward.function.c.a.b b5 = this.f10335c.D().b();
                        i10 = b5.a();
                        i8 = b5.b();
                        c5 = 2;
                        i9 = (this.f10335c.D().a() == null || this.f10335c.D().a().isEmpty()) ? 0 : this.f10335c.D().a().get(0).getFilterCallBackState();
                    }
                    c cVar = this.f10333a;
                    e eVar = this.f10335c;
                    f fVar = f.REPORT_LOAD_VIDEO_CAMPAIGN_SUCCESS;
                    Integer valueOf = Integer.valueOf(i10);
                    Integer valueOf2 = Integer.valueOf(i8);
                    Integer valueOf3 = Integer.valueOf(i9);
                    Object[] objArr = new Object[8];
                    objArr[0] = "cache";
                    objArr[1] = 2;
                    objArr[c5] = com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX;
                    objArr[3] = valueOf;
                    objArr[4] = com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX;
                    objArr[5] = valueOf2;
                    objArr[6] = CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE;
                    objArr[7] = valueOf3;
                    cVar.a((Object) eVar, fVar, (Object) cVar.a(objArr));
                    if (this.f10336d != null) {
                        this.f10335c.h(true);
                        this.f10336d.onVideoLoadSuccess(this.f10334b);
                    }
                }
            }
        } else if (!this.f10335c.q() && !this.f10335c.s()) {
            List<CampaignEx> a5 = this.f10335c.D() != null ? this.f10335c.D().a() : null;
            if (this.f10335c.D() == null || this.f10335c.D().b() == null) {
                i7 = 0;
                i6 = 0;
            } else {
                com.mbridge.msdk.newreward.function.c.a.b b6 = this.f10335c.D().b();
                i6 = b6.a();
                i7 = b6.b();
            }
            int filterCallBackState = (a5 == null || a5.isEmpty()) ? 0 : a5.get(0).getFilterCallBackState();
            c cVar2 = this.f10333a;
            e eVar2 = this.f10335c;
            cVar2.a((Object) eVar2, f.REPORT_LOAD_V3_CAMPAIGN_SUCCESS, (Object) cVar2.a("metrics_data", obj, "auto_load", Integer.valueOf(eVar2.I() ? 2 : 1), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(i6), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(i7), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState), "cache", 2));
            if (this.f10336d != null) {
                this.f10335c.f(true);
                this.f10336d.onLoadSuccess(this.f10334b);
            }
        }
    }

    public final void a(MBridgeIds mBridgeIds, com.mbridge.msdk.foundation.c.b bVar) {
        int i5;
        int i6;
        int i7;
        this.f10335c.c(2);
        if (!this.f10335c.s()) {
            if (this.f10335c.D() == null || this.f10335c.D().b() == null) {
                i7 = 0;
                i6 = 0;
                i5 = 0;
            } else {
                com.mbridge.msdk.newreward.function.c.a.b b5 = this.f10335c.D().b();
                i6 = b5.a();
                i7 = b5.b();
                i5 = (this.f10335c.D().a() == null || this.f10335c.D().a().isEmpty()) ? 0 : this.f10335c.D().a().get(0).getFilterCallBackState();
            }
            c cVar = this.f10333a;
            cVar.a((Object) this.f10335c, f.REPORT_LOAD_FAILED, (Object) cVar.a("metrics_data", bVar, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(i6), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(i7), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(i5)));
            if (this.f10336d != null) {
                this.f10335c.h(true);
                RewardVideoListener rewardVideoListener = this.f10336d;
                if (rewardVideoListener != null) {
                    rewardVideoListener.onVideoLoadFail(mBridgeIds, bVar.b());
                }
            }
        }
    }

    public final void a(e eVar) {
        eVar.c(1);
        this.f10335c = eVar;
        this.f10336d = eVar.K();
        MBridgeIds mBridgeIds = (MBridgeIds) this.f10333a.a((Object) null, f.CREATE_BIDS);
        this.f10334b = mBridgeIds;
        mBridgeIds.setBidToken(this.f10335c.J());
        c cVar = this.f10333a;
        cVar.c((Object) cVar.a("command_type", f.PRE_HANDLE_LOAD, "command_manager", cVar, "adapter_model", this.f10335c), (b) new b() {
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                a aVar = a.this;
                aVar.a(aVar.f10334b, bVar);
            }

            public final void reqSuccessful(Object obj) {
                a aVar = a.this;
                c cVar = aVar.f10333a;
                cVar.a((Object) cVar.a("command_manager", cVar, "adapter_model", aVar.f10335c), (b) a.this);
            }
        });
    }
}
