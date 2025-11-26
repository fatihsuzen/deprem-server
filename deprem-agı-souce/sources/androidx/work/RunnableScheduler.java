package androidx.work;

import androidx.annotation.IntRange;

public interface RunnableScheduler {
    void cancel(Runnable runnable);

    void scheduleWithDelay(@IntRange(from = 0) long j5, Runnable runnable);
}
