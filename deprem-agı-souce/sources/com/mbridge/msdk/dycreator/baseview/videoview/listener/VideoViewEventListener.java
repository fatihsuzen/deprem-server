package com.mbridge.msdk.dycreator.baseview.videoview.listener;

public interface VideoViewEventListener {
    void onBufferingEnd();

    void onBufferingFail(String str);

    void onBufferingStart();

    void onPlayCompleted();

    void onPlayProgress(int i5, int i6);

    void onPlayStart(String str);

    void onPlayerError(int i5, String str);
}
