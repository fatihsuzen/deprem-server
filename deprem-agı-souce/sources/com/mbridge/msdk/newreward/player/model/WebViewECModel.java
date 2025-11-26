package com.mbridge.msdk.newreward.player.model;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.imodel.IECModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectType;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

public class WebViewECModel extends BaseWebContentModel implements IECModel {
    private final String TAG = "WebViewECModel";
    boolean adCloseState = false;
    boolean adShownState = false;
    boolean addRewardState = false;
    boolean endCardShowState = false;
    boolean eventImpression = false;
    boolean eventOnlyImpression = false;
    boolean eventPvUrls = false;
    boolean eventTrackingImp = false;
    boolean muteState = false;
    RewardVideoListener rewardVideoListener;
    boolean trackClick = false;
    boolean trackEndCardShow = false;
    boolean trackPause = false;
    boolean trackPlayError = false;
    boolean trackResume = false;
    boolean videoComPleteState = false;

    public WebViewECModel(c cVar, e eVar) {
        this.mCommandManager = cVar;
        this.mAdapterModel = eVar;
        this.rewardVideoListener = eVar.K();
    }

    public boolean eventAddReward(RedirectModel redirectModel) {
        if (this.addRewardState) {
            return true;
        }
        this.addRewardState = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.ADD_REWARD));
        return false;
    }

    public boolean eventClickUrl(RedirectModel redirectModel) {
        return false;
    }

    public void eventImpression(RedirectModel redirectModel) {
        if (!this.eventImpression) {
            this.eventImpression = true;
            af.b("WebViewECModel", "触发了eventImpression，url为--》" + redirectModel.getCampaignEx().getImpressionURL());
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.IMPRESSION_URL));
        }
    }

    public void eventNoticeUrl(RedirectModel redirectModel, int i5) {
    }

    public void eventOnlyImpression(RedirectModel redirectModel) {
        if (!this.eventOnlyImpression) {
            this.eventOnlyImpression = true;
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.ONLY_IMPRESSION_URL));
            af.b("WebViewECModel", "触发了eventOnlyImpression，url为--》" + redirectModel.getCampaignEx().getOnlyImpressionURL());
        }
    }

    public void eventPvUrls(RedirectModel redirectModel) {
        if (!this.eventPvUrls) {
            this.eventPvUrls = true;
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.PV_URL));
        }
    }

    public boolean eventTrackingForClick(RedirectModel redirectModel) {
        if (this.trackClick) {
            return true;
        }
        this.trackClick = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_CLICK_URL));
        return false;
    }

    public void eventTrackingForEndCardShow(RedirectModel redirectModel, @BridgeParameter(key = "type") int i5) {
        if (!this.trackEndCardShow) {
            this.trackEndCardShow = true;
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_EC_SHOW_URL));
        }
    }

    public boolean eventTrackingForImpression(RedirectModel redirectModel) {
        if (this.eventTrackingImp) {
            return true;
        }
        this.eventTrackingImp = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_IMPRESSION_URL));
        return false;
    }

    public void eventTrackingForMute(RedirectModel redirectModel) {
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_MUTE_URL));
    }

    public void eventTrackingForUnMute(RedirectModel redirectModel) {
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_UN_MUTE_URL));
    }

    public void onAdClick(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener2 = this.rewardVideoListener;
        if (rewardVideoListener2 != null) {
            rewardVideoListener2.onVideoAdClicked(mBridgeIds);
        }
    }

    public boolean onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo, @BridgeParameter(key = "type") int i5) {
        if (this.adCloseState) {
            return true;
        }
        this.adCloseState = true;
        RewardVideoListener rewardVideoListener2 = this.rewardVideoListener;
        if (rewardVideoListener2 == null) {
            return false;
        }
        rewardVideoListener2.onAdClose(mBridgeIds, rewardInfo);
        return false;
    }

    public void onAdCloseWithIVReward(MBridgeIds mBridgeIds, boolean z4, int i5) {
        RewardVideoListener rewardVideoListener2 = this.rewardVideoListener;
        if (rewardVideoListener2 != null) {
            rewardVideoListener2.onAdCloseWithIVReward(mBridgeIds, z4, i5);
        }
    }

    public boolean onAdShow(MBridgeIds mBridgeIds) {
        if (this.adShownState) {
            return true;
        }
        this.adShownState = true;
        if (this.rewardVideoListener == null) {
            return false;
        }
        this.mAdapterModel.j(true);
        this.rewardVideoListener.onAdShow(mBridgeIds);
        return false;
    }

    public void onCloseViewClick(int i5) {
    }

    public void onEndCardShow(MBridgeIds mBridgeIds, @BridgeParameter(key = "type") int i5) {
        RewardVideoListener rewardVideoListener2 = this.rewardVideoListener;
        if (rewardVideoListener2 != null && !this.endCardShowState) {
            this.endCardShowState = true;
            rewardVideoListener2.onEndcardShow(mBridgeIds);
        }
    }

    public boolean onShowFail(MBridgeIds mBridgeIds, String str, int i5) {
        if (this.adShownState) {
            return true;
        }
        this.adShownState = true;
        if (this.rewardVideoListener == null) {
            return false;
        }
        this.mAdapterModel.j(true);
        this.rewardVideoListener.onShowFail(mBridgeIds, str);
        return false;
    }

    public void onVideoComplete(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener2;
        if (!this.videoComPleteState && (rewardVideoListener2 = this.rewardVideoListener) != null) {
            this.videoComPleteState = true;
            rewardVideoListener2.onVideoComplete(mBridgeIds);
        }
    }

    /* access modifiers changed from: protected */
    public void sendDirectEvent(RedirectModel redirectModel) {
        c cVar = this.mCommandManager;
        cVar.f(cVar.a("campaign_redirect", redirectModel), f.CAMPAIGN_REDIRECT);
    }

    public void setRewardVideoListener(RewardVideoListener rewardVideoListener2) {
        this.rewardVideoListener = rewardVideoListener2;
    }
}
