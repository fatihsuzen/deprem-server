package com.mbridge.msdk.foundation.download.core;

import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {
    /* access modifiers changed from: private */
    public final int threadPriority;

    PriorityThreadFactory(int i5) {
        this.threadPriority = i5;
    }

    public Thread newThread(final Runnable runnable) {
        Thread thread = new Thread(new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|2|3|5) */
            /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
                return;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0009 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r1 = this;
                    com.mbridge.msdk.foundation.download.core.PriorityThreadFactory r0 = com.mbridge.msdk.foundation.download.core.PriorityThreadFactory.this     // Catch:{ all -> 0x0009 }
                    int r0 = r0.threadPriority     // Catch:{ all -> 0x0009 }
                    android.os.Process.setThreadPriority(r0)     // Catch:{ all -> 0x0009 }
                L_0x0009:
                    java.lang.Runnable r0 = r2     // Catch:{ Exception -> 0x000e }
                    r0.run()     // Catch:{ Exception -> 0x000e }
                L_0x000e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.core.PriorityThreadFactory.AnonymousClass1.run():void");
            }
        });
        thread.setName("mb_download_thread");
        return thread;
    }
}
