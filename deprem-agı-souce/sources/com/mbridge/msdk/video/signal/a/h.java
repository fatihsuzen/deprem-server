package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.signal.j;

public class h implements j {
    public void alertWebViewShowed() {
        af.a("DefaultJSVideoModule", "alertWebViewShowed:");
    }

    public void closeVideoOperate(int i5, int i6) {
        af.a("DefaultJSVideoModule", "closeOperte:close=" + i5 + "closeViewVisible=" + i6);
    }

    public void dismissAllAlert() {
        af.a("DefaultJSVideoModule", "dismissAllAlert");
    }

    public int getBorderViewHeight() {
        return 0;
    }

    public int getBorderViewLeft() {
        return 0;
    }

    public int getBorderViewRadius() {
        return 0;
    }

    public int getBorderViewTop() {
        return 0;
    }

    public int getBorderViewWidth() {
        return 0;
    }

    public String getCurrentProgress() {
        af.a("DefaultJSVideoModule", "getCurrentProgress");
        return "{}";
    }

    public void hideAlertView(int i5) {
        af.a("DefaultJSVideoModule", "hideAlertView:");
    }

    public boolean isH5Canvas() {
        return false;
    }

    public void notifyCloseBtn(int i5) {
        af.a("DefaultJSVideoModule", "notifyCloseBtn:" + i5);
    }

    public void progressBarOperate(int i5) {
        af.a("DefaultJSVideoModule", "progressBarOperate:progressViewVisible=" + i5);
    }

    public void progressOperate(int i5, int i6) {
        af.a("DefaultJSVideoModule", "progressOperate:progress=" + i5 + "progressViewVisible=" + i6);
    }

    public void setCover(boolean z4) {
        af.a("DefaultJSVideoModule", "setCover:" + z4);
    }

    public void setMiniEndCardState(boolean z4) {
        af.a("DefaultJSVideoModule", "setMiniEndCardState");
    }

    public void setScaleFitXY(int i5) {
        af.a("DefaultJSVideoModule", "setScaleFitXY:" + i5);
    }

    public void setVisible(int i5) {
        af.a("DefaultJSVideoModule", "setVisible:" + i5);
    }

    public void showAlertView() {
        af.a("DefaultJSVideoModule", "showAlertView:");
    }

    public void showIVRewardAlertView(String str) {
        af.a("DefaultJSVideoModule", "showAlertView:");
    }

    public void showVideoLocation(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        af.a("DefaultJSVideoModule", "showVideoLocation:marginTop=" + i5 + ",marginLeft=" + i6 + ",width=" + i7 + ",height=" + i8 + ",radius=" + i9 + ",borderTop=" + i10 + ",borderTop=" + i10 + ",borderLeft=" + i11 + ",borderWidth=" + i12 + ",borderHeight=" + i13);
    }

    public void soundOperate(int i5, int i6) {
        af.a("DefaultJSVideoModule", "soundOperate:mute=" + i5 + ",soundViewVisible=" + i6);
    }

    public void videoOperate(int i5) {
        af.a("DefaultJSVideoModule", "videoOperate:" + i5);
    }

    public void soundOperate(int i5, int i6, String str) {
        af.a("DefaultJSVideoModule", "soundOperate:mute=" + i5 + ",soundViewVisible=" + i6 + ",pt=" + str);
    }
}
