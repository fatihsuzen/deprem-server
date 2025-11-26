package com.mbridge.msdk.newreward.player.model;

import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.imodel.IECModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectType;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

public class ECTempleModel extends BaseModel implements IECModel {
    boolean adCloseState = false;
    boolean adShownState = false;
    boolean addRewardState = false;
    boolean endCardShowState = false;
    boolean eventImpression = false;
    boolean eventOnlyImpression = false;
    boolean eventPvUrls = false;
    boolean eventTrackingImp = false;
    RewardVideoListener rewardVideoListener;
    boolean trackClick = false;
    boolean trackClose = false;
    boolean trackEndCardShow = false;

    public ECTempleModel(c cVar, RewardVideoListener rewardVideoListener2) {
        super(cVar);
        this.rewardVideoListener = rewardVideoListener2;
    }

    public boolean eventAddReward(RedirectModel redirectModel) {
        if (this.addRewardState) {
            return true;
        }
        this.addRewardState = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.ADD_REWARD));
        return false;
    }

    public void eventImpression(RedirectModel redirectModel) {
        if (!this.eventImpression) {
            this.eventImpression = true;
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.IMPRESSION_URL));
        }
    }

    public void eventOnlyImpression(RedirectModel redirectModel) {
        if (!this.eventOnlyImpression) {
            this.eventOnlyImpression = true;
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.ONLY_IMPRESSION_URL));
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

    public int getRenderStatus() {
        return 0;
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
        RewardVideoListener rewardVideoListener2 = this.rewardVideoListener;
        if (rewardVideoListener2 == null) {
            return false;
        }
        rewardVideoListener2.onAdShow(mBridgeIds);
        return false;
    }

    public void onCloseViewClick(@BridgeParameter(key = "type") int i5) {
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
        RewardVideoListener rewardVideoListener2 = this.rewardVideoListener;
        if (rewardVideoListener2 == null) {
            return false;
        }
        rewardVideoListener2.onShowFail(mBridgeIds, str);
        return false;
    }

    public void setRenderStatus(int i5) {
    }
}
