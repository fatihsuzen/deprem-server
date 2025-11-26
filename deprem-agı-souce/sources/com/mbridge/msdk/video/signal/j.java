package com.mbridge.msdk.video.signal;

public interface j {
    void alertWebViewShowed();

    void closeVideoOperate(int i5, int i6);

    void dismissAllAlert();

    int getBorderViewHeight();

    int getBorderViewLeft();

    int getBorderViewRadius();

    int getBorderViewTop();

    int getBorderViewWidth();

    String getCurrentProgress();

    void hideAlertView(int i5);

    boolean isH5Canvas();

    void notifyCloseBtn(int i5);

    void progressBarOperate(int i5);

    void progressOperate(int i5, int i6);

    void setCover(boolean z4);

    void setMiniEndCardState(boolean z4);

    void setScaleFitXY(int i5);

    void setVisible(int i5);

    void showAlertView();

    void showIVRewardAlertView(String str);

    void showVideoLocation(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13);

    void soundOperate(int i5, int i6);

    void soundOperate(int i5, int i6, String str);

    void videoOperate(int i5);
}
