package androidx.work;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.t;

public final class ConfigurationKt$createDefaultExecutor$factory$1 implements ThreadFactory {
    final /* synthetic */ boolean $isTaskExecutor;
    private final AtomicInteger threadCount = new AtomicInteger(0);

    ConfigurationKt$createDefaultExecutor$factory$1(boolean z4) {
        this.$isTaskExecutor = z4;
    }

    public Thread newThread(Runnable runnable) {
        String str;
        t.e(runnable, "runnable");
        if (this.$isTaskExecutor) {
            str = "WM.task-";
        } else {
            str = "androidx.work-";
        }
        return new Thread(runnable, str + this.threadCount.incrementAndGet());
    }
}
