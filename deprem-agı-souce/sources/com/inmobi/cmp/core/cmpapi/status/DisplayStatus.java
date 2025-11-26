package com.inmobi.cmp.core.cmpapi.status;

import androidx.annotation.Keep;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;

@Keep
public enum DisplayStatus {
    VISIBLE("visible"),
    HIDDEN(MRAIDCommunicatorUtil.STATES_HIDDEN),
    DISABLED("disabled"),
    DISMISSED("dismissed");
    
    private final String value;

    private DisplayStatus(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
