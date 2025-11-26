package com.mbridge.msdk.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.R;
import com.mbridge.msdk.click.a;
import com.mbridge.msdk.click.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.video.signal.h;

public abstract class MBridgeH5EndCardViewDiff extends MBridgeBaseView implements i, b, h {
    public String unitId;

    public MBridgeH5EndCardViewDiff(Context context) {
        super(context);
    }

    public void open(String str) {
        try {
            String clickURL = this.f12294b.getClickURL();
            if (!TextUtils.isEmpty(str)) {
                this.f12294b.setClickURL(str);
                reportOpen(str);
            }
            a aVar = new a(getContext(), this.unitId);
            aVar.a((i) this);
            aVar.a(this.f12294b);
            this.f12294b.setClickURL(clickURL);
            this.notifyListener.a(R.styleable.AppCompatTheme_windowNoTitle, "");
        } catch (Exception e5) {
            af.b(MBridgeBaseView.TAG, e5.getMessage());
        }
    }

    public void reportOpen(String str) {
        CampaignEx mraidCampaign = getMraidCampaign();
        if (mraidCampaign != null) {
            new com.mbridge.msdk.foundation.same.report.h(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.unitId, str, this.f12294b.isBidCampaign());
        }
    }

    public MBridgeH5EndCardViewDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
