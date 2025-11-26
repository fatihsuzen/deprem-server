package com.mbridge.msdk.out;

import com.mbridge.msdk.e.a;
import com.mbridge.msdk.out.NativeListener;

public abstract class NativeAdWithCodeListener implements NativeListener.NativeAdListener {
    public void onAdLoadError(String str) {
        onAdLoadErrorWithCode(a.a(1000, str), str);
    }

    public abstract void onAdLoadErrorWithCode(int i5, String str);
}
