package com.mbridge.msdk.newreward.player.model;

import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.imodel.IBigTempModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectType;
import com.mbridge.msdk.out.MBridgeIds;

public class BigTemplateModel extends BaseModel implements IBigTempModel {
    boolean adShownState = false;
    boolean eventImpression = false;
    RewardVideoListener rewardVideoListener;

    public BigTemplateModel(c cVar, RewardVideoListener rewardVideoListener2) {
        super(cVar);
        this.rewardVideoListener = rewardVideoListener2;
    }

    public void eventOnlyImpression(RedirectModel redirectModel) {
        if (!this.eventImpression) {
            this.eventImpression = true;
            sendDirectEvent(redirectModel.setRedirectType(RedirectType.ONLY_IMPRESSION_URL));
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

    public boolean onShowFail(MBridgeIds mBridgeIds, @BridgeParameter(key = "reason") String str, @BridgeParameter(key = "code") int i5) {
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
}
