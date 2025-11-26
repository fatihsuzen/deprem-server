package com.mbridge.msdk.playercommon;

public interface VideoPlayerStatusListener {
    void onBufferingEnd();

    void onBufferingStart(String str);

    void onPlayCompleted();

    void onPlayError(String str);

    void onPlayProgress(int i5, int i6);

    void onPlayProgressMS(int i5, int i6);

    void onPlaySetDataSourceError(String str);

    void onPlayStarted(int i5);
}
