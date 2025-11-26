package com.inmobi.cmp.core.cmpapi.status;

import androidx.annotation.Keep;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;

@Keep
public enum CmpStatus {
    STUB("stub"),
    LOADING(MRAIDCommunicatorUtil.STATES_LOADING),
    LOADED("loaded"),
    ERROR(CampaignEx.JSON_NATIVE_VIDEO_ERROR);
    
    private final String value;

    private CmpStatus(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
