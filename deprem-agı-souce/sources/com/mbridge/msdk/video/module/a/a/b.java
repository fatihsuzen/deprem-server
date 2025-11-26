package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

public final class b extends d {

    /* renamed from: k  reason: collision with root package name */
    private MBridgeVideoView f12570k;

    /* renamed from: l  reason: collision with root package name */
    private MBridgeContainerView f12571l;

    public b(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, c cVar, a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i5, boolean z4) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i5, z4);
        this.f12570k = mBridgeVideoView;
        this.f12571l = mBridgeContainerView;
        if (mBridgeVideoView == null || mBridgeContainerView == null) {
            this.f12581a = false;
        }
    }

    public final void a(int i5, Object obj) {
        if (this.f12581a) {
            if (i5 == 8) {
                MBridgeContainerView mBridgeContainerView = this.f12571l;
                if (mBridgeContainerView == null) {
                    MBridgeVideoView mBridgeVideoView = this.f12570k;
                    if (mBridgeVideoView != null) {
                        mBridgeVideoView.showAlertView();
                    }
                } else if (!mBridgeContainerView.showAlertWebView()) {
                    MBridgeVideoView mBridgeVideoView2 = this.f12570k;
                    if (mBridgeVideoView2 != null) {
                        mBridgeVideoView2.showAlertView();
                    }
                } else {
                    MBridgeVideoView mBridgeVideoView3 = this.f12570k;
                    if (mBridgeVideoView3 != null) {
                        mBridgeVideoView3.alertWebViewShowed();
                    }
                }
            } else if (i5 == 107) {
                this.f12571l.showVideoClickView(-1);
                this.f12570k.setCover(false);
                this.f12570k.setMiniEndCardState(false);
                this.f12570k.videoOperate(1);
            } else if (i5 == 112) {
                this.f12570k.setCover(true);
                this.f12570k.setMiniEndCardState(true);
                this.f12570k.videoOperate(2);
            } else if (i5 == 115) {
                this.f12571l.resizeMiniCard(this.f12570k.getBorderViewWidth(), this.f12570k.getBorderViewHeight(), this.f12570k.getBorderViewRadius());
            }
        }
        super.a(i5, obj);
    }
}
