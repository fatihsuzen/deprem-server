package com.mbridge.msdk.out;

public interface IDownloadListener {
    void onEnd(int i5, int i6, String str);

    void onProgressUpdate(int i5);

    void onStart();

    void onStatus(int i5);
}
