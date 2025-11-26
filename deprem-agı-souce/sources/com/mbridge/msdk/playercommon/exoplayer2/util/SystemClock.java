package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

final class SystemClock implements Clock {
    SystemClock() {
    }

    public final HandlerWrapper createHandler(Looper looper, @Nullable Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }

    public final long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    public final void sleep(long j5) {
        android.os.SystemClock.sleep(j5);
    }

    public final long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }
}
