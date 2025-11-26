package com.mbridge.msdk.newreward.player.redirect;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.a.f;
import com.mbridge.msdk.videocommon.b.c;

public class RedirectModel {
    private CampaignEx campaignEx;
    public int clickSenario = 0;
    public Context context;
    private int currPercentAge;
    public f devExtraData;
    private int endScreenType;
    private int percentRate;
    public RedirectType redirectType;
    public c reward;
    public com.mbridge.msdk.newreward.function.e.f settingModel;
    public String unitId;
    private int videoSourceCompleteTime;
    public float xInScreen;
    public float yInScreen;

    public CampaignEx getCampaignEx() {
        return this.campaignEx;
    }

    public int getClickSenario() {
        return this.clickSenario;
    }

    public Context getContext() {
        return this.context;
    }

    public int getCurrPercentAge() {
        return this.currPercentAge;
    }

    public f getDevExtraData() {
        return this.devExtraData;
    }

    public int getEndScreenType() {
        return this.endScreenType;
    }

    public int getPercentRate() {
        return this.percentRate;
    }

    public RedirectType getRedirectType() {
        return this.redirectType;
    }

    public c getReward() {
        return this.reward;
    }

    public com.mbridge.msdk.newreward.function.e.f getSettingModel() {
        return this.settingModel;
    }

    public String getUnitId() {
        return this.unitId;
    }

    public int getVideoSourceCompleteTime() {
        return this.videoSourceCompleteTime;
    }

    public int getxInScreen() {
        return ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.xInScreen);
    }

    public int getyInScreen() {
        return ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.yInScreen);
    }

    public void setCampaignEx(CampaignEx campaignEx2) {
        this.campaignEx = campaignEx2;
    }

    public void setClickSenario(int i5) {
        this.clickSenario = i5;
    }

    public void setContext(Context context2) {
        this.context = context2;
    }

    public void setCurrPercentAge(int i5) {
        this.currPercentAge = i5;
    }

    public void setDevExtraData(f fVar) {
        this.devExtraData = fVar;
    }

    public void setEndScreenType(int i5) {
        this.endScreenType = i5;
    }

    public void setPercentRate(int i5) {
        this.percentRate = i5;
    }

    public RedirectModel setRedirectType(RedirectType redirectType2) {
        this.redirectType = redirectType2;
        return this;
    }

    public void setReward(c cVar) {
        this.reward = cVar;
    }

    public void setSettingModel(com.mbridge.msdk.newreward.function.e.f fVar) {
        this.settingModel = fVar;
        if (fVar != null && fVar.b() != null) {
            setEndScreenType(fVar.b().q());
        }
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public void setVideoSourceCompleteTime(int i5) {
        this.videoSourceCompleteTime = i5;
    }

    public void setxInScreen(float f5) {
        this.xInScreen = f5;
    }

    public void setyInScreen(float f5) {
        this.yInScreen = f5;
    }
}
