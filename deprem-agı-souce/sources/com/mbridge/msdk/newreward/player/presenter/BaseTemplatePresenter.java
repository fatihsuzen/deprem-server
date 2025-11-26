package com.mbridge.msdk.newreward.player.presenter;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.player.imodel.IPlayModel;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.playercommon.VideoPlayerStatusListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public abstract class BaseTemplatePresenter extends AbsPresenter implements VideoPlayerStatusListener {
    private static final int AD_SCAPE_VALUE = 1;
    private static final int VIDEO_ERROR_RULE_VALUE = 1;
    private final String TAG = "BaseTemplatePresenter";
    boolean closeBtnVisible = false;
    int currentPlayProgress;
    boolean dialogContinueClicked = false;
    boolean hasIteratorPercentage = false;
    IPlayTempleView iView;
    boolean isAlertShowing = false;
    boolean isCloseBtnClicked = false;
    private ConcurrentHashMap<Integer, Integer> omsdkPercentageMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, Integer> percentageMap = new ConcurrentHashMap<>();
    public boolean playTemplateRanderSuccess = true;
    IPlayModel playTempleModel;
    private boolean progressHasDoAdSuccess = false;
    int videoCompleteTime;
    int videoSkipTime;
    int videoTotalLength;

    public BaseTemplatePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    private void advImpList(int i5) {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx != null && campaignEx.getAdvImpList() != null) {
            try {
                if (!this.campaignEx.getAdvImpList().isEmpty()) {
                    this.redirectModel.setCurrPercentAge(i5);
                    this.playTempleModel.eventAdvImpList(this.redirectModel);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    private void callbackAdClose() {
        if (isIVRewardEnable()) {
            this.playTempleModel.onAdCloseWithIVReward(this.mBridgeIds, this.adapterModel.ab(), this.ivRewardAlertViewStatus);
        }
        adClosed();
        if (this.isCloseBtnClicked) {
            this.playTempleModel.eventTrackingForClose(this.redirectModel);
        }
        if (!this.isIV && !this.adapterModel.X() && this.adapterModel.ab()) {
            this.adapterModel.i(true);
            this.playTempleModel.eventAddReward(this.redirectModel);
        }
        finish(true);
    }

    private void checkOMSdkProgress(int i5, int i6) {
        try {
            if (this.playTempleModel != null) {
                if (this.omsdkPercentageMap.isEmpty()) {
                    for (int i7 = 0; i7 <= 100; i7 += 25) {
                        this.omsdkPercentageMap.put(Integer.valueOf((i6 * i7) / 100), Integer.valueOf(i7));
                    }
                }
                if (i5 == 1 && this.omsdkPercentageMap.contains(0)) {
                    i5 = 0;
                }
                if (this.omsdkPercentageMap.containsKey(Integer.valueOf(i5))) {
                    int intValue = this.omsdkPercentageMap.get(Integer.valueOf(i5)).intValue();
                    this.omsdkPercentageMap.remove(Integer.valueOf(i5));
                    this.playTempleModel.checkOMSdkProgress(intValue, i6);
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    private void checkPlayCloseBtnState(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        if (i5 == i6) {
            this.closeBtnVisible = true;
            this.iView.setAdCloseVisibility(true);
        }
        if (!this.adapterModel.ab() && (i9 = this.videoCompleteTime) > 0 && i5 > i9) {
            this.adapterModel.m(true);
        }
        if ((!this.closeBtnVisible && (i8 = this.videoSkipTime) >= 0 && i5 >= i8) || ((i7 = this.videoCompleteTime) > 0 && i5 > i7)) {
            this.closeBtnVisible = true;
            this.iView.setAdCloseVisibility(true);
        }
    }

    private void checkTrackingForPlayPercentage(int i5, int i6) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap;
        ConcurrentHashMap<Integer, Integer> concurrentHashMap2;
        try {
            if (!this.hasIteratorPercentage && (concurrentHashMap2 = this.percentageMap) != null && concurrentHashMap2.isEmpty()) {
                this.hasIteratorPercentage = true;
                for (Map<Integer, String> entrySet : this.campaignEx.getNativeVideoTracking().i()) {
                    for (Map.Entry entry : entrySet.entrySet()) {
                        this.percentageMap.put(Integer.valueOf((int) ((((float) ((Integer) entry.getKey()).intValue()) / 100.0f) * ((float) i6))), entry.getKey());
                    }
                }
            }
            if (i5 == 1 && (concurrentHashMap = this.percentageMap) != null && concurrentHashMap.containsKey(0)) {
                i5 = 0;
            }
            ConcurrentHashMap<Integer, Integer> concurrentHashMap3 = this.percentageMap;
            if (concurrentHashMap3 != null && concurrentHashMap3.containsKey(Integer.valueOf(i5))) {
                int intValue = this.percentageMap.get(Integer.valueOf(i5)).intValue();
                this.percentageMap.remove(Integer.valueOf(i5));
                this.redirectModel.setPercentRate(intValue);
                this.playTempleModel.eventTrackingForPlayPercentage(this.redirectModel, intValue);
            }
        } catch (Exception e5) {
            af.b("BaseTemplatePresenter", e5.getMessage());
        }
    }

    private void closeOrShowHalfEndCard() {
        c cVar = this.commandManager;
        cVar.g(cVar.a("add_temple", "HALF_TEMPLATE_EC", "adapter_model", this.adapterModel, "parent_temple", this.data.getRootViewGroup()), f.SHOW_ADD_TEMPLE);
        this.iView.removeTempleFromSuperView(this.data.getRootViewGroup());
    }

    private void doVideoEndTypeLogic() {
        try {
            int i5 = this.videoEndType;
            if (i5 == 1) {
                callbackAdClose();
            } else if (i5 == 2) {
                showEndCard("");
            } else if (i5 == 3) {
                showEndCard("VAST");
            } else if (i5 == 4) {
                showEndCard("SHOW_CLICK_URL");
                IPlayModel iPlayModel = this.playTempleModel;
                if (iPlayModel != null) {
                    iPlayModel.eventTrackingForClick(this.redirectModel);
                    this.playTempleModel.eventNoticeUrl(this.redirectModel, 2);
                    this.playTempleModel.onAdClick(this.mBridgeIds);
                }
            } else if (i5 == 5) {
                com.mbridge.msdk.click.c.d(this.context, com.mbridge.msdk.click.c.a(this.campaignEx.getClickURL(), "-999", "-999"));
                IPlayModel iPlayModel2 = this.playTempleModel;
                if (iPlayModel2 != null) {
                    iPlayModel2.eventTrackingForClick(this.redirectModel);
                    this.playTempleModel.eventNoticeUrl(this.redirectModel, 2);
                    this.playTempleModel.onAdClick(this.mBridgeIds);
                }
                callbackAdClose();
            } else if (i5 != 100) {
                showEndCard("");
            } else {
                showEndCard("404");
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            finish(true);
        }
    }

    private void initCountDown() {
        c cVar = this.commandManager;
        Object d5 = cVar.d((Object) cVar.a("videoCompleteTime", Integer.valueOf(this.videoCompleteTime)), f.TEMP_PLAY_START_COUNT_DOWN);
        if (this.iView.getCountDownView() != null) {
            try {
                if (d5 instanceof Map) {
                    Map map = (Map) d5;
                    int intValue = ((Integer) map.get("width")).intValue();
                    int intValue2 = ((Integer) map.get("height")).intValue();
                    int intValue3 = ((Integer) map.get("background")).intValue();
                    int intValue4 = ((Integer) map.get("padding")).intValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iView.getCountDownView().getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = intValue;
                        layoutParams.height = intValue2;
                    }
                    this.iView.setCountDown("", intValue4, intValue3, layoutParams);
                }
            } catch (Throwable th) {
                af.b("BaseTemplatePresenter", th.getMessage());
            }
        }
    }

    private void setCountDownInfo(int i5, int i6) {
        try {
            c cVar = this.commandManager;
            Object d5 = cVar.d((Object) cVar.a("campaign", this.campaignEx, "isIV", Boolean.valueOf(this.isIV), "videoCompleteTime", Integer.valueOf(this.videoCompleteTime), "videoSkipTime", Integer.valueOf(this.videoSkipTime), "curPlayPosition", Integer.valueOf(i5), "allDuration", Integer.valueOf(i6)), f.TEMP_PLAY_PROGRESS_COUNT_DOWN);
            if ((d5 instanceof Map) && ((Integer) ((Map) d5).get("valueVisible")).intValue() == 0) {
                this.iView.setCountDown((String) ((Map) d5).get("countMsg"), 0, 0, (ViewGroup.LayoutParams) null);
            }
            IPlayTempleView iPlayTempleView = this.iView;
            if (iPlayTempleView != null && iPlayTempleView.getPrivacyButton() != null) {
                this.iView.getPrivacyButton().setTag(String.valueOf(i5));
            }
        } catch (Exception e5) {
            af.b("BaseTemplatePresenter", e5.getMessage());
        }
    }

    private void setSegmentsProgressBarState() {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx != null && campaignEx.getProgressBarShow() == 1) {
            this.iView.setSegmentsProgressBar(0);
        }
    }

    private void setSkipAndCompleteTime(int i5) {
        if (this.campaignEx.getVst() > -2) {
            this.videoSkipTime = this.campaignEx.getVst();
        } else if (this.adapterModel.x().b() != null) {
            this.videoSkipTime = this.adapterModel.x().b().e();
        }
        int videoCompleteTime2 = this.campaignEx.getVideoCompleteTime();
        this.videoCompleteTime = videoCompleteTime2;
        if (videoCompleteTime2 <= 0) {
            this.videoCompleteTime = i5;
        }
    }

    private void showEndCard(String str) {
        try {
            c cVar = this.commandManager;
            if (TextUtils.isEmpty(str)) {
                str = this.adapterModel.aj();
            }
            cVar.g(cVar.a("add_temple", str, "adapter_model", this.adapterModel, "template_type", 18, "parent_temple", this.data.getRootViewGroup()), f.SHOW_ADD_TEMPLE);
            this.iView.removeTempleFromSuperView(this.data.getRootViewGroup());
            finish(false);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    private void showIVRewardDialogOnPlayMode() {
        if (isIVRewardEnable() && this.ivRewardAlertViewStatus == a.f9163F && this.ivRewardMode == a.f9166I) {
            int i5 = this.ivRewardValueType;
            if (i5 == a.f9167J && ((int) ((((float) this.currentPlayProgress) / ((float) this.videoTotalLength)) * 100.0f)) >= this.ivRewardValue) {
                onPause();
                this.ivRewardAlertViewStatus = a.f9164G;
                this.iView.setAlertViewType(this.adapterModel.H(), 0, this.ivRewardMode);
                this.iView.alertShow();
            } else if (i5 == a.f9168K && this.currentPlayProgress >= this.ivRewardValue) {
                onPause();
                this.ivRewardAlertViewStatus = a.f9164G;
                this.iView.setAlertViewType(this.adapterModel.H(), 0, this.ivRewardMode);
                this.iView.alertShow();
            }
        }
    }

    private void updatePlayCampaignFrequence() {
        this.commandManager.a((Object) this.adapterModel, "PlayFrequenceReceiver");
    }

    private void updateSegmentsProgressBar(int i5, int i6) {
        try {
            if (this.iView.getSegmentsProgressBar() != null && this.iView.getSegmentsProgressBar().getVisibility() == 0) {
                this.iView.getSegmentsProgressBar().setProgress((i5 * 100) / i6, 0);
            }
        } catch (Exception e5) {
            af.b("BaseTemplatePresenter", e5.getMessage());
        }
    }

    public void adClosed() {
        if (!this.adapterModel.aa()) {
            this.adapterModel.l(true);
            if (this.reward != null) {
                this.playTempleModel.onAdClose(this.mBridgeIds, new RewardInfo(this.adapterModel.ab(), this.reward.a(), String.valueOf(this.reward.b())), 1);
            }
        }
    }

    public void adShowFail(String str, int i5) {
        if (!this.adapterModel.Y()) {
            this.adapterModel.j(true);
            super.adShowFail(str, i5);
            IPlayModel iPlayModel = this.playTempleModel;
            if (iPlayModel != null) {
                iPlayModel.onShowFail(this.mBridgeIds, str, i5);
            }
            finish(true);
        }
    }

    public void adShowSuccess() {
        if (!this.adapterModel.Y()) {
            super.adShowSuccess();
            if (!this.adapterModel.ah()) {
                this.playTempleModel.onAdShow(this.mBridgeIds);
                this.playTempleModel.eventOnlyImpression(this.redirectModel);
            }
            this.playTempleModel.eventImpression(this.redirectModel);
            updatePlayCampaignFrequence();
            this.playTempleModel.eventPvUrls(this.redirectModel);
            this.playTempleModel.eventTrackingForImpression(this.redirectModel);
            this.playTempleModel.eventAdUrlList(this.redirectModel);
        }
    }

    public void click(View view) {
        if (view.getId() == filterFindViewId(false, "mbridge_alertview_close_button")) {
            if (isIVRewardEnable()) {
                this.ivRewardAlertViewStatus = a.f9161D;
            }
            this.isCloseBtnClicked = true;
            this.isAlertShowing = false;
            closeAdOrShowEndCard();
            this.iView.alertDismiss();
        } else if (view.getId() == filterFindViewId(false, "mbridge_alertview_continue_button")) {
            if (isIVRewardEnable()) {
                this.ivRewardAlertViewStatus = a.f9162E;
                this.dialogContinueClicked = true;
                this.iView.setAdCloseVisibility(false);
            }
            this.isAlertShowing = false;
            this.iView.alertDismiss();
        }
    }

    public void closeAdOrShowEndCard() {
        if (isIVRewardEnable()) {
            this.adapterModel.b(this.ivRewardAlertViewStatus);
        }
        if (this.videoSkipResult == 2) {
            doVideoEndTypeLogic();
        } else {
            callbackAdClose();
        }
        if (this.isCloseBtnClicked) {
            this.playTempleModel.eventTrackingForClose(this.redirectModel);
        }
    }

    public int getBufferTimeout() {
        try {
            com.mbridge.msdk.videocommon.d.a a5 = this.adapterModel.x().a();
            if (a5 != null) {
                return (int) a5.h();
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    public void handleInterceptTouchEvent(MotionEvent motionEvent) {
        RedirectModel redirectModel = this.redirectModel;
        if (redirectModel != null && motionEvent != null) {
            redirectModel.setxInScreen(motionEvent.getRawX());
            this.redirectModel.setyInScreen(motionEvent.getRawY());
        }
    }

    public boolean isHalfScreenOffer() {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx == null || campaignEx.getAdSpaceT() != 2) {
            return false;
        }
        return true;
    }

    public void onBufferingEnd() {
        IPlayModel iPlayModel = this.playTempleModel;
        if (iPlayModel != null) {
            iPlayModel.onBufferingEnd();
        }
    }

    public void onBufferingStart(String str) {
        IPlayModel iPlayModel = this.playTempleModel;
        if (iPlayModel != null) {
            iPlayModel.onBufferingStart(str);
        }
    }

    public void onCloseButtonClick() {
        if (this.isIV) {
            this.isCloseBtnClicked = true;
            if (this.campaignEx.getAdSpaceT() != 2) {
                showIVRewardDialogOnCloseMode();
            }
        } else if (this.adapterModel.ab()) {
            this.isCloseBtnClicked = true;
            closeAdOrShowEndCard();
            return;
        } else if (this.closeAlert == 1) {
            this.isAlertShowing = true;
            this.iView.setAlertViewType(this.adapterModel.H(), 1, -1);
            this.iView.alertShow();
        } else {
            this.isCloseBtnClicked = true;
            closeAdOrShowEndCard();
        }
        if (!this.adapterModel.ab()) {
            this.playTempleModel.skipped();
        }
    }

    public void onDestroy() {
        IPlayModel iPlayModel;
        super.onDestroy();
        if (!this.adapterModel.Y()) {
            this.adapterModel.j(true);
            super.adShowFail(com.mbridge.msdk.foundation.c.a.a(890003), 890003);
            IPlayModel iPlayModel2 = this.playTempleModel;
            if (iPlayModel2 != null) {
                iPlayModel2.onShowFail(this.mBridgeIds, com.mbridge.msdk.foundation.c.a.a(890003), 890003);
            }
        }
        if (!this.adapterModel.aa()) {
            this.adapterModel.l(true);
            if (this.reward != null && (iPlayModel = this.playTempleModel) != null) {
                iPlayModel.onAdClose(this.mBridgeIds, new RewardInfo(this.adapterModel.ab(), this.reward.a(), String.valueOf(this.reward.b())), 1);
            }
        }
    }

    public void onPause() {
        this.iView.pause();
        if (!this.isCloseBtnClicked && !this.adapterModel.ab()) {
            this.playTempleModel.eventTrackingForPause(this.redirectModel);
        }
    }

    public void onPlayCompleted() {
        this.adapterModel.m(true);
        this.playTempleModel.onVideoComplete(this.mBridgeIds);
        if (this.campaignEx.getAdSpaceT() == 1) {
            if (isIVRewardEnable()) {
                this.adapterModel.b(this.ivRewardAlertViewStatus);
            }
            doVideoEndTypeLogic();
            if (this.isCloseBtnClicked) {
                this.playTempleModel.eventTrackingForClose(this.redirectModel);
                return;
            }
            return;
        }
        closeOrShowHalfEndCard();
    }

    public void onPlayError(String str) {
        this.playTempleModel.eventTrackingForPlayError(this.redirectModel, str);
        if (this.adapterModel.x().b().C() == 1) {
            if (!this.progressHasDoAdSuccess) {
                this.progressHasDoAdSuccess = true;
                adShowSuccess();
            }
            if (this.campaignEx.getAdSpaceT() == 1) {
                closeAdOrShowEndCard();
            } else {
                closeOrShowHalfEndCard();
            }
        } else {
            adShowFail(com.mbridge.msdk.foundation.c.a.a(890004), 890004);
        }
    }

    public void onPlayProgress(int i5, int i6) {
        int i7;
        if (this.iView != null && this.campaignEx != null) {
            try {
                this.currentPlayProgress = i5;
                if (i6 == 0) {
                    i7 = 1;
                } else {
                    i7 = i6;
                }
                this.videoTotalLength = i7;
                adShowSuccess();
                advImpList(i5);
                setCountDownInfo(i5, i6);
                if (isIVRewardEnable()) {
                    showIVRewardDialogOnPlayMode();
                }
                updateSegmentsProgressBar(i5, i6);
                checkOMSdkProgress(i5, i6);
                checkPlayCloseBtnState(i5, i6);
                checkTrackingForPlayPercentage(this.currentPlayProgress, i6);
            } catch (Exception e5) {
                af.b("BaseTemplatePresenter", e5.getMessage());
            }
        }
    }

    public void onPlayProgressMS(int i5, int i6) {
    }

    public void onPlaySetDataSourceError(String str) {
    }

    public void onPlayStarted(int i5) {
        boolean z4;
        if (this.iView != null && this.campaignEx != null) {
            try {
                setSkipAndCompleteTime(i5);
                initCountDown();
                IPlayTempleView iPlayTempleView = this.iView;
                if (this.adapterModel.O() == 2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                iPlayTempleView.setMuteState(z4);
                setSegmentsProgressBarState();
            } catch (Exception e5) {
                af.b("BaseTemplatePresenter", e5.getMessage());
            }
        }
    }

    public void onResume() {
        this.iView.resume();
        this.playTempleModel.eventTrackingForResume(this.redirectModel);
    }

    public void showIVRewardDialogOnCloseMode() {
        if (!isIVRewardEnable()) {
            closeAdOrShowEndCard();
        } else if (this.ivRewardMode == a.f9165H) {
            int i5 = this.ivRewardValueType;
            if (i5 == a.f9167J && ((int) ((((float) this.currentPlayProgress) / ((float) this.videoTotalLength)) * 100.0f)) >= this.ivRewardValue) {
                closeAdOrShowEndCard();
            } else if (i5 != a.f9168K || this.currentPlayProgress < this.ivRewardValue) {
                this.iView.setAlertViewType(this.adapterModel.H(), 0, this.ivRewardMode);
                this.iView.alertShow();
            } else {
                closeAdOrShowEndCard();
            }
        }
    }
}
