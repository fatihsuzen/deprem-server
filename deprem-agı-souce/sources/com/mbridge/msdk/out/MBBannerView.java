package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbbanner.a.a;
import org.json.JSONObject;

public class MBBannerView extends RelativeLayout implements BaseExtraInterfaceForHandler {
    private String bidToken;
    /* access modifiers changed from: private */
    public a controller;
    private boolean hadAttached;
    private boolean isVisible;
    private BannerAdListener mBannerAdListener;
    private MBridgeIds mBridgeIds;
    private String unitId;

    public MBBannerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void callbackAndReportFail(c cVar, b bVar) {
        String str = "";
        if (bVar != null) {
            try {
                str = bVar.b();
            } catch (Throwable th) {
                af.b("BannerView", th.getMessage());
            }
        }
        cVar.a(bVar);
        cVar.c(true);
        com.mbridge.msdk.mbbanner.common.d.a.a("2000047", cVar, (e) null);
        BannerAdListener bannerAdListener = this.mBannerAdListener;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.mBridgeIds, str);
        }
    }

    private void delayedNotify() {
        postDelayed(new Runnable() {
            public void run() {
                if (MBBannerView.this.controller != null && !com.mbridge.msdk.foundation.d.b.f8931c) {
                    MBBannerView.this.controller.c(true);
                }
            }
        }, 200);
    }

    private void updateAttachedState(boolean z4) {
        this.hadAttached = z4;
        a aVar = this.controller;
        if (aVar != null) {
            aVar.b(z4);
        }
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.controller;
        if (aVar != null) {
            return aVar.b();
        }
        return "";
    }

    public String getRequestId() {
        a aVar = this.controller;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public void init(BannerSize bannerSize, String str, String str2) {
        String str3;
        this.unitId = str2;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            str3 = str;
        }
        this.mBridgeIds = new MBridgeIds(str3, str2);
        String e5 = ak.e(str2);
        if (!TextUtils.isEmpty(e5)) {
            ak.b(str2, e5);
        }
        a aVar = new a(this, bannerSize, str, str2);
        this.controller = aVar;
        aVar.c(this.isVisible);
        this.controller.b(this.hadAttached);
    }

    public void load() {
        String a5 = com.mbridge.msdk.mbbanner.common.d.a.a(this.bidToken);
        c a6 = com.mbridge.msdk.mbbanner.common.d.a.a(this.unitId, a5);
        a6.i("0");
        a aVar = this.controller;
        if (aVar != null) {
            aVar.b(this.hadAttached);
            this.controller.a("", a5);
            return;
        }
        b bVar = new b(880042);
        bVar.b(a5);
        callbackAndReportFail(a6, bVar);
    }

    public void loadFromBid(String str) {
        this.bidToken = str;
        String a5 = com.mbridge.msdk.mbbanner.common.d.a.a(str);
        c a6 = com.mbridge.msdk.mbbanner.common.d.a.a(this.unitId, a5);
        a6.i("1");
        if (this.controller == null) {
            b bVar = new b(880042);
            bVar.b(a5);
            callbackAndReportFail(a6, bVar);
        } else if (!TextUtils.isEmpty(str)) {
            this.controller.b(this.hadAttached);
            this.controller.a(0);
            this.controller.a(str, a5);
        } else {
            b bVar2 = new b(880035);
            bVar2.b(a5);
            callbackAndReportFail(a6, bVar2);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateAttachedState(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        updateAttachedState(false);
    }

    public void onPause() {
        if (this.controller != null && TextUtils.isEmpty(this.bidToken)) {
            this.controller.e();
        }
    }

    public void onResume() {
        if (this.controller != null && TextUtils.isEmpty(this.bidToken) && !com.mbridge.msdk.foundation.d.b.f8931c) {
            this.controller.f();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(i5, i6, i7, i8);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i5) {
        boolean z4;
        super.onVisibilityChanged(view, i5);
        if (i5 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.isVisible = z4;
        a aVar = this.controller;
        if (aVar == null) {
            return;
        }
        if (i5 == 0) {
            delayedNotify();
        } else {
            aVar.c(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i5) {
        boolean z4;
        super.onWindowVisibilityChanged(i5);
        if (i5 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.isVisible = z4;
        if (this.controller == null) {
            return;
        }
        if (i5 == 0) {
            delayedNotify();
        } else if (!com.mbridge.msdk.foundation.d.b.f8931c) {
            this.controller.c(false);
        }
    }

    public void release() {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener = null;
        }
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((BannerAdListener) null);
            this.controller.c();
        }
        removeAllViews();
    }

    public void setAllowShowCloseBtn(boolean z4) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(z4);
        }
    }

    public void setBannerAdListener(BannerAdListener bannerAdListener) {
        this.mBannerAdListener = bannerAdListener;
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(bannerAdListener);
        }
    }

    public void setExtraInfo(JSONObject jSONObject) {
        com.mbridge.msdk.foundation.controller.c.m().a(this.unitId, jSONObject);
    }

    public void setRefreshTime(int i5) {
        a aVar = this.controller;
        if (aVar != null && i5 >= 0) {
            aVar.a(i5);
        }
    }

    public void updateBannerSize(BannerSize bannerSize) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(bannerSize);
        }
    }

    public MBBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBBannerView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.hadAttached = false;
        this.isVisible = false;
        com.mbridge.msdk.foundation.controller.c.m().a(context);
    }
}
