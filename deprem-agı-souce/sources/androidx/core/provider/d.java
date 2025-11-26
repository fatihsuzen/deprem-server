package androidx.core.provider;

import android.os.Build;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public abstract /* synthetic */ class d {
    public static /* synthetic */ void a(ExecutorService executorService) {
        boolean isTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || executorService != ForkJoinPool.commonPool()) && !(isTerminated = executorService.isTerminated())) {
            executorService.shutdown();
            boolean z4 = false;
            while (!isTerminated) {
                try {
                    isTerminated = executorService.awaitTermination(1, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z4) {
                        executorService.shutdownNow();
                        z4 = true;
                    }
                }
            }
            if (z4) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
