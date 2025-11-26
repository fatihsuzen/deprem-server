package com.mbridge.msdk.interstitialvideo.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.b.d;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;

@Deprecated
public class MBBidInterstitialVideoHandler {

    /* renamed from: a  reason: collision with root package name */
    private a f9851a;

    /* renamed from: b  reason: collision with root package name */
    private String f9852b;

    /* renamed from: c  reason: collision with root package name */
    private String f9853c;

    /* renamed from: d  reason: collision with root package name */
    private String f9854d;

    /* renamed from: e  reason: collision with root package name */
    private String f9855e;

    /* renamed from: f  reason: collision with root package name */
    private String f9856f;

    /* renamed from: g  reason: collision with root package name */
    private String f9857g;

    /* renamed from: h  reason: collision with root package name */
    private d f9858h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9859i = false;

    /* renamed from: j  reason: collision with root package name */
    private InterstitialVideoListener f9860j;

    /* renamed from: k  reason: collision with root package name */
    private int f9861k = 2;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9862l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9863m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f9864n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9865o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f9866p;

    /* renamed from: q  reason: collision with root package name */
    private int f9867q;

    /* renamed from: r  reason: collision with root package name */
    private int f9868r;

    public MBBidInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String e5 = ak.e(str2);
        if (!TextUtils.isEmpty(e5)) {
            ak.b(str2, e5);
        }
        this.f9852b = str2;
        this.f9853c = str;
    }

    private void a(String str, String str2) {
        try {
            if (this.f9851a == null) {
                a aVar = new a();
                this.f9851a = aVar;
                aVar.a(true);
                this.f9851a.b(true);
                this.f9851a.b(str, str2);
            }
        } catch (Throwable th) {
            af.b("MBBidRewardVideoHandler", th.getMessage(), th);
        }
    }

    private void b(String str, String str2) {
        if (this.f9858h == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.f9858h = new d(287, str, str2, true);
        }
    }

    public void clearVideoCache() {
        if (!this.f9859i) {
            try {
                if (this.f9851a != null) {
                    ad.b();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f9859i) {
            d dVar = this.f9858h;
            if (dVar != null) {
                return dVar.c();
            }
            return "";
        }
        a aVar = this.f9851a;
        if (aVar != null) {
            return aVar.d();
        }
        return "";
    }

    public String getRequestId() {
        if (this.f9859i) {
            d dVar = this.f9858h;
            if (dVar != null) {
                return dVar.b();
            }
            return "";
        }
        a aVar = this.f9851a;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public boolean isBidReady() {
        if (this.f9859i) {
            d dVar = this.f9858h;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f9851a;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f9859i = a5;
        if (a5) {
            b();
            d dVar = this.f9858h;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        a();
        if (this.f9851a != null) {
            this.f9851a.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f9852b, true, 1));
        }
    }

    public void loadFromBid(String str) {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f9859i = a5;
        if (a5) {
            b();
            d dVar = this.f9858h;
            if (dVar != null) {
                dVar.a(true, str);
                return;
            }
            return;
        }
        a();
        if (this.f9851a != null) {
            this.f9851a.a(true, str, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f9852b, true, 2));
        }
    }

    public void playVideoMute(int i5) {
        this.f9861k = i5;
        if (this.f9859i) {
            d dVar = this.f9858h;
            if (dVar != null) {
                dVar.a(i5);
                return;
            }
            return;
        }
        a aVar = this.f9851a;
        if (aVar != null) {
            aVar.a(i5);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f9854d = str;
        this.f9855e = str2;
        this.f9856f = str3;
        this.f9857g = str4;
        this.f9864n = true;
        this.f9865o = true;
    }

    public void setIVRewardEnable(int i5, int i6) {
        this.f9866p = i5;
        this.f9867q = i6;
        this.f9868r = com.mbridge.msdk.foundation.same.a.f9168K;
    }

    public void setInterstitialVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f9860j = interstitialVideoListener;
        this.f9863m = true;
        this.f9862l = true;
    }

    @Deprecated
    public void setRewardVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f9860j = interstitialVideoListener;
        this.f9863m = true;
        this.f9862l = true;
    }

    public void showFromBid() {
        if (this.f9859i) {
            b();
            d dVar = this.f9858h;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f9851a != null) {
            this.f9851a.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f9852b, false, -1));
        }
    }

    private void b() {
        if (this.f9858h == null) {
            b(this.f9853c, this.f9852b);
        }
        if (this.f9862l) {
            d dVar = this.f9858h;
            if (dVar != null) {
                dVar.a((RewardVideoListener) new InterstitialVideoListenerWrapper(this.f9860j));
            }
            this.f9862l = false;
        }
        if (this.f9865o) {
            MBridgeGlobalCommon.setAlertDialogText(this.f9852b, this.f9854d, this.f9855e, this.f9856f, this.f9857g);
            this.f9865o = false;
        }
        d dVar2 = this.f9858h;
        if (dVar2 != null) {
            dVar2.a(this.f9866p, this.f9868r, this.f9867q);
            this.f9858h.a(this.f9861k);
        }
    }

    public void setIVRewardEnable(int i5, double d5) {
        this.f9866p = i5;
        this.f9867q = (int) (d5 * 100.0d);
        this.f9868r = com.mbridge.msdk.foundation.same.a.f9167J;
    }

    private void a() {
        if (this.f9851a == null) {
            a(this.f9853c, this.f9852b);
        }
        if (this.f9863m) {
            a aVar = this.f9851a;
            if (aVar != null) {
                aVar.a((InterVideoOutListener) new com.mbridge.msdk.interstitialvideo.a.a(this.f9860j, this.f9852b, true));
            }
            this.f9863m = false;
        }
        if (this.f9864n) {
            a aVar2 = this.f9851a;
            if (aVar2 != null) {
                aVar2.a(this.f9854d, this.f9855e, this.f9856f, this.f9857g);
            }
            this.f9864n = false;
        }
        a aVar3 = this.f9851a;
        if (aVar3 != null) {
            aVar3.a(this.f9866p, this.f9868r, this.f9867q);
            this.f9851a.a(this.f9861k);
        }
    }

    public MBBidInterstitialVideoHandler(String str, String str2) {
        this.f9852b = str2;
        this.f9853c = str;
    }
}
