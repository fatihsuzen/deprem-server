package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;

public final class a implements InterVideoOutListener {

    /* renamed from: a  reason: collision with root package name */
    private g f12010a;

    /* renamed from: b  reason: collision with root package name */
    private String f12011b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12012c;

    public a(g gVar, String str, boolean z4) {
        this.f12010a = gVar;
        this.f12011b = str;
        this.f12012c = z4;
    }

    public final void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        g gVar = this.f12010a;
        if (gVar != null) {
            gVar.onAdClose(mBridgeIds, rewardInfo);
        }
    }

    public final void onAdCloseWithIVReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
    }

    public final void onAdShow(MBridgeIds mBridgeIds) {
        g gVar = this.f12010a;
        if (gVar != null) {
            gVar.onAdShow(mBridgeIds);
        }
    }

    public final void onEndcardShow(MBridgeIds mBridgeIds) {
        g gVar = this.f12010a;
        if (gVar != null) {
            gVar.onEndcardShow(mBridgeIds);
        }
    }

    public final void onLoadSuccess(MBridgeIds mBridgeIds) {
        g gVar = this.f12010a;
        if (gVar != null) {
            gVar.onLoadSuccess(mBridgeIds);
        }
    }

    public final void onShowFail(c cVar, MBridgeIds mBridgeIds, String str) {
        g gVar = this.f12010a;
        if (gVar != null) {
            gVar.onShowFail(mBridgeIds, str);
        }
    }

    public final void onVideoAdClicked(boolean z4, MBridgeIds mBridgeIds) {
        g gVar = this.f12010a;
        if (gVar != null) {
            gVar.onVideoAdClicked(mBridgeIds);
        }
    }

    public final void onVideoComplete(MBridgeIds mBridgeIds) {
        g gVar = this.f12010a;
        if (gVar != null) {
            gVar.onVideoComplete(mBridgeIds);
        }
    }

    public final void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        g gVar = this.f12010a;
        if (gVar != null) {
            gVar.onVideoLoadFail(mBridgeIds, str);
        }
    }

    public final void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
        g gVar = this.f12010a;
        if (gVar != null) {
            gVar.onVideoLoadSuccess(mBridgeIds);
        }
    }

    public a(g gVar) {
        this.f12011b = "";
        this.f12010a = gVar;
    }
}
