package com.mbridge.msdk.out;

import com.mbridge.msdk.e.a;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

public abstract class MBSplashLoadWithCodeListener implements MBSplashLoadListener {
    public void onLoadFailed(MBridgeIds mBridgeIds, String str, int i5) {
        onLoadFailedWithCode(mBridgeIds, a.a(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS, str), str, i5);
    }

    public abstract void onLoadFailedWithCode(MBridgeIds mBridgeIds, int i5, String str, int i6);
}
