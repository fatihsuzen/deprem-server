package com.mbridge.msdk.out;

import com.mbridge.msdk.e.a;

public abstract class BannerAdWithCodeListener implements BannerAdListener {
    public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
        onLoadFailedWithCode(mBridgeIds, a.a(2000, str), str);
    }

    public abstract void onLoadFailedWithCode(MBridgeIds mBridgeIds, int i5, String str);
}
