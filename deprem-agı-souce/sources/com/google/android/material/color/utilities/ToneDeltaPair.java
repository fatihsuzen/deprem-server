package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ToneDeltaPair {
    private final double delta;
    private final TonePolarity polarity;
    private final DynamicColor roleA;
    private final DynamicColor roleB;
    private final boolean stayTogether;

    public ToneDeltaPair(@NonNull DynamicColor dynamicColor, @NonNull DynamicColor dynamicColor2, double d5, @NonNull TonePolarity tonePolarity, boolean z4) {
        this.roleA = dynamicColor;
        this.roleB = dynamicColor2;
        this.delta = d5;
        this.polarity = tonePolarity;
        this.stayTogether = z4;
    }

    public double getDelta() {
        return this.delta;
    }

    @NonNull
    public TonePolarity getPolarity() {
        return this.polarity;
    }

    @NonNull
    public DynamicColor getRoleA() {
        return this.roleA;
    }

    @NonNull
    public DynamicColor getRoleB() {
        return this.roleB;
    }

    public boolean getStayTogether() {
        return this.stayTogether;
    }
}
