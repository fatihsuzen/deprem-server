package com.google.android.material.transition;

class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int i5, int i6, boolean z4) {
        this.startAlpha = i5;
        this.endAlpha = i6;
        this.endOnTop = z4;
    }

    static FadeModeResult endOnTop(int i5, int i6) {
        return new FadeModeResult(i5, i6, true);
    }

    static FadeModeResult startOnTop(int i5, int i6) {
        return new FadeModeResult(i5, i6, false);
    }
}
