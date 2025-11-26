package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.mbridge.msdk.click.a;
import com.mbridge.msdk.click.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.video.signal.a.k;

public abstract class MBridgeBTWebViewDiff extends BTBaseView implements i, b {
    public k jsCommon;
    public WindVaneWebView webView;

    public MBridgeBTWebViewDiff(Context context) {
        super(context);
    }

    public void open(String str) {
        try {
            String clickURL = this.f11820b.getClickURL();
            if (!TextUtils.isEmpty(str)) {
                this.f11820b.setClickURL(str);
                reportOpen(str);
            }
            a aVar = new a(getContext(), this.f11821c);
            aVar.a((i) this);
            aVar.a(this.f11820b);
            this.f11820b.setClickURL(clickURL);
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage());
        }
    }

    public void reportOpen(String str) {
        try {
            CampaignEx mraidCampaign = getMraidCampaign();
            if (mraidCampaign != null) {
                new h(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.f11821c, str, this.f11820b.isBidCampaign());
            }
        } catch (Throwable th) {
            af.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void setChinaAlertInstallState(k kVar) {
    }

    public MBridgeBTWebViewDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
