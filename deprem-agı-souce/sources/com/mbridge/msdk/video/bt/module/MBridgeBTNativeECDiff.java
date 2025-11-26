package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.signal.a.k;

public class MBridgeBTNativeECDiff extends BTBaseView {
    public View ctaView;

    public MBridgeBTNativeECDiff(Context context) {
        super(context);
    }

    public boolean checkChinaProgressBarStatus() {
        return false;
    }

    public void doChinaJumpClick(Context context, k kVar) {
    }

    public void init(Context context) {
    }

    public void onDestory() {
    }

    public void setChinaCTAData(CampaignEx campaignEx) {
    }

    public MBridgeBTNativeECDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
