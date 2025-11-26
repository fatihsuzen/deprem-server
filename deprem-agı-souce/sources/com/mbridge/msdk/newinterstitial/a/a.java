package com.mbridge.msdk.newinterstitial.a;

import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.newinterstitial.out.NewInterstitialListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;

public final class a implements InterVideoOutListener {

    /* renamed from: a  reason: collision with root package name */
    private NewInterstitialListener f10249a;

    /* renamed from: b  reason: collision with root package name */
    private String f10250b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10251c;

    public a(NewInterstitialListener newInterstitialListener) {
        this.f10249a = newInterstitialListener;
    }

    public final void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        NewInterstitialListener newInterstitialListener = this.f10249a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onAdClose(mBridgeIds, rewardInfo);
        }
    }

    public final void onAdCloseWithIVReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        NewInterstitialListener newInterstitialListener = this.f10249a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onAdCloseWithNIReward(mBridgeIds, rewardInfo);
        }
    }

    public final void onAdShow(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.f10249a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onAdShow(mBridgeIds);
        }
    }

    public final void onEndcardShow(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.f10249a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onEndcardShow(mBridgeIds);
        }
    }

    public final void onLoadSuccess(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.f10249a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onLoadCampaignSuccess(mBridgeIds);
        }
    }

    public final void onShowFail(c cVar, MBridgeIds mBridgeIds, String str) {
        NewInterstitialListener newInterstitialListener = this.f10249a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onShowFail(mBridgeIds, str);
        }
    }

    public final void onVideoAdClicked(boolean z4, MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.f10249a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onAdClicked(mBridgeIds);
        }
    }

    public final void onVideoComplete(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.f10249a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onVideoComplete(mBridgeIds);
        }
    }

    public final void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        NewInterstitialListener newInterstitialListener = this.f10249a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onResourceLoadFail(mBridgeIds, str);
        }
    }

    public final void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.f10249a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onResourceLoadSuccess(mBridgeIds);
        }
    }

    public a(NewInterstitialListener newInterstitialListener, String str, boolean z4) {
        this.f10249a = newInterstitialListener;
        this.f10250b = str;
        this.f10251c = z4;
    }
}
