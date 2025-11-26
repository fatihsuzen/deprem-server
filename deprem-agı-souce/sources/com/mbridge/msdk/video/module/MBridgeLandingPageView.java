package com.mbridge.msdk.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.video.signal.factory.b;

public class MBridgeLandingPageView extends MBridgeH5EndCardView {

    private static final class a implements com.mbridge.msdk.mbsignalcommon.base.a {
        private a() {
        }

        public final boolean a(String str) {
            if (TextUtils.isEmpty(str) || URLUtil.isNetworkUrl(str)) {
                return false;
            }
            aj.a(c.m().c(), str, (BaseTrackingListener) null);
            return true;
        }
    }

    public MBridgeLandingPageView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final String a() {
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null) {
            return com.mbridge.msdk.click.c.a(campaignEx.getClickURL(), "-999", "-999");
        }
        return null;
    }

    public void init(Context context) {
        super.init(context);
    }

    public void preLoadData(b bVar) {
        if (this.f12297e) {
            this.f12380p.setFilter(new a());
        }
        super.preLoadData(bVar);
        setVisibility(0);
        setCloseVisible(0);
    }

    public void webviewshow() {
        try {
            af.a(MBridgeBaseView.TAG, "webviewshow");
            g.a().a((WebView) this.f12380p, "webviewshow", "");
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public MBridgeLandingPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
