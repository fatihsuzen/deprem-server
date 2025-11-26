package com.inmobi.cmp.core.model.portalconfig;

import androidx.annotation.Keep;

@Keep
public enum GBCConsentValue {
    GRANTED("GRANTED"),
    DENIED("DENIED");
    
    private final String value;

    private GBCConsentValue(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
