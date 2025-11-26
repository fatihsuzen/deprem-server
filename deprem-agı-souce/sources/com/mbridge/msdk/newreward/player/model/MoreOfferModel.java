package com.mbridge.msdk.newreward.player.model;

import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.imodel.IMoreOfferModel;
import com.mbridge.msdk.newreward.player.redirect.MoreOfferRedirectModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectType;
import java.util.ArrayList;
import java.util.List;

public class MoreOfferModel extends BaseModel implements IMoreOfferModel {
    boolean eventOnlyImpression = false;
    public final List<Integer> mImpressionId = new ArrayList();

    public MoreOfferModel(c cVar) {
        super(cVar);
    }

    public void eventImpression(MoreOfferRedirectModel moreOfferRedirectModel) {
        int itemPositionId = moreOfferRedirectModel.getItemPositionId();
        if (!this.mImpressionId.contains(Integer.valueOf(itemPositionId))) {
            this.mImpressionId.add(Integer.valueOf(itemPositionId));
            sendDirectEvent(moreOfferRedirectModel.setRedirectType(RedirectType.IMPRESSION_URL));
        }
    }

    public void eventOnlyImpression(MoreOfferRedirectModel moreOfferRedirectModel) {
        if (!this.eventOnlyImpression) {
            this.eventOnlyImpression = true;
            sendDirectEvent(moreOfferRedirectModel.setRedirectType(RedirectType.ONLY_IMPRESSION_URL));
        }
    }

    public void onMoreOfferReq(@BridgeParameter(key = "retry") String str) {
    }

    public void onMoreOfferRes(@BridgeParameter(key = "result") String str, @BridgeParameter(key = "retry") String str2) {
    }

    public void onMoreOfferShow(@BridgeParameter(key = "scene") String str) {
    }

    public void onMoreOfferRes(@BridgeParameter(key = "code") String str, @BridgeParameter(key = "result") String str2, @BridgeParameter(key = "retry") String str3) {
    }
}
