package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
class FitModeResult {
    final float currentEndHeight;
    final float currentEndWidth;
    final float currentStartHeight;
    final float currentStartWidth;
    final float endScale;
    final float startScale;

    FitModeResult(float f5, float f6, float f7, float f8, float f9, float f10) {
        this.startScale = f5;
        this.endScale = f6;
        this.currentStartWidth = f7;
        this.currentStartHeight = f8;
        this.currentEndWidth = f9;
        this.currentEndHeight = f10;
    }
}
