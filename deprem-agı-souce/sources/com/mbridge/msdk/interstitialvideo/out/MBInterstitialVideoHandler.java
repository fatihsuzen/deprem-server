package com.mbridge.msdk.interstitialvideo.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.h;
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
public class MBInterstitialVideoHandler {

    /* renamed from: a  reason: collision with root package name */
    private String f9869a;

    /* renamed from: b  reason: collision with root package name */
    private a f9870b;

    /* renamed from: c  reason: collision with root package name */
    private String f9871c;

    /* renamed from: d  reason: collision with root package name */
    private String f9872d;

    /* renamed from: e  reason: collision with root package name */
    private String f9873e;

    /* renamed from: f  reason: collision with root package name */
    private String f9874f;

    /* renamed from: g  reason: collision with root package name */
    private String f9875g;

    /* renamed from: h  reason: collision with root package name */
    private d f9876h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9877i = false;

    /* renamed from: j  reason: collision with root package name */
    private InterstitialVideoListener f9878j;

    /* renamed from: k  reason: collision with root package name */
    private int f9879k = 2;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9880l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9881m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f9882n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9883o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f9884p;

    /* renamed from: q  reason: collision with root package name */
    private int f9885q;

    /* renamed from: r  reason: collision with root package name */
    private int f9886r;

    public MBInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String e5 = ak.e(str2);
        if (!TextUtils.isEmpty(e5)) {
            ak.b(str2, e5);
        }
        this.f9869a = str;
        this.f9871c = str2;
    }

    private void a(String str, String str2) {
        try {
            if (this.f9870b == null) {
                a aVar = new a();
                this.f9870b = aVar;
                aVar.a(true);
                this.f9870b.b(str, str2);
                h.a().e(str2);
            }
        } catch (Throwable th) {
            af.b("MBRewardVideoHandler", th.getMessage(), th);
        }
    }

    private void b(String str, String str2) {
        if (this.f9876h == null) {
            String str3 = "";
            if (TextUtils.isEmpty(str)) {
                str = str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                str3 = str2;
            }
            this.f9876h = new d(287, str, str3, false);
            h.a().e(str2);
        }
    }

    public void clearVideoCache() {
        if (!this.f9877i) {
            try {
                if (this.f9870b != null) {
                    ad.b();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f9877i) {
            d dVar = this.f9876h;
            if (dVar != null) {
                return dVar.c();
            }
            return "";
        }
        a aVar = this.f9870b;
        if (aVar != null) {
            return aVar.d();
        }
        return "";
    }

    public String getRequestId() {
        if (this.f9877i) {
            d dVar = this.f9876h;
            if (dVar != null) {
                return dVar.b();
            }
            return "";
        }
        a aVar = this.f9870b;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public boolean isReady() {
        if (this.f9877i) {
            d dVar = this.f9876h;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f9870b;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void load() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f9877i = a5;
        if (a5) {
            b();
            d dVar = this.f9876h;
            if (dVar != null) {
                dVar.a(true, "");
                return;
            }
            return;
        }
        a();
        if (this.f9870b != null) {
            this.f9870b.a(true, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f9871c, true, 2));
        }
    }

    public void loadFormSelfFilling() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f9877i = a5;
        if (a5) {
            b();
            d dVar = this.f9876h;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        a();
        if (this.f9870b != null) {
            this.f9870b.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f9871c, true, 1));
        }
    }

    public void playVideoMute(int i5) {
        this.f9879k = i5;
        if (this.f9877i) {
            d dVar = this.f9876h;
            if (dVar != null) {
                dVar.a(i5);
                return;
            }
            return;
        }
        a aVar = this.f9870b;
        if (aVar != null) {
            aVar.a(i5);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f9872d = str;
        this.f9873e = str2;
        this.f9874f = str3;
        this.f9875g = str4;
        this.f9882n = true;
        this.f9883o = true;
    }

    public void setIVRewardEnable(int i5, int i6) {
        this.f9884p = i5;
        this.f9885q = i6;
        this.f9886r = com.mbridge.msdk.foundation.same.a.f9168K;
    }

    public void setInterstitialVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f9878j = interstitialVideoListener;
        this.f9881m = true;
        this.f9880l = true;
    }

    @Deprecated
    public void setRewardVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f9878j = interstitialVideoListener;
        this.f9881m = true;
        this.f9880l = true;
    }

    public void show() {
        if (this.f9877i) {
            b();
            d dVar = this.f9876h;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f9870b != null) {
            this.f9870b.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f9871c, false, -1));
        }
    }

    private void b() {
        if (this.f9876h == null) {
            b(this.f9869a, this.f9871c);
        }
        if (this.f9880l) {
            this.f9876h.a((RewardVideoListener) new InterstitialVideoListenerWrapper(this.f9878j));
            this.f9880l = false;
        }
        if (this.f9883o) {
            MBridgeGlobalCommon.setAlertDialogText(this.f9871c, this.f9872d, this.f9873e, this.f9874f, this.f9875g);
            this.f9883o = false;
        }
        d dVar = this.f9876h;
        if (dVar != null) {
            dVar.a(this.f9884p, this.f9886r, this.f9885q);
            this.f9876h.a(this.f9879k);
        }
    }

    public void setIVRewardEnable(int i5, double d5) {
        this.f9884p = i5;
        this.f9885q = (int) (d5 * 100.0d);
        this.f9886r = com.mbridge.msdk.foundation.same.a.f9167J;
    }

    private void a() {
        if (this.f9870b == null) {
            a(this.f9869a, this.f9871c);
        }
        if (this.f9881m) {
            this.f9870b.a((InterVideoOutListener) new com.mbridge.msdk.interstitialvideo.a.a(this.f9878j, this.f9871c, false));
            this.f9881m = false;
        }
        if (this.f9882n) {
            this.f9870b.a(this.f9872d, this.f9873e, this.f9874f, this.f9875g);
            this.f9882n = false;
        }
        a aVar = this.f9870b;
        if (aVar != null) {
            aVar.a(this.f9884p, this.f9886r, this.f9885q);
            this.f9870b.a(this.f9879k);
        }
    }

    public MBInterstitialVideoHandler(String str, String str2) {
        this.f9871c = str2;
        this.f9869a = str;
    }
}
