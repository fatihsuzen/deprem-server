package com.inmobi.cmp.core.model.portalconfig;

import androidx.annotation.Keep;

@Keep
public enum PrivacyEncodingMode {
    TCF("TCF"),
    GPP("GPP"),
    TCF_AND_GPP("TCF_AND_GPP");
    
    private final String value;

    private PrivacyEncodingMode(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
