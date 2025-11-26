package com.inmobi.cmp.model;

import androidx.annotation.Keep;

@Keep
public enum Regulations {
    CCPA("USP"),
    GDPR("GDPR"),
    MSPA("MSPA"),
    NA("NA");
    
    private final String value;

    private Regulations(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
