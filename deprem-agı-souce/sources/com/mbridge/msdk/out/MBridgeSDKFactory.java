package com.mbridge.msdk.out;

import android.annotation.SuppressLint;
import com.mbridge.msdk.system.MBridgeSDKImpl;

public class MBridgeSDKFactory {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile MBridgeSDKImpl instance;

    private MBridgeSDKFactory() {
    }

    public static MBridgeSDKImpl getMBridgeSDK() {
        if (instance == null) {
            synchronized (MBridgeSDKFactory.class) {
                try {
                    if (instance == null) {
                        instance = new MBridgeSDKImpl();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }
}
