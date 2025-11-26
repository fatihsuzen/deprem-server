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

@Deprecated
public class MBBidInterstitialVideoHandler implements BaseExtraInterfaceForHandler {

    /* renamed from: a  reason: collision with root package name */
    private String f10252a;

    /* renamed from: b  reason: collision with root package name */
    private String f10253b;

    /* renamed from: c  reason: collision with root package name */
    private String f10254c;

    /* renamed from: d  reason: collision with root package name */
    private String f10255d;

    /* renamed from: e  reason: collision with root package name */
    private String f10256e;

    /* renamed from: f  reason: collision with root package name */
    private a f10257f;

    /* renamed from: g  reason: collision with root package name */
    private d f10258g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10259h = false;

    /* renamed from: i  reason: collision with root package name */
    private NewInterstitialListener f10260i;

    /* renamed from: j  reason: collision with root package name */
    private int f10261j = 2;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10262k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10263l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10264m = false;
    public String mUnitId;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10265n = false;

    /* renamed from: o  reason: collision with root package name */
    private int f10266o;

    /* renamed from: p  reason: collision with root package name */
    private int f10267p;

    /* renamed from: q  reason: collision with root package name */
    private int f10268q;

    public MBBidInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String e5 = ak.e(str2);
        if (!TextUtils.isEmpty(e5)) {
            ak.b(str2, e5);
        }
        this.mUnitId = str2;
        this.f10252a = str;
    }

    private void a(String str, String str2) {
        try {
            if (this.f10257f == null) {
                a aVar = new a();
                this.f10257f = aVar;
                aVar.a(true);
                this.f10257f.b(true);
                this.f10257f.b(str, str2);
            }
        } catch (Throwable th) {
            af.b("MBBidInterstitialVideoHandler", th.getMessage(), th);
        }
    }

    private void b(String str, String str2) {
        if (this.f10258g == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.f10258g = new d(287, str, str2, true);
        }
    }

    private void c() {
        if (this.f10258g == null) {
            b(this.f10252a, this.mUnitId);
        }
        d();
    }

    private void d() {
        if (this.f10262k) {
            d dVar = this.f10258g;
            if (dVar != null) {
                dVar.a((RewardVideoListener) new NewInterstitialListenerWrapper(this.f10260i));
            }
            this.f10262k = false;
        }
        if (this.f10265n) {
            MBridgeGlobalCommon.setAlertDialogText(this.mUnitId, this.f10254c, this.f10253b, this.f10255d, this.f10256e);
            this.f10265n = false;
        }
        d dVar2 = this.f10258g;
        if (dVar2 != null) {
            dVar2.a(this.f10266o, this.f10268q, this.f10267p);
            this.f10258g.a(this.f10261j);
        }
    }

    public void clearVideoCache() {
        if (!this.f10259h) {
            try {
                if (this.f10257f != null) {
                    ad.b();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f10259h) {
            d dVar = this.f10258g;
            if (dVar != null) {
                return dVar.c();
            }
            return "";
        }
        a aVar = this.f10257f;
        if (aVar != null) {
            return aVar.d();
        }
        return "";
    }

    public String getRequestId() {
        if (this.f10259h) {
            d dVar = this.f10258g;
            if (dVar != null) {
                return dVar.b();
            }
            return "";
        }
        a aVar = this.f10257f;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public boolean isBidReady() {
        if (this.f10259h) {
            d dVar = this.f10258g;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f10257f;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f10259h = a5;
        if (a5) {
            c();
            d dVar = this.f10258g;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        a();
        if (this.f10257f != null) {
            this.f10257f.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.mUnitId, true, 1));
        }
    }

    public void loadFromBid(String str) {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f10259h = a5;
        if (a5) {
            c();
            d dVar = this.f10258g;
            if (dVar != null) {
                dVar.a(true, str);
                return;
            }
            return;
        }
        a();
        if (this.f10257f != null) {
            this.f10257f.a(true, str, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.mUnitId, true, 2));
        }
    }

    public void playVideoMute(int i5) {
        this.f10261j = i5;
        if (this.f10259h) {
            d dVar = this.f10258g;
            if (dVar != null) {
                dVar.a(i5);
                return;
            }
            return;
        }
        a aVar = this.f10257f;
        if (aVar != null) {
            aVar.a(i5);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f10254c = str;
        this.f10253b = str2;
        this.f10255d = str3;
        this.f10256e = str4;
        this.f10265n = true;
        this.f10264m = true;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(this.mUnitId, jSONObject);
    }

    public void setIVRewardEnable(int i5, int i6) {
        this.f10266o = i5;
        this.f10267p = i6;
        this.f10268q = com.mbridge.msdk.foundation.same.a.f9168K;
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f10260i = newInterstitialListener;
        this.f10262k = true;
        this.f10263l = true;
    }

    @Deprecated
    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f10260i = newInterstitialListener;
        this.f10262k = true;
        this.f10263l = true;
    }

    public void showFromBid() {
        if (this.f10259h) {
            c();
            d dVar = this.f10258g;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f10257f != null) {
            this.f10257f.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.mUnitId, false, -1));
        }
    }

    private void b() {
        if (this.f10263l) {
            a aVar = this.f10257f;
            if (aVar != null) {
                aVar.a((InterVideoOutListener) new com.mbridge.msdk.newinterstitial.a.a(this.f10260i));
            }
            this.f10263l = false;
        }
        if (this.f10264m) {
            a aVar2 = this.f10257f;
            if (aVar2 != null) {
                aVar2.a(this.f10254c, this.f10253b, this.f10255d, this.f10256e);
            }
            this.f10264m = false;
        }
        a aVar3 = this.f10257f;
        if (aVar3 != null) {
            aVar3.a(this.f10266o, this.f10268q, this.f10267p);
            this.f10257f.a(this.f10261j);
        }
    }

    public void setIVRewardEnable(int i5, double d5) {
        this.f10266o = i5;
        this.f10267p = (int) (d5 * 100.0d);
        this.f10268q = com.mbridge.msdk.foundation.same.a.f9167J;
    }

    private void a() {
        if (this.f10257f == null) {
            a(this.f10252a, this.mUnitId);
        }
        b();
    }

    public MBBidInterstitialVideoHandler(String str, String str2) {
        this.mUnitId = str2;
        this.f10252a = str;
    }
}
