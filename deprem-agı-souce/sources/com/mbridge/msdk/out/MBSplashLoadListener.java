package com.mbridge.msdk.out;

public interface MBSplashLoadListener {
    void isSupportZoomOut(MBridgeIds mBridgeIds, boolean z4);

    void onLoadFailed(MBridgeIds mBridgeIds, String str, int i5);

    void onLoadSuccessed(MBridgeIds mBridgeIds, int i5);
}
