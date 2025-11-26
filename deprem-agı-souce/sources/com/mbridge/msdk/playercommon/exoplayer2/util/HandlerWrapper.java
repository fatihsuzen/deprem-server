package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.os.Looper;
import android.os.Message;

public interface HandlerWrapper {
    Looper getLooper();

    Message obtainMessage(int i5);

    Message obtainMessage(int i5, int i6, int i7);

    Message obtainMessage(int i5, int i6, int i7, Object obj);

    Message obtainMessage(int i5, Object obj);

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j5);

    void removeCallbacksAndMessages(Object obj);

    void removeMessages(int i5);

    boolean sendEmptyMessage(int i5);

    boolean sendEmptyMessageAtTime(int i5, long j5);
}
