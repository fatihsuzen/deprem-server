package com.mbridge.msdk.out;

import com.mbridge.msdk.e.a;
import com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener;

public abstract class InterstitialVideoWithCodeListener implements InterstitialVideoListener {
    public void onShowFail(MBridgeIds mBridgeIds, String str) {
        onShowFailWithCode(mBridgeIds, 3900, str);
    }

    public abstract void onShowFailWithCode(MBridgeIds mBridgeIds, int i5, String str);

    public void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        onVideoLoadFailWithCode(mBridgeIds, a.a(3000, str), str);
    }

    public abstract void onVideoLoadFailWithCode(MBridgeIds mBridgeIds, int i5, String str);
}
