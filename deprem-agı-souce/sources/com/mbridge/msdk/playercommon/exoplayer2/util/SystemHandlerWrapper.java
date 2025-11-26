package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class SystemHandlerWrapper implements HandlerWrapper {
    private final Handler handler;

    public SystemHandlerWrapper(Handler handler2) {
        this.handler = handler2;
    }

    public final Looper getLooper() {
        return this.handler.getLooper();
    }

    public final Message obtainMessage(int i5) {
        return this.handler.obtainMessage(i5);
    }

    public final boolean post(Runnable runnable) {
        return this.handler.post(runnable);
    }

    public final boolean postDelayed(Runnable runnable, long j5) {
        return this.handler.postDelayed(runnable, j5);
    }

    public final void removeCallbacksAndMessages(Object obj) {
        this.handler.removeCallbacksAndMessages(obj);
    }

    public final void removeMessages(int i5) {
        this.handler.removeMessages(i5);
    }

    public final boolean sendEmptyMessage(int i5) {
        return this.handler.sendEmptyMessage(i5);
    }

    public final boolean sendEmptyMessageAtTime(int i5, long j5) {
        return this.handler.sendEmptyMessageAtTime(i5, j5);
    }

    public final Message obtainMessage(int i5, Object obj) {
        return this.handler.obtainMessage(i5, obj);
    }

    public final Message obtainMessage(int i5, int i6, int i7) {
        return this.handler.obtainMessage(i5, i6, i7);
    }

    public final Message obtainMessage(int i5, int i6, int i7, Object obj) {
        return this.handler.obtainMessage(i5, i6, i7, obj);
    }
}
