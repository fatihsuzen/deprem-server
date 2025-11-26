package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.videocommon.download.a;

public final class c extends d {

    /* renamed from: k  reason: collision with root package name */
    private IJSFactory f12572k;

    public c(IJSFactory iJSFactory, CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i5, boolean z4) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i5, z4);
        this.f12572k = iJSFactory;
        if (iJSFactory == null) {
            this.f12581a = false;
        }
    }

    public final void a(int i5, Object obj) {
        if (this.f12581a) {
            if (i5 != 8) {
                if (i5 == 105) {
                    this.f12572k.getJSNotifyProxy().a(3, obj.toString());
                    i5 = -1;
                } else if (i5 == 107) {
                    this.f12572k.getJSContainerModule().showVideoClickView(-1);
                    this.f12572k.getJSVideoModule().setCover(false);
                    this.f12572k.getJSVideoModule().setMiniEndCardState(false);
                    this.f12572k.getJSVideoModule().videoOperate(1);
                } else if (i5 == 112) {
                    this.f12572k.getJSVideoModule().setCover(true);
                    this.f12572k.getJSVideoModule().setMiniEndCardState(true);
                    this.f12572k.getJSVideoModule().videoOperate(2);
                } else if (i5 == 115) {
                    j jSVideoModule = this.f12572k.getJSVideoModule();
                    this.f12572k.getJSContainerModule().resizeMiniCard(jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                }
            } else if (!this.f12572k.getJSContainerModule().showAlertWebView()) {
                this.f12572k.getJSVideoModule().showAlertView();
            } else {
                this.f12572k.getJSVideoModule().alertWebViewShowed();
            }
        }
        super.a(i5, obj);
    }
}
