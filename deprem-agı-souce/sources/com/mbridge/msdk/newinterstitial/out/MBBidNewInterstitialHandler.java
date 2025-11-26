package com.mbridge.msdk.newinterstitial.out;

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
import com.mbridge.msdk.out.BaseExtraInterfaceForHandler;
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import org.json.JSONObject;

public class MBBidNewInterstitialHandler implements BaseExtraInterfaceForHandler {

    /* renamed from: a  reason: collision with root package name */
    private final String f10269a;

    /* renamed from: b  reason: collision with root package name */
    private String f10270b;

    /* renamed from: c  reason: collision with root package name */
    private String f10271c;

    /* renamed from: d  reason: collision with root package name */
    private String f10272d;

    /* renamed from: e  reason: collision with root package name */
    private String f10273e;

    /* renamed from: f  reason: collision with root package name */
    private a f10274f;

    /* renamed from: g  reason: collision with root package name */
    private String f10275g;

    /* renamed from: h  reason: collision with root package name */
    private d f10276h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10277i = false;

    /* renamed from: j  reason: collision with root package name */
    private NewInterstitialListener f10278j;

    /* renamed from: k  reason: collision with root package name */
    private int f10279k = 2;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10280l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10281m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10282n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10283o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f10284p;

    /* renamed from: q  reason: collision with root package name */
    private int f10285q;

    /* renamed from: r  reason: collision with root package name */
    private int f10286r;

    public MBBidNewInterstitialHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String e5 = ak.e(str2);
        if (!TextUtils.isEmpty(e5)) {
            ak.b(str2, e5);
        }
        this.f10269a = str;
        this.f10275g = str2;
    }

    private void a(String str, String str2) {
        try {
            if (this.f10274f == null) {
                a aVar = new a();
                this.f10274f = aVar;
                aVar.a(true);
                this.f10274f.b(true);
                this.f10274f.b(str, str2);
            }
        } catch (Throwable th) {
            af.b("MBBidNewInterstitialHandler", th.getMessage(), th);
        }
    }

    private void b(String str, String str2) {
        if (this.f10276h == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.f10276h = new d(287, str, str2, true);
        }
    }

    public void clearVideoCache() {
        if (!this.f10277i) {
            try {
                if (this.f10274f != null) {
                    ad.b();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f10277i) {
            d dVar = this.f10276h;
            if (dVar != null) {
                return dVar.c();
            }
            return "";
        }
        a aVar = this.f10274f;
        if (aVar != null) {
            return aVar.d();
        }
        return "";
    }

    public String getRequestId() {
        if (this.f10277i) {
            d dVar = this.f10276h;
            if (dVar != null) {
                return dVar.b();
            }
            return "";
        }
        a aVar = this.f10274f;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public boolean isBidReady() {
        if (this.f10277i) {
            d dVar = this.f10276h;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f10274f;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f10277i = a5;
        if (a5) {
            b();
            d dVar = this.f10276h;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        a();
        if (this.f10274f != null) {
            this.f10274f.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f10275g, true, 1));
        }
    }

    public void loadFromBid(String str) {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f10277i = a5;
        if (a5) {
            b();
            d dVar = this.f10276h;
            if (dVar != null) {
                dVar.a(true, str);
                return;
            }
            return;
        }
        a();
        if (this.f10274f != null) {
            this.f10274f.a(true, str, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f10275g, true, 2));
        }
    }

    public void playVideoMute(int i5) {
        this.f10279k = i5;
        if (this.f10277i) {
            d dVar = this.f10276h;
            if (dVar != null) {
                dVar.a(i5);
                return;
            }
            return;
        }
        a aVar = this.f10274f;
        if (aVar != null) {
            aVar.a(i5);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f10271c = str;
        this.f10270b = str2;
        this.f10272d = str3;
        this.f10273e = str4;
        this.f10282n = true;
        this.f10283o = true;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(this.f10275g, jSONObject);
    }

    public void setIVRewardEnable(int i5, int i6) {
        this.f10284p = i5;
        this.f10285q = i6;
        this.f10286r = com.mbridge.msdk.foundation.same.a.f9168K;
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f10278j = newInterstitialListener;
        this.f10280l = true;
        this.f10281m = true;
    }

    @Deprecated
    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f10278j = newInterstitialListener;
        this.f10280l = true;
        this.f10281m = true;
    }

    public void showFromBid() {
        if (this.f10277i) {
            b();
            d dVar = this.f10276h;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f10274f != null) {
            this.f10274f.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f10275g, false, -1));
        }
    }

    private void b() {
        if (this.f10276h == null) {
            b(this.f10269a, this.f10275g);
        }
        if (this.f10280l) {
            d dVar = this.f10276h;
            if (dVar != null) {
                dVar.a((RewardVideoListener) new NewInterstitialListenerWrapper(this.f10278j));
            }
            this.f10280l = false;
        }
        if (this.f10283o) {
            MBridgeGlobalCommon.setAlertDialogText(this.f10275g, this.f10271c, this.f10270b, this.f10272d, this.f10273e);
            this.f10283o = false;
        }
        d dVar2 = this.f10276h;
        if (dVar2 != null) {
            dVar2.a(this.f10279k);
            this.f10276h.a(this.f10284p, this.f10286r, this.f10285q);
        }
    }

    public void setIVRewardEnable(int i5, double d5) {
        this.f10284p = i5;
        this.f10285q = (int) (d5 * 100.0d);
        this.f10286r = com.mbridge.msdk.foundation.same.a.f9167J;
    }

    private void a() {
        if (this.f10274f == null) {
            a(this.f10269a, this.f10275g);
        }
        if (this.f10281m) {
            a aVar = this.f10274f;
            if (aVar != null) {
                aVar.a((InterVideoOutListener) new com.mbridge.msdk.newinterstitial.a.a(this.f10278j, this.f10275g, true));
            }
            this.f10281m = false;
        }
        if (this.f10282n) {
            a aVar2 = this.f10274f;
            if (aVar2 != null) {
                aVar2.a(this.f10271c, this.f10270b, this.f10272d, this.f10273e);
            }
            this.f10282n = false;
        }
        a aVar3 = this.f10274f;
        if (aVar3 != null) {
            aVar3.a(this.f10279k);
            this.f10274f.a(this.f10284p, this.f10286r, this.f10285q);
        }
    }

    public MBBidNewInterstitialHandler(String str, String str2) {
        this.f10269a = str;
        this.f10275g = str2;
    }
}
