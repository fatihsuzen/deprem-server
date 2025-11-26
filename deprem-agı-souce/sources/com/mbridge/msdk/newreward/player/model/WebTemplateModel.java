package com.mbridge.msdk.newreward.player.model;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.imodel.IPlayModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectType;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

public class WebTemplateModel extends BaseWebContentModel implements IPlayModel {
    private static final String TAG = "WebTemplateModel";
    boolean adCloseState = false;
    boolean adShownState = false;
    boolean adUrlList = false;
    boolean addRewardState = false;
    boolean advImpList = false;
    boolean eventImpression = false;
    boolean eventOnlyImpression = false;
    boolean eventPvUrls = false;
    boolean eventTrackingImp = false;
    boolean muteState = false;
    RewardVideoListener rewardVideoListener;
    boolean trackClick = false;
    boolean trackClose = false;
    boolean trackPause = false;
    boolean trackPlayError = false;
    boolean trackResume = false;
    boolean videoCompleteState = false;

    public WebTemplateModel(c cVar, e eVar) {
        this.mCommandManager = cVar;
        this.mAdapterModel = eVar;
        this.rewardVideoListener = eVar.K();
    }

    public void checkOMSdkProgress(int i5, int i6) {
    }

    public void eventAdUrlList(RedirectModel redirectModel) {
        if (!this.adUrlList) {
            this.adUrlList = true;
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_URL_LIST));
        }
    }

    public boolean eventAddReward(RedirectModel redirectModel) {
        if (this.addRewardState) {
            return true;
        }
        this.addRewardState = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.ADD_REWARD));
        return false;
    }

    public void eventAdvImpList(RedirectModel redirectModel) {
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.ADV_IMP_LIST));
    }

    public boolean eventClickUrl(RedirectModel redirectModel) {
        if (this.mCommandManager == null) {
            return false;
        }
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.CLICK_URL));
        return true;
    }

    public void eventImpression(RedirectModel redirectModel) {
        if (!this.eventImpression) {
            this.eventImpression = true;
            af.b(TAG, "触发了eventImpression，url为--》" + redirectModel.getCampaignEx().getImpressionURL());
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.IMPRESSION_URL));
        }
    }

    public void eventNoticeUrl(RedirectModel redirectModel, int i5) {
        if (this.mCommandManager != null) {
            redirectModel.setRedirectType(RedirectType.NOTICE_URL);
            c cVar = this.mCommandManager;
            cVar.f(cVar.a("campaign_redirect", redirectModel, "click_scenario", Integer.valueOf(i5)), f.CAMPAIGN_REDIRECT);
        }
    }

    public void eventOnlyImpression(RedirectModel redirectModel) {
        if (!this.eventOnlyImpression) {
            this.eventOnlyImpression = true;
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.ONLY_IMPRESSION_URL));
            af.b(TAG, "触发了eventOnlyImpression，url为--》" + redirectModel.getCampaignEx().getOnlyImpressionURL());
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

    public boolean eventTrackingForClose(RedirectModel redirectModel) {
        if (this.trackClose) {
            return true;
        }
        this.trackClose = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_CLOSE_URL));
        return false;
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

    public void eventTrackingForPause(RedirectModel redirectModel) {
        if (!this.trackPause) {
            this.trackPause = true;
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_PAUSE));
        }
    }

    public void eventTrackingForPlayError(RedirectModel redirectModel, @BridgeParameter(key = "reason") String str) {
        if (!this.trackPlayError) {
            this.trackPlayError = true;
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_ERROR));
        }
    }

    public void eventTrackingForPlayPercentage(RedirectModel redirectModel, @BridgeParameter(key = "percent") int i5) {
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_PLAY_PERCENTAGE));
    }

    public void eventTrackingForResume(RedirectModel redirectModel) {
        if (!this.trackResume) {
            this.trackResume = true;
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_RESUME));
        }
    }

    public void eventTrackingForUnMute(RedirectModel redirectModel) {
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_UN_MUTE_URL));
    }

    public void historyShowState() {
    }

    public void modelReport(String str) {
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

    public void onBufferingEnd() {
    }

    public void onBufferingStart(String str) {
    }

    public boolean onShowFail(MBridgeIds mBridgeIds, String str, @BridgeParameter(key = "code") int i5) {
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
        if (!this.videoCompleteState && (rewardVideoListener2 = this.rewardVideoListener) != null) {
            this.videoCompleteState = true;
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

    public void skipped() {
    }

    public void modelReport(String str, com.mbridge.msdk.foundation.same.report.d.e eVar) {
    }
}
