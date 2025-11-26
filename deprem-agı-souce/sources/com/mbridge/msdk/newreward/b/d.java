package com.mbridge.msdk.newreward.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.c;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.a.g;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

public final class d extends a implements RewardVideoListener, c {

    /* renamed from: d  reason: collision with root package name */
    RewardVideoListener f10497d;

    /* renamed from: e  reason: collision with root package name */
    private int f10498e = 2;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10499f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f10500g;

    /* renamed from: h  reason: collision with root package name */
    private int f10501h;

    /* renamed from: i  reason: collision with root package name */
    private int f10502i;

    public d(int i5, String str, String str2, boolean z4) {
        super(i5, str, str2, z4);
        if (i5 == 287) {
            this.f10498e = a.f9181X;
        } else {
            this.f10498e = a.f9180W;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f10488b.a(this.f10487a, this.f10489c);
    }

    public final String b() {
        e b5;
        com.mbridge.msdk.newreward.function.e.a D4;
        b b6;
        c cVar = this.f10488b;
        if (cVar == null || (b5 = cVar.b()) == null || (D4 = b5.D()) == null || (b6 = D4.b()) == null) {
            return "";
        }
        String f5 = b6.f();
        if (TextUtils.isEmpty(f5)) {
            return "";
        }
        return f5;
    }

    public final String c() {
        e b5;
        com.mbridge.msdk.newreward.function.e.a D4;
        b b6;
        c cVar = this.f10488b;
        if (cVar == null || (b5 = cVar.b()) == null || (D4 = b5.D()) == null || (b6 = D4.b()) == null) {
            return "";
        }
        return com.mbridge.msdk.foundation.same.c.a(b6.E());
    }

    public final void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        RewardVideoListener rewardVideoListener = this.f10497d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdClose(mBridgeIds, rewardInfo);
        }
    }

    public final void onAdCloseWithIVReward(MBridgeIds mBridgeIds, boolean z4, int i5) {
        RewardVideoListener rewardVideoListener = this.f10497d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdCloseWithIVReward(mBridgeIds, z4, i5);
        }
    }

    public final void onAdShow(MBridgeIds mBridgeIds) {
        try {
            ((MBridgeDailyPlayModel) this.f10487a.a((Object) null, f.CREATE_DAILY)).insertDailyCap();
        } catch (Exception e5) {
            af.b("RewardVideoController", "updateDailyShowCap error:" + e5.getMessage());
        }
        RewardVideoListener rewardVideoListener = this.f10497d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdShow(mBridgeIds);
        }
    }

    public final void onEndcardShow(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f10497d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onEndcardShow(mBridgeIds);
        }
    }

    public final void onLoadSuccess(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f10497d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onLoadSuccess(mBridgeIds);
        }
    }

    public final void onShowFail(MBridgeIds mBridgeIds, String str) {
        RewardVideoListener rewardVideoListener = this.f10497d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onShowFail(mBridgeIds, str);
        }
    }

    public final void onVideoAdClicked(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f10497d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoAdClicked(mBridgeIds);
        }
    }

    public final void onVideoComplete(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f10497d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoComplete(mBridgeIds);
        }
    }

    public final void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        RewardVideoListener rewardVideoListener = this.f10497d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoLoadFail(mBridgeIds, str);
        }
    }

    public final void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f10497d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoLoadSuccess(mBridgeIds);
        }
    }

    public final void a(boolean z4, String str) {
        g gVar = new g(this.f10487a);
        String str2 = str;
        e eVar = new e(z4, this.f10489c.e(), str2, this.f10489c.c(), this.f10489c.f());
        eVar.e(this.f10489c.d());
        eVar.e(this.f10498e);
        eVar.d(com.mbridge.msdk.foundation.controller.c.m().k());
        eVar.d(this.f10489c.f() ? 2 : 1);
        eVar.f(com.mbridge.msdk.newreward.function.h.d.a(str2));
        eVar.e(this.f10499f);
        eVar.a(this.f10500g, this.f10501h, this.f10502i);
        this.f10488b.a(eVar, gVar);
    }

    public final void b(boolean z4) {
        this.f10499f = z4;
    }

    public final void a(String str, String str2, String str3) {
        com.mbridge.msdk.newreward.a.f fVar = new com.mbridge.msdk.newreward.a.f();
        fVar.a(str2);
        fVar.b(str3);
        this.f10488b.a(fVar);
    }

    public final boolean a(boolean z4) {
        return this.f10488b.a(z4);
    }

    public final void a(int i5) {
        this.f10498e = i5;
        c cVar = this.f10488b;
        if (cVar != null) {
            for (e e5 : cVar.a()) {
                e5.e(i5);
            }
        }
    }

    public final void a(int i5, int i6, int i7) {
        this.f10500g = i5;
        this.f10501h = i6;
        if (i6 == a.f9168K) {
            this.f10502i = i7 < 0 ? 5 : i7;
        }
        if (i6 == a.f9167J) {
            this.f10502i = i7 < 0 ? 80 : i7;
        }
        com.mbridge.msdk.newreward.function.h.c.a(this.f10489c.c(), i5, i6, i7);
    }

    public final void a(RewardVideoListener rewardVideoListener) {
        this.f10497d = rewardVideoListener;
        this.f10488b.a((Object) this);
    }
}
