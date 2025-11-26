package com.mbridge.msdk.out;

import com.mbridge.msdk.e.a;

public abstract class NativeAdvancedAdWithCodeListener implements NativeAdvancedAdListener {
    public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
        onLoadFailedWithCode(mBridgeIds, a.a(6000, str), str);
    }

    public abstract void onLoadFailedWithCode(MBridgeIds mBridgeIds, int i5, String str);
}
