package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.h;

public class e implements f, h {
    public void configurationChanged(int i5, int i6, int i7) {
    }

    public boolean endCardShowing() {
        af.a("DefaultJSContainerModule", "endCardShowing");
        return true;
    }

    public void hideAlertWebview() {
        af.a("DefaultJSContainerModule", "hideAlertWebview ,msg=");
    }

    public void ivRewardAdsWithoutVideo(String str) {
        af.a("DefaultJSContainerModule", "ivRewardAdsWithoutVideo,params=");
    }

    public boolean miniCardShowing() {
        af.a("DefaultJSContainerModule", "miniCardShowing");
        return false;
    }

    public void notifyCloseBtn(int i5) {
        af.a("DefaultJSContainerModule", "notifyCloseBtn:state = " + i5);
    }

    public void readyStatus(int i5) {
        af.a("DefaultJSContainerModule", "readyStatus:isReady=" + i5);
    }

    public void resizeMiniCard(int i5, int i6, int i7) {
        af.a("DefaultJSContainerModule", "showMiniCard width = " + i5 + " height = " + i6 + " radius = " + i7);
    }

    public boolean showAlertWebView() {
        af.a("DefaultJSContainerModule", "showAlertWebView ,msg=");
        return false;
    }

    public void showEndcard(int i5) {
        af.a("DefaultJSContainerModule", "showEndcard,type=" + i5);
    }

    public void showMiniCard(int i5, int i6, int i7, int i8, int i9) {
        af.a("DefaultJSContainerModule", "showMiniCard top = " + i5 + " left = " + i6 + " width = " + i7 + " height = " + i8 + " radius = " + i9);
    }

    public void showVideoClickView(int i5) {
        af.a("DefaultJSContainerModule", "showVideoClickView:" + i5);
    }

    public void showVideoEndCover() {
        af.a("DefaultJSContainerModule", "showVideoEndCover");
    }

    public void toggleCloseBtn(int i5) {
        af.a("DefaultJSContainerModule", "toggleCloseBtn:state=" + i5);
    }
}
