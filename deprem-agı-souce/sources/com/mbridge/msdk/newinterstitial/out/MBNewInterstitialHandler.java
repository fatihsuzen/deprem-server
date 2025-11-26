package com.mbridge.msdk.newinterstitial.out;

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
import com.mbridge.msdk.out.BaseExtraInterfaceForHandler;
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import org.json.JSONObject;

public class MBNewInterstitialHandler implements BaseExtraInterfaceForHandler {

    /* renamed from: a  reason: collision with root package name */
    private String f10287a;

    /* renamed from: b  reason: collision with root package name */
    private String f10288b;

    /* renamed from: c  reason: collision with root package name */
    private String f10289c;

    /* renamed from: d  reason: collision with root package name */
    private String f10290d;

    /* renamed from: e  reason: collision with root package name */
    private String f10291e;

    /* renamed from: f  reason: collision with root package name */
    private a f10292f;

    /* renamed from: g  reason: collision with root package name */
    private String f10293g;

    /* renamed from: h  reason: collision with root package name */
    private d f10294h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10295i = false;

    /* renamed from: j  reason: collision with root package name */
    private NewInterstitialListener f10296j;

    /* renamed from: k  reason: collision with root package name */
    private int f10297k = 2;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10298l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10299m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10300n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10301o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f10302p;

    /* renamed from: q  reason: collision with root package name */
    private int f10303q;

    /* renamed from: r  reason: collision with root package name */
    private int f10304r;

    public MBNewInterstitialHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String e5 = ak.e(str2);
        if (!TextUtils.isEmpty(e5)) {
            ak.b(str2, e5);
        }
        this.f10287a = str;
        this.f10293g = str2;
    }

    private void a(String str, String str2) {
        try {
            if (this.f10292f == null) {
                a aVar = new a();
                this.f10292f = aVar;
                aVar.a(true);
                this.f10292f.b(str, str2);
                h.a().e(str2);
            }
        } catch (Throwable th) {
            af.b("MBRewardVideoHandler", th.getMessage(), th);
        }
    }

    private void b(String str, String str2) {
        if (this.f10294h == null) {
            String str3 = "";
            if (TextUtils.isEmpty(str)) {
                str = str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                str3 = str2;
            }
            this.f10294h = new d(287, str, str3, false);
            h.a().e(str2);
        }
    }

    public void clearVideoCache() {
        if (!this.f10295i) {
            try {
                if (this.f10292f != null) {
                    ad.b();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f10295i) {
            d dVar = this.f10294h;
            if (dVar != null) {
                return dVar.c();
            }
            return "";
        }
        a aVar = this.f10292f;
        if (aVar != null) {
            return aVar.d();
        }
        return "";
    }

    public String getRequestId() {
        if (this.f10295i) {
            d dVar = this.f10294h;
            if (dVar != null) {
                return dVar.b();
            }
            return "";
        }
        a aVar = this.f10292f;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public boolean isReady() {
        if (this.f10295i) {
            d dVar = this.f10294h;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f10292f;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void load() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f10295i = a5;
        if (a5) {
            b();
            d dVar = this.f10294h;
            if (dVar != null) {
                dVar.a(true, "");
                return;
            }
            return;
        }
        a();
        if (this.f10292f != null) {
            this.f10292f.a(true, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f10293g, true, 2));
        }
    }

    public void loadFormSelfFilling() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f10295i = a5;
        if (a5) {
            b();
            d dVar = this.f10294h;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        a();
        if (this.f10292f != null) {
            this.f10292f.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f10293g, true, 1));
        }
    }

    public void playVideoMute(int i5) {
        this.f10297k = i5;
        if (this.f10295i) {
            d dVar = this.f10294h;
            if (dVar != null) {
                dVar.a(i5);
                return;
            }
            return;
        }
        a aVar = this.f10292f;
        if (aVar != null) {
            aVar.a(i5);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f10288b = str;
        this.f10289c = str2;
        this.f10290d = str3;
        this.f10291e = str4;
        this.f10300n = true;
        this.f10301o = true;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(this.f10293g, jSONObject);
    }

    public void setIVRewardEnable(int i5, int i6) {
        this.f10302p = i5;
        this.f10303q = i6;
        this.f10304r = com.mbridge.msdk.foundation.same.a.f9168K;
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f10296j = newInterstitialListener;
        this.f10298l = true;
        this.f10299m = true;
    }

    @Deprecated
    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f10296j = newInterstitialListener;
        this.f10298l = true;
        this.f10299m = true;
    }

    public void show() {
        if (this.f10295i) {
            b();
            d dVar = this.f10294h;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f10292f != null) {
            this.f10292f.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f10293g, false, -1));
        }
    }

    private void b() {
        if (this.f10294h == null) {
            b(this.f10287a, this.f10293g);
        }
        if (this.f10298l) {
            d dVar = this.f10294h;
            if (dVar != null) {
                dVar.a((RewardVideoListener) new NewInterstitialListenerWrapper(this.f10296j));
            }
            this.f10298l = false;
        }
        if (this.f10301o) {
            MBridgeGlobalCommon.setAlertDialogText(this.f10293g, this.f10288b, this.f10289c, this.f10290d, this.f10291e);
            this.f10301o = false;
        }
        d dVar2 = this.f10294h;
        if (dVar2 != null) {
            dVar2.a(this.f10302p, this.f10304r, this.f10303q);
            this.f10294h.a(this.f10297k);
        }
    }

    public void setIVRewardEnable(int i5, double d5) {
        this.f10302p = i5;
        this.f10303q = (int) (d5 * 100.0d);
        this.f10304r = com.mbridge.msdk.foundation.same.a.f9167J;
    }

    private void a() {
        if (this.f10292f == null) {
            a(this.f10287a, this.f10293g);
        }
        if (this.f10299m) {
            a aVar = this.f10292f;
            if (aVar != null) {
                aVar.a((InterVideoOutListener) new com.mbridge.msdk.newinterstitial.a.a(this.f10296j, this.f10293g, false));
            }
            this.f10299m = false;
        }
        if (this.f10300n) {
            a aVar2 = this.f10292f;
            if (aVar2 != null) {
                aVar2.a(this.f10288b, this.f10289c, this.f10290d, this.f10291e);
            }
            this.f10300n = false;
        }
        a aVar3 = this.f10292f;
        if (aVar3 != null) {
            aVar3.a(this.f10302p, this.f10304r, this.f10303q);
            this.f10292f.a(this.f10297k);
        }
    }

    public MBNewInterstitialHandler(String str, String str2) {
        this.f10287a = str;
        this.f10293g = str2;
    }
}
