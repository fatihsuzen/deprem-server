package com.mbridge.msdk.video.module.a.a;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.b.b;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

public class d extends k {
    public d(CampaignEx campaignEx, a aVar, c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i5, boolean z4) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i5, z4);
    }

    public void a(int i5, Object obj) {
        super.a(i5, obj);
        if (this.f12581a) {
            try {
                CampaignEx campaignEx = this.f12582b;
                if (campaignEx != null && campaignEx.getDynamicTempCode() == 5) {
                    b(obj.toString());
                }
            } catch (Exception unused) {
            }
            if (i5 == 105 || i5 == 106 || i5 == 113) {
                b.d(com.mbridge.msdk.foundation.controller.c.m().c(), this.f12582b);
                if (i5 != 105) {
                    String noticeUrl = this.f12582b.getNoticeUrl();
                    if (!TextUtils.isEmpty(noticeUrl)) {
                        if (!noticeUrl.contains(com.mbridge.msdk.foundation.same.a.f9194m)) {
                            noticeUrl = noticeUrl + "&" + com.mbridge.msdk.foundation.same.a.f9194m + "=2";
                        } else {
                            noticeUrl = noticeUrl.replace(com.mbridge.msdk.foundation.same.a.f9194m + "=" + Uri.parse(noticeUrl).getQueryParameter(com.mbridge.msdk.foundation.same.a.f9194m), com.mbridge.msdk.foundation.same.a.f9194m + "=2");
                        }
                    }
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f12582b, this.f12587g, noticeUrl, true, false, com.mbridge.msdk.click.a.a.f8071i);
                }
            } else if (i5 != 122) {
                switch (i5) {
                    case 109:
                        b(2);
                        a(2);
                        return;
                    case 110:
                        b(1);
                        a(1);
                        return;
                    case 111:
                        a(1);
                        return;
                    default:
                        return;
                }
            } else {
                a();
            }
        }
    }
}
