package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DefaultRunnableScheduler implements RunnableScheduler {
    private final Handler mHandler = HandlerCompat.createAsync(Looper.getMainLooper());

    public void cancel(Runnable runnable) {
        this.mHandler.removeCallbacks(runnable);
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void scheduleWithDelay(long j5, Runnable runnable) {
        this.mHandler.postDelayed(runnable, j5);
    }
}
