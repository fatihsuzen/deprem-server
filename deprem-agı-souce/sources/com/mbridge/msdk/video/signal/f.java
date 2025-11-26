package com.mbridge.msdk.video.signal;

public interface f {
    void configurationChanged(int i5, int i6, int i7);

    boolean endCardShowing();

    void hideAlertWebview();

    void ivRewardAdsWithoutVideo(String str);

    boolean miniCardShowing();

    void readyStatus(int i5);

    void resizeMiniCard(int i5, int i6, int i7);

    boolean showAlertWebView();

    void showEndcard(int i5);

    void showMiniCard(int i5, int i6, int i7, int i8, int i9);

    void showVideoClickView(int i5);

    void showVideoEndCover();
}
