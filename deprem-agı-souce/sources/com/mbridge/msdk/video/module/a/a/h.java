package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

public final class h extends k {
    public h(CampaignEx campaignEx, a aVar, c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i5, boolean z4) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i5, z4);
    }

    public final void a(int i5, Object obj) {
        if (i5 == 100) {
            g();
            f();
            e();
            a(2);
        } else if (i5 == 109) {
            b(2);
        } else if (i5 == 122) {
            a();
        } else if (i5 != 129) {
            String str = "";
            if (i5 == 118) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(3, str);
            } else if (i5 == 119) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(4, str);
            }
        } else {
            CampaignEx campaignEx = this.f12582b;
            if (campaignEx != null && campaignEx.getPlayable_ads_without_video() == 2) {
                g();
                f();
                e();
                a(1);
            }
        }
        super.a(i5, obj);
    }
}
