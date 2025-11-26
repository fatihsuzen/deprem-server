package com.mbridge.msdk.scheme.applet;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;

public abstract class AppletSchemeCallBack implements IAppletSchemeCallBack {
    private static final String TAG = "AppletSchemeCallBack";

    public void onAppletSchemeRequestFailed(int i5, String str, String str2) {
        try {
            onRequestFailed(i5, str, str2);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, e5.getMessage());
            }
        }
    }

    public void onAppletSchemeRequestStart() {
        try {
            onRequestStart();
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, e5.getMessage());
            }
        }
    }

    public void onAppletSchemeRequestSuccess(String str) {
        try {
            onRequestSuccess(str);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, e5.getMessage());
            }
        }
    }

    public void onNetworkError(int i5, String str, String str2) {
        try {
            onRequestFailed(i5, str, str2);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, e5.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onRequestFailed(int i5, String str, String str2);

    /* access modifiers changed from: protected */
    public abstract void onRequestStart();

    /* access modifiers changed from: protected */
    public abstract void onRequestSuccess(String str);
}
