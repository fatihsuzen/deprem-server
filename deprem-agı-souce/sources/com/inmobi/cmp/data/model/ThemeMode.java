package com.inmobi.cmp.data.model;

import androidx.annotation.Keep;

@Keep
public enum ThemeMode {
    LIGHT("light"),
    DARK("dark"),
    AUTO("lightAndDark");
    
    private final String value;

    private ThemeMode(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
